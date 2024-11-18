package kaukasus.Enums;

public enum OverallRelativeBuffTypeEnum {
    ANDERMAGIC_RESISTANCE("Andermagic Resistance"),
    ANDERMANT_DROP_BONUS("Andermant Drop Bonus"),
    ARMOR("Armor Value"),
    ATTACK_SPEED("Attack Speed"),
    BLOCK_VALUE("Block Value"),
    COIN_DROP_BONUS("Coin Drop Bonus"),
    CRIT_VALUE("Critical Value"),
    DAMAGE("Damage"),
    FIRE_RESISTANCE("Fire Resistance"),
    HEALTH_POINTS("Health Points"),
    HEALTH_PER_SECOND("Health Points per Second"),
    HONOR_GAIN("Honor Gain"),
    ICE_RESISTANCE("Ice Resistance"),
    LIGHTNING_RESISTANCE("Lightning Resistance"),
    MANA("Mana Points"),
    MANA_PER_SECOND("Mana Points per Second"),
    MATERI_FRAGMENT_DROP_BONUS("Materi Fragment Drop Bonus"),
    MOVEMENT_SPEED("Movement Speed"),
    ONE_HAND_DAMAGE("One Hand Damage"),
    POISON_RESISTANCE("Poison Resistance"),
    RESISTANCE("All Resistance Values"),
    TWO_HAND_DAMAGE("Two Hand Damage"),
    WISDOM_DROP_BONUS("Wisdom Drop Bonus"),
    XP_GAIN("XP Gain");


    private final String description;

    OverallRelativeBuffTypeEnum(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
