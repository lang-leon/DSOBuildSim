package com.langleon.dsobuildsim.runes;

import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.runes.enums.RuneLimitGroup;
import com.langleon.dsobuildsim.runes.enums.RuneType;
import com.langleon.dsobuildsim.runes.enums.RuneUpgradeType;

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