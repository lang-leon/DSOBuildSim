package com.langleon.dsobuildsim.gems;


import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.gems.dto.*;
import com.langleon.dsobuildsim.gems.enums.GemLimitGroup;
import com.langleon.dsobuildsim.gems.enums.GemType;
import com.langleon.dsobuildsim.gems.enums.GemUpgradeType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.Objects;

class GemFactoryTest {

    private GemFactory gemFactory;

    @BeforeEach
    void setup() throws IOException {
        try (var reader = new InputStreamReader(Objects.requireNonNull(getClass().getResourceAsStream("/gamedata/gems.json"))))
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
        Assertions.assertTrue(gem.getStats().containsKey(StatType.DAMAGE));
        Assertions.assertEquals(1, gem.getStats().size());
        Assertions.assertEquals(15, gem.getStats().get(StatType.DAMAGE));
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
        Assertions.assertTrue(opal.getStats().containsKey(StatType.DAMAGE));
        Assertions.assertEquals(3, opal.getStats().size());
        Assertions.assertEquals(84.75, opal.getStats().get(StatType.DAMAGE), 1e-6);
        Assertions.assertEquals(562.5, opal.getStats().get(StatType.CRIT_VALUE), 1e-6);
        Assertions.assertEquals(0.075, opal.getStats().get(StatType.MOVEMENT_SPEED), 1e-6);
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

    @Test
    void shouldResolveGemFromGemDTO()
    {
        GemInstanceDTO gemDTO = new GemInstanceDTO(GemType.RUBY, 16);

        AbstractGem gem = gemFactory.fromDTO(gemDTO);

        Assertions.assertEquals(GemType.RUBY, gem.getGemType());
        Assertions.assertEquals(16, gem.getTier());
        Assertions.assertEquals(Map.of(StatType.DAMAGE, 600.0), gem.getStats());
    }

    @Test
    void shouldResolveGemsFromGemDTOs()
    {
        GemInstanceDTO gemDTO1 = new GemInstanceDTO(GemType.RUBY, 16);
        GemInstanceDTO gemDTO2 = new GemInstanceDTO(GemType.AMETHYST, 16);
        List<AbstractGemInstanceDTO> gemDTOs = List.of(gemDTO1, gemDTO2);
        List<AbstractGem> gems = gemFactory.fromDTOList(gemDTOs);

        Assertions.assertEquals(GemType.RUBY, gems.getFirst().getGemType());
        Assertions.assertEquals(16, gems.getFirst().getTier());
        Assertions.assertEquals(Map.of(StatType.DAMAGE, 600.0), gems.getFirst().getStats());
        Assertions.assertEquals(GemType.AMETHYST, gems.get(1).getGemType());
        Assertions.assertEquals(16, gems.get(1).getTier());
        Assertions.assertEquals(Map.of(StatType.HEALTH_POINTS, 4900.0), gems.get(1).getStats());
    }

    @Test
    void shouldResolveOpalFromOpalDTO()
    {
        OpalInstanceDTO opalDTO = new OpalInstanceDTO(GemType.RUBY, GemType.ONYX, GemType.AMETHYST, 16);

        AbstractGem opal = gemFactory.fromDTO(opalDTO);

        Assertions.assertEquals(GemType.OPAL, opal.getGemType());
        Assertions.assertEquals(16, opal.getTier());
        Assertions.assertEquals(Map.of(StatType.DAMAGE, 450.0, StatType.CRIT_VALUE, 1687.5, StatType.HEALTH_POINTS, 3675.0), opal.getStats());
    }

    @Test
    void shouldResolveOpalsFromOpalDTOs()
    {
        OpalInstanceDTO opalDTO1 = new OpalInstanceDTO(GemType.RUBY, GemType.ONYX, GemType.AMETHYST, 16);
        OpalInstanceDTO opalDTO2 = new OpalInstanceDTO(GemType.RUBY, GemType.ONYX, GemType.ZIRCON, 16);
        List<AbstractGemInstanceDTO> opalDTOs = List.of(opalDTO1, opalDTO2);
        List<AbstractGem> opals = gemFactory.fromDTOList(opalDTOs);

        Assertions.assertEquals(GemType.OPAL, opals.getFirst().getGemType());
        Assertions.assertEquals(16, opals.getFirst().getTier());
        Assertions.assertEquals(Map.of(StatType.DAMAGE, 450.0, StatType.CRIT_VALUE, 1687.5, StatType.HEALTH_POINTS, 3675.0), opals.getFirst().getStats());
        Assertions.assertEquals(GemType.OPAL, opals.get(1).getGemType());
        Assertions.assertEquals(16, opals.get(1).getTier());
        Assertions.assertEquals(Map.of(StatType.DAMAGE, 450.0, StatType.CRIT_VALUE, 1687.5, StatType.ATTACK_SPEED, 0.012), opals.get(1).getStats());
    }
}
