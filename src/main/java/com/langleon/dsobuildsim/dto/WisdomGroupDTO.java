package com.langleon.dsobuildsim.dto;

import com.langleon.dsobuildsim.wisdomskilltree.wisdomgroup.WisdomGroupType;
import com.langleon.dsobuildsim.wisdomskilltree.wisdomskill.WisdomSkill;
import com.langleon.dsobuildsim.wisdomskilltree.wisdomskill.WisdomSkillType;

import java.util.EnumMap;

public record WisdomGroupDTO(
        WisdomGroupType type,
        String name,
        int maxLevel,
        int currentLevel,
        EnumMap<WisdomSkillType, WisdomSkill> wisdomSkills
        ) {
}
