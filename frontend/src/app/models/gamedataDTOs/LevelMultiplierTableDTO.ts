import { StatType } from '../../enums/StatType';

export interface LevelMultiplierTableDTO {
  multipliersPerLevel: Record<number, Partial<Record<StatType, number>>>;
}
