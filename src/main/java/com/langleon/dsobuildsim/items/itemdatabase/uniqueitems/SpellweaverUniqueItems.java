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

public enum SpellweaverUniqueItems implements Item {

    BLUEPRINT("blueprint", ItemType.ONE_HAND_WEAPON, Map.of(StatType.CRIT_VALUE, .0, StatType.HEALTH_POINTS, .0, StatType.POISON_RESISTANCE, .0), Map.of(), List.of(), List.of(), 145),

    //amulets
    AMULET_OF_DEFLECTION("Amulet of Deflection", ItemType.AMULET, Map.of(StatType.CRIT_VALUE, 1754.0, StatType.HEALTH_POINTS, 24761.0, StatType.POISON_RESISTANCE, 4150.0), Map.of(StatType.MOVEMENT_SPEED, 0.168), List.of(), List.of(new OverallDescriptionBuff("Makes you immune to the self-damage caused by the Jewel of Poisonous Thorns' effect.")), 145),
    AMULET_OF_ZEAL("Amulet of Zeal", ItemType.AMULET, Map.of(StatType.DAMAGE, 1644.883, StatType.MOVEMENT_SPEED, 0.489, StatType.ARMOR_VALUE, 1098.0), Map.of(), List.of(), List.of(new OverallDescriptionBuff("Whenever you defeat enemies you will generate Protective Energy. If you heath drops below 33% the accumulated Protective Energy will generate a shield around you, increasing your armor by 2% for each stack of Protective Energy for 20 seconds.")), 145),
    AMULET_OF_THE_BLACK_KNIGHT("Amulet of the Black Knight", ItemType.AMULET, Map.of(StatType.DAMAGE, 1644.883, StatType.HEALTH_POINTS, 24761.00, StatType.RESISTANCE_VALUE, 1162.0), Map.of(), List.of(new UniqueEnchant(EnchantType.DAMAGE,  0.67153)), List.of(), 145),
    AMULET_OF_THE_KRAKEN("Amulet of the Kraken", ItemType.AMULET, Map.of(StatType.CRIT_VALUE, 1753.505, StatType.HEALTH_POINTS, 24760.80, StatType.POISON_RESISTANCE, 4150.0), Map.of(StatType.POISON_RESISTANCE, 3406.0), List.of(), List.of(new OverallDescriptionBuff("Increases the Frost Wind talent by 4.")), 145),
    AMULET_OF_THE_REALMS("Amulet of the Realms", ItemType.AMULET, Map.of(StatType.HEALTH_POINTS, 24217.0, StatType.ARMOR_VALUE, 1068.0, StatType.RESISTANCE_VALUE, 1131.0), Map.of(), List.of(), List.of(new OverallDescriptionBuff("Increases the Realm Changer talent by 2."), new OverallDescriptionBuff("+ 2 drop stack size of Realm Fragment")), 140),
    ARACHNAS_VIGOR_OF_THE_SPIDER("Arachna's Vigor of the Spider", ItemType.AMULET, Map.of(StatType.DAMAGE, 1644.883, StatType.CRIT_VALUE , 1754.0, StatType.HEALTH_POINTS, 24761.0), Map.of(StatType.POISON_RESISTANCE, 592.0), List.of(), List.of(new OverallDescriptionBuff("Increases the Singularity talent by 4.")), 145),
    BRONZE_HELIOS_AMULET("Bronze Helios Amulet", ItemType.AMULET, Map.of(StatType.HEALTH_POINTS, 24761.0, StatType.ARMOR_VALUE, 1098.0, StatType.BLOCK_VALUE, 1987.0), Map.of(StatType.ARMOR_VALUE, 1921.0), List.of(), List.of(), 145),
    GOLDEN_HELIOS_AMULET("Golden Helios Amulet", ItemType.AMULET, Map.of(StatType.HEALTH_POINTS, 24761.0, StatType.ARMOR_VALUE, 1098.0, StatType.BLOCK_VALUE, 1987.0), Map.of(StatType.ARMOR_VALUE, 357.0), List.of(new UniqueEnchant(EnchantType.BLOCK_VALUE, 0.11283)), List.of(new OverallDescriptionBuff("+ 1 Gilded Clover drop stack size")), 145),
    KINGSHILL_NECKLACE("Kingshill Necklace", ItemType.AMULET, Map.of(StatType.HEALTH_POINTS, 24761.0, StatType.RESISTANCE_VALUE, 1162.0, StatType.BLOCK_VALUE, 1987.0), Map.of(StatType.HEALTH_POINTS, 43615.0), List.of(), List.of(), 145),
    MYSTICAL_GEAR("Mystical Gear", ItemType.AMULET, Map.of(StatType.DAMAGE, 1644.883, StatType.CRIT_VALUE, 1754.0, StatType.HEALTH_POINTS, 24761.0), Map.of(StatType.DAMAGE, 2584.0, StatType.FIRE_RESISTANCE, 2433.0), List.of(), List.of(), 145),
    SARGONS_SHADOW_AMULET("Sargon's Shadow Amulet", ItemType.AMULET, Map.of(StatType.DAMAGE, 1601.0, StatType.MOVEMENT_SPEED, 0.489, StatType.HEALTH_POINTS, 24761.0), Map.of(StatType.DAMAGE, 3771.0), List.of(), List.of(), 140),
    SEAL_OF_BETRAYAL("Seal of Betrayal", ItemType.AMULET, Map.of(StatType.DAMAGE, 1644.883, StatType.CRIT_VALUE, 1754.0, StatType.HEALTH_POINTS, 24761.0), Map.of(StatType.HEALTH_PER_SECOND, 14734.086), List.of(), List.of(), 145),
    SILVER_HELIOS_AMULET("Silver Helios Amulet", ItemType.AMULET, Map.of(StatType.HEALTH_POINTS, 24761.0, StatType.ARMOR_VALUE, 1098.0, StatType.BLOCK_VALUE, 1987.0), Map.of(StatType.ARMOR_VALUE, 1281.0), List.of(new UniqueEnchant(EnchantType.BLOCK_VALUE, 0.24364)), List.of(), 145),
    SPIRITUAL_TREASURE("Spiritual Treasure", ItemType.AMULET, Map.of(StatType.DAMAGE, 1644.883, StatType.HEALTH_POINTS, 24761.0, StatType.RESISTANCE_VALUE, 1162.0), Map.of(), List.of(), List.of(new OverallDescriptionBuff("When your Health Points drop below 30%, you will enter the Soul Revival state, which restores 10% of your maximum Health Points every second for 10 seconds (PVP: 3 seconds). \nCooldown: 100 Seconds")), 145),

    //cloaks
    ADAMANT_MAGMA("Adamant Magma", ItemType.CLOAK, Map.of(StatType.DAMAGE, 1892.0, StatType.CRIT_VALUE, 2104.0, StatType.HEALTH_POINTS, 16507.0), Map.of(StatType.HEALTH_POINTS, 21383.0), List.of(), List.of(new OverallDescriptionBuff("Fireball will shoot a dual fireball instead of the normal one. Each fireball will deal 75% of the normal fireball damage.")), 145),
    CLOAK_OF_HEROES("Cloak of Heroes", ItemType.CLOAK, Map.of(StatType.DAMAGE, 1892.0, StatType.ATTACK_SPEED, 0.006, StatType.HEALTH_POINTS, 16507.0), Map.of(StatType.DAMAGE, 1949.0, StatType.MOVEMENT_SPEED, 0.129), List.of(), List.of(), 145),
    CLOAK_OF_THE_UNDEFEATABLES("Cloak of the Undefeatables", ItemType.CLOAK, Map.of(StatType.HEALTH_POINTS, 24761.0, StatType.ARMOR_VALUE, 1373.0, StatType.RESISTANCE_VALUE, 1452.0), Map.of(), List.of(), List.of(new OverallDescriptionBuff("50% less time to summon mounts")), 145),
    DUPLICITOUS_TROPHY("Duplicitous Trophy", ItemType.CLOAK, Map.of(StatType.HEALTH_POINTS, 24761.0, StatType.POISON_RESISTANCE, 5188.0, StatType.BLOCK_VALUE, 2384.0), Map.of(StatType.MOVEMENT_SPEED, 0.084), List.of(), List.of(new OverallDescriptionBuff("Teleport will petrify nearby enemies at the point of origin for 3 seconds.")), 145),
    GWENFARAS_GHOSTLY_SHROUD("Gwenfara's Ghostly Shroud", ItemType.CLOAK, Map.of(StatType.ARMOR_VALUE, 1373.0, StatType.RESISTANCE_VALUE, 1452.0, StatType.BLOCK_VALUE, 2384.0), Map.of(StatType.MOVEMENT_SPEED, 0.252), List.of(), List.of(new OverallDescriptionBuff("50% less time to summon Mounts")), 145),
    KAYLIN_LEFRYES_COAT("Kaylin Lefrye's Coat", ItemType.CLOAK, Map.of(StatType.DAMAGE, 1892.0, StatType.CRIT_VALUE, 2104.0, StatType.HEALTH_POINTS, 16507.0), Map.of(StatType.CRIT_VALUE, 1624.0, StatType.MANA, 7.0), List.of(), List.of(), 145),
    MERCILESS_TERROR("Merciless Terror", ItemType.CLOAK, Map.of(StatType.HEALTH_POINTS, 24217.0, StatType.ARMOR_VALUE, 1335.0, StatType.LIGHTNING_RESISTANCE, 5052.0), Map.of(), List.of(new UniqueEnchant(EnchantType.HEALTH_POINTS, 0.4415)), List.of(new OverallDescriptionBuff("Controlled Terror Effect")), 140),
    WINTER_FESTIVAL_BAG("Winter Festival Bag", ItemType.CLOAK, Map.of(StatType.HEALTH_POINTS, 24761.0, StatType.RESISTANCE_VALUE, 1452.0, StatType.BLOCK_VALUE, 2384.0), Map.of(), List.of(), List.of(new OverallDescriptionBuff("+ 3.0-10.0% chance of finding items from regular monsters")), 145),

    //belts
    BEARACHS_INSTICT("Bearach's Instinct", ItemType.BELT, Map.of(StatType.DAMAGE, 1644.883, StatType.HEALTH_POINTS, 24760.80, StatType.LIGHTNING_RESISTANCE, 6226.0), Map.of(StatType.LIGHTNING_RESISTANCE, 4941.0), List.of(), List.of(new OverallDescriptionBuff("Increases the Lightning Strike talent by 4.")), 145),
    BELT_OF_ZEAL("Belt of Zeal", ItemType.BELT, Map.of(StatType.DAMAGE, 1644.883, StatType.HEALTH_POINTS, 24760.80, StatType.RESISTANCE_VALUE, 1743.0), Map.of(), List.of(new UniqueEnchant(EnchantType.DAMAGE, 0.22384)), List.of(new OverallDescriptionBuff("Belt of Zeal Buff")), 145),
    INQUIRING_MIND("Inquiring Mind", ItemType.BELT, Map.of(StatType.HEALTH_POINTS, 24217.0, StatType.FIRE_RESISTANCE, 6062.0, StatType.ANDERMAGIC_RESISTANCE, 6062.0), Map.of(StatType.BLOCK_VALUE, 2069.0), List.of(), List.of(new OverallRelativeBuff(StatType.RESISTANCE_VALUE, 0.1)), 140),

    //rings


    //helmet //todo world drop helmet
    ABYSSAL_TREASURE_HELMET("Abyssal Treasure Helmet", ItemType.HELMET, Map.of(StatType.HEALTH_POINTS, 20638.0, StatType.ARMOR_VALUE, 1098.0, StatType.ANDERMAGIC_RESISTANCE, 4150.0), Map.of(StatType.ARMOR_VALUE, 1281.0, StatType.MANA, 10.0), List.of(), List.of(), 145),
    HEREDURS_ROYAL_POWER("Heredur's Royal Power", ItemType.HELMET, Map.of(StatType.DAMAGE, 1645.0, StatType.CRIT_VALUE, 1402.0, StatType.BLOCK_VALUE, 1589.0), Map.of(StatType.ICE_RESISTANCE, 3406.0), List.of(), List.of(new OverallDescriptionBuff("Increases the Frost Charge talent by 4.")), 145),
    KHALYS_DARK_GAZE("Khaly's Dark Gaze", ItemType.HELMET, Map.of(StatType.DAMAGE, 1645.0, StatType.HEALTH_POINTS, 20638.0, StatType.ARMOR_VALUE, 1098.0), Map.of(StatType.MANA, 10.0), List.of(), List.of(new OverallDescriptionBuff("Increases the Mind Control talent by 3.")), 145),
    STRAW_HAT("Straw Hat", ItemType.HELMET, Map.of(StatType.DAMAGE, 1645.0, StatType.MOVEMENT_SPEED, 0.489, StatType.HEALTH_POINTS, 20638.0), Map.of(StatType.HEALTH_PER_SECOND, 11050.562), List.of(), List.of(), 145),
    SPEECHLESS_TERROR("Speechless Terror", ItemType.HELMET, Map.of(StatType.CRIT_VALUE, 1366.0, StatType.HEALTH_POINTS, 20185.0, StatType.FIRE_RESISTANCE, 4041.0), Map.of(), List.of(new UniqueEnchant(EnchantType.CRIT_VALUE, 0.24365)), List.of(new OverallDescriptionBuff("Controlled Terror Effect")), 140),
    TODO9("blueprint", ItemType.HELMET, Map.of(StatType.CRIT_VALUE, .0, StatType.HEALTH_POINTS, .0, StatType.POISON_RESISTANCE, .0), Map.of(), List.of(), List.of(), 145),


    //shoulders
    ABYSSAL_TREASURE_PAULDRONS("Abyssal Treasure Pauldrons", ItemType.SHOULDERS, Map.of(StatType.DAMAGE, 1892.0, StatType.HEALTH_POINTS, 16507.0, StatType.POISON_RESISTANCE, 4150.0), Map.of(StatType.POISON_RESISTANCE, 4865.0), List.of(), List.of(new OverallDescriptionBuff("Increases the Magic Missile talent by 10."), new OverallDescriptionBuff("Magic Missile reduces the poison resistance of hit enemies by 50% for 10 seconds (PvP: 5 seconds). (Effect not stackable)")), 145),
    KHALYS_DARK_SCHEME("Khaly's Dark Scheme", ItemType.SHOULDERS, Map.of(StatType.DAMAGE, 1892.0, StatType.ARMOR_VALUE, 1098.0, StatType.RESISTANCE_VALUE, 1162.0), Map.of(StatType.ANDERMAGIC_RESISTANCE, 2433.0), List.of(), List.of(new OverallDescriptionBuff("...")), 145),
    MASTERS_PAULDRONS("Master's Pauldrons", ItemType.SHOULDERS, Map.of(StatType.DAMAGE, 1892.0, StatType.HEALTH_POINTS, 16507.0, StatType.ARMOR_VALUE, 1098.0), Map.of(StatType.CRIT_VALUE, 1396.0, StatType.ATTACK_SPEED, 0.09), List.of(), List.of(), 145),
    PAULDRONS_OF_THE_FEROCIOUS_BEAST("Pauldrons of the Ferocious Beast", ItemType.SHOULDERS, Map.of(StatType.HEALTH_POINTS, 16507.0, StatType.ARMOR_VALUE, 1098.0, StatType.RESISTANCE_VALUE, 1162.0), Map.of(StatType.MOVEMENT_SPEED, 0.336), List.of(), List.of(), 145),
    ROYAL_PAULDRONS_OF_SINGULARITY("Royal Pauldrons of Singularity", ItemType.SHOULDERS, Map.of(StatType.ARMOR_VALUE, 1098.0, StatType.RESISTANCE_VALUE, 1162.0, StatType.BLOCK_VALUE, 1589.0), Map.of(StatType.MANA, 5.0), List.of(), List.of(new OverallDescriptionBuff("- Singularity% cooldown time for 20.00")), 145),
    TERRIBLE_TRIBUNAL("Terrible Tribunal", ItemType.SHOULDERS, Map.of(StatType.ARMOR_VALUE, 1068.0, StatType.ICE_RESISTANCE, 4041.0, StatType.BLOCK_VALUE, 1549.0), Map.of(), List.of(new UniqueEnchant(EnchantType.BLOCK_VALUE, 24.184)), List.of(new OverallDescriptionBuff("Controlled Terror Effect")), 140),


    //torso
    ARMOR_OF_THE_BLACK_KNIGHT("Armor of the Black Knight", ItemType.TORSO, Map.of(StatType.DAMAGE, 1645.0, StatType.HEALTH_POINTS, 16507.0, StatType.ARMOR_VALUE, 1648.0), Map.of(), List.of(new UniqueEnchant(EnchantType.ARMOR, 0.40632)), List.of(), 145),
    DESTRUCTOR_PLATED_ROBES("Destructor Plated Robes", ItemType.TORSO, Map.of(StatType.DAMAGE, 1645.0, StatType.HEALTH_POINTS, 16507.0, StatType.ARMOR_VALUE, 1648.0), Map.of(StatType.ATTACK_SPEED, 0.106, StatType.FIRE_RESISTANCE, 2471.0), List.of(), List.of(), 145),
    GREAT_TERROR("Great Terror", ItemType.TORSO, Map.of(StatType.CRIT_VALUE, 1366.0, StatType.ARMOR_VALUE, 1603.0, StatType.ANDERMAGIC_RESISTANCE, 6062.0), Map.of(), List.of(new UniqueEnchant(EnchantType.ARMOR, 0.26832)), List.of(new OverallDescriptionBuff("Controlled Terror Effect")), 145),
    GRIMMAGS_STARRY_ROBE("Grimmag's Starry Robe", ItemType.TORSO, Map.of(StatType.DAMAGE, 1645.0, StatType.MOVEMENT_SPEED, 0.489, StatType.HEALTH_POINTS, 16507.0), Map.of(StatType.MANA, 36.0, StatType.MANA_PER_SECOND, 9.0), List.of(), List.of(), 145),
    REMINS_BATTLE_HARNESS("Remin's Battle Harness", ItemType.TORSO, Map.of(StatType.DAMAGE, 1645.0, StatType.HEALTH_POINTS, 16507.0, StatType.ARMOR_VALUE, 1648.0), Map.of(StatType.RESISTANCE_VALUE, 1375.0, StatType.BLOCK_VALUE, 1052.0), List.of(), List.of(), 145),
    RESEARCHERS_COAT("Researcher's Coat", ItemType.TORSO, Map.of(StatType.HEALTH_POINTS, 16145.0, StatType.ARMOR_VALUE, 1603.0, StatType.RESISTANCE_VALUE, 1697.0), Map.of(StatType.HEALTH_PER_SECOND, 3615.886), List.of(), List.of(new OverallRelativeBuff(StatType.HEALTH_POINTS, 0.05)), 140),
    SIGRISMARRS_ETERNAL_WARD("Sigrismarr's Eternal Ward", ItemType.TORSO, Map.of(StatType.DAMAGE, 1644.883, StatType.HEALTH_POINTS, 16507.0, StatType.ARMOR_VALUE, 1648.0), Map.of(StatType.ICE_RESISTANCE, 3459.0), List.of(), List.of(new OverallDescriptionBuff("Increases the Frozen Sphere talent by 3.")), 145),


    //gloves
    ABYSSAL_TREASURE_GLOVES("Abyssal Treasure Gloves", ItemType.GLOVES, Map.of(StatType.ATTACK_SPEED, 0.055, StatType.CRIT_VALUE, 1753.505, StatType.LIGHTNING_RESISTANCE, 4150.0), Map.of(StatType.LIGHTNING_RESISTANCE, 4865.0), List.of(), List.of(new OverallDescriptionBuff("Increases the Frozen Sphere talent by 10. Frozen Sphere has a 5% chance to petrify hit enemies.")), 145),
    GLOVES_OF_THE_BLACK_KNIGHT("Gloves of the Black Knight", ItemType.GLOVES, Map.of(StatType.DAMAGE, 1645.0, StatType.ATTACK_SPEED, 0.055, StatType.RESISTANCE_VALUE, 1162.0), Map.of(), List.of(new UniqueEnchant(EnchantType.RESISTANCE, 0.41173)), List.of(), 145),
    GLOVES_OF_ZEAL("Gloves of Zeal", ItemType.GLOVES, Map.of(StatType.HEALTH_POINTS, 16507.0, StatType.ARMOR_VALUE, 1098.0, StatType.RESISTANCE_VALUE, 1162.0), Map.of(), List.of(new UniqueEnchant(EnchantType.HEALTH_POINTS, 0.22295)), List.of(new OverallDescriptionBuff("When you defeat an enemy, your armor and all resistances will be increased by 0,15%. This effect lasts for 1 Minute or until you have been defeated. This effect can stack up to 100 times.")), 145),
    REIGN_OF_TERROR("Reign of Terror", ItemType.GLOVES, Map.of(StatType.DAMAGE, 1601.0, StatType.ATTACK_SPEED, 0.054, StatType.ARMOR_VALUE, 1068.0), Map.of(), List.of(new UniqueEnchant(EnchantType.DAMAGE, 0.44221)), List.of(new OverallDescriptionBuff("Controlled Terror Buff")), 140),
    RESEARCHERS_GAUNTLETS("Researcher's Gauntlets", ItemType.GLOVES, Map.of(StatType.MOVEMENT_SPEED, 0.484, StatType.ARMOR_VALUE, 1068.0, StatType.RESISTANCE_VALUE, 1131.0), Map.of(), List.of(new UniqueEnchant(EnchantType.RESISTANCE, 0.27198)), List.of(new OverallRelativeBuff(StatType.ARMOR_VALUE, 0.1)), 140),
    THE_HERALDS_BLAZING_ONSLAUGHT("The Herald's Blazing Onslaught", ItemType.GLOVES, Map.of(StatType.DAMAGE, 1645.0, StatType.FIRE_RESISTANCE, 4150.0, StatType.ANDERMAGIC_RESISTANCE, 4150.0), Map.of(StatType.ANDERMAGIC_RESISTANCE, 3406.0), List.of(), List.of(new OverallDescriptionBuff("Increases the Rising Vigor (III) talent by 4.")), 145),

    //boots //todo lapis lazuli boots
    BOOTS_OF_THE_BLACK_KNIGHT("Boots of the Black Knight", ItemType.BOOTS, Map.of(StatType.MOVEMENT_SPEED, 1.221, StatType.HEALTH_POINTS, 16507.0, StatType.RESISTANCE_VALUE, 1162.0), Map.of(), List.of(new UniqueEnchant(EnchantType.MOVEMENT_SPEED, 0.3856)), List.of(), 145),
    DEADLY_TERROR("Deadly Terror", ItemType.BOOTS, Map.of(StatType.MOVEMENT_SPEED, 1.208, StatType.ARMOR_VALUE, 1068.0, StatType.POISON_RESISTANCE, 4041.0), Map.of(), List.of(new UniqueEnchant(EnchantType.MOVEMENT_SPEED, 0.25558)), List.of(new OverallDescriptionBuff("Controlled Terror Effect")), 140),
    FIERY_TRACKS_OF_GRIMMAG("Fiery Tracks of Grimmag", ItemType.BOOTS, Map.of(StatType.MOVEMENT_SPEED, 1.221, StatType.ARMOR_VALUE, 1098.0, StatType.FIRE_RESISTANCE, 4150.0), Map.of(StatType.FIRE_RESISTANCE, 2433.0), List.of(), List.of(new OverallDescriptionBuff("Increases the Price Fall (II) talent by5.")), 145),
    GORGONSKIN_LEATHER_BOOTS("Gorgonskin Leather Boots", ItemType.BOOTS, Map.of(StatType.MOVEMENT_SPEED, 1.221, StatType.HEALTH_POINTS, 16507.0, StatType.ANDERMAGIC_RESISTANCE, 4150.0), Map.of(StatType.ANDERMAGIC_RESISTANCE, 3892.0), List.of(), List.of(new OverallDescriptionBuff("Increases the Teleport talent by 4.")), 145),
    RESEARCHERS_BOOTS("Researcher's Boots", ItemType.BOOTS, Map.of(StatType.DAMAGE, 1601.0, StatType.MOVEMENT_SPEED, 1.208, StatType.CRIT_VALUE, 1366.0), Map.of(), List.of(new UniqueEnchant(EnchantType.MOVEMENT_SPEED, 0.25558)), List.of(new OverallRelativeBuff(StatType.CRIT_VALUE, 0.1)), 140),
    TODO3("blueprint", ItemType.BOOTS, Map.of(StatType.CRIT_VALUE, .0, StatType.HEALTH_POINTS, .0, StatType.POISON_RESISTANCE, .0), Map.of(), List.of(), List.of(), 145),

    //weapon adornment
    ADORNMENT_OF_THE_VANQUISHER("Adornment of the Vanquisher", ItemType.WEAPON_ADORNMENT, Map.of(StatType.ATTACK_SPEED, 0.055, StatType.CRIT_VALUE, 2104.0), Map.of(), List.of(), List.of(new OverallDescriptionBuff("Whenever you defeat an enemy you will get the Frenzy of the Vanquisher buff that increases your critical value by 0.1%. This effect lasts for 1 minute or until you have been defeated. It can stack up to 100 times.")), 145),
    ANCIENT_BATTLE_ADORNMENT("Ancient Battle Adornment", ItemType.WEAPON_ADORNMENT, Map.of(StatType.DAMAGE, 1841.0, StatType.CRIT_VALUE, 2050.0), Map.of(), List.of(new UniqueEnchant(EnchantType.CRIT_VALUE, 0.24365)), List.of(new OverallRelativeBuff(StatType.DAMAGE, 0.05)), 140),
    GRIMMAGS_FLAMING_WRATH("Grimmag's Flaming Wrath", ItemType.WEAPON_ADORNMENT, Map.of(StatType.ATTACK_SPEED, 0.055, StatType.CRIT_VALUE, 2104.0), Map.of(StatType.DAMAGE, 1306.0), List.of(), List.of(new OverallDescriptionBuff("Increases the Fire Blast talent by 2.")), 145),
    SIGRISMARRS_ETERNAL_GRASP("Sigrismarr's Eternal Grasp", ItemType.WEAPON_ADORNMENT, Map.of(StatType.DAMAGE, 1891.513, StatType.CRIT_VALUE, 2104.0), Map.of(StatType.ATTACK_SPEED, 0.06), List.of(), List.of(new OverallDescriptionBuff("Increases the Ice Missile talent by 5")), 145),
    STINGER("Stinger", ItemType.WEAPON_ADORNMENT, Map.of(StatType.DAMAGE, 1891.513, StatType.ATTACK_SPEED, 0.055, StatType.CRIT_VALUE, 2104.0), Map.of(), List.of(new UniqueEnchant(EnchantType.DAMAGE, 0.67637), new UniqueEnchant(EnchantType.CRIT_VALUE, 0.60126)), List.of(), 145),


    //two hand weapon


    //one hand weapon //todo oasis staff
    ARACHNAS_VENOMOUS_REVENGE("Arachna's Venomous Revenge", ItemType.ONE_HAND_WEAPON, Map.of(StatType.DAMAGE, 2057.0, StatType.ATTACK_SPEED, 0.220, StatType.CRIT_VALUE, 2104.0), Map.of(StatType.DAMAGE, 1842.0), List.of(), List.of(new OverallDescriptionBuff("...")), 145),
    TODO2("blueprint", ItemType.ONE_HAND_WEAPON, Map.of(StatType.CRIT_VALUE, .0, StatType.HEALTH_POINTS, .0, StatType.POISON_RESISTANCE, .0), Map.of(), List.of(), List.of(), 145),
    GWENFARAS_GHOST_CLAW("Gwenfara's Ghost Claw", ItemType.ONE_HAND_WEAPON, Map.of(StatType.DAMAGE, 2057.0, StatType.ATTACK_SPEED, 0.220, StatType.CRIT_VALUE, 2104.0), Map.of(StatType.CRIT_VALUE, 2166.0), List.of(), List.of(new OverallDescriptionBuff("...")), 145),
    STAFF_OF_DESTRUCTION("Staff of Destruction", ItemType.ONE_HAND_WEAPON, Map.of(StatType.DAMAGE, 2057.0, StatType.CRIT_VALUE, 2104.0), Map.of(StatType.CRIT_VALUE, 2166.0, StatType.FIRE_RESISTANCE, 2282.0), List.of(), List.of(), 145),
    STARLIGHT("Starlight", ItemType.ONE_HAND_WEAPON, Map.of(StatType.DAMAGE, 2057.0, StatType.ATTACK_SPEED, 0.439), Map.of(StatType.MANA, 19.0), List.of(), List.of(), 145),


    //books
    BITING_TOMB("Biting Tomb", ItemType.OFF_HAND, Map.of(StatType.ATTACK_SPEED, 0.109, StatType.CRIT_VALUE, 2104.0), Map.of(), List.of(new UniqueEnchant(EnchantType.ATTACK_SPEED, 0.9432)), List.of(), 145),
    BOOK_OF_CONDEMNATION("Book of Condemnation", ItemType.OFF_HAND, Map.of(StatType.HEALTH_POINTS, 33022.0, StatType.ARMOR_VALUE, 2197.0, StatType.BLOCK_VALUE, 47683.0), Map.of(StatType.MANA, 7.0, StatType.RESISTANCE_VALUE, 1050.0), List.of(), List.of(), 145),
    GWENFARAS_GHOSTLY_ALMANAC("Gwenfara's Ghostly Almanac", ItemType.OFF_HAND, Map.of(StatType.ATTACK_SPEED, 0.109, StatType.CRIT_VALUE, 2104.0), Map.of(StatType.CRIT_VALUE, 2166.0), List.of(), List.of(new OverallDescriptionBuff("...")), 145),
    ROYAL_TOME_OF_THE_GUARDIANS("Royal Tome of the Guardians", ItemType.OFF_HAND, Map.of(StatType.DAMAGE, 3292.0, StatType.CRIT_VALUE, 2104.0), Map.of(StatType.ATTACK_SPEED, 0.043), List.of(), List.of(new OverallDescriptionBuff("Increases the Rising Vigor (III) talent by 4.")), 145),
    SHARR_KHARABS_SCROLL("Sharr Kharab's Scroll", ItemType.OFF_HAND, Map.of(StatType.ATTACK_SPEED, 0.109, StatType.CRIT_VALUE, 2104.0), Map.of(), List.of(), List.of(new OverallDescriptionBuff("There is a 8% chance that the fists of Sharr Kharab will attack your enemies after using Magic Missile and cause 100% of your base damage as physical damage.")), 145),

    //orbs
    HEREDURS_ROYAL_SHIELD("Heredur's Royal Shield", ItemType.OFF_HAND, Map.of(StatType.ARMOR_VALUE, 2197.0, StatType.RESISTANCE_VALUE, 2324.0, StatType.BLOCK_VALUE, 47683.0), Map.of(), List.of(new UniqueEnchant(EnchantType.BLOCK_VALUE, 0.12183)), List.of(new OverallDescriptionBuff("Increases the Frost Nova talent by 2.")), 145),
    RIDDLE("Riddle", ItemType.OFF_HAND, Map.of(StatType.HEALTH_POINTS, 33022.0, StatType.ARMOR_VALUE, 2197.0, StatType.BLOCK_VALUE, 47683.0), Map.of(StatType.HEALTH_POINTS, 44463.0), List.of(), List.of(), 145),



    GRIMACE_OF_THE_THUNDER_BEAST("Grimace of the Thunder Beast", ItemType.TWO_HAND_WEAPON, Map.of(StatType.DAMAGE, 26326.0, StatType.CRIT_VALUE, 3506.0), Map.of(StatType.ATTACK_SPEED, 0.102), List.of(), List.of(new OverallDescriptionBuff("Anni Weapon Buff")), 145),;

    private final String name;
    private final ItemType itemType;
    private final Map<StatType, Double> baseStats;
    private final CharacterClass characterClass;
    private final Map<StatType, Double> uniqueBaseStat;
    private final List<UniqueEnchant> uniqueEnchants;
    private final List<OverallBuff> overallBuffs;
    private final int itemLevel;

    SpellweaverUniqueItems(String name, ItemType itemType, Map<StatType, Double> baseStats, Map<StatType, Double> uniqueBaseStats, java.util.List<UniqueEnchant> uniqueEnchants, List<OverallBuff> overallBuffs, int itemLevel) {
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
