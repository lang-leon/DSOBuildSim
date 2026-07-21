import { StatType } from "../../enums/StatType";

export interface RuneDefinitionDTO {
    runeType: string;
    runeLimitGroup: string;
    defaultTier: number;
    statsPerTier: Record<string, Record<StatType, number>>;
    description: string;
}