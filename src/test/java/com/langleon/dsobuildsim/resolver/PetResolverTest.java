package com.langleon.dsobuildsim.resolver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.langleon.dsobuildsim.buffs.BuffConfig;
import com.langleon.dsobuildsim.buffs.BuffFactory;
import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.dto.PetDTO;
import com.langleon.dsobuildsim.pets.Pet;
import com.langleon.dsobuildsim.pets.PetConfig;
import com.langleon.dsobuildsim.pets.PetFactory;
import com.langleon.dsobuildsim.pets.enums.PetCategory;
import com.langleon.dsobuildsim.pets.enums.PetType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Objects;

public class PetResolverTest {

    private PetResolver petResolver;

    @BeforeEach
    void setup() throws IOException
    {
        try (var reader = new InputStreamReader(Objects.requireNonNull(getClass().getResourceAsStream("/data/pets.json"))))
        {
            ObjectMapper objectMapper = new ObjectMapper();
            PetConfig petConfig = objectMapper.readValue(reader, PetConfig.class);
            PetFactory petFactory = new PetFactory(petConfig);
            petResolver = new PetResolver(petFactory);
        }
    }

    @Test
    void shouldResolvePetFromPetDTO()
    {
        PetDTO petDTO = new PetDTO("BLUE_DRAGONSPAWN", "DRAGON_SPAWN", "Blue Dragonspawn", 4, Map.of(4, Map.of(StatType.XP_GAIN, 0.25)), Map.of());

        Pet pet = petResolver.resolvePet(petDTO);
        Map<Integer, Map<StatType, Double>> statsPerTier = Map.of(4, Map.of(StatType.XP_GAIN, 0.25));

        Assertions.assertEquals(PetType.BLUE_DRAGONSPAWN, pet.getPetType());
        Assertions.assertEquals(4, pet.getTier());
        Assertions.assertEquals(Map.of(StatType.XP_GAIN, 0.25), pet.getRelativeStats());
        Assertions.assertEquals("+ 25,00% XP Gain", pet.getDescription());
    }
}
