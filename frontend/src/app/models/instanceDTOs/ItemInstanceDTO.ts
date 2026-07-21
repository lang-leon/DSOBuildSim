import { StatType } from "../../enums/StatType";
import { EnchantmentDTO } from "../gamedataDTOs/EnchantmentDTO";
import { GemInstanceDTO } from "./GemInstanceDTO";

export interface ItemInstanceDTO {
    itemCategory: string;
    itemType: string;
    level: number;
    baseValues: Record<StatType, number>;
    gems: GemInstanceDTO[];
    enchantments: EnchantmentDTO[];

    //optional fields depending on item category
    uniqueBaseValues: Record<string, number>;
    uniqueEnchantments: EnchantmentDTO[];
}