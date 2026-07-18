import { StatType } from "./stat-type";
import { StatsDTO } from "./stats-dto";

export interface ClassStatsDTO{
    absoluteStats: Record<StatType, number>;
    relativeStats: Record<StatType, number>;
}