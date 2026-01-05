package com.langleon.dsobuildsim.runes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.langleon.dsobuildsim.enums.StatType;
import com.langleon.dsobuildsim.enums.runes.RuneType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class RuneTrinketTest {

    private RuneFactory dragonStoneFactory;

    @BeforeEach
    void setup() throws IOException
    {
        try (var reader = new InputStreamReader(getClass().getResourceAsStream("/data/runes.json")))
        {
            ObjectMapper objectMapper = new ObjectMapper();
            RuneConfig dragonStoneConfig = objectMapper.readValue(reader, RuneConfig.class);
            dragonStoneFactory = new RuneFactory(dragonStoneConfig);
        }
    }

    @Test
    void testDragonCrestCreation()
    {
        RuneTrinket runeTrinket = new RuneTrinket();
        Assertions.assertNotNull(runeTrinket);
    }

    @Test
    void testAddRunes()
    {
        RuneTrinket runeTrinket = new RuneTrinket();
        runeTrinket.addRune(dragonStoneFactory.createRune(RuneType.VIGOR, 3),2);
        runeTrinket.addRune(dragonStoneFactory.createRune(RuneType.WINTER,5),9);
        runeTrinket.addRune(dragonStoneFactory.createRune(RuneType.VITALITY, 2),3);
        Rune[] runes = runeTrinket.getRunes();
        Assertions.assertNotNull(runes);
        Assertions.assertEquals(dragonStoneFactory.createRune(RuneType.VIGOR, 3), runes[2]);
        Assertions.assertEquals(dragonStoneFactory.createRune(RuneType.WINTER,5), runes[9]);
        Assertions.assertEquals(dragonStoneFactory.createRune(RuneType.VITALITY, 2), runes[3]);
        Assertions.assertNull(runes[1]);
        Assertions.assertEquals(dragonStoneFactory.createRune(RuneType.VIGOR, 3), runeTrinket.getRune(2));
        Assertions.assertEquals(dragonStoneFactory.createRune(RuneType.WINTER, 5), runeTrinket.getRune(9));
        Assertions.assertEquals(dragonStoneFactory.createRune(RuneType.VITALITY, 2), runeTrinket.getRune(3));
        Assertions.assertNull(runeTrinket.getRune(1));
    }

    @Test
    void testRemoveRunes()
    {
        RuneTrinket runeTrinket = new RuneTrinket();
        runeTrinket.addRune(dragonStoneFactory.createRune(RuneType.VIGOR, 3),2);
        runeTrinket.addRune(dragonStoneFactory.createRune(RuneType.WINTER,5),9);
        runeTrinket.addRune(dragonStoneFactory.createRune(RuneType.VITALITY, 2),3);
        Assertions.assertEquals(dragonStoneFactory.createRune(RuneType.VITALITY, 2), runeTrinket.getRunes()[3]);
        runeTrinket.removeRune(3);
        Assertions.assertNull(runeTrinket.getRune(3));
    }

    @Test
    void testGetTotalStats()
    {
        RuneTrinket runeTrinket = new RuneTrinket();
        runeTrinket.addRune(dragonStoneFactory.createRune(RuneType.VIGOR, 5),0);
        runeTrinket.addRune(dragonStoneFactory.createRune(RuneType.VIGOR, 5),1);
        runeTrinket.addRune(dragonStoneFactory.createRune(RuneType.DEVASTATION, 1),1);
        runeTrinket.addRune(dragonStoneFactory.createRune(RuneType.CELERITY, 2),3);
        runeTrinket.addRune(dragonStoneFactory.createRune(RuneType.CELERITY, 2),4);
        runeTrinket.addRune(dragonStoneFactory.createRune(RuneType.VITALITY, 5),5);
        runeTrinket.addRune(dragonStoneFactory.createRune(RuneType.WINTER, 5),6);
        runeTrinket.addRune(dragonStoneFactory.createRune(RuneType.WINTER, 5),7);
        runeTrinket.addRune(dragonStoneFactory.createRune(RuneType.WINTER, 5),8);
        runeTrinket.addRune(dragonStoneFactory.createRune(RuneType.ACCELERATION, 2),9);
        Map<StatType, Double> stats = runeTrinket.getTotalStats();
        Assertions.assertEquals(6, stats.size());
        Assertions.assertTrue(stats.containsKey(StatType.HEALTH_POINTS));
        Assertions.assertTrue(stats.containsKey(StatType.CRIT_VALUE));
        Assertions.assertTrue(stats.containsKey(StatType.ICE_RESISTANCE));
        Assertions.assertTrue(stats.containsKey(StatType.MOVEMENT_SPEED));
        Assertions.assertTrue(stats.containsKey(StatType.DAMAGE));
        Assertions.assertTrue(stats.containsKey(StatType.ATTACK_SPEED));
        Assertions.assertEquals(0.26, stats.get(StatType.HEALTH_POINTS), 1e-9);
        Assertions.assertEquals(0.208, stats.get(StatType.CRIT_VALUE), 1e-9);
        Assertions.assertEquals(0.195, stats.get(StatType.ICE_RESISTANCE), 1e-9);
        Assertions.assertEquals(0.026, stats.get(StatType.MOVEMENT_SPEED), 1e-9);
        Assertions.assertEquals(0.065, stats.get(StatType.DAMAGE), 1e-9);
        Assertions.assertEquals(0.052, stats.get(StatType.ATTACK_SPEED), 1e-9);
    }
}
