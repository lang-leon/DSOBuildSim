package com.langleon.dsobuildsim.wisdomskilltree.wisdomskill;

import com.langleon.dsobuildsim.common.StatType;

import java.util.Map;

public class WisdomSkill {

    private final WisdomSkillDefinition wisdomSkillDefinition;
    private  int currentLevel;

    public WisdomSkill(WisdomSkillDefinition wisdomSkillDefinition) {
        this.wisdomSkillDefinition = wisdomSkillDefinition;
        this.currentLevel = 0;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int currentLevel) {
        if (currentLevel < 0) throw new IllegalArgumentException("Level can't be lower than 0");
        this.currentLevel = currentLevel;
    }

    public Map<StatType, Double> calculateTotalStats()
    {
        if (wisdomSkillDefinition.statType() == null || this.currentLevel == 0) return Map.of();

        return Map.of(wisdomSkillDefinition.statType(), currentLevel * wisdomSkillDefinition.increasePerLevel() + wisdomSkillDefinition.firstLevelBonus());
    }
}
