package com.langleon.dsobuildsim.charactertests;

import com.langleon.dsobuildsim.character.Character;
import com.langleon.dsobuildsim.enums.AbsoluteStatType;

import java.util.Map;

public class RealWarTest {
    //best atm, 7 und 15
    public static void main(String[] args) {
        //Character war = weidenWar();
        //war.calculateFinalStats();
        //printStats(war);
    }

    /*
    public static Character normalWar() {
        Character dragonknight = new Character(CharacterClass.DRAGONKNIGHT, "normal setup");

        Map<AbsoluteStatType, Double> amuletBaseStats = new HashMap<>();
        amuletBaseStats.put(AbsoluteStatType.DAMAGE, 1535.152);
        amuletBaseStats.put(AbsoluteStatType.CRIT_VALUE, 1627.546);
        amuletBaseStats.put(AbsoluteStatType.HEALTH_POINTS, 43467.97);
        UniqueItem amulet = DragonknightUniqueItems.POWERFUL_GEAR.getItem();
        amulet.setBaseStats(amuletBaseStats);
        amulet.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        amulet.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        amulet.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        amulet.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        amulet.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        dragonknight.addItem(amulet, ItemSlot.AMULET);

        SetItem cloak = DragonknightSetItems.CLOAK_OF_THE_END.getItem();
        cloak.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        cloak.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        cloak.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        cloak.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        cloak.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        cloak.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        cloak.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        cloak.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        cloak.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        cloak.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        cloak.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        dragonknight.addItem(cloak, ItemSlot.CLOAK);

        Map<AbsoluteStatType, Double> beltBaseStats = new HashMap<>();
        beltBaseStats.put(AbsoluteStatType.DAMAGE, 1488.589);
        beltBaseStats.put(AbsoluteStatType.HEALTH_POINTS, 53493.572);
        beltBaseStats.put(AbsoluteStatType.RESISTANCE_VALUE, 1595.500);
        UniqueItem belt = DragonknightUniqueItems.BELT_OF_ZEAL.getItem();
        belt.setBaseStats(beltBaseStats);
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44757));
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44734));
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44719));
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44707));
        belt.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        dragonknight.addItem(belt, ItemSlot.BELT);

        MythicItem ring1 = DragonknightMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring1.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        ring1.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        ring1.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        ring1.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        ring1.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        ring1.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        ring1.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        ring1.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        ring1.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        ring1.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        ring1.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        ring1.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        ring1.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        ring1.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        dragonknight.addItem(ring1, ItemSlot.RING1);

        MythicItem ring2 = DragonknightMythicItem.RING_OF_OLD_GLORY.getItem();
        ring2.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        ring2.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        ring2.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        ring2.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        ring2.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        ring2.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        ring2.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        ring2.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        ring2.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        ring2.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        ring2.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        dragonknight.addItem(ring2, ItemSlot.RING2);

        SetItem helmet = DragonknightSetItems.HELMET_OF_THE_END.getItem();
        helmet.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        helmet.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        helmet.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        helmet.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        helmet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        dragonknight.addItem(helmet, ItemSlot.HELMET);

        SetItem shoulders = DragonknightSetItems.SHOULDERS_OF_THE_END.getItem();
        shoulders.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        shoulders.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        shoulders.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        shoulders.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        shoulders.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        dragonknight.addItem(shoulders, ItemSlot.SHOULDERS);

        Map<AbsoluteStatType, Double> torsoBaseStats = new HashMap<>();
        torsoBaseStats.put(AbsoluteStatType.DAMAGE, 1339.327);
        torsoBaseStats.put(AbsoluteStatType.HEALTH_POINTS, 47564.308);
        torsoBaseStats.put(AbsoluteStatType.ARMOR_VALUE, 1130.479);
        UniqueItem torso = DragonknightUniqueItems.SIGRISMARRS_ETERNAL_WARD.getItem();
        torso.setBaseStats(torsoBaseStats);
        torso.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        torso.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        torso.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        torso.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        dragonknight.addItem(torso, ItemSlot.TORSO);

        Map<AbsoluteStatType, Double> glovesBaseStats = new HashMap<>();
        glovesBaseStats.put(AbsoluteStatType.DAMAGE, 1413.061);
        glovesBaseStats.put(AbsoluteStatType.ATTACK_SPEED, 0.046);
        glovesBaseStats.put(AbsoluteStatType.CRIT_VALUE, 1540.514);
        SetItem gloves = DragonknightSetItems.MIGHTY_WRATHFUL_SEEKERS_GLOVES.getItem();
        gloves.setBaseStats(glovesBaseStats);
        gloves.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        gloves.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        gloves.addEnchant(new Enchant(EnchantType.CRIT_VALUE, 0.24533));
        gloves.addEnchant(new Enchant(EnchantType.CRIT_VALUE, 0.24556));
        gloves.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        gloves.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        gloves.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        gloves.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        gloves.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        gloves.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        gloves.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        gloves.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        gloves.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        gloves.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        dragonknight.addItem(gloves, ItemSlot.GLOVES);

        Map<AbsoluteStatType, Double> bootsBaseStats = new HashMap<>();
        bootsBaseStats.put(AbsoluteStatType.DAMAGE, 1544.042);
        bootsBaseStats.put(AbsoluteStatType.MOVEMENT_SPEED, 1.132);
        bootsBaseStats.put(AbsoluteStatType.CRIT_VALUE, 1226.948);
        SetItem boots = DragonknightSetItems.MIGHTY_WRATHFUL_SEEKERS_BOOTS.getItem();
        boots.setBaseStats(bootsBaseStats);
        boots.addEnchant(new Enchant(EnchantType.MOVEMENT_SPEED, 0.22436));
        boots.addEnchant(new Enchant(EnchantType.MOVEMENT_SPEED, 0.22434));
        boots.addEnchant(new Enchant(EnchantType.MOVEMENT_SPEED, 0.22447));
        boots.addEnchant(new Enchant(EnchantType.MOVEMENT_SPEED, 0.22444));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.13));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        dragonknight.addItem(boots, ItemSlot.BOOTS);

        Map<AbsoluteStatType, Double> adornmentBaseStats = new HashMap<>();
        adornmentBaseStats.put(AbsoluteStatType.DAMAGE, 1856.008);
        adornmentBaseStats.put(AbsoluteStatType.ATTACK_SPEED, 0.052);
        adornmentBaseStats.put(AbsoluteStatType.CRIT_VALUE, 1991.931);
        UniqueItem adornment = DragonknightUniqueItems.ILLUMINATING_FANGS.getItem();
        adornment.setBaseStats(adornmentBaseStats);
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        Opal opal = new Opal(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0), new Gem(AbsoluteStatType.DAMAGE, 700.0), new Gem(AbsoluteStatType.ATTACK_SPEED, 0.017));
        adornment.addGem(opal);
        adornment.addGem(opal);
        adornment.addGem(opal);
        adornment.addGem(opal);
        adornment.addGem(opal);
        adornment.addGem(opal);
        adornment.addGem(opal);
        adornment.addGem(opal);
        adornment.addGem(opal);
        adornment.addGem(opal);
        dragonknight.addItem(adornment, ItemSlot.WEAPON_ADORNMENT);

        Map<AbsoluteStatType, Double> twoHandBaseStats = new HashMap<>();
        twoHandBaseStats.put(AbsoluteStatType.DAMAGE, 24934.348);
        twoHandBaseStats.put(AbsoluteStatType.CRIT_VALUE, 2887.408);
        UniqueItem twoHand = DragonknightUniqueItems.WINDING_THUNDER_DRAGON.getItem();
        twoHand.setBaseStats(twoHandBaseStats);
        twoHand.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        twoHand.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        twoHand.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        twoHand.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        twoHand.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        dragonknight.addItem(twoHand, ItemSlot.TWO_HAND_WEAPON);

        RuneTrinket runeTrinket1 = new RuneTrinket();
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffType.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffType.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffType.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffType.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffType.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffType.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffType.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffType.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffType.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffType.DAMAGE, 0.065));
        dragonknight.addRuneTrinket(runeTrinket1, 1);

        RuneTrinket runeTrinket2 = new RuneTrinket();
        runeTrinket2.addRune(new Rune("Rune of Celerity", OverallRelativeBuffType.ATTACK_SPEED, 0.065));
        runeTrinket2.addRune(new Rune("Rune of Celerity", OverallRelativeBuffType.ATTACK_SPEED, 0.065));
        runeTrinket2.addRune(new Rune("Rune of Celerity", OverallRelativeBuffType.ATTACK_SPEED, 0.065));
        runeTrinket2.addRune(new Rune("Rune of Celerity", OverallRelativeBuffType.ATTACK_SPEED, 0.065));
        runeTrinket2.addRune(new Rune("Rune of Celerity", OverallRelativeBuffType.ATTACK_SPEED, 0.065));
        runeTrinket2.addRune(new Rune("Rune of Vitality", OverallRelativeBuffType.HEALTH_POINTS, 0.065));
        runeTrinket2.addRune(new Rune("Rune of Vitality", OverallRelativeBuffType.HEALTH_POINTS, 0.065));
        runeTrinket2.addRune(new Rune("Rune of Vitality", OverallRelativeBuffType.HEALTH_POINTS, 0.065));
        runeTrinket2.addRune(new Rune("Rune of Vitality", OverallRelativeBuffType.HEALTH_POINTS, 0.065));
        runeTrinket2.addRune(new Rune("Rune of Vitality", OverallRelativeBuffType.HEALTH_POINTS, 0.065));
        dragonknight.addRuneTrinket(runeTrinket2, 2);

        RuneTrinket runeTrinket3 = new RuneTrinket();
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffType.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffType.MOVEMENT_SPEED, 0.065, OverallRelativeBuffType.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffType.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffType.MOVEMENT_SPEED, 0.065, OverallRelativeBuffType.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffType.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffType.MOVEMENT_SPEED, 0.065, OverallRelativeBuffType.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffType.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffType.MOVEMENT_SPEED, 0.065, OverallRelativeBuffType.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffType.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffType.MOVEMENT_SPEED, 0.065, OverallRelativeBuffType.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffType.ICE_RESISTANCE, 0.065, OverallRelativeBuffType.HEALTH_POINTS, 0.065, OverallRelativeBuffType.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffType.ICE_RESISTANCE, 0.065, OverallRelativeBuffType.HEALTH_POINTS, 0.065, OverallRelativeBuffType.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffType.ICE_RESISTANCE, 0.065, OverallRelativeBuffType.HEALTH_POINTS, 0.065, OverallRelativeBuffType.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffType.ICE_RESISTANCE, 0.065, OverallRelativeBuffType.HEALTH_POINTS, 0.065, OverallRelativeBuffType.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffType.ICE_RESISTANCE, 0.065, OverallRelativeBuffType.HEALTH_POINTS, 0.065, OverallRelativeBuffType.CRIT_VALUE, 0.065), ""));
        dragonknight.addRuneTrinket(runeTrinket3, 3);

        RuneTrinket runeTrinket4 = new RuneTrinket();
        runeTrinket4.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffType.RESISTANCE, 0.065, OverallRelativeBuffType.DAMAGE, 0.065, OverallRelativeBuffType.BLOCK_VALUE, 0.065), ""));
        runeTrinket4.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffType.RESISTANCE, 0.065, OverallRelativeBuffType.DAMAGE, 0.065, OverallRelativeBuffType.BLOCK_VALUE, 0.065), ""));
        runeTrinket4.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffType.RESISTANCE, 0.065, OverallRelativeBuffType.DAMAGE, 0.065, OverallRelativeBuffType.BLOCK_VALUE, 0.065), ""));
        runeTrinket4.addRune(new Rune("Rune of Resilience", OverallRelativeBuffType.RESISTANCE, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Resilience", OverallRelativeBuffType.RESISTANCE, 0.065));
        runeTrinket4.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffType.HEALTH_POINTS, 0.065, OverallRelativeBuffType.CRIT_VALUE, 0.065, OverallRelativeBuffType.ATTACK_SPEED, 0.065), ""));
        runeTrinket4.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffType.HEALTH_POINTS, 0.065, OverallRelativeBuffType.CRIT_VALUE, 0.065, OverallRelativeBuffType.ATTACK_SPEED, 0.065), ""));
        runeTrinket4.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffType.ARMOR, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffType.ARMOR, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffType.ARMOR, 0.065));
        dragonknight.addRuneTrinket(runeTrinket4, 4);

        RuneTrinket runeTrinket5 = new RuneTrinket();
        runeTrinket5.addRune(new Rune("Rune of Materi Blessing", OverallRelativeBuffType.MATERI_FRAGMENT_DROP_BONUS, 0.3));
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffType.ARMOR, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffType.ARMOR, 0.065));
        runeTrinket5.addRune(new SpecialRune("Rune of the Andermant Fever", Map.of(), "Increases the Andermant Fever talent by 5."));
        runeTrinket5.addRune(new SpecialRune("Rune of the Realm Changer", Map.of(), "Increases the Realm Changer talent by 5."));
        runeTrinket5.addRune(new Rune("Rune of Recharging", OverallRelativeBuffType.MANA_PER_SECOND, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Recharging", OverallRelativeBuffType.MANA_PER_SECOND, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Recharging", OverallRelativeBuffType.MANA_PER_SECOND, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Recharging", OverallRelativeBuffType.MANA_PER_SECOND, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Recharging", OverallRelativeBuffType.MANA_PER_SECOND, 0.065));
        dragonknight.addRuneTrinket(runeTrinket5, 5);

        JewelTrinket jewelTrinket1 = new JewelTrinket();
        jewelTrinket1.addJewel(new Jewel("Jewel of Rage", "..."));
        jewelTrinket1.addJewel(new Jewel("Jewel of the Gem Fortune", "..."));
        jewelTrinket1.addJewel(new Jewel("Jewel of the Eternal Wrath", "..."));
        jewelTrinket1.addJewel(new Jewel("Jewel of the Ingredient Hunter", "..."));
        jewelTrinket1.addJewel(new Jewel("Jewel of the Ingredient Hunter", "..."));
        jewelTrinket1.addJewel(new Jewel("Jewel of Amplified Healing", "..."));
        jewelTrinket1.addJewel(new Jewel("Jewel of Contribution", "..."));
        jewelTrinket1.addJewel(new Jewel("Jewel of Encouragement", "..."));
        jewelTrinket1.addJewel(new Jewel("Jewel of Vigor", OverallRelativeBuffType.DAMAGE, 0.1));
        jewelTrinket1.addJewel(new Jewel("Jewel of Ambidextrous Vigor", OverallRelativeBuffType.TWO_HAND_DAMAGE, 0.1));
        dragonknight.addJewelTrinket(jewelTrinket1, 1);

        JewelTrinket jewelTrinket2 = new JewelTrinket();
        jewelTrinket2.addJewel(new Jewel("Jewel of Relentlessness", "..."));
        jewelTrinket2.addJewel(new Jewel("Jewel of Relentlessness", "..."));
        jewelTrinket2.addJewel(new Jewel("Jewel of Relentlessness", "..."));
        jewelTrinket2.addJewel(new Jewel("Jewel of Relentlessness", "..."));
        jewelTrinket2.addJewel(new Jewel("Jewel of Relentlessness", "..."));
        jewelTrinket2.addJewel(new Jewel("Jewel of Focus", "..."));
        jewelTrinket2.addJewel(new Jewel("Jewel of Focus", "..."));
        jewelTrinket2.addJewel(new Jewel("Jewel of Focus", "..."));
        jewelTrinket2.addJewel(new Jewel("Jewel of Focus", "..."));
        jewelTrinket2.addJewel(new Jewel("Jewel of Focus", "..."));
        dragonknight.addJewelTrinket(jewelTrinket2, 2);

        JewelTrinket jewelTrinket3 = new JewelTrinket();
        jewelTrinket3.addJewel(new Jewel("Jewel of the Easter Fever", "..."));
        jewelTrinket3.addJewel(new Jewel("Thundering Flower Jewel", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Strenuousness", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Fortitude", OverallRelativeBuffType.ARMOR, 0.1));
        jewelTrinket3.addJewel(new Jewel("Jewel of Prolongation", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Scorching Ray", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Vitality", OverallRelativeBuffType.HEALTH_POINTS, 0.1));
        jewelTrinket3.addJewel(new Jewel("Jewel of the Frozen Heart", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Ghost Power", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Dextrous Vigor", OverallRelativeBuffType.ONE_HAND_DAMAGE, 0.1));
        dragonknight.addJewelTrinket(jewelTrinket3, 3);

        WisdomSkillTree wisdomSkillTree = new WisdomSkillTree();
        wisdomSkillTree.setLevel(60, 1,1);
        wisdomSkillTree.setLevel(30, 1,2);
        wisdomSkillTree.setLevel(60, 1,3);

        wisdomSkillTree.setLevel(80, 2,1);
        wisdomSkillTree.setLevel(80, 2,2);
        wisdomSkillTree.setLevel(40, 2,3);

        wisdomSkillTree.setLevel(40, 3,1);
        wisdomSkillTree.setLevel(80, 3,2);
        wisdomSkillTree.setLevel(80, 3,3);

        wisdomSkillTree.setLevel(1, 4,1);

        wisdomSkillTree.setLevel(60, 5,1);
        wisdomSkillTree.setLevel(60, 5,2);

        wisdomSkillTree.setLevel(60, 6,1);
        wisdomSkillTree.setLevel(60, 6,2);
        wisdomSkillTree.setLevel(5, 6,3);

        wisdomSkillTree.setLevel(1, 7,2);
        wisdomSkillTree.setLevel(1, 7,3);

        wisdomSkillTree.setLevel(15, 8,1);
        wisdomSkillTree.setLevel(15, 8,2);

        dragonknight.setWisdomSkillTree(wisdomSkillTree);

        dragonknight.setEssence(0.50);

        Pet mortisPet = new Pet("Mortis Doll", Map.of(OverallRelativeBuffType.DAMAGE, 0.3, OverallRelativeBuffType.MANA, 0.3, OverallRelativeBuffType.ATTACK_SPEED, 0.3, OverallRelativeBuffType.HEALTH_POINTS, 0.075), "");
        dragonknight.setPet(mortisPet);
        dragonknight.setCollectorBagBuff(Map.of(OverallRelativeBuffType.HEALTH_POINTS, 0.33, OverallRelativeBuffType.RESISTANCE, 0.15, OverallRelativeBuffType.DAMAGE, 0.06, OverallRelativeBuffType.BLOCK_VALUE, 0.02));

        Tonic tonic = new Tonic("Tonic of Vigor", AbsoluteStatType.DAMAGE, 10496.0);
        //dragonknight.setTonic(tonic);
        Physic physic = new Physic("Advanced Physic of Vigor", OverallRelativeBuffType.DAMAGE, 0.18);
        //dragonknight.setPhysic(physic);


        return dragonknight;
    }
     */

    public static void printStats(Character character)
    {
        Map<AbsoluteStatType, Double> stats = character.getCharacterFinalStats();
        System.out.println("Character: " + character.getName());
        System.out.printf(AbsoluteStatType.DAMAGE + ": %.2f%n", stats.get(AbsoluteStatType.DAMAGE));
        System.out.printf(AbsoluteStatType.ATTACK_SPEED + ": %.2f%n", stats.get(AbsoluteStatType.ATTACK_SPEED));
        System.out.printf(AbsoluteStatType.CRIT_VALUE + ": %.2f%n", stats.get(AbsoluteStatType.CRIT_VALUE));
        System.out.printf(AbsoluteStatType.MANA + ": %.2f%n", stats.get(AbsoluteStatType.MANA));
        System.out.printf(AbsoluteStatType.MANA_PER_SECOND + ": %.2f%n", stats.get(AbsoluteStatType.MANA_PER_SECOND));
        System.out.printf(AbsoluteStatType.MOVEMENT_SPEED + ": %.2f%n", stats.get(AbsoluteStatType.MOVEMENT_SPEED));
        System.out.printf(AbsoluteStatType.HEALTH_POINTS + ": %.2f%n", stats.get(AbsoluteStatType.HEALTH_POINTS));
        System.out.printf(AbsoluteStatType.HEALTH_PER_SECOND + ": %.2f%n", stats.get(AbsoluteStatType.HEALTH_PER_SECOND));
        System.out.printf(AbsoluteStatType.BLOCK_VALUE + ": %.2f%n", stats.get(AbsoluteStatType.BLOCK_VALUE));
        System.out.printf(AbsoluteStatType.ARMOR_VALUE + ": %.2f%n", stats.get(AbsoluteStatType.ARMOR_VALUE));
        System.out.printf(AbsoluteStatType.FIRE_RESISTANCE + ": %.2f%n", stats.get(AbsoluteStatType.FIRE_RESISTANCE));
        System.out.printf(AbsoluteStatType.ICE_RESISTANCE + ": %.2f%n", stats.get(AbsoluteStatType.ICE_RESISTANCE));
        System.out.printf(AbsoluteStatType.LIGHTNING_RESISTANCE + ": %.2f%n", stats.get(AbsoluteStatType.LIGHTNING_RESISTANCE));
        System.out.printf(AbsoluteStatType.ANDERMAGIC_RESISTANCE + ": %.2f%n", stats.get(AbsoluteStatType.ANDERMAGIC_RESISTANCE));
        System.out.printf(AbsoluteStatType.POISON_RESISTANCE + ": %.2f%n", stats.get(AbsoluteStatType.POISON_RESISTANCE));
    }
}
