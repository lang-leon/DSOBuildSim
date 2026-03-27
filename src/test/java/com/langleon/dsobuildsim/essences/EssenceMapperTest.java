package com.langleon.dsobuildsim.essences;

import tools.jackson.databind.ObjectMapper;
import com.langleon.dsobuildsim.essences.dto.EssenceDefinitionDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Objects;

public class EssenceMapperTest {

    private EssenceConfig essenceConfig;

    @BeforeEach
    void setup() throws IOException {
        try (var reader = new InputStreamReader(Objects.requireNonNull(getClass().getResourceAsStream("/gamedata/essences.json"))))
        {
            ObjectMapper objectMapper = new ObjectMapper();
            essenceConfig = objectMapper.readValue(reader, EssenceConfig.class);
        }
    }

    @Test
    void shouldMapEssenceDefinitionToEssenceDTO()
    {
        EssenceDefinitionDTO essenceDTO = EssenceMapper.from(essenceConfig.essences().get(EssenceType.BLAZING));

        Assertions.assertEquals(EssenceType.BLAZING, essenceDTO.essenceType());
        Assertions.assertEquals("Blazing Essence of Vigor", essenceDTO.name());
        Assertions.assertEquals(5, essenceDTO.defaultTier());
        Assertions.assertEquals(Map.of(5, 6.00), essenceDTO.damage());
        Assertions.assertEquals("600.00% increased damage\nNo effect in official arenas.", essenceDTO.description().get(5));
    }
}
