package com.langleon.dsobuildsim.dragonstones;

import tools.jackson.databind.ObjectMapper;
import com.langleon.dsobuildsim.common.StatType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStreamReader;

public class DragonStoneFactoryTest {

    private DragonStoneFactory dragonStoneFactory;

    @BeforeEach
    void setup() throws IOException
    {
        try (var reader = new InputStreamReader(getClass().getResourceAsStream("/gamedata/dragonstones.json")))
        {
            ObjectMapper objectMapper = new ObjectMapper();
            DragonStoneConfig dragonStoneConfig = objectMapper.readValue(reader, DragonStoneConfig.class);
            dragonStoneFactory = new DragonStoneFactory(dragonStoneConfig);
        }
    }

    @Test
    void createHatchlingsPowerstone()
    {
        DragonStone dragonStone = dragonStoneFactory.createDragonStone(DragonStoneType.POWERSTONE, 3);
        Assertions.assertNotNull(dragonStone);
        Assertions.assertEquals(3, dragonStone.tier());
        Assertions.assertTrue(dragonStone.stats().containsKey(StatType.HEALTH_POINTS));
        Assertions.assertEquals(0.025, dragonStone.stats().get(StatType.HEALTH_POINTS));
        Assertions.assertEquals("+ 2.50% Health Points", dragonStone.description());
    }

    @Test
    void createMightyGreedstone()
    {
        DragonStone dragonStone = dragonStoneFactory.createDragonStone(DragonStoneType.GREEDSTONE, 4);
        Assertions.assertNotNull(dragonStone);
        Assertions.assertEquals(4, dragonStone.tier());
        Assertions.assertTrue(dragonStone.stats().containsKey(StatType.ANDERMANT_DROP_BONUS));
        Assertions.assertEquals(0.01, dragonStone.stats().get(StatType.ANDERMANT_DROP_BONUS));
        Assertions.assertEquals("+ 1% drop stack size of Andermant", dragonStone.description());
    }

    @Test
    void createEldersRestlessStone()
    {
        DragonStone dragonStone = dragonStoneFactory.createDragonStone(DragonStoneType.RESTLESS_STONE, 5);
        Assertions.assertNotNull(dragonStone);
        Assertions.assertEquals(5, dragonStone.tier());
        Assertions.assertTrue(dragonStone.stats().containsKey(StatType.DAMAGE));
        Assertions.assertTrue(dragonStone.stats().containsKey(StatType.ATTACK_SPEED));
        Assertions.assertEquals(-0.015, dragonStone.stats().get(StatType.DAMAGE));
        Assertions.assertEquals(0.015, dragonStone.stats().get(StatType.ATTACK_SPEED));
        Assertions.assertEquals("Condensed from a Dragon Elder's blood, this crystal is brimming with a faint aura of restlessness. With the Dragon Crest inserted, attack speed increases by 1.5%, damage percentage decreases by 1.5%\n- 1.50% damage.", dragonStone.description());
    }
}
