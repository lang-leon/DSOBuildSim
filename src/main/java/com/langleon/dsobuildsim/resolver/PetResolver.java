package com.langleon.dsobuildsim.resolver;

import com.langleon.dsobuildsim.dto.PetDTO;
import com.langleon.dsobuildsim.pets.Pet;
import com.langleon.dsobuildsim.pets.PetFactory;
import com.langleon.dsobuildsim.pets.enums.PetType;

import java.util.List;
import java.util.stream.Collectors;

public class PetResolver {

    private final PetFactory petFactory;

    public PetResolver(PetFactory petFactory) {
        this.petFactory = petFactory;
    }

    public Pet resolvePet(PetDTO petDTO)
    {
        try
        {
            PetType petType = PetType.valueOf(petDTO.petType());
            return petFactory.createPet(petType, petDTO.tier());
        }
        catch (IllegalArgumentException e)
        {
            throw new IllegalArgumentException("Unknown pet type: " + petDTO.petType(), e);
        }
    }
}
