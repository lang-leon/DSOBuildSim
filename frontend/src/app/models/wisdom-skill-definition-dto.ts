import { StatType } from "./stat-type";

export interface WisdomSkillDefinitionDTO {
    type: string;
    name: string;
    maxLevel: number;
    currentLevel: number;   
    costPerLevel: number;
    statType: StatType;
    increasePerLevel: number;
    firstLevelBonus: number;
    description: string;
}