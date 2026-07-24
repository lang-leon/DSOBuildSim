import { ChangeDetectorRef, Component, ElementRef, OnInit, ViewChild } from '@angular/core';
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

@Component({
  selector: 'app-character',
  standalone: true,
  imports: [CommonModule, BuildSimButton, FormsModule, PetSelector],
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
  character: CharacterDTO = this.createDefaultCharacter(CharacterClass.SPELLWEAVER);

  CharacterClass = CharacterClass;
  showResetConfirmation = false;
  showClassChangeScreen = false;
  selectedClass: CharacterClass = CharacterClass.SPELLWEAVER;
  slowClassChangeConfirmation = false;
  showPetSelector = false;

  constructor(
    private statCalculationService: StatCalculationService,
    private gameDataService: GameDataService,
    private changeDetector: ChangeDetectorRef,
  ) {}

  ngOnInit(): void {
    this.gameDataService.getGameData().subscribe((data) => {
      this.gameData = data;
      this.stats = { ...this.gameData.characterClassStats[CharacterClass.SPELLWEAVER] };
      this.changeDetector.detectChanges();
    });
  }

  private createDefaultCharacter(characterClass: CharacterClass): CharacterDTO {
    return {
      characterClass,
      name: 'Character',
      masteryType: MasteryType.NONE,
      masteryLevel: 0,
      experienceBonus: false,
      experienceBonusLevel: 0,
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

  confirmPetSelection(pet: PetInstanceDTO) {
    this.character.pet = pet;
    this.calculate();
    this.showPetSelector = false;
  }
}
