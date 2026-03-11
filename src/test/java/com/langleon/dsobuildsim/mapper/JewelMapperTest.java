package com.langleon.dsobuildsim.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.dto.JewelDTO;
import com.langleon.dsobuildsim.jewels.JewelConfig;
import com.langleon.dsobuildsim.jewels.JewelType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Objects;

public class JewelMapperTest {
    private JewelConfig jewelConfig;

    @BeforeEach
    void setup() throws IOException {
        try (var reader = new InputStreamReader(Objects.requireNonNull(getClass().getResourceAsStream("/data/jewels.json"))))
        {
            ObjectMapper objectMapper = new ObjectMapper();
            jewelConfig = objectMapper.readValue(reader, JewelConfig.class);
        }
    }

    @Test
    void shouldMapJewelDefinitionToJewelDTO()
    {
        JewelDTO jewelDTO = JewelMapper.from(jewelConfig.spellweaverJewels().get(JewelType.VIGOR));

        Map<Integer, Map<StatType, Double>> statsPerTier = Map.of(
                1, Map.of(StatType.DAMAGE, 0.02),
                2, Map.of(StatType.DAMAGE, 0.04),
                3, Map.of(StatType.DAMAGE, 0.06),
                4, Map.of(StatType.DAMAGE, 0.08),
                5, Map.of(StatType.DAMAGE, 0.10)
        );
        Map<Integer, String> descriptionPerTier = Map.of(
                1, "+ 2.00% damage",
                2, "+ 4.00% damage",
                3, "+ 6.00% damage",
                4, "+ 8.00% damage",
                5, "+ 10.00% damage"
        );
        Assertions.assertEquals(JewelType.VIGOR, jewelDTO.jewelType());
        Assertions.assertEquals("Jewel of Vigor", jewelDTO.name());
        Assertions.assertEquals(5, jewelDTO.tier());
        Assertions.assertEquals(statsPerTier, jewelDTO.statsPerTier());
        Assertions.assertEquals(descriptionPerTier, jewelDTO.descriptionPerTier());
    }
}
