package kaukasus.Enums;

public enum OverallBuffTypeEnum {
    ANDERMAGIC_RESISTANCE("Andermagic Resistance"),
    ANDERMANT_DROP_BONUS("Andermant Drop Bonus"),
    ARMOR("Armor Value"),
    ATTACK_SPEED("Attack Speed"),
    BLOCK_VALUE("Block Value"),
    CRIT_VALUE("Critical Value"),
    DAMAGE("Damage"),
    FIRE_RESISTANCE("Fire Resistance"),
    HEALTH_POINTS("Health Points"),
    ICE_RESISTANCE("Ice Resistance"),
    LIGHTNING_RESISTANCE("Lightning Resistance"),
    MATERI_FRAGTMENT_DROP_BONUS("Materi Fragment Drop Bonus"),
    MOVEMENT_SPEED("Movement Speed"),
    POISON_RESISTANCE("Poison Resistance"),
    RESISTANCE("All Resistance Values"),
    WISDOM_DROP_BONUS("Wisdom Drop Bonus"),
    XP_GAIN("XP Gain");


    private final String description;

    OverallBuffTypeEnum(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
