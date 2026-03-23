package com.langleon.dsobuildsim.dto;

import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.wisdomskilltree.wisdomskill.WisdomSkillType;

public record WisdomSkillDTO(
        WisdomSkillType type,
        String name,
        int maxLevel,
        int currentLevel,
        int costPerLevel,
        StatType statType,
        double increasePerLevel,
        double firstLevelBonus,
        String description
) {
}
