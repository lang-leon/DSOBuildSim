package com.langleon.dsobuildsim.essences;

import com.langleon.dsobuildsim.gamedata.GameDataConfig;
import com.langleon.dsobuildsim.gamedata.GameDataLoader;
import com.langleon.dsobuildsim.essences.dto.EssenceDefinitionDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class EssenceMapperTest {

    private Map<EssenceType, EssenceDefinition> essences;

    @BeforeEach
    void setup()
    {
        GameDataConfig config = new GameDataLoader().loadGameDataConfig();
        essences = config.essences();
    }

    @Test
    void shouldMapEssenceDefinitionToEssenceDTO()
    {
        EssenceDefinitionDTO essenceDTO = EssenceMapper.from(essences.get(EssenceType.BLAZING));

        Assertions.assertEquals(EssenceType.BLAZING, essenceDTO.essenceType());
        Assertions.assertEquals("Blazing Essence of Vigor", essenceDTO.name());
        Assertions.assertEquals(5, essenceDTO.defaultTier());
        Assertions.assertEquals(Map.of(5, 6.00), essenceDTO.damage());
        Assertions.assertEquals("600.00% increased damage\nNo effect in official arenas.", essenceDTO.description().get(5));
    }
}
