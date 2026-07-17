package com.langleon.dsobuildsim.wisdomskilltree;

import com.langleon.dsobuildsim.wisdomskilltree.wisdomgroup.WisdomGroupDefinition;
import com.langleon.dsobuildsim.wisdomskilltree.wisdomgroup.WisdomGroupType;
import com.langleon.dsobuildsim.wisdomskilltree.wisdomskill.WisdomSkillDefinition;
import com.langleon.dsobuildsim.wisdomskilltree.wisdomskill.WisdomSkillType;

import java.util.EnumMap;

public record WisdomSkillTreeConfig(EnumMap<WisdomSkillType, WisdomSkillDefinition> wisdomSkills, EnumMap<WisdomGroupType, WisdomGroupDefinition> wisdomGroups) {
}
