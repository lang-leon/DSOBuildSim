import { Component, EventEmitter, Input, Output } from '@angular/core';
import { BuildSimButton } from '../build-sim-button/build-sim-button';
import { WisdomGroupType } from '../../enums/WisdomGroupType';
import { WisdomSkillType } from '../../enums/WisdomSkillType';
import { CharacterClass } from '../../enums/CharacterClass';
import { WisdomSkillInstanceDTO } from '../../models/instanceDTOs/WisdomSkillInstanceDTO';
import { WisdomGroupDefinitionDTO } from '../../models/gamedataDTOs/WisdomGroupDefinitionDTO';
import { WisdomSkillDefinitionDTO } from '../../models/gamedataDTOs/WisdomSkillDefinitionDTO';
import { formatStatName } from '../../utils/display-utils';

@Component({
  selector: 'app-wisdom-skilltree',
  imports: [BuildSimButton],
  templateUrl: './wisdom-skilltree-editor.html',
  styleUrl: './wisdom-skilltree-editor.scss',
})
export class WisdomSkilltreeEditor {
  @Input() scale = 1;

  @Input() characterClass!: CharacterClass;

  @Input() wisdomSkills!: Record<WisdomSkillType, WisdomSkillInstanceDTO>;

  @Input() wisdomSkillDefs!: Record<WisdomSkillType, WisdomSkillDefinitionDTO>;

  @Input() wisdomGroupDefs!: Record<WisdomGroupType, WisdomGroupDefinitionDTO>;

  @Output() cancelled = new EventEmitter<void>();

  @Output() confirmed = new EventEmitter<Record<WisdomSkillType, WisdomSkillInstanceDTO>>();

  WisdomGroupType = WisdomGroupType;
  WisdomSkillType = WisdomSkillType;

  ngOnInit(): void {
    const existingSkills = this.wisdomSkills ?? [];
    console.log(existingSkills);
  }

  getWisdomSkillName(wisdomSkillType: WisdomSkillType) {
    return this.wisdomSkillDefs[wisdomSkillType].name;
  }

  getWisdomSkillDescription(wisdomSkillType: WisdomSkillType) {
    const wisdomSkillDef = this.wisdomSkillDefs[wisdomSkillType];
    let desc: string[] = [];
    desc.push(
      wisdomSkillDef.description.replace(
        '%f',
        this.formatStatValue(
          this.getWisdomSkillStatAmount(wisdomSkillType),
          wisdomSkillDef.statValueAbsolute,
        ),
      ),
    );

    if (wisdomSkillDef.statType !== null) {
      desc.push(
        `+ ${this.formatStatValue(this.getWisdomSkillStatAmount(wisdomSkillType), wisdomSkillDef.statValueAbsolute)} ${formatStatName(wisdomSkillDef.statType)}`,
      );
    }

    if (
      this.wisdomSkills[wisdomSkillType].currentLevel > 0 &&
      this.wisdomSkills[wisdomSkillType].currentLevel < wisdomSkillDef.maxLevel
    ) {
      desc.push(
        'Increase per talent level:\n' +
          `+ ${this.formatStatValue(wisdomSkillDef.increasePerLevel, wisdomSkillDef.statValueAbsolute)} ${formatStatName(wisdomSkillDef.statType ?? '')}`,
      );
    }

    if (this.wisdomSkills[wisdomSkillType].currentLevel < wisdomSkillDef.maxLevel) {
      desc.push('Cost: ' + wisdomSkillDef.costPerLevel + ' Talent Points');
    }

    return desc;
  }

  getWisdomSkillStatAmount(wisdomSkillType: WisdomSkillType) {
    const wisdomSkillDef = this.wisdomSkillDefs[wisdomSkillType];
    if (this.wisdomSkills[wisdomSkillType].currentLevel <= 0)
      return wisdomSkillDef.increasePerLevel + wisdomSkillDef.firstLevelBonus;
    return (
      this.wisdomSkills[wisdomSkillType].currentLevel * wisdomSkillDef.increasePerLevel +
      wisdomSkillDef.firstLevelBonus
    );
  }

  formatStatValue(value: number, statValueAbsolute: boolean): string {
    if (statValueAbsolute) return value.toFixed(3).replace(/\.?0+$/, '');
    return (value * 100).toFixed(2) + '%';
  }

  getWisdomSkillIcon(wisdomSkillType: WisdomSkillType) {
    const typeName = wisdomSkillType.toLowerCase().replaceAll('_', '-').replaceAll(' ', '-');
    const active = this.wisdomSkills[wisdomSkillType].currentLevel > 0;
    const activeStr = active ? '-active' : '-inactive';

    if (
      wisdomSkillType === WisdomSkillType.CLASS_SKILL_1 ||
      wisdomSkillType === WisdomSkillType.CLASS_SKILL_2
    ) {
      let classStr = '';
      switch (this.characterClass) {
        case CharacterClass.DRAGONKNIGHT:
          classStr = '-dk';
          break;
        case CharacterClass.RANGER:
          classStr = '-rn';
          break;
        case CharacterClass.SPELLWEAVER:
          classStr = '-sw';
          break;
        case CharacterClass.STEAM_MECHANICUS:
          classStr = '-sm';
          break;
      }

      return 'wisdom-skills/' + typeName + activeStr + classStr + '.png';
    }
    return 'wisdom-skills/' + typeName + activeStr + '.png';
  }

  getCurrentOfGroup(wisdomGroupType: WisdomGroupType) {
    let count = 0;
    for (const skillType of this.wisdomGroupDefs[wisdomGroupType].wisdomSkills) {
      count += this.wisdomSkills[skillType].currentLevel;
    }
    return count;
  }

  getMaxOfGroup(wisdomGroupType: WisdomGroupType) {
    return this.wisdomGroupDefs[wisdomGroupType].maxLevel;
  }

  getSkillLevel(wisdomSkillType: WisdomSkillType) {
    return (
      this.wisdomSkills[wisdomSkillType].currentLevel +
      '/' +
      this.wisdomSkillDefs[wisdomSkillType].maxLevel
    );
  }

  resetWisdomGroup(wisdomGroupType: WisdomGroupType) {
    for (const skillType of this.wisdomGroupDefs[wisdomGroupType].wisdomSkills) {
      this.wisdomSkills[skillType].currentLevel = 0;
    }
  }

  getTotalPointsLeft() {
    let count = 0;
    for (const [skillType, skill] of Object.entries(this.wisdomSkills) as [
      WisdomSkillType,
      WisdomSkillInstanceDTO,
    ][]) {
      count += skill.currentLevel * this.wisdomSkillDefs[skillType].costPerLevel;
    }
    return 2865 - count;
  }

  onSkillClick(wisdomSkillType: WisdomSkillType, wisdomGroupType: WisdomGroupType) {
    if (
      this.wisdomSkills[wisdomSkillType].currentLevel <
        this.wisdomSkillDefs[wisdomSkillType].maxLevel &&
      this.getCurrentOfGroup(wisdomGroupType) < this.wisdomGroupDefs[wisdomGroupType].maxLevel &&
      this.getTotalPointsLeft() >= this.wisdomSkillDefs[wisdomSkillType].costPerLevel
    )
      this.wisdomSkills[wisdomSkillType].currentLevel++;
  }

  onSkillRightClick(event: MouseEvent, wisdomSkillType: WisdomSkillType) {
    event.preventDefault();
    if (this.wisdomSkills[wisdomSkillType].currentLevel > 0)
      this.wisdomSkills[wisdomSkillType].currentLevel--;
  }

  cancel() {
    this.cancelled.emit();
  }

  confirm() {
    this.confirmed.emit();
  }
}
