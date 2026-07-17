package com.langleon.dsobuildsim.wisdomskilltree.dto.definition;

import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.wisdomskilltree.wisdomskill.WisdomSkillType;

public record WisdomSkillDefinitionDTO(
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
