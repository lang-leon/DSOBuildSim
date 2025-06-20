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

public enum SpellweaverUniqueItems implements Item {

    BLUEPRINT("blueprint", ItemTypeEnum.ONE_HAND_WEAPON, Map.of(AbsoluteStatTypeEnum.CRIT_VALUE, .0, AbsoluteStatTypeEnum.HEALTH_POINTS, .0, AbsoluteStatTypeEnum.POISON_RESISTANCE, .0), Map.of(), List.of(), List.of(), 145),

    //amulets
    AMULET_OF_DEFLECTION("Amulet of Deflection", ItemTypeEnum.AMULET, Map.of(AbsoluteStatTypeEnum.CRIT_VALUE, 1754.0, AbsoluteStatTypeEnum.HEALTH_POINTS, 24761.0, AbsoluteStatTypeEnum.POISON_RESISTANCE, 4150.0), Map.of(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.168), List.of(), List.of(new OverallDescriptionBuff("Makes you immune to the self-damage caused by the Jewel of Poisonous Thorns' effect.")), 145),
    AMULET_OF_ZEAL("Amulet of Zeal", ItemTypeEnum.AMULET, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1644.883, AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.489, AbsoluteStatTypeEnum.ARMOR, 1098.0), Map.of(), List.of(), List.of(new OverallDescriptionBuff("Whenever you defeat enemies you will generate Protective Energy. If you heath drops below 33% the accumulated Protective Energy will generate a shield around you, increasing your armor by 2% for each stack of Protective Energy for 20 seconds.")), 145),
    AMULET_OF_THE_BLACK_KNIGHT("Amulet of the Black Knight", ItemTypeEnum.AMULET, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1644.883, AbsoluteStatTypeEnum.HEALTH_POINTS, 24761.00, AbsoluteStatTypeEnum.RESISTANCE, 1162.0), Map.of(), List.of(new UniqueEnchant(EnchantTypeEnum.DAMAGE,  0.67153)), List.of(), 145),
    AMULET_OF_THE_KRAKEN("Amulet of the Kraken", ItemTypeEnum.AMULET, Map.of(AbsoluteStatTypeEnum.CRIT_VALUE, 1753.505, AbsoluteStatTypeEnum.HEALTH_POINTS, 24760.80, AbsoluteStatTypeEnum.POISON_RESISTANCE, 4150.0), Map.of(AbsoluteStatTypeEnum.POISON_RESISTANCE, 3406.0), List.of(), List.of(new OverallDescriptionBuff("Increases the Frost Wind talent by 4.")), 145),
    AMULET_OF_THE_REALMS("Amulet of the Realms", ItemTypeEnum.AMULET, Map.of(AbsoluteStatTypeEnum.HEALTH_POINTS, 24217.0, AbsoluteStatTypeEnum.ARMOR, 1068.0, AbsoluteStatTypeEnum.RESISTANCE, 1131.0), Map.of(), List.of(), List.of(new OverallDescriptionBuff("Increases the Realm Changer talent by 2."), new OverallDescriptionBuff("+ 2 drop stack size of Realm Fragment")), 140),
    ARACHNAS_VIGOR_OF_THE_SPIDER("Arachna's Vigor of the Spider", ItemTypeEnum.AMULET, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1644.883, AbsoluteStatTypeEnum.CRIT_VALUE , 1754.0, AbsoluteStatTypeEnum.HEALTH_POINTS, 24761.0), Map.of(AbsoluteStatTypeEnum.POISON_RESISTANCE, 592.0), List.of(), List.of(new OverallDescriptionBuff("Increases the Singularity talent by 4.")), 145),
    BRONZE_HELIOS_AMULET("Bronze Helios Amulet", ItemTypeEnum.AMULET, Map.of(AbsoluteStatTypeEnum.HEALTH_POINTS, 24761.0, AbsoluteStatTypeEnum.ARMOR, 1098.0, AbsoluteStatTypeEnum.BLOCK_VALUE, 1987.0), Map.of(AbsoluteStatTypeEnum.ARMOR, 1921.0), List.of(), List.of(), 145),
    GOLDEN_HELIOS_AMULET("Golden Helios Amulet", ItemTypeEnum.AMULET, Map.of(AbsoluteStatTypeEnum.HEALTH_POINTS, 24761.0, AbsoluteStatTypeEnum.ARMOR, 1098.0, AbsoluteStatTypeEnum.BLOCK_VALUE, 1987.0), Map.of(AbsoluteStatTypeEnum.ARMOR, 357.0), List.of(new UniqueEnchant(EnchantTypeEnum.BLOCK_VALUE, 0.11283)), List.of(new OverallDescriptionBuff("+ 1 Gilded Clover drop stack size")), 145),
    KINGSHILL_NECKLACE("Kingshill Necklace", ItemTypeEnum.AMULET, Map.of(AbsoluteStatTypeEnum.HEALTH_POINTS, 24761.0, AbsoluteStatTypeEnum.RESISTANCE, 1162.0, AbsoluteStatTypeEnum.BLOCK_VALUE, 1987.0), Map.of(AbsoluteStatTypeEnum.HEALTH_POINTS, 43615.0), List.of(), List.of(), 145),
    MYSTICAL_GEAR("Mystical Gear", ItemTypeEnum.AMULET, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1644.883, AbsoluteStatTypeEnum.CRIT_VALUE, 1754.0, AbsoluteStatTypeEnum.HEALTH_POINTS, 24761.0), Map.of(AbsoluteStatTypeEnum.DAMAGE, 2584.0, AbsoluteStatTypeEnum.FIRE_RESISTANCE, 2433.0), List.of(), List.of(), 145),
    SARGONS_SHADOW_AMULET("Sargon's Shadow Amulet", ItemTypeEnum.AMULET, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1601.0, AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.489, AbsoluteStatTypeEnum.HEALTH_POINTS, 24761.0), Map.of(AbsoluteStatTypeEnum.DAMAGE, 3771.0), List.of(), List.of(), 140),
    SEAL_OF_BETRAYAL("Seal of Betrayal", ItemTypeEnum.AMULET, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1644.883, AbsoluteStatTypeEnum.CRIT_VALUE, 1754.0, AbsoluteStatTypeEnum.HEALTH_POINTS, 24761.0), Map.of(AbsoluteStatTypeEnum.HEALTH_PER_SECOND, 14734.086), List.of(), List.of(), 145),
    SILVER_HELIOS_AMULET("Silver Helios Amulet", ItemTypeEnum.AMULET, Map.of(AbsoluteStatTypeEnum.HEALTH_POINTS, 24761.0, AbsoluteStatTypeEnum.ARMOR, 1098.0, AbsoluteStatTypeEnum.BLOCK_VALUE, 1987.0), Map.of(AbsoluteStatTypeEnum.ARMOR, 1281.0), List.of(new UniqueEnchant(EnchantTypeEnum.BLOCK_VALUE, 0.24364)), List.of(), 145),
    SPIRITUAL_TREASURE("Spiritual Treasure", ItemTypeEnum.AMULET, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1644.883, AbsoluteStatTypeEnum.HEALTH_POINTS, 24761.0, AbsoluteStatTypeEnum.RESISTANCE, 1162.0), Map.of(), List.of(), List.of(new OverallDescriptionBuff("When your Health Points drop below 30%, you will enter the Soul Revival state, which restores 10% of your maximum Health Points every second for 10 seconds (PVP: 3 seconds). \nCooldown: 100 Seconds")), 145),

    //cloaks
    ADAMANT_MAGMA("Adamant Magma", ItemTypeEnum.CLOAK, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1892.0, AbsoluteStatTypeEnum.CRIT_VALUE, 2104.0, AbsoluteStatTypeEnum.HEALTH_POINTS, 16507.0), Map.of(AbsoluteStatTypeEnum.HEALTH_POINTS, 21383.0), List.of(), List.of(new OverallDescriptionBuff("Fireball will shoot a dual fireball instead of the normal one. Each fireball will deal 75% of the normal fireball damage.")), 145),
    CLOAK_OF_HEROES("Cloak of Heroes", ItemTypeEnum.CLOAK, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1892.0, AbsoluteStatTypeEnum.ATTACK_SPEED, 0.006, AbsoluteStatTypeEnum.HEALTH_POINTS, 16507.0), Map.of(AbsoluteStatTypeEnum.DAMAGE, 1949.0, AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.129), List.of(), List.of(), 145),
    CLOAK_OF_THE_UNDEFEATABLES("Cloak of the Undefeatables", ItemTypeEnum.CLOAK, Map.of(AbsoluteStatTypeEnum.HEALTH_POINTS, 24761.0, AbsoluteStatTypeEnum.ARMOR, 1373.0, AbsoluteStatTypeEnum.RESISTANCE, 1452.0), Map.of(), List.of(), List.of(new OverallDescriptionBuff("50% less time to summon mounts")), 145),
    DUPLICITOUS_TROPHY("Duplicitous Trophy", ItemTypeEnum.CLOAK, Map.of(AbsoluteStatTypeEnum.HEALTH_POINTS, 24761.0, AbsoluteStatTypeEnum.POISON_RESISTANCE, 5188.0, AbsoluteStatTypeEnum.BLOCK_VALUE, 2384.0), Map.of(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.084), List.of(), List.of(new OverallDescriptionBuff("Teleport will petrify nearby enemies at the point of origin for 3 seconds.")), 145),
    GWENFARAS_GHOSTLY_SHROUD("Gwenfara's Ghostly Shroud", ItemTypeEnum.CLOAK, Map.of(AbsoluteStatTypeEnum.ARMOR, 1373.0, AbsoluteStatTypeEnum.RESISTANCE, 1452.0, AbsoluteStatTypeEnum.BLOCK_VALUE, 2384.0), Map.of(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.252), List.of(), List.of(new OverallDescriptionBuff("50% less time to summon Mounts")), 145),
    KAYLIN_LEFRYES_COAT("Kaylin Lefrye's Coat", ItemTypeEnum.CLOAK, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1892.0, AbsoluteStatTypeEnum.CRIT_VALUE, 2104.0, AbsoluteStatTypeEnum.HEALTH_POINTS, 16507.0), Map.of(AbsoluteStatTypeEnum.CRIT_VALUE, 1624.0, AbsoluteStatTypeEnum.MANA, 7.0), List.of(), List.of(), 145),
    MERCILESS_TERROR("Merciless Terror", ItemTypeEnum.CLOAK, Map.of(AbsoluteStatTypeEnum.HEALTH_POINTS, 24217.0, AbsoluteStatTypeEnum.ARMOR, 1335.0, AbsoluteStatTypeEnum.LIGHTNING_RESISTANCE, 5052.0), Map.of(), List.of(new UniqueEnchant(EnchantTypeEnum.HEALTH_POINTS, 0.4415)), List.of(new OverallDescriptionBuff("Controlled Terror Effect")), 140),
    WINTER_FESTIVAL_BAG("Winter Festival Bag", ItemTypeEnum.CLOAK, Map.of(AbsoluteStatTypeEnum.HEALTH_POINTS, 24761.0, AbsoluteStatTypeEnum.RESISTANCE, 1452.0, AbsoluteStatTypeEnum.BLOCK_VALUE, 2384.0), Map.of(), List.of(), List.of(new OverallDescriptionBuff("+ 3.0-10.0% chance of finding items from regular monsters")), 145),

    //belts
    BEARACHS_INSTICT("Bearach's Instinct", ItemTypeEnum.BELT, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1644.883, AbsoluteStatTypeEnum.HEALTH_POINTS, 24760.80, AbsoluteStatTypeEnum.LIGHTNING_RESISTANCE, 6226.0), Map.of(AbsoluteStatTypeEnum.LIGHTNING_RESISTANCE, 4941.0), List.of(), List.of(new OverallDescriptionBuff("Increases the Lightning Strike talent by 4.")), 145),
    BELT_OF_ZEAL("Belt of Zeal", ItemTypeEnum.BELT, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1644.883, AbsoluteStatTypeEnum.HEALTH_POINTS, 24760.80, AbsoluteStatTypeEnum.RESISTANCE, 1743.0), Map.of(), List.of(new UniqueEnchant(EnchantTypeEnum.DAMAGE, 0.22384)), List.of(new OverallDescriptionBuff("Belt of Zeal Buff")), 145),
    INQUIRING_MIND("Inquiring Mind", ItemTypeEnum.BELT, Map.of(AbsoluteStatTypeEnum.HEALTH_POINTS, 24217.0, AbsoluteStatTypeEnum.FIRE_RESISTANCE, 6062.0, AbsoluteStatTypeEnum.ANDERMAGIC_RESISTANCE, 6062.0), Map.of(AbsoluteStatTypeEnum.BLOCK_VALUE, 2069.0), List.of(), List.of(new OverallRelativeBuff(OverallRelativeBuffTypeEnum.RESISTANCE, 0.1)), 140),

    //rings


    //helmet //todo world drop helmet
    ABYSSAL_TREASURE_HELMET("Abyssal Treasure Helmet", ItemTypeEnum.HELMET, Map.of(AbsoluteStatTypeEnum.HEALTH_POINTS, 20638.0, AbsoluteStatTypeEnum.ARMOR, 1098.0, AbsoluteStatTypeEnum.ANDERMAGIC_RESISTANCE, 4150.0), Map.of(AbsoluteStatTypeEnum.ARMOR, 1281.0, AbsoluteStatTypeEnum.MANA, 10.0), List.of(), List.of(), 145),
    HEREDURS_ROYAL_POWER("Heredur's Royal Power", ItemTypeEnum.HELMET, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1645.0, AbsoluteStatTypeEnum.CRIT_VALUE, 1402.0, AbsoluteStatTypeEnum.BLOCK_VALUE, 1589.0), Map.of(AbsoluteStatTypeEnum.ICE_RESISTANCE, 3406.0), List.of(), List.of(new OverallDescriptionBuff("Increases the Frost Charge talent by 4.")), 145),
    KHALYS_DARK_GAZE("Khaly's Dark Gaze", ItemTypeEnum.HELMET, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1645.0, AbsoluteStatTypeEnum.HEALTH_POINTS, 20638.0, AbsoluteStatTypeEnum.ARMOR, 1098.0), Map.of(AbsoluteStatTypeEnum.MANA, 10.0), List.of(), List.of(new OverallDescriptionBuff("Increases the Mind Control talent by 3.")), 145),
    STRAW_HAT("Straw Hat", ItemTypeEnum.HELMET, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1645.0, AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.489, AbsoluteStatTypeEnum.HEALTH_POINTS, 20638.0), Map.of(AbsoluteStatTypeEnum.HEALTH_PER_SECOND, 11050.562), List.of(), List.of(), 145),
    SPEECHLESS_TERROR("Speechless Terror", ItemTypeEnum.HELMET, Map.of(AbsoluteStatTypeEnum.CRIT_VALUE, 1366.0, AbsoluteStatTypeEnum.HEALTH_POINTS, 20185.0, AbsoluteStatTypeEnum.FIRE_RESISTANCE, 4041.0), Map.of(), List.of(new UniqueEnchant(EnchantTypeEnum.CRIT_VALUE, 0.24365)), List.of(new OverallDescriptionBuff("Controlled Terror Effect")), 140),
    TODO9("blueprint", ItemTypeEnum.HELMET, Map.of(AbsoluteStatTypeEnum.CRIT_VALUE, .0, AbsoluteStatTypeEnum.HEALTH_POINTS, .0, AbsoluteStatTypeEnum.POISON_RESISTANCE, .0), Map.of(), List.of(), List.of(), 145),


    //shoulders
    ABYSSAL_TREASURE_PAULDRONS("Abyssal Treasure Pauldrons", ItemTypeEnum.SHOULDERS, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1892.0, AbsoluteStatTypeEnum.HEALTH_POINTS, 16507.0, AbsoluteStatTypeEnum.POISON_RESISTANCE, 4150.0), Map.of(AbsoluteStatTypeEnum.POISON_RESISTANCE, 4865.0), List.of(), List.of(new OverallDescriptionBuff("Increases the Magic Missile talent by 10."), new OverallDescriptionBuff("Magic Missile reduces the poison resistance of hit enemies by 50% for 10 seconds (PvP: 5 seconds). (Effect not stackable)")), 145),
    KHALYS_DARK_SCHEME("Khaly's Dark Scheme", ItemTypeEnum.SHOULDERS, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1892.0, AbsoluteStatTypeEnum.ARMOR, 1098.0, AbsoluteStatTypeEnum.RESISTANCE, 1162.0), Map.of(AbsoluteStatTypeEnum.ANDERMAGIC_RESISTANCE, 2433.0), List.of(), List.of(new OverallDescriptionBuff("...")), 145),
    MASTERS_PAULDRONS("Master's Pauldrons", ItemTypeEnum.SHOULDERS, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1892.0, AbsoluteStatTypeEnum.HEALTH_POINTS, 16507.0, AbsoluteStatTypeEnum.ARMOR, 1098.0), Map.of(AbsoluteStatTypeEnum.CRIT_VALUE, 1396.0, AbsoluteStatTypeEnum.ATTACK_SPEED, 0.09), List.of(), List.of(), 145),
    PAULDRONS_OF_THE_FEROCIOUS_BEAST("Pauldrons of the Ferocious Beast", ItemTypeEnum.SHOULDERS, Map.of(AbsoluteStatTypeEnum.HEALTH_POINTS, 16507.0, AbsoluteStatTypeEnum.ARMOR, 1098.0, AbsoluteStatTypeEnum.RESISTANCE, 1162.0), Map.of(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.336), List.of(), List.of(), 145),
    ROYAL_PAULDRONS_OF_SINGULARITY("Royal Pauldrons of Singularity", ItemTypeEnum.SHOULDERS, Map.of(AbsoluteStatTypeEnum.ARMOR, 1098.0, AbsoluteStatTypeEnum.RESISTANCE, 1162.0, AbsoluteStatTypeEnum.BLOCK_VALUE, 1589.0), Map.of(AbsoluteStatTypeEnum.MANA, 5.0), List.of(), List.of(new OverallDescriptionBuff("- Singularity% cooldown time for 20.00")), 145),
    TERRIBLE_TRIBUNAL("Terrible Tribunal", ItemTypeEnum.SHOULDERS, Map.of(AbsoluteStatTypeEnum.ARMOR, 1068.0, AbsoluteStatTypeEnum.ICE_RESISTANCE, 4041.0, AbsoluteStatTypeEnum.BLOCK_VALUE, 1549.0), Map.of(), List.of(new UniqueEnchant(EnchantTypeEnum.BLOCK_VALUE, 24.184)), List.of(new OverallDescriptionBuff("Controlled Terror Effect")), 140),


    //torso
    ARMOR_OF_THE_BLACK_KNIGHT("Armor of the Black Knight", ItemTypeEnum.TORSO, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1645.0, AbsoluteStatTypeEnum.HEALTH_POINTS, 16507.0, AbsoluteStatTypeEnum.ARMOR, 1648.0), Map.of(), List.of(new UniqueEnchant(EnchantTypeEnum.ARMOR, 0.40632)), List.of(), 145),
    DESTRUCTOR_PLATED_ROBES("Destructor Plated Robes", ItemTypeEnum.TORSO, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1645.0, AbsoluteStatTypeEnum.HEALTH_POINTS, 16507.0, AbsoluteStatTypeEnum.ARMOR, 1648.0), Map.of(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.106, AbsoluteStatTypeEnum.FIRE_RESISTANCE, 2471.0), List.of(), List.of(), 145),
    GREAT_TERROR("Great Terror", ItemTypeEnum.TORSO, Map.of(AbsoluteStatTypeEnum.CRIT_VALUE, 1366.0, AbsoluteStatTypeEnum.ARMOR, 1603.0, AbsoluteStatTypeEnum.ANDERMAGIC_RESISTANCE, 6062.0), Map.of(), List.of(new UniqueEnchant(EnchantTypeEnum.ARMOR, 0.26832)), List.of(new OverallDescriptionBuff("Controlled Terror Effect")), 145),
    GRIMMAGS_STARRY_ROBE("Grimmag's Starry Robe", ItemTypeEnum.TORSO, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1645.0, AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.489, AbsoluteStatTypeEnum.HEALTH_POINTS, 16507.0), Map.of(AbsoluteStatTypeEnum.MANA, 36.0, AbsoluteStatTypeEnum.MANA_PER_SECOND, 9.0), List.of(), List.of(), 145),
    REMINS_BATTLE_HARNESS("Remin's Battle Harness", ItemTypeEnum.TORSO, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1645.0, AbsoluteStatTypeEnum.HEALTH_POINTS, 16507.0, AbsoluteStatTypeEnum.ARMOR, 1648.0), Map.of(AbsoluteStatTypeEnum.RESISTANCE, 1375.0, AbsoluteStatTypeEnum.BLOCK_VALUE, 1052.0), List.of(), List.of(), 145),
    RESEARCHERS_COAT("Researcher's Coat", ItemTypeEnum.TORSO, Map.of(AbsoluteStatTypeEnum.HEALTH_POINTS, 16145.0, AbsoluteStatTypeEnum.ARMOR, 1603.0, AbsoluteStatTypeEnum.RESISTANCE, 1697.0), Map.of(AbsoluteStatTypeEnum.HEALTH_PER_SECOND, 3615.886), List.of(), List.of(new OverallRelativeBuff(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.05)), 140),
    SIGRISMARRS_ETERNAL_WARD("Sigrismarr's Eternal Ward", ItemTypeEnum.TORSO, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1644.883, AbsoluteStatTypeEnum.HEALTH_POINTS, 16507.0, AbsoluteStatTypeEnum.ARMOR, 1648.0), Map.of(AbsoluteStatTypeEnum.ICE_RESISTANCE, 3459.0), List.of(), List.of(new OverallDescriptionBuff("Increases the Frozen Sphere talent by 3.")), 145),


    //gloves
    ABYSSAL_TREASURE_GLOVES("Abyssal Treasure Gloves", ItemTypeEnum.GLOVES, Map.of(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.055, AbsoluteStatTypeEnum.CRIT_VALUE, 1753.505, AbsoluteStatTypeEnum.LIGHTNING_RESISTANCE, 4150.0), Map.of(AbsoluteStatTypeEnum.LIGHTNING_RESISTANCE, 4865.0), List.of(), List.of(new OverallDescriptionBuff("Increases the Frozen Sphere talent by 10. Frozen Sphere has a 5% chance to petrify hit enemies.")), 145),
    GLOVES_OF_THE_BLACK_KNIGHT("Gloves of the Black Knight", ItemTypeEnum.GLOVES, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1645.0, AbsoluteStatTypeEnum.ATTACK_SPEED, 0.055, AbsoluteStatTypeEnum.RESISTANCE, 1162.0), Map.of(), List.of(new UniqueEnchant(EnchantTypeEnum.RESISTANCE, 0.41173)), List.of(), 145),
    GLOVES_OF_ZEAL("Gloves of Zeal", ItemTypeEnum.GLOVES, Map.of(AbsoluteStatTypeEnum.HEALTH_POINTS, 16507.0, AbsoluteStatTypeEnum.ARMOR, 1098.0, AbsoluteStatTypeEnum.RESISTANCE, 1162.0), Map.of(), List.of(new UniqueEnchant(EnchantTypeEnum.HEALTH_POINTS, 0.22295)), List.of(new OverallDescriptionBuff("When you defeat an enemy, your armor and all resistances will be increased by 0,15%. This effect lasts for 1 Minute or until you have been defeated. This effect can stack up to 100 times.")), 145),
    REIGN_OF_TERROR("Reign of Terror", ItemTypeEnum.GLOVES, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1601.0, AbsoluteStatTypeEnum.ATTACK_SPEED, 0.054, AbsoluteStatTypeEnum.ARMOR, 1068.0), Map.of(), List.of(new UniqueEnchant(EnchantTypeEnum.DAMAGE, 0.44221)), List.of(new OverallDescriptionBuff("Controlled Terror Buff")), 140),
    RESEARCHERS_GAUNTLETS("Researcher's Gauntlets", ItemTypeEnum.GLOVES, Map.of(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.484, AbsoluteStatTypeEnum.ARMOR, 1068.0, AbsoluteStatTypeEnum.RESISTANCE, 1131.0), Map.of(), List.of(new UniqueEnchant(EnchantTypeEnum.RESISTANCE, 0.27198)), List.of(new OverallRelativeBuff(OverallRelativeBuffTypeEnum.ARMOR, 0.1)), 140),
    THE_HERALDS_BLAZING_ONSLAUGHT("The Herald's Blazing Onslaught", ItemTypeEnum.GLOVES, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1645.0, AbsoluteStatTypeEnum.FIRE_RESISTANCE, 4150.0, AbsoluteStatTypeEnum.ANDERMAGIC_RESISTANCE, 4150.0), Map.of(AbsoluteStatTypeEnum.ANDERMAGIC_RESISTANCE, 3406.0), List.of(), List.of(new OverallDescriptionBuff("Increases the Rising Vigor (III) talent by 4.")), 145),

    //boots //todo lapis lazuli boots
    BOOTS_OF_THE_BLACK_KNIGHT("Boots of the Black Knight", ItemTypeEnum.BOOTS, Map.of(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 1.221, AbsoluteStatTypeEnum.HEALTH_POINTS, 16507.0, AbsoluteStatTypeEnum.RESISTANCE, 1162.0), Map.of(), List.of(new UniqueEnchant(EnchantTypeEnum.MOVEMENT_SPEED, 0.3856)), List.of(), 145),
    DEADLY_TERROR("Deadly Terror", ItemTypeEnum.BOOTS, Map.of(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 1.208, AbsoluteStatTypeEnum.ARMOR, 1068.0, AbsoluteStatTypeEnum.POISON_RESISTANCE, 4041.0), Map.of(), List.of(new UniqueEnchant(EnchantTypeEnum.MOVEMENT_SPEED, 0.25558)), List.of(new OverallDescriptionBuff("Controlled Terror Effect")), 140),
    FIERY_TRACKS_OF_GRIMMAG("Fiery Tracks of Grimmag", ItemTypeEnum.BOOTS, Map.of(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 1.221, AbsoluteStatTypeEnum.ARMOR, 1098.0, AbsoluteStatTypeEnum.FIRE_RESISTANCE, 4150.0), Map.of(AbsoluteStatTypeEnum.FIRE_RESISTANCE, 2433.0), List.of(), List.of(new OverallDescriptionBuff("Increases the Price Fall (II) talent by5.")), 145),
    GORGONSKIN_LEATHER_BOOTS("Gorgonskin Leather Boots", ItemTypeEnum.BOOTS, Map.of(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 1.221, AbsoluteStatTypeEnum.HEALTH_POINTS, 16507.0, AbsoluteStatTypeEnum.ANDERMAGIC_RESISTANCE, 4150.0), Map.of(AbsoluteStatTypeEnum.ANDERMAGIC_RESISTANCE, 3892.0), List.of(), List.of(new OverallDescriptionBuff("Increases the Teleport talent by 4.")), 145),
    RESEARCHERS_BOOTS("Researcher's Boots", ItemTypeEnum.BOOTS, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1601.0, AbsoluteStatTypeEnum.MOVEMENT_SPEED, 1.208, AbsoluteStatTypeEnum.CRIT_VALUE, 1366.0), Map.of(), List.of(new UniqueEnchant(EnchantTypeEnum.MOVEMENT_SPEED, 0.25558)), List.of(new OverallRelativeBuff(OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.1)), 140),
    TODO3("blueprint", ItemTypeEnum.BOOTS, Map.of(AbsoluteStatTypeEnum.CRIT_VALUE, .0, AbsoluteStatTypeEnum.HEALTH_POINTS, .0, AbsoluteStatTypeEnum.POISON_RESISTANCE, .0), Map.of(), List.of(), List.of(), 145),

    //weapon adornment
    ADORNMENT_OF_THE_VANQUISHER("Adornment of the Vanquisher", ItemTypeEnum.WEAPON_ADORNMENT, Map.of(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.055, AbsoluteStatTypeEnum.CRIT_VALUE, 2104.0), Map.of(), List.of(), List.of(new OverallDescriptionBuff("Whenever you defeat an enemy you will get the Frenzy of the Vanquisher buff that increases your critical value by 0.1%. This effect lasts for 1 minute or until you have been defeated. It can stack up to 100 times.")), 145),
    ANCIENT_BATTLE_ADORNMENT("Ancient Battle Adornment", ItemTypeEnum.WEAPON_ADORNMENT, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1841.0, AbsoluteStatTypeEnum.CRIT_VALUE, 2050.0), Map.of(), List.of(new UniqueEnchant(EnchantTypeEnum.CRIT_VALUE, 0.24365)), List.of(new OverallRelativeBuff(OverallRelativeBuffTypeEnum.DAMAGE, 0.05)), 140),
    GRIMMAGS_FLAMING_WRATH("Grimmag's Flaming Wrath", ItemTypeEnum.WEAPON_ADORNMENT, Map.of(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.055, AbsoluteStatTypeEnum.CRIT_VALUE, 2104.0), Map.of(AbsoluteStatTypeEnum.DAMAGE, 1306.0), List.of(), List.of(new OverallDescriptionBuff("Increases the Fire Blast talent by 2.")), 145),
    SIGRISMARRS_ETERNAL_GRASP("Sigrismarr's Eternal Grasp", ItemTypeEnum.WEAPON_ADORNMENT, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1891.513, AbsoluteStatTypeEnum.CRIT_VALUE, 2104.0), Map.of(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.06), List.of(), List.of(new OverallDescriptionBuff("Increases the Ice Missile talent by 5")), 145),
    STINGER("Stinger", ItemTypeEnum.WEAPON_ADORNMENT, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1891.513, AbsoluteStatTypeEnum.ATTACK_SPEED, 0.055, AbsoluteStatTypeEnum.CRIT_VALUE, 2104.0), Map.of(), List.of(new UniqueEnchant(EnchantTypeEnum.DAMAGE, 0.67637), new UniqueEnchant(EnchantTypeEnum.CRIT_VALUE, 0.60126)), List.of(), 145),


    //two hand weapon


    //one hand weapon //todo oasis staff
    ARACHNAS_VENOMOUS_REVENGE("Arachna's Venomous Revenge", ItemTypeEnum.ONE_HAND_WEAPON, Map.of(AbsoluteStatTypeEnum.DAMAGE, 2057.0, AbsoluteStatTypeEnum.ATTACK_SPEED, 0.220, AbsoluteStatTypeEnum.CRIT_VALUE, 2104.0), Map.of(AbsoluteStatTypeEnum.DAMAGE, 1842.0), List.of(), List.of(new OverallDescriptionBuff("...")), 145),
    TODO2("blueprint", ItemTypeEnum.ONE_HAND_WEAPON, Map.of(AbsoluteStatTypeEnum.CRIT_VALUE, .0, AbsoluteStatTypeEnum.HEALTH_POINTS, .0, AbsoluteStatTypeEnum.POISON_RESISTANCE, .0), Map.of(), List.of(), List.of(), 145),
    GWENFARAS_GHOST_CLAW("Gwenfara's Ghost Claw", ItemTypeEnum.ONE_HAND_WEAPON, Map.of(AbsoluteStatTypeEnum.DAMAGE, 2057.0, AbsoluteStatTypeEnum.ATTACK_SPEED, 0.220, AbsoluteStatTypeEnum.CRIT_VALUE, 2104.0), Map.of(AbsoluteStatTypeEnum.CRIT_VALUE, 2166.0), List.of(), List.of(new OverallDescriptionBuff("...")), 145),
    STAFF_OF_DESTRUCTION("Staff of Destruction", ItemTypeEnum.ONE_HAND_WEAPON, Map.of(AbsoluteStatTypeEnum.DAMAGE, 2057.0, AbsoluteStatTypeEnum.CRIT_VALUE, 2104.0), Map.of(AbsoluteStatTypeEnum.CRIT_VALUE, 2166.0, AbsoluteStatTypeEnum.FIRE_RESISTANCE, 2282.0), List.of(), List.of(), 145),
    STARLIGHT("Starlight", ItemTypeEnum.ONE_HAND_WEAPON, Map.of(AbsoluteStatTypeEnum.DAMAGE, 2057.0, AbsoluteStatTypeEnum.ATTACK_SPEED, 0.439), Map.of(AbsoluteStatTypeEnum.MANA, 19.0), List.of(), List.of(), 145),


    //books
    BITING_TOMB("Biting Tomb", ItemTypeEnum.OFF_HAND, Map.of(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.109, AbsoluteStatTypeEnum.CRIT_VALUE, 2104.0), Map.of(), List.of(new UniqueEnchant(EnchantTypeEnum.ATTACK_SPEED, 0.9432)), List.of(), 145),
    BOOK_OF_CONDEMNATION("Book of Condemnation", ItemTypeEnum.OFF_HAND, Map.of(AbsoluteStatTypeEnum.HEALTH_POINTS, 33022.0, AbsoluteStatTypeEnum.ARMOR, 2197.0, AbsoluteStatTypeEnum.BLOCK_VALUE, 47683.0), Map.of(AbsoluteStatTypeEnum.MANA, 7.0, AbsoluteStatTypeEnum.RESISTANCE, 1050.0), List.of(), List.of(), 145),
    GWENFARAS_GHOSTLY_ALMANAC("Gwenfara's Ghostly Almanac", ItemTypeEnum.OFF_HAND, Map.of(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.109, AbsoluteStatTypeEnum.CRIT_VALUE, 2104.0), Map.of(AbsoluteStatTypeEnum.CRIT_VALUE, 2166.0), List.of(), List.of(new OverallDescriptionBuff("...")), 145),
    ROYAL_TOME_OF_THE_GUARDIANS("Royal Tome of the Guardians", ItemTypeEnum.OFF_HAND, Map.of(AbsoluteStatTypeEnum.DAMAGE, 3292.0, AbsoluteStatTypeEnum.CRIT_VALUE, 2104.0), Map.of(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.043), List.of(), List.of(new OverallDescriptionBuff("Increases the Rising Vigor (III) talent by 4.")), 145),
    SHARR_KHARABS_SCROLL("Sharr Kharab's Scroll", ItemTypeEnum.OFF_HAND, Map.of(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.109, AbsoluteStatTypeEnum.CRIT_VALUE, 2104.0), Map.of(), List.of(), List.of(new OverallDescriptionBuff("There is a 8% chance that the fists of Sharr Kharab will attack your enemies after using Magic Missile and cause 100% of your base damage as physical damage.")), 145),

    //orbs
    HEREDURS_ROYAL_SHIELD("Heredur's Royal Shield", ItemTypeEnum.OFF_HAND, Map.of(AbsoluteStatTypeEnum.ARMOR, 2197.0, AbsoluteStatTypeEnum.RESISTANCE, 2324.0, AbsoluteStatTypeEnum.BLOCK_VALUE, 47683.0), Map.of(), List.of(new UniqueEnchant(EnchantTypeEnum.BLOCK_VALUE, 0.12183)), List.of(new OverallDescriptionBuff("Increases the Frost Nova talent by 2.")), 145),
    RIDDLE("Riddle", ItemTypeEnum.OFF_HAND, Map.of(AbsoluteStatTypeEnum.HEALTH_POINTS, 33022.0, AbsoluteStatTypeEnum.ARMOR, 2197.0, AbsoluteStatTypeEnum.BLOCK_VALUE, 47683.0), Map.of(AbsoluteStatTypeEnum.HEALTH_POINTS, 44463.0), List.of(), List.of(), 145),



    GRIMACE_OF_THE_THUNDER_BEAST("Grimace of the Thunder Beast", ItemTypeEnum.TWO_HAND_WEAPON, Map.of(AbsoluteStatTypeEnum.DAMAGE, 26326.0, AbsoluteStatTypeEnum.CRIT_VALUE, 3506.0), Map.of(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.102), List.of(), List.of(new OverallDescriptionBuff("Anni Weapon Buff")), 145),;

    private final String name;
    private final ItemTypeEnum itemType;
    private final Map<AbsoluteStatTypeEnum, Double> baseStats;
    private final CharacterClassEnum characterClass;
    private final Map<AbsoluteStatTypeEnum, Double> uniqueBaseStat;
    private final List<UniqueEnchant> uniqueEnchants;
    private final List<OverallBuff> overallBuffs;
    private final int itemLevel;

    SpellweaverUniqueItems(String name, ItemTypeEnum itemType, Map<AbsoluteStatTypeEnum, Double> baseStats, Map<AbsoluteStatTypeEnum, Double> uniqueBaseStats, java.util.List<UniqueEnchant> uniqueEnchants, List<OverallBuff> overallBuffs, int itemLevel) {
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
