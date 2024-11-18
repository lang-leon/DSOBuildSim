package kaukasus.Mapper;

import kaukasus.Enums.AbsoluteStatTypeEnum;
import kaukasus.Enums.OverallRelativeBuffTypeEnum;

import java.util.HashMap;
import java.util.Map;

public class AbsoluteToRelativeStatTypeMapper {

    private static final Map<AbsoluteStatTypeEnum, OverallRelativeBuffTypeEnum> map = new HashMap<>();

    static {
        map.put(AbsoluteStatTypeEnum.ANDERMAGIC_RESISTANCE, OverallRelativeBuffTypeEnum.ANDERMAGIC_RESISTANCE);
        map.put(AbsoluteStatTypeEnum.ARMOR, OverallRelativeBuffTypeEnum.ARMOR);
        map.put(AbsoluteStatTypeEnum.ATTACK_SPEED, OverallRelativeBuffTypeEnum.ATTACK_SPEED);
        map.put(AbsoluteStatTypeEnum.BLOCK_VALUE, OverallRelativeBuffTypeEnum.BLOCK_VALUE);
        map.put(AbsoluteStatTypeEnum.CRIT_VALUE, OverallRelativeBuffTypeEnum.CRIT_VALUE);
        map.put(AbsoluteStatTypeEnum.DAMAGE, OverallRelativeBuffTypeEnum.DAMAGE);
        map.put(AbsoluteStatTypeEnum.FIRE_RESISTANCE, OverallRelativeBuffTypeEnum.FIRE_RESISTANCE);
        map.put(AbsoluteStatTypeEnum.HEALTH_POINTS, OverallRelativeBuffTypeEnum.HEALTH_POINTS);
        map.put(AbsoluteStatTypeEnum.HEALTH_PER_SECOND, OverallRelativeBuffTypeEnum.HEALTH_PER_SECOND);
        map.put(AbsoluteStatTypeEnum.ICE_RESISTANCE, OverallRelativeBuffTypeEnum.ICE_RESISTANCE);
        map.put(AbsoluteStatTypeEnum.LIGHTNING_RESISTANCE, OverallRelativeBuffTypeEnum.LIGHTNING_RESISTANCE);
        map.put(AbsoluteStatTypeEnum.MANA, OverallRelativeBuffTypeEnum.MANA);
        map.put(AbsoluteStatTypeEnum.MANA_PER_SECOND, OverallRelativeBuffTypeEnum.MANA_PER_SECOND);
        map.put(AbsoluteStatTypeEnum.MOVEMENT_SPEED, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED);
        map.put(AbsoluteStatTypeEnum.POISON_RESISTANCE, OverallRelativeBuffTypeEnum.POISON_RESISTANCE);
        map.put(AbsoluteStatTypeEnum.RESISTANCE, OverallRelativeBuffTypeEnum.RESISTANCE);
    }

    public static OverallRelativeBuffTypeEnum getRelativeType(AbsoluteStatTypeEnum baseStatType){
        return map.get(baseStatType);
    }
}
