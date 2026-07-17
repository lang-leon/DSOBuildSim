import { StatType } from "./stat-type";

export interface GemDefinitionDTO {
    gemType: string;
    gemLimitGroup: string;
    gemLimit: number;
    tier: number;
    statType: StatType;
    stats: Record<string, number>;
}