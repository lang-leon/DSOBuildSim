package com.langleon.dsobuildsim.wisdomskilltree;

import com.langleon.dsobuildsim.gamedata.GameDataConfig;
import com.langleon.dsobuildsim.wisdomskilltree.wisdomgroup.WisdomGroupDefinition;
import com.langleon.dsobuildsim.wisdomskilltree.wisdomgroup.WisdomGroupType;
import com.langleon.dsobuildsim.wisdomskilltree.wisdomskill.WisdomSkill;
import com.langleon.dsobuildsim.wisdomskilltree.wisdomskill.WisdomSkillDefinition;
import com.langleon.dsobuildsim.wisdomskilltree.wisdomskill.WisdomSkillType;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class WisdomSkillTreeFactory {

    private final Map<WisdomSkillType, WisdomSkillDefinition> wisdomSkills;
    final Map<WisdomGroupType, WisdomGroupDefinition> wisdomGroups;


    public WisdomSkillTreeFactory(GameDataConfig config) {
        this.wisdomSkills = config.wisdomSkills();
        this.wisdomGroups = config.wisdomGroups();
    }

    public WisdomSkill createSkill(WisdomSkillType skillType, int level)
    {
        WisdomSkillDefinition wisdomSkillDefinition = wisdomSkills.get(skillType);
        return new WisdomSkill(wisdomSkillDefinition, level);
    }
}
