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
import { WisdomSkillTreeInstanceDTO } from '../../models/instanceDTOs/WisdomSkillTreeInstanceDTO';
import { WisdomGroupType } from '../../enums/WisdomGroupType';
import { WisdomGroupInstanceDTO } from '../../models/instanceDTOs/WisdomGroupInstanceDTO';
import { WisdomSkillType } from '../../enums/WisdomSkillType';
import { BuildSimButton } from '../build-sim-button/build-sim-button';
import { ItemSlot } from '../../enums/ItemSlot';
import { FormsModule, NgModel } from '@angular/forms';
import { PetSelector } from '../pet-selector/pet-selector';
import { PetInstanceDTO } from '../../models/instanceDTOs/PetInstanceDTO';
import { EssenceSelector } from '../essence-selector/essence-selector';
import { EssenceInstanceDTO } from '../../models/instanceDTOs/EssenceInstanceDTO';
import { formatStatName } from '../../utils/display-utils';
import { BuffInstanceDTO } from '../../models/instanceDTOs/BuffInstanceDTO';
import { BuffCategory } from '../../enums/BuffCategory';
import { BuffSelector } from '../buff-selector/buff-selector';
import { ClassSkillType } from '../../enums/ClassSkillType';
import { MasterySelector } from '../mastery-selector/mastery-selector';
import { ClassChangeWindow } from '../class-change-window/class-change-window';
import { ConfirmationWindow } from '../confirmation-window/confirmation-window';

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
    ConfirmationWindow
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

  formatStatName = formatStatName;
  BuffCategory = BuffCategory;
  ClassSkillType = ClassSkillType;

  constructor(
    private statCalculationService: StatCalculationService,
    private gameDataService: GameDataService,
    private changeDetector: ChangeDetectorRef,
  ) {}

  ngOnInit(): void {
    this.updateScale();
    this.gameDataService.getGameData().subscribe((data) => {
      this.gameData = data;
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
      name: 'Character',
      masteryType: MasteryType.NONE,
      masteryLevel: 0,
      classSkillType: ClassSkillType.NONE,
      classSkillLevel: 0,
      runeTrinkets: Array.from({ length: 7 }, () => ({
        runes: [],
      })),
      jewelTrinkets: Array.from({ length: 3 }, () => ({
        jewels: [],
      })),
      dragonCrest: {
        dragonStones: [],
      },
      items: {},
      pet: null,
      essence: null,
      tonic: null,
      physic: null,
      wisdomSkillTree: this.createDefaultWisdomSkillTree(),
      collectorBagBuffs: [],
    };
  }

  private createDefaultWisdomSkillTree(): WisdomSkillTreeInstanceDTO {
    const wisdomGroups: Record<WisdomGroupType, WisdomGroupInstanceDTO> = {
      [WisdomGroupType.HEALTH_RESOURCE]: {
        type: WisdomGroupType.HEALTH_RESOURCE,
        wisdomSkills: {
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
        },
      },
      [WisdomGroupType.ATTACK]: {
        type: WisdomGroupType.ATTACK,
        wisdomSkills: {
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
        },
      },
      [WisdomGroupType.DEFENSE]: {
        type: WisdomGroupType.DEFENSE,
        wisdomSkills: {
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
        },
      },
      [WisdomGroupType.COMBAT]: {
        type: WisdomGroupType.COMBAT,
        wisdomSkills: {
          [WisdomSkillType.SECOND_CHANCE]: {
            type: WisdomSkillType.SECOND_CHANCE,
            currentLevel: 0,
          },
          [WisdomSkillType.EMERGENCY_RESERVES]: {
            type: WisdomSkillType.EMERGENCY_RESERVES,
            currentLevel: 0,
          },
          [WisdomSkillType.ENERGETIC_FORCE]: {
            type: WisdomSkillType.ENERGETIC_FORCE,
            currentLevel: 0,
          },
        },
      },
      [WisdomGroupType.ONE_HANDED_WEAPON]: {
        type: WisdomGroupType.ONE_HANDED_WEAPON,
        wisdomSkills: {
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
        },
      },
      [WisdomGroupType.TWO_HANDED_WEAPON]: {
        type: WisdomGroupType.TWO_HANDED_WEAPON,
        wisdomSkills: {
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
        },
      },
      [WisdomGroupType.PROSPERITY]: {
        type: WisdomGroupType.PROSPERITY,
        wisdomSkills: {
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
        },
      },
      [WisdomGroupType.TRAVEL_MERITS]: {
        type: WisdomGroupType.TRAVEL_MERITS,
        wisdomSkills: {
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
        },
      },
    };

    return { wisdomGroups };
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
      oneHand: 'inventory-icons/dk-1h.png',
      offHand: 'inventory-icons/dk-shield.png',
      twoHand: 'inventory-icons/dk-2h.png',
    },

    [CharacterClass.RANGER]: {
      oneHand: 'inventory-icons/ranger-1h.png',
      offHand: 'inventory-icons/ranger-shield.png',
      twoHand: 'inventory-icons/ranger-2h.png',
    },

    [CharacterClass.SPELLWEAVER]: {
      oneHand: 'inventory-icons/sw-1h.png',
      offHand: 'inventory-icons/sw-shield.png',
      twoHand: 'inventory-icons/sw-2h.png',
    },

    [CharacterClass.STEAM_MECHANICUS]: {
      oneHand: 'inventory-icons/sm-1h.png',
      offHand: 'inventory-icons/sm-shield.png',
      twoHand: 'inventory-icons/sm-2h.png',
    },
  };

  getMainHandIcon(): string {
    const icons = this.weaponIcons[this.character.characterClass];

    return this.character.items[ItemSlot.TWO_HAND_WEAPON] !== undefined
      ? icons.twoHand
      : icons.oneHand;
  }

  getOffHandIcon(): string {
    const icons = this.weaponIcons[this.character.characterClass];

    return this.character.items[ItemSlot.TWO_HAND_WEAPON] !== undefined
      ? icons.twoHand
      : icons.offHand;
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

  getPetIcon(): string {
    if (this.character.pet?.tier === undefined) {
      return 'inventory-icons/pet.png';
    }

    switch (this.character.pet.tier) {
      case 2:
        return 'inventory-icons/pet-green.png';
      case 3:
        return 'inventory-icons/pet-blue.png';
      case 4:
        return 'inventory-icons/pet-purple.png';
      case 5:
        return 'inventory-icons/pet-orange.png';
      case 6:
        return 'inventory-icons/pet-yellow.png';
      default:
        return 'inventory-icons/pet.png';
    }
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

  getEssenceIcon(): string {
    if (this.character.essence?.tier === undefined) {
      return 'inventory-icons/essence.png';
    }

    switch (this.character.essence.tier) {
      case 2:
        return 'inventory-icons/essence-green.png';
      case 3:
        return 'inventory-icons/essence-blue.png';
      case 4:
        return 'inventory-icons/essence-purple.png';
      case 5:
        return 'inventory-icons/essence-red.png';
      default:
        return 'inventory-icons/essence.png';
    }
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

  getPhysicIcon(): string {
    if (this.character.physic?.tier === undefined) {
      return 'inventory-icons/physic.png';
    }

    switch (this.character.physic.tier) {
      case 2:
        return 'inventory-icons/physic-green.png';
      case 3:
        return 'inventory-icons/physic-blue.png';
      case 4:
        return 'inventory-icons/physic-purple.png';
      case 5:
        return 'inventory-icons/physic-orange.png';
      default:
        return 'inventory-icons/physic.png';
    }
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

  getTonicIcon(): string {
    if (this.character.tonic?.tier === undefined) {
      return 'inventory-icons/tonic.png';
    }

    switch (this.character.tonic.tier) {
      case 2:
        return 'inventory-icons/tonic-green.png';
      case 3:
        return 'inventory-icons/tonic-blue.png';
      case 4:
        return 'inventory-icons/tonic-purple.png';
      case 5:
        return 'inventory-icons/tonic-orange.png';
      default:
        return 'inventory-icons/tonic.png';
    }
  }

  openMasterySelector() {
    this.showMasterySelector = true;
  }

  closeMasterySelector() {
    this.showMasterySelector = false;
  }

  confirmMasterySelection(selection: {
    masteryType: MasteryType;
    level: number;
  }) {
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
        if(this.character.classSkillType === ClassSkillType.BLOODMAGE && this.character.classSkillLevel > 0) return 'inventory-icons/bloodmage-active.png';
        return 'inventory-icons/bloodmage.png';
      case ClassSkillType.IMMOVEABLE_WALL:
        if(this.character.classSkillType === ClassSkillType.IMMOVEABLE_WALL && this.character.classSkillLevel > 0) return 'inventory-icons/immoveable-wall-active.png';
        return 'inventory-icons/immoveable-wall.png';
      case ClassSkillType.QUICK_STRIKER:
        if(this.character.classSkillType === ClassSkillType.QUICK_STRIKER && this.character.classSkillLevel > 0) return 'inventory-icons/quick-striker-active.png';
        return 'inventory-icons/quick-striker.png';
      default:
        return '';
    }
  }
}
