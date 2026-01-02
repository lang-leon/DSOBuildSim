package com.langleon.dsobuildsim.buffs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.langleon.dsobuildsim.enums.StatType;
import com.langleon.dsobuildsim.enums.buffs.PhysicType;
import com.langleon.dsobuildsim.enums.buffs.TonicType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStreamReader;

public class BuffFactoryTest {

    private BuffFactory buffFactory;

    @BeforeEach
    void setup() throws IOException
    {
        try (var reader = new InputStreamReader(getClass().getResourceAsStream("/data/buffs.json")))
        {
            ObjectMapper objectMapper = new ObjectMapper();
            BuffConfig buffConfig = objectMapper.readValue(reader, BuffConfig.class);
            buffFactory = new BuffFactory(buffConfig);
        }
    }

    @Test
    void createTonicOfVigorTier4()
    {
        Tonic tonic = buffFactory.createTonic(TonicType.VIGOR, 4);
        Assertions.assertNotNull(tonic);
        Assertions.assertEquals(4, tonic.tier());
        Assertions.assertEquals(8397, tonic.statValue());
        Assertions.assertEquals(StatType.DAMAGE, tonic.statType());
        Assertions.assertEquals("+ 8397 Damage", tonic.description());
    }

    @Test
    void createTonicOfVitalityDefaultTier()
    {
        Tonic tonic = buffFactory.createTonic(TonicType.VITALITY);
        Assertions.assertNotNull(tonic);
        Assertions.assertEquals(5, tonic.tier());
        Assertions.assertEquals(156068, tonic.statValue());
        Assertions.assertEquals(StatType.HEALTH_POINTS, tonic.statType());
        Assertions.assertEquals("+ 156068 Health Points", tonic.description());
    }

    @Test
    void createSimplePhysicOfVigorTier4()
    {
        Physic physic = buffFactory.createPhysic(PhysicType.VIGOR_SIMPLE, 4);
        Assertions.assertNotNull(physic);
        Assertions.assertEquals(4, physic.tier());
        Assertions.assertEquals(0.07, physic.statValue());
        Assertions.assertEquals(StatType.DAMAGE, physic.statType());
        Assertions.assertEquals("+ 7,00% Damage", physic.description());
    }

    @Test
    void createSimplePhysicOfVitalityDefaultTier()
    {
        Physic physic = buffFactory.createPhysic(PhysicType.VITALITY_SIMPLE);
        Assertions.assertNotNull(physic);
        Assertions.assertEquals(5, physic.tier());
        Assertions.assertEquals(0.09, physic.statValue());
        Assertions.assertEquals(StatType.HEALTH_POINTS, physic.statType());
        Assertions.assertEquals("+ 9,00% Health Points", physic.description());
    }

    @Test
    void createAdvancedPhysicOfVigorTier4()
    {
        Physic physic = buffFactory.createPhysic(PhysicType.VIGOR_ADVANCED, 4);
        Assertions.assertNotNull(physic);
        Assertions.assertEquals(4, physic.tier());
        Assertions.assertEquals(0.16, physic.statValue());
        Assertions.assertEquals(StatType.DAMAGE, physic.statType());
        Assertions.assertEquals("+ 16,00% Damage", physic.description());
    }

    @Test
    void createAdvancedPhysicOfVitalityDefaultTier()
    {
        Physic physic = buffFactory.createPhysic(PhysicType.VITALITY_ADVANCED);
        Assertions.assertNotNull(physic);
        Assertions.assertEquals(5, physic.tier());
        Assertions.assertEquals(0.18, physic.statValue());
        Assertions.assertEquals(StatType.HEALTH_POINTS, physic.statType());
        Assertions.assertEquals("+ 18,00% Health Points", physic.description());
    }

    @Test
    void throwsOnInvalidTier()
    {
        Assertions.assertThrows(IllegalArgumentException.class, () ->  buffFactory.createTonic(TonicType.CELERITY, -1));
        Assertions.assertThrows(IllegalArgumentException.class, () ->  buffFactory.createPhysic(PhysicType.ALACRITY_ADVANCED, 7));
    }
}
