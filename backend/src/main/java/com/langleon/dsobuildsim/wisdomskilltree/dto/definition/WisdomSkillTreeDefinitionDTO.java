package com.langleon.dsobuildsim.wisdomskilltree.dto.definition;

import com.langleon.dsobuildsim.wisdomskilltree.wisdomgroup.WisdomGroupType;

import java.util.EnumMap;

public record WisdomSkillTreeDefinitionDTO(
        EnumMap<WisdomGroupType, WisdomGroupDefinitionDTO> wisdomGroups
) {
}
