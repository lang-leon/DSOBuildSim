package com.langleon.dsobuildsim.pets;

import com.langleon.dsobuildsim.collectorbagbonus.enums.CollectorBagCategory;
import com.langleon.dsobuildsim.gamedata.GameDataConfig;
import com.langleon.dsobuildsim.gamedata.GameDataLoader;
import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.pets.dto.PetDefinitionDTO;
import com.langleon.dsobuildsim.pets.enums.PetType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class PetMapperTest {

    private Map<PetType, PetDefinition> pets;

    @BeforeEach
    void setup()
    {
        GameDataConfig config = new GameDataLoader().loadGameDataConfig();
        pets = config.pets();
    }

    @Test
    void shouldMapPetDefinitionToPetDTO()
    {
        PetDefinitionDTO petDTO = PetMapper.from(pets.get(PetType.BLUE_DRAGONSPAWN));

        Map<Integer, Map<StatType, Double>> statsPerTier = Map.of(
                2, Map.of(StatType.XP_GAIN, 0.05),
                3, Map.of(StatType.XP_GAIN, 0.15),
                4, Map.of(StatType.XP_GAIN, 0.25),
                5, Map.of(StatType.XP_GAIN, 0.35)
        );
        Assertions.assertEquals(PetType.BLUE_DRAGONSPAWN, petDTO.petType());
        Assertions.assertEquals(CollectorBagCategory.DRAGON_SPAWN, petDTO.petCategory());
        Assertions.assertEquals("Blue Dragonspawn", petDTO.name());
        Assertions.assertEquals(5, petDTO.tier());
        Assertions.assertEquals(statsPerTier, petDTO.stats());
        Assertions.assertEquals(Map.of(), petDTO.description());
    }
}
