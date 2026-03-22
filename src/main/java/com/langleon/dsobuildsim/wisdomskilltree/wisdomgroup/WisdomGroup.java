package com.langleon.dsobuildsim.wisdomskilltree.wisdomgroup;

import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.wisdomskilltree.wisdomskill.WisdomSkill;
import com.langleon.dsobuildsim.wisdomskilltree.wisdomskill.WisdomSkillType;

import java.util.EnumMap;

public class WisdomGroup {
    private final WisdomGroupDefinition wisdomGroupDefinition;
    private final EnumMap<WisdomSkillType, WisdomSkill> wisdomSkills;

    public WisdomGroup(WisdomGroupDefinition wisdomGroupDefinition, EnumMap<WisdomSkillType, WisdomSkill> wisdomSkills) {
        this.wisdomGroupDefinition = wisdomGroupDefinition;
        this.wisdomSkills = wisdomSkills;
    }

    public WisdomGroupType getWisdomGroupType() {
        return wisdomGroupDefinition.wisdomGroupType();
    }

    public EnumMap<WisdomSkillType, WisdomSkill> getWisdomSkills() {
        return wisdomSkills;
    }

    public int getMaxLevel() {
        return wisdomGroupDefinition.maxLevel();
    }

    public int getCurrentLevel() {
        return wisdomSkills.values().stream()
                .mapToInt(WisdomSkill::getCurrentLevel)
                .sum();
    }

    public void setSkillLevel(WisdomSkillType type, int skillLevel) {
        if (!wisdomSkills.containsKey(type)) throw new IllegalArgumentException("Wisdom skill of type "+type+" not present in this wisdom group "+wisdomGroupDefinition.wisdomGroupType());
        int currentLevel = this.getCurrentLevel();
        int newCurrentLevel = currentLevel - wisdomSkills.get(type).getCurrentLevel() + skillLevel;
        if (newCurrentLevel > wisdomGroupDefinition.maxLevel() || newCurrentLevel < 0) throw new IllegalArgumentException("Updating skill level would result in invalid group level.");
        wisdomSkills.get(type).setCurrentLevel(skillLevel);
    }

    public EnumMap<StatType, Double> calculateStats()
    {
        EnumMap<StatType, Double> stats = new EnumMap<>(StatType.class);
        wisdomSkills.forEach((_, v) -> stats.putAll(v.calculateTotalStats()));
        return stats;
    }
}
