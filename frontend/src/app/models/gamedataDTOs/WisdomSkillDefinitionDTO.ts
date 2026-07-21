import { StatType } from "../../enums/StatType";
import { WisdomSkillType } from "../../enums/WisdomSkillType";

export interface WisdomSkillDefinitionDTO {
    type: WisdomSkillType;
    name: string;
    maxLevel: number;
    currentLevel: number;   
    costPerLevel: number;
    statType: StatType;
    increasePerLevel: number;
    firstLevelBonus: number;
    description: string;
}