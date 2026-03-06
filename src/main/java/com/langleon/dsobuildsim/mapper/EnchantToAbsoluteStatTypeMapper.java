package com.langleon.dsobuildsim.mapper;

import com.langleon.dsobuildsim.enums.EnchantmentType;
import com.langleon.dsobuildsim.enums.StatType;

import java.util.EnumMap;
import java.util.Map;

public class EnchantToAbsoluteStatTypeMapper {

    private static final Map<EnchantmentType, StatType> map = new EnumMap<>(EnchantmentType.class);

    static {
        map.put(EnchantmentType.ANDERMAGIC_RESISTANCE, StatType.ANDERMAGIC_RESISTANCE);
        map.put(EnchantmentType.ARMOR, StatType.ARMOR_VALUE);
        map.put(EnchantmentType.ATTACK_SPEED, StatType.ATTACK_SPEED);
        map.put(EnchantmentType.BLOCK_VALUE, StatType.BLOCK_VALUE);
        map.put(EnchantmentType.CRIT_VALUE, StatType.CRIT_VALUE);
        map.put(EnchantmentType.DAMAGE, StatType.DAMAGE);
        map.put(EnchantmentType.FIRE_RESISTANCE, StatType.FIRE_RESISTANCE);
        map.put(EnchantmentType.HEALTH_POINTS, StatType.HEALTH_POINTS);
        map.put(EnchantmentType.ICE_RESISTANCE, StatType.ICE_RESISTANCE);
        map.put(EnchantmentType.LIGHTNING_RESISTANCE, StatType.LIGHTNING_RESISTANCE);
        map.put(EnchantmentType.MOVEMENT_SPEED, StatType.MOVEMENT_SPEED);
        map.put(EnchantmentType.POISON_RESISTANCE, StatType.POISON_RESISTANCE);
        map.put(EnchantmentType.RESISTANCE, StatType.RESISTANCE_VALUE);
    }

    public static StatType getAbsoluteType(EnchantmentType enchant){
        return map.get(enchant);
    }
}
