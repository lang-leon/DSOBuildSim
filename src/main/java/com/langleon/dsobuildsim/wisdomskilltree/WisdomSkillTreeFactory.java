package com.langleon.dsobuildsim.wisdomskilltree;

import com.langleon.dsobuildsim.gamedata.GameDataConfig;
import com.langleon.dsobuildsim.wisdomskilltree.wisdomgroup.WisdomGroup;
import com.langleon.dsobuildsim.wisdomskilltree.wisdomgroup.WisdomGroupDefinition;
import com.langleon.dsobuildsim.wisdomskilltree.wisdomgroup.WisdomGroupType;
import com.langleon.dsobuildsim.wisdomskilltree.wisdomskill.WisdomSkill;
import com.langleon.dsobuildsim.wisdomskilltree.wisdomskill.WisdomSkillDefinition;
import com.langleon.dsobuildsim.wisdomskilltree.wisdomskill.WisdomSkillType;
import org.springframework.stereotype.Component;

import java.util.EnumMap;

@Component
public class WisdomSkillTreeFactory {

    private final WisdomSkillTreeConfig config;

    public WisdomSkillTreeFactory(GameDataConfig config) {
        this.config = config.wisdomSkillConfig();
    }

    public WisdomSkillTree createTree()
    {
        EnumMap<WisdomGroupType, WisdomGroup> wisdomGroups = new EnumMap<>(WisdomGroupType.class);
        config.wisdomGroups().forEach((k, _) -> {
            wisdomGroups.put(k, this.createGroup(k));
        });

        return new WisdomSkillTree(wisdomGroups);
    }

    public WisdomGroup createGroup(WisdomGroupType groupType)
    {
        WisdomGroupDefinition wisdomGroupDefinition = config.wisdomGroups().get(groupType);
        EnumMap<WisdomSkillType, WisdomSkill> wisdomSkills = new EnumMap<>(WisdomSkillType.class);
        wisdomGroupDefinition.wisdomSkills().forEach(k -> wisdomSkills.put(k, this.createSkill(k)));
        return new WisdomGroup(wisdomGroupDefinition, wisdomSkills);
    }

    public WisdomSkill createSkill(WisdomSkillType skillType)
    {
        WisdomSkillDefinition wisdomSkillDefinition = this.config.wisdomSkills().get(skillType);
        return new WisdomSkill(wisdomSkillDefinition);
    }
}
