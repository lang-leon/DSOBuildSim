export interface EssenceDefinitionDTO {
    essenceType: string;
    name: string;
    defaultTier: number;
    damage: Record<string, number>;
    description: Record<string, string>;
}