import { StatType } from '../../enums/StatType';

export interface StatsDTO {
  stats: Record<StatType, number>;
}