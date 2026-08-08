import { CollectorBagBonusType } from "../../enums/CollectorBagBonusType";
import { StatType } from "../../enums/StatType";

export interface CollectorBagBonusDefinitionDTO {
    bonusType: CollectorBagBonusType,
    name: string,
    stats: Record<StatType, number>;
}