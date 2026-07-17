package com.langleon.dsobuildsim.pets.dto;

import com.langleon.dsobuildsim.pets.enums.PetType;

public record PetInstanceDTO(PetType petType, int tier) {
}
