package com.langleon.dsobuildsim.gems;

import com.langleon.dsobuildsim.gems.enums.GemType;

import java.util.Map;

/**
 * Stores gem data like gem definitions (name, isOffensive, statType, statsPerTier) and upgrade costs for offensive and defensive gems and allows for gem creation.
 */
public class GemFactory {
    private final GemConfig config;

    public GemFactory(GemConfig config) {
        this.config = config;
    }

    public Integer getUpgradeCost(AbstractGem gem)
    {
        switch (gem.getGemUpgradeType())
        {
            case OFFENSIVE -> {
                return this.config.offensiveUpgradeCosts().get(gem.getTier());
            }
            case DEFENSIVE -> {
                return this.config.defensiveUpgradeCosts().get(gem.getTier());
            }
            case OPAL -> {
                return this.config.opalUpgradeCosts().get(gem.getTier());
            }
            default -> {
                return -1;
            }
        }
    }

    public Gem createGem(GemType gemType, int tier) {
        GemDefinition gemDefinition = this.config.gems().get(gemType);
        Double value = gemDefinition.statsPerTier().get(tier);
        if (value == null) throw new IllegalArgumentException("Invalid gem tier: " + tier + "!");
        return new Gem(gemDefinition.gemType(), gemDefinition.gemUpgradeType(), gemDefinition.gemLimitGroup(), tier, Map.of(gemDefinition.statType(), gemDefinition.statsPerTier().get(tier)));
    }

    public Opal createOpal(GemType gemType1, GemType gemType2, GemType gemType3, int tier) {
        GemDefinition gemDefinition1 = this.config.gems().get(gemType1);
        GemDefinition gemDefinition2 = this.config.gems().get(gemType2);
        GemDefinition gemDefinition3 = this.config.gems().get(gemType3);
        if (!(config.opalUpgradeCosts().containsKey(tier) || tier==17)) throw new IllegalArgumentException("Invalid gem tier: " + tier + "!");
        return new Opal(tier, Map.of(gemDefinition1.statType(), gemDefinition1.statsPerTier().get(tier)*0.75, gemDefinition2.statType(), gemDefinition2.statsPerTier().get(tier)*0.75 , gemDefinition3.statType(), gemDefinition3.statsPerTier().get(tier)*0.75));
    }
}
