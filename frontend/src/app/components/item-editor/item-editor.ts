import { ChangeDetectorRef, Component, EventEmitter, Input, Output } from '@angular/core';
import { ItemInstanceDTO } from '../../models/instanceDTOs/ItemInstanceDTO';
import { ItemDefinitionDTO } from '../../models/gamedataDTOs/ItemDefinitionDTO';
import { ItemSlot } from '../../enums/ItemSlot';
import { GemInstanceDTO } from '../../models/instanceDTOs/GemInstanceDTO';
import { BuildSimButton } from '../build-sim-button/build-sim-button';
import { GemDefinitionDTO } from '../../models/gamedataDTOs/GemDefinitionDTO';
import { ItemSlotDisplayName } from '../../const/ItemSlotDisplayName';
import { FormsModule } from '@angular/forms';
import { KeyValuePipe } from '@angular/common';
import { EnchantmentDTO } from '../../models/gamedataDTOs/EnchantmentDTO';
import { LevelMultiplierTableDTO } from '../../models/gamedataDTOs/LevelMultiplierTableDTO';
import { StatType } from '../../enums/StatType';
import { formatStatName, formatStatValueRelative } from '../../utils/display-utils';
import { SetDTO } from '../../models/gamedataDTOs/SetDTO';
import { GemService } from '../../utils/gem-service';
import { GemSelector } from '../gem-selector/gem-selector';
import { ItemService } from '../../utils/item-service';

@Component({
  selector: 'app-item-editor',
  imports: [BuildSimButton, FormsModule, KeyValuePipe, GemSelector],
  templateUrl: './item-editor.html',
  styleUrl: './item-editor.scss',
})
export class ItemEditor {
  constructor(
    public itemService: ItemService,
    public gemService: GemService,
    private cdr: ChangeDetectorRef,
  ) {}

  @Input() scale = 1;

  @Input() item!: ItemInstanceDTO | undefined;

  @Input() slot!: ItemSlot;

  @Input() equippedSets!: Record<string, Set<string>>;

  @Input() equippedItems!: string[];

  @Input() itemConfig!: Record<string, ItemDefinitionDTO>;

  @Input() fullItemConfig!: Record<string, ItemDefinitionDTO>;

  @Input() setConfig!: Record<string, SetDTO>;

  @Input() levelMultiplierTable!: LevelMultiplierTableDTO;

  @Input() gemConfig!: Record<string, GemDefinitionDTO>;

  @Input() enchantmentConfig!: Partial<Record<StatType, EnchantmentDTO>>;

  @Input() canAddGem!: (gemType: string, gems: (GemInstanceDTO | null)[], excludedSlot: number) => boolean;

  @Output() cancelled = new EventEmitter<void>();

  @Output() confirmed = new EventEmitter<ItemInstanceDTO>();

  ItemSlotDisplayName = ItemSlotDisplayName;
  formatStatName = formatStatName;
  formatStatValueRelative = formatStatValueRelative;
  Object = Object;

  editedBaseValues: { type: StatType; value: number }[] = [];
  gems: (GemInstanceDTO | null)[] = Array(10).fill(null);
  enchantments: (EnchantmentDTO | null)[] = Array(4).fill(null);
  uniqueBaseValues: Partial<Record<StatType, number>> = {};
  uniqueEnchantments: EnchantmentDTO[] = [];
  showGemSelector = false;
  selectedSlot = -1;

  ngOnInit() {
    this.itemService.setConfigs(this.fullItemConfig, this.setConfig);
    this.gemService.setGemConfig(this.gemConfig);

    const existingGems = this.item?.gems ?? [];
    this.gems = Array.from({ length: 10 }, (_, index) => existingGems[index] ?? null);

    const existingEnchantments = this.item?.enchantments ?? [];

    this.enchantments = Array.from({ length: 4 }, (_, index) => {
      const enchantment = existingEnchantments[index];

      return enchantment
        ? {
            ...enchantment,
            value: Math.trunc(enchantment.value * 100 * 1000) / 1000,
          }
        : null;
    });

    if (this.item) {
      this.editedBaseValues = Object.entries(this.item.baseValues).map(([type, value]) => ({
        type: type as StatType,
        value,
      }));
    }

    this.uniqueBaseValues = {
      ...(this.item?.uniqueBaseValues ?? {}),
    };

    this.uniqueEnchantments = (this.item?.uniqueEnchantments ?? []).map((enchantment) => ({
      ...enchantment,
      value: enchantment.value * 100,
    }));
  }

  onItemChange(itemType: string | null) {
    if (itemType === null) {
      this.item = undefined;
      return;
    }
    const item = this.itemConfig[itemType];
    if (item === null) {
      this.item = undefined;
      return;
    }
    this.item = {
      itemCategory: item.itemCategory,
      itemType: item.itemType,
      level: item.defaultLevel,
      baseValues: {},
      gems: [],
      enchantments: [],
      uniqueBaseValues: item.uniqueBaseValues,
      uniqueEnchantments: item.uniqueEnchantments,
    };

    this.editedBaseValues = (Object.keys(item.rawBaseValues) as StatType[]).map((type) => ({
      type,
      value: Number(
        (
          item.rawBaseValues[type] *
          (this.levelMultiplierTable.multipliersPerLevel[item.defaultLevel][type] ?? 1)
        ).toFixed(3),
      ),
    }));

    this.gems = Array(10).fill(null);
    this.enchantments = Array(4).fill(null);

    const definition = this.getItemDefinition(item.itemType);

    this.uniqueBaseValues = {
      ...(definition.uniqueBaseValues ?? {}),
    };

    this.uniqueEnchantments = (definition.uniqueEnchantments ?? []).map((enchantment) => ({
      ...enchantment,
      value: Math.trunc(enchantment.value * 100 * 1000) / 1000,
    }));
  }

  onBaseValueChange(index: number, value: number): void {
    const baseValue = this.editedBaseValues[index];

    if (baseValue !== null) {
      baseValue.value = value;
    }
  }

  clampBaseValue(index: number, statType: StatType): void {
    const baseValue = this.editedBaseValues[index];

    if (baseValue === null) {
      return;
    }

    const maxValue = this.item
      ? Math.trunc(
          this.itemConfig[this.item.itemType].rawBaseValues[statType] *
            (this.levelMultiplierTable.multipliersPerLevel[
              this.itemConfig[this.item?.itemType].defaultLevel
            ][statType] ?? 1) *
            1000,
        ) / 1000
      : 0;

    baseValue.value = Math.min(baseValue.value, maxValue);
  }

  onEnchantmentChange(index: number, statType: StatType | null) {
    if (statType === null) {
      this.enchantments[index] = null;
      return;
    }

    const config = this.enchantmentConfig[statType];

    this.enchantments[index] = config
      ? { ...config, value: Math.trunc(config.value * 100 * 1000) / 1000 }
      : null;
  }

  onEnchantmentValueChange(index: number, value: number): void {
    const enchantment = this.enchantments[index];

    if (enchantment !== null) {
      enchantment.value = value;
    }
  }

  clampEnchantmentValue(index: number): void {
    const enchantment = this.enchantments[index];

    if (enchantment === null) {
      return;
    }

    enchantment.value = Math.min(enchantment.value, this.getEnchantmentMaxValue(index));
  }

  getEnchantmentMaxValue(index: number): number {
    const enchantment = this.enchantments[index];

    if (enchantment === null) {
      return 0;
    }

    const maxValue = this.enchantmentConfig[enchantment.statType]?.value;

    if (maxValue === undefined) {
      return 0;
    }

    return Math.trunc(maxValue * 100 * 1000) / 1000;
  }

  onUniqueBaseValueChange(key: string, value: number) {
    const type = key as StatType;
    this.uniqueBaseValues[type] = value;
  }

  clampUniqueBaseValue(key: string): void {
    const type = key as StatType;
    const maxValue = this.item
      ? Math.trunc(this.itemConfig[this.item.itemType].uniqueBaseValues[type] * 1000) / 1000
      : 0;
    const currentValue = this.uniqueBaseValues[type] ?? 0;

    this.uniqueBaseValues[type] = Math.min(currentValue, maxValue);
  }

  onUniqueEnchantmentChange(index: number, value: number) {
    if (this.uniqueEnchantments[index]) {
      this.uniqueEnchantments[index].value = value;
    }
  }

  clampUniqueEnchantmentValue(index: number): void {
    const enchantment = this.uniqueEnchantments[index];

    if (enchantment === null) {
      return;
    }
    if (this.item?.itemType === undefined) return;
    enchantment.value = Math.min(
      enchantment.value,
      Math.trunc(
        this.itemConfig[this.item?.itemType].uniqueEnchantments[index].value * 100 * 1000,
      ) / 1000,
    );
  }

  deleteGem(index: number) {
    this.gems[index] = null;
  }

  copyGem(index: number) {
    if (this.gems[index] === null) return;
    if (!this.hasEmptyGemSlot()) return;
    const gemType = this.gems[index].gemCategory === 'OPAL' ? 'OPAL' : this.gems[index].gemType[0];
    if (!this.canAddGem(gemType, this.gems, -1)) return;
    for (let i = 0; i < 10; i++) {
      if (this.gems[i] === null) {
        this.gems[i] = this.gems[index];
        return;
      }
    }
  }

  hasEmptyGemSlot(): boolean {
    return this.gems.some((stone) => stone === null);
  }

  canSelectGem(gemType: string) {
    return this.canAddGem(gemType, this.gems, this.selectedSlot);
  }

  getItemDefinition(itemType: string) {
    return this.itemConfig[itemType];
  }

  hasUniqueAbsoluteValues(): boolean {
    if (this.item === undefined) return false;
    return Object.keys(this.itemConfig[this.item.itemType].uniqueAbsoluteValues ?? {}).length > 0;
  }

  openGemSelector(index: number) {
    this.selectedSlot = index;
    this.showGemSelector = true;
  }

  closeGemSelector() {
    this.selectedSlot = -1;
    this.showGemSelector = false;
  }

  confirmGemSelection(gem: GemInstanceDTO) {
    this.gems[this.selectedSlot] = gem;
    this.closeGemSelector();
  }

  cancel() {
    this.cancelled.emit();
  }

  confirm() {
    if (this.item !== undefined) {
      this.item.gems = this.gems ?? [];
      this.item.enchantments = this.enchantments
        .filter((enchantment) => enchantment !== null)
        .map((enchantment) => ({
          ...enchantment,
          value: enchantment.value / 100,
        }));

      this.item.baseValues = Object.fromEntries(
        this.editedBaseValues.map((stat) => [stat.type, stat.value]),
      ) as Partial<Record<StatType, number>>;

      if (Object.keys(this.uniqueBaseValues).length > 0) {
        this.item.uniqueBaseValues = this.uniqueBaseValues;
      }

      if (this.uniqueEnchantments.length > 0) {
        this.item.uniqueEnchantments = this.uniqueEnchantments.map((enchantment) => ({
          ...enchantment,
          value: enchantment.value / 100,
        }));
      }
    }
    this.confirmed.emit(this.item);
  }
}
