package com.langleon.dsobuildsim.runes;

import com.langleon.dsobuildsim.enums.GemUpgradeType;
import com.langleon.dsobuildsim.enums.OverallRelativeBuffType;
import com.langleon.dsobuildsim.enums.RuneType;
import com.langleon.dsobuildsim.enums.RuneUpgradeType;

import java.util.Map;

public class Rune{
    RuneType runeType;
    int tier;
    Map<OverallRelativeBuffType, Double> stats;
    String description;

    public Rune(RuneType runeType, int tier, Map<OverallRelativeBuffType, Double> stats, String description) {
        this.runeType = runeType;
        this.tier = tier;
        this.stats = stats;
        this.description = description;
    }

    public String getDisplayName()
    {
        String tierName;
        switch (tier)
        {
            case 1 -> tierName = " (gray)";
            case 2 -> tierName = " (green)";
            case 3 -> tierName = " (blue)";
            case 4 -> tierName = " (purple)";
            case 5 -> tierName = " (orange)";
            case 6 -> tierName = " (yellow)";
            case 7 -> tierName = " (red)";
            default -> tierName = "";
        }
        return this.runeType+tierName;
    }

    public RuneUpgradeType getRuneUpgradeType() {
        return runeType.getRuneUpgradeType();
    }

    public RuneType getRuneType() {
        return runeType;
    }

    public int getTier() {
        return tier;
    }

    public Map<OverallRelativeBuffType, Double> getStats() {
        return stats;
    }

    public String getDescription() {
        return description;
    }
}