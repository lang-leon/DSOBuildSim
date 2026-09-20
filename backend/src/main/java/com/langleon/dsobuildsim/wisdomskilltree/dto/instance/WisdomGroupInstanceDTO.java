package com.langleon.dsobuildsim.wisdomskilltree.dto.instance;

import com.langleon.dsobuildsim.wisdomskilltree.wisdomgroup.WisdomGroupType;
import com.langleon.dsobuildsim.wisdomskilltree.wisdomskill.WisdomSkillType;

import java.util.EnumMap;

public record WisdomGroupInstanceDTO(
        WisdomGroupType type,
        EnumMap<WisdomSkillType, WisdomSkillInstanceDTO> wisdomSkills
) {
}
