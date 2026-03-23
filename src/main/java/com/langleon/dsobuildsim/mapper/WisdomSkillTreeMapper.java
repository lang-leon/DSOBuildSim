package com.langleon.dsobuildsim.mapper;


import com.langleon.dsobuildsim.dto.WisdomGroupDTO;
import com.langleon.dsobuildsim.dto.WisdomSkillDTO;
import com.langleon.dsobuildsim.dto.WisdomSkillTreeDTO;
import com.langleon.dsobuildsim.wisdomskilltree.WisdomSkillTreeConfig;
import com.langleon.dsobuildsim.wisdomskilltree.wisdomgroup.WisdomGroupDefinition;
import com.langleon.dsobuildsim.wisdomskilltree.wisdomgroup.WisdomGroupType;
import com.langleon.dsobuildsim.wisdomskilltree.wisdomskill.WisdomSkillDefinition;
import com.langleon.dsobuildsim.wisdomskilltree.wisdomskill.WisdomSkillType;

import java.util.EnumMap;

public class WisdomSkillTreeMapper {

    public static WisdomSkillDTO from(WisdomSkillDefinition definition)
    {
        return new WisdomSkillDTO(definition.wisdomSkillType(), definition.name(), definition.maxLevel(), 0, definition.costPerLevel(), definition.statType(), definition.increasePerLevel(), definition.firstLevelBonus(), definition.description());
    }

    public static WisdomGroupDTO from(WisdomGroupDefinition definition, WisdomSkillTreeConfig config)
    {
        EnumMap<WisdomSkillType, WisdomSkillDTO> skillDTOs = new EnumMap<>(WisdomSkillType.class);
        definition.wisdomSkills().forEach((k) -> skillDTOs.put(k, from(config.wisdomSkills().get(k))));

        return new WisdomGroupDTO(definition.wisdomGroupType(), definition.name(), definition.maxLevel(), skillDTOs);
    }

    public static WisdomSkillTreeDTO from (WisdomSkillTreeConfig config)
    {
        EnumMap<WisdomGroupType, WisdomGroupDTO> wisdomGroups = new EnumMap<>(WisdomGroupType.class);

        config.wisdomGroups().forEach((k, v) -> wisdomGroups.put(k, from(v, config)));

        return new WisdomSkillTreeDTO(wisdomGroups);
    }
}
