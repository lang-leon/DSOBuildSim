package kaukasus.Runes;

import kaukasus.Enums.OverallBuffTypeEnum;

import java.util.Map;

public class SpecialRune extends AbstractRune{

    private final Map<OverallBuffTypeEnum, Double> buffs;
    private final String description;

    public SpecialRune(String name, Map<OverallBuffTypeEnum, Double> buffs, String description) {
        this.name = name;
        this.buffs = buffs;
        this.description = description;
    }

    public Map<OverallBuffTypeEnum, Double> getBuffs() {
        return buffs;
    }

    public String getDescription() {
        return description;
    }
}
