package com.langleon.dsobuildsim.essences;

public class EssenceFactory {
    private final EssenceConfig config;

    public EssenceFactory(EssenceConfig config) {
        this.config = config;
    }

    public Essence createEssence(EssenceType essenceType, int tier){
        EssenceDefinition essenceDefinition = config.essences().get(essenceType);
        if (!essenceDefinition.damagePerTier().containsKey(tier)) throw new IllegalArgumentException("Invalid pet tier: " + tier + "!");
        return new Essence(essenceType, tier, essenceDefinition.damagePerTier().get(tier), essenceDefinition.descriptionPerTier().get(tier));
    }

    public Essence createEssence(EssenceType essenceType){
        EssenceDefinition essenceDefinition = config.essences().get(essenceType);
        int tier = essenceDefinition.defaultTier();
        if (!essenceDefinition.damagePerTier().containsKey(tier)) throw new IllegalArgumentException("Invalid pet tier: " + tier + "!");
        return new Essence(essenceType, tier, essenceDefinition.damagePerTier().get(tier), essenceDefinition.descriptionPerTier().get(tier));
    }
}
