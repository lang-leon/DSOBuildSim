import { StatType } from "../../enums/StatType";

export interface DragonStoneDefinitionDTO {
    dragonStoneType: string;
    name: string;
    defaultTier: number;
    stats: Record<number, Record<StatType, number>>;
    description: Record<number, string>;
}