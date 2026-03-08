package com.langleon.dsobuildsim.pets;

import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.pets.enums.PetType;
import java.util.Map;

public class PetFactory {
    private final PetConfig config;

    public PetFactory(PetConfig config) {
        this.config = config;
    }

    public int getUpgradeCost(Pet pet)
    {
        switch (pet.getPetUpgradeType())
        {
            case NORMAL -> {
                return this.config.normalUpgradeCosts().get(pet.getTier());
            }
            case SILVERCAT -> {
                return this.config.silverCatUpgradeCosts().get(pet.getTier());
            }
            case GILDEDCAT -> {
                return this.config.gildedCatUpgradeCosts().get(pet.getTier());
            }
            default -> {
                return -1;
            }
        }
    }

    public Pet createPet(PetType petType, int tier)
    {
        PetDefinition petDefinition = this.config.pets().get(petType);
        Map<StatType, Double> stats = petDefinition.statsPerTier().get(tier);
        if (stats == null) throw new IllegalArgumentException("Invalid pet tier: " + tier + "!");
        return new Pet(petType, petDefinition.petUpgradeType(), tier, stats, petDefinition.descriptionPerTier().getOrDefault(tier, ""));
    }

    public Pet createPet(PetType petType)
    {
        PetDefinition petDefinition = this.config.pets().get(petType);
        int tier = petDefinition.defaultTier();
        Map<StatType, Double> stats = petDefinition.statsPerTier().get(tier);
        if (stats == null) throw new IllegalArgumentException("Invalid pet tier: " + tier + "!");
        return new Pet(petType, petDefinition.petUpgradeType(), tier, stats, petDefinition.descriptionPerTier().getOrDefault(tier, ""));
    }
}
