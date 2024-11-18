package kaukasus.Enums;

public enum AbsoluteStatTypeEnum {

    ANDERMAGIC_RESISTANCE("Andermagic Resistance"),
    ARMOR("Armor Value"),
    ATTACK_SPEED("Attacks per Second"),
    BLOCK_VALUE("Block Value"),
    CRIT_VALUE("Critical Value"),
    DAMAGE("Damage"),
    FIRE_RESISTANCE("Fire Resistance"),
    HEALTH_POINTS("Health Points"),
    HEALTH_PER_SECOND("Health Points per Second"),
    ICE_RESISTANCE("Ice Resistance"),
    LIGHTNING_RESISTANCE("Lightning Resistance"),
    MANA("Mana Points"),
    MANA_PER_SECOND("Mana Points per Second"),
    MOVEMENT_SPEED("Movement Speed"),
    ONE_HAND_DAMAGE("One Hand Damage"),
    POISON_RESISTANCE("Poison Resistance"),
    RESISTANCE("All Resistance Values"),
    TWO_HAND_DAMAGE("Two Hand Damage");



    private final String description;

    AbsoluteStatTypeEnum(String description){
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
