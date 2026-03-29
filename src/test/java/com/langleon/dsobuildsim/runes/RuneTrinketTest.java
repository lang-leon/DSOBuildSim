package com.langleon.dsobuildsim.runes;

import tools.jackson.databind.ObjectMapper;
import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.runes.enums.RuneType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class RuneTrinketTest {

    private RuneFactory runeFactory;

    @BeforeEach
    void setup() throws IOException
    {
        try (var reader = new InputStreamReader(Objects.requireNonNull(getClass().getResourceAsStream("/gamedata/runes.json"))))
        {
            ObjectMapper objectMapper = new ObjectMapper();
            RuneConfig dragonStoneConfig = objectMapper.readValue(reader, RuneConfig.class);
            runeFactory = new RuneFactory(dragonStoneConfig);
        }
    }

    @Test
    void testRuneTrinketCreation()
    {
        List<Rune> runesActual = new ArrayList<>();
        runesActual.add(runeFactory.createRune(RuneType.VIGOR, 3));
        runesActual.add(runeFactory.createRune(RuneType.WINTER,5));
        runesActual.add(runeFactory.createRune(RuneType.VITALITY, 2));
        RuneTrinket runeTrinket = new RuneTrinket(runesActual);
        List<Rune> runes = runeTrinket.getRunes();
        Assertions.assertNotNull(runes);
        Assertions.assertEquals(runeFactory.createRune(RuneType.VIGOR, 3), runes.getFirst());
        Assertions.assertEquals(runeFactory.createRune(RuneType.WINTER,5), runes.get(1));
        Assertions.assertEquals(runeFactory.createRune(RuneType.VITALITY, 2), runes.get(2));
    }

    @Test
    void testGetTotalStats()
    {
        List<Rune> runes = new ArrayList<>();
        runes.add(runeFactory.createRune(RuneType.VIGOR, 5));
        runes.add(runeFactory.createRune(RuneType.VIGOR, 5));
        runes.add(runeFactory.createRune(RuneType.DEVASTATION, 1));
        runes.add(runeFactory.createRune(RuneType.CELERITY, 2));
        runes.add(runeFactory.createRune(RuneType.CELERITY, 2));
        runes.add(runeFactory.createRune(RuneType.VITALITY, 5));
        runes.add(runeFactory.createRune(RuneType.WINTER, 5));
        runes.add(runeFactory.createRune(RuneType.WINTER, 5));
        runes.add(runeFactory.createRune(RuneType.WINTER, 5));
        runes.add(runeFactory.createRune(RuneType.ACCELERATION, 2));
        RuneTrinket runeTrinket = new RuneTrinket(runes);
        Map<StatType, Double> stats = runeTrinket.getTotalRelativeStats();
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
        Assertions.assertEquals(0.13, stats.get(StatType.DAMAGE), 1e-9);
        Assertions.assertEquals(0.052, stats.get(StatType.ATTACK_SPEED), 1e-9);
    }
}
