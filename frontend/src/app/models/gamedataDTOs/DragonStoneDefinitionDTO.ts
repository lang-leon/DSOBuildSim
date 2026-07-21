import { StatType } from "../../enums/StatType";

export interface DragonStoneDefinitionDTO {
    dragonStoneType: string;
    name: string;
    defaultTier: number;
    stats: Record<string, Record<StatType, number>>;
    description: Record<string, string>;
}