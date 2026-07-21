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
import { WisdomSkillInstanceDTO } from '../../models/instanceDTOs/WisdomSkillInstanceDTO';

@Component({
  selector: 'app-character',
  standalone: true,
  imports: [
    CommonModule
  ],
  templateUrl: './build-sim-component.html',
  styleUrl: './build-sim-component.scss',
})

export class BuildSimComponent implements OnInit{

  @ViewChild('fileInput')
  fileInput!: ElementRef<HTMLInputElement>;

  StatType = StatType;
  gameData!: GameDataDTO;
  stats?: ClassStatsDTO;
  character!: CharacterDTO;

  constructor(
    private statCalculationService: StatCalculationService,
    private gameDataService: GameDataService,
    private changeDetector: ChangeDetectorRef
  ) {}

  ngOnInit(): void {
    this.gameDataService.getGameData()
    .subscribe(data => {
      this.gameData = data;
      this.stats = this.gameData.characterClassStats["SPELLWEAVER"];
      this.character = this.createDefaultCharacter();
      console.log(this.character.wisdomSkillTree);
      this.changeDetector.detectChanges();
    });
  }

  private createDefaultCharacter(): CharacterDTO {
    return {
      characterClass: CharacterClass.SPELLWEAVER,
      name: "Character",
      masteryType: MasteryType.NONE,
      masteryLevel: 0,
      experienceBonus: false,
      experienceBonusLevel: 0,
      runeTrinkets: Array.from({ length: 7 }, () => ({
        runes: []
      })),
      jewelTrinkets: Array.from({ length: 3 }, () => ({
        jewels: []
      })),
      dragonCrest: {
        dragonStones: []
      },
      items: {},
      pet: null,
      essence: null,
      tonic: null,
      physic: null,
      wisdomSkillTree: this.createDefaultWisdomSkillTree(),
      collectorBagBuffs: []
    }
  }

  private createDefaultWisdomSkillTree(): WisdomSkillTreeInstanceDTO {
    const wisdomGroups = {} as Record<WisdomGroupType, WisdomGroupInstanceDTO>;

    for(const groupDefinition of Object.values(this.gameData.wisdomSkillTree.wisdomGroups))
    {
      const wisdomSkills = {} as Record<WisdomSkillType, WisdomSkillInstanceDTO>;

      for (const skillDefinition of Object.values(groupDefinition.wisdomSkills))
      {
        wisdomSkills[skillDefinition.type] = {
          type: skillDefinition.type,
          currentLevel: 0
        };
      }

      wisdomGroups[groupDefinition.type] = {
        type: groupDefinition.type,
        wisdomSkills
      }
    }

    return { wisdomGroups };
  }

  openFilePicker()
  {
    this.fileInput.nativeElement.click();
  }

  onFileSelected(event: Event)
  {
    const input = event.target as HTMLInputElement;

    if(!input.files || input.files.length ===0)
    {
      return;
    }

    const file = input.files[0];

    const reader = new FileReader();

    reader.onload = () => {
      this.character = JSON.parse(reader.result as string);
      this.calculate(this.character);
    };
    reader.readAsText(file);
  }

  calculate(character: object)
  {
    this.statCalculationService.calculateStats(character).subscribe((response: any) => {
      this.stats!.absoluteStats = response.stats;
      this.changeDetector.detectChanges();
    });
  }

  downloadCharacter() {
    const json = JSON.stringify(this.character, null, 2);

    const blob = new Blob([json], {
      type: 'application/json'
    });

    const url = URL.createObjectURL(blob);

    const link = document.createElement('a');
    link.href = url;
    link.download = `${this.character.name || 'character'}.json`;

    link.click();

    URL.revokeObjectURL(url);
  }
}
