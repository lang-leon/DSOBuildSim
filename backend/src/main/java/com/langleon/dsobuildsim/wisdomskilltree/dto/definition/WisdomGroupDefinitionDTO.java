package com.langleon.dsobuildsim.wisdomskilltree.dto.definition;

import com.langleon.dsobuildsim.wisdomskilltree.wisdomgroup.WisdomGroupType;
import com.langleon.dsobuildsim.wisdomskilltree.wisdomskill.WisdomSkillType;

import java.util.List;

public record WisdomGroupDefinitionDTO(
        WisdomGroupType type,
        String name,
        int maxLevel,
        List<WisdomSkillType> wisdomSkills
        ) {
}
