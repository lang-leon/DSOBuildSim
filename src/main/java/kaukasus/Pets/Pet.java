package kaukasus.Pets;

import kaukasus.Enums.OverallBuffTypeEnum;

import java.util.Map;

public class Pet {

    String name;
    Map<OverallBuffTypeEnum, Double> effects;
    String specialEffect;

    public Pet(String name, Map<OverallBuffTypeEnum, Double> effects, String specialEffect) {
        this.name = name;
        this.effects = effects;
        this.specialEffect = specialEffect;
    }

    public String getName() {
        return name;
    }

    public Map<OverallBuffTypeEnum, Double> getEffects() {
        return effects;
    }

    public String getSpecialEffect() {
        return specialEffect;
    }
}
