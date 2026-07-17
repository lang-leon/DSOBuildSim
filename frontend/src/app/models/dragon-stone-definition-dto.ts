import { StatType } from "./stat-type";

export interface DragonStoneDefinitionDTO {
    dragonStoneType: string;
    name: string;
    defaultTier: number;
    stats: Record<string, Record<StatType, number>>;
    description: Record<string, string>;
}