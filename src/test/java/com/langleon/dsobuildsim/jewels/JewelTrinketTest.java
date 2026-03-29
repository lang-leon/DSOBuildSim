package com.langleon.dsobuildsim.jewels;

import tools.jackson.databind.ObjectMapper;
import com.langleon.dsobuildsim.character.CharacterClass;
import com.langleon.dsobuildsim.common.StatType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
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
        List<Jewel> jewels = new ArrayList<>();
        jewels.add(jewelFactory.createJewel(JewelType.VIGOR, CharacterClass.SPELLWEAVER, 5));
        jewels.add(jewelFactory.createJewel(JewelType.GEM_FORTUNE, CharacterClass.SPELLWEAVER,4));
        jewels.add(jewelFactory.createJewel(JewelType.FOCUS, CharacterClass.SPELLWEAVER,5));
        JewelTrinket jewelTrinket = new JewelTrinket(jewels);
        Assertions.assertNotNull(jewelTrinket.getJewels());
        Assertions.assertEquals(jewelFactory.createJewel(JewelType.VIGOR, CharacterClass.SPELLWEAVER, 5), jewelTrinket.getJewels().getFirst());
        Assertions.assertEquals(jewelFactory.createJewel(JewelType.GEM_FORTUNE, CharacterClass.SPELLWEAVER,4), jewelTrinket.getJewels().get(1));
        Assertions.assertEquals(jewelFactory.createJewel(JewelType.FOCUS, CharacterClass.SPELLWEAVER,5), jewelTrinket.getJewels().get(2));
    }

    @Test
    void testGetTotalStats()
    {
        List<Jewel> jewels = new ArrayList<>();
        jewels.add(jewelFactory.createJewel(JewelType.VIGOR, CharacterClass.SPELLWEAVER, 5));
        jewels.add(jewelFactory.createJewel(JewelType.INGREDIENT_HUNTER, CharacterClass.SPELLWEAVER, 5));
        jewels.add(jewelFactory.createJewel(JewelType.RAGE, CharacterClass.SPELLWEAVER, 3));
        jewels.add(jewelFactory.createJewel(JewelType.FOCUS, CharacterClass.SPELLWEAVER, 3));
        jewels.add(jewelFactory.createJewel(JewelType.FOCUS, CharacterClass.SPELLWEAVER, 4));
        jewels.add(jewelFactory.createJewel(JewelType.FLOWER, CharacterClass.SPELLWEAVER, 1));
        jewels.add(jewelFactory.createJewel(JewelType.ETERNAL_WRATH, CharacterClass.SPELLWEAVER, 5));
        jewels.add(jewelFactory.createJewel(JewelType.ETERNAL_SCORN, CharacterClass.SPELLWEAVER,7));
        jewels.add(jewelFactory.createJewel(JewelType.GEM_FORTUNE, CharacterClass.SPELLWEAVER, 2));
        jewels.add(jewelFactory.createJewel(JewelType.VITALITY, CharacterClass.SPELLWEAVER, 5));
        JewelTrinket jewelTrinket = new JewelTrinket(jewels);
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
