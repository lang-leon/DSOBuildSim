package kaukasus.Runes;

import kaukasus.Enums.OverallRelativeBuffTypeEnum;

import java.util.Map;

public class SpecialRune extends AbstractRune{

    private final Map<OverallRelativeBuffTypeEnum, Double> buffs;
    private final String description;

    public SpecialRune(String name, Map<OverallRelativeBuffTypeEnum, Double> buffs, String description) {
        this.name = name;
        this.buffs = buffs;
        this.description = description;
    }

    public Map<OverallRelativeBuffTypeEnum, Double> getBuffs() {
        return buffs;
    }

    public String getDescription() {
        return description;
    }
}
