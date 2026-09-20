package com.langleon.dsobuildsim.wisdomskilltree;

import com.langleon.dsobuildsim.gamedata.GameDataConfig;
import com.langleon.dsobuildsim.gamedata.GameDataLoader;
import com.langleon.dsobuildsim.wisdomskilltree.dto.instance.WisdomSkillInstanceDTO;
import com.langleon.dsobuildsim.wisdomskilltree.wisdomskill.WisdomSkill;
import com.langleon.dsobuildsim.wisdomskilltree.wisdomskill.WisdomSkillType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class WisdomSkillTreeResolverTest {

    private WisdomSkillTreeResolver wisdomSkillTreeResolver;

    @BeforeEach
    void setup()
    {
        GameDataConfig config = new GameDataLoader().loadGameDataConfig();
        wisdomSkillTreeResolver = new WisdomSkillTreeResolver(new WisdomSkillTreeFactory(config));
    }

    @Test
    void shouldResolveFromWisdomSkillDTOtoWisdomSkill()
    {
        Map<WisdomSkillType, WisdomSkillInstanceDTO> wisdomSkillDTOs = new HashMap<>();
        wisdomSkillDTOs.put(WisdomSkillType.RISING_VIGOR, new WisdomSkillInstanceDTO(WisdomSkillType.RISING_VIGOR, 13));
        wisdomSkillDTOs.put(WisdomSkillType.VIVACIOUS_VITALITY, new WisdomSkillInstanceDTO(WisdomSkillType.VIVACIOUS_VITALITY, 15));
        wisdomSkillDTOs.put(WisdomSkillType.CONJURED_DISTILLATION, new WisdomSkillInstanceDTO(WisdomSkillType.CONJURED_DISTILLATION, 17));

        Map<WisdomSkillType, WisdomSkill> wisdomSkills = wisdomSkillTreeResolver.resolveWisdomSkills(wisdomSkillDTOs);

        Assertions.assertEquals(3, wisdomSkills.size());
        Assertions.assertEquals(13, wisdomSkills.get(WisdomSkillType.RISING_VIGOR).getCurrentLevel());
        Assertions.assertEquals(15, wisdomSkills.get(WisdomSkillType.VIVACIOUS_VITALITY).getCurrentLevel());
        Assertions.assertEquals(17, wisdomSkills.get(WisdomSkillType.CONJURED_DISTILLATION).getCurrentLevel());
    }
}
