package com.langleon.dsobuildsim.wisdomskilltree.wisdomskill;

import java.util.EnumMap;

public record WisdomSkillConfig(EnumMap<WisdomSkillType, WisdomSkillDefinition> wisdomSkills) {
}
