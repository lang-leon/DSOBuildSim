package com.langleon.dsobuildsim.wisdomskilltree;

import com.langleon.dsobuildsim.wisdomskilltree.dto.definition.WisdomGroupDefinitionDTO;
import com.langleon.dsobuildsim.wisdomskilltree.dto.definition.WisdomSkillDefinitionDTO;
import com.langleon.dsobuildsim.wisdomskilltree.wisdomgroup.WisdomGroupDefinition;
import com.langleon.dsobuildsim.wisdomskilltree.wisdomgroup.WisdomGroupType;
import com.langleon.dsobuildsim.wisdomskilltree.wisdomskill.WisdomSkillDefinition;
import com.langleon.dsobuildsim.wisdomskilltree.wisdomskill.WisdomSkillType;

import java.util.Map;
import java.util.stream.Collectors;

public class WisdomSkillTreeMapper {

    public static WisdomSkillDefinitionDTO from(WisdomSkillDefinition definition)
    {
        return new WisdomSkillDefinitionDTO(definition.wisdomSkillType(), definition.name(), definition.maxLevel(), 0, definition.costPerLevel(), definition.statType(), definition.increasePerLevel(), definition.firstLevelBonus(), definition.statValueAbsolute(), definition.description());
    }

    public static Map<WisdomSkillType, WisdomSkillDefinitionDTO> fromSkills(Map<WisdomSkillType, WisdomSkillDefinition> wisdomSkills)
    {
        return wisdomSkills.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, entry -> WisdomSkillTreeMapper.from(entry.getValue())));
    }

    public static WisdomGroupDefinitionDTO from(WisdomGroupDefinition definition)
    {
        return new WisdomGroupDefinitionDTO(definition.wisdomGroupType(), definition.name(), definition.maxLevel(), definition.wisdomSkills());
    }

    public static Map<WisdomGroupType, WisdomGroupDefinitionDTO> fromGroups(Map<WisdomGroupType, WisdomGroupDefinition> wisdomGroups)
    {
        return wisdomGroups.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, entry -> WisdomSkillTreeMapper.from(entry.getValue())));
    }
}
