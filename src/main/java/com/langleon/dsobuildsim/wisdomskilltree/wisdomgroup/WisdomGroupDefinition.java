package com.langleon.dsobuildsim.wisdomskilltree.wisdomgroup;

import com.langleon.dsobuildsim.wisdomskilltree.wisdomskill.WisdomSkillType;

import java.util.List;

public record WisdomGroupDefinition(WisdomGroupType wisdomGroupType, String name, int maxLevel, List<WisdomSkillType> wisdomSkills) {
}
