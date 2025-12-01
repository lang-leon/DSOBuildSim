package com.langleon.dsobuildsim.pets;

import com.langleon.dsobuildsim.enums.OverallRelativeBuffType;

import java.util.Map;

public class Pet {

    String name;
    Map<OverallRelativeBuffType, Double> effects;
    String specialEffect;

    public Pet(String name, Map<OverallRelativeBuffType, Double> effects, String specialEffect) {
        this.name = name;
        this.effects = effects;
        this.specialEffect = specialEffect;
    }

    public String getName() {
        return name;
    }

    public Map<OverallRelativeBuffType, Double> getEffects() {
        return effects;
    }

    public String getSpecialEffect() {
        return specialEffect;
    }
}
