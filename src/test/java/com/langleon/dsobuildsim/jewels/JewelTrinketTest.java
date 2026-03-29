package com.langleon.dsobuildsim.jewels;

import tools.jackson.databind.ObjectMapper;
import com.langleon.dsobuildsim.character.CharacterClass;
import com.langleon.dsobuildsim.dragonstones.DragonCrestTrinket;
import com.langleon.dsobuildsim.common.StatType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Objects;

public class JewelTrinketTest {

    private JewelFactory jewelFactory;

    @BeforeEach
    void setup() throws IOException
    {
        try (var reader = new InputStreamReader(Objects.requireNonNull(getClass().getResourceAsStream("/gamedata/jewels.json"))))
        {
            ObjectMapper objectMapper = new ObjectMapper();
            JewelConfig jewelConfig = objectMapper.readValue(reader, JewelConfig.class);
            jewelFactory = new JewelFactory(jewelConfig);
        }
    }

    @Test
    void testAddJewels()
    {
        JewelTrinket jewelTrinket = new JewelTrinket();
        jewelTrinket.addJewel(jewelFactory.createJewel(JewelType.VIGOR, CharacterClass.SPELLWEAVER, 5),2);
        jewelTrinket.addJewel(jewelFactory.createJewel(JewelType.GEM_FORTUNE, CharacterClass.SPELLWEAVER,4),9);
        jewelTrinket.addJewel(jewelFactory.createJewel(JewelType.FOCUS, CharacterClass.SPELLWEAVER,5),3);
        Jewel[] jewels = jewelTrinket.getJewels();
        Assertions.assertNotNull(jewels);
        Assertions.assertEquals(jewelFactory.createJewel(JewelType.VIGOR, CharacterClass.SPELLWEAVER, 5), jewels[2]);
        Assertions.assertEquals(jewelFactory.createJewel(JewelType.GEM_FORTUNE, CharacterClass.SPELLWEAVER,4), jewels[9]);
        Assertions.assertEquals(jewelFactory.createJewel(JewelType.FOCUS, CharacterClass.SPELLWEAVER,5), jewels[3]);
        Assertions.assertNull(jewels[1]);
        Assertions.assertEquals(jewelFactory.createJewel(JewelType.VIGOR, CharacterClass.SPELLWEAVER, 5), jewelTrinket.getJewel(2));
        Assertions.assertEquals(jewelFactory.createJewel(JewelType.GEM_FORTUNE, CharacterClass.SPELLWEAVER,4), jewelTrinket.getJewel(9));
        Assertions.assertEquals(jewelFactory.createJewel(JewelType.FOCUS, CharacterClass.SPELLWEAVER,5), jewelTrinket.getJewel(3));
        Assertions.assertNull(jewelTrinket.getJewel(1));
    }

    @Test
    void testRemoveJewels()
    {
        JewelTrinket jewelTrinket = new JewelTrinket();
        jewelTrinket.addJewel(jewelFactory.createJewel(JewelType.VIGOR, CharacterClass.SPELLWEAVER, 5),2);
        jewelTrinket.addJewel(jewelFactory.createJewel(JewelType.INGREDIENT_HUNTER, CharacterClass.SPELLWEAVER, 5),9);
        jewelTrinket.addJewel(jewelFactory.createJewel(JewelType.RAGE, CharacterClass.SPELLWEAVER, 5),3);
        Assertions.assertEquals(jewelFactory.createJewel(JewelType.RAGE, CharacterClass.SPELLWEAVER, 5), jewelTrinket.getJewel(3));
        jewelTrinket.removeJewel(3);
        Assertions.assertNull(jewelTrinket.getJewel(3));
    }

    @Test
    void testGetTotalStats()
    {
        JewelTrinket jewelTrinket = new JewelTrinket();
        jewelTrinket.addJewel(jewelFactory.createJewel(JewelType.VIGOR, CharacterClass.SPELLWEAVER, 5),0);
        jewelTrinket.addJewel(jewelFactory.createJewel(JewelType.INGREDIENT_HUNTER, CharacterClass.SPELLWEAVER, 5),1);
        jewelTrinket.addJewel(jewelFactory.createJewel(JewelType.RAGE, CharacterClass.SPELLWEAVER, 3),1);
        jewelTrinket.addJewel(jewelFactory.createJewel(JewelType.FOCUS, CharacterClass.SPELLWEAVER, 3),3);
        jewelTrinket.addJewel(jewelFactory.createJewel(JewelType.FOCUS, CharacterClass.SPELLWEAVER, 4),4);
        jewelTrinket.addJewel(jewelFactory.createJewel(JewelType.FLOWER, CharacterClass.SPELLWEAVER, 1),5);
        jewelTrinket.addJewel(jewelFactory.createJewel(JewelType.ETERNAL_WRATH, CharacterClass.SPELLWEAVER, 5),6);
        jewelTrinket.addJewel(jewelFactory.createJewel(JewelType.ETERNAL_SCORN, CharacterClass.SPELLWEAVER,7),7);
        jewelTrinket.addJewel(jewelFactory.createJewel(JewelType.GEM_FORTUNE, CharacterClass.SPELLWEAVER, 2),8);
        jewelTrinket.addJewel(jewelFactory.createJewel(JewelType.VITALITY, CharacterClass.SPELLWEAVER, 5),9);
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
