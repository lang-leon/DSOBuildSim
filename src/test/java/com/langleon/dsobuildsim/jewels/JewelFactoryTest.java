package com.langleon.dsobuildsim.jewels;

import tools.jackson.databind.ObjectMapper;
import com.langleon.dsobuildsim.character.CharacterClass;
import com.langleon.dsobuildsim.common.StatType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStreamReader;

public class JewelFactoryTest {
    private JewelFactory jewelFactory;

    @BeforeEach
    void setup() throws IOException {
        try (var reader = new InputStreamReader(getClass().getResourceAsStream("/gamedata/jewels.json")))
        {
            ObjectMapper objectMapper = new ObjectMapper();
            JewelConfig jewelConfig = objectMapper.readValue(reader, JewelConfig.class);
            jewelFactory = new JewelFactory(jewelConfig);
        }
    }

    @Test
    void createVigorTier5()
    {
        Jewel jewel = jewelFactory.createJewel(JewelType.VIGOR, CharacterClass.SPELLWEAVER, 5);
        Assertions.assertNotNull(jewel);
        Assertions.assertEquals(5, jewel.getTier());
        Assertions.assertEquals(JewelType.VIGOR, jewel.getJewelType());
        Assertions.assertTrue(jewel.getStats().containsKey(StatType.DAMAGE));
        Assertions.assertEquals(1, jewel.getStats().size());
        Assertions.assertEquals(0.1, jewel.getStats().get(StatType.DAMAGE));
    }

    @Test
    void createGemFortune4()
    {
        Jewel jewel = jewelFactory.createJewel(JewelType.GEM_FORTUNE, CharacterClass.SPELLWEAVER, 4);
        Assertions.assertNotNull(jewel);
        Assertions.assertEquals(4, jewel.getTier());
        Assertions.assertEquals(JewelType.GEM_FORTUNE, jewel.getJewelType());
        Assertions.assertTrue(jewel.getStats().isEmpty());
        Assertions.assertEquals("Bosses drop 4 additional gems.", jewel.getDescription());
    }

    @Test
    void testUpgradeCosts()
    {
        Jewel jewel = jewelFactory.createJewel(JewelType.VIGOR, CharacterClass.SPELLWEAVER, 4);
        Assertions.assertEquals(27750, jewelFactory.getUpgradeCost(jewel));
    }

    @Test
    void throwsOnInvalidTier()
    {
        Assertions.assertThrows(IllegalArgumentException.class, () -> jewelFactory.createJewel(JewelType.VIGOR, CharacterClass.SPELLWEAVER, -1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> jewelFactory.createJewel(JewelType.BLACK_KNIGHT_ORDER, CharacterClass.SPELLWEAVER, 5));
    }
}
