package kaukasus.Enums;

public enum EnchantTypeEnum {

    ANDERMAGIC_RESISTANCE("Andermagic Resistance", 0.2696),
    ARMOR("Armor Value", 0.2706),
    ATTACK_SPEED("Attacks per Second", 0.47122),
    BLOCK_VALUE("Block Value", 0.2432),
    CRIT_VALUE("Critical Value", 0.24563),
    DAMAGE("Damage", 0.4476),
    FIRE_RESISTANCE("Fire Resistance", 0.2696),
    HEALTH_POINTS("Health Points", 0.44537),
    ICE_RESISTANCE("Ice Resistance", 0.2696),
    LIGHTNING_RESISTANCE("Lightning Resistance", 0.2696),
    MOVEMENT_SPEED("Movement Speed", 0.2245),
    POISON_RESISTANCE("Poison Resistance", 0.2696),
    RESISTANCE("All Resistance Values", 0.2749);


    private final String description;
    private final Double maxValue;

    EnchantTypeEnum(String description, Double maxValue){
        this.description = description;
        this.maxValue = maxValue;
    }

    public String getDescription() {
        return description;
    }

    public Double getMaxValue() {
        return maxValue;
    }
}
