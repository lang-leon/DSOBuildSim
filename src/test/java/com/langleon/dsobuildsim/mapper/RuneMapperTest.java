package com.langleon.dsobuildsim.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.dto.RuneDTO;
import com.langleon.dsobuildsim.runes.RuneConfig;
import com.langleon.dsobuildsim.runes.enums.RuneLimitGroup;
import com.langleon.dsobuildsim.runes.enums.RuneType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Objects;

public class RuneMapperTest {
    
    private RuneConfig runeConfig;

    @BeforeEach
    void setup() throws IOException
    {
        try (var reader = new InputStreamReader(Objects.requireNonNull(getClass().getResourceAsStream("/data/runes.json"))))
        {
            ObjectMapper objectMapper = new ObjectMapper();
            runeConfig = objectMapper.readValue(reader, RuneConfig.class);
        }
    }

    @Test
    void shouldMapRuneDefinitionToRuneDTO()
    {
        RuneDTO runeDTO = RuneMapper.from(runeConfig.runes().get(RuneType.VIGOR));
        Map<Integer, Map<StatType, Double>> stats = Map.of(
                1, Map.of(StatType.DAMAGE, 0.013),
                2, Map.of(StatType.DAMAGE, 0.026),
                3, Map.of(StatType.DAMAGE, 0.039),
                4, Map.of(StatType.DAMAGE, 0.052),
                5, Map.of(StatType.DAMAGE, 0.065)
        );

        Assertions.assertEquals(RuneType.VIGOR, runeDTO.runeType());
        Assertions.assertEquals(RuneLimitGroup.VIGOR, runeDTO.runeLimitGroup());
        Assertions.assertEquals(5, runeDTO.tier());
        Assertions.assertEquals(stats, runeDTO.statsPerTier());
    }
}
