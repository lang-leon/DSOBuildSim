package com.langleon.dsobuildsim.gems;

import com.langleon.dsobuildsim.enums.AbsoluteStatType;
import com.langleon.dsobuildsim.enums.GemType;
import com.langleon.dsobuildsim.enums.GemUpgradeType;

import java.util.Map;
import java.util.Objects;

public abstract class AbstractGem {

    protected GemType gemType;
    protected int tier;
    protected Map<AbsoluteStatType, Double> stats;

    public GemType getGemType() {
        return gemType;
    }

    public int getTier() {
        return tier;
    }

    public GemUpgradeType getGemUpgradeType() {
        return gemType.getGemUpgradeType();
    }

    public Map<AbsoluteStatType, Double> getStats() {
        return stats;
    }

    public abstract AbstractGem copyGem();

    public String getDisplayName()
    {
        String tierName;
        switch (tier)
        {
            case 1 -> tierName = "Flawed ";
            case 2 -> tierName = "Splintered ";
            case 3 -> tierName = "Simple ";
            case 4 -> tierName = "";
            case 5 -> tierName = "Polished ";
            case 6 -> tierName = "Radiant ";
            case 7 -> tierName = "Flawless ";
            case 8 -> tierName = "Sacred ";
            case 9 -> tierName = "Royal ";
            case 10 -> tierName = "Trapezoid ";
            case 11 -> tierName = "Refined Trapezoid ";
            case 12 -> tierName = "Brilliant Trapezoid ";
            case 13 -> tierName = "Exquisite Trapezoid ";
            case 14 -> tierName = "Imperial ";
            case 15 -> tierName = "Refined Imperial ";
            case 16 -> tierName = "Brilliant Imperial ";
            case 17 -> tierName = "Exquisite Imperial ";
            default -> tierName = "Unknown ";
        }
        return tierName+this.gemType;
    }

    public String toString() {
        String result = getDisplayName() + '\n' +
                "Tier: " + tier +"\n";
        for (Map.Entry<AbsoluteStatType, Double> entry : stats.entrySet())
        {
            result+= entry.getKey()+": "+entry.getValue()+"\n";
        }

        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AbstractGem that = (AbstractGem) o;
        return tier == that.tier && Objects.equals(gemType, that.gemType) && Objects.equals(stats, that.stats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gemType, tier, stats);
    }
}
