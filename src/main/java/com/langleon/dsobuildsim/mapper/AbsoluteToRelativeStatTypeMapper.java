package com.langleon.dsobuildsim.mapper;

import com.langleon.dsobuildsim.enums.AbsoluteStatType;
import com.langleon.dsobuildsim.enums.OverallRelativeBuffType;

import java.util.HashMap;
import java.util.Map;

public class AbsoluteToRelativeStatTypeMapper {

    private static final Map<AbsoluteStatType, OverallRelativeBuffType> map = new HashMap<>();

    static {
        map.put(AbsoluteStatType.ANDERMAGIC_RESISTANCE, OverallRelativeBuffType.ANDERMAGIC_RESISTANCE);
        map.put(AbsoluteStatType.ARMOR, OverallRelativeBuffType.ARMOR);
        map.put(AbsoluteStatType.ATTACK_SPEED, OverallRelativeBuffType.ATTACK_SPEED);
        map.put(AbsoluteStatType.BLOCK_VALUE, OverallRelativeBuffType.BLOCK_VALUE);
        map.put(AbsoluteStatType.CRIT_VALUE, OverallRelativeBuffType.CRIT_VALUE);
        map.put(AbsoluteStatType.DAMAGE, OverallRelativeBuffType.DAMAGE);
        map.put(AbsoluteStatType.FIRE_RESISTANCE, OverallRelativeBuffType.FIRE_RESISTANCE);
        map.put(AbsoluteStatType.HEALTH_POINTS, OverallRelativeBuffType.HEALTH_POINTS);
        map.put(AbsoluteStatType.HEALTH_PER_SECOND, OverallRelativeBuffType.HEALTH_PER_SECOND);
        map.put(AbsoluteStatType.ICE_RESISTANCE, OverallRelativeBuffType.ICE_RESISTANCE);
        map.put(AbsoluteStatType.LIGHTNING_RESISTANCE, OverallRelativeBuffType.LIGHTNING_RESISTANCE);
        map.put(AbsoluteStatType.MANA, OverallRelativeBuffType.MANA);
        map.put(AbsoluteStatType.MANA_PER_SECOND, OverallRelativeBuffType.MANA_PER_SECOND);
        map.put(AbsoluteStatType.MOVEMENT_SPEED, OverallRelativeBuffType.MOVEMENT_SPEED);
        map.put(AbsoluteStatType.POISON_RESISTANCE, OverallRelativeBuffType.POISON_RESISTANCE);
        map.put(AbsoluteStatType.RESISTANCE, OverallRelativeBuffType.RESISTANCE);
    }

    public static OverallRelativeBuffType getRelativeType(AbsoluteStatType baseStatType){
        return map.get(baseStatType);
    }
}
