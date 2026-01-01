package com.langleon.dsobuildsim.mapper;

import com.langleon.dsobuildsim.enums.EnchantType;
import com.langleon.dsobuildsim.enums.StatType;

import java.util.HashMap;
import java.util.Map;

public class EnchantToAbsoluteStatTypeMapper {

    private static final Map<EnchantType, StatType> map = new HashMap<>();

    static {
        map.put(EnchantType.ANDERMAGIC_RESISTANCE, StatType.ANDERMAGIC_RESISTANCE);
        map.put(EnchantType.ARMOR, StatType.ARMOR_VALUE);
        map.put(EnchantType.ATTACK_SPEED, StatType.ATTACK_SPEED);
        map.put(EnchantType.BLOCK_VALUE, StatType.BLOCK_VALUE);
        map.put(EnchantType.CRIT_VALUE, StatType.CRIT_VALUE);
        map.put(EnchantType.DAMAGE, StatType.DAMAGE);
        map.put(EnchantType.FIRE_RESISTANCE, StatType.FIRE_RESISTANCE);
        map.put(EnchantType.HEALTH_POINTS, StatType.HEALTH_POINTS);
        map.put(EnchantType.ICE_RESISTANCE, StatType.ICE_RESISTANCE);
        map.put(EnchantType.LIGHTNING_RESISTANCE, StatType.LIGHTNING_RESISTANCE);
        map.put(EnchantType.MOVEMENT_SPEED, StatType.MOVEMENT_SPEED);
        map.put(EnchantType.POISON_RESISTANCE, StatType.POISON_RESISTANCE);
        map.put(EnchantType.RESISTANCE, StatType.RESISTANCE_VALUE);
    }

    public static StatType getAbsoluteType(EnchantType enchant){
        return map.get(enchant);
    }
}
