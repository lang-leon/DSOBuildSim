package com.langleon.dsobuildsim.runes;

import com.langleon.dsobuildsim.enums.runes.RuneType;
import com.langleon.dsobuildsim.enums.runes.RuneUpgradeType;

public class RuneFactory {
    private final RuneConfig config;

    public RuneFactory(RuneConfig config) {
        this.config = config;
    }

    public int getUpgradeCost(Rune rune)
    {
        switch (rune.getRuneUpgradeType())
        {
            case RuneUpgradeType.OFFENSIVE -> {
                return this.config.offensiveUpgradeCosts().get(rune.getTier());
            }
            case RuneUpgradeType.DEFENSIVE, RuneUpgradeType.GROUP -> {
                return this.config.defensiveUpgradeCosts().get(rune.getTier());
            }
            case RuneUpgradeType.BASIC -> {
                return this.config.basicUpgradeCosts().get(rune.getTier());
            }
            default -> {
                return -1;
            }
        }
    }

    public Rune createRune(RuneType runeType, int tier)
    {
        RuneDefinition runeDefinition = this.config.runes().get(runeType);
        if (!runeDefinition.statsPerTier().containsKey(tier)) throw new IllegalArgumentException("Invalid pet tier: " + tier + "!");
        return new Rune(runeType, runeDefinition.runeUpgradeType(), runeDefinition.runeLimitGroup(), tier, runeDefinition.statsPerTier().get(tier), runeDefinition.description());
    }

    public Rune createRune(RuneType runeType)
    {
        RuneDefinition runeDefinition = this.config.runes().get(runeType);
        return new Rune(runeType, runeDefinition.runeUpgradeType(), runeDefinition.runeLimitGroup(), runeDefinition.defaultTier(), runeDefinition.statsPerTier().get(runeDefinition.defaultTier()), runeDefinition.description());
    }
}
