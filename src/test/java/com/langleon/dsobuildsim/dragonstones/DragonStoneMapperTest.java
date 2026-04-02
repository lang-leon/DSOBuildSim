package com.langleon.dsobuildsim.dragonstones;

import com.langleon.dsobuildsim.dragonstones.dto.DragonStoneDefinitionDTO;
import com.langleon.dsobuildsim.gamedata.GameDataConfig;
import com.langleon.dsobuildsim.gamedata.GameDataLoader;
import com.langleon.dsobuildsim.common.StatType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class DragonStoneMapperTest {

    private Map<DragonStoneType, DragonStoneDefinition> dragonStones;

    @BeforeEach
    void setup()
    {
        GameDataConfig config = new GameDataLoader().loadGameDataConfig();
        dragonStones = config.dragonStones();
    }

    @Test
    void shouldMapDragonStoneDefinitionToDragonStoneDTO()
    {
        DragonStoneDefinitionDTO dto = DragonStoneMapper.from(dragonStones.get(DragonStoneType.POWERSTONE));

        Map<Integer, Map<StatType, Double>> statsPerTier = Map.of(
                3, Map.of(StatType.HEALTH_POINTS, 0.025),
                4, Map.of(StatType.HEALTH_POINTS, 0.05),
                5, Map.of(StatType.HEALTH_POINTS, 0.075)
        );
        Map<Integer, String> descriptionPerTier = Map.of(3, "+ 2.50% Health Points", 4, "+ 5.00% Health Points", 5, "+ 7.50% Health Points");

        Assertions.assertEquals(DragonStoneType.POWERSTONE, dto.dragonStoneType());
        Assertions.assertEquals("Powerstone", dto.name());
        Assertions.assertEquals(5, dto.defaultTier());
        Assertions.assertEquals(statsPerTier, dto.stats());
        Assertions.assertEquals(descriptionPerTier, dto.description());
    }
}
