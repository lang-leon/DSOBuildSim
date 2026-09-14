import { EnchantmentDTO } from "./EnchantmentDTO";
import { StatType } from "../../enums/StatType";
import { ItemSlotType } from "../../enums/ItemSlotType";

export interface ItemDefinitionDTO {
    itemCategory: string;
    itemType: string;
    name: string;
    defaultLevel: number;
    tier: number;
    itemSlotType: ItemSlotType;
    rawBaseValues: Record<StatType, number>;
    //optional fields, might be empty
    uniqueBaseValues: Record<StatType, number>;
    uniqueRelativeValues: Record<StatType, number>;
    uniqueAbsoluteValues: Record<StatType, number>;
    uniqueEnchantments: EnchantmentDTO[];
    uniqueDescription: string;
    set: string;
}