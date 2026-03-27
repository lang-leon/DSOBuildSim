package com.langleon.dsobuildsim.buffs;

import tools.jackson.databind.ObjectMapper;
import com.langleon.dsobuildsim.buffs.enums.PhysicType;
import com.langleon.dsobuildsim.buffs.enums.TonicType;
import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.buffs.dto.BuffDefinitionDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Objects;

public class BuffMapperTest {

    private BuffConfig buffConfig;

    @BeforeEach
    void setup() throws IOException
    {
        try (var reader = new InputStreamReader(Objects.requireNonNull(getClass().getResourceAsStream("/gamedata/buffs.json"))))
        {
            ObjectMapper objectMapper = new ObjectMapper();
            buffConfig = objectMapper.readValue(reader, BuffConfig.class);
        }
    }

    @Test
    void shouldMapTonicDefinitionToBuffDTO()
    {
        BuffDefinitionDTO buffDTO = BuffMapper.from(buffConfig.tonics().get(TonicType.VIGOR));

        Assertions.assertEquals("VIGOR", buffDTO.type());
        Assertions.assertEquals("Tonic of Vigor", buffDTO.name());
        Assertions.assertEquals(5, buffDTO.defaultTier());
        Assertions.assertEquals(StatType.DAMAGE, buffDTO.statType());
        Assertions.assertEquals(Map.of(1, 2099.0, 2, 4198.0, 3, 6298.0, 4, 8397.0, 5, 10496.0), buffDTO.statsPerTier());
    }

    @Test
    void shouldMapPhysicDefinitionToBuffDTO()
    {
        BuffDefinitionDTO buffDTO = BuffMapper.from(buffConfig.physics().get(PhysicType.VIGOR_ADVANCED));

        Assertions.assertEquals("VIGOR_ADVANCED", buffDTO.type());
        Assertions.assertEquals("Advanced Physic of Vigor", buffDTO.name());
        Assertions.assertEquals(5, buffDTO.defaultTier());
        Assertions.assertEquals(StatType.DAMAGE, buffDTO.statType());
        Assertions.assertEquals(Map.of(1, 0.11, 2, 0.13, 3, 0.14, 4, 0.16, 5, 0.18), buffDTO.statsPerTier());
    }
}
