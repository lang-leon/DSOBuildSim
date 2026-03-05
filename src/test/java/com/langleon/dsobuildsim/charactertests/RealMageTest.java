package com.langleon.dsobuildsim.charactertests;
import com.langleon.dsobuildsim.character.Character;
import com.langleon.dsobuildsim.enums.*;

import java.util.*;

public class RealMageTest {
    public static void main(String[] args) {
        //Character mage = zohan();
        //mage.calculateFinalStats();
        //printStats(mage);
    }

    /*
    public static Character pveNormal() {
        //3p sargon, 2p seeker, q8, q9
        Character mage = new Character(CharacterClass.SPELLWEAVER, "3p sargon, 2p seeker, q8, q9");

        AbstractItem amulet = SpellweaverUniqueItems.AMULET_OF_THE_KRAKEN.getItem();
        amulet.setEnchants(EnchantType.HEALTH_POINTS);
        amulet.setGems(StatType.HEALTH_POINTS);
        mage.addItem(amulet, ItemSlot.AMULET);

        AbstractItem cloak = SpellweaverMythicItem.ANCESTRAL_GLORY_CLOAK.getItem();
        cloak.setEnchants(EnchantType.DAMAGE);
        cloak.setGems(StatType.DAMAGE);
        mage.addItem(cloak, ItemSlot.CLOAK);

        AbstractItem belt = SpellweaverUniqueItems.BELT_OF_ZEAL.getItem();
        belt.setEnchants(EnchantType.DAMAGE);
        belt.setGems(StatType.DAMAGE);
        mage.addItem(belt, ItemSlot.BELT);

        AbstractItem ring1 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring1.setEnchants(EnchantType.DAMAGE);
        ring1.setGems(StatType.DAMAGE);
        mage.addItem(ring1, ItemSlot.RING1);

        AbstractItem ring2 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring2.setEnchants(EnchantType.DAMAGE);
        Opal opal = new Opal(new Gem(StatType.CRIT_VALUE, 2520.0), new Gem(StatType.DAMAGE, 700.0), new Gem(StatType.MOVEMENT_SPEED, 0.17));
        ring2.addGems(opal, 10);
        mage.addItem(ring2, ItemSlot.RING2);

        AbstractItem helmet = SpellweaverSetItems.SARGONS_HORNS.getItem();
        helmet.setEnchants(EnchantType.HEALTH_POINTS);
        helmet.setGems(StatType.HEALTH_POINTS);
        mage.addItem(helmet, ItemSlot.HELMET);

        AbstractItem shoulders = SpellweaverSetItems.SARGONS_PAULDRONS.getItem();
        shoulders.setEnchants(EnchantType.DAMAGE);
        shoulders.setGems(StatType.CRIT_VALUE);
        mage.addItem(shoulders, ItemSlot.SHOULDERS);

        AbstractItem torso = SpellweaverSetItems.SARGONS_TORSO.getItem();
        torso.setEnchants(EnchantType.HEALTH_POINTS);
        torso.setGems(StatType.HEALTH_POINTS);
        mage.addItem(torso, ItemSlot.TORSO);

        AbstractItem gloves = SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_GLOVES.getItem();
        gloves.setEnchants(EnchantType.DAMAGE);
        gloves.setGems(StatType.CRIT_VALUE);
        mage.addItem(gloves, ItemSlot.GLOVES);

        AbstractItem boots = SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_BOOTS.getItem();
        boots.setEnchants(EnchantType.DAMAGE);
        boots.addGems(StatType.CRIT_VALUE, 8);
        boots.addGems(StatType.MOVEMENT_SPEED, 2);
        mage.addItem(boots, ItemSlot.BOOTS);

        AbstractItem adornment = SpellweaverUniqueItems.SIGRISMARRS_ETERNAL_GRASP.getItem();
        adornment.setEnchants(EnchantType.DAMAGE);
        adornment.setGems(StatType.DAMAGE);
        mage.addItem(adornment, ItemSlot.WEAPON_ADORNMENT);

        AbstractItem twoHand = SpellweaverUniqueItems.GRIMACE_OF_THE_THUNDER_BEAST.getItem();
        twoHand.setEnchants(EnchantType.DAMAGE);
        twoHand.setGems(StatType.DAMAGE);
        mage.addItem(twoHand, ItemSlot.TWO_HAND_WEAPON);



        RuneTrinket runeTrinket1 = new RuneTrinket();
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffType.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffType.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffType.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffType.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffType.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffType.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffType.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffType.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffType.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffType.CRIT_VALUE, 0.065));
        mage.addRuneTrinket(runeTrinket1, 1);

        RuneTrinket runeTrinket2 = new RuneTrinket();
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffType.HEALTH_POINTS, 0.065, OverallRelativeBuffType.CRIT_VALUE, 0.065, OverallRelativeBuffType.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffType.HEALTH_POINTS, 0.065, OverallRelativeBuffType.CRIT_VALUE, 0.065, OverallRelativeBuffType.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffType.HEALTH_POINTS, 0.065, OverallRelativeBuffType.CRIT_VALUE, 0.065, OverallRelativeBuffType.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffType.HEALTH_POINTS, 0.065, OverallRelativeBuffType.CRIT_VALUE, 0.065, OverallRelativeBuffType.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffType.HEALTH_POINTS, 0.065, OverallRelativeBuffType.CRIT_VALUE, 0.065, OverallRelativeBuffType.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffType.RESISTANCE, 0.065, OverallRelativeBuffType.DAMAGE, 0.065, OverallRelativeBuffType.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffType.RESISTANCE, 0.065, OverallRelativeBuffType.DAMAGE, 0.065, OverallRelativeBuffType.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffType.RESISTANCE, 0.065, OverallRelativeBuffType.DAMAGE, 0.065, OverallRelativeBuffType.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffType.RESISTANCE, 0.065, OverallRelativeBuffType.DAMAGE, 0.065, OverallRelativeBuffType.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffType.RESISTANCE, 0.065, OverallRelativeBuffType.DAMAGE, 0.065, OverallRelativeBuffType.BLOCK_VALUE, 0.065), ""));
        mage.addRuneTrinket(runeTrinket2, 2);

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
        mage.addRuneTrinket(runeTrinket3, 3);

        RuneTrinket runeTrinket4 = new RuneTrinket();
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffType.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffType.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffType.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffType.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffType.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffType.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffType.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffType.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffType.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffType.HEALTH_POINTS, 0.065));
        mage.addRuneTrinket(runeTrinket4, 4);

        RuneTrinket runeTrinket5 = new RuneTrinket();
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffType.ARMOR, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffType.ARMOR, 0.065));
        runeTrinket5.addRune(new SpecialRune("Rune of Rising Vigor", Map.of(OverallRelativeBuffType.MOVEMENT_SPEED, 0.10, OverallRelativeBuffType.ATTACK_SPEED, 0.06), ""));
        runeTrinket5.addRune(new SpecialRune("Rune of the Realm Changer", Map.of(), "Increases the Realm Changer talent by 5."));
        runeTrinket5.addRune(new SpecialRune("Rune of the Andermant Fever", Map.of(), "Increases the Andermant Fever talent by 5."));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffType.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffType.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffType.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffType.MOVEMENT_SPEED, 0.065));
        mage.addRuneTrinket(runeTrinket5, 5);

        JewelTrinket jewelTrinket1 = new JewelTrinket();
        jewelTrinket1.addJewel(new Jewel("Jewel of Eternal Scorn", OverallRelativeBuffType.CRIT_VALUE, 0.15, "..."));
        jewelTrinket1.addJewel(new Jewel("Jewel of Rage", "..."));
        jewelTrinket1.addJewel(new Jewel("Jewel of Amplified Healing", "..."));
        jewelTrinket1.addJewel(new Jewel("Jewel of the Frozen Heart", "..."));
        jewelTrinket1.addJewel(new Jewel("Jewel of the Easter Fever", "..."));
        jewelTrinket1.addJewel(new Jewel("Jewel of the Gem Fortune", "..."));
        jewelTrinket1.addJewel(new Jewel("Jewel of the Eternal Wrath", "..."));
        jewelTrinket1.addJewel(new Jewel("Jewel of the Ingredient Hunter", "..."));
        jewelTrinket1.addJewel(new Jewel("Jewel of the Ingredient Hunter", "..."));
        jewelTrinket1.addJewel(new Jewel("Jewel of the Ingredient Hunter", "..."));
        mage.addJewelTrinket(jewelTrinket1, 1);

        JewelTrinket jewelTrinket2 = new JewelTrinket();
        jewelTrinket2.addJewel(new Jewel("Jewel of Focus", "..."));
        jewelTrinket2.addJewel(new Jewel("Jewel of Focus", "..."));
        jewelTrinket2.addJewel(new Jewel("Jewel of Focus", "..."));
        jewelTrinket2.addJewel(new Jewel("Jewel of Focus", "..."));
        jewelTrinket2.addJewel(new Jewel("Jewel of Focus", "..."));
        jewelTrinket2.addJewel(new Jewel("Jewel of Vigor", OverallRelativeBuffType.DAMAGE, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Ambidextrous Vigor", OverallRelativeBuffType.TWO_HAND_DAMAGE, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Vitality", OverallRelativeBuffType.HEALTH_POINTS, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Encouragement", "..."));
        jewelTrinket2.addJewel(new Jewel("Jewel of Contribution", "..."));
        mage.addJewelTrinket(jewelTrinket2, 2);

        JewelTrinket jewelTrinket3 = new JewelTrinket();
        jewelTrinket3.addJewel(new Jewel("Jewel of Lasting Health", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Converse", "..."));
        jewelTrinket3.addJewel(new Jewel("Fiery Flower Jewel", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Strenuousness", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Fortitude", OverallRelativeBuffType.ARMOR, 0.1));
        jewelTrinket3.addJewel(new Jewel("Jewel of Prolongation", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Revival Boon", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Pent-up-Power", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Scorching Ray", "..."));
        mage.addJewelTrinket(jewelTrinket3, 3);

        WisdomSkillTree wisdomSkillTree = new WisdomSkillTree();
        wisdomSkillTree.setLevel(60, 1,1);
        wisdomSkillTree.setLevel(60, 1,2);

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
        wisdomSkillTree.setLevel(30, 6,3);

        wisdomSkillTree.setLevel(15, 7,1);
        wisdomSkillTree.setLevel(1, 7,2);
        wisdomSkillTree.setLevel(1, 7,3);

        wisdomSkillTree.setLevel(15, 8,1);
        wisdomSkillTree.setLevel(15, 8,2);

        mage.setWisdomSkillTree(wisdomSkillTree);

        mage.setEssence(1.00);

        Pet mortisPet = new Pet("Mortis Doll", Map.of(OverallRelativeBuffType.DAMAGE, 0.3, OverallRelativeBuffType.ATTACK_SPEED, 0.3, OverallRelativeBuffType.HEALTH_POINTS, 0.175), "");
        mage.setPet(mortisPet);
        mage.setCollectorBagBuff(Map.of(OverallRelativeBuffType.HEALTH_POINTS, 0.33, OverallRelativeBuffType.RESISTANCE, 0.15, OverallRelativeBuffType.DAMAGE, 0.06, OverallRelativeBuffType.BLOCK_VALUE, 0.02));

        Tonic tonic = new Tonic("Tonic of Vigor", StatType.HEALTH_POINTS, 156068.0);
        //mage.setTonic(tonic);
        Physic physic = new Physic("Advanced Physic of Vigor", OverallRelativeBuffType.HEALTH_POINTS, 0.18);
        //mage.setPhysic(physic);

        return mage;
    }
     */


    public static void printStats(Character character)
    {
        Map<StatType, Double> stats = character.calculateCharacterStats();
        System.out.println("Character: " + character.getName());
        System.out.printf(StatType.DAMAGE + ": %.2f%n", stats.get(StatType.DAMAGE));
        System.out.printf(StatType.ATTACK_SPEED + ": %.2f%n", stats.get(StatType.ATTACK_SPEED));
        System.out.printf(StatType.CRIT_VALUE + ": %.2f%n", stats.get(StatType.CRIT_VALUE));
        System.out.printf(StatType.MANA + ": %.2f%n", stats.get(StatType.MANA));
        System.out.printf(StatType.MANA_PER_SECOND + ": %.2f%n", stats.get(StatType.MANA_PER_SECOND));
        System.out.printf(StatType.MOVEMENT_SPEED + ": %.2f%n", stats.get(StatType.MOVEMENT_SPEED));
        System.out.printf(StatType.HEALTH_POINTS + ": %.2f%n", stats.get(StatType.HEALTH_POINTS));
        System.out.printf(StatType.HEALTH_PER_SECOND + ": %.2f%n", stats.get(StatType.HEALTH_PER_SECOND));
        System.out.printf(StatType.BLOCK_VALUE + ": %.2f%n", stats.get(StatType.BLOCK_VALUE));
        System.out.printf(StatType.ARMOR_VALUE + ": %.2f%n", stats.get(StatType.ARMOR_VALUE));
        System.out.printf(StatType.FIRE_RESISTANCE + ": %.2f%n", stats.get(StatType.FIRE_RESISTANCE));
        System.out.printf(StatType.ICE_RESISTANCE + ": %.2f%n", stats.get(StatType.ICE_RESISTANCE));
        System.out.printf(StatType.LIGHTNING_RESISTANCE + ": %.2f%n", stats.get(StatType.LIGHTNING_RESISTANCE));
        System.out.printf(StatType.ANDERMAGIC_RESISTANCE + ": %.2f%n", stats.get(StatType.ANDERMAGIC_RESISTANCE));
        System.out.printf(StatType.POISON_RESISTANCE + ": %.2f%n", stats.get(StatType.POISON_RESISTANCE));
    }
}