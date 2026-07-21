import { StatType } from "../../enums/StatType";

export interface LevelMultiplierTableDTO {
    multipliersPerLevel: Record<string, Record<StatType, number>>;
}