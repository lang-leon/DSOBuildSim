import { StatType } from './stat-type';

export interface StatsDTO {
  stats: Record<StatType, number>;
}