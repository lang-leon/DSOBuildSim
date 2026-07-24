export interface EssenceDefinitionDTO {
    essenceType: string;
    name: string;
    defaultTier: number;
    damage: Record<number, number>;
    description: Record<number, string>;
}