package com.langleon.dsobuildsim.resolver;

import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.dto.WisdomGroupDTO;
import com.langleon.dsobuildsim.dto.WisdomSkillDTO;
import com.langleon.dsobuildsim.dto.WisdomSkillTreeDTO;
import com.langleon.dsobuildsim.wisdomskilltree.WisdomSkillTree;
import com.langleon.dsobuildsim.wisdomskilltree.WisdomSkillTreeConfig;
import com.langleon.dsobuildsim.wisdomskilltree.WisdomSkillTreeFactory;
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
        EnumMap<WisdomSkillType, WisdomSkillDTO> health = new EnumMap<>(WisdomSkillType.class);
        health.put(WisdomSkillType.RISING_VIGOR, new WisdomSkillDTO(WisdomSkillType.RISING_VIGOR, "Rising Vigor", 80, 13, 3, StatType.HEALTH_POINTS, 123, 123, ""));
        health.put(WisdomSkillType.VIVACIOUS_VITALITY, new WisdomSkillDTO(WisdomSkillType.RISING_VIGOR, "Vivacious Vitality", 80, 15, 3, StatType.HEALTH_PER_SECOND, 123, 123, ""));
        health.put(WisdomSkillType.CONJURED_DISTILLATION, new WisdomSkillDTO(WisdomSkillType.RISING_VIGOR, "Conjured Distillation", 80, 17, 3, StatType.MANA, 123, 123, ""));

        EnumMap<WisdomGroupType, WisdomGroupDTO> wisdomGroups = new EnumMap<>(WisdomGroupType.class);
        wisdomGroups.put(WisdomGroupType.HEALTH_RESOURCE, new WisdomGroupDTO(WisdomGroupType.HEALTH_RESOURCE, "Health/Resource", 150, health));

        WisdomSkillTreeDTO wisdomSkillTreeDTO = new WisdomSkillTreeDTO(wisdomGroups);
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
