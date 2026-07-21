import { StatType } from "../../enums/StatType";

export interface PetDefinitionDTO {
    petType: string;
    petCategory: string;
    name: string;
    tier: number;
    stats: Record<string, Record<StatType, number>>;
    description: Record<string, string>;
}