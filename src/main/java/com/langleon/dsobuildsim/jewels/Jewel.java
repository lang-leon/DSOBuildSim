package com.langleon.dsobuildsim.jewels;

import com.langleon.dsobuildsim.enums.jewels.JewelType;
import com.langleon.dsobuildsim.enums.StatType;

import java.util.Map;

public class Jewel {
    private final int tier;
    private final JewelType jewelType;
    private final String description;
    private final Map<StatType, Double> stats;

    public Jewel(JewelType jewelType, int tier, Map<StatType, Double> stats, String description) {
        this.tier = tier;
        this.jewelType = jewelType;
        this.description = description;
        this.stats = stats;
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
        return this.jewelType+tierName;
    }

    public int getTier() {
        return tier;
    }

    public JewelType getJewelType() {
        return jewelType;
    }

    public String getDescription() {
        return description;
    }

    public Map<StatType, Double> getStats() {
        return stats;
    }
}
