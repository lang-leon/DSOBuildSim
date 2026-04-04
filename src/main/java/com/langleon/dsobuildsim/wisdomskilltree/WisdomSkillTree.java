package com.langleon.dsobuildsim.wisdomskilltree;

import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.wisdomskilltree.wisdomgroup.WisdomGroup;
import com.langleon.dsobuildsim.wisdomskilltree.wisdomgroup.WisdomGroupType;

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
}