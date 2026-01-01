package com.langleon.dsobuildsim.items.itemdatabase.uniqueitems;

import com.langleon.dsobuildsim.enchantments.UniqueEnchant;
import com.langleon.dsobuildsim.enums.*;
import com.langleon.dsobuildsim.items.actualitems.UniqueItem;
import com.langleon.dsobuildsim.items.itemdatabase.Item;
import com.langleon.dsobuildsim.overallbuffs.OverallBuff;
import com.langleon.dsobuildsim.overallbuffs.OverallDescriptionBuff;
import com.langleon.dsobuildsim.overallbuffs.OverallRelativeBuff;

import java.util.List;
import java.util.Map;

public enum DragonknightUniqueItems implements Item {

    BLUEPRINT("blueprint", ItemType.AMULET, Map.of(StatType.CRIT_VALUE, 0.0, StatType.HEALTH_POINTS, 0.0, StatType.POISON_RESISTANCE, 0.0), Map.of(), List.of(), List.of(), 145),

    ANCIENT_BATTLE_ADORNMENT("Ancient Battle Adornment", ItemType.WEAPON_ADORNMENT, Map.of(StatType.DAMAGE, 1841.0, StatType.CRIT_VALUE, 2050.0), Map.of(), List.of(new UniqueEnchant(EnchantType.CRIT_VALUE, 0.24365)), List.of(new OverallRelativeBuff(StatType.DAMAGE, 0.05)), 140),
    BALORS_RING_OF_CHAOS("Balor's Ring of Chaos", ItemType.RING, Map.of(StatType.DAMAGE, 1891.513, StatType.HEALTH_POINTS, 74282.408, StatType.ANDERMAGIC_RESISTANCE, 4150.0), Map.of(StatType.DAMAGE, 2612.0), List.of(new UniqueEnchant(EnchantType.ANDERMAGIC_RESISTANCE, 0.26992)), List.of(), 145),
    BELT_OF_ZEAL("Belt of Zeal", ItemType.BELT, Map.of(StatType.DAMAGE, 1644.883, StatType.HEALTH_POINTS, 74282.408, StatType.RESISTANCE_VALUE, 1743.0), Map.of(), List.of(new UniqueEnchant(EnchantType.DAMAGE, 0.22384)), List.of(new OverallDescriptionBuff("Belt of Zeal Buff")), 145),
    FIERY_TRACK_OF_GRIMMAG("Fiery Track of Grimmag", ItemType.BOOTS, Map.of(StatType.MOVEMENT_SPEED, 1.221, StatType.ARMOR_VALUE, 1098.0, StatType.FIRE_RESISTANCE, 4150.0), Map.of(StatType.FIRE_RESISTANCE, 2433.0), List.of(), List.of(new OverallDescriptionBuff("Increases the Price Fall (III) talent by 5.")), 145),
    GORGONSKIN_LEATHER_BOOTS("Gorgonskin Leather Boots", ItemType.BOOTS, Map.of(StatType.MOVEMENT_SPEED, 1.221, StatType.HEALTH_POINTS, 49522.0, StatType.ANDERMAGIC_RESISTANCE, 4150.0), Map.of(StatType.ANDERMAGIC_RESISTANCE, 3892.0), List.of(), List.of(new OverallDescriptionBuff("Increases the Rage Jump talent by 4.")), 145),
    INQUIRING_MIND("Inquiring Mind", ItemType.BELT, Map.of(StatType.HEALTH_POINTS, 72651.0, StatType.FIRE_RESISTANCE, 6062.0, StatType.ANDERMAGIC_RESISTANCE, 6062.0), Map.of(StatType.BLOCK_VALUE, 2069.0), List.of(), List.of(new OverallRelativeBuff(StatType.RESISTANCE_VALUE, 0.1)), 140),
    POWERFUL_GEAR("Powerful Gear", ItemType.AMULET, Map.of(StatType.DAMAGE, 1645.0, StatType.CRIT_VALUE, 1754.0, StatType.HEALTH_POINTS, 74282.408), Map.of(StatType.DAMAGE, 2584.0, StatType.FIRE_RESISTANCE, 2433.0), List.of(), List.of(), 145),
    REIGN_OF_TERROR("Reign of Terror", ItemType.GLOVES, Map.of(StatType.DAMAGE, 1601.0, StatType.ATTACK_SPEED, 0.054, StatType.ARMOR_VALUE, 1068.0), Map.of(), List.of(new UniqueEnchant(EnchantType.DAMAGE, 0.44221)), List.of(new OverallDescriptionBuff("Controlled Terror Buff")), 145),
    SIGRISMARRS_ETERNAL_WARD("Sigrismarr's Eternal Ward", ItemType.TORSO, Map.of(StatType.DAMAGE, 1644.883, StatType.HEALTH_POINTS, 49521.596, StatType.ARMOR_VALUE, 1648.0), Map.of(StatType.ICE_RESISTANCE, 3459.0), List.of(), List.of(new OverallDescriptionBuff("Increases the Smash talent by 3.")), 145),
    THE_HERALDS_BLAZING_ONSLAUGHT("The Herald's Blazing Onslaught", ItemType.GLOVES, Map.of(StatType.DAMAGE, 1645.0, StatType.FIRE_RESISTANCE, 4150.0, StatType.ANDERMAGIC_RESISTANCE, 4150.0), Map.of(StatType.ANDERMAGIC_RESISTANCE, 3406.0), List.of(), List.of(new OverallDescriptionBuff("Increases the Rising Vigor (III) talent by 4.")), 145),
    WINDING_THUNDER_DRAGON("Winding Thunder Dragon", ItemType.TWO_HAND_WEAPON, Map.of(StatType.DAMAGE, 26326.0, StatType.CRIT_VALUE, 3506.0), Map.of(StatType.ATTACK_SPEED, 0.102), List.of(), List.of(new OverallDescriptionBuff("...")), 145),
    ILLUMINATING_FANGS("Illuminating Fangs", ItemType.WEAPON_ADORNMENT, Map.of(StatType.DAMAGE, 1892.0, StatType.ATTACK_SPEED, 0.055, StatType.CRIT_VALUE, 2104.0), Map.of(), List.of(new UniqueEnchant(EnchantType.DAMAGE, 0.67637), new UniqueEnchant(EnchantType.CRIT_VALUE, 0.6126)), List.of(), 145),
    AMULET_OF_THE_BLACK_KNIGHT("Amulet of the Black Knight", ItemType.AMULET, Map.of(StatType.DAMAGE, 1645.0, StatType.HEALTH_POINTS, 74283.0, StatType.RESISTANCE_VALUE, 1162.0), Map.of(), List.of(new UniqueEnchant(EnchantType.DAMAGE, 0.67153)), List.of(), 145),
    ABYSSAL_TREASURE_GLOVES("Abyssal Treasure Gloves", ItemType.GLOVES, Map.of(StatType.ATTACK_SPEED, 0.055, StatType.CRIT_VALUE, 1753.505, StatType.LIGHTNING_RESISTANCE, 4150.0), Map.of(StatType.LIGHTNING_RESISTANCE, 4865.0), List.of(), List.of(new OverallDescriptionBuff("Increases the Mighty Wild Swing talent by 10. Mighty Wild Swing has a 5% chance to petrify hit enemies.")), 145),
    GRAND_MASTERS_SABATONS("Grand Master's Sabatons", ItemType.BOOTS, Map.of(StatType.DAMAGE, 1601.0, StatType.MOVEMENT_SPEED, 1.208, StatType.CRIT_VALUE, 1366.0), Map.of(), List.of(new UniqueEnchant(EnchantType.MOVEMENT_SPEED, 0.25558)), List.of(new OverallRelativeBuff(StatType.CRIT_VALUE, 0.1)), 140),
    SARGONS_SHADOW_AMULET("Sargon's Shadow Amulet", ItemType.AMULET, Map.of(StatType.DAMAGE, 1601.0, StatType.MOVEMENT_SPEED, 0.489, StatType.HEALTH_POINTS, 74282.0), Map.of(StatType.DAMAGE, 3771.0), List.of(), List.of(), 140),
    KINGSHILLS_NECKLACE("Kingshill Necklace", ItemType.AMULET, Map.of(StatType.HEALTH_PER_SECOND, 74283.0, StatType.RESISTANCE_VALUE, 1162.0, StatType.BLOCK_VALUE, 1897.0), Map.of(StatType.HEALTH_POINTS, 43615.0), List.of(), List.of(), 145),
    GRAND_MASTERS_ARMOR("Grand Master's Armor", ItemType.TORSO, Map.of(StatType.HEALTH_POINTS, 48435.0, StatType.ARMOR_VALUE, 1603.0, StatType.RESISTANCE_VALUE, 1697.0), Map.of(StatType.HEALTH_PER_SECOND, 3615.886), List.of(), List.of(new OverallRelativeBuff(StatType.HEALTH_POINTS, 0.05)), 140),
    GRAND_MASTERS_GLOVES("Grand Master's Gloves", ItemType.GLOVES, Map.of(StatType.MOVEMENT_SPEED, 0.484, StatType.ARMOR_VALUE, 1068.0, StatType.RESISTANCE_VALUE, 1131.0), Map.of(), List.of(new UniqueEnchant(EnchantType.RESISTANCE, 0.27198)), List.of(new OverallRelativeBuff(StatType.ARMOR_VALUE, 0.1)), 140),
    JUSTICE("Justice", ItemType.OFF_HAND, Map.of(StatType.HEALTH_POINTS, 99067.0, StatType.ARMOR_VALUE, 2197.0, StatType.BLOCK_VALUE, 47683.0), Map.of(StatType.HEALTH_POINTS, 44463.0), List.of(), List.of(), 145),
    ;

    private final String name;
    private final ItemType itemType;
    private final Map<StatType, Double> baseStats;
    private final CharacterClass characterClass;
    private final Map<StatType, Double> uniqueBaseStat;
    private final List<UniqueEnchant> uniqueEnchants;
    private final List<OverallBuff> overallBuffs;
    private final int itemLevel;

    DragonknightUniqueItems(String name, ItemType itemType, Map<StatType, Double> baseStats, Map<StatType, Double> uniqueBaseStats, java.util.List<UniqueEnchant> uniqueEnchants, List<OverallBuff> overallBuffs, int itemLevel) {
        this.characterClass = CharacterClass.SPELLWEAVER;
        this.name = name;
        this.itemType = itemType;
        this.baseStats = baseStats;
        this.uniqueBaseStat = uniqueBaseStats;
        this.uniqueEnchants = uniqueEnchants;
        this.overallBuffs = overallBuffs;
        this.itemLevel = itemLevel;
    }

    public UniqueItem getItem() {
        return new UniqueItem(this.name, CharacterClass.SPELLWEAVER, this.itemType, this.baseStats, this.uniqueBaseStat, this.uniqueEnchants, this.overallBuffs, this.itemLevel);
    }

    public CharacterClass getCharacterClass() {
        return characterClass;
    }
}
