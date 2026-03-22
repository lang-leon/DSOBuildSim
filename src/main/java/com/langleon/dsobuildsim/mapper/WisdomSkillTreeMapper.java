package com.langleon.dsobuildsim.mapper;


import com.langleon.dsobuildsim.dto.WisdomSkillDTO;
import com.langleon.dsobuildsim.wisdomskilltree.wisdomskill.WisdomSkillDefinition;

public class WisdomSkillTreeMapper {

    public static WisdomSkillDTO from(WisdomSkillDefinition definition)
    {
        return new WisdomSkillDTO(definition.wisdomSkillType(), definition.name(), definition.maxLevel(), 0, definition.costPerLevel(), definition.statType(), definition.increasePerLevel(), definition.firstLevelBonus(), definition.description());
    }
}
