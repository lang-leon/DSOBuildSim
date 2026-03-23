package com.langleon.dsobuildsim.wisdomskilltree;

import com.langleon.dsobuildsim.wisdomskilltree.wisdomgroup.WisdomGroup;
import com.langleon.dsobuildsim.wisdomskilltree.wisdomgroup.WisdomGroupDefinition;
import com.langleon.dsobuildsim.wisdomskilltree.wisdomgroup.WisdomGroupType;
import com.langleon.dsobuildsim.wisdomskilltree.wisdomskill.WisdomSkill;
import com.langleon.dsobuildsim.wisdomskilltree.wisdomskill.WisdomSkillDefinition;
import com.langleon.dsobuildsim.wisdomskilltree.wisdomskill.WisdomSkillType;

import java.util.EnumMap;
import java.util.Map;

public class WisdomSkillTreeFactory {

    private final Map<WisdomSkillType, WisdomSkillDefinition> wisdomSkillConfig;
    private final Map<WisdomGroupType, WisdomGroupDefinition> wisdomGroupConfig;

    public WisdomSkillTreeFactory(WisdomSkillTreeConfig config) {
        this.wisdomSkillConfig = new EnumMap<>(config.wisdomSkills());
        this.wisdomGroupConfig = new EnumMap<>(config.wisdomGroups());
    }

    public WisdomSkillTree createTree()
    {
        EnumMap<WisdomGroupType, WisdomGroup> wisdomGroups = new EnumMap<>(WisdomGroupType.class);
        wisdomGroupConfig.forEach((k, _) -> {
            wisdomGroups.put(k, this.createGroup(k));
        });

        return new WisdomSkillTree(wisdomGroups);
    }

    public WisdomGroup createGroup(WisdomGroupType groupType)
    {
        WisdomGroupDefinition wisdomGroupDefinition = this.wisdomGroupConfig.get(groupType);
        EnumMap<WisdomSkillType, WisdomSkill> wisdomSkills = new EnumMap<>(WisdomSkillType.class);
        wisdomGroupDefinition.wisdomSkills().forEach(k -> wisdomSkills.put(k, this.createSkill(k)));
        return new WisdomGroup(wisdomGroupDefinition, wisdomSkills);
    }

    public WisdomSkill createSkill(WisdomSkillType skillType)
    {
        WisdomSkillDefinition wisdomSkillDefinition = this.wisdomSkillConfig.get(skillType);
        return new WisdomSkill(wisdomSkillDefinition);
    }
}
