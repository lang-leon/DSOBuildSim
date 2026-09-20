package com.langleon.dsobuildsim.pets;

import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.exceptions.InvalidTierException;
import com.langleon.dsobuildsim.gamedata.GameDataConfig;
import com.langleon.dsobuildsim.pets.dto.PetInstanceDTO;
import com.langleon.dsobuildsim.pets.enums.PetType;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class PetFactory {
    private final Map<PetType, PetDefinition> pets;

    public PetFactory(GameDataConfig config) {
        this.pets = config.pets();
    }

    public Pet createPet(PetType petType, int tier)
    {
        PetDefinition petDefinition = this.pets.get(petType);
        Map<StatType, Double> stats = petDefinition.statsPerTier().get(tier);
        if (stats == null) throw new InvalidTierException("Invalid pet tier " + tier + " for pet type "+petType);
        return new Pet(petType, tier, stats, petDefinition.descriptionPerTier().getOrDefault(tier, ""));
    }

    public Pet fromDTO(PetInstanceDTO petDTO)
    {
        try
        {
            PetType petType = petDTO.petType();
            return this.createPet(petType, petDTO.tier());
        }
        catch (IllegalArgumentException e)
        {
            throw new IllegalArgumentException("Unknown pet type: " + petDTO.petType(), e);
        }
    }
}
