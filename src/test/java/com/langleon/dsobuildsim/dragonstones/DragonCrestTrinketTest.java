package com.langleon.dsobuildsim.dragonstones;

import com.langleon.dsobuildsim.gamedata.GameDataConfig;
import com.langleon.dsobuildsim.gamedata.GameDataLoader;
import com.langleon.dsobuildsim.common.StatType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DragonCrestTrinketTest {

    private DragonStoneFactory dragonStoneFactory;

    @BeforeEach
    void setup()
    {
        GameDataConfig config = new GameDataLoader().loadGameDataConfig();
        dragonStoneFactory = new DragonStoneFactory(config);
    }

    @Test
    void testDragonCrestCreation()
    {
        List<DragonStone> dragonStones = new ArrayList<>();
        dragonStones.add(dragonStoneFactory.createDragonStone(DragonStoneType.POWERSTONE, 3));
        dragonStones.add(dragonStoneFactory.createDragonStone(DragonStoneType.GREEDSTONE, 4));
        dragonStones.add(dragonStoneFactory.createDragonStone(DragonStoneType.RESTLESS_STONE, 5));
        DragonCrestTrinket dragonCrest = new DragonCrestTrinket(dragonStones);

        List<DragonStone> dragonStonesActual = dragonCrest.getDragonStones();
        Assertions.assertNotNull(dragonStonesActual);
        Assertions.assertEquals(3, dragonCrest.getDragonStones().size());
        Assertions.assertEquals(dragonStoneFactory.createDragonStone(DragonStoneType.POWERSTONE, 3), dragonStonesActual.get(0));
        Assertions.assertEquals(dragonStoneFactory.createDragonStone(DragonStoneType.GREEDSTONE, 4), dragonStonesActual.get(1));
        Assertions.assertEquals(dragonStoneFactory.createDragonStone(DragonStoneType.RESTLESS_STONE, 5), dragonStonesActual.get(2));
    }

    @Test
    void testGetTotalStats()
    {
        List<DragonStone> dragonStones = new ArrayList<>();
        dragonStones.add(dragonStoneFactory.createDragonStone(DragonStoneType.POWERSTONE, 3));
        dragonStones.add(dragonStoneFactory.createDragonStone(DragonStoneType.POWERSTONE, 3));
        dragonStones.add(dragonStoneFactory.createDragonStone(DragonStoneType.POWERSTONE, 4));
        dragonStones.add(dragonStoneFactory.createDragonStone(DragonStoneType.GREEDSTONE, 5));
        dragonStones.add(dragonStoneFactory.createDragonStone(DragonStoneType.GREEDSTONE, 5));
        dragonStones.add(dragonStoneFactory.createDragonStone(DragonStoneType.GREEDSTONE, 5));
        dragonStones.add(dragonStoneFactory.createDragonStone(DragonStoneType.FURYSTONE, 5));
        dragonStones.add(dragonStoneFactory.createDragonStone(DragonStoneType.FURYSTONE, 5));
        dragonStones.add(dragonStoneFactory.createDragonStone(DragonStoneType.RESTLESS_STONE, 5));
        dragonStones.add(dragonStoneFactory.createDragonStone(DragonStoneType.RESTLESS_STONE, 5));
        DragonCrestTrinket dragonCrest = new DragonCrestTrinket(dragonStones);
        Map<StatType, Double> stats = dragonCrest.getTotalRelativeStats();
        Assertions.assertEquals(4, stats.size());
        Assertions.assertTrue(stats.containsKey(StatType.HEALTH_POINTS));
        Assertions.assertTrue(stats.containsKey(StatType.ANDERMANT_DROP_BONUS));
        Assertions.assertTrue(stats.containsKey(StatType.DAMAGE));
        Assertions.assertTrue(stats.containsKey(StatType.ATTACK_SPEED));
        Assertions.assertEquals(0.1, stats.get(StatType.HEALTH_POINTS), 1e-9);
        Assertions.assertEquals(0.06, stats.get(StatType.ANDERMANT_DROP_BONUS), 1e-9);
        Assertions.assertEquals(-0.03, stats.get(StatType.DAMAGE), 1e-9);
        Assertions.assertEquals(0.09, stats.get(StatType.ATTACK_SPEED), 1e-9);
    }

    @Test
    void shouldThrowOnElevenOrMoreStones()
    {
        List<DragonStone> dragonStones = new ArrayList<>();
        dragonStones.add(dragonStoneFactory.createDragonStone(DragonStoneType.POWERSTONE, 3));
        dragonStones.add(dragonStoneFactory.createDragonStone(DragonStoneType.POWERSTONE, 3));
        dragonStones.add(dragonStoneFactory.createDragonStone(DragonStoneType.POWERSTONE, 4));
        dragonStones.add(dragonStoneFactory.createDragonStone(DragonStoneType.GREEDSTONE, 5));
        dragonStones.add(dragonStoneFactory.createDragonStone(DragonStoneType.GREEDSTONE, 5));
        dragonStones.add(dragonStoneFactory.createDragonStone(DragonStoneType.GREEDSTONE, 5));
        dragonStones.add(dragonStoneFactory.createDragonStone(DragonStoneType.FURYSTONE, 5));
        dragonStones.add(dragonStoneFactory.createDragonStone(DragonStoneType.FURYSTONE, 5));
        dragonStones.add(dragonStoneFactory.createDragonStone(DragonStoneType.RESTLESS_STONE, 5));
        dragonStones.add(dragonStoneFactory.createDragonStone(DragonStoneType.RESTLESS_STONE, 5));
        dragonStones.add(dragonStoneFactory.createDragonStone(DragonStoneType.RESTLESS_STONE, 5));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new DragonCrestTrinket(dragonStones));
    }

}
