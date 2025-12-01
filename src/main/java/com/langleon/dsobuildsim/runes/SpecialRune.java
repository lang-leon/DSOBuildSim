package com.langleon.dsobuildsim.runes;

import com.langleon.dsobuildsim.enums.OverallRelativeBuffType;

import java.util.Map;

public class SpecialRune extends AbstractRune{

    private final Map<OverallRelativeBuffType, Double> buffs;
    private final String description;

    public SpecialRune(String name, Map<OverallRelativeBuffType, Double> buffs, String description) {
        this.name = name;
        this.buffs = buffs;
        this.description = description;
    }

    public Map<OverallRelativeBuffType, Double> getBuffs() {
        return buffs;
    }

    public String getDescription() {
        return description;
    }
}
