import { StatType } from "../../enums/StatType";

export interface JewelDefinitionDTO {
    jewelType: string;
    name: string;
    tier: number;
    statsPerTier: Record<string, Record<StatType, number>>;
    descriptionPerTier: Record<string, string>;
}