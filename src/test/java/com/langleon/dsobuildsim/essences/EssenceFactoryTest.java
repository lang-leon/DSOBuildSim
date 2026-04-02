package com.langleon.dsobuildsim.essences;

import com.langleon.dsobuildsim.essences.dto.EssenceInstanceDTO;
import com.langleon.dsobuildsim.gamedata.GameDataConfig;
import com.langleon.dsobuildsim.gamedata.GameDataLoader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EssenceFactoryTest {

    private EssenceFactory essenceFactory;

    @BeforeEach
    void setup()
    {
        GameDataConfig config = new GameDataLoader().loadGameDataConfig();
        essenceFactory = new EssenceFactory(config);
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
    void throwsOnInvalidTier()
    {
        Assertions.assertThrows(IllegalArgumentException.class, () ->  essenceFactory.createEssence(EssenceType.BLAZING, -1));
        Assertions.assertThrows(IllegalArgumentException.class, () ->  essenceFactory.createEssence(EssenceType.STELLAR_GOLD, 5));
    }

    @Test
    void shouldResolveEssenceFromEssenceDTO()
    {
        EssenceInstanceDTO essenceDTO = new EssenceInstanceDTO(EssenceType.BLAZING, 5);
        Essence essence = essenceFactory.fromDTO(essenceDTO);

        Assertions.assertEquals(EssenceType.BLAZING, essence.essenceType());
        Assertions.assertEquals(5, essence.tier());
        Assertions.assertEquals(6.0, essence.damageIncrease());
        Assertions.assertEquals("600.00% increased damage\nNo effect in official arenas.", essence.description());
    }
}
