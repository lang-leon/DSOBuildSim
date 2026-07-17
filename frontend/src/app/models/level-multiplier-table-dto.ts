import { StatType } from "./stat-type";

export interface LevelMultiplierTableDTO {
    multipliersPerLevel: Record<string, Record<StatType, number>>;
}