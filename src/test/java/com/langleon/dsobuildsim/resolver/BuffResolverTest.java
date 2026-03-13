package com.langleon.dsobuildsim.resolver;

import tools.jackson.databind.ObjectMapper;
import com.langleon.dsobuildsim.buffs.BuffConfig;
import com.langleon.dsobuildsim.buffs.BuffFactory;
import com.langleon.dsobuildsim.buffs.Physic;
import com.langleon.dsobuildsim.buffs.Tonic;
import com.langleon.dsobuildsim.buffs.enums.PhysicType;
import com.langleon.dsobuildsim.buffs.enums.TonicType;
import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.dto.BuffDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Objects;

public class BuffResolverTest {

    private BuffResolver buffResolver;

    @BeforeEach
    void setup() throws IOException
    {
        try (var reader = new InputStreamReader(Objects.requireNonNull(getClass().getResourceAsStream("/gamedata/buffs.json"))))
        {
            ObjectMapper objectMapper = new ObjectMapper();
            BuffConfig buffConfig = objectMapper.readValue(reader, BuffConfig.class);
            BuffFactory buffFactory = new BuffFactory(buffConfig);
            buffResolver = new BuffResolver(buffFactory);
        }
    }

    @Test
    void shouldResolveTonicFromBuffDTO()
    {
        BuffDTO buffDTO = new BuffDTO("VIGOR", "Tonic of Vigor", 4, StatType.DAMAGE, Map.of(4, 8397.0));

        Tonic tonic = buffResolver.resolveTonic(buffDTO);

        Assertions.assertEquals(TonicType.VIGOR, tonic.tonicType());
        Assertions.assertEquals("Tonic of Vigor", tonic.getName());
        Assertions.assertEquals(4, tonic.tier());
        Assertions.assertEquals(StatType.DAMAGE, tonic.statType());
        Assertions.assertEquals(8397.0, tonic.statValue());
    }

    @Test
    void shouldResolvePhysicFromBuffDTO()
    {
        BuffDTO buffDTO = new BuffDTO("VITALITY_SIMPLE", "Simple Physic of Vitality", 4, StatType.HEALTH_POINTS, Map.of(4, 0.07));

        Physic physic = buffResolver.resolvePhysic(buffDTO);

        Assertions.assertEquals(PhysicType.VITALITY_SIMPLE, physic.physicType());
        Assertions.assertEquals("Simple Physic of Vitality", physic.getName());
        Assertions.assertEquals(4, physic.tier());
        Assertions.assertEquals(StatType.HEALTH_POINTS, physic.statType());
        Assertions.assertEquals(0.07, physic.statValue());
    }


}
