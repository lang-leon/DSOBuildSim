package com.langleon.dsobuildsim.mapper;

import tools.jackson.databind.ObjectMapper;
import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.dragonstones.DragonStoneConfig;
import com.langleon.dsobuildsim.dragonstones.DragonStoneType;
import com.langleon.dsobuildsim.dto.DragonStoneDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Objects;

public class DragonStoneMapperTest {

    private DragonStoneConfig config;

    @BeforeEach
    void setup() throws IOException {
        try (var reader = new InputStreamReader(Objects.requireNonNull(getClass().getResourceAsStream("/gamedata/dragonstones.json"))))
        {
            ObjectMapper objectMapper = new ObjectMapper();
            config = objectMapper.readValue(reader, DragonStoneConfig.class);
        }
    }

    @Test
    void shouldMapDragonStoneDefinitionToDragonStoneDTO()
    {
        DragonStoneDTO dto = DragonStoneMapper.from(config.dragonStones().get(DragonStoneType.POWERSTONE));

        Map<Integer, Map<StatType, Double>> statsPerTier = Map.of(
                3, Map.of(StatType.HEALTH_POINTS, 0.025),
                4, Map.of(StatType.HEALTH_POINTS, 0.05),
                5, Map.of(StatType.HEALTH_POINTS, 0.075)
        );
        Map<Integer, String> descriptionPerTier = Map.of(3, "+ 2.50% Health Points", 4, "+ 5.00% Health Points", 5, "+ 7.50% Health Points");

        Assertions.assertEquals(DragonStoneType.POWERSTONE, dto.dragonStoneType());
        Assertions.assertEquals("Powerstone", dto.name());
        Assertions.assertEquals(5, dto.tier());
        Assertions.assertEquals(statsPerTier, dto.stats());
        Assertions.assertEquals(descriptionPerTier, dto.description());
    }
}
