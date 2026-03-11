package com.langleon.dsobuildsim.resolver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.dto.RuneDTO;
import com.langleon.dsobuildsim.runes.Rune;
import com.langleon.dsobuildsim.runes.RuneConfig;
import com.langleon.dsobuildsim.runes.RuneFactory;
import com.langleon.dsobuildsim.runes.enums.RuneLimitGroup;
import com.langleon.dsobuildsim.runes.enums.RuneType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class RuneResolverTest {

    private RuneResolver runeResolver;

    @BeforeEach
    void setup() throws IOException
    {
        try (var reader = new InputStreamReader(Objects.requireNonNull(getClass().getResourceAsStream("/data/runes.json"))))
        {
            ObjectMapper objectMapper = new ObjectMapper();
            RuneConfig runeConfig = objectMapper.readValue(reader, RuneConfig.class);
            RuneFactory runeFactory = new RuneFactory(runeConfig);
            runeResolver = new RuneResolver(runeFactory);
        }
    }

    @Test
    void shouldResolveRuneFromRuneDTO()
    {
        RuneDTO runeDTO = new RuneDTO(RuneType.VIGOR, RuneLimitGroup.VIGOR, 4, Map.of(4, Map.of(StatType.DAMAGE, 0.052)), "");

        Rune rune = runeResolver.resolveRune(runeDTO);

        Assertions.assertEquals(RuneType.VIGOR, rune.getRuneType());
        Assertions.assertEquals(RuneLimitGroup.VIGOR, rune.getRuneLimitGroup());
        Assertions.assertEquals(4, rune.getTier());
        Assertions.assertEquals(Map.of(StatType.DAMAGE, 0.052), rune.getStats());
    }

    @Test
    void shouldResolveRunesFromRuneDTOs()
    {
        RuneDTO runeDTO1 = new RuneDTO(RuneType.VIGOR, RuneLimitGroup.VIGOR, 4, Map.of(4, Map.of(StatType.DAMAGE, 0.052)), "");
        RuneDTO runeDTO2 = new RuneDTO(RuneType.VITALITY, RuneLimitGroup.VITALITY, 4, Map.of(4, Map.of(StatType.HEALTH_POINTS, 0.052)), "");

        List<RuneDTO> runeDTOs = List.of(runeDTO1, runeDTO2);
        List<Rune> runes = runeResolver.resolveRunes(runeDTOs);

        Assertions.assertEquals(RuneType.VIGOR, runes.getFirst().getRuneType());
        Assertions.assertEquals(RuneLimitGroup.VIGOR, runes.getFirst().getRuneLimitGroup());
        Assertions.assertEquals(4, runes.getFirst().getTier());
        Assertions.assertEquals(Map.of(StatType.DAMAGE, 0.052), runes.getFirst().getStats());
        Assertions.assertEquals(RuneType.VITALITY, runes.get(1).getRuneType());
        Assertions.assertEquals(RuneLimitGroup.VITALITY, runes.get(1).getRuneLimitGroup());
        Assertions.assertEquals(4, runes.get(1).getTier());
        Assertions.assertEquals(Map.of(StatType.HEALTH_POINTS, 0.052), runes.get(1).getStats());
    }
}
