import { StatType } from "../../enums/StatType";

export interface PetDefinitionDTO {
    petType: string;
    petCategory: string;
    name: string;
    tier: number;
    stats: Record<number, Record<StatType, number>>;
    description: Record<number, string>;
}