package com.langleon.dsobuildsim.pets;

import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.pets.enums.PetType;
import com.langleon.dsobuildsim.pets.enums.PetUpgradeType;

import java.util.Map;

public class Pet {
    private final PetType petType;
    private final int tier;
    private final Map<StatType, Double> stats;
    private final String description;

    public Pet(PetType petType, int tier, Map<StatType, Double> stats, String description) {
        this.petType = petType;
        this.tier = tier;
        this.stats = stats;
        this.description = description;
    }

    public PetType getPetType() {
        return petType;
    }

    public int getTier() {
        return tier;
    }

    public Map<StatType, Double> getRelativeStats() {
        return stats;
    }

    public String getDescription() {
        StringBuilder res = new StringBuilder();
        for (Map.Entry<StatType, Double> entry : this.stats.entrySet())
        {
            res.append("+ ").append(String.format("%.2f%%", entry.getValue() * 100)).append(" ").append(entry.getKey().getName()).append("\n");
        }
        res.append(description);
        return res.toString().trim();
    }
}
