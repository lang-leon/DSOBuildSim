package com.langleon.dsobuildsim.runes;

import com.langleon.dsobuildsim.gamedata.GameDataConfig;
import com.langleon.dsobuildsim.gamedata.GameDataLoader;
import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.runes.dto.RuneDefinitionDTO;
import com.langleon.dsobuildsim.runes.enums.RuneLimitGroup;
import com.langleon.dsobuildsim.runes.enums.RuneType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Map;

public class RuneMapperTest {
    
    private Map<RuneType, RuneDefinition> runes;

    @BeforeEach
    void setup()
    {
        GameDataConfig config = new GameDataLoader().loadGameDataConfig();
        runes = config.runes();
    }

    @Test
    void shouldMapRuneDefinitionToRuneDTO()
    {
        RuneDefinitionDTO runeDTO = RuneMapper.from(runes.get(RuneType.VIGOR));
        Map<Integer, Map<StatType, Double>> stats = Map.of(
                1, Map.of(StatType.DAMAGE, 0.013),
                2, Map.of(StatType.DAMAGE, 0.026),
                3, Map.of(StatType.DAMAGE, 0.039),
                4, Map.of(StatType.DAMAGE, 0.052),
                5, Map.of(StatType.DAMAGE, 0.065)
        );

        Assertions.assertEquals(RuneType.VIGOR, runeDTO.runeType());
        Assertions.assertEquals(RuneLimitGroup.VIGOR, runeDTO.runeLimitGroup());
        Assertions.assertEquals(5, runeDTO.defaultTier());
        Assertions.assertEquals(stats, runeDTO.statsPerTier());
    }
}
