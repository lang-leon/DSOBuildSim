package com.langleon.dsobuildsim.buffs;

import com.langleon.dsobuildsim.buffs.dto.BuffInstanceDTO;
import com.langleon.dsobuildsim.gamedata.GameDataConfig;
import com.langleon.dsobuildsim.gamedata.GameDataLoader;
import com.langleon.dsobuildsim.buffs.enums.PhysicType;
import com.langleon.dsobuildsim.buffs.enums.TonicType;
import com.langleon.dsobuildsim.common.StatType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BuffResolverTest {

    private BuffResolver buffResolver;

    @BeforeEach
    void setup()
    {
        GameDataConfig config = new GameDataLoader().loadGameDataConfig();
        BuffFactory buffFactory = new BuffFactory(config);
        buffResolver = new BuffResolver(buffFactory);
    }

    @Test
    void shouldResolveTonicFromBuffDTO()
    {
        BuffInstanceDTO buffDTO = new BuffInstanceDTO("VIGOR", 4);

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
        BuffInstanceDTO buffDTO = new BuffInstanceDTO("VITALITY_SIMPLE", 4);

        Physic physic = buffResolver.resolvePhysic(buffDTO);

        Assertions.assertEquals(PhysicType.VITALITY_SIMPLE, physic.physicType());
        Assertions.assertEquals("Simple Physic of Vitality", physic.getName());
        Assertions.assertEquals(4, physic.tier());
        Assertions.assertEquals(StatType.HEALTH_POINTS, physic.statType());
        Assertions.assertEquals(0.07, physic.statValue());
    }


}
