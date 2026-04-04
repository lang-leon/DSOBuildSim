package com.langleon.dsobuildsim.wisdomskilltree;

import com.langleon.dsobuildsim.wisdomskilltree.dto.instance.WisdomSkillTreeInstanceDTO;
import com.langleon.dsobuildsim.wisdomskilltree.wisdomgroup.WisdomGroup;
import org.springframework.stereotype.Component;

@Component
public class WisdomSkillTreeResolver {

    private final WisdomSkillTreeFactory wisdomFactory;

    public WisdomSkillTreeResolver(WisdomSkillTreeFactory wisdomFactory) {
        this.wisdomFactory = wisdomFactory;
    }

    public WisdomSkillTree resolveWisdomSkillTree(WisdomSkillTreeInstanceDTO wisdomSkillTreeDTO)
    {
        WisdomSkillTree wisdomSkillTree = wisdomFactory.createTree();

        wisdomSkillTreeDTO.wisdomGroups().forEach((groupType, groupDTO) -> {
            WisdomGroup group = wisdomSkillTree.getWisdomGroups().get(groupType);

            groupDTO.wisdomSkills().forEach((skillType, wisdomSkillDTO) -> {
                group.setSkillLevel(skillType, wisdomSkillDTO.currentLevel());
            });
        });

        return wisdomSkillTree;
    }
}
