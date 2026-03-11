package com.langleon.dsobuildsim.resolver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.dragonstones.DragonStone;
import com.langleon.dsobuildsim.dragonstones.DragonStoneConfig;
import com.langleon.dsobuildsim.dragonstones.DragonStoneFactory;
import com.langleon.dsobuildsim.dragonstones.DragonStoneType;
import com.langleon.dsobuildsim.dto.DragonStoneDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Objects;

public class DragonStoneResolverTest {

    private DragonStoneResolver resolver;

    @BeforeEach
    void setup() throws IOException
    {
        try (var reader = new InputStreamReader(Objects.requireNonNull(getClass().getResourceAsStream("/data/dragonstones.json"))))
        {
            ObjectMapper objectMapper = new ObjectMapper();
            DragonStoneConfig config = objectMapper.readValue(reader, DragonStoneConfig.class);
            DragonStoneFactory factory = new DragonStoneFactory(config);
            resolver = new DragonStoneResolver(factory);
        }
    }

    @Test
    void shouldResolveDragonStoneFromDragonStoneDTO()
    {
        DragonStoneDTO dto = new DragonStoneDTO(DragonStoneType.POWERSTONE, "Powerstone", 4,  Map.of(4, Map.of(StatType.HEALTH_POINTS, 0.05)), Map.of(4, "+ 5.00% Health Points"));

        DragonStone dragonStone = resolver.resolveDragonStone(dto);

        Assertions.assertEquals(DragonStoneType.POWERSTONE, dragonStone.dragonStoneType());
        Assertions.assertEquals(4, dragonStone.tier());
        Assertions.assertEquals(Map.of(StatType.HEALTH_POINTS, 0.05), dragonStone.stats());
        Assertions.assertEquals("+ 5.00% Health Points", dragonStone.description());
    }
}
