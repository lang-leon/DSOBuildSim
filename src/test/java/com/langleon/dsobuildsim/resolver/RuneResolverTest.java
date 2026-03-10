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

        Rune rune = runeResolver.resolve(runeDTO);

        Assertions.assertEquals(RuneType.VIGOR, rune.getRuneType());
        Assertions.assertEquals(RuneLimitGroup.VIGOR, rune.getRuneLimitGroup());
        Assertions.assertEquals(4, rune.getTier());
        Assertions.assertEquals(Map.of(StatType.DAMAGE, 0.052), rune.getStats());
    }
}
