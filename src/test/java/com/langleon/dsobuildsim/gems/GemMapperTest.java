package com.langleon.dsobuildsim.gems;

import tools.jackson.databind.ObjectMapper;
import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.gems.dto.GemDefinitionDTO;
import com.langleon.dsobuildsim.gems.enums.GemLimitGroup;
import com.langleon.dsobuildsim.gems.enums.GemType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Objects;

public class GemMapperTest {

    private GemConfig gemConfig;

    @BeforeEach
    void setup() throws IOException {
        try (var reader = new InputStreamReader(Objects.requireNonNull(getClass().getResourceAsStream("/gamedata/gems.json"))))
        {
            ObjectMapper objectMapper = new ObjectMapper();
            gemConfig = objectMapper.readValue(reader, GemConfig.class);
        }
    }

    @Test
    void shouldMapGemDefinitionToGemDTO()
    {
        GemDefinitionDTO gemDTO = GemMapper.from(gemConfig.gems().get(GemType.RUBY));

        Map<Integer, Double> statsPerTier = Map.ofEntries(
                Map.entry(1, 2.0),
                Map.entry(2, 3.0),
                Map.entry(3, 6.0),
                Map.entry(4, 10.0),
                Map.entry(5, 15.0),
                Map.entry(6, 24.0),
                Map.entry(7, 36.0),
                Map.entry(8, 54.0),
                Map.entry(9, 80.0),
                Map.entry(10, 113.0),
                Map.entry(11, 145.0),
                Map.entry(12, 200.0),
                Map.entry(13, 300.0),
                Map.entry(14, 400.0),
                Map.entry(15, 500.0),
                Map.entry(16, 600.0),
                Map.entry(17, 700.0)
        );

        Assertions.assertEquals(GemType.RUBY, gemDTO.gemType());
        Assertions.assertEquals(GemLimitGroup.RUBY, gemDTO.gemLimitGroup());
        Assertions.assertEquals(50, gemDTO.gemLimit());
        Assertions.assertEquals(17, gemDTO.tier());
        Assertions.assertEquals(StatType.DAMAGE, gemDTO.statType());
        Assertions.assertEquals(statsPerTier, gemDTO.stats());
    }
}