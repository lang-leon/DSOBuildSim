import { Component, EventEmitter, Input, Output } from '@angular/core';
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

@Component({
  selector: 'app-item-editor',
  imports: [BuildSimButton, FormsModule, KeyValuePipe, GemSelector],
  templateUrl: './item-editor.html',
  styleUrl: './item-editor.scss',
})
export class ItemEditor {
  constructor(public gemService: GemService){}

  @Input() scale = 1;

  @Input() item!: ItemInstanceDTO | undefined;

  @Input() slot!: ItemSlot;

  @Input() itemConfig!: Record<string, ItemDefinitionDTO>;

  @Input() setConfig!: Record<string, SetDTO>;

  @Input() levelMultiplierTable!: LevelMultiplierTableDTO;

  @Input() gemConfig!: Record<string, GemDefinitionDTO>;

  @Input() enchantmentConfig!: EnchantmentDTO[];

  @Input() canAddGem!: (gemType: string, gems: (GemInstanceDTO | null)[]) => boolean;

  @Output() cancelled = new EventEmitter<void>();

  @Output() confirmed = new EventEmitter<ItemInstanceDTO>();

  ItemSlotDisplayName = ItemSlotDisplayName;
  formatStatName = formatStatName;
  formatStatValueRelative = formatStatValueRelative;
  Object = Object;

  editedBaseValues: { type: StatType; value: number }[] = [];
  gems: (GemInstanceDTO | null)[] = Array(10).fill(null);
  enchantments: (EnchantmentDTO | null)[] = Array(4).fill(null);
  uniqueBaseValues: Record<string, number> = {};
  uniqueEnchantments: EnchantmentDTO[] = [];
  showGemSelector = false;
  selectedSlot = -1;

  ngOnInit() {
    this.gemService.setGemConfig(this.gemConfig);

    const existingGems = this.item?.gems ?? [];
    this.gems = Array.from({ length: 10 }, (_, index) => existingGems[index] ?? null);

    const existingEnchantments = this.item?.enchantments ?? [];
    this.enchantments = Array.from(
      { length: 4 },
      (_, index) => existingEnchantments[index] ?? null,
    );

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
    }));
  }

  onEnchantmentChange(index: number, statType: StatType | null) {
    if (statType === null) {
      this.enchantments[index] = null;
      return;
    }

    const config = this.enchantmentConfig.find((enchantment) => enchantment.statType === statType);

    this.enchantments[index] = config ? { ...config } : null;
  }

  onEnchantmentValueChange(index: number, value: number) {
    const enchantment = this.enchantments[index];

    if (enchantment) {
      enchantment.value = value;
    }
  }

  onUniqueBaseValueChange(key: string, value: number) {
    this.uniqueBaseValues[key] = value;
  }

  onUniqueEnchantmentChange(index: number, value: number) {
    if (this.uniqueEnchantments[index]) {
      this.uniqueEnchantments[index].value = value;
    }
  }

  deleteGem(index: number) {
    this.gems[index] = null;
  }

  copyGem(index: number) {
    if (this.gems[index] === null) return;
    if (!this.hasEmptyGemSlot()) return;
    const gemType = this.gems[index].gemCategory === "OPAL" ? "OPAL" : this.gems[index].gemType[0];
    if (!this.canAddGem(gemType, this.gems)) return;
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
    return this.canAddGem(gemType, this.gems);
  }

  getGemName(index: number) {
    const gem = this.gems[index];
    if (gem === null) return 'Empty';
    let tierName = '';
    switch (gem.tier) {
      case 1:
        tierName = 'Flawed ';
        break;
      case 2:
        tierName = 'Splintered ';
        break;
      case 3:
        tierName = 'Simple ';
        break;
      case 4:
        tierName = '';
        break;
      case 5:
        tierName = 'Polished ';
        break;
      case 6:
        tierName = 'Radiant ';
        break;
      case 7:
        tierName = 'Flawless ';
        break;
      case 8:
        tierName = 'Sacred ';
        break;
      case 9:
        tierName = 'Royal ';
        break;
      case 10:
        tierName = 'Trapezoid ';
        break;
      case 11:
        tierName = 'Refined Trapezoid ';
        break;
      case 12:
        tierName = 'Brilliant Trapezoid ';
        break;
      case 13:
        tierName = 'Exquisite Trapezoid ';
        break;
      case 14:
        tierName = 'Imperial ';
        break;
      case 15:
        tierName = 'Refined Imperial ';
        break;
      case 16:
        tierName = 'Brilliant Imperial ';
        break;
      case 17:
        tierName = 'Exquisite Imperial ';
        break;
    }
    if (gem.gemCategory === 'OPAL') return tierName + 'Opal';
    return tierName + this.gemConfig[gem.gemType[0]].name;
  }

  getItemDefinition(itemtType: string) {
    return this.itemConfig[itemtType];
  }

hasUniqueAbsoluteValues(): boolean {
  if(this.item === undefined) return false;
  return Object.keys(
    this.itemConfig[this.item.itemType].uniqueAbsoluteValues ?? {}
  ).length > 0;
}

getSetBonusStrings(setType: string): string[] {
  const set = this.setConfig[setType];
  const tiers = new Set([
    ...Object.keys(set.baseValuesPerTier),
    ...Object.keys(set.relativeValuesPerTier),
    ...Object.keys(set.descriptionPerTier)
  ]);

  return [...tiers]
    .sort((a, b) => Number(a) - Number(b))
    .map(tier => {
      const parts: string[] = [];

      const baseValues = set.baseValuesPerTier[tier];
      if (baseValues) {
        for (const [statType, value] of Object.entries(baseValues)) {
          parts.push(`+ ${value} ${this.formatStatName(statType)}`);
        }
      }

      const relativeValues = set.relativeValuesPerTier[tier];
      if (relativeValues) {
        for (const [statType, value] of Object.entries(relativeValues)) {
          parts.push(`+ ${value}% ${this.formatStatName(statType)}`);
        }
      }

      const description = set.descriptionPerTier[tier];
      if (description) {
        parts.push(description);
      }

      return `(${tier}): ${parts.join('\n')}`;
    });
}



  cancel() {
    this.cancelled.emit();
  }

  confirm() {
    if (this.item !== undefined) {
      this.item.gems = this.gems.filter((gem) => gem !== null) ?? [];
      this.item.enchantments =
        this.enchantments.filter((enchantment) => enchantment !== null) ?? [];

      this.item.baseValues = Object.fromEntries(
        this.editedBaseValues.map((stat) => [stat.type, stat.value]),
      ) as Partial<Record<StatType, number>>;

      if (Object.keys(this.uniqueBaseValues).length > 0)
        {
          this.item.uniqueBaseValues = this.uniqueBaseValues;
        } 

      if (this.uniqueEnchantments.length > 0)
        {
          this.item.uniqueEnchantments = this.uniqueEnchantments;
        } 
    }
    this.confirmed.emit(this.item);
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
}
