package com.langleon.dsobuildsim.gems;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.langleon.dsobuildsim.enums.AbsoluteStatType;
import com.langleon.dsobuildsim.enums.gems.GemLimitGroup;
import com.langleon.dsobuildsim.enums.gems.GemType;
import com.langleon.dsobuildsim.enums.gems.GemUpgradeType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStreamReader;

class GemFactoryTest {

    private GemFactory gemFactory;

    @BeforeEach
    void setup() throws IOException {
        try (var reader = new InputStreamReader(getClass().getResourceAsStream("/data/gems.json")))
        {
            ObjectMapper objectMapper = new ObjectMapper();
            GemConfig gemConfig = objectMapper.readValue(reader, GemConfig.class);
            gemFactory = new GemFactory(gemConfig);
        }
    }

    @Test
    void createRubyTier5()
    {
        Gem gem = gemFactory.createGem(GemType.RUBY, 5);
        Assertions.assertNotNull(gem);
        Assertions.assertEquals(5, gem.getTier());
        Assertions.assertEquals(GemType.RUBY, gem.getGemType());
        Assertions.assertTrue(gem.getStats().containsKey(AbsoluteStatType.DAMAGE));
        Assertions.assertEquals(1, gem.getStats().size());
        Assertions.assertEquals(15, gem.getStats().get(AbsoluteStatType.DAMAGE));
        Assertions.assertEquals(GemLimitGroup.RUBY, gem.getGemLimitGroup());
    }

    @Test
    void testUpgradeCostsOffensive()
    {
        Gem gem = gemFactory.createGem(GemType.RUBY, 5);
        Assertions.assertEquals(GemUpgradeType.OFFENSIVE, gem.getGemUpgradeType());
        Assertions.assertEquals(50, gemFactory.getUpgradeCost(gem));
    }

    @Test
    void testUpgradeCostsDefensive()
    {
        Gem gem = gemFactory.createGem(GemType.AMETHYST, 5);
        Assertions.assertEquals(GemUpgradeType.DEFENSIVE, gem.getGemUpgradeType());
        Assertions.assertEquals(40, gemFactory.getUpgradeCost(gem));
    }

    @Test
    void createOpalTier10()
    {
        Opal opal = gemFactory.createOpal(GemType.RUBY, GemType.ONYX, GemType.RHODOLITE, 10);
        Assertions.assertNotNull(opal);
        Assertions.assertEquals(10, opal.getTier());
        Assertions.assertEquals(GemType.OPAL, opal.getGemType());
        Assertions.assertTrue(opal.getStats().containsKey(AbsoluteStatType.DAMAGE));
        Assertions.assertEquals(3, opal.getStats().size());
        Assertions.assertEquals(84.75, opal.getStats().get(AbsoluteStatType.DAMAGE), 1e-6);
        Assertions.assertEquals(562.5, opal.getStats().get(AbsoluteStatType.CRIT_VALUE), 1e-6);
        Assertions.assertEquals(0.075, opal.getStats().get(AbsoluteStatType.MOVEMENT_SPEED), 1e-6);
    }

    @Test
    void testUpgradeCostsOpal()
    {
        Opal opal = gemFactory.createOpal(GemType.RUBY, GemType.ONYX, GemType.RHODOLITE, 10);
        Assertions.assertEquals(GemUpgradeType.OPAL, opal.getGemUpgradeType());
        Assertions.assertEquals(7875, gemFactory.getUpgradeCost(opal));
    }

    @Test
    void throwsOnInvalidTier()
    {
        Assertions.assertThrows(IllegalArgumentException.class, () -> gemFactory.createGem(GemType.RUBY, -1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> gemFactory.createOpal(GemType.RUBY, GemType.ONYX, GemType.RHODOLITE, 5));
    }
}
