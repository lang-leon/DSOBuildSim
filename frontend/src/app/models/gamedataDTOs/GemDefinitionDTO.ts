import { StatType } from "../../enums/StatType";

export interface GemDefinitionDTO {
    gemType: string;
    gemLimitGroup: string;
    gemLimit: number;
    tier: number;
    statType: StatType;
    stats: Record<string, number>;
}