package com.langleon.dsobuildsim.jewels;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.langleon.dsobuildsim.enums.OverallRelativeBuffType;
import com.langleon.dsobuildsim.enums.jewels.JewelType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStreamReader;

public class JewelFactoryTest {
    private JewelFactory jewelFactory;

    @BeforeEach
    void setup() throws IOException {
        try (var reader = new InputStreamReader(getClass().getResourceAsStream("/data/jewels.json")))
        {
            ObjectMapper objectMapper = new ObjectMapper();
            JewelConfig jewelConfig = objectMapper.readValue(reader, JewelConfig.class);
            jewelFactory = new JewelFactory(jewelConfig);
        }
    }

    @Test
    void createVigorTier5()
    {
        Jewel jewel = jewelFactory.createJewel(JewelType.VIGOR, 5);
        Assertions.assertNotNull(jewel);
        Assertions.assertEquals(5, jewel.getTier());
        Assertions.assertEquals(JewelType.VIGOR, jewel.getJewelType());
        Assertions.assertTrue(jewel.getStats().containsKey(OverallRelativeBuffType.DAMAGE));
        Assertions.assertEquals(1, jewel.getStats().size());
        Assertions.assertEquals(0.1, jewel.getStats().get(OverallRelativeBuffType.DAMAGE));
    }

    @Test
    void createGemFortune4()
    {
        Jewel jewel = jewelFactory.createJewel(JewelType.GEM_FORTUNE, 4);
        Assertions.assertNotNull(jewel);
        Assertions.assertEquals(4, jewel.getTier());
        Assertions.assertEquals(JewelType.GEM_FORTUNE, jewel.getJewelType());
        Assertions.assertTrue(jewel.getStats().isEmpty());
        Assertions.assertEquals(jewel.getDescription(),"Bosses drop 4 additional gems.");
    }

    @Test
    void testUpgradeCosts()
    {
        Jewel jewel = jewelFactory.createJewel(JewelType.VIGOR, 4);
        Assertions.assertEquals(27750, jewelFactory.getUpgradeCost(jewel));
    }

    @Test
    void throwsOnInvalidTier()
    {
        Assertions.assertThrows(IllegalArgumentException.class, () -> jewelFactory.createJewel(JewelType.VIGOR, -1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> jewelFactory.createJewel(JewelType.BLACK_KNIGHT_ORDER, 5));
    }
}
