package com.langleon.dsobuildsim.resolver;

import com.langleon.dsobuildsim.dto.WisdomSkillTreeDTO;
import com.langleon.dsobuildsim.wisdomskilltree.WisdomSkillTree;
import com.langleon.dsobuildsim.wisdomskilltree.WisdomSkillTreeFactory;
import com.langleon.dsobuildsim.wisdomskilltree.wisdomgroup.WisdomGroup;
import com.langleon.dsobuildsim.wisdomskilltree.wisdomskill.WisdomSkill;

public class WisdomSkillTreeResolver {

    private final WisdomSkillTreeFactory wisdomFactory;

    public WisdomSkillTreeResolver(WisdomSkillTreeFactory wisdomFactory) {
        this.wisdomFactory = wisdomFactory;
    }

    private WisdomSkillTree resolveWisdomSkillTree(WisdomSkillTreeDTO wisdomSkillTreeDTO)
    {
        WisdomSkillTree wisdomSkillTree = wisdomFactory.createTree();

        wisdomSkillTreeDTO.wisdomGroups().forEach((groupType, groupDTO) -> {
            WisdomGroup group = wisdomSkillTree.getWisdomGroups().get(groupType);

            groupDTO.wisdomSkills().forEach((skillType, wisdomSkillDTO) -> {
                WisdomSkill wisdomSkill = group.getWisdomSkills().get(skillType);

                if (wisdomSkill != null) wisdomSkill.setCurrentLevel(wisdomSkillDTO.currentLevel());
            });
        });

        return wisdomSkillTree;
    }
}
