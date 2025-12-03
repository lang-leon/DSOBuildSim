package com.langleon.dsobuildsim.enums;

public enum AbsoluteStatType {

    ANDERMAGIC_RESISTANCE("Andermagic Resistance", 4440.0),
    ARMOR_VALUE("Armor Value", 1110.0),
    ATTACK_SPEED("Attacks per Second", 0.017),
    BLOCK_VALUE("Block Value", 2520.0),
    CRIT_VALUE("Critical Value", 2520.0),
    DAMAGE("Damage", 700.0),
    FIRE_RESISTANCE("Fire Resistance", 4440.0),
    HEALTH_POINTS("Health Points", 5500.0),
    HEALTH_PER_SECOND("Health Points per Second", 0.0),
    ICE_RESISTANCE("Ice Resistance", 4440.0),
    LIGHTNING_RESISTANCE("Lightning Resistance", 4440.0),
    MANA("Mana Points", 0.0),
    MANA_PER_SECOND("Mana Points per Second", 0.0),
    MOVEMENT_SPEED("Movement Speed", 0.17),
    ONE_HAND_ATTACK_SPEED("One Hand Attack Speed", 0.0),
    ONE_HAND_DAMAGE("One Hand Damage", 0.0),
    POISON_RESISTANCE("Poison Resistance", 4440.0),
    RESISTANCE_VALUE("All Resistance Values", 1110.0),
    TWO_HAND_DAMAGE("Two Hand Damage", 0.0),
    TWO_HAND_ATTACK_SPEED("Two Hand Attack Speed", 0.0);



    private final String description;
    private final Double gemMaxValue;

    AbsoluteStatType(String description, Double gemMaxValue){
        this.description = description;
        this.gemMaxValue = gemMaxValue;
    }

    public Double getGemMaxValue() {
        return gemMaxValue;
    }

    @Override
    public String toString() {
        return description;
    }
}
