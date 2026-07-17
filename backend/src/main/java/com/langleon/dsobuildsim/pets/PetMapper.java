package com.langleon.dsobuildsim.pets;

import com.langleon.dsobuildsim.pets.dto.PetDefinitionDTO;

public class PetMapper {

    public static PetDefinitionDTO from(PetDefinition pet)
    {
        return new PetDefinitionDTO(pet.petType(), pet.petCategory(), pet.petType().getName(), pet.defaultTier(), pet.statsPerTier(), pet.descriptionPerTier());
    }
}
