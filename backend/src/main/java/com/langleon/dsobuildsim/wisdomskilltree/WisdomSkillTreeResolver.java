package com.langleon.dsobuildsim.wisdomskilltree;

import com.langleon.dsobuildsim.exceptions.LimitExceededException;
import com.langleon.dsobuildsim.exceptions.LimitType;
import com.langleon.dsobuildsim.wisdomskilltree.dto.instance.WisdomSkillInstanceDTO;
import com.langleon.dsobuildsim.wisdomskilltree.wisdomskill.WisdomSkill;
import com.langleon.dsobuildsim.wisdomskilltree.wisdomskill.WisdomSkillType;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class WisdomSkillTreeResolver {

    private final WisdomSkillTreeFactory wisdomFactory;

    public WisdomSkillTreeResolver(WisdomSkillTreeFactory wisdomFactory) {
        this.wisdomFactory = wisdomFactory;
    }

    public Map<WisdomSkillType, WisdomSkill> resolveWisdomSkills(Map<WisdomSkillType, WisdomSkillInstanceDTO> wisdomSkillDTOs)
    {
        Map<WisdomSkillType, WisdomSkill> wisdomSkills = new HashMap<>();
        wisdomSkillDTOs.forEach((k, v) ->
            wisdomSkills.put(v.type(), wisdomFactory.createSkill(v.type(), v.currentLevel()))
        );
        this.validateSkills(wisdomSkills);
        return wisdomSkills;
    }

    private void validateSkills(Map<WisdomSkillType, WisdomSkill> wisdomSkills)
    {
        wisdomFactory.wisdomGroups.forEach((k, v)-> {
            int counter = 0;
            for (WisdomSkillType skill : v.wisdomSkills()) {
                WisdomSkill wisdomSkill = wisdomSkills.get(skill);
                if (wisdomSkill != null) {
                    counter += wisdomSkill.getCurrentLevel();
                }
            }
            if(counter > v.maxLevel()) throw new LimitExceededException(LimitType.WISDOM_GROUP, "Exceeded Wisdom Group "+v.name());
        });
    }
}
