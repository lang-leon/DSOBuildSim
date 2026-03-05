package com.langleon.dsobuildsim.jewels;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.langleon.dsobuildsim.dragonstones.DragonCrestTrinket;
import com.langleon.dsobuildsim.enums.StatType;
import com.langleon.dsobuildsim.enums.jewels.JewelType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class JewelTrinketTest {

    private JewelFactory jewelFactory;

    @BeforeEach
    void setup() throws IOException
    {
        try (var reader = new InputStreamReader(getClass().getResourceAsStream("/data/jewels.json")))
        {
            ObjectMapper objectMapper = new ObjectMapper();
            JewelConfig jewelConfig = objectMapper.readValue(reader, JewelConfig.class);
            jewelFactory = new JewelFactory(jewelConfig);
        }
    }

    @Test
    void testDragonCrestCreation()
    {
        DragonCrestTrinket jewelTrinket = new DragonCrestTrinket();
        Assertions.assertNotNull(jewelTrinket);
    }

    @Test
    void testAddJewels()
    {
        JewelTrinket jewelTrinket = new JewelTrinket();
        jewelTrinket.addJewel(jewelFactory.createJewel(JewelType.VIGOR, 5),2);
        jewelTrinket.addJewel(jewelFactory.createJewel(JewelType.GEM_FORTUNE,4),9);
        jewelTrinket.addJewel(jewelFactory.createJewel(JewelType.FOCUS,5),3);
        Jewel[] jewels = jewelTrinket.getJewels();
        Assertions.assertNotNull(jewels);
        Assertions.assertEquals(jewelFactory.createJewel(JewelType.VIGOR, 5), jewels[2]);
        Assertions.assertEquals(jewelFactory.createJewel(JewelType.GEM_FORTUNE,4), jewels[9]);
        Assertions.assertEquals(jewelFactory.createJewel(JewelType.FOCUS,5), jewels[3]);
        Assertions.assertNull(jewels[1]);
        Assertions.assertEquals(jewelFactory.createJewel(JewelType.VIGOR, 5), jewelTrinket.getJewel(2));
        Assertions.assertEquals(jewelFactory.createJewel(JewelType.GEM_FORTUNE,4), jewelTrinket.getJewel(9));
        Assertions.assertEquals(jewelFactory.createJewel(JewelType.FOCUS,5), jewelTrinket.getJewel(3));
        Assertions.assertNull(jewelTrinket.getJewel(1));
    }

    @Test
    void testRemoveJewels()
    {
        JewelTrinket jewelTrinket = new JewelTrinket();
        jewelTrinket.addJewel(jewelFactory.createJewel(JewelType.VIGOR, 5),2);
        jewelTrinket.addJewel(jewelFactory.createJewel(JewelType.INGREDIENT_HUNTER, 5),9);
        jewelTrinket.addJewel(jewelFactory.createJewel(JewelType.RAGE, 5),3);
        Assertions.assertEquals(jewelFactory.createJewel(JewelType.RAGE, 5), jewelTrinket.getJewel(3));
        jewelTrinket.removeJewel(3);
        Assertions.assertNull(jewelTrinket.getJewel(3));
    }

    @Test
    void testGetTotalStats()
    {
        JewelTrinket jewelTrinket = new JewelTrinket();
        jewelTrinket.addJewel(jewelFactory.createJewel(JewelType.VIGOR, 5),0);
        jewelTrinket.addJewel(jewelFactory.createJewel(JewelType.INGREDIENT_HUNTER, 5),1);
        jewelTrinket.addJewel(jewelFactory.createJewel(JewelType.RAGE, 3),1);
        jewelTrinket.addJewel(jewelFactory.createJewel(JewelType.FOCUS, 3),3);
        jewelTrinket.addJewel(jewelFactory.createJewel(JewelType.FOCUS, 4),4);
        jewelTrinket.addJewel(jewelFactory.createJewel(JewelType.FIERY_FLOWER, 1),5);
        jewelTrinket.addJewel(jewelFactory.createJewel(JewelType.ETERNAL_WRATH, 5),6);
        jewelTrinket.addJewel(jewelFactory.createJewel(JewelType.ETERNAL_SCORN,7),7);
        jewelTrinket.addJewel(jewelFactory.createJewel(JewelType.GEM_FORTUNE, 2),8);
        jewelTrinket.addJewel(jewelFactory.createJewel(JewelType.VITALITY, 5),9);
        Map<StatType, Double> stats = jewelTrinket.getTotalRelativeStats();
        Assertions.assertEquals(3, stats.size());
        Assertions.assertTrue(stats.containsKey(StatType.HEALTH_POINTS));
        Assertions.assertTrue(stats.containsKey(StatType.CRIT_VALUE));
        Assertions.assertTrue(stats.containsKey(StatType.DAMAGE));
        Assertions.assertEquals(0.10, stats.get(StatType.HEALTH_POINTS), 1e-9);
        Assertions.assertEquals(0.15, stats.get(StatType.CRIT_VALUE), 1e-9);
        Assertions.assertEquals(0.10, stats.get(StatType.DAMAGE), 1e-9);
    }
}
