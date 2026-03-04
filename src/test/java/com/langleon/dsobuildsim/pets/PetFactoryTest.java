package com.langleon.dsobuildsim.pets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.langleon.dsobuildsim.enums.StatType;
import com.langleon.dsobuildsim.enums.pets.PetType;
import com.langleon.dsobuildsim.enums.pets.PetUpgradeType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStreamReader;

public class PetFactoryTest {
    private PetFactory petFactory;

    @BeforeEach
    void setup() throws IOException {
        try (var reader = new InputStreamReader(getClass().getResourceAsStream("/data/pets.json")))
        {
            ObjectMapper objectMapper = new ObjectMapper();
            PetConfig petConfig = objectMapper.readValue(reader, PetConfig.class);
            petFactory = new PetFactory(petConfig);
        }
    }

    @Test
    void createMortisPetTier3()
    {
        Pet pet = petFactory.createPet(PetType.MORTIS_DOLL, 3);
        Assertions.assertNotNull(pet);
        Assertions.assertEquals(3, pet.getTier());
        Assertions.assertEquals(0.12, pet.getRelativeStats().get(StatType.DAMAGE));
        Assertions.assertEquals("+ 12,00% Attack Speed\n+ 12,00% Mana Points\n+ 12,00% Damage", pet.getDescription());
    }

    @Test
    void createAwokenLionPetDefaultTier()
    {
        Pet pet = petFactory.createPet(PetType.AWOKEN_LION);
        Assertions.assertNotNull(pet);
        Assertions.assertEquals(6, pet.getTier());
        Assertions.assertEquals(0.2, pet.getRelativeStats().get(StatType.DAMAGE));
        Assertions.assertEquals("+ 20,00% Damage\nIncreased item drop worthy monsters", pet.getDescription());
    }

    @Test
    void testUpgradeCosts()
    {
        Pet pet = petFactory.createPet(PetType.AWOKEN_LION);
        Assertions.assertEquals(PetUpgradeType.NONE, pet.getPetUpgradeType());
        Pet pet2 = petFactory.createPet(PetType.UNLEASHED_SARGON_DOLL);
        Assertions.assertEquals(PetUpgradeType.NORMAL, pet2.getPetUpgradeType());
        Pet pet3 = petFactory.createPet(PetType.GILDED_LUCKY_CAT);
        Assertions.assertEquals(PetUpgradeType.GILDEDCAT, pet3.getPetUpgradeType());
    }

    @Test
    void throwsOnInvalidTier()
    {
        Assertions.assertThrows(IllegalArgumentException.class, () ->  petFactory.createPet(PetType.DAZZLING_FIREFLY, -1));
        Assertions.assertThrows(IllegalArgumentException.class, () ->  petFactory.createPet(PetType.HEREDUR_DOLL, 7));
    }
}
