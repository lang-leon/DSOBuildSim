package com.langleon.dsobuildsim.dto;

import com.langleon.dsobuildsim.wisdomskilltree.wisdomgroup.WisdomGroupType;

import java.util.EnumMap;

public record WisdomSkillTreeDTO(
        EnumMap<WisdomGroupType, WisdomGroupDTO> wisdomGroups
) {
}
