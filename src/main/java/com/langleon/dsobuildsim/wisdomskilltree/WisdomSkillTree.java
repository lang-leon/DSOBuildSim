package com.langleon.dsobuildsim.wisdomskilltree;

import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.wisdomskilltree.wisdomgroup.WisdomGroup;
import com.langleon.dsobuildsim.wisdomskilltree.wisdomgroup.WisdomGroupType;
import com.langleon.dsobuildsim.wisdomskilltree.wisdomskill.WisdomSkillType;

import java.util.EnumMap;

public class WisdomSkillTree {

    private final EnumMap<WisdomGroupType, WisdomGroup> wisdomGroups;

    public WisdomSkillTree(EnumMap<WisdomGroupType, WisdomGroup> wisdomGroups) {
        this.wisdomGroups = new EnumMap<>(wisdomGroups);
    }

    public EnumMap<WisdomGroupType, WisdomGroup> getWisdomGroups() {
        return wisdomGroups;
    }

    public EnumMap<StatType, Double> calculateStats()
    {
        EnumMap<StatType ,Double> stats = new EnumMap<>(StatType.class);
        wisdomGroups.forEach((_, v) -> {
            stats.putAll(v.calculateStats());
        });
        return stats;
    }

    public void setSkillLevel(WisdomGroupType groupType, WisdomSkillType skillType, int skillLevel) {
        if (!wisdomGroups.containsKey(groupType)) throw new IllegalArgumentException("Wisdom skill tree doesn't contain wisdom group "+groupType);
        wisdomGroups.get(groupType).setSkillLevel(skillType, skillLevel);
    }
}