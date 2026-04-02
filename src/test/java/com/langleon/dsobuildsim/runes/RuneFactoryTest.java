package com.langleon.dsobuildsim.runes;

import com.langleon.dsobuildsim.gamedata.GameDataConfig;
import com.langleon.dsobuildsim.gamedata.GameDataLoader;
import com.langleon.dsobuildsim.runes.dto.RuneInstanceDTO;
import com.langleon.dsobuildsim.runes.dto.RuneTrinketDTO;
import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.runes.enums.RuneLimitGroup;
import com.langleon.dsobuildsim.runes.enums.RuneType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;

class RuneFactoryTest {

    private RuneFactory runeFactory;

    @BeforeEach
    void setup()
    {
        GameDataConfig config = new GameDataLoader().loadGameDataConfig();
        runeFactory = new RuneFactory(config);
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
    void throwsOnInvalidTier()
    {
        Assertions.assertThrows(IllegalArgumentException.class, () -> runeFactory.createRune(RuneType.VIGOR, -1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> runeFactory.createRune(RuneType.HOLY_STAR_SHARD, 5));
    }

    @Test
    void shouldResolveRuneFromRuneDTO()
    {
        RuneInstanceDTO runeDTO = new RuneInstanceDTO(RuneType.VIGOR, 4);

        Rune rune = runeFactory.fromDTO(runeDTO);

        Assertions.assertEquals(RuneType.VIGOR, rune.getRuneType());
        Assertions.assertEquals(RuneLimitGroup.VIGOR, rune.getRuneLimitGroup());
        Assertions.assertEquals(4, rune.getTier());
        Assertions.assertEquals(Map.of(StatType.DAMAGE, 0.052), rune.getStats());
    }

    @Test
    void shouldResolveRunesFromRuneDTOs()
    {
        RuneInstanceDTO runeDTO1 = new RuneInstanceDTO(RuneType.VIGOR, 4);
        RuneInstanceDTO runeDTO2 = new RuneInstanceDTO(RuneType.VITALITY, 4);

        List<RuneInstanceDTO> runeDTOs = List.of(runeDTO1, runeDTO2);
        List<Rune> runes = runeFactory.fromDTOList(runeDTOs);

        Assertions.assertEquals(RuneType.VIGOR, runes.getFirst().getRuneType());
        Assertions.assertEquals(RuneLimitGroup.VIGOR, runes.getFirst().getRuneLimitGroup());
        Assertions.assertEquals(4, runes.getFirst().getTier());
        Assertions.assertEquals(Map.of(StatType.DAMAGE, 0.052), runes.getFirst().getStats());
        Assertions.assertEquals(RuneType.VITALITY, runes.get(1).getRuneType());
        Assertions.assertEquals(RuneLimitGroup.VITALITY, runes.get(1).getRuneLimitGroup());
        Assertions.assertEquals(4, runes.get(1).getTier());
        Assertions.assertEquals(Map.of(StatType.HEALTH_POINTS, 0.052), runes.get(1).getStats());
    }

    @Test
    void shouldResolveRuneTrinketFromRuneTrinketDTO()
    {
        RuneInstanceDTO runeDTO1 = new RuneInstanceDTO(RuneType.VIGOR, 4);
        RuneInstanceDTO runeDTO2 = new RuneInstanceDTO(RuneType.VITALITY, 4);
        RuneTrinketDTO runeTrinketDTO = new RuneTrinketDTO(List.of(runeDTO1, runeDTO2));

        RuneTrinket runeTrinket = runeFactory.fromTrinketDTO(runeTrinketDTO);

        Assertions.assertEquals(RuneType.VIGOR, runeTrinket.getRunes().getFirst().getRuneType());
        Assertions.assertEquals(RuneLimitGroup.VIGOR, runeTrinket.getRunes().getFirst().getRuneLimitGroup());
        Assertions.assertEquals(4, runeTrinket.getRunes().getFirst().getTier());
        Assertions.assertEquals(Map.of(StatType.DAMAGE, 0.052), runeTrinket.getRunes().getFirst().getStats());
        Assertions.assertEquals(RuneType.VITALITY, runeTrinket.getRunes().get(1).getRuneType());
        Assertions.assertEquals(RuneLimitGroup.VITALITY, runeTrinket.getRunes().get(1).getRuneLimitGroup());
        Assertions.assertEquals(4, runeTrinket.getRunes().get(1).getTier());
        Assertions.assertEquals(Map.of(StatType.HEALTH_POINTS, 0.052), runeTrinket.getRunes().get(1).getStats());
    }

    @Test
    void shouldResolveRuneTrinketFromRuneTrinketDTOs()
    {
        RuneInstanceDTO runeDTO1 = new RuneInstanceDTO(RuneType.VIGOR, 4);
        RuneInstanceDTO runeDTO2 = new RuneInstanceDTO(RuneType.VITALITY, 4);
        RuneTrinketDTO runeTrinketDTO1 = new RuneTrinketDTO(List.of(runeDTO1, runeDTO2));
        RuneInstanceDTO runeDTO3 = new RuneInstanceDTO(RuneType.RESILIENCE, 4);
        RuneInstanceDTO runeDTO4 = new RuneInstanceDTO(RuneType.CELERITY, 4);
        RuneTrinketDTO runeTrinketDTO2 = new RuneTrinketDTO(List.of(runeDTO3, runeDTO4));

        List<RuneTrinket> runeTrinkets = runeFactory.fromTrinketDTOList(List.of(runeTrinketDTO1, runeTrinketDTO2));

        Assertions.assertEquals(RuneType.VIGOR, runeTrinkets.getFirst().getRunes().getFirst().getRuneType());
        Assertions.assertEquals(RuneLimitGroup.VIGOR, runeTrinkets.getFirst().getRunes().getFirst().getRuneLimitGroup());
        Assertions.assertEquals(4, runeTrinkets.getFirst().getRunes().getFirst().getTier());
        Assertions.assertEquals(Map.of(StatType.DAMAGE, 0.052), runeTrinkets.getFirst().getRunes().getFirst().getStats());
        Assertions.assertEquals(RuneType.VITALITY, runeTrinkets.getFirst().getRunes().get(1).getRuneType());
        Assertions.assertEquals(RuneLimitGroup.VITALITY, runeTrinkets.getFirst().getRunes().get(1).getRuneLimitGroup());
        Assertions.assertEquals(4, runeTrinkets.getFirst().getRunes().get(1).getTier());
        Assertions.assertEquals(Map.of(StatType.HEALTH_POINTS, 0.052), runeTrinkets.getFirst().getRunes().get(1).getStats());

        Assertions.assertEquals(RuneType.RESILIENCE, runeTrinkets.get(1).getRunes().getFirst().getRuneType());
        Assertions.assertEquals(RuneLimitGroup.RESILIENCE, runeTrinkets.get(1).getRunes().getFirst().getRuneLimitGroup());
        Assertions.assertEquals(4, runeTrinkets.get(1).getRunes().getFirst().getTier());
        Assertions.assertEquals(Map.of(StatType.RESISTANCE_VALUE, 0.052), runeTrinkets.get(1).getRunes().getFirst().getStats());
        Assertions.assertEquals(RuneType.CELERITY, runeTrinkets.get(1).getRunes().get(1).getRuneType());
        Assertions.assertEquals(RuneLimitGroup.CELERITY, runeTrinkets.get(1).getRunes().get(1).getRuneLimitGroup());
        Assertions.assertEquals(4, runeTrinkets.get(1).getRunes().get(1).getTier());
        Assertions.assertEquals(Map.of(StatType.ATTACK_SPEED, 0.052), runeTrinkets.get(1).getRunes().get(1).getStats());
    }
}
