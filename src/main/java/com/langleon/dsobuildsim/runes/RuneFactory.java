package com.langleon.dsobuildsim.runes;

import com.langleon.dsobuildsim.enums.OverallRelativeBuffType;
import com.langleon.dsobuildsim.enums.RuneType;
import com.langleon.dsobuildsim.enums.RuneUpgradeType;

import java.util.Map;

public class RuneFactory {
    private final RuneConfig config;

    public RuneFactory(RuneConfig config) {
        this.config = config;
    }

    public int getUpgradeCost(Rune rune)
    {
        switch (rune.getRuneType().getRuneUpgradeType())
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
        Map<OverallRelativeBuffType, Double> stats = runeDefinition.statsPerTier().get(tier);
        if (stats == null) throw new IllegalArgumentException("Invalid rune tier: " + tier + "!");
        return new Rune(runeType, tier, stats, runeDefinition.description());
    }
}
