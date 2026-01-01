package com.langleon.dsobuildsim.mapper;

import com.langleon.dsobuildsim.enums.StatType;

import java.util.HashMap;
import java.util.Map;

public class AbsoluteToRelativeStatTypeMapper {

    private static final Map<StatType, StatType> map = new HashMap<>();

    static {
        map.put(StatType.ANDERMAGIC_RESISTANCE, StatType.ANDERMAGIC_RESISTANCE);
        map.put(StatType.ARMOR_VALUE, StatType.ARMOR_VALUE);
        map.put(StatType.ATTACK_SPEED, StatType.ATTACK_SPEED);
        map.put(StatType.BLOCK_VALUE, StatType.BLOCK_VALUE);
        map.put(StatType.CRIT_VALUE, StatType.CRIT_VALUE);
        map.put(StatType.DAMAGE, StatType.DAMAGE);
        map.put(StatType.FIRE_RESISTANCE, StatType.FIRE_RESISTANCE);
        map.put(StatType.HEALTH_POINTS, StatType.HEALTH_POINTS);
        map.put(StatType.HEALTH_PER_SECOND, StatType.HEALTH_PER_SECOND);
        map.put(StatType.ICE_RESISTANCE, StatType.ICE_RESISTANCE);
        map.put(StatType.LIGHTNING_RESISTANCE, StatType.LIGHTNING_RESISTANCE);
        map.put(StatType.MANA, StatType.MANA);
        map.put(StatType.MANA_PER_SECOND, StatType.MANA_PER_SECOND);
        map.put(StatType.MOVEMENT_SPEED, StatType.MOVEMENT_SPEED);
        map.put(StatType.POISON_RESISTANCE, StatType.POISON_RESISTANCE);
        map.put(StatType.RESISTANCE_VALUE, StatType.RESISTANCE_VALUE);
    }

    public static StatType getRelativeType(StatType baseStatType){
        return map.get(baseStatType);
    }
}
