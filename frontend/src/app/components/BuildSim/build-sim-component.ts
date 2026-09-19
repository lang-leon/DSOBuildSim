import {
  ChangeDetectorRef,
  Component,
  ElementRef,
  HostListener,
  OnInit,
  ViewChild,
} from '@angular/core';
import { StatCalculationService } from '../../services/stat-calculation-service';
import { GameDataDTO } from '../../models/gamedataDTOs/GameDataDTO';
import { GameDataService } from '../../services/game-data-service';
import { StatType } from '../../enums/StatType';
import { ClassStatsDTO } from '../../models/gamedataDTOs/ClassStatsDTO';
import { CommonModule } from '@angular/common';
import { CharacterDTO } from '../../models/instanceDTOs/CharacterDTO';
import { CharacterClass } from '../../enums/CharacterClass';
import { MasteryType } from '../../enums/MasteryType';
import { WisdomSkillType } from '../../enums/WisdomSkillType';
import { BuildSimButton } from '../build-sim-button/build-sim-button';
import { ItemSlot } from '../../enums/ItemSlot';
import { FormsModule, NgModel } from '@angular/forms';
import { PetSelector } from '../pet-selector/pet-selector';
import { PetInstanceDTO } from '../../models/instanceDTOs/PetInstanceDTO';
import { EssenceSelector } from '../essence-selector/essence-selector';
import { EssenceInstanceDTO } from '../../models/instanceDTOs/EssenceInstanceDTO';
import { formatStatName, formatStatValueRelative, getIcon } from '../../utils/display-utils';
import { BuffInstanceDTO } from '../../models/instanceDTOs/BuffInstanceDTO';
import { BuffCategory } from '../../enums/BuffCategory';
import { BuffSelector } from '../buff-selector/buff-selector';
import { ClassSkillType } from '../../enums/ClassSkillType';
import { MasterySelector } from '../mastery-selector/mastery-selector';
import { ClassChangeWindow } from '../class-change-window/class-change-window';
import { ConfirmationWindow } from '../confirmation-window/confirmation-window';
import { CollectorBagSelector } from '../collector-bag-selector/collector-bag-selector';
import { CollectorBagCategoryBonusInstanceDTO } from '../../models/instanceDTOs/CollectorBagCategoryBonusInstanceDTO';
import { DragoncrestTrinketEditor } from '../dragoncrest-trinket-editor/dragoncrest-trinket-editor';
import { DragonCrestTrinketDTO } from '../../models/instanceDTOs/DragonCrestTrinketDTO';
import { JewelTrinketEditor } from '../jewel-trinket-editor/jewel-trinket-editor';
import { JewelTrinketDTO } from '../../models/instanceDTOs/JewelTrinketDTO';
import { JewelInstanceDTO } from '../../models/instanceDTOs/JewelInstanceDTO';
import { RuneInstanceDTO } from '../../models/instanceDTOs/RuneInstanceDTO';
import { RuneTrinketDTO } from '../../models/instanceDTOs/RuneTrinketDTO';
import { RuneTrinketEditor } from '../rune-trinket-editor/rune-trinket-editor';
import { WisdomSkilltreeEditor } from '../wisdom-skilltree-editor/wisdom-skilltree-editor';
import { WisdomSkillInstanceDTO } from '../../models/instanceDTOs/WisdomSkillInstanceDTO';
import { ItemSlotType } from '../../enums/ItemSlotType';
import { GemInstanceDTO } from '../../models/instanceDTOs/GemInstanceDTO';
import { ItemDefinitionDTO } from '../../models/gamedataDTOs/ItemDefinitionDTO';
import { ItemEditor } from '../item-editor/item-editor';
import { ItemInstanceDTO } from '../../models/instanceDTOs/ItemInstanceDTO';
import { getMasteryDescription, getTierName } from '../../utils/tooltip-utils';
import { PetService } from '../../utils/pet-service';
import { EssenceService } from '../../utils/essence-service';
import { BuffService } from '../../utils/buff-service';

@Component({
  selector: 'app-character',
  standalone: true,
  imports: [
    CommonModule,
    BuildSimButton,
    FormsModule,
    PetSelector,
    EssenceSelector,
    BuffSelector,
    MasterySelector,
    ClassChangeWindow,
    ConfirmationWindow,
    CollectorBagSelector,
    DragoncrestTrinketEditor,
    JewelTrinketEditor,
    RuneTrinketEditor,
    WisdomSkilltreeEditor,
    ItemEditor,
  ],
  templateUrl: './build-sim-component.html',
  styleUrl: './build-sim-component.scss',
})
export class BuildSimComponent implements OnInit {
  @ViewChild('fileInput')
  fileInput!: ElementRef<HTMLInputElement>;

  StatType = StatType;
  gameData!: GameDataDTO;
  stats?: ClassStatsDTO;
  @ViewChild(NgModel) classSelect!: NgModel;
  character!: CharacterDTO; // = this.createDefaultCharacter(CharacterClass.SPELLWEAVER);
  jewelLimitGroups!: Record<string, string>;
  runeLimitGroups!: Record<string, string>;
  gemLimitGroups!: Record<string, string>;
  item!: Record<CharacterClass, Record<ItemSlotType, Record<string, ItemDefinitionDTO>>>;

  scale = 1;
  private readonly designWidth = 1920;
  private readonly designHeight = 1080;

  CharacterClass = CharacterClass;
  showResetConfirmation = false;
  showClassChangeScreen = false;
  selectedClass: CharacterClass = CharacterClass.SPELLWEAVER;
  slowClassChangeConfirmation = false;
  showPetSelector = false;
  showEssenceSelector = false;
  showPhysicSelector = false;
  showTonicSelector = false;
  showMasterySelector = false;
  showClassSkillSelector = false;
  showCollectorBagSelector = false;
  showDragonCrest = false;
  showJewelTrinket = false;
  selectedJewelTrinket = -1;
  showRuneTrinket = false;
  selectedRuneTrinket = -1;
  showWisdomSkillTreeEditor = false;
  showItemEditor = false;
  selectedItemSlot = ItemSlot.NONE;
  itemsByClassAndSlot: Record<
    CharacterClass,
    Record<ItemSlotType, Record<string, ItemDefinitionDTO>>
  > = {} as Record<CharacterClass, Record<ItemSlotType, Record<string, ItemDefinitionDTO>>>;
  showShadowSoulEquipment = false;

  formatStatName = formatStatName;
  formatStatValueRelative = formatStatValueRelative;
  getMasteryDescription = getMasteryDescription;
  getTierName = getTierName;
  MasteryType = MasteryType;
  BuffCategory = BuffCategory;
  ClassSkillType = ClassSkillType;
  ItemSlot = ItemSlot;

  constructor(
    private statCalculationService: StatCalculationService,
    private gameDataService: GameDataService,
    private changeDetector: ChangeDetectorRef,
    public petService: PetService,
    public essenceService: EssenceService,
    public buffService: BuffService,
  ) {}

  ngOnInit(): void {
    this.updateScale();
    this.gameDataService.getGameData().subscribe((data) => {
      this.gameData = data;
      this.jewelLimitGroups = Object.values(this.gameData.jewels)
        .flatMap((classJewels) => Object.values(classJewels))
        .reduce(
          (map, jewel) => {
            map[jewel.jewelType] = jewel.jewelLimitGroup;
            return map;
          },
          {} as Record<string, string>,
        );
      this.runeLimitGroups = Object.values(this.gameData.runes).reduce(
        (map, rune) => {
          map[rune.runeType] = rune.runeLimitGroup;
          return map;
        },
        {} as Record<string, string>,
      );
      this.gemLimitGroups = Object.values(this.gameData.gems).reduce(
        (map, gem) => {
          map[gem.gemType] = gem.gemLimitGroup;
          return map;
        },
        {} as Record<string, string>,
      );

      for (const [characterClass, items] of Object.entries(this.gameData.items) as [
        CharacterClass,
        Record<string, ItemDefinitionDTO>,
      ][]) {
        const itemsBySlot: Record<ItemSlotType, Record<string, ItemDefinitionDTO>> = {} as Record<
          ItemSlotType,
          Record<string, ItemDefinitionDTO>
        >;

        for (const [itemType, itemDefinition] of Object.entries(items)) {
          const slot = itemDefinition.itemSlotType;

          if (!itemsBySlot[slot]) {
            itemsBySlot[slot] = {};
          }

          itemsBySlot[slot][itemType] = itemDefinition;
        }

        this.itemsByClassAndSlot[characterClass] = itemsBySlot;
      }

      this.petService.setPetConfig(this.gameData.pets);
      this.essenceService.setEssenceConfig(this.gameData.essences);
      this.buffService.setTonicConfig(this.gameData.tonics);
      this.buffService.setPhysicConfig(this.gameData.physics);

      this.character = this.createDefaultCharacter(CharacterClass.SPELLWEAVER);
      this.stats = { ...this.gameData.characterClassStats[CharacterClass.SPELLWEAVER] };
      this.changeDetector.detectChanges();
    });
  }

  ngOnDestroy() {
    window.removeEventListener('resize', this.updateScale);
  }

  @HostListener('window:resize')
  onResize() {
    this.updateScale();
  }

  private updateScale() {
    const scaleX = window.innerWidth / this.designWidth;
    const scaleY = window.innerHeight / this.designHeight;

    this.scale = Math.min(scaleX, scaleY);
  }

  private createDefaultCharacter(characterClass: CharacterClass): CharacterDTO {
    return {
      characterClass,
      name: '',
      masteryType: MasteryType.NONE,
      masteryLevel: 0,
      classSkillType: ClassSkillType.NONE,
      classSkillLevel: 0,
      runeTrinkets: Array.from({ length: 7 }, () => ({
        runes: ([] = Array(10).fill(null)),
      })),
      jewelTrinkets: Array.from({ length: 3 }, () => ({
        jewels: ([] = Array(10).fill(null)),
      })),
      dragonCrest: {
        dragonStones: ([] = Array(10).fill(null)),
      },
      items: {},
      pet: null,
      essence: null,
      tonic: null,
      physic: null,
      wisdomSkills: this.createDefaultWisdomSkillTree(),
      collectorBagBuffs: [],
    };
  }

  private createDefaultWisdomSkillTree(): Record<WisdomSkillType, WisdomSkillInstanceDTO> {
    const wisdomSkills: Record<WisdomSkillType, WisdomSkillInstanceDTO> = {
      [WisdomSkillType.RISING_VIGOR]: {
        type: WisdomSkillType.RISING_VIGOR,
        currentLevel: 0,
      },
      [WisdomSkillType.VIVACIOUS_VITALITY]: {
        type: WisdomSkillType.VIVACIOUS_VITALITY,
        currentLevel: 0,
      },
      [WisdomSkillType.CONJURED_DISTILLATION]: {
        type: WisdomSkillType.CONJURED_DISTILLATION,
        currentLevel: 0,
      },
      [WisdomSkillType.RISING_POWER]: {
        type: WisdomSkillType.RISING_POWER,
        currentLevel: 0,
      },
      [WisdomSkillType.DECISIVE_STRIKE]: {
        type: WisdomSkillType.DECISIVE_STRIKE,
        currentLevel: 0,
      },
      [WisdomSkillType.HANGMANS_PRIDE]: {
        type: WisdomSkillType.HANGMANS_PRIDE,
        currentLevel: 0,
      },
      [WisdomSkillType.STURDY_SHIELD]: {
        type: WisdomSkillType.STURDY_SHIELD,
        currentLevel: 0,
      },
      [WisdomSkillType.HARD_AS_A_ROCK]: {
        type: WisdomSkillType.HARD_AS_A_ROCK,
        currentLevel: 0,
      },
      [WisdomSkillType.ELEMENTAL_PROTECTION]: {
        type: WisdomSkillType.ELEMENTAL_PROTECTION,
        currentLevel: 0,
      },
      [WisdomSkillType.SECOND_CHANCE]: {
        type: WisdomSkillType.SECOND_CHANCE,
        currentLevel: 0,
      },
      [WisdomSkillType.CLASS_SKILL_1]: {
        type: WisdomSkillType.CLASS_SKILL_1,
        currentLevel: 0,
      },
      [WisdomSkillType.CLASS_SKILL_2]: {
        type: WisdomSkillType.CLASS_SKILL_2,
        currentLevel: 0,
      },
      [WisdomSkillType.DEXTROUS_SMITING]: {
        type: WisdomSkillType.DEXTROUS_SMITING,
        currentLevel: 0,
      },
      [WisdomSkillType.DEXTROUS_AGILITY]: {
        type: WisdomSkillType.DEXTROUS_AGILITY,
        currentLevel: 0,
      },
      [WisdomSkillType.A_HANDFUL_OF_RESOURCES]: {
        type: WisdomSkillType.A_HANDFUL_OF_RESOURCES,
        currentLevel: 0,
      },
      [WisdomSkillType.AMBIDEXTROUS_SMITING]: {
        type: WisdomSkillType.AMBIDEXTROUS_SMITING,
        currentLevel: 0,
      },
      [WisdomSkillType.AMBIDEXTROUS_AGILITY]: {
        type: WisdomSkillType.AMBIDEXTROUS_AGILITY,
        currentLevel: 0,
      },
      [WisdomSkillType.LIFETIME_THIEF]: {
        type: WisdomSkillType.LIFETIME_THIEF,
        currentLevel: 0,
      },
      [WisdomSkillType.BONANZA]: {
        type: WisdomSkillType.BONANZA,
        currentLevel: 0,
      },
      [WisdomSkillType.PEDDLER]: {
        type: WisdomSkillType.PEDDLER,
        currentLevel: 0,
      },
      [WisdomSkillType.PORTABLE_WORKBENCH]: {
        type: WisdomSkillType.PORTABLE_WORKBENCH,
        currentLevel: 0,
      },
      [WisdomSkillType.HOME_SWEET_HOME]: {
        type: WisdomSkillType.HOME_SWEET_HOME,
        currentLevel: 0,
      },
      [WisdomSkillType.ON_HORSEBACK]: {
        type: WisdomSkillType.ON_HORSEBACK,
        currentLevel: 0,
      },
      [WisdomSkillType.RACING_SLIPPERS]: {
        type: WisdomSkillType.RACING_SLIPPERS,
        currentLevel: 0,
      },
    };

    return wisdomSkills;
  }

  openFilePicker() {
    this.fileInput.nativeElement.click();
  }

  onFileSelected(event: Event) {
    const input = event.target as HTMLInputElement;

    if (!input.files || input.files.length === 0) {
      return;
    }

    const file = input.files[0];

    const reader = new FileReader();

    reader.onload = () => {
      this.character = JSON.parse(reader.result as string);
      this.calculate();
    };
    reader.readAsText(file);
  }

  calculate() {
    this.statCalculationService.calculateStats(this.character).subscribe((response: any) => {
      this.stats!.absoluteStats = response.stats;
      this.changeDetector.detectChanges();
    });
  }

  downloadCharacter() {
    const json = JSON.stringify(this.character, null, 2);

    const blob = new Blob([json], {
      type: 'application/json',
    });

    const url = URL.createObjectURL(blob);

    const link = document.createElement('a');
    link.href = url;
    link.download = `${this.character.name || 'character'}.json`;

    link.click();

    URL.revokeObjectURL(url);
  }

  getCharacterClassImage(): string {
    switch (this.character.characterClass) {
      case CharacterClass.DRAGONKNIGHT:
        return 'class-icons/dragonknight.png';
      case CharacterClass.RANGER:
        return 'class-icons/ranger.png';
      case CharacterClass.SPELLWEAVER:
        return 'class-icons/spellweaver.png';
      case CharacterClass.STEAM_MECHANICUS:
        return 'class-icons/steam-mechanicus.png';
      default:
        return '';
    }
  }

  getCharacterClassName(characterClass: CharacterClass): string {
    return characterClass
      .split('_')
      .map((word) => word.charAt(0) + word.slice(1).toLowerCase())
      .join(' ');
  }

  private readonly weaponIcons: Record<
    CharacterClass,
    {
      oneHand: string;
      offHand: string;
      twoHand: string;
    }
  > = {
    [CharacterClass.DRAGONKNIGHT]: {
      oneHand: 'item-icons/dk-1h',
      offHand: 'item-icons/dk-shield',
      twoHand: 'item-icons/dk-2h',
    },

    [CharacterClass.RANGER]: {
      oneHand: 'item-icons/ranger-1h',
      offHand: 'item-icons/ranger-shield',
      twoHand: 'item-icons/ranger-2h',
    },

    [CharacterClass.SPELLWEAVER]: {
      oneHand: 'item-icons/sw-1h',
      offHand: 'item-icons/sw-shield',
      twoHand: 'item-icons/sw-2h',
    },

    [CharacterClass.STEAM_MECHANICUS]: {
      oneHand: 'item-icons/sm-1h',
      offHand: 'item-icons/sm-shield',
      twoHand: 'item-icons/sm-2h',
    },
  };

  getItemIcon(itemSlot: ItemSlot): string {
    if (this.character.items[itemSlot] === undefined)
      return (
        'item-icons/' +
        itemSlot
          .toLowerCase()
          .replaceAll('_', '-')
          .replaceAll(' ', '-')
          .replaceAll('1', '')
          .replaceAll('2', '')
          .replace('soul-companion-', '') +
        '.png'
      );

    const item = this.character.items[itemSlot];
    return (
      'item-icons/' +
      getIcon(itemSlot, this.gameData.items[this.character.characterClass][item.itemType].tier)
        .replaceAll('1', '')
        .replaceAll('2', '')
        .replace('soul-companion-', '')
    );
  }

  getMainHandIcon(): string {
    const icons = this.weaponIcons[this.character.characterClass];
    const item = this.character.items[ItemSlot.MAIN_HAND];
    if (item === undefined) return icons.oneHand + '.png';

    let tier = this.getItemIconSuffix(
      this.gameData.items[this.character.characterClass][item.itemType].tier,
    );

    return this.gameData.items[this.character.characterClass][item.itemType].itemSlotType ===
      ItemSlotType.TWO_HAND_WEAPON
      ? icons.twoHand + tier + '.png'
      : icons.oneHand + tier + '.png';
  }

  getOffHandIcon(): string {
    const icons = this.weaponIcons[this.character.characterClass];
    const item = this.character.items[ItemSlot.OFF_HAND];
    const weapon = this.character.items[ItemSlot.MAIN_HAND];

    if (weapon !== undefined) {
      if (
        this.gameData.items[this.character.characterClass][weapon.itemType].itemSlotType ===
        ItemSlotType.TWO_HAND_WEAPON
      )
        return (
          icons.twoHand +
          this.getItemIconSuffix(
            this.gameData.items[this.character.characterClass][weapon.itemType].tier,
          ) +
          '.png'
        );
    }

    if (item === undefined) return icons.offHand + '.png';

    let tier = this.getItemIconSuffix(
      this.gameData.items[this.character.characterClass][item.itemType].tier,
    );

    return icons.offHand + tier + '.png';
  }

  getItemIconSuffix(tier: number) {
    switch (tier) {
      case 6:
        return '-unique';
      case 0:
        return '-set';
      case 7:
        return '-mythic';
      case 8:
        return '-mythic+';
      default:
        return '';
    }
  }

  getInventoryIcon(prefix: string, tier: number | undefined) {
    if (tier === undefined) {
      return prefix + '-default.png';
    }

    switch (tier) {
      case 1:
        return prefix + '-common.png';
      case 2:
        return prefix + '-improved.png';
      case 3:
        return prefix + '-magic.png';
      case 4:
        return prefix + '-extraordinary.png';
      case 5:
        return prefix + '-legendary.png';
      case 6:
        return prefix + '-unique.png';
      case 7:
        return prefix + '-mythic.png';
      default:
        return prefix + '-default.png';
    }
  }

  getItemName(slot: ItemSlot, defaultSlotName: string): string {
    const item = this.character.items[slot];
    if (
      slot === ItemSlot.OFF_HAND &&
      this.character.items[ItemSlot.MAIN_HAND] !== undefined &&
      this.gameData.items[this.character.characterClass][
        this.character.items[ItemSlot.MAIN_HAND].itemType
      ].itemSlotType === ItemSlotType.TWO_HAND_WEAPON
    )
      return this.gameData.items[this.character.characterClass][
        this.character.items[ItemSlot.MAIN_HAND].itemType
      ].name;

    if (!item) {
      return defaultSlotName;
    }

    return this.gameData.items[this.character.characterClass][item.itemType].name;
  }

  resetCharacter() {
    if (!this.isDefaultCharacter()) this.showResetConfirmation = true;
  }

  confirmResetCharacter() {
    this.character = this.createDefaultCharacter(this.character.characterClass);
    this.stats = { ...this.gameData.characterClassStats[this.character.characterClass] };
    this.showResetConfirmation = false;
  }

  cancelResetCharacter() {
    this.showResetConfirmation = false;
  }

  onCharacterClassChange(newClass: CharacterClass) {
    if (this.character.characterClass == newClass) return;
    if (!this.isDefaultCharacter()) {
      const confirmed = confirm('Changing class will reset your build. Do you want to continue?');
      if (!confirmed) return;
    }

    this.character.characterClass = newClass;
    this.character = this.createDefaultCharacter(newClass);
    this.stats = { ...this.gameData.characterClassStats[newClass] };
  }

  isDefaultCharacter(): boolean {
    const defaultCharacter = this.createDefaultCharacter(this.character.characterClass);
    return JSON.stringify(this.character) === JSON.stringify(defaultCharacter);
  }

  openChangeClassWindow() {
    this.showClassChangeScreen = true;
  }

  changeClass(newClass: CharacterClass) {
    if (this.isDefaultCharacter()) {
      this.character = this.createDefaultCharacter(newClass);
      this.stats = { ...this.gameData.characterClassStats[newClass] };
      this.showClassChangeScreen = false;
    } else {
      this.selectedClass = newClass;
      this.showClassChangeScreen = false;
      this.slowClassChangeConfirmation = true;
    }
  }

  confirmClassChange() {
    this.character = this.createDefaultCharacter(this.selectedClass);
    this.stats = { ...this.gameData.characterClassStats[this.selectedClass] };
    this.slowClassChangeConfirmation = false;
    this.showClassChangeScreen = false;
  }

  cancelClassChange() {
    this.slowClassChangeConfirmation = false;
    this.showClassChangeScreen = false;
  }

  openPetSelector() {
    this.showPetSelector = true;
  }

  closePetSelector() {
    this.showPetSelector = false;
  }

  confirmPetSelection(pet: PetInstanceDTO | null) {
    this.character.pet = pet;
    this.calculate();
    this.showPetSelector = false;
  }

  openEssenceSelector() {
    this.showEssenceSelector = true;
  }

  closeEssenceSelector() {
    this.showEssenceSelector = false;
  }

  confirmEssenceSelection(essence: EssenceInstanceDTO | null) {
    this.character.essence = essence;
    this.calculate();
    this.showEssenceSelector = false;
  }

  openPhysicSelector() {
    this.showPhysicSelector = true;
  }

  closePhysicSelector() {
    this.showPhysicSelector = false;
  }

  confirmPhysicSelection(physic: BuffInstanceDTO | null) {
    this.character.physic = physic;
    this.calculate();
    this.showPhysicSelector = false;
  }

  openTonicSelector() {
    this.showTonicSelector = true;
  }

  closeTonicSelector() {
    this.showTonicSelector = false;
  }

  confirmTonicSelection(tonic: BuffInstanceDTO | null) {
    this.character.tonic = tonic;
    this.calculate();
    this.showTonicSelector = false;
  }

  openMasterySelector() {
    this.showMasterySelector = true;
  }

  closeMasterySelector() {
    this.showMasterySelector = false;
  }

  confirmMasterySelection(selection: { masteryType: MasteryType; level: number }) {
    this.character.masteryType = selection.masteryType;
    this.character.masteryLevel = selection.level;
    this.calculate();
    this.showMasterySelector = false;
  }

  getMasteryIcon(): string {
    switch (this.character.masteryType) {
      case MasteryType.POISON:
        return 'inventory-icons/mastery-poison.png';
      case MasteryType.FIRE:
        return 'inventory-icons/mastery-fire.png';
      case MasteryType.ICE:
        return 'inventory-icons/mastery-ice.png';
      case MasteryType.LIGHTNING:
        return 'inventory-icons/mastery-lightning.png';
      default:
        return 'inventory-icons/mastery.png';
    }
  }

  onClassSkillClick(skillType: ClassSkillType) {
    if (this.character.classSkillType !== skillType) {
      this.character.classSkillType = skillType;
      this.character.classSkillLevel = 1;
      this.calculate();
      return;
    }
    if (this.character.classSkillLevel < 5) {
      this.character.classSkillLevel++;
    }
    this.calculate();
  }

  onClassSkillRightClick(event: MouseEvent, skillType: ClassSkillType) {
    event.preventDefault();
    if (this.character.classSkillType === skillType) {
      this.character.classSkillLevel--;
      if (this.character.classSkillLevel <= 0) {
        this.character.classSkillType = ClassSkillType.NONE;
        this.character.classSkillLevel = 0;
      }
    }
    this.calculate();
  }

  getClassSkillIcon(skillType: ClassSkillType): string {
    switch (skillType) {
      case ClassSkillType.BLOODMAGE:
        if (
          this.character.classSkillType === ClassSkillType.BLOODMAGE &&
          this.character.classSkillLevel > 0
        )
          return 'inventory-icons/bloodmage-active.png';
        return 'inventory-icons/bloodmage.png';
      case ClassSkillType.IMMOVEABLE_WALL:
        if (
          this.character.classSkillType === ClassSkillType.IMMOVEABLE_WALL &&
          this.character.classSkillLevel > 0
        )
          return 'inventory-icons/immoveable-wall-active.png';
        return 'inventory-icons/immoveable-wall.png';
      case ClassSkillType.QUICK_STRIKER:
        if (
          this.character.classSkillType === ClassSkillType.QUICK_STRIKER &&
          this.character.classSkillLevel > 0
        )
          return 'inventory-icons/quick-striker-active.png';
        return 'inventory-icons/quick-striker.png';
      default:
        return '';
    }
  }

  openCollectorBagSelector() {
    this.showCollectorBagSelector = true;
  }

  closeCollectorBagSelector() {
    this.showCollectorBagSelector = false;
  }

  confirmCollectorBagSelection(buffs: CollectorBagCategoryBonusInstanceDTO[]) {
    this.character.collectorBagBuffs = buffs;
    this.calculate();
    this.showCollectorBagSelector = false;
  }

  openDragonCrestEditor() {
    this.showDragonCrest = true;
  }

  closeDragonCrestEditor() {
    this.showDragonCrest = false;
  }

  confirmDragonCrestSelection(dragonCrest: DragonCrestTrinketDTO) {
    this.character.dragonCrest = dragonCrest;
    this.calculate();
    this.showDragonCrest = false;
  }

  openJewelTrinketEditor(index: number) {
    this.selectedJewelTrinket = index;
    this.showJewelTrinket = true;
  }

  closeJewelTrinketEditor() {
    this.showJewelTrinket = false;
    this.selectedJewelTrinket = -1;
  }

  confirmJewelTrinketSelection(jewelTrinket: JewelTrinketDTO) {
    this.character.jewelTrinkets[this.selectedJewelTrinket] = jewelTrinket;
    this.calculate();
    this.closeJewelTrinketEditor();
  }

  getEquippedJewelAmount(excludedTrinketIndex: number, jewelType: string): number {
    const limitGroup = this.jewelLimitGroups[jewelType];

    return this.character.jewelTrinkets
      .filter((_, index) => index !== excludedTrinketIndex)
      .flatMap((trinket) => trinket.jewels)
      .filter((jewel) => jewel !== null)
      .filter((jewel) => this.jewelLimitGroups[jewel.jewelType] === limitGroup).length;
  }

  canAddJewel(jewelType: string, editedJewels: (JewelInstanceDTO | null)[]): boolean {
    const limitGroup = this.jewelLimitGroups[jewelType];

    const equippedAmount = this.getEquippedJewelAmount(this.selectedJewelTrinket, jewelType);

    const editedAmount = editedJewels
      .filter((jewel) => jewel !== null)
      .filter((jewel) => this.jewelLimitGroups[jewel.jewelType] === limitGroup).length;

    return equippedAmount + editedAmount < this.gameData.jewelLimits[limitGroup];
  }

  openRuneTrinketEditor(index: number) {
    this.selectedRuneTrinket = index;
    this.showRuneTrinket = true;
  }

  closeRuneTrinketEditor() {
    this.showRuneTrinket = false;
    this.selectedRuneTrinket = -1;
  }

  confirmRuneTrinketSelection(runeTrinket: RuneTrinketDTO) {
    this.character.runeTrinkets[this.selectedRuneTrinket] = runeTrinket;
    this.calculate();
    this.closeRuneTrinketEditor();
  }

  getEquippedRuneAmount(excludedTrinketIndex: number, runeType: string): number {
    const limitGroup = this.runeLimitGroups[runeType];

    return this.character.runeTrinkets
      .filter((_, index) => index !== excludedTrinketIndex)
      .flatMap((trinket) => trinket.runes)
      .filter((rune) => rune !== null)
      .filter((rune) => this.runeLimitGroups[rune.runeType] === limitGroup).length;
  }

  canAddRune(runeType: string, editedRunes: (RuneInstanceDTO | null)[]): boolean {
    const limitGroup = this.runeLimitGroups[runeType];

    const equippedAmount = this.getEquippedRuneAmount(this.selectedRuneTrinket, runeType);

    const editedAmount = editedRunes
      .filter((rune) => rune !== null)
      .filter((rune) => this.runeLimitGroups[rune.runeType] === limitGroup).length;

    return equippedAmount + editedAmount < this.gameData.runeLimits[limitGroup];
  }

  openWisdomSkillTreeEditor() {
    this.showWisdomSkillTreeEditor = true;
  }

  closeWisdomSkillTreeEditor() {
    this.showWisdomSkillTreeEditor = false;
  }

  confirmWisdomSkillTreeSelection(wisdomSkills: Record<WisdomSkillType, WisdomSkillInstanceDTO>) {
    this.calculate();
    this.closeWisdomSkillTreeEditor();
  }

  openItemEditor(itemSlot: ItemSlot) {
    this.selectedItemSlot = itemSlot;
    this.showItemEditor = true;
  }

  closeItemEditor() {
    this.selectedItemSlot = ItemSlot.NONE;
    this.showItemEditor = false;
  }

  confirmItemSelection(item: ItemInstanceDTO) {
    if (!item) {
      delete this.character.items[this.selectedItemSlot];
      this.calculate();
      this.closeItemEditor();
      return;
    }

    if (
      this.gameData.items[this.character.characterClass][item.itemType].itemSlotType ===
      ItemSlotType.TWO_HAND_WEAPON
    ) {
      delete this.character.items[ItemSlot.OFF_HAND];
    }
    const mainHand = this.character.items[ItemSlot.MAIN_HAND];

    if (
      this.gameData.items[this.character.characterClass][item.itemType].itemSlotType ===
        ItemSlotType.OFF_HAND &&
      mainHand &&
      this.gameData.items[this.character.characterClass][mainHand.itemType].itemSlotType ===
        ItemSlotType.TWO_HAND_WEAPON
    ) {
      delete this.character.items[ItemSlot.MAIN_HAND];
    }
    this.character.items[this.selectedItemSlot] = item;
    this.calculate();
    this.closeItemEditor();
  }

  getItemsForSlot(itemSlot: ItemSlot) {
    let filteredItems: Record<string, ItemDefinitionDTO> = {};
    switch (itemSlot) {
      case ItemSlot.AMULET:
        filteredItems =
          this.itemsByClassAndSlot[this.character.characterClass][ItemSlotType.AMULET];
        break;
      case ItemSlot.CLOAK:
        filteredItems = this.itemsByClassAndSlot[this.character.characterClass][ItemSlotType.CLOAK];
        break;
      case ItemSlot.BELT:
        filteredItems = this.itemsByClassAndSlot[this.character.characterClass][ItemSlotType.BELT];
        break;
      case ItemSlot.RING1:
        filteredItems = this.itemsByClassAndSlot[this.character.characterClass][ItemSlotType.RING];
        break;
      case ItemSlot.RING2:
        filteredItems = this.itemsByClassAndSlot[this.character.characterClass][ItemSlotType.RING];
        break;
      case ItemSlot.HELMET:
        filteredItems =
          this.itemsByClassAndSlot[this.character.characterClass][ItemSlotType.HELMET];
        break;
      case ItemSlot.SHOULDERS:
        filteredItems =
          this.itemsByClassAndSlot[this.character.characterClass][ItemSlotType.SHOULDERS];
        break;
      case ItemSlot.TORSO:
        filteredItems = this.itemsByClassAndSlot[this.character.characterClass][ItemSlotType.TORSO];
        break;
      case ItemSlot.GLOVES:
        filteredItems =
          this.itemsByClassAndSlot[this.character.characterClass][ItemSlotType.GLOVES];
        break;
      case ItemSlot.BOOTS:
        filteredItems = this.itemsByClassAndSlot[this.character.characterClass][ItemSlotType.BOOTS];
        break;
      case ItemSlot.WEAPON_ADORNMENT:
        filteredItems =
          this.itemsByClassAndSlot[this.character.characterClass][ItemSlotType.WEAPON_ADORNMENT];
        break;
      case ItemSlot.MAIN_HAND:
        filteredItems = filteredItems = {
          ...this.itemsByClassAndSlot[this.character.characterClass][ItemSlotType.ONE_HAND_WEAPON],
          ...this.itemsByClassAndSlot[this.character.characterClass][ItemSlotType.TWO_HAND_WEAPON],
        };
        break;
      case ItemSlot.OFF_HAND:
        filteredItems =
          this.itemsByClassAndSlot[this.character.characterClass][ItemSlotType.OFF_HAND];
        break;
      case ItemSlot.SOUL_COMPANION_AMULET:
        filteredItems =
          this.itemsByClassAndSlot[this.character.characterClass][
            ItemSlotType.SOUL_COMPANION_AMULET
          ];
        break;
      case ItemSlot.SOUL_COMPANION_CLOAK:
        filteredItems =
          this.itemsByClassAndSlot[this.character.characterClass][
            ItemSlotType.SOUL_COMPANION_CLOAK
          ];
        break;
      case ItemSlot.SOUL_COMPANION_BELT:
        filteredItems =
          this.itemsByClassAndSlot[this.character.characterClass][ItemSlotType.SOUL_COMPANION_BELT];
        break;
      case ItemSlot.NONE:
    }

    return filteredItems;
  }

  canAddGem(gemType: string, editedGems: (GemInstanceDTO | null)[]): boolean {
    const limitGroup = gemType === 'OPAL' ? 'OPAL' : this.gemLimitGroups[gemType];

    const equippedAmount = this.getEquippedGemAmount(this.selectedItemSlot, gemType);

    const editedAmount = editedGems
      .filter((gem) => gem !== null)
      .filter((gem) =>
        gem.gemCategory === 'OPAL'
          ? 'OPAL' === limitGroup
          : this.gemLimitGroups[gem.gemType[0]] === limitGroup,
      ).length;
    return equippedAmount + editedAmount < this.gameData.gemLimits[limitGroup];
  }

  getEquippedGemAmount(excludedItem: ItemSlot, gemType: string): number {
    const limitGroup = gemType === 'OPAL' ? 'OPAL' : this.gemLimitGroups[gemType];
    return Object.entries(this.character.items)
      .filter(([slot]) => slot !== excludedItem)
      .map(([_, item]) => item)
      .filter((item) => item !== undefined)
      .flatMap((item) => item.gems)
      .filter((gem) => gem !== null)
      .filter((gem) =>
        gem.gemCategory === 'OPAL'
          ? 'OPAL' === limitGroup
          : this.gemLimitGroups[gem.gemType[0]] === limitGroup,
      ).length;
  }

  getEquippedSets(excludedItem: ItemSlot): Record<string, Set<string>> {
    const equippedSets: Record<string, Set<string>> = {};

    Object.entries(this.character.items)
      .filter(([slot]) => slot !== excludedItem)
      .forEach(([, item]) => {
        if (!item) {
          return;
        }

        const itemDefinition = this.gameData.items[this.character.characterClass]?.[item.itemType];

        if (!itemDefinition) {
          return;
        }

        if (itemDefinition.itemCategory !== 'SET' && itemDefinition.itemCategory !== 'MYTHIC') {
          return;
        }

        if (!itemDefinition.set) {
          return;
        }

        const items = equippedSets[itemDefinition.set] ?? new Set<string>();

        items.add(item.itemType);
        equippedSets[itemDefinition.set] = items;
      });

    return equippedSets;
  }

  getEquippedItems(excludedItem: ItemSlot): string[] {
    return Object.entries(this.character.items)
      .filter(([slot]) => slot !== excludedItem)
      .map(([, item]) => item?.itemType)
      .filter((itemType): itemType is string => itemType !== undefined);
  }
}
