import { StatType } from "../../enums/StatType";

export interface SetDTO {
    setType: string;
    name: string;
    level: number;
    setItems: string[];
    baseValuesPerTier: Record<string, Record<StatType, number>>;
    relativeValuesPerTier: Record<string, Record<StatType, number>>;
    descriptionPerTier: Record<string, string>;
}