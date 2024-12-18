package kaukasus.Items.ItemDatabase.UniqueItems;

import kaukasus.Enchants.UniqueEnchant;
import kaukasus.Enums.*;
import kaukasus.Items.ActualItems.UniqueItem;
import kaukasus.Items.ItemDatabase.Item;
import kaukasus.OverallBuffs.OverallBuff;
import kaukasus.OverallBuffs.OverallDescriptionBuff;
import kaukasus.OverallBuffs.OverallRelativeBuff;

import java.util.List;
import java.util.Map;

public enum DragonknightUniqueItems implements Item {

    BLUEPRINT("blueprint", ItemTypeEnum.AMULET, Map.of(AbsoluteStatTypeEnum.CRIT_VALUE, 0.0, AbsoluteStatTypeEnum.HEALTH_POINTS, 0.0, AbsoluteStatTypeEnum.POISON_RESISTANCE, 0.0), Map.of(), List.of(), List.of(), 145),

    ANCIENT_BATTLE_ADORNMENT("Ancient Battle Adornment", ItemTypeEnum.WEAPON_ADORNMENT, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1841.0, AbsoluteStatTypeEnum.CRIT_VALUE, 2050.0), Map.of(), List.of(new UniqueEnchant(EnchantTypeEnum.CRIT_VALUE, 0.24365)), List.of(new OverallRelativeBuff(OverallRelativeBuffTypeEnum.DAMAGE, 0.05)), 140),
    BALORS_RING_OF_CHAOS("Balor's Ring of Chaos", ItemTypeEnum.RING, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1891.513, AbsoluteStatTypeEnum.HEALTH_POINTS, 74282.408, AbsoluteStatTypeEnum.ANDERMAGIC_RESISTANCE, 4150.0), Map.of(AbsoluteStatTypeEnum.DAMAGE, 2612.0), List.of(new UniqueEnchant(EnchantTypeEnum.ANDERMAGIC_RESISTANCE, 0.26992)), List.of(), 145),
    BELT_OF_ZEAL("Belt of Zeal", ItemTypeEnum.BELT, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1644.883, AbsoluteStatTypeEnum.HEALTH_POINTS, 74282.408, AbsoluteStatTypeEnum.RESISTANCE, 1743.0), Map.of(), List.of(new UniqueEnchant(EnchantTypeEnum.DAMAGE, 0.22384)), List.of(new OverallDescriptionBuff("Belt of Zeal Buff")), 145),
    FIERY_TRACK_OF_GRIMMAG("Fiery Track of Grimmag", ItemTypeEnum.BOOTS, Map.of(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 1.221, AbsoluteStatTypeEnum.ARMOR, 1098.0, AbsoluteStatTypeEnum.FIRE_RESISTANCE, 4150.0), Map.of(AbsoluteStatTypeEnum.FIRE_RESISTANCE, 2433.0), List.of(), List.of(new OverallDescriptionBuff("Increases the Price Fall (III) talent by 5.")), 145),
    GORGONSKIN_LEATHER_BOOTS("Gorgonskin Leather Boots", ItemTypeEnum.BOOTS, Map.of(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 1.221, AbsoluteStatTypeEnum.HEALTH_POINTS, 49522.0, AbsoluteStatTypeEnum.ANDERMAGIC_RESISTANCE, 4150.0), Map.of(AbsoluteStatTypeEnum.ANDERMAGIC_RESISTANCE, 3892.0), List.of(), List.of(new OverallDescriptionBuff("Increases the Rage Jump talent by 4.")), 145),
    INQUIRING_MIND("Inquiring Mind", ItemTypeEnum.BELT, Map.of(AbsoluteStatTypeEnum.HEALTH_POINTS, 72651.0, AbsoluteStatTypeEnum.FIRE_RESISTANCE, 6062.0, AbsoluteStatTypeEnum.ANDERMAGIC_RESISTANCE, 6062.0), Map.of(AbsoluteStatTypeEnum.BLOCK_VALUE, 2069.0), List.of(), List.of(new OverallRelativeBuff(OverallRelativeBuffTypeEnum.RESISTANCE, 0.1)), 140),
    POWERFUL_GEAR("Powerful Gear", ItemTypeEnum.AMULET, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1645.0, AbsoluteStatTypeEnum.CRIT_VALUE, 1754.0, AbsoluteStatTypeEnum.HEALTH_POINTS, 74282.408), Map.of(AbsoluteStatTypeEnum.DAMAGE, 2584.0, AbsoluteStatTypeEnum.FIRE_RESISTANCE, 2433.0), List.of(), List.of(), 145),
    REIGN_OF_TERROR("Reign of Terror", ItemTypeEnum.GLOVES, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1601.0, AbsoluteStatTypeEnum.ATTACK_SPEED, 0.054, AbsoluteStatTypeEnum.ARMOR, 1068.0), Map.of(), List.of(new UniqueEnchant(EnchantTypeEnum.DAMAGE, 0.44221)), List.of(new OverallDescriptionBuff("Controlled Terror Buff")), 145),
    SIGRISMARRS_ETERNAL_WARD("Sigrismarr's Eternal Ward", ItemTypeEnum.TORSO, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1644.883, AbsoluteStatTypeEnum.HEALTH_POINTS, 49521.596, AbsoluteStatTypeEnum.ARMOR, 1648.0), Map.of(AbsoluteStatTypeEnum.ICE_RESISTANCE, 3459.0), List.of(), List.of(new OverallDescriptionBuff("Increases the Smash talent by 3.")), 145),
    THE_HERALDS_BLAZING_ONSLAUGHT("The Herald's Blazing Onslaught", ItemTypeEnum.GLOVES, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1645.0, AbsoluteStatTypeEnum.FIRE_RESISTANCE, 4150.0, AbsoluteStatTypeEnum.ANDERMAGIC_RESISTANCE, 4150.0), Map.of(AbsoluteStatTypeEnum.ANDERMAGIC_RESISTANCE, 3406.0), List.of(), List.of(new OverallDescriptionBuff("Increases the Rising Vigor (III) talent by 4.")), 145),
    WINDING_THUNDER_DRAGON("Winding Thunder Dragon", ItemTypeEnum.TWO_HAND_WEAPON, Map.of(AbsoluteStatTypeEnum.DAMAGE, 26326.0, AbsoluteStatTypeEnum.CRIT_VALUE, 3506.0), Map.of(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.102), List.of(), List.of(new OverallDescriptionBuff("...")), 145),
    ILLUMINATING_FANGS("Illuminating Fangs", ItemTypeEnum.WEAPON_ADORNMENT, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1892.0, AbsoluteStatTypeEnum.ATTACK_SPEED, 0.055, AbsoluteStatTypeEnum.CRIT_VALUE, 2104.0), Map.of(), List.of(new UniqueEnchant(EnchantTypeEnum.DAMAGE, 0.67637), new UniqueEnchant(EnchantTypeEnum.CRIT_VALUE, 0.6126)), List.of(), 145),
    AMULET_OF_THE_BLACK_KNIGHT("Amulet of the Black Knight", ItemTypeEnum.AMULET, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1645.0, AbsoluteStatTypeEnum.HEALTH_POINTS, 74283.0, AbsoluteStatTypeEnum.RESISTANCE, 1162.0), Map.of(), List.of(new UniqueEnchant(EnchantTypeEnum.DAMAGE, 0.67153)), List.of(), 145),
    ABYSSAL_TREASURE_GLOVES("Abyssal Treasure Gloves", ItemTypeEnum.GLOVES, Map.of(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.055, AbsoluteStatTypeEnum.CRIT_VALUE, 1753.505, AbsoluteStatTypeEnum.LIGHTNING_RESISTANCE, 4150.0), Map.of(AbsoluteStatTypeEnum.LIGHTNING_RESISTANCE, 4865.0), List.of(), List.of(new OverallDescriptionBuff("Increases the Mighty Wild Swing talent by 10. Mighty Wild Swing has a 5% chance to petrify hit enemies.")), 145),
    GRAND_MASTERS_SABATONS("Grand Master's Sabatons", ItemTypeEnum.BOOTS, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1601.0, AbsoluteStatTypeEnum.MOVEMENT_SPEED, 1.208, AbsoluteStatTypeEnum.CRIT_VALUE, 1366.0), Map.of(), List.of(new UniqueEnchant(EnchantTypeEnum.MOVEMENT_SPEED, 0.25558)), List.of(new OverallRelativeBuff(OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.1)), 140),
    ;

    private final String name;
    private final ItemTypeEnum itemType;
    private final Map<AbsoluteStatTypeEnum, Double> baseStats;
    private final CharacterClassEnum characterClass;
    private final Map<AbsoluteStatTypeEnum, Double> uniqueBaseStat;
    private final List<UniqueEnchant> uniqueEnchants;
    private final List<OverallBuff> overallBuffs;
    private final int itemLevel;

    DragonknightUniqueItems(String name, ItemTypeEnum itemType, Map<AbsoluteStatTypeEnum, Double> baseStats, Map<AbsoluteStatTypeEnum, Double> uniqueBaseStats, java.util.List<UniqueEnchant> uniqueEnchants, List<OverallBuff> overallBuffs, int itemLevel) {
        this.characterClass = CharacterClassEnum.SPELLWEAVER;
        this.name = name;
        this.itemType = itemType;
        this.baseStats = baseStats;
        this.uniqueBaseStat = uniqueBaseStats;
        this.uniqueEnchants = uniqueEnchants;
        this.overallBuffs = overallBuffs;
        this.itemLevel = itemLevel;
    }

    public UniqueItem getItem() {
        return new UniqueItem(this.name, CharacterClassEnum.SPELLWEAVER, this.itemType, this.baseStats, this.uniqueBaseStat, this.uniqueEnchants, this.overallBuffs, this.itemLevel);
    }

    public CharacterClassEnum getCharacterClass() {
        return characterClass;
    }
}
