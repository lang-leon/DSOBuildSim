package kaukasus.Mapper;

import kaukasus.Enums.AbsoluteStatTypeEnum;
import kaukasus.Enums.EnchantTypeEnum;

import java.util.HashMap;
import java.util.Map;

public class EnchantToAbsoluteStatTypeMapper {
    private static final Map<EnchantTypeEnum, AbsoluteStatTypeEnum> map = new HashMap<>();

    static {
        map.put(EnchantTypeEnum.ANDERMAGIC_RESISTANCE, AbsoluteStatTypeEnum.ANDERMAGIC_RESISTANCE);
        map.put(EnchantTypeEnum.ARMOR, AbsoluteStatTypeEnum.ARMOR);
        map.put(EnchantTypeEnum.ATTACK_SPEED, AbsoluteStatTypeEnum.ATTACK_SPEED);
        map.put(EnchantTypeEnum.BLOCK_VALUE, AbsoluteStatTypeEnum.BLOCK_VALUE);
        map.put(EnchantTypeEnum.CRIT_VALUE, AbsoluteStatTypeEnum.CRIT_VALUE);
        map.put(EnchantTypeEnum.DAMAGE, AbsoluteStatTypeEnum.DAMAGE);
        map.put(EnchantTypeEnum.FIRE_RESISTANCE, AbsoluteStatTypeEnum.FIRE_RESISTANCE);
        map.put(EnchantTypeEnum.HEALTH_POINTS, AbsoluteStatTypeEnum.HEALTH_POINTS);
        map.put(EnchantTypeEnum.ICE_RESISTANCE, AbsoluteStatTypeEnum.ICE_RESISTANCE);
        map.put(EnchantTypeEnum.LIGHTNING_RESISTANCE, AbsoluteStatTypeEnum.LIGHTNING_RESISTANCE);
        map.put(EnchantTypeEnum.MOVEMENT_SPEED, AbsoluteStatTypeEnum.MOVEMENT_SPEED);
        map.put(EnchantTypeEnum.POISON_RESISTANCE, AbsoluteStatTypeEnum.POISON_RESISTANCE);
        map.put(EnchantTypeEnum.RESISTANCE, AbsoluteStatTypeEnum.RESISTANCE);
    }

    public static AbsoluteStatTypeEnum getAbsoluteType(EnchantTypeEnum enchant){
        return map.get(enchant);
    }
}
