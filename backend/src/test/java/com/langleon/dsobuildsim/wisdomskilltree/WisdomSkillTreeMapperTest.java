package com.langleon.dsobuildsim.wisdomskilltree;

import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.gamedata.GameDataConfig;
import com.langleon.dsobuildsim.gamedata.GameDataLoader;
import com.langleon.dsobuildsim.wisdomskilltree.dto.definition.WisdomGroupDefinitionDTO;
import com.langleon.dsobuildsim.wisdomskilltree.dto.definition.WisdomSkillDefinitionDTO;
import com.langleon.dsobuildsim.wisdomskilltree.wisdomgroup.WisdomGroupDefinition;
import com.langleon.dsobuildsim.wisdomskilltree.wisdomgroup.WisdomGroupType;
import com.langleon.dsobuildsim.wisdomskilltree.wisdomskill.WisdomSkillDefinition;
import com.langleon.dsobuildsim.wisdomskilltree.wisdomskill.WisdomSkillType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class WisdomSkillTreeMapperTest {

    private Map<WisdomSkillType, WisdomSkillDefinition> wisdomSkills;
    private Map<WisdomGroupType, WisdomGroupDefinition> wisdomGroups;

    @BeforeEach
    void setup()
    {
        GameDataConfig config = new GameDataLoader().loadGameDataConfig();
        wisdomSkills = config.wisdomSkills();
        wisdomGroups = config.wisdomGroups();
    }

    @Test
    void shouldMapDefinitionToDTO()
    {
        WisdomSkillDefinitionDTO wisdomSkill = WisdomSkillTreeMapper.from(wisdomSkills.get(WisdomSkillType.RISING_POWER));
        WisdomGroupDefinitionDTO wisdomGroup = WisdomSkillTreeMapper.from(wisdomGroups.get(WisdomGroupType.ATTACK));
        Assertions.assertEquals(80, wisdomSkill.maxLevel());
        Assertions.assertEquals(0, wisdomSkill.currentLevel());
        Assertions.assertEquals(StatType.DAMAGE, wisdomSkill.statType());
        Assertions.assertEquals(75, wisdomSkill.increasePerLevel());
        Assertions.assertEquals(0, wisdomSkill.firstLevelBonus());
        Assertions.assertEquals(3, wisdomSkill.costPerLevel());
        Assertions.assertEquals(200, wisdomGroup.maxLevel());
        Assertions.assertEquals(WisdomGroupType.ATTACK, wisdomGroup.type());
    }
}
