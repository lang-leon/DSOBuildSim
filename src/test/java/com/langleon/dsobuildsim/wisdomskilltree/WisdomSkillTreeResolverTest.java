package com.langleon.dsobuildsim.wisdomskilltree;

import com.langleon.dsobuildsim.wisdomskilltree.dto.instance.WisdomGroupInstanceDTO;
import com.langleon.dsobuildsim.wisdomskilltree.dto.instance.WisdomSkillInstanceDTO;
import com.langleon.dsobuildsim.wisdomskilltree.dto.instance.WisdomSkillTreeInstanceDTO;
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
import java.util.EnumMap;
import java.util.Objects;

public class WisdomSkillTreeResolverTest {

    private WisdomSkillTreeResolver wisdomSkillTreeResolver;

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
        wisdomSkillTreeResolver = new WisdomSkillTreeResolver(new WisdomSkillTreeFactory(new WisdomSkillTreeConfig(wisdomSkillConfig.wisdomSkills(), wisdomGroupConfig.wisdomGroups())));
    }

    @Test
    void shouldResolveFromWisdomSkillTreeDTOtoWisdomSkillTree()
    {
        EnumMap<WisdomSkillType, WisdomSkillInstanceDTO> health = new EnumMap<>(WisdomSkillType.class);
        health.put(WisdomSkillType.RISING_VIGOR, new WisdomSkillInstanceDTO(WisdomSkillType.RISING_VIGOR, 13));
        health.put(WisdomSkillType.VIVACIOUS_VITALITY, new WisdomSkillInstanceDTO(WisdomSkillType.RISING_VIGOR, 15));
        health.put(WisdomSkillType.CONJURED_DISTILLATION, new WisdomSkillInstanceDTO(WisdomSkillType.RISING_VIGOR, 17));

        EnumMap<WisdomGroupType, WisdomGroupInstanceDTO> wisdomGroups = new EnumMap<>(WisdomGroupType.class);
        wisdomGroups.put(WisdomGroupType.HEALTH_RESOURCE, new WisdomGroupInstanceDTO(WisdomGroupType.HEALTH_RESOURCE, health));

        WisdomSkillTreeInstanceDTO wisdomSkillTreeDTO = new WisdomSkillTreeInstanceDTO(wisdomGroups);
        WisdomSkillTree wisdomSkillTree = wisdomSkillTreeResolver.resolveWisdomSkillTree(wisdomSkillTreeDTO);

        Assertions.assertEquals(8, wisdomSkillTree.getWisdomGroups().size());
        Assertions.assertEquals(3, wisdomSkillTree.getWisdomGroups().get(WisdomGroupType.HEALTH_RESOURCE).getWisdomSkills().size());
        Assertions.assertEquals(WisdomGroupType.HEALTH_RESOURCE, wisdomSkillTree.getWisdomGroups().get(WisdomGroupType.HEALTH_RESOURCE).getWisdomGroupType());
        Assertions.assertEquals(150, wisdomSkillTree.getWisdomGroups().get(WisdomGroupType.HEALTH_RESOURCE).getMaxLevel());
        Assertions.assertEquals(13, wisdomSkillTree.getWisdomGroups().get(WisdomGroupType.HEALTH_RESOURCE).getWisdomSkills().get(WisdomSkillType.RISING_VIGOR).getCurrentLevel());
        Assertions.assertEquals(15, wisdomSkillTree.getWisdomGroups().get(WisdomGroupType.HEALTH_RESOURCE).getWisdomSkills().get(WisdomSkillType.VIVACIOUS_VITALITY).getCurrentLevel());
        Assertions.assertEquals(17, wisdomSkillTree.getWisdomGroups().get(WisdomGroupType.HEALTH_RESOURCE).getWisdomSkills().get(WisdomSkillType.CONJURED_DISTILLATION).getCurrentLevel());
    }
}
