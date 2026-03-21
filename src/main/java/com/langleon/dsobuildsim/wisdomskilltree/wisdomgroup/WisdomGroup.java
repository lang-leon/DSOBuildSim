package com.langleon.dsobuildsim.wisdomskilltree.wisdomgroup;

import com.langleon.dsobuildsim.wisdomskilltree.wisdomskill.WisdomSkill;
import com.langleon.dsobuildsim.wisdomskilltree.wisdomskill.WisdomSkillType;

import java.util.EnumMap;

public class WisdomGroup {
    private final WisdomGroupDefinition wisdomGroupDefinition;
    private final EnumMap<WisdomSkillType, WisdomSkill> wisdomSkills;
    private int currentLevel;

    public WisdomGroup(WisdomGroupDefinition wisdomGroupDefinition, EnumMap<WisdomSkillType, WisdomSkill> wisdomSkills) {
        this.wisdomGroupDefinition = wisdomGroupDefinition;
        this.wisdomSkills = wisdomSkills;
        this.currentLevel = 0;
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
        return currentLevel;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }
}
