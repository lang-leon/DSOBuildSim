package com.langleon.dsobuildsim.runes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.runes.enums.RuneLimitGroup;
import com.langleon.dsobuildsim.runes.enums.RuneType;
import com.langleon.dsobuildsim.runes.enums.RuneUpgradeType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStreamReader;

class RuneFactoryTest {

    private RuneFactory runeFactory;

    @BeforeEach
    void setup() throws IOException {
        try (var reader = new InputStreamReader(getClass().getResourceAsStream("/data/runes.json")))
        {
            ObjectMapper objectMapper = new ObjectMapper();
            RuneConfig runeConfig = objectMapper.readValue(reader, RuneConfig.class);
            runeFactory = new RuneFactory(runeConfig);
        }
    }

    @Test
    void createVigorTier5()
    {
        Rune rune = runeFactory.createRune(RuneType.VIGOR, 5);
        Assertions.assertNotNull(rune);
        Assertions.assertEquals(5, rune.getTier());
        Assertions.assertEquals(RuneType.VIGOR, rune.getRuneType());
        Assertions.assertTrue(rune.getStats().containsKey(StatType.DAMAGE));
        Assertions.assertEquals(1, rune.getStats().size());
        Assertions.assertEquals(0.065, rune.getStats().get(StatType.DAMAGE));
    }

    @Test
    void createFireResistanceTier4()
    {
        Rune rune = runeFactory.createRune(RuneType.FIRE_RESILIENCE, 4);
        Assertions.assertNotNull(rune);
        Assertions.assertEquals(4, rune.getTier());
        Assertions.assertEquals(RuneType.FIRE_RESILIENCE, rune.getRuneType());
        Assertions.assertTrue(rune.getStats().containsKey(StatType.FIRE_RESISTANCE));
        Assertions.assertEquals(1, rune.getStats().size());
        Assertions.assertEquals(0.052, rune.getStats().get(StatType.FIRE_RESISTANCE));
        Assertions.assertEquals(RuneLimitGroup.RESILIENCE, rune.getRuneLimitGroup());
    }

    @Test
    void testUpgradeCostsOffensive()
    {
        Rune rune = runeFactory.createRune(RuneType.VIGOR, 4);
        Assertions.assertEquals(RuneUpgradeType.OFFENSIVE, rune.getRuneUpgradeType());
        Assertions.assertEquals(28908, runeFactory.getUpgradeCost(rune));
    }

    @Test
    void testUpgradeCostsDefensive()
    {
        Rune rune = runeFactory.createRune(RuneType.VITALITY, 4);
        Assertions.assertEquals(RuneUpgradeType.DEFENSIVE, rune.getRuneUpgradeType());
        Assertions.assertEquals(23126, runeFactory.getUpgradeCost(rune));
    }

    @Test
    void testUpgradeCostsGroup()
    {
        Rune rune = runeFactory.createRune(RuneType.SCHOLAR, 4);
        Assertions.assertEquals(RuneUpgradeType.GROUP, rune.getRuneUpgradeType());
        Assertions.assertEquals(23126, runeFactory.getUpgradeCost(rune));
    }

    @Test
    void testUpgradeCostsBasic()
    {
        Rune rune = runeFactory.createRune(RuneType.INSIGHT, 4);
        Assertions.assertEquals(RuneUpgradeType.BASIC, rune.getRuneUpgradeType());
        Assertions.assertEquals(2313, runeFactory.getUpgradeCost(rune));
    }

    @Test
    void throwsOnInvalidTier()
    {
        Assertions.assertThrows(IllegalArgumentException.class, () -> runeFactory.createRune(RuneType.VIGOR, -1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> runeFactory.createRune(RuneType.HOLY_STAR_SHARD, 5));
    }
}
