package com.langleon.dsobuildsim.mapper;

import com.langleon.dsobuildsim.enums.AbsoluteStatType;
import com.langleon.dsobuildsim.enums.EnchantType;

import java.util.HashMap;
import java.util.Map;

public class EnchantToAbsoluteStatTypeMapper {

    private static final Map<EnchantType, AbsoluteStatType> map = new HashMap<>();

    static {
        map.put(EnchantType.ANDERMAGIC_RESISTANCE, AbsoluteStatType.ANDERMAGIC_RESISTANCE);
        map.put(EnchantType.ARMOR, AbsoluteStatType.ARMOR_VALUE);
        map.put(EnchantType.ATTACK_SPEED, AbsoluteStatType.ATTACK_SPEED);
        map.put(EnchantType.BLOCK_VALUE, AbsoluteStatType.BLOCK_VALUE);
        map.put(EnchantType.CRIT_VALUE, AbsoluteStatType.CRIT_VALUE);
        map.put(EnchantType.DAMAGE, AbsoluteStatType.DAMAGE);
        map.put(EnchantType.FIRE_RESISTANCE, AbsoluteStatType.FIRE_RESISTANCE);
        map.put(EnchantType.HEALTH_POINTS, AbsoluteStatType.HEALTH_POINTS);
        map.put(EnchantType.ICE_RESISTANCE, AbsoluteStatType.ICE_RESISTANCE);
        map.put(EnchantType.LIGHTNING_RESISTANCE, AbsoluteStatType.LIGHTNING_RESISTANCE);
        map.put(EnchantType.MOVEMENT_SPEED, AbsoluteStatType.MOVEMENT_SPEED);
        map.put(EnchantType.POISON_RESISTANCE, AbsoluteStatType.POISON_RESISTANCE);
        map.put(EnchantType.RESISTANCE, AbsoluteStatType.RESISTANCE_VALUE);
    }

    public static AbsoluteStatType getAbsoluteType(EnchantType enchant){
        return map.get(enchant);
    }
}
