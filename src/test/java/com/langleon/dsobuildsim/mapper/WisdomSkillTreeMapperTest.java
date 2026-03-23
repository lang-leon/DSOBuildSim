package com.langleon.dsobuildsim.mapper;

import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.dto.WisdomSkillDTO;
import com.langleon.dsobuildsim.dto.WisdomSkillTreeDTO;
import com.langleon.dsobuildsim.wisdomskilltree.WisdomSkillTreeConfig;
import com.langleon.dsobuildsim.wisdomskilltree.wisdomgroup.WisdomGroupConfig;
import com.langleon.dsobuildsim.wisdomskilltree.wisdomgroup.WisdomGroupType;
import com.langleon.dsobuildsim.wisdomskilltree.wisdomskill.WisdomSkillConfig;
import com.langleon.dsobuildsim.wisdomskilltree.wisdomskill.WisdomSkillType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class WisdomSkillTreeMapperTest {

    private WisdomSkillTreeConfig wisdomSkillTreeConfig;

    @BeforeEach
    void setup() throws IOException
    {
        ObjectMapper objectMapper = new ObjectMapper();
        WisdomSkillConfig wisdomSkillConfig;
        WisdomGroupConfig wisdomGroupConfig;
        try (var reader = new InputStreamReader(Objects.requireNonNull(getClass().getResourceAsStream("/gamedata/wisdomSkills.json"))))
        {
            wisdomSkillConfig = objectMapper.readValue(reader, WisdomSkillConfig.class);
        }
        try (var reader = new InputStreamReader(Objects.requireNonNull(getClass().getResourceAsStream("/gamedata/wisdomGroups.json"))))
        {
            wisdomGroupConfig = objectMapper.readValue(reader, WisdomGroupConfig.class);
        }
        wisdomSkillTreeConfig = new WisdomSkillTreeConfig(wisdomSkillConfig.wisdomSkills(), wisdomGroupConfig.wisdomGroups());
    }

    @Test
    void shouldMapDefinitionToDTO()
    {
        WisdomSkillTreeDTO wisdomSkillTreeDTO = WisdomSkillTreeMapper.from(wisdomSkillTreeConfig);

        Assertions.assertEquals(8, wisdomSkillTreeDTO.wisdomGroups().size());
        Assertions.assertEquals(3, wisdomSkillTreeDTO.wisdomGroups().get(WisdomGroupType.ATTACK).wisdomSkills().size());
        WisdomSkillDTO wisdomSkill = wisdomSkillTreeDTO.wisdomGroups().get(WisdomGroupType.ATTACK).wisdomSkills().get(WisdomSkillType.RISING_POWER);
        Assertions.assertEquals(80, wisdomSkill.maxLevel());
        Assertions.assertEquals(0, wisdomSkill.currentLevel());
        Assertions.assertEquals(StatType.DAMAGE, wisdomSkill.statType());
        Assertions.assertEquals(75, wisdomSkill.increasePerLevel());
        Assertions.assertEquals(0, wisdomSkill.firstLevelBonus());
        Assertions.assertEquals(3, wisdomSkill.costPerLevel());
    }
}
