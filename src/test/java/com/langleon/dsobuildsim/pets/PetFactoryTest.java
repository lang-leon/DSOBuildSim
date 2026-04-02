package com.langleon.dsobuildsim.pets;

import com.langleon.dsobuildsim.gamedata.GameDataConfig;
import com.langleon.dsobuildsim.gamedata.GameDataLoader;
import com.langleon.dsobuildsim.pets.dto.PetInstanceDTO;
import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.pets.enums.PetType;
import com.langleon.dsobuildsim.pets.enums.PetUpgradeType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class PetFactoryTest {
    private PetFactory petFactory;

    @BeforeEach
    void setup()
    {
        GameDataConfig config = new GameDataLoader().loadGameDataConfig();
        petFactory = new PetFactory(config);
    }

    @Test
    void createMortisPetTier3()
    {
        Pet pet = petFactory.createPet(PetType.MORTIS_DOLL, 3);
        Assertions.assertNotNull(pet);
        Assertions.assertEquals(3, pet.getTier());
        Assertions.assertEquals(0.12, pet.getRelativeStats().get(StatType.DAMAGE));
        Assertions.assertEquals("+ 12,00% Attack Speed\n+ 12,00% Damage\n+ 12,00% Mana Points", pet.getDescription());
    }

    @Test
    void createAwokenLionPetDefaultTier()
    {
        Pet pet = petFactory.createPet(PetType.AWOKEN_LION, 6);
        Assertions.assertNotNull(pet);
        Assertions.assertEquals(6, pet.getTier());
        Assertions.assertEquals(0.2, pet.getRelativeStats().get(StatType.DAMAGE));
        Assertions.assertEquals("+ 20,00% Damage\nIncreased item drop worthy monsters", pet.getDescription());
    }

    @Test
    void testUpgradeCosts()
    {
        Pet pet = petFactory.createPet(PetType.AWOKEN_LION, 6);
        Assertions.assertEquals(PetUpgradeType.NONE, pet.getPetUpgradeType());
        Pet pet2 = petFactory.createPet(PetType.UNLEASHED_SARGON_DOLL, 5);
        Assertions.assertEquals(PetUpgradeType.NORMAL, pet2.getPetUpgradeType());
        Pet pet3 = petFactory.createPet(PetType.GILDED_LUCKY_CAT, 5);
        Assertions.assertEquals(PetUpgradeType.GILDEDCAT, pet3.getPetUpgradeType());
    }

    @Test
    void throwsOnInvalidTier()
    {
        Assertions.assertThrows(IllegalArgumentException.class, () ->  petFactory.createPet(PetType.DAZZLING_FIREFLY, -1));
        Assertions.assertThrows(IllegalArgumentException.class, () ->  petFactory.createPet(PetType.HEREDUR_DOLL, 7));
    }

    @Test
    void shouldResolvePetFromPetDTO()
    {
        PetInstanceDTO petDTO = new PetInstanceDTO(PetType.BLUE_DRAGONSPAWN, 4);

        Pet pet = petFactory.fromDTO(petDTO);

        Assertions.assertEquals(PetType.BLUE_DRAGONSPAWN, pet.getPetType());
        Assertions.assertEquals(4, pet.getTier());
        Assertions.assertEquals(Map.of(StatType.XP_GAIN, 0.25), pet.getRelativeStats());
        Assertions.assertEquals("+ 25,00% XP Gain", pet.getDescription());
    }
}
