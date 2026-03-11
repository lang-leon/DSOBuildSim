package com.langleon.dsobuildsim.mapper;

import com.langleon.dsobuildsim.dto.PetDTO;
import com.langleon.dsobuildsim.pets.PetDefinition;

public class PetMapper {

    public static PetDTO from(PetDefinition pet)
    {
        return new PetDTO(pet.petType(), pet.petCategory(), pet.petType().getName(), pet.defaultTier(), pet.statsPerTier(), pet.descriptionPerTier());
    }
}
