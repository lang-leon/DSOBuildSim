package com.langleon.dsobuildsim.wisdomskilltree;


import com.langleon.dsobuildsim.wisdomskilltree.dto.definition.WisdomGroupDefinitionDTO;
import com.langleon.dsobuildsim.wisdomskilltree.dto.definition.WisdomSkillDefinitionDTO;
import com.langleon.dsobuildsim.wisdomskilltree.dto.definition.WisdomSkillTreeDefinitionDTO;
import com.langleon.dsobuildsim.wisdomskilltree.wisdomgroup.WisdomGroupDefinition;
import com.langleon.dsobuildsim.wisdomskilltree.wisdomgroup.WisdomGroupType;
import com.langleon.dsobuildsim.wisdomskilltree.wisdomskill.WisdomSkillDefinition;
import com.langleon.dsobuildsim.wisdomskilltree.wisdomskill.WisdomSkillType;

import java.util.EnumMap;

public class WisdomSkillTreeMapper {

    public static WisdomSkillDefinitionDTO from(WisdomSkillDefinition definition)
    {
        return new WisdomSkillDefinitionDTO(definition.wisdomSkillType(), definition.name(), definition.maxLevel(), 0, definition.costPerLevel(), definition.statType(), definition.increasePerLevel(), definition.firstLevelBonus(), definition.description());
    }

    public static WisdomGroupDefinitionDTO from(WisdomGroupDefinition definition, WisdomSkillTreeConfig config)
    {
        EnumMap<WisdomSkillType, WisdomSkillDefinitionDTO> skillDTOs = new EnumMap<>(WisdomSkillType.class);
        definition.wisdomSkills().forEach((k) -> skillDTOs.put(k, from(config.wisdomSkills().get(k))));

        return new WisdomGroupDefinitionDTO(definition.wisdomGroupType(), definition.name(), definition.maxLevel(), skillDTOs);
    }

    public static WisdomSkillTreeDefinitionDTO from (WisdomSkillTreeConfig config)
    {
        EnumMap<WisdomGroupType, WisdomGroupDefinitionDTO> wisdomGroups = new EnumMap<>(WisdomGroupType.class);

        config.wisdomGroups().forEach((k, v) -> wisdomGroups.put(k, from(v, config)));

        return new WisdomSkillTreeDefinitionDTO(wisdomGroups);
    }
}
