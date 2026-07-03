package com.langleon.dsobuildsim.wisdomskilltree;

import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.gamedata.GameDataConfig;
import com.langleon.dsobuildsim.gamedata.GameDataLoader;
import com.langleon.dsobuildsim.wisdomskilltree.dto.definition.WisdomSkillDefinitionDTO;
import com.langleon.dsobuildsim.wisdomskilltree.dto.definition.WisdomSkillTreeDefinitionDTO;
import com.langleon.dsobuildsim.wisdomskilltree.wisdomgroup.WisdomGroupType;
import com.langleon.dsobuildsim.wisdomskilltree.wisdomskill.WisdomSkillType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WisdomSkillTreeMapperTest {

    private WisdomSkillTreeConfig wisdomSkillTreeConfig;

    @BeforeEach
    void setup()
    {
        GameDataConfig config = new GameDataLoader().loadGameDataConfig();
        wisdomSkillTreeConfig = config.wisdomSkillConfig();
    }

    @Test
    void shouldMapDefinitionToDTO()
    {
        WisdomSkillTreeDefinitionDTO wisdomSkillTreeDTO = WisdomSkillTreeMapper.from(wisdomSkillTreeConfig);

        Assertions.assertEquals(8, wisdomSkillTreeDTO.wisdomGroups().size());
        Assertions.assertEquals(3, wisdomSkillTreeDTO.wisdomGroups().get(WisdomGroupType.ATTACK).wisdomSkills().size());
        WisdomSkillDefinitionDTO wisdomSkill = wisdomSkillTreeDTO.wisdomGroups().get(WisdomGroupType.ATTACK).wisdomSkills().get(WisdomSkillType.RISING_POWER);
        Assertions.assertEquals(80, wisdomSkill.maxLevel());
        Assertions.assertEquals(0, wisdomSkill.currentLevel());
        Assertions.assertEquals(StatType.DAMAGE, wisdomSkill.statType());
        Assertions.assertEquals(75, wisdomSkill.increasePerLevel());
        Assertions.assertEquals(0, wisdomSkill.firstLevelBonus());
        Assertions.assertEquals(3, wisdomSkill.costPerLevel());
    }
}
