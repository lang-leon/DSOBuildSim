package com.langleon.dsobuildsim.pets;

import com.langleon.dsobuildsim.enums.OverallRelativeBuffType;
import com.langleon.dsobuildsim.enums.pets.PetType;
import com.langleon.dsobuildsim.enums.pets.PetUpgradeType;

import java.util.Map;

public class Pet {
    private final PetType petType;
    private final PetUpgradeType petUpgradeType;
    private final int tier;
    private final Map<OverallRelativeBuffType, Double> stats;
    private final String description;

    public Pet(PetType petType, PetUpgradeType petUpgradeType, int tier, Map<OverallRelativeBuffType, Double> stats, String description) {
        this.petType = petType;
        this.petUpgradeType = petUpgradeType;
        this.tier = tier;
        this.stats = stats;
        this.description = description;
    }

    public PetType getPetType() {
        return petType;
    }

    public PetUpgradeType getPetUpgradeType() {
        return petUpgradeType;
    }

    public int getTier() {
        return tier;
    }

    public Map<OverallRelativeBuffType, Double> getStats() {
        return stats;
    }

    public String getDescription() {
        StringBuilder res = new StringBuilder();
        for (Map.Entry<OverallRelativeBuffType, Double> entry : this.stats.entrySet())
        {
            res.append("+ ").append(String.format("%.2f%%", entry.getValue() * 100)).append(" ").append(entry.getKey()).append("\n");
        }
        res.append(description);
        return res.toString().trim();
    }
}
