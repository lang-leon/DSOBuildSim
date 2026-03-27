package com.langleon.dsobuildsim.wisdomskilltree.dto.instance;

import com.langleon.dsobuildsim.wisdomskilltree.wisdomgroup.WisdomGroupType;

import java.util.EnumMap;

public record WisdomSkillTreeInstanceDTO(EnumMap<WisdomGroupType, WisdomGroupInstanceDTO> wisdomGroups) {
}
