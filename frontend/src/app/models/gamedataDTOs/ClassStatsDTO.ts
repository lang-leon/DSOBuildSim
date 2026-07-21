import { StatType } from "../../enums/StatType";

export interface ClassStatsDTO{
    absoluteStats: Record<StatType, number>;
    relativeStats: Record<StatType, number>;
}