package com.langleon.dsobuildsim.common;

public enum StatType {
    ANCIENT_WISDOM_DROP_BONUS("Ancient Wisdom Drop Bonus"),
    ANDERMAGIC_RESISTANCE("Andermagic Resistance"),
    ANDERMANT_DROP_BONUS("Andermant Drop Bonus"),
    ARMOR_VALUE("Armor Value"),
    ATTACK_SPEED("Attack Speed"),
    BLOCK_VALUE("Block Value"),
    CITY_MOVEMENT_SPEED("Movement Speed (only in the Urban Area"),
    COIN_DROP_BONUS("Coin Drop Bonus"),
    COLLECTOR_BAG_BONUS("Increase collector bag bonus"),
    CRIT_VALUE("Critical Value"),
    DAMAGE("Damage"),
    FIRE_RESISTANCE("Fire Resistance"),
    HEALTH_POINTS("Health Points"),
    HEALTH_PER_SECOND("Health Points per Second"),
    HONOR_GAIN("Honor Gain"),
    ICE_RESISTANCE("Ice Resistance"),
    LIGHTNING_RESISTANCE("Lightning Resistance"),
    MANA("Mana Points"),
    MANA_PER_SECOND("Mana Points per Second"),
    MATERI_FRAGMENT_DROP_BONUS("Materi Fragment Drop Bonus"),
    MOVEMENT_SPEED("Movement Speed"),
    ONE_HAND_ATTACK_SPEED("One Hand Attack Speed"),
    ONE_HAND_DAMAGE("One Hand Damage"),
    POISON_RESISTANCE("Poison Resistance"),
    RESISTANCE_VALUE("All Resistance Values"),
    SELL_PRICE("Sell price"),
    TWO_HAND_ATTACK_SPEED("Two Hand Attack Speed"),
    TWO_HAND_DAMAGE("Two Hand Damage"),
    XP_GAIN("XP Gain");


    private final String name;

    StatType(String description){
        this.name = description;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
