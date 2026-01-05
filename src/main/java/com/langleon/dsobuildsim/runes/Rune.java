package com.langleon.dsobuildsim.runes;

import com.langleon.dsobuildsim.enums.StatType;
import com.langleon.dsobuildsim.enums.runes.RuneLimitGroup;
import com.langleon.dsobuildsim.enums.runes.RuneType;
import com.langleon.dsobuildsim.enums.runes.RuneUpgradeType;

import java.util.Map;
import java.util.Objects;

public class Rune{
    private final RuneType runeType;
    private final RuneUpgradeType runeUpgradeType;
    private final RuneLimitGroup runeLimitGroup;
    private final int tier;
    private final Map<StatType, Double> stats;
    private final String description;

    public Rune(RuneType runeType, RuneUpgradeType runeUpgradeType, RuneLimitGroup runeLimitGroup, int tier, Map<StatType, Double> stats, String description) {
        this.runeType = runeType;
        this.runeUpgradeType = runeUpgradeType;
        this.runeLimitGroup = runeLimitGroup;
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
        return runeUpgradeType;
    }

    public RuneLimitGroup getRuneLimitGroup() {
        return runeLimitGroup;
    }

    public RuneType getRuneType() {
        return runeType;
    }

    public int getTier() {
        return tier;
    }

    public Map<StatType, Double> getStats() {
        return stats;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Rune rune = (Rune) o;
        return tier == rune.tier && runeType == rune.runeType && runeUpgradeType == rune.runeUpgradeType && runeLimitGroup == rune.runeLimitGroup && Objects.equals(stats, rune.stats) && Objects.equals(description, rune.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(runeType, runeUpgradeType, runeLimitGroup, tier, stats, description);
    }
}