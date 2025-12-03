package com.langleon.dsobuildsim.gems;

import com.langleon.dsobuildsim.enums.GemType;

import java.util.Map;

/**
 * Stores gem data like gem definitions (name, isOffensive, statType, statsPerTier) and upgrade costs for offensive and defensive gems.
 */
public class GemFactory {
    private Map<GemType, GemDefinition> gems;
    private Map<Integer, Integer> offensiveUpgradeCosts;
    private Map<Integer, Integer> defensiveUpgradeCosts;
    private Map<Integer, Integer> opalUpgradeCosts;

    public void setGems(Map<GemType, GemDefinition> gems) {
        this.gems = gems;
    }

    public void setOffensiveUpgradeCosts(Map<Integer, Integer> offensiveUpgradeCosts) {
        this.offensiveUpgradeCosts = offensiveUpgradeCosts;
    }

    public void setDefensiveUpgradeCosts(Map<Integer, Integer> defensiveUpgradeCosts) {
        this.defensiveUpgradeCosts = defensiveUpgradeCosts;
    }

    public void setOpalUpgradeCosts(Map<Integer, Integer> opalUpgradeCosts) {
        this.opalUpgradeCosts = opalUpgradeCosts;
    }

    public Map<GemType, GemDefinition> getGems() {
        return gems;
    }

    public GemDefinition getGemDefinition(GemType gemType)
    {
        return this.gems.get(gemType);
    }

    public Integer getUpgradeCost(Gem gem)
    {
        switch (gem.getGemUpgradeType())
        {
            case OFFENSIVE -> {
                return offensiveUpgradeCosts.get(gem.getTier());
            }
            case DEFENSIVE -> {
                return defensiveUpgradeCosts.get(gem.getTier());
            }
            case OPAL -> {
                return opalUpgradeCosts.get(gem.getTier());
            }
            default -> {
                return -1;
            }
        }
    }

    public Gem createGem(GemType gemType, int tier) {
        GemDefinition gemDefinition = gems.get(gemType);
        Double value = gemDefinition.statsPerTier().get(tier);
        if (value == null) throw new IllegalArgumentException("Invalid gem tier: " + tier + "!");
        return new Gem(gemDefinition.gemType(), tier, Map.of(gemDefinition.statType(), gemDefinition.statsPerTier().get(tier)));
    }

    public Opal createOpal(GemType gemType1, GemType gemType2, GemType gemType3, int tier) {
        GemDefinition gemDefinition1 = gems.get(gemType1);
        GemDefinition gemDefinition2 = gems.get(gemType2);
        GemDefinition gemDefinition3 = gems.get(gemType3);
        Double value = gemDefinition1.statsPerTier().get(tier);
        if (value == null) throw new IllegalArgumentException("Invalid gem tier: " + tier + "!");
        return new Opal(tier, Map.of(gemDefinition1.statType(), gemDefinition1.statsPerTier().get(tier), gemDefinition2.statType(), gemDefinition2.statsPerTier().get(tier) , gemDefinition3.statType(), gemDefinition3.statsPerTier().get(tier)));
    }
}
