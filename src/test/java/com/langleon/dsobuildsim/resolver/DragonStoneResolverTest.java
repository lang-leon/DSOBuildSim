package com.langleon.dsobuildsim.resolver;

import tools.jackson.databind.ObjectMapper;
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
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class DragonStoneResolverTest {

    private DragonStoneResolver resolver;

    @BeforeEach
    void setup() throws IOException
    {
        try (var reader = new InputStreamReader(Objects.requireNonNull(getClass().getResourceAsStream("/gamedata/dragonstones.json"))))
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

    @Test
    void shouldResolveDragonStonesFromDragonStoneDTOs()
    {
        DragonStoneDTO dragonStoneDTO1 = new DragonStoneDTO(DragonStoneType.POWERSTONE, "Powerstone", 4,  Map.of(4, Map.of(StatType.HEALTH_POINTS, 0.05)), Map.of(4, "+ 5.00% Health Points"));
        DragonStoneDTO dragonStoneDTO2 = new DragonStoneDTO(DragonStoneType.GREEDSTONE, "Greedstone", 4,  Map.of(4, Map.of(StatType.HEALTH_POINTS, 0.05)), Map.of(4, "+ 5.00% Health Points"));
        List<DragonStoneDTO> dragonStoneDTOs = List.of(dragonStoneDTO1, dragonStoneDTO2);
        List<DragonStone> dragonStones = resolver.resolveDragonStones(dragonStoneDTOs);

        Assertions.assertEquals(DragonStoneType.POWERSTONE, dragonStones.getFirst().dragonStoneType());
        Assertions.assertEquals(4, dragonStones.getFirst().tier());
        Assertions.assertEquals(Map.of(StatType.HEALTH_POINTS, 0.05), dragonStones.getFirst().stats());
        Assertions.assertEquals("+ 5.00% Health Points", dragonStones.getFirst().description());
        Assertions.assertEquals(DragonStoneType.GREEDSTONE, dragonStones.get(1).dragonStoneType());
        Assertions.assertEquals(4, dragonStones.get(1).tier());
        Assertions.assertEquals(Map.of(StatType.ANDERMANT_DROP_BONUS, 0.01), dragonStones.get(1).stats());
        Assertions.assertEquals("+ 1% drop stack size of Andermant", dragonStones.get(1).description());
    }
}
