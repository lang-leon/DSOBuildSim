package com.langleon.dsobuildsim.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.dto.PetDTO;
import com.langleon.dsobuildsim.pets.PetConfig;
import com.langleon.dsobuildsim.pets.enums.PetType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Objects;

public class PetMapperTest {

    private PetConfig petConfig;

    @BeforeEach
    void setup() throws IOException {
        try (var reader = new InputStreamReader(Objects.requireNonNull(getClass().getResourceAsStream("/data/pets.json"))))
        {
            ObjectMapper objectMapper = new ObjectMapper();
            petConfig = objectMapper.readValue(reader, PetConfig.class);
        }
    }

    @Test
    void shouldMapPetDefinitionToPetDTO()
    {
        PetDTO petDTO = PetMapper.from(petConfig.pets().get(PetType.BLUE_DRAGONSPAWN));

        Map<Integer, Map<StatType, Double>> statsPerTier = Map.of(
                2, Map.of(StatType.XP_GAIN, 0.05),
                3, Map.of(StatType.XP_GAIN, 0.15),
                4, Map.of(StatType.XP_GAIN, 0.25),
                5, Map.of(StatType.XP_GAIN, 0.35)
        );
        Assertions.assertEquals("BLUE_DRAGONSPAWN", petDTO.petType());
        Assertions.assertEquals("DRAGON_SPAWN", petDTO.petCategory());
        Assertions.assertEquals("Blue Dragonspawn", petDTO.name());
        Assertions.assertEquals(5, petDTO.tier());
        Assertions.assertEquals(statsPerTier, petDTO.stats());
        Assertions.assertEquals(Map.of(), petDTO.description());
    }
}
