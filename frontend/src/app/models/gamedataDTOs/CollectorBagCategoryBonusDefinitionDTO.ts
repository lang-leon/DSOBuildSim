import { CollectorBagCategory } from "../../enums/CollectorBagCategory";
import { CollectorBagBonusDefinitionDTO } from "./CollectorBagBonusDefinitionDTO";

export interface CollectorBagCategoryBonusDefinitionDTO {
    category: CollectorBagCategory,
    name: string,
    bonuses: CollectorBagBonusDefinitionDTO[];
}