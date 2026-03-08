package com.langleon.dsobuildsim.enchantments;

import com.langleon.dsobuildsim.common.StatType;

public enum EnchantmentType {

    ANDERMAGIC_RESISTANCE(StatType.ANDERMAGIC_RESISTANCE, "+ %.3f%% Andermagic resistance on this item", 0.26961),
    ARMOR(StatType.ARMOR_VALUE, "+ %.3f%% amor value on this item", 0.27058),
    ATTACK_SPEED(StatType.ATTACK_SPEED, "+ %.3f%% weapon attack speed on this item", 0.47122),
    BLOCK_VALUE(StatType.BLOCK_VALUE, "+ %.3f%% block value on this item", 0.24323),
    CRIT_VALUE(StatType.CRIT_VALUE, "+ %.3f%% critical value on this item", 0.24563),
    DAMAGE(StatType.DAMAGE, "+ %.3f%% damage on this item", 0.44776),
    FIRE_RESISTANCE(StatType.FIRE_RESISTANCE, "+ %.3f%% Fire resistance on this item", 0.26961),
    HEALTH_POINTS(StatType.HEALTH_POINTS, "+ %.3f%% health points on this item", 0.44537),
    ICE_RESISTANCE(StatType.ICE_RESISTANCE, "+ %.3f%% Ice resistance on this item", 0.26961),
    LIGHTNING_RESISTANCE(StatType.LIGHTNING_RESISTANCE, "+ %.3f%% Lightning resistance on this item", 0.26961),
    MOVEMENT_SPEED(StatType.MOVEMENT_SPEED, "+ %.3f%% movement speed on this item", 0.22450),
    POISON_RESISTANCE(StatType.POISON_RESISTANCE, "+ %.3f%% Poison resistance on this item", 0.26961),
    RESISTANCE(StatType.RESISTANCE_VALUE, "+ %.3f%% all resistance values on this item", 0.27489);

    private final StatType statType;
    private final String description;
    private final Double maxValue;

    EnchantmentType(StatType statType, String description, Double maxValue){
        this.statType = statType;
        this.description = description;
        this.maxValue = maxValue;
    }

    public StatType getStatType() {
        return statType;
    }

    public String getDescription() {
        return description;
    }

    public Double getMaxValue() {
        return maxValue;
    }

    @Override
    public String toString() {
        return description;
    }
}
