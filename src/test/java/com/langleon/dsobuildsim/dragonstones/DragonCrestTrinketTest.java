package com.langleon.dsobuildsim.dragonstones;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.langleon.dsobuildsim.enums.StatType;
import com.langleon.dsobuildsim.enums.dragonstones.DragonStoneType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class DragonCrestTrinketTest {

    private DragonStoneFactory dragonStoneFactory;

    @BeforeEach
    void setup() throws IOException
    {
        try (var reader = new InputStreamReader(getClass().getResourceAsStream("/data/dragonstones.json")))
        {
            ObjectMapper objectMapper = new ObjectMapper();
            DragonStoneConfig dragonStoneConfig = objectMapper.readValue(reader, DragonStoneConfig.class);
            dragonStoneFactory = new DragonStoneFactory(dragonStoneConfig);
        }
    }

    @Test
    void testDragonCrestCreation()
    {
        DragonCrestTrinket dragonCrest = new DragonCrestTrinket();
        Assertions.assertNotNull(dragonCrest);
    }

    @Test
    void testAddDragonStones()
    {
        DragonCrestTrinket dragonCrest = new DragonCrestTrinket();
        dragonCrest.addDragonStone(dragonStoneFactory.createDragonStone(DragonStoneType.POWERSTONE_HATCHLING),2);
        dragonCrest.addDragonStone(dragonStoneFactory.createDragonStone(DragonStoneType.GREEDSTONE_MIGTHY),9);
        dragonCrest.addDragonStone(dragonStoneFactory.createDragonStone(DragonStoneType.RESTLESS_STONE_ELDERS),3);
        DragonStone[] dragonStones = dragonCrest.getDragonStones();
        Assertions.assertNotNull(dragonStones);
        Assertions.assertEquals(dragonStoneFactory.createDragonStone(DragonStoneType.POWERSTONE_HATCHLING), dragonStones[2]);
        Assertions.assertEquals(dragonStoneFactory.createDragonStone(DragonStoneType.GREEDSTONE_MIGTHY), dragonStones[9]);
        Assertions.assertEquals(dragonStoneFactory.createDragonStone(DragonStoneType.RESTLESS_STONE_ELDERS), dragonStones[3]);
        Assertions.assertNull(dragonStones[1]);
        Assertions.assertEquals(dragonStoneFactory.createDragonStone(DragonStoneType.POWERSTONE_HATCHLING), dragonCrest.getDragonStone(2));
        Assertions.assertEquals(dragonStoneFactory.createDragonStone(DragonStoneType.GREEDSTONE_MIGTHY), dragonCrest.getDragonStone(9));
        Assertions.assertEquals(dragonStoneFactory.createDragonStone(DragonStoneType.RESTLESS_STONE_ELDERS), dragonCrest.getDragonStone(3));
        Assertions.assertNull(dragonCrest.getDragonStone(1));
    }

    @Test
    void testRemoveDragonStones()
    {
        DragonCrestTrinket dragonCrest = new DragonCrestTrinket();
        dragonCrest.addDragonStone(dragonStoneFactory.createDragonStone(DragonStoneType.POWERSTONE_HATCHLING),2);
        dragonCrest.addDragonStone(dragonStoneFactory.createDragonStone(DragonStoneType.GREEDSTONE_MIGTHY),9);
        dragonCrest.addDragonStone(dragonStoneFactory.createDragonStone(DragonStoneType.RESTLESS_STONE_ELDERS),3);
        Assertions.assertEquals(dragonStoneFactory.createDragonStone(DragonStoneType.RESTLESS_STONE_ELDERS), dragonCrest.getDragonStone(3));
        dragonCrest.removeDragonStone(3);
        Assertions.assertNull(dragonCrest.getDragonStone(3));
    }

    @Test
    void testGetTotalStats()
    {
        DragonCrestTrinket dragonCrest = new DragonCrestTrinket();
        dragonCrest.addDragonStone(dragonStoneFactory.createDragonStone(DragonStoneType.POWERSTONE_HATCHLING),0);
        dragonCrest.addDragonStone(dragonStoneFactory.createDragonStone(DragonStoneType.POWERSTONE_HATCHLING),1);
        dragonCrest.addDragonStone(dragonStoneFactory.createDragonStone(DragonStoneType.POWERSTONE_MIGTHY),1);
        dragonCrest.addDragonStone(dragonStoneFactory.createDragonStone(DragonStoneType.GREEDSTONE_ELDERS),3);
        dragonCrest.addDragonStone(dragonStoneFactory.createDragonStone(DragonStoneType.GREEDSTONE_ELDERS),4);
        dragonCrest.addDragonStone(dragonStoneFactory.createDragonStone(DragonStoneType.GREEDSTONE_ELDERS),5);
        dragonCrest.addDragonStone(dragonStoneFactory.createDragonStone(DragonStoneType.FURYSTONE_ELDERS),6);
        dragonCrest.addDragonStone(dragonStoneFactory.createDragonStone(DragonStoneType.FURYSTONE_ELDERS),7);
        dragonCrest.addDragonStone(dragonStoneFactory.createDragonStone(DragonStoneType.RESTLESS_STONE_ELDERS),8);
        dragonCrest.addDragonStone(dragonStoneFactory.createDragonStone(DragonStoneType.RESTLESS_STONE_ELDERS),9);
        Map<StatType, Double> stats = dragonCrest.getTotalRelativeStats();
        Assertions.assertEquals(4, stats.size());
        Assertions.assertTrue(stats.containsKey(StatType.HEALTH_POINTS));
        Assertions.assertTrue(stats.containsKey(StatType.ANDERMANT_DROP_BONUS));
        Assertions.assertTrue(stats.containsKey(StatType.DAMAGE));
        Assertions.assertTrue(stats.containsKey(StatType.ATTACK_SPEED));
        Assertions.assertEquals(0.075, stats.get(StatType.HEALTH_POINTS), 1e-9);
        Assertions.assertEquals(0.06, stats.get(StatType.ANDERMANT_DROP_BONUS), 1e-9);
        Assertions.assertEquals(-0.03, stats.get(StatType.DAMAGE), 1e-9);
        Assertions.assertEquals(0.09, stats.get(StatType.ATTACK_SPEED), 1e-9);
    }

}
