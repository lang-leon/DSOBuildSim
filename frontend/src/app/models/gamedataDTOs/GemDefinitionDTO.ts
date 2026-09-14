import { StatType } from "../../enums/StatType";

export interface GemDefinitionDTO {
    gemType: string;
    gemLimitGroup: string;
    name: string;
    tier: number;
    statType: StatType;
    stats: Record<string, number>;
}