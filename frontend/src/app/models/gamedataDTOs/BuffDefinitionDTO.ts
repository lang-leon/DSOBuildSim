import { StatType } from "../../enums/StatType";

export interface BuffDefinitionDTO {
    type: string;
    name: string;
    defaultTier: number;
    statType: StatType;
    statsPerTier: Record<string, number>
}