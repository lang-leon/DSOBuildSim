package com.langleon.dsobuildsim.essences;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStreamReader;

public class EssenceFactoryTest {

    private EssenceFactory essenceFactory;

    @BeforeEach
    void setup() throws IOException
    {
        try (var reader = new InputStreamReader(getClass().getResourceAsStream("/data/essences.json")))
        {
            ObjectMapper objectMapper = new ObjectMapper();
            EssenceConfig essenceConfig = objectMapper.readValue(reader, EssenceConfig.class);
            essenceFactory = new EssenceFactory(essenceConfig);
        }
    }

    @Test
    void createLightEssenceTier4()
    {
        Essence essence = essenceFactory.createEssence(EssenceType.LIGHT, 4);
        Assertions.assertNotNull(essence);
        Assertions.assertEquals(4, essence.tier());
        Assertions.assertEquals(2.00, essence.damageIncrease());
        Assertions.assertEquals("Destroys darkness\n200.00% increased damage\nNo effect in official arenas.", essence.description());
    }

    @Test
    void createFireEssenceDefaultTier()
    {
        Essence essence = essenceFactory.createEssence(EssenceType.ELEMENTAL_FIRE);
        Assertions.assertNotNull(essence);
        Assertions.assertEquals(5, essence.tier());
        Assertions.assertEquals(0.00, essence.damageIncrease());
        Assertions.assertEquals("Deals 300% of your skill's base damage as additional fire damage\nNo effect in official arenas.", essence.description());
    }

    @Test
    void throwsOnInvalidTier()
    {
        Assertions.assertThrows(IllegalArgumentException.class, () ->  essenceFactory.createEssence(EssenceType.BLAZING, -1));
        Assertions.assertThrows(IllegalArgumentException.class, () ->  essenceFactory.createEssence(EssenceType.STELLAR_GOLD, 5));
    }
}
