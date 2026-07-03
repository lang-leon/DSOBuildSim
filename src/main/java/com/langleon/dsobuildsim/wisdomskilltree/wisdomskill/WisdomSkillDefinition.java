package com.langleon.dsobuildsim.wisdomskilltree.wisdomskill;

import com.langleon.dsobuildsim.common.StatType;

public record WisdomSkillDefinition(WisdomSkillType wisdomSkillType, String name, int maxLevel, int costPerLevel, StatType statType, double increasePerLevel, double firstLevelBonus, String description) {
}
