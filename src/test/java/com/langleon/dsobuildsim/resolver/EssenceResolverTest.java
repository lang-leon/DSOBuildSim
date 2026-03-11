package com.langleon.dsobuildsim.resolver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.langleon.dsobuildsim.dto.EssenceDTO;
import com.langleon.dsobuildsim.essences.Essence;
import com.langleon.dsobuildsim.essences.EssenceConfig;
import com.langleon.dsobuildsim.essences.EssenceFactory;
import com.langleon.dsobuildsim.essences.EssenceType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Objects;

public class EssenceResolverTest {

    private EssenceResolver essenceResolver;

    @BeforeEach
    void setup() throws IOException
    {
        try (var reader = new InputStreamReader(Objects.requireNonNull(getClass().getResourceAsStream("/data/essences.json"))))
        {
            ObjectMapper objectMapper = new ObjectMapper();
            EssenceConfig essenceConfig = objectMapper.readValue(reader, EssenceConfig.class);
            EssenceFactory essenceFactory = new EssenceFactory(essenceConfig);
            essenceResolver = new EssenceResolver(essenceFactory);
        }
    }

    @Test
    void shouldResolveEssenceFromEssenceDTO()
    {
        EssenceDTO essenceDTO = new EssenceDTO(EssenceType.BLAZING, "Blazing Essence of Vigor", 5, Map.of(5, 6.00), Map.of(5, "600.00% increased damage\nNo effect in official arenas."));
        Essence essence = essenceResolver.resolveEssence(essenceDTO);

        Assertions.assertEquals(EssenceType.BLAZING, essence.essenceType());
        Assertions.assertEquals(5, essence.tier());
        Assertions.assertEquals(6.0, essence.damageIncrease());
        Assertions.assertEquals("600.00% increased damage\nNo effect in official arenas.", essence.description());
    }
}
