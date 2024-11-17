package kaukasus.Enums;

public enum EnchantTypeEnum {

    ANDERMAGIC_RESISTANCE("Andermagic Resistance", 0.26961),
    ARMOR("Armor Value", 0.27058),
    ATTACK_SPEED("Attacks per Second", 0.47122),
    BLOCK_VALUE("Block Value", 0.24323),
    CRIT_VALUE("Critical Value", 0.24563),
    DAMAGE("Damage", 0.44776),
    FIRE_RESISTANCE("Fire Resistance", 0.26961),
    HEALTH_POINTS("Health Points", 0.44537),
    ICE_RESISTANCE("Ice Resistance", 0.26961),
    LIGHTNING_RESISTANCE("Lightning Resistance", 0.26961),
    MOVEMENT_SPEED("Movement Speed", 0.22450),
    POISON_RESISTANCE("Poison Resistance", 0.26961),
    RESISTANCE("All Resistance Values", 0.27489);


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
