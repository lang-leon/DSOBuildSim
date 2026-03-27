package com.langleon.dsobuildsim.wisdomskilltree.dto.instance;

import com.langleon.dsobuildsim.wisdomskilltree.wisdomskill.WisdomSkillType;

public record WisdomSkillInstanceDTO(
        WisdomSkillType type,
        int currentLevel
) {
}
