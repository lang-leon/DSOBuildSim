package kaukasus.Pets;

import kaukasus.Enums.OverallRelativeBuffTypeEnum;

import java.util.Map;

public class Pet {

    String name;
    Map<OverallRelativeBuffTypeEnum, Double> effects;
    String specialEffect;

    public Pet(String name, Map<OverallRelativeBuffTypeEnum, Double> effects, String specialEffect) {
        this.name = name;
        this.effects = effects;
        this.specialEffect = specialEffect;
    }

    public String getName() {
        return name;
    }

    public Map<OverallRelativeBuffTypeEnum, Double> getEffects() {
        return effects;
    }

    public String getSpecialEffect() {
        return specialEffect;
    }
}
