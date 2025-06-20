package CharacterTests;

import kaukasus.Buffs.Physic;
import kaukasus.Buffs.Tonic;
import kaukasus.Character.Character;
import kaukasus.Enchants.Enchant;
import kaukasus.Enums.*;
import kaukasus.Gems.Gem;
import kaukasus.Gems.Opal;
import kaukasus.Items.ActualItems.AbstractItem;
import kaukasus.Items.ActualItems.MythicItem;
import kaukasus.Items.ItemDatabase.MythicItems.SpellweaverMythicItem;
import kaukasus.Items.ActualItems.SetItem;
import kaukasus.Items.ActualItems.UniqueItem;
import kaukasus.Items.ItemDatabase.SetItems.SpellweaverSetItems;
import kaukasus.Items.ItemDatabase.UniqueItems.SpellweaverUniqueItems;
import kaukasus.Jewels.Jewel;
import kaukasus.Jewels.JewelTrinket;
import kaukasus.Pets.Pet;
import kaukasus.Runes.Rune;
import kaukasus.Runes.RuneTrinket;
import kaukasus.Runes.SpecialRune;
import kaukasus.SkillTrees.WisdomSkillTree.WisdomSkillTree;

import java.util.*;

public class RealMageTest {
    public static void main(String[] args) {
        Character mage = pveNormal2();
        mage.calculateFinalStats();
        printStats(mage);
    }

    public static Character pveNormal() {
        //3p sargon, 2p seeker, q8, q9
        Character mage = new Character(CharacterClassEnum.SPELLWEAVER, "3p sargon, 2p seeker, q8, q9");

        AbstractItem amulet = SpellweaverUniqueItems.AMULET_OF_THE_KRAKEN.getItem();
        amulet.setEnchants(EnchantTypeEnum.HEALTH_POINTS);
        amulet.setGems(AbsoluteStatTypeEnum.HEALTH_POINTS);
        mage.addItem(amulet, ItemSlotEnum.AMULET);

        AbstractItem cloak = SpellweaverMythicItem.ANCESTRAL_GLORY_CLOAK.getItem();
        cloak.setEnchants(EnchantTypeEnum.DAMAGE);
        cloak.setGems(AbsoluteStatTypeEnum.DAMAGE);
        mage.addItem(cloak, ItemSlotEnum.CLOAK);

        AbstractItem belt = SpellweaverUniqueItems.BELT_OF_ZEAL.getItem();
        belt.setEnchants(EnchantTypeEnum.DAMAGE);
        belt.setGems(AbsoluteStatTypeEnum.DAMAGE);
        mage.addItem(belt, ItemSlotEnum.BELT);

        AbstractItem ring1 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring1.setEnchants(EnchantTypeEnum.DAMAGE);
        ring1.setGems(AbsoluteStatTypeEnum.DAMAGE);
        mage.addItem(ring1, ItemSlotEnum.RING1);

        AbstractItem ring2 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring2.setEnchants(EnchantTypeEnum.DAMAGE);
        Opal opal = new Opal(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0), new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0), new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        ring2.addGems(opal, 10);
        mage.addItem(ring2, ItemSlotEnum.RING2);

        AbstractItem helmet = SpellweaverSetItems.SARGONS_HORNS.getItem();
        helmet.setEnchants(EnchantTypeEnum.HEALTH_POINTS);
        helmet.setGems(AbsoluteStatTypeEnum.HEALTH_POINTS);
        mage.addItem(helmet, ItemSlotEnum.HELMET);

        AbstractItem shoulders = SpellweaverSetItems.SARGONS_PAULDRONS.getItem();
        shoulders.setEnchants(EnchantTypeEnum.DAMAGE);
        shoulders.setGems(AbsoluteStatTypeEnum.CRIT_VALUE);
        mage.addItem(shoulders, ItemSlotEnum.SHOULDERS);

        AbstractItem torso = SpellweaverSetItems.SARGONS_TORSO.getItem();
        torso.setEnchants(EnchantTypeEnum.HEALTH_POINTS);
        torso.setGems(AbsoluteStatTypeEnum.HEALTH_POINTS);
        mage.addItem(torso, ItemSlotEnum.TORSO);

        AbstractItem gloves = SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_GLOVES.getItem();
        gloves.setEnchants(EnchantTypeEnum.DAMAGE);
        gloves.setGems(AbsoluteStatTypeEnum.CRIT_VALUE);
        mage.addItem(gloves, ItemSlotEnum.GLOVES);

        AbstractItem boots = SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_BOOTS.getItem();
        boots.setEnchants(EnchantTypeEnum.DAMAGE);
        boots.addGems(AbsoluteStatTypeEnum.CRIT_VALUE, 8);
        boots.addGems(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 2);
        mage.addItem(boots, ItemSlotEnum.BOOTS);

        AbstractItem adornment = SpellweaverUniqueItems.SIGRISMARRS_ETERNAL_GRASP.getItem();
        adornment.setEnchants(EnchantTypeEnum.DAMAGE);
        adornment.setGems(AbsoluteStatTypeEnum.DAMAGE);
        mage.addItem(adornment, ItemSlotEnum.WEAPON_ADORNMENT);

        AbstractItem twoHand = SpellweaverUniqueItems.GRIMACE_OF_THE_THUNDER_BEAST.getItem();
        twoHand.setEnchants(EnchantTypeEnum.DAMAGE);
        twoHand.setGems(AbsoluteStatTypeEnum.DAMAGE);
        mage.addItem(twoHand, ItemSlotEnum.TWO_HAND_WEAPON);



        RuneTrinket runeTrinket1 = new RuneTrinket();
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        mage.addRuneTrinket(runeTrinket1, 1);

        RuneTrinket runeTrinket2 = new RuneTrinket();
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        mage.addRuneTrinket(runeTrinket2, 2);

        RuneTrinket runeTrinket3 = new RuneTrinket();
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        mage.addRuneTrinket(runeTrinket3, 3);

        RuneTrinket runeTrinket4 = new RuneTrinket();
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        mage.addRuneTrinket(runeTrinket4, 4);

        RuneTrinket runeTrinket5 = new RuneTrinket();
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.065));
        runeTrinket5.addRune(new SpecialRune("Rune of Rising Vigor", Map.of(OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.10, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.06), ""));
        runeTrinket5.addRune(new SpecialRune("Rune of the Realm Changer", Map.of(), "Increases the Realm Changer talent by 5."));
        runeTrinket5.addRune(new SpecialRune("Rune of the Andermant Fever", Map.of(), "Increases the Andermant Fever talent by 5."));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        mage.addRuneTrinket(runeTrinket5, 5);

        JewelTrinket jewelTrinket1 = new JewelTrinket();
        jewelTrinket1.addJewel(new Jewel("Jewel of Eternal Scorn", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.15, "..."));
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
        jewelTrinket2.addJewel(new Jewel("Jewel of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Ambidextrous Vigor", OverallRelativeBuffTypeEnum.TWO_HAND_DAMAGE, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Encouragement", "..."));
        jewelTrinket2.addJewel(new Jewel("Jewel of Contribution", "..."));
        mage.addJewelTrinket(jewelTrinket2, 2);

        JewelTrinket jewelTrinket3 = new JewelTrinket();
        jewelTrinket3.addJewel(new Jewel("Jewel of Lasting Health", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Converse", "..."));
        jewelTrinket3.addJewel(new Jewel("Fiery Flower Jewel", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Strenuousness", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.1));
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

        Pet mortisPet = new Pet("Mortis Doll", Map.of(OverallRelativeBuffTypeEnum.DAMAGE, 0.3, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.3, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.175), "");
        mage.setPet(mortisPet);
        mage.setCollectorBagBuff(Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.33, OverallRelativeBuffTypeEnum.RESISTANCE, 0.15, OverallRelativeBuffTypeEnum.DAMAGE, 0.06, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.02));

        Tonic tonic = new Tonic("Tonic of Vigor", AbsoluteStatTypeEnum.HEALTH_POINTS, 156068.0);
        //mage.setTonic(tonic);
        Physic physic = new Physic("Advanced Physic of Vigor", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.18);
        //mage.setPhysic(physic);

        return mage;
    }

    public static Character pveNormal2() {
        //2p destructor, sargon gloves, 2p seeker, q8, q9
        Character mage = new Character(CharacterClassEnum.SPELLWEAVER, "2p destructor, sargon gloves, 2p seeker, q8, q9");

        AbstractItem amulet = SpellweaverUniqueItems.AMULET_OF_THE_KRAKEN.getItem();
        amulet.setEnchants(EnchantTypeEnum.HEALTH_POINTS);
        amulet.setGems(AbsoluteStatTypeEnum.HEALTH_POINTS);
        mage.addItem(amulet, ItemSlotEnum.AMULET);

        AbstractItem cloak = SpellweaverMythicItem.ANCESTRAL_GLORY_CLOAK.getItem();
        cloak.setEnchants(EnchantTypeEnum.DAMAGE);
        cloak.setGems(AbsoluteStatTypeEnum.CRIT_VALUE);
        mage.addItem(cloak, ItemSlotEnum.CLOAK);

        AbstractItem belt = SpellweaverUniqueItems.BELT_OF_ZEAL.getItem();
        belt.setEnchants(EnchantTypeEnum.DAMAGE);
        belt.setGems(AbsoluteStatTypeEnum.DAMAGE);
        mage.addItem(belt, ItemSlotEnum.BELT);

        AbstractItem ring1 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring1.setEnchants(EnchantTypeEnum.DAMAGE);
        ring1.setGems(AbsoluteStatTypeEnum.DAMAGE);
        mage.addItem(ring1, ItemSlotEnum.RING1);

        AbstractItem ring2 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring2.setEnchants(EnchantTypeEnum.DAMAGE);
        Opal opal = new Opal(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0), new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0), new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        ring2.addGems(opal, 10);
        mage.addItem(ring2, ItemSlotEnum.RING2);

        AbstractItem helmet = SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_HELMET.getItem();
        helmet.setEnchants(EnchantTypeEnum.HEALTH_POINTS);
        helmet.setGems(AbsoluteStatTypeEnum.HEALTH_POINTS);
        mage.addItem(helmet, ItemSlotEnum.HELMET);

        AbstractItem shoulders = SpellweaverSetItems.AUTOMATED_SHOULDERGUARDS.getItem();
        shoulders.setEnchants(EnchantTypeEnum.HEALTH_POINTS);
        shoulders.setGems(AbsoluteStatTypeEnum.HEALTH_POINTS);
        mage.addItem(shoulders, ItemSlotEnum.SHOULDERS);

        AbstractItem torso = SpellweaverSetItems.AUTOMATED_STERNUM_GUARD.getItem();
        torso.setEnchants(EnchantTypeEnum.DAMAGE);
        torso.setGems(AbsoluteStatTypeEnum.CRIT_VALUE);
        mage.addItem(torso, ItemSlotEnum.TORSO);

        AbstractItem gloves = SpellweaverUniqueItems.REIGN_OF_TERROR.getItem();
        gloves.setEnchants(EnchantTypeEnum.DAMAGE);
        gloves.setGems(AbsoluteStatTypeEnum.DAMAGE);
        mage.addItem(gloves, ItemSlotEnum.GLOVES);

        AbstractItem boots = SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_BOOTS.getItem();
        boots.setEnchants(EnchantTypeEnum.DAMAGE);
        boots.addGems(AbsoluteStatTypeEnum.CRIT_VALUE, 8);
        boots.addGems(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 2);
        mage.addItem(boots, ItemSlotEnum.BOOTS);

        AbstractItem adornment = SpellweaverUniqueItems.SIGRISMARRS_ETERNAL_GRASP.getItem();
        adornment.setEnchants(EnchantTypeEnum.DAMAGE);
        adornment.setGems(AbsoluteStatTypeEnum.DAMAGE);
        mage.addItem(adornment, ItemSlotEnum.WEAPON_ADORNMENT);

        AbstractItem twoHand = SpellweaverUniqueItems.GRIMACE_OF_THE_THUNDER_BEAST.getItem();
        twoHand.setEnchants(EnchantTypeEnum.DAMAGE);
        twoHand.setGems(AbsoluteStatTypeEnum.DAMAGE);
        mage.addItem(twoHand, ItemSlotEnum.TWO_HAND_WEAPON);



        RuneTrinket runeTrinket1 = new RuneTrinket();
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        mage.addRuneTrinket(runeTrinket1, 1);

        RuneTrinket runeTrinket2 = new RuneTrinket();
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        mage.addRuneTrinket(runeTrinket2, 2);

        RuneTrinket runeTrinket3 = new RuneTrinket();
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        mage.addRuneTrinket(runeTrinket3, 3);

        RuneTrinket runeTrinket4 = new RuneTrinket();
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        mage.addRuneTrinket(runeTrinket4, 4);

        RuneTrinket runeTrinket5 = new RuneTrinket();
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.065));
        runeTrinket5.addRune(new SpecialRune("Rune of Rising Vigor", Map.of(OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.10, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.06), ""));
        runeTrinket5.addRune(new SpecialRune("Rune of the Realm Changer", Map.of(), "Increases the Realm Changer talent by 5."));
        runeTrinket5.addRune(new SpecialRune("Rune of the Andermant Fever", Map.of(), "Increases the Andermant Fever talent by 5."));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        mage.addRuneTrinket(runeTrinket5, 5);

        JewelTrinket jewelTrinket1 = new JewelTrinket();
        jewelTrinket1.addJewel(new Jewel("Jewel of Eternal Scorn", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.15, "..."));
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
        jewelTrinket2.addJewel(new Jewel("Jewel of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Ambidextrous Vigor", OverallRelativeBuffTypeEnum.TWO_HAND_DAMAGE, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Encouragement", "..."));
        jewelTrinket2.addJewel(new Jewel("Jewel of Contribution", "..."));
        mage.addJewelTrinket(jewelTrinket2, 2);

        JewelTrinket jewelTrinket3 = new JewelTrinket();
        jewelTrinket3.addJewel(new Jewel("Jewel of Lasting Health", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Converse", "..."));
        jewelTrinket3.addJewel(new Jewel("Fiery Flower Jewel", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Strenuousness", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.1));
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

        Pet mortisPet = new Pet("Mortis Doll", Map.of(OverallRelativeBuffTypeEnum.DAMAGE, 0.3, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.3, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.175), "");
        mage.setPet(mortisPet);
        mage.setCollectorBagBuff(Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.33, OverallRelativeBuffTypeEnum.RESISTANCE, 0.15, OverallRelativeBuffTypeEnum.DAMAGE, 0.06, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.02));

        Tonic tonic = new Tonic("Tonic of Vigor", AbsoluteStatTypeEnum.HEALTH_POINTS, 156068.0);
        //mage.setTonic(tonic);
        Physic physic = new Physic("Advanced Physic of Vigor", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.18);
        //mage.setPhysic(physic);

        return mage;
    }

    public static Character mortisMage1() {
        //prem belt, mob gloves, seeker boots
        Character mage = new Character(CharacterClassEnum.SPELLWEAVER);

        AbstractItem amulet = SpellweaverSetItems.AMULET_OF_DEATH.getItem();
        amulet.setEnchants(EnchantTypeEnum.HEALTH_POINTS);
        amulet.setGems(AbsoluteStatTypeEnum.HEALTH_POINTS);
        mage.addItem(amulet, ItemSlotEnum.AMULET);

        AbstractItem cloak = SpellweaverMythicItem.ANCESTRAL_GLORY_CLOAK.getItem();
        cloak.setEnchants(EnchantTypeEnum.DAMAGE);
        cloak.setGems(AbsoluteStatTypeEnum.DAMAGE);
        mage.addItem(cloak, ItemSlotEnum.CLOAK);

        AbstractItem belt = SpellweaverUniqueItems.BELT_OF_ZEAL.getItem();
        belt.setEnchants(EnchantTypeEnum.DAMAGE);
        belt.setGems(AbsoluteStatTypeEnum.DAMAGE);
        mage.addItem(belt, ItemSlotEnum.BELT);

        AbstractItem ring1 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring1.setEnchants(EnchantTypeEnum.HEALTH_POINTS);
        ring1.setGems(AbsoluteStatTypeEnum.HEALTH_POINTS);
        mage.addItem(ring1, ItemSlotEnum.RING1);

        AbstractItem ring2 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring2.setEnchants(EnchantTypeEnum.DAMAGE);
        Opal opal = new Opal(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0), new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0), new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        ring2.addGems(opal, 10);
        mage.addItem(ring2, ItemSlotEnum.RING2);

        AbstractItem helmet = SpellweaverSetItems.CAP_OF_DEATH.getItem();
        helmet.setEnchants(EnchantTypeEnum.HEALTH_POINTS);
        helmet.setGems(AbsoluteStatTypeEnum.HEALTH_POINTS);
        mage.addItem(helmet, ItemSlotEnum.HELMET);

        AbstractItem shoulders = SpellweaverSetItems.SHOULDERS_OF_THE_END.getItem();
        shoulders.setEnchants(EnchantTypeEnum.HEALTH_POINTS);
        shoulders.setEnchants(EnchantTypeEnum.HEALTH_POINTS);
        mage.addItem(shoulders, ItemSlotEnum.SHOULDERS);

        AbstractItem torso = SpellweaverUniqueItems.RESEARCHERS_COAT.getItem();
        torso.setEnchants(EnchantTypeEnum.HEALTH_POINTS);
        torso.addGems(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0),6);
        torso.addGems(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0),4);
        mage.addItem(torso, ItemSlotEnum.TORSO);

        AbstractItem gloves = SpellweaverSetItems.GLOVES_OF_THE_FLAME_CONQUEROR.getItem();
        gloves.setEnchants(EnchantTypeEnum.ATTACK_SPEED);
        gloves.setGems(AbsoluteStatTypeEnum.ATTACK_SPEED);
        mage.addItem(gloves, ItemSlotEnum.GLOVES);

        AbstractItem boots = SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_BOOTS.getItem();
        boots.setEnchants(EnchantTypeEnum.DAMAGE);
        boots.setGems(AbsoluteStatTypeEnum.CRIT_VALUE);
        mage.addItem(boots, ItemSlotEnum.BOOTS);

        AbstractItem adornment = SpellweaverUniqueItems.STINGER.getItem();
        adornment.setGems(AbsoluteStatTypeEnum.CRIT_VALUE);
        adornment.setGems(AbsoluteStatTypeEnum.CRIT_VALUE);
        mage.addItem(adornment, ItemSlotEnum.WEAPON_ADORNMENT);

        AbstractItem twoHand = SpellweaverUniqueItems.GRIMACE_OF_THE_THUNDER_BEAST.getItem();
        twoHand.setEnchants(EnchantTypeEnum.DAMAGE);
        twoHand.setGems(AbsoluteStatTypeEnum.DAMAGE);
        mage.addItem(twoHand, ItemSlotEnum.TWO_HAND_WEAPON);

        RuneTrinket runeTrinket1 = new RuneTrinket();
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        mage.addRuneTrinket(runeTrinket1, 1);

        RuneTrinket runeTrinket2 = new RuneTrinket();
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        mage.addRuneTrinket(runeTrinket2, 2);

        RuneTrinket runeTrinket3 = new RuneTrinket();
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        mage.addRuneTrinket(runeTrinket3, 3);

        RuneTrinket runeTrinket4 = new RuneTrinket();
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        mage.addRuneTrinket(runeTrinket4, 4);

        RuneTrinket runeTrinket5 = new RuneTrinket();
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.065));
        runeTrinket5.addRune(new SpecialRune("Rune of Rising Vigor", Map.of(OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.10, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.06), ""));
        runeTrinket5.addRune(new SpecialRune("Rune of the Realm Changer", Map.of(), "Increases the Realm Changer talent by 5."));
        runeTrinket5.addRune(new SpecialRune("Rune of the Andermant Fever", Map.of(), "Increases the Andermant Fever talent by 5."));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        mage.addRuneTrinket(runeTrinket5, 5);

        JewelTrinket jewelTrinket1 = new JewelTrinket();
        jewelTrinket1.addJewel(new Jewel("Jewel of Eternal Scorn", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.15, "..."));
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
        jewelTrinket2.addJewel(new Jewel("Jewel of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Ambidextrous Vigor", OverallRelativeBuffTypeEnum.TWO_HAND_DAMAGE, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Encouragement", "..."));
        jewelTrinket2.addJewel(new Jewel("Jewel of Contribution", "..."));
        mage.addJewelTrinket(jewelTrinket2, 2);

        JewelTrinket jewelTrinket3 = new JewelTrinket();
        jewelTrinket3.addJewel(new Jewel("Jewel of Lasting Health", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Converse", "..."));
        jewelTrinket3.addJewel(new Jewel("Fiery Flower Jewel", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Strenuousness", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.1));
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

        Pet mortisPet = new Pet("Mortis Doll", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.48, OverallRelativeBuffTypeEnum.ARMOR, 0.18), "");
        mage.setPet(mortisPet);
        mage.setCollectorBagBuff(Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.33, OverallRelativeBuffTypeEnum.RESISTANCE, 0.15, OverallRelativeBuffTypeEnum.DAMAGE, 0.06, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.02));

        Tonic tonic = new Tonic("Tonic of Vigor", AbsoluteStatTypeEnum.HEALTH_POINTS, 156068.0);
        mage.setTonic(tonic);
        Physic physic = new Physic("Advanced Physic of Vigor", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.18);
        mage.setPhysic(physic);

        return mage;
    }

    public static Character mortisMage2() {
        //prem belt, mob gloves, briga boots
        Character mage = new Character(CharacterClassEnum.SPELLWEAVER);

        AbstractItem amulet = SpellweaverSetItems.AMULET_OF_DEATH.getItem();
        amulet.setEnchants(EnchantTypeEnum.HEALTH_POINTS);
        amulet.setGems(AbsoluteStatTypeEnum.HEALTH_POINTS);
        mage.addItem(amulet, ItemSlotEnum.AMULET);

        AbstractItem cloak = SpellweaverMythicItem.ANCESTRAL_GLORY_CLOAK.getItem();
        cloak.setEnchants(EnchantTypeEnum.DAMAGE);
        cloak.setGems(AbsoluteStatTypeEnum.DAMAGE);
        mage.addItem(cloak, ItemSlotEnum.CLOAK);

        AbstractItem belt = SpellweaverUniqueItems.BELT_OF_ZEAL.getItem();
        belt.setEnchants(EnchantTypeEnum.DAMAGE);
        belt.setGems(AbsoluteStatTypeEnum.DAMAGE);
        mage.addItem(belt, ItemSlotEnum.BELT);

        AbstractItem ring1 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring1.setEnchants(EnchantTypeEnum.HEALTH_POINTS);
        ring1.setGems(AbsoluteStatTypeEnum.HEALTH_POINTS);
        mage.addItem(ring1, ItemSlotEnum.RING1);

        AbstractItem ring2 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring2.setEnchants(EnchantTypeEnum.DAMAGE);
        Opal opal = new Opal(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0), new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0), new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        ring2.addGems(opal, 10);
        mage.addItem(ring2, ItemSlotEnum.RING2);

        AbstractItem helmet = SpellweaverSetItems.CAP_OF_DEATH.getItem();
        helmet.setEnchants(EnchantTypeEnum.HEALTH_POINTS);
        helmet.setGems(AbsoluteStatTypeEnum.HEALTH_POINTS);
        mage.addItem(helmet, ItemSlotEnum.HELMET);

        AbstractItem shoulders = SpellweaverSetItems.SHOULDERS_OF_THE_END.getItem();
        shoulders.setEnchants(EnchantTypeEnum.HEALTH_POINTS);
        shoulders.setEnchants(EnchantTypeEnum.HEALTH_POINTS);
        mage.addItem(shoulders, ItemSlotEnum.SHOULDERS);

        AbstractItem torso = SpellweaverUniqueItems.RESEARCHERS_COAT.getItem();
        torso.setEnchants(EnchantTypeEnum.HEALTH_POINTS);
        torso.addGems(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0),6);
        torso.addGems(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0),4);
        mage.addItem(torso, ItemSlotEnum.TORSO);

        AbstractItem gloves = SpellweaverSetItems.GLOVES_OF_THE_FLAME_CONQUEROR.getItem();
        gloves.setEnchants(EnchantTypeEnum.ATTACK_SPEED);
        gloves.setGems(AbsoluteStatTypeEnum.ATTACK_SPEED);
        mage.addItem(gloves, ItemSlotEnum.GLOVES);

        AbstractItem boots = SpellweaverUniqueItems.RESEARCHERS_BOOTS.getItem();
        boots.setEnchants(EnchantTypeEnum.CRIT_VALUE);
        boots.setGems(AbsoluteStatTypeEnum.CRIT_VALUE);
        mage.addItem(boots, ItemSlotEnum.BOOTS);

        AbstractItem adornment = SpellweaverUniqueItems.STINGER.getItem();
        adornment.setGems(AbsoluteStatTypeEnum.DAMAGE);
        adornment.setGems(AbsoluteStatTypeEnum.DAMAGE);
        mage.addItem(adornment, ItemSlotEnum.WEAPON_ADORNMENT);

        AbstractItem twoHand = SpellweaverUniqueItems.GRIMACE_OF_THE_THUNDER_BEAST.getItem();
        twoHand.setEnchants(EnchantTypeEnum.DAMAGE);
        twoHand.setGems(AbsoluteStatTypeEnum.DAMAGE);
        mage.addItem(twoHand, ItemSlotEnum.TWO_HAND_WEAPON);

        RuneTrinket runeTrinket1 = new RuneTrinket();
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        mage.addRuneTrinket(runeTrinket1, 1);

        RuneTrinket runeTrinket2 = new RuneTrinket();
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        mage.addRuneTrinket(runeTrinket2, 2);

        RuneTrinket runeTrinket3 = new RuneTrinket();
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        mage.addRuneTrinket(runeTrinket3, 3);

        RuneTrinket runeTrinket4 = new RuneTrinket();
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        mage.addRuneTrinket(runeTrinket4, 4);

        RuneTrinket runeTrinket5 = new RuneTrinket();
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.065));
        runeTrinket5.addRune(new SpecialRune("Rune of Rising Vigor", Map.of(OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.10, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.06), ""));
        runeTrinket5.addRune(new SpecialRune("Rune of the Realm Changer", Map.of(), "Increases the Realm Changer talent by 5."));
        runeTrinket5.addRune(new SpecialRune("Rune of the Andermant Fever", Map.of(), "Increases the Andermant Fever talent by 5."));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        mage.addRuneTrinket(runeTrinket5, 5);

        JewelTrinket jewelTrinket1 = new JewelTrinket();
        jewelTrinket1.addJewel(new Jewel("Jewel of Eternal Scorn", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.15, "..."));
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
        jewelTrinket2.addJewel(new Jewel("Jewel of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Ambidextrous Vigor", OverallRelativeBuffTypeEnum.TWO_HAND_DAMAGE, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Encouragement", "..."));
        jewelTrinket2.addJewel(new Jewel("Jewel of Contribution", "..."));
        mage.addJewelTrinket(jewelTrinket2, 2);

        JewelTrinket jewelTrinket3 = new JewelTrinket();
        jewelTrinket3.addJewel(new Jewel("Jewel of Lasting Health", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Converse", "..."));
        jewelTrinket3.addJewel(new Jewel("Fiery Flower Jewel", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Strenuousness", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.1));
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

        Pet mortisPet = new Pet("Mortis Doll", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.48, OverallRelativeBuffTypeEnum.ARMOR, 0.18, OverallRelativeBuffTypeEnum.DAMAGE, 0.2), "");
        mage.setPet(mortisPet);
        mage.setCollectorBagBuff(Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.33, OverallRelativeBuffTypeEnum.RESISTANCE, 0.15, OverallRelativeBuffTypeEnum.DAMAGE, 0.06, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.02));

        Tonic tonic = new Tonic("Tonic of Vigor", AbsoluteStatTypeEnum.HEALTH_POINTS, 156068.0);
        mage.setTonic(tonic);
        Physic physic = new Physic("Advanced Physic of Vigor", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.18);
        mage.setPhysic(physic);

        return mage;
    }

    public static Character mortisMage3() {
        //prem belt, sargon gloves, mob boots
        Character mage = new Character(CharacterClassEnum.SPELLWEAVER);

        AbstractItem amulet = SpellweaverSetItems.AMULET_OF_DEATH.getItem();
        amulet.setEnchants(EnchantTypeEnum.HEALTH_POINTS);
        amulet.setGems(AbsoluteStatTypeEnum.HEALTH_POINTS);
        mage.addItem(amulet, ItemSlotEnum.AMULET);

        AbstractItem cloak = SpellweaverMythicItem.ANCESTRAL_GLORY_CLOAK.getItem();
        cloak.setEnchants(EnchantTypeEnum.ATTACK_SPEED);
        cloak.setGems(AbsoluteStatTypeEnum.ATTACK_SPEED);
        mage.addItem(cloak, ItemSlotEnum.CLOAK);

        AbstractItem belt = SpellweaverUniqueItems.BELT_OF_ZEAL.getItem();
        belt.setEnchants(EnchantTypeEnum.DAMAGE);
        belt.setGems(AbsoluteStatTypeEnum.DAMAGE);
        mage.addItem(belt, ItemSlotEnum.BELT);

        AbstractItem ring1 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring1.setEnchants(EnchantTypeEnum.HEALTH_POINTS);
        ring1.setGems(AbsoluteStatTypeEnum.HEALTH_POINTS);
        mage.addItem(ring1, ItemSlotEnum.RING1);

        AbstractItem ring2 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring2.setEnchants(EnchantTypeEnum.DAMAGE);
        Opal opal = new Opal(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0), new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0), new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        ring2.addGems(opal, 10);
        mage.addItem(ring2, ItemSlotEnum.RING2);

        AbstractItem helmet = SpellweaverSetItems.CAP_OF_DEATH.getItem();
        helmet.setEnchants(EnchantTypeEnum.HEALTH_POINTS);
        helmet.setGems(AbsoluteStatTypeEnum.HEALTH_POINTS);
        mage.addItem(helmet, ItemSlotEnum.HELMET);

        AbstractItem shoulders = SpellweaverSetItems.SHOULDERS_OF_THE_END.getItem();
        shoulders.setEnchants(EnchantTypeEnum.HEALTH_POINTS);
        shoulders.setEnchants(EnchantTypeEnum.HEALTH_POINTS);
        mage.addItem(shoulders, ItemSlotEnum.SHOULDERS);

        AbstractItem torso = SpellweaverUniqueItems.RESEARCHERS_COAT.getItem();
        torso.setEnchants(EnchantTypeEnum.HEALTH_POINTS);
        torso.addGems(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0),2);
        torso.addGems(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0),6);
        torso.addGems(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17),2);
        mage.addItem(torso, ItemSlotEnum.TORSO);

        AbstractItem gloves = SpellweaverUniqueItems.REIGN_OF_TERROR.getItem();
        gloves.setEnchants(EnchantTypeEnum.DAMAGE);
        gloves.setGems(AbsoluteStatTypeEnum.DAMAGE);
        mage.addItem(gloves, ItemSlotEnum.GLOVES);

        AbstractItem boots = SpellweaverSetItems.BOOTS_OF_THE_FLAME_CONQUEROR.getItem();
        boots.setEnchants(EnchantTypeEnum.CRIT_VALUE);
        boots.setGems(AbsoluteStatTypeEnum.CRIT_VALUE);
        mage.addItem(boots, ItemSlotEnum.BOOTS);

        AbstractItem adornment = SpellweaverUniqueItems.STINGER.getItem();
        adornment.setGems(AbsoluteStatTypeEnum.DAMAGE);
        adornment.setGems(AbsoluteStatTypeEnum.DAMAGE);
        mage.addItem(adornment, ItemSlotEnum.WEAPON_ADORNMENT);

        AbstractItem twoHand = SpellweaverUniqueItems.GRIMACE_OF_THE_THUNDER_BEAST.getItem();
        twoHand.setEnchants(EnchantTypeEnum.DAMAGE);
        twoHand.setGems(AbsoluteStatTypeEnum.DAMAGE);
        mage.addItem(twoHand, ItemSlotEnum.TWO_HAND_WEAPON);

        RuneTrinket runeTrinket1 = new RuneTrinket();
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        mage.addRuneTrinket(runeTrinket1, 1);

        RuneTrinket runeTrinket2 = new RuneTrinket();
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        mage.addRuneTrinket(runeTrinket2, 2);

        RuneTrinket runeTrinket3 = new RuneTrinket();
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        mage.addRuneTrinket(runeTrinket3, 3);

        RuneTrinket runeTrinket4 = new RuneTrinket();
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        mage.addRuneTrinket(runeTrinket4, 4);

        RuneTrinket runeTrinket5 = new RuneTrinket();
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.065));
        runeTrinket5.addRune(new SpecialRune("Rune of Rising Vigor", Map.of(OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.10, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.06), ""));
        runeTrinket5.addRune(new SpecialRune("Rune of the Realm Changer", Map.of(), "Increases the Realm Changer talent by 5."));
        runeTrinket5.addRune(new SpecialRune("Rune of the Andermant Fever", Map.of(), "Increases the Andermant Fever talent by 5."));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        mage.addRuneTrinket(runeTrinket5, 5);

        JewelTrinket jewelTrinket1 = new JewelTrinket();
        jewelTrinket1.addJewel(new Jewel("Jewel of Eternal Scorn", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.15, "..."));
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
        jewelTrinket2.addJewel(new Jewel("Jewel of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Ambidextrous Vigor", OverallRelativeBuffTypeEnum.TWO_HAND_DAMAGE, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Encouragement", "..."));
        jewelTrinket2.addJewel(new Jewel("Jewel of Contribution", "..."));
        mage.addJewelTrinket(jewelTrinket2, 2);

        JewelTrinket jewelTrinket3 = new JewelTrinket();
        jewelTrinket3.addJewel(new Jewel("Jewel of Lasting Health", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Converse", "..."));
        jewelTrinket3.addJewel(new Jewel("Fiery Flower Jewel", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Strenuousness", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.1));
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

        Pet mortisPet = new Pet("Mortis Doll", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.38, OverallRelativeBuffTypeEnum.ARMOR, 0.18), "");
        mage.setPet(mortisPet);
        mage.setCollectorBagBuff(Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.33, OverallRelativeBuffTypeEnum.RESISTANCE, 0.15, OverallRelativeBuffTypeEnum.DAMAGE, 0.06, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.02));

        Tonic tonic = new Tonic("Tonic of Vigor", AbsoluteStatTypeEnum.HEALTH_POINTS, 156068.0);
        mage.setTonic(tonic);
        Physic physic = new Physic("Advanced Physic of Vigor", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.18);
        mage.setPhysic(physic);

        return mage;
    }

    public static Character mortisMage4() {
        //prem belt, sargon gloves, mob boots
        Character mage = new Character(CharacterClassEnum.SPELLWEAVER);

        AbstractItem amulet = SpellweaverSetItems.AMULET_OF_DEATH.getItem();
        amulet.setEnchants(EnchantTypeEnum.HEALTH_POINTS);
        amulet.setGems(AbsoluteStatTypeEnum.HEALTH_POINTS);
        mage.addItem(amulet, ItemSlotEnum.AMULET);

        AbstractItem cloak = SpellweaverMythicItem.ANCESTRAL_GLORY_CLOAK.getItem();
        cloak.setEnchants(EnchantTypeEnum.ATTACK_SPEED);
        cloak.setGems(AbsoluteStatTypeEnum.ATTACK_SPEED);
        mage.addItem(cloak, ItemSlotEnum.CLOAK);

        AbstractItem belt = SpellweaverSetItems.AUTOMATED_BELT.getItem();
        belt.setEnchants(EnchantTypeEnum.DAMAGE);
        belt.setGems(AbsoluteStatTypeEnum.DAMAGE);
        mage.addItem(belt, ItemSlotEnum.BELT);

        AbstractItem ring1 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring1.setEnchants(EnchantTypeEnum.HEALTH_POINTS);
        ring1.setGems(AbsoluteStatTypeEnum.HEALTH_POINTS);
        mage.addItem(ring1, ItemSlotEnum.RING1);

        AbstractItem ring2 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring2.setEnchants(EnchantTypeEnum.DAMAGE);
        Opal opal = new Opal(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0), new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0), new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        ring2.addGems(opal, 10);
        mage.addItem(ring2, ItemSlotEnum.RING2);

        AbstractItem helmet = SpellweaverSetItems.CAP_OF_DEATH.getItem();
        helmet.setEnchants(EnchantTypeEnum.HEALTH_POINTS);
        helmet.setGems(AbsoluteStatTypeEnum.HEALTH_POINTS);
        mage.addItem(helmet, ItemSlotEnum.HELMET);

        AbstractItem shoulders = SpellweaverSetItems.SHOULDERS_OF_THE_END.getItem();
        shoulders.setEnchants(EnchantTypeEnum.HEALTH_POINTS);
        shoulders.setEnchants(EnchantTypeEnum.HEALTH_POINTS);
        mage.addItem(shoulders, ItemSlotEnum.SHOULDERS);

        AbstractItem torso = SpellweaverUniqueItems.RESEARCHERS_COAT.getItem();
        torso.setEnchants(EnchantTypeEnum.HEALTH_POINTS);
        torso.addGems(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0),2);
        torso.addGems(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0),6);
        torso.addGems(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17),2);
        mage.addItem(torso, ItemSlotEnum.TORSO);

        AbstractItem gloves = SpellweaverSetItems.AUTOMATED_ARMGUARDS.getItem();
        gloves.setEnchants(EnchantTypeEnum.DAMAGE);
        gloves.setGems(AbsoluteStatTypeEnum.DAMAGE);
        mage.addItem(gloves, ItemSlotEnum.GLOVES);

        AbstractItem boots = SpellweaverSetItems.BOOTS_OF_THE_FLAME_CONQUEROR.getItem();
        boots.setEnchants(EnchantTypeEnum.CRIT_VALUE);
        boots.setGems(AbsoluteStatTypeEnum.CRIT_VALUE);
        mage.addItem(boots, ItemSlotEnum.BOOTS);

        AbstractItem adornment = SpellweaverUniqueItems.STINGER.getItem();
        adornment.setGems(AbsoluteStatTypeEnum.DAMAGE);
        adornment.setGems(AbsoluteStatTypeEnum.DAMAGE);
        mage.addItem(adornment, ItemSlotEnum.WEAPON_ADORNMENT);

        AbstractItem twoHand = SpellweaverUniqueItems.GRIMACE_OF_THE_THUNDER_BEAST.getItem();
        twoHand.setEnchants(EnchantTypeEnum.DAMAGE);
        twoHand.setGems(AbsoluteStatTypeEnum.DAMAGE);
        mage.addItem(twoHand, ItemSlotEnum.TWO_HAND_WEAPON);

        RuneTrinket runeTrinket1 = new RuneTrinket();
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        mage.addRuneTrinket(runeTrinket1, 1);

        RuneTrinket runeTrinket2 = new RuneTrinket();
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        mage.addRuneTrinket(runeTrinket2, 2);

        RuneTrinket runeTrinket3 = new RuneTrinket();
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        mage.addRuneTrinket(runeTrinket3, 3);

        RuneTrinket runeTrinket4 = new RuneTrinket();
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        mage.addRuneTrinket(runeTrinket4, 4);

        RuneTrinket runeTrinket5 = new RuneTrinket();
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.065));
        runeTrinket5.addRune(new SpecialRune("Rune of Rising Vigor", Map.of(OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.10, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.06), ""));
        runeTrinket5.addRune(new SpecialRune("Rune of the Realm Changer", Map.of(), "Increases the Realm Changer talent by 5."));
        runeTrinket5.addRune(new SpecialRune("Rune of the Andermant Fever", Map.of(), "Increases the Andermant Fever talent by 5."));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        mage.addRuneTrinket(runeTrinket5, 5);

        JewelTrinket jewelTrinket1 = new JewelTrinket();
        jewelTrinket1.addJewel(new Jewel("Jewel of Eternal Scorn", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.15, "..."));
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
        jewelTrinket2.addJewel(new Jewel("Jewel of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Ambidextrous Vigor", OverallRelativeBuffTypeEnum.TWO_HAND_DAMAGE, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Encouragement", "..."));
        jewelTrinket2.addJewel(new Jewel("Jewel of Contribution", "..."));
        mage.addJewelTrinket(jewelTrinket2, 2);

        JewelTrinket jewelTrinket3 = new JewelTrinket();
        jewelTrinket3.addJewel(new Jewel("Jewel of Lasting Health", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Converse", "..."));
        jewelTrinket3.addJewel(new Jewel("Fiery Flower Jewel", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Strenuousness", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.1));
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

        Pet mortisPet = new Pet("Mortis Doll", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.38, OverallRelativeBuffTypeEnum.ARMOR, 0.18), "");
        mage.setPet(mortisPet);
        mage.setCollectorBagBuff(Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.33, OverallRelativeBuffTypeEnum.RESISTANCE, 0.15, OverallRelativeBuffTypeEnum.DAMAGE, 0.06, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.02));

        Tonic tonic = new Tonic("Tonic of Vigor", AbsoluteStatTypeEnum.HEALTH_POINTS, 156068.0);
        mage.setTonic(tonic);
        Physic physic = new Physic("Advanced Physic of Vigor", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.18);
        mage.setPhysic(physic);

        return mage;
    }

    public static Character bghMage() {
        Character mage = new Character(CharacterClassEnum.SPELLWEAVER);

        Map<AbsoluteStatTypeEnum, Double> amuletBaseStats = new HashMap<>();
        amuletBaseStats.put(AbsoluteStatTypeEnum.CRIT_VALUE, 1731.466);
        amuletBaseStats.put(AbsoluteStatTypeEnum.HEALTH_POINTS, 24127.76);
        UniqueItem amulet = SpellweaverUniqueItems.AMULET_OF_THE_KRAKEN.getItem();
        amulet.setBaseStats(amuletBaseStats);
        amulet.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        amulet.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        amulet.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        amulet.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        mage.addItem(amulet, ItemSlotEnum.AMULET);

        MythicItem cloak = SpellweaverMythicItem.ANCESTRAL_GLORY_CLOAK.getItem();
        cloak.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(cloak, ItemSlotEnum.CLOAK);

        Map<AbsoluteStatTypeEnum, Double> beltBaseStats = new HashMap<>();
        beltBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1630.885);
        beltBaseStats.put(AbsoluteStatTypeEnum.HEALTH_POINTS, 20072.654);
        beltBaseStats.put(AbsoluteStatTypeEnum.RESISTANCE, 1679.873);
        UniqueItem belt = SpellweaverUniqueItems.BELT_OF_ZEAL.getItem();
        belt.setBaseStats(beltBaseStats);
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(belt, ItemSlotEnum.BELT);

        MythicItem ring1 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring1.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring1.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring1.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring1.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(ring1, ItemSlotEnum.RING1);
        MythicItem ring2 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring2.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        Opal opal = new Opal(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0), new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0), new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        ring2.addGem(opal);
        ring2.addGem(opal);
        ring2.addGem(opal);
        ring2.addGem(opal);
        ring2.addGem(opal);
        ring2.addGem(opal);
        ring2.addGem(opal);
        ring2.addGem(opal);
        ring2.addGem(opal);
        ring2.addGem(opal);
        mage.addItem(ring2, ItemSlotEnum.RING2);

        Map<AbsoluteStatTypeEnum, Double> helmetBaseStats = new HashMap<>();
        helmetBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1512.772);
        helmetBaseStats.put(AbsoluteStatTypeEnum.CRIT_VALUE, 1394.209);
        helmetBaseStats.put(AbsoluteStatTypeEnum.HEALTH_POINTS, 18258.694);
        SetItem helmet = SpellweaverSetItems.SARGONS_HORNS.getItem();
        helmet.setBaseStats(helmetBaseStats);
        helmet.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.4452));
        helmet.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44364));
        helmet.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44483));
        helmet.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44430));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        mage.addItem(helmet, ItemSlotEnum.HELMET);

        Map<AbsoluteStatTypeEnum, Double> shouldersBaseStats = new HashMap<>();
        shouldersBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1876.316);
        shouldersBaseStats.put(AbsoluteStatTypeEnum.CRIT_VALUE, 1282.912);
        shouldersBaseStats.put(AbsoluteStatTypeEnum.ANDERMAGIC_RESISTANCE, 3443.896);
        SetItem shoulders = SpellweaverSetItems.SARGONS_PAULDRONS.getItem();
        shoulders.setBaseStats(shouldersBaseStats);
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44757));
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44766));
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44757));
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44750));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        mage.addItem(shoulders, ItemSlotEnum.SHOULDERS);

        Map<AbsoluteStatTypeEnum, Double> torsoBaseStats = new HashMap<>();
        torsoBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1631.657);
        torsoBaseStats.put(AbsoluteStatTypeEnum.HEALTH_POINTS, 14232.794);
        torsoBaseStats.put(AbsoluteStatTypeEnum.ARMOR, 1639.716);
        SetItem torso = SpellweaverSetItems.SARGONS_TORSO.getItem();
        torso.setBaseStats(torsoBaseStats);
        torso.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44263));
        torso.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44415));
        torso.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44382));
        torso.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44237));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        mage.addItem(torso, ItemSlotEnum.TORSO);

        Map<AbsoluteStatTypeEnum, Double> glovesBaseStats = new HashMap<>();
        glovesBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1514.933);
        glovesBaseStats.put(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.053);
        glovesBaseStats.put(AbsoluteStatTypeEnum.CRIT_VALUE, 1494.107);
        SetItem gloves = SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_GLOVES.getItem();
        gloves.setBaseStats(glovesBaseStats);
        gloves.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44743));
        gloves.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44768));
        gloves.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44738));
        gloves.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44766));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        mage.addItem(gloves, ItemSlotEnum.GLOVES);

        Map<AbsoluteStatTypeEnum, Double> bootsBaseStats = new HashMap<>();
        bootsBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1510.415);
        bootsBaseStats.put(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 1.113);
        bootsBaseStats.put(AbsoluteStatTypeEnum.CRIT_VALUE, 1168.091);
        SetItem boots = SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_BOOTS.getItem();
        boots.setBaseStats(bootsBaseStats);
        boots.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44760));
        boots.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44763));
        boots.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44762));
        boots.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44751));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        mage.addItem(boots, ItemSlotEnum.BOOTS);

        Map<AbsoluteStatTypeEnum, Double> adornmentBaseStats = new HashMap<>();
        adornmentBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1870.52);
        adornmentBaseStats.put(AbsoluteStatTypeEnum.CRIT_VALUE, 2100.146);
        UniqueItem adornment = SpellweaverUniqueItems.SIGRISMARRS_ETERNAL_GRASP.getItem();
        adornment.setBaseStats(adornmentBaseStats);
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(adornment, ItemSlotEnum.WEAPON_ADORNMENT);

        Map<AbsoluteStatTypeEnum, Double> twoHandBaseStats = new HashMap<>();
        twoHandBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 24570.982);
        twoHandBaseStats.put(AbsoluteStatTypeEnum.CRIT_VALUE, 3321.515);
        UniqueItem twoHand = SpellweaverUniqueItems.GRIMACE_OF_THE_THUNDER_BEAST.getItem();
        twoHand.setBaseStats(twoHandBaseStats);
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(twoHand, ItemSlotEnum.TWO_HAND_WEAPON);

        RuneTrinket runeTrinket1 = new RuneTrinket();
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        mage.addRuneTrinket(runeTrinket1, 1);

        RuneTrinket runeTrinket2 = new RuneTrinket();
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        mage.addRuneTrinket(runeTrinket2, 2);

        RuneTrinket runeTrinket3 = new RuneTrinket();
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        mage.addRuneTrinket(runeTrinket3, 3);

        RuneTrinket runeTrinket4 = new RuneTrinket();
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        mage.addRuneTrinket(runeTrinket4, 4);

        RuneTrinket runeTrinket5 = new RuneTrinket();
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.065));
        runeTrinket5.addRune(new SpecialRune("Rune of Rising Vigor", Map.of(OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.10, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.06), ""));
        runeTrinket5.addRune(new SpecialRune("Rune of the Realm Changer", Map.of(), "Increases the Realm Changer talent by 5."));
        runeTrinket5.addRune(new SpecialRune("Rune of the Andermant Fever", Map.of(), "Increases the Andermant Fever talent by 5."));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        mage.addRuneTrinket(runeTrinket5, 5);

        JewelTrinket jewelTrinket1 = new JewelTrinket();
        jewelTrinket1.addJewel(new Jewel("Jewel of Eternal Scorn", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.15, "..."));
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
        jewelTrinket2.addJewel(new Jewel("Jewel of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Ambidextrous Vigor", OverallRelativeBuffTypeEnum.TWO_HAND_DAMAGE, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Encouragement", "..."));
        jewelTrinket2.addJewel(new Jewel("Jewel of Contribution", "..."));
        mage.addJewelTrinket(jewelTrinket2, 2);

        JewelTrinket jewelTrinket3 = new JewelTrinket();
        jewelTrinket3.addJewel(new Jewel("Jewel of Lasting Health", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Converse", "..."));
        jewelTrinket3.addJewel(new Jewel("Fiery Flower Jewel", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Strenuousness", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.1));
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

        Pet mortisPet = new Pet("Mortis Doll", Map.of(OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.3, OverallRelativeBuffTypeEnum.MANA, 0.3, OverallRelativeBuffTypeEnum.DAMAGE, 0.3, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 10.0), "");
        mage.setPet(mortisPet);
        mage.setCollectorBagBuff(Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.33, OverallRelativeBuffTypeEnum.RESISTANCE, 0.15, OverallRelativeBuffTypeEnum.DAMAGE, 0.06, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.02));

        Tonic tonic = new Tonic("Tonic of Vigor", AbsoluteStatTypeEnum.DAMAGE, 10496.0);
        //mage.setTonic(tonic);
        Physic physic = new Physic("Advanced Physic of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.18);
        //mage.setPhysic(physic);


        return mage;
    }

    public static Character q5Mage() {
        Character mage = new Character(CharacterClassEnum.SPELLWEAVER);

        Map<AbsoluteStatTypeEnum, Double> amuletBaseStats = new HashMap<>();
        amuletBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1495.899);
        amuletBaseStats.put(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.460);
        amuletBaseStats.put(AbsoluteStatTypeEnum.HEALTH_POINTS, 23093.384);
        AbstractItem amulet = SpellweaverUniqueItems.SARGONS_SHADOW_AMULET.getItem();
        amulet.setBaseStats(amuletBaseStats);
        amulet.setEnchants(EnchantTypeEnum.HEALTH_POINTS);
        amulet.setGems(AbsoluteStatTypeEnum.DAMAGE);
        mage.addItem(amulet, ItemSlotEnum.AMULET);

        MythicItem cloak = SpellweaverMythicItem.ANCESTRAL_GLORY_CLOAK.getItem();
        cloak.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(cloak, ItemSlotEnum.CLOAK);

        Map<AbsoluteStatTypeEnum, Double> beltBaseStats = new HashMap<>();
        beltBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1630.885);
        beltBaseStats.put(AbsoluteStatTypeEnum.HEALTH_POINTS, 20072.654);
        beltBaseStats.put(AbsoluteStatTypeEnum.RESISTANCE, 1679.873);
        UniqueItem belt = SpellweaverUniqueItems.BELT_OF_ZEAL.getItem();
        belt.setBaseStats(beltBaseStats);
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(belt, ItemSlotEnum.BELT);

        MythicItem ring1 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring1.setEnchants(EnchantTypeEnum.HEALTH_POINTS);
        ring1.setGems(AbsoluteStatTypeEnum.HEALTH_POINTS);
        mage.addItem(ring1, ItemSlotEnum.RING1);
        MythicItem ring2 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring2.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        Opal opal = new Opal(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0), new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0), new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        ring2.addGem(opal);
        ring2.addGem(opal);
        ring2.addGem(opal);
        ring2.addGem(opal);
        ring2.addGem(opal);
        ring2.addGem(opal);
        ring2.addGem(opal);
        ring2.addGem(opal);
        ring2.addGem(opal);
        ring2.addGem(opal);
        mage.addItem(ring2, ItemSlotEnum.RING2);

        Map<AbsoluteStatTypeEnum, Double> helmetBaseStats = new HashMap<>();
        helmetBaseStats.put(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.427);
        helmetBaseStats.put(AbsoluteStatTypeEnum.HEALTH_POINTS, 20345.704);
        helmetBaseStats.put(AbsoluteStatTypeEnum.POISON_RESISTANCE, 4145.679);
        AbstractItem helmet = SpellweaverSetItems.POISON_EXTINGUISHER_HAT.getItem();
        helmet.setBaseStats(helmetBaseStats);
        helmet.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.4452));
        helmet.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44364));
        helmet.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44483));
        helmet.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44430));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        mage.addItem(helmet, ItemSlotEnum.HELMET);

        AbstractItem shoulders = SpellweaverUniqueItems.ROYAL_PAULDRONS_OF_SINGULARITY.getItem();
        shoulders.setEnchants(EnchantTypeEnum.CRIT_VALUE);
        shoulders.setGems(AbsoluteStatTypeEnum.CRIT_VALUE);
        mage.addItem(shoulders, ItemSlotEnum.SHOULDERS);

        Map<AbsoluteStatTypeEnum, Double> torsoBaseStats = new HashMap<>();
        torsoBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1631.657);
        torsoBaseStats.put(AbsoluteStatTypeEnum.HEALTH_POINTS, 14232.794);
        torsoBaseStats.put(AbsoluteStatTypeEnum.ARMOR, 1639.716);
        SetItem torso = SpellweaverSetItems.SARGONS_TORSO.getItem();
        torso.setBaseStats(torsoBaseStats);
        torso.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44263));
        torso.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44415));
        torso.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44382));
        torso.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44237));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        mage.addItem(torso, ItemSlotEnum.TORSO);

        Map<AbsoluteStatTypeEnum, Double> glovesBaseStats = new HashMap<>();
        glovesBaseStats.put(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.054);
        glovesBaseStats.put(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.424);
        glovesBaseStats.put(AbsoluteStatTypeEnum.POISON_RESISTANCE, 3899.42);
        SetItem gloves = SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_GLOVES.getItem();
        gloves.setBaseStats(glovesBaseStats);
        gloves.setEnchants(EnchantTypeEnum.ATTACK_SPEED);
        gloves.setGems(AbsoluteStatTypeEnum.ATTACK_SPEED);
        mage.addItem(gloves, ItemSlotEnum.GLOVES);

        Map<AbsoluteStatTypeEnum, Double> bootsBaseStats = new HashMap<>();
        bootsBaseStats.put(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 1.198);
        bootsBaseStats.put(AbsoluteStatTypeEnum.HEALTH_POINTS, 12495.802);
        bootsBaseStats.put(AbsoluteStatTypeEnum.POISON_RESISTANCE, 3957.135);
        SetItem boots = SpellweaverSetItems.POISON_EXTINGUISHER_BOOTS.getItem();
        boots.setBaseStats(bootsBaseStats);
        boots.setEnchants(EnchantTypeEnum.HEALTH_POINTS);
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        mage.addItem(boots, ItemSlotEnum.BOOTS);

        Map<AbsoluteStatTypeEnum, Double> adornmentBaseStats = new HashMap<>();
        adornmentBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1870.52);
        adornmentBaseStats.put(AbsoluteStatTypeEnum.CRIT_VALUE, 2100.146);
        UniqueItem adornment = SpellweaverUniqueItems.SIGRISMARRS_ETERNAL_GRASP.getItem();
        adornment.setBaseStats(adornmentBaseStats);
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(adornment, ItemSlotEnum.WEAPON_ADORNMENT);

        Map<AbsoluteStatTypeEnum, Double> twoHandBaseStats = new HashMap<>();
        twoHandBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 24570.982);
        twoHandBaseStats.put(AbsoluteStatTypeEnum.CRIT_VALUE, 3321.515);
        UniqueItem twoHand = SpellweaverUniqueItems.GRIMACE_OF_THE_THUNDER_BEAST.getItem();
        twoHand.setBaseStats(twoHandBaseStats);
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(twoHand, ItemSlotEnum.TWO_HAND_WEAPON);

        RuneTrinket runeTrinket1 = new RuneTrinket();
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        mage.addRuneTrinket(runeTrinket1, 1);

        RuneTrinket runeTrinket2 = new RuneTrinket();
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        mage.addRuneTrinket(runeTrinket2, 2);

        RuneTrinket runeTrinket3 = new RuneTrinket();
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        mage.addRuneTrinket(runeTrinket3, 3);

        RuneTrinket runeTrinket4 = new RuneTrinket();
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        mage.addRuneTrinket(runeTrinket4, 4);

        RuneTrinket runeTrinket5 = new RuneTrinket();
        runeTrinket5.addRune(new SpecialRune("Rune of Rising Vigor", Map.of(OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.10, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.06), ""));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        mage.addRuneTrinket(runeTrinket5, 5);

        JewelTrinket jewelTrinket1 = new JewelTrinket();
        jewelTrinket1.addJewel(new Jewel("Jewel of Eternal Scorn", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.15, "..."));
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
        jewelTrinket2.addJewel(new Jewel("Jewel of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Ambidextrous Vigor", OverallRelativeBuffTypeEnum.TWO_HAND_DAMAGE, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Encouragement", "..."));
        jewelTrinket2.addJewel(new Jewel("Jewel of Contribution", "..."));
        mage.addJewelTrinket(jewelTrinket2, 2);

        JewelTrinket jewelTrinket3 = new JewelTrinket();
        jewelTrinket3.addJewel(new Jewel("Jewel of Lasting Health", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Converse", "..."));
        jewelTrinket3.addJewel(new Jewel("Fiery Flower Jewel", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Strenuousness", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.1));
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

        mage.setEssence(1.50);

        Pet mortisPet = new Pet("Mortis Doll", Map.of(OverallRelativeBuffTypeEnum.DAMAGE, 0.1, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.10), "");
        mage.setPet(mortisPet);
        mage.setCollectorBagBuff(Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.33, OverallRelativeBuffTypeEnum.RESISTANCE, 0.15, OverallRelativeBuffTypeEnum.DAMAGE, 0.06, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.02));

        Tonic tonic = new Tonic("Tonic of Vigor", AbsoluteStatTypeEnum.DAMAGE, 10496.0);
        mage.setTonic(tonic);
        Physic physic = new Physic("Advanced Physic of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.18);
        mage.setPhysic(physic);


        return mage;
    }

    public static Character bghMage10msrunes() {
        Character mage = new Character(CharacterClassEnum.SPELLWEAVER);

        Map<AbsoluteStatTypeEnum, Double> amuletBaseStats = new HashMap<>();
        amuletBaseStats.put(AbsoluteStatTypeEnum.CRIT_VALUE, 1731.466);
        amuletBaseStats.put(AbsoluteStatTypeEnum.HEALTH_POINTS, 24127.76);
        UniqueItem amulet = SpellweaverUniqueItems.AMULET_OF_THE_KRAKEN.getItem();
        amulet.setBaseStats(amuletBaseStats);
        amulet.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        amulet.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        amulet.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        amulet.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        mage.addItem(amulet, ItemSlotEnum.AMULET);

        MythicItem cloak = SpellweaverMythicItem.ANCESTRAL_GLORY_CLOAK.getItem();
        cloak.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        Opal opal = new Opal(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0), new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0), new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        cloak.addGem(opal);
        cloak.addGem(opal);
        cloak.addGem(opal);
        cloak.addGem(opal);
        cloak.addGem(opal);
        cloak.addGem(opal);
        cloak.addGem(opal);
        cloak.addGem(opal);
        cloak.addGem(opal);
        cloak.addGem(opal);
        mage.addItem(cloak, ItemSlotEnum.CLOAK);

        Map<AbsoluteStatTypeEnum, Double> beltBaseStats = new HashMap<>();
        beltBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1630.885);
        beltBaseStats.put(AbsoluteStatTypeEnum.HEALTH_POINTS, 20072.654);
        beltBaseStats.put(AbsoluteStatTypeEnum.RESISTANCE, 1679.873);
        UniqueItem belt = SpellweaverUniqueItems.BELT_OF_ZEAL.getItem();
        belt.setBaseStats(beltBaseStats);
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(belt, ItemSlotEnum.BELT);

        MythicItem ring1 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring1.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        ring1.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        ring1.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        ring1.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        mage.addItem(ring1, ItemSlotEnum.RING1);
        MythicItem ring2 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring2.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        ring2.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        ring2.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        ring2.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        mage.addItem(ring2, ItemSlotEnum.RING2);

        Map<AbsoluteStatTypeEnum, Double> helmetBaseStats = new HashMap<>();
        helmetBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1512.772);
        helmetBaseStats.put(AbsoluteStatTypeEnum.CRIT_VALUE, 1394.209);
        helmetBaseStats.put(AbsoluteStatTypeEnum.HEALTH_POINTS, 18258.694);
        SetItem helmet = SpellweaverSetItems.SARGONS_HORNS.getItem();
        helmet.setBaseStats(helmetBaseStats);
        helmet.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.4452));
        helmet.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44364));
        helmet.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44483));
        helmet.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44430));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        mage.addItem(helmet, ItemSlotEnum.HELMET);

        Map<AbsoluteStatTypeEnum, Double> shouldersBaseStats = new HashMap<>();
        shouldersBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1876.316);
        shouldersBaseStats.put(AbsoluteStatTypeEnum.CRIT_VALUE, 1282.912);
        shouldersBaseStats.put(AbsoluteStatTypeEnum.ANDERMAGIC_RESISTANCE, 3443.896);
        SetItem shoulders = SpellweaverSetItems.SARGONS_PAULDRONS.getItem();
        shoulders.setBaseStats(shouldersBaseStats);
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(shoulders, ItemSlotEnum.SHOULDERS);

        Map<AbsoluteStatTypeEnum, Double> torsoBaseStats = new HashMap<>();
        torsoBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1631.657);
        torsoBaseStats.put(AbsoluteStatTypeEnum.HEALTH_POINTS, 14232.794);
        torsoBaseStats.put(AbsoluteStatTypeEnum.ARMOR, 1639.716);
        SetItem torso = SpellweaverSetItems.SARGONS_TORSO.getItem();
        torso.setBaseStats(torsoBaseStats);
        torso.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44263));
        torso.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44415));
        torso.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44382));
        torso.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44237));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        mage.addItem(torso, ItemSlotEnum.TORSO);

        Map<AbsoluteStatTypeEnum, Double> glovesBaseStats = new HashMap<>();
        glovesBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1514.933);
        glovesBaseStats.put(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.053);
        glovesBaseStats.put(AbsoluteStatTypeEnum.CRIT_VALUE, 1494.107);
        SetItem gloves = SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_GLOVES.getItem();
        gloves.setBaseStats(glovesBaseStats);
        gloves.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44743));
        gloves.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44768));
        gloves.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44738));
        gloves.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44766));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(gloves, ItemSlotEnum.GLOVES);

        Map<AbsoluteStatTypeEnum, Double> bootsBaseStats = new HashMap<>();
        bootsBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1510.415);
        bootsBaseStats.put(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 1.113);
        bootsBaseStats.put(AbsoluteStatTypeEnum.CRIT_VALUE, 1168.091);
        SetItem boots = SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_BOOTS.getItem();
        boots.setBaseStats(bootsBaseStats);
        boots.addEnchant(new Enchant(EnchantTypeEnum.CRIT_VALUE, 0.24563));
        boots.addEnchant(new Enchant(EnchantTypeEnum.CRIT_VALUE, 0.24563));
        boots.addEnchant(new Enchant(EnchantTypeEnum.CRIT_VALUE, 0.24563));
        boots.addEnchant(new Enchant(EnchantTypeEnum.CRIT_VALUE, 0.24563));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        mage.addItem(boots, ItemSlotEnum.BOOTS);

        Map<AbsoluteStatTypeEnum, Double> adornmentBaseStats = new HashMap<>();
        adornmentBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1870.52);
        adornmentBaseStats.put(AbsoluteStatTypeEnum.CRIT_VALUE, 2100.146);
        UniqueItem adornment = SpellweaverUniqueItems.SIGRISMARRS_ETERNAL_GRASP.getItem();
        adornment.setBaseStats(adornmentBaseStats);
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(adornment, ItemSlotEnum.WEAPON_ADORNMENT);

        Map<AbsoluteStatTypeEnum, Double> twoHandBaseStats = new HashMap<>();
        twoHandBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 24570.982);
        twoHandBaseStats.put(AbsoluteStatTypeEnum.CRIT_VALUE, 3321.515);
        UniqueItem twoHand = SpellweaverUniqueItems.GRIMACE_OF_THE_THUNDER_BEAST.getItem();
        twoHand.setBaseStats(twoHandBaseStats);
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(twoHand, ItemSlotEnum.TWO_HAND_WEAPON);

        RuneTrinket runeTrinket1 = new RuneTrinket();
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        mage.addRuneTrinket(runeTrinket1, 1);

        RuneTrinket runeTrinket2 = new RuneTrinket();
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        mage.addRuneTrinket(runeTrinket2, 2);

        RuneTrinket runeTrinket3 = new RuneTrinket();
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        mage.addRuneTrinket(runeTrinket3, 3);

        RuneTrinket runeTrinket4 = new RuneTrinket();
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        mage.addRuneTrinket(runeTrinket4, 4);

        RuneTrinket runeTrinket5 = new RuneTrinket();
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.065));
        runeTrinket5.addRune(new SpecialRune("Rune of Rising Vigor", Map.of(OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.10, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.06), ""));
        runeTrinket5.addRune(new SpecialRune("Rune of the Realm Changer", Map.of(), "Increases the Realm Changer talent by 5."));
        runeTrinket5.addRune(new SpecialRune("Rune of the Andermant Fever", Map.of(), "Increases the Andermant Fever talent by 5."));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        mage.addRuneTrinket(runeTrinket5, 5);

        JewelTrinket jewelTrinket1 = new JewelTrinket();
        jewelTrinket1.addJewel(new Jewel("Jewel of Eternal Scorn", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.15, "..."));
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
        jewelTrinket2.addJewel(new Jewel("Jewel of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Ambidextrous Vigor", OverallRelativeBuffTypeEnum.TWO_HAND_DAMAGE, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Encouragement", "..."));
        jewelTrinket2.addJewel(new Jewel("Jewel of Contribution", "..."));
        mage.addJewelTrinket(jewelTrinket2, 2);

        JewelTrinket jewelTrinket3 = new JewelTrinket();
        jewelTrinket3.addJewel(new Jewel("Jewel of Lasting Health", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Converse", "..."));
        jewelTrinket3.addJewel(new Jewel("Fiery Flower Jewel", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Strenuousness", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.1));
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

        Pet mortisPet = new Pet("Mortis Doll", Map.of(OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.3, OverallRelativeBuffTypeEnum.MANA, 0.3, OverallRelativeBuffTypeEnum.DAMAGE, 0.3, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.10), "");
        mage.setPet(mortisPet);
        mage.setCollectorBagBuff(Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.33, OverallRelativeBuffTypeEnum.RESISTANCE, 0.15, OverallRelativeBuffTypeEnum.DAMAGE, 0.06, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.02));

        Tonic tonic = new Tonic("Tonic of Vigor", AbsoluteStatTypeEnum.DAMAGE, 10496.0);
        //mage.setTonic(tonic);
        Physic physic = new Physic("Advanced Physic of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.18);
        //mage.setPhysic(physic);


        return mage;
    }

    public static Character bghMage10msrunes2() {
        Character mage = new Character(CharacterClassEnum.SPELLWEAVER);

        Map<AbsoluteStatTypeEnum, Double> amuletBaseStats = new HashMap<>();
        amuletBaseStats.put(AbsoluteStatTypeEnum.CRIT_VALUE, 1731.466);
        amuletBaseStats.put(AbsoluteStatTypeEnum.HEALTH_POINTS, 24127.76);
        UniqueItem amulet = SpellweaverUniqueItems.AMULET_OF_THE_KRAKEN.getItem();
        amulet.setBaseStats(amuletBaseStats);
        amulet.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        amulet.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        amulet.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        amulet.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        mage.addItem(amulet, ItemSlotEnum.AMULET);

        MythicItem cloak = SpellweaverMythicItem.ANCESTRAL_GLORY_CLOAK.getItem();
        cloak.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        Opal opal = new Opal(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0), new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0), new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        cloak.addGem(opal);
        cloak.addGem(opal);
        cloak.addGem(opal);
        cloak.addGem(opal);
        cloak.addGem(opal);
        cloak.addGem(opal);
        cloak.addGem(opal);
        cloak.addGem(opal);
        cloak.addGem(opal);
        cloak.addGem(opal);
        mage.addItem(cloak, ItemSlotEnum.CLOAK);

        Map<AbsoluteStatTypeEnum, Double> beltBaseStats = new HashMap<>();
        beltBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1630.885);
        beltBaseStats.put(AbsoluteStatTypeEnum.HEALTH_POINTS, 20072.654);
        beltBaseStats.put(AbsoluteStatTypeEnum.RESISTANCE, 1679.873);
        UniqueItem belt = SpellweaverUniqueItems.BELT_OF_ZEAL.getItem();
        belt.setBaseStats(beltBaseStats);
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(belt, ItemSlotEnum.BELT);

        MythicItem ring1 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring1.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        ring1.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        ring1.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        ring1.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        mage.addItem(ring1, ItemSlotEnum.RING1);
        MythicItem ring2 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring2.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        ring2.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        ring2.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        ring2.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        mage.addItem(ring2, ItemSlotEnum.RING2);

        Map<AbsoluteStatTypeEnum, Double> helmetBaseStats = new HashMap<>();
        SetItem helmet = SpellweaverSetItems.HELMET_OF_THE_BLACK_KNIGHT.getItem();
        helmet.setBaseStats(helmetBaseStats);
        helmet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        helmet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        helmet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        helmet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(helmet, ItemSlotEnum.HELMET);

        Map<AbsoluteStatTypeEnum, Double> shouldersBaseStats = new HashMap<>();
        SetItem shoulders = SpellweaverSetItems.SHOULDERS_OF_THE_END.getItem();
        shoulders.setBaseStats(shouldersBaseStats);
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        mage.addItem(shoulders, ItemSlotEnum.SHOULDERS);

        Map<AbsoluteStatTypeEnum, Double> torsoBaseStats = new HashMap<>();
        SetItem torso = SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_TORSO.getItem();
        torso.setBaseStats(torsoBaseStats);
        torso.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44263));
        torso.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44415));
        torso.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44382));
        torso.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44237));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        mage.addItem(torso, ItemSlotEnum.TORSO);

        Map<AbsoluteStatTypeEnum, Double> glovesBaseStats = new HashMap<>();
        glovesBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1514.933);
        glovesBaseStats.put(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.053);
        glovesBaseStats.put(AbsoluteStatTypeEnum.CRIT_VALUE, 1494.107);
        UniqueItem gloves = SpellweaverUniqueItems.REIGN_OF_TERROR.getItem();
        gloves.setBaseStats(glovesBaseStats);
        gloves.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44743));
        gloves.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44768));
        gloves.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44738));
        gloves.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44766));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(gloves, ItemSlotEnum.GLOVES);

        Map<AbsoluteStatTypeEnum, Double> bootsBaseStats = new HashMap<>();
        bootsBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1510.415);
        bootsBaseStats.put(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 1.113);
        bootsBaseStats.put(AbsoluteStatTypeEnum.CRIT_VALUE, 1168.091);
        SetItem boots = SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_BOOTS.getItem();
        boots.setBaseStats(bootsBaseStats);
        boots.addEnchant(new Enchant(EnchantTypeEnum.CRIT_VALUE, 0.24563));
        boots.addEnchant(new Enchant(EnchantTypeEnum.CRIT_VALUE, 0.24563));
        boots.addEnchant(new Enchant(EnchantTypeEnum.CRIT_VALUE, 0.24563));
        boots.addEnchant(new Enchant(EnchantTypeEnum.CRIT_VALUE, 0.24563));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        mage.addItem(boots, ItemSlotEnum.BOOTS);

        Map<AbsoluteStatTypeEnum, Double> adornmentBaseStats = new HashMap<>();
        adornmentBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1870.52);
        adornmentBaseStats.put(AbsoluteStatTypeEnum.CRIT_VALUE, 2100.146);
        UniqueItem adornment = SpellweaverUniqueItems.SIGRISMARRS_ETERNAL_GRASP.getItem();
        adornment.setBaseStats(adornmentBaseStats);
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(adornment, ItemSlotEnum.WEAPON_ADORNMENT);

        Map<AbsoluteStatTypeEnum, Double> twoHandBaseStats = new HashMap<>();
        twoHandBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 24570.982);
        twoHandBaseStats.put(AbsoluteStatTypeEnum.CRIT_VALUE, 3321.515);
        UniqueItem twoHand = SpellweaverUniqueItems.GRIMACE_OF_THE_THUNDER_BEAST.getItem();
        twoHand.setBaseStats(twoHandBaseStats);
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(twoHand, ItemSlotEnum.TWO_HAND_WEAPON);

        RuneTrinket runeTrinket1 = new RuneTrinket();
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        mage.addRuneTrinket(runeTrinket1, 1);

        RuneTrinket runeTrinket2 = new RuneTrinket();
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        mage.addRuneTrinket(runeTrinket2, 2);

        RuneTrinket runeTrinket3 = new RuneTrinket();
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        mage.addRuneTrinket(runeTrinket3, 3);

        RuneTrinket runeTrinket4 = new RuneTrinket();
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        mage.addRuneTrinket(runeTrinket4, 4);

        RuneTrinket runeTrinket5 = new RuneTrinket();
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.065));
        runeTrinket5.addRune(new SpecialRune("Rune of Rising Vigor", Map.of(OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.10, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.06), ""));
        runeTrinket5.addRune(new SpecialRune("Rune of the Realm Changer", Map.of(), "Increases the Realm Changer talent by 5."));
        runeTrinket5.addRune(new SpecialRune("Rune of the Andermant Fever", Map.of(), "Increases the Andermant Fever talent by 5."));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        mage.addRuneTrinket(runeTrinket5, 5);

        JewelTrinket jewelTrinket1 = new JewelTrinket();
        jewelTrinket1.addJewel(new Jewel("Jewel of Eternal Scorn", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.15, "..."));
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
        jewelTrinket2.addJewel(new Jewel("Jewel of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Ambidextrous Vigor", OverallRelativeBuffTypeEnum.TWO_HAND_DAMAGE, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Encouragement", "..."));
        jewelTrinket2.addJewel(new Jewel("Jewel of Contribution", "..."));
        mage.addJewelTrinket(jewelTrinket2, 2);

        JewelTrinket jewelTrinket3 = new JewelTrinket();
        jewelTrinket3.addJewel(new Jewel("Jewel of Lasting Health", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Converse", "..."));
        jewelTrinket3.addJewel(new Jewel("Fiery Flower Jewel", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Strenuousness", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.1));
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

        Pet mortisPet = new Pet("Mortis Doll", Map.of(OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.3, OverallRelativeBuffTypeEnum.MANA, 0.3, OverallRelativeBuffTypeEnum.DAMAGE, 0.3, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.10), "");
        mage.setPet(mortisPet);
        mage.setCollectorBagBuff(Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.33, OverallRelativeBuffTypeEnum.RESISTANCE, 0.15, OverallRelativeBuffTypeEnum.DAMAGE, 0.06, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.02));

        Tonic tonic = new Tonic("Tonic of Vigor", AbsoluteStatTypeEnum.DAMAGE, 10496.0);
        //mage.setTonic(tonic);
        Physic physic = new Physic("Advanced Physic of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.18);
        //mage.setPhysic(physic);


        return mage;
    }

    public static Character sinasBuildmax() {
        Character mage = new Character(CharacterClassEnum.SPELLWEAVER);

        Map<AbsoluteStatTypeEnum, Double> amuletBaseStats = new HashMap<>();
        UniqueItem amulet = SpellweaverUniqueItems.SARGONS_SHADOW_AMULET.getItem();
        amulet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        amulet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        amulet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        amulet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(amulet, ItemSlotEnum.AMULET);

        MythicItem cloak = SpellweaverMythicItem.ANCESTRAL_GLORY_CLOAK.getItem();
        cloak.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(cloak, ItemSlotEnum.CLOAK);

        UniqueItem belt = SpellweaverUniqueItems.BELT_OF_ZEAL.getItem();
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(belt, ItemSlotEnum.BELT);

        MythicItem ring1 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring1.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        ring1.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        ring1.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        ring1.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        mage.addItem(ring1, ItemSlotEnum.RING1);
        MythicItem ring2 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring2.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        ring2.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        ring2.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        ring2.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        mage.addItem(ring2, ItemSlotEnum.RING2);

        SetItem helmet = SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_HELMET.getItem();
        helmet.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.4452));
        helmet.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44364));
        helmet.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44483));
        helmet.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44430));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        mage.addItem(helmet, ItemSlotEnum.HELMET);

        SetItem shoulders = SpellweaverSetItems.SHOULDERS_OF_THE_BLACK_KNIGHT.getItem();
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44757));
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        mage.addItem(shoulders, ItemSlotEnum.SHOULDERS);

        UniqueItem torso = SpellweaverUniqueItems.RESEARCHERS_COAT.getItem();
        torso.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        torso.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        torso.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        torso.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        mage.addItem(torso, ItemSlotEnum.TORSO);

        //UniqueItem gloves = SpellweaverUniqueItems.REIGN_OF_TERROR.getItem();
        SetItem gloves = SpellweaverSetItems.GLOVES_OF_THE_FLAME_CONQUEROR.getItem();
        gloves.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        gloves.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        gloves.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        gloves.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(gloves, ItemSlotEnum.GLOVES);

        SetItem boots = SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_BOOTS.getItem();
        boots.addEnchant(new Enchant(EnchantTypeEnum.CRIT_VALUE, 0.22444));
        boots.addEnchant(new Enchant(EnchantTypeEnum.CRIT_VALUE, 0.22444));
        boots.addEnchant(new Enchant(EnchantTypeEnum.CRIT_VALUE, 0.22444));
        boots.addEnchant(new Enchant(EnchantTypeEnum.CRIT_VALUE, 0.22444));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        mage.addItem(boots, ItemSlotEnum.BOOTS);

        UniqueItem adornment = SpellweaverUniqueItems.STINGER.getItem();
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        Opal opal = new Opal(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0), new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0), new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        adornment.addGem(opal);
        adornment.addGem(opal);
        adornment.addGem(opal);
        adornment.addGem(opal);
        adornment.addGem(opal);
        adornment.addGem(opal);
        opal = new Opal(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0), new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0), new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        adornment.addGem(opal);
        adornment.addGem(opal);
        adornment.addGem(opal);
        adornment.addGem(opal);
        mage.addItem(adornment, ItemSlotEnum.WEAPON_ADORNMENT);

        UniqueItem twoHand = SpellweaverUniqueItems.GRIMACE_OF_THE_THUNDER_BEAST.getItem();
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(twoHand, ItemSlotEnum.TWO_HAND_WEAPON);

        RuneTrinket runeTrinket1 = new RuneTrinket();
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        mage.addRuneTrinket(runeTrinket1, 1);

        RuneTrinket runeTrinket2 = new RuneTrinket();
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        mage.addRuneTrinket(runeTrinket2, 2);

        RuneTrinket runeTrinket3 = new RuneTrinket();
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        mage.addRuneTrinket(runeTrinket3, 3);

        RuneTrinket runeTrinket4 = new RuneTrinket();
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        mage.addRuneTrinket(runeTrinket4, 4);

        RuneTrinket runeTrinket5 = new RuneTrinket();
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.065));
        runeTrinket5.addRune(new SpecialRune("Rune of the Realm Changer", Map.of(), "Increases the Realm Changer talent by 5."));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new SpecialRune("Rune of Rising Vigor", Map.of(OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.10, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.06), ""));
        mage.addRuneTrinket(runeTrinket5, 5);

        JewelTrinket jewelTrinket1 = new JewelTrinket();
        jewelTrinket1.addJewel(new Jewel("Jewel of Eternal Scorn", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.15, "..."));
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
        jewelTrinket2.addJewel(new Jewel("Jewel of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Ambidextrous Vigor", OverallRelativeBuffTypeEnum.TWO_HAND_DAMAGE, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Encouragement", "..."));
        jewelTrinket2.addJewel(new Jewel("Jewel of Contribution", "..."));
        mage.addJewelTrinket(jewelTrinket2, 2);

        JewelTrinket jewelTrinket3 = new JewelTrinket();
        jewelTrinket3.addJewel(new Jewel("Jewel of Lasting Health", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Converse", "..."));
        jewelTrinket3.addJewel(new Jewel("Fiery Flower Jewel", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Strenuousness", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.1));
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

        Pet mortisPet = new Pet("Mortis Doll", Map.of(OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.3, OverallRelativeBuffTypeEnum.MANA, 0.3, OverallRelativeBuffTypeEnum.DAMAGE, 0.3, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.1), "");
        mage.setPet(mortisPet);
        mage.setCollectorBagBuff(Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.33, OverallRelativeBuffTypeEnum.RESISTANCE, 0.15, OverallRelativeBuffTypeEnum.DAMAGE, 0.06, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.02));

        Tonic tonic = new Tonic("Tonic of Vigor", AbsoluteStatTypeEnum.DAMAGE, 10496.0);
        //Tonic tonic = new Tonic("Tonic of Vigor", AbsoluteStatTypeEnum.HEALTH_POINTS, 156068.0);
        mage.setTonic(tonic);
        Physic physic = new Physic("Advanced Physic of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.18);
        //Physic physic = new Physic("Advanced Physic of Vigor", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.18);
        mage.setPhysic(physic);


        return mage;
    }

    public static Character bghMageNewDragan2() {
        Character mage = new Character(CharacterClassEnum.SPELLWEAVER);

        Map<AbsoluteStatTypeEnum, Double> amuletBaseStats = new HashMap<>();
        amuletBaseStats.put(AbsoluteStatTypeEnum.CRIT_VALUE, 1731.466);
        amuletBaseStats.put(AbsoluteStatTypeEnum.HEALTH_POINTS, 24127.76);
        UniqueItem amulet = SpellweaverUniqueItems.AMULET_OF_THE_KRAKEN.getItem();
        amulet.setBaseStats(amuletBaseStats);
        amulet.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        amulet.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        amulet.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        amulet.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        mage.addItem(amulet, ItemSlotEnum.AMULET);

        MythicItem cloak = SpellweaverMythicItem.ANCESTRAL_GLORY_CLOAK.getItem();
        cloak.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(cloak, ItemSlotEnum.CLOAK);

        Map<AbsoluteStatTypeEnum, Double> beltBaseStats = new HashMap<>();
        beltBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1630.885);
        beltBaseStats.put(AbsoluteStatTypeEnum.HEALTH_POINTS, 20072.654);
        beltBaseStats.put(AbsoluteStatTypeEnum.RESISTANCE, 1679.873);
        UniqueItem belt = SpellweaverUniqueItems.BELT_OF_ZEAL.getItem();
        belt.setBaseStats(beltBaseStats);
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(belt, ItemSlotEnum.BELT);

        MythicItem ring1 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring1.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring1.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring1.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring1.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        mage.addItem(ring1, ItemSlotEnum.RING1);
        MythicItem ring2 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring2.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        Opal opal = new Opal(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0), new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0), new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        ring2.addGem(opal);
        ring2.addGem(opal);
        ring2.addGem(opal);
        ring2.addGem(opal);
        ring2.addGem(opal);
        ring2.addGem(opal);
        ring2.addGem(opal);
        ring2.addGem(opal);
        ring2.addGem(opal);
        ring2.addGem(opal);
        mage.addItem(ring2, ItemSlotEnum.RING2);

        SetItem helmet = SpellweaverSetItems.HELMET_OF_THE_BLACK_KNIGHT.getItem();
        helmet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        helmet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        helmet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        helmet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        mage.addItem(helmet, ItemSlotEnum.HELMET);

        SetItem shoulders = SpellweaverSetItems.SHOULDERS_OF_THE_BLACK_KNIGHT.getItem();
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        mage.addItem(shoulders, ItemSlotEnum.SHOULDERS);

        SetItem torso = SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_TORSO.getItem();
        torso.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44263));
        torso.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44415));
        torso.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44382));
        torso.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44237));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        mage.addItem(torso, ItemSlotEnum.TORSO);

        Map<AbsoluteStatTypeEnum, Double> glovesBaseStats = new HashMap<>();
        glovesBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1584.734);
        glovesBaseStats.put(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.052);
        glovesBaseStats.put(AbsoluteStatTypeEnum.ARMOR, 653.453);
        UniqueItem gloves = SpellweaverUniqueItems.REIGN_OF_TERROR.getItem();
        gloves.setBaseStats(glovesBaseStats);
        gloves.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44743));
        gloves.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44768));
        gloves.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44738));
        gloves.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44766));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(gloves, ItemSlotEnum.GLOVES);

        Map<AbsoluteStatTypeEnum, Double> bootsBaseStats = new HashMap<>();
        bootsBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1510.415);
        bootsBaseStats.put(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 1.113);
        bootsBaseStats.put(AbsoluteStatTypeEnum.CRIT_VALUE, 1168.091);
        SetItem boots = SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_BOOTS.getItem();
        boots.setBaseStats(bootsBaseStats);
        boots.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44760));
        boots.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44763));
        boots.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44762));
        boots.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44751));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        mage.addItem(boots, ItemSlotEnum.BOOTS);

        Map<AbsoluteStatTypeEnum, Double> adornmentBaseStats = new HashMap<>();
        adornmentBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1870.52);
        adornmentBaseStats.put(AbsoluteStatTypeEnum.CRIT_VALUE, 2100.146);
        UniqueItem adornment = SpellweaverUniqueItems.SIGRISMARRS_ETERNAL_GRASP.getItem();
        adornment.setBaseStats(adornmentBaseStats);
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44771));
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44767));
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44775));
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44772));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(adornment, ItemSlotEnum.WEAPON_ADORNMENT);

        Map<AbsoluteStatTypeEnum, Double> twoHandBaseStats = new HashMap<>();
        twoHandBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 24570.982);
        twoHandBaseStats.put(AbsoluteStatTypeEnum.CRIT_VALUE, 3321.515);
        UniqueItem twoHand = SpellweaverUniqueItems.GRIMACE_OF_THE_THUNDER_BEAST.getItem();
        twoHand.setBaseStats(twoHandBaseStats);
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(twoHand, ItemSlotEnum.TWO_HAND_WEAPON);

        RuneTrinket runeTrinket1 = new RuneTrinket();
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        mage.addRuneTrinket(runeTrinket1, 1);

        RuneTrinket runeTrinket2 = new RuneTrinket();
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        mage.addRuneTrinket(runeTrinket2, 2);

        RuneTrinket runeTrinket3 = new RuneTrinket();
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        mage.addRuneTrinket(runeTrinket3, 3);

        RuneTrinket runeTrinket4 = new RuneTrinket();
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        mage.addRuneTrinket(runeTrinket4, 4);

        RuneTrinket runeTrinket5 = new RuneTrinket();
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.065));
        runeTrinket5.addRune(new SpecialRune("Rune of the Realm Changer", Map.of(), "Increases the Realm Changer talent by 5."));
        runeTrinket5.addRune(new SpecialRune("Rune of the Andermant Fever", Map.of(), "Increases the Andermant Fever talent by 5."));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Materi Blessing", OverallRelativeBuffTypeEnum.MATERI_FRAGMENT_DROP_BONUS, 0.3));
        runeTrinket5.addRune(new Rune("Rune of Materi Blessing", OverallRelativeBuffTypeEnum.MATERI_FRAGMENT_DROP_BONUS, 0.3));
        runeTrinket5.addRune(new SpecialRune("Rune of Rising Vigor", Map.of(OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.10, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.06), ""));
        mage.addRuneTrinket(runeTrinket5, 5);

        JewelTrinket jewelTrinket1 = new JewelTrinket();
        jewelTrinket1.addJewel(new Jewel("Jewel of Eternal Scorn", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.15, "..."));
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
        jewelTrinket2.addJewel(new Jewel("Jewel of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Ambidextrous Vigor", OverallRelativeBuffTypeEnum.TWO_HAND_DAMAGE, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Encouragement", "..."));
        jewelTrinket2.addJewel(new Jewel("Jewel of Contribution", "..."));
        mage.addJewelTrinket(jewelTrinket2, 2);

        JewelTrinket jewelTrinket3 = new JewelTrinket();
        jewelTrinket3.addJewel(new Jewel("Jewel of Lasting Health", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Converse", "..."));
        jewelTrinket3.addJewel(new Jewel("Fiery Flower Jewel", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Strenuousness", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.1));
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

        Pet mortisPet = new Pet("Mortis Doll", Map.of(OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.3, OverallRelativeBuffTypeEnum.MANA, 0.3, OverallRelativeBuffTypeEnum.DAMAGE, 0.4
                , OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.05, OverallRelativeBuffTypeEnum.ARMOR, 0.1), "");
        mage.setPet(mortisPet);
        mage.setCollectorBagBuff(Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.33, OverallRelativeBuffTypeEnum.RESISTANCE, 0.15, OverallRelativeBuffTypeEnum.DAMAGE, 0.06, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.02));

        Tonic tonic = new Tonic("Tonic of Vigor", AbsoluteStatTypeEnum.DAMAGE, 10496.0);
        //mage.setTonic(tonic);
        Physic physic = new Physic("Advanced Physic of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.18);
        //mage.setPhysic(physic);


        return mage;
    }

    public static Character bghMageNewDragan() {
        Character mage = new Character(CharacterClassEnum.SPELLWEAVER);

        Map<AbsoluteStatTypeEnum, Double> amuletBaseStats = new HashMap<>();
        amuletBaseStats.put(AbsoluteStatTypeEnum.CRIT_VALUE, 1731.466);
        amuletBaseStats.put(AbsoluteStatTypeEnum.HEALTH_POINTS, 24127.76);
        UniqueItem amulet = SpellweaverUniqueItems.AMULET_OF_THE_KRAKEN.getItem();
        amulet.setBaseStats(amuletBaseStats);
        amulet.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        amulet.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        amulet.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        amulet.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        mage.addItem(amulet, ItemSlotEnum.AMULET);

        MythicItem cloak = SpellweaverMythicItem.ANCESTRAL_GLORY_CLOAK.getItem();
        cloak.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(cloak, ItemSlotEnum.CLOAK);

        Map<AbsoluteStatTypeEnum, Double> beltBaseStats = new HashMap<>();
        beltBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1630.885);
        beltBaseStats.put(AbsoluteStatTypeEnum.HEALTH_POINTS, 20072.654);
        beltBaseStats.put(AbsoluteStatTypeEnum.RESISTANCE, 1679.873);
        UniqueItem belt = SpellweaverUniqueItems.BELT_OF_ZEAL.getItem();
        belt.setBaseStats(beltBaseStats);
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(belt, ItemSlotEnum.BELT);

        MythicItem ring1 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring1.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring1.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring1.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring1.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(ring1, ItemSlotEnum.RING1);
        MythicItem ring2 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring2.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        Opal opal = new Opal(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0), new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0), new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        ring2.addGem(opal);
        ring2.addGem(opal);
        ring2.addGem(opal);
        ring2.addGem(opal);
        ring2.addGem(opal);
        ring2.addGem(opal);
        ring2.addGem(opal);
        ring2.addGem(opal);
        ring2.addGem(opal);
        ring2.addGem(opal);
        mage.addItem(ring2, ItemSlotEnum.RING2);

        SetItem helmet = SpellweaverSetItems.HELMET_OF_THE_BLACK_KNIGHT.getItem();
        helmet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        helmet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        helmet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        helmet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        mage.addItem(helmet, ItemSlotEnum.HELMET);

        SetItem shoulders = SpellweaverSetItems.SHOULDERS_OF_THE_BLACK_KNIGHT.getItem();
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        mage.addItem(shoulders, ItemSlotEnum.SHOULDERS);

        Map<AbsoluteStatTypeEnum, Double> torsoBaseStats = new HashMap<>();
        torsoBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1631.657);
        torsoBaseStats.put(AbsoluteStatTypeEnum.HEALTH_POINTS, 14232.794);
        torsoBaseStats.put(AbsoluteStatTypeEnum.ARMOR, 1639.716);
        UniqueItem torso = SpellweaverUniqueItems.RESEARCHERS_COAT.getItem();
        torso.setBaseStats(torsoBaseStats);
        torso.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44263));
        torso.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44415));
        torso.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44382));
        torso.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44237));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        mage.addItem(torso, ItemSlotEnum.TORSO);

        Map<AbsoluteStatTypeEnum, Double> glovesBaseStats = new HashMap<>();
        glovesBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1514.933);
        glovesBaseStats.put(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.053);
        glovesBaseStats.put(AbsoluteStatTypeEnum.CRIT_VALUE, 1494.107);
        SetItem gloves = SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_GLOVES.getItem();
        gloves.setBaseStats(glovesBaseStats);
        gloves.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44743));
        gloves.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44768));
        gloves.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44738));
        gloves.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44766));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        mage.addItem(gloves, ItemSlotEnum.GLOVES);

        Map<AbsoluteStatTypeEnum, Double> bootsBaseStats = new HashMap<>();
        bootsBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1510.415);
        bootsBaseStats.put(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 1.113);
        bootsBaseStats.put(AbsoluteStatTypeEnum.CRIT_VALUE, 1168.091);
        SetItem boots = SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_BOOTS.getItem();
        boots.setBaseStats(bootsBaseStats);
        boots.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44760));
        boots.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44763));
        boots.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44762));
        boots.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44751));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        mage.addItem(boots, ItemSlotEnum.BOOTS);

        Map<AbsoluteStatTypeEnum, Double> adornmentBaseStats = new HashMap<>();
        adornmentBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1870.52);
        adornmentBaseStats.put(AbsoluteStatTypeEnum.CRIT_VALUE, 2100.146);
        UniqueItem adornment = SpellweaverUniqueItems.SIGRISMARRS_ETERNAL_GRASP.getItem();
        adornment.setBaseStats(adornmentBaseStats);
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44771));
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44767));
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44775));
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44772));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(adornment, ItemSlotEnum.WEAPON_ADORNMENT);

        Map<AbsoluteStatTypeEnum, Double> twoHandBaseStats = new HashMap<>();
        twoHandBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 24570.982);
        twoHandBaseStats.put(AbsoluteStatTypeEnum.CRIT_VALUE, 3321.515);
        UniqueItem twoHand = SpellweaverUniqueItems.GRIMACE_OF_THE_THUNDER_BEAST.getItem();
        twoHand.setBaseStats(twoHandBaseStats);
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(twoHand, ItemSlotEnum.TWO_HAND_WEAPON);

        RuneTrinket runeTrinket1 = new RuneTrinket();
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        mage.addRuneTrinket(runeTrinket1, 1);

        RuneTrinket runeTrinket2 = new RuneTrinket();
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        mage.addRuneTrinket(runeTrinket2, 2);

        RuneTrinket runeTrinket3 = new RuneTrinket();
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        mage.addRuneTrinket(runeTrinket3, 3);

        RuneTrinket runeTrinket4 = new RuneTrinket();
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        mage.addRuneTrinket(runeTrinket4, 4);

        RuneTrinket runeTrinket5 = new RuneTrinket();
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.065));
        runeTrinket5.addRune(new SpecialRune("Rune of the Realm Changer", Map.of(), "Increases the Realm Changer talent by 5."));
        runeTrinket5.addRune(new SpecialRune("Rune of the Andermant Fever", Map.of(), "Increases the Andermant Fever talent by 5."));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Materi Blessing", OverallRelativeBuffTypeEnum.MATERI_FRAGMENT_DROP_BONUS, 0.3));
        runeTrinket5.addRune(new Rune("Rune of Materi Blessing", OverallRelativeBuffTypeEnum.MATERI_FRAGMENT_DROP_BONUS, 0.3));
        runeTrinket5.addRune(new SpecialRune("Rune of Rising Vigor", Map.of(OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.10, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.06), ""));
        mage.addRuneTrinket(runeTrinket5, 5);

        JewelTrinket jewelTrinket1 = new JewelTrinket();
        jewelTrinket1.addJewel(new Jewel("Jewel of Eternal Scorn", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.15, "..."));
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
        jewelTrinket2.addJewel(new Jewel("Jewel of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Ambidextrous Vigor", OverallRelativeBuffTypeEnum.TWO_HAND_DAMAGE, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Encouragement", "..."));
        jewelTrinket2.addJewel(new Jewel("Jewel of Contribution", "..."));
        mage.addJewelTrinket(jewelTrinket2, 2);

        JewelTrinket jewelTrinket3 = new JewelTrinket();
        jewelTrinket3.addJewel(new Jewel("Jewel of Lasting Health", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Converse", "..."));
        jewelTrinket3.addJewel(new Jewel("Fiery Flower Jewel", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Strenuousness", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.1));
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

        mage.setEssence(0.50);

        Pet mortisPet = new Pet("Mortis Doll", Map.of(OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.3, OverallRelativeBuffTypeEnum.MANA, 0.3, OverallRelativeBuffTypeEnum.DAMAGE, 0.4
        , OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.05, OverallRelativeBuffTypeEnum.ARMOR, 0.1), "");
        mage.setPet(mortisPet);
        mage.setCollectorBagBuff(Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.33, OverallRelativeBuffTypeEnum.RESISTANCE, 0.15, OverallRelativeBuffTypeEnum.DAMAGE, 0.06, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.02));

        Tonic tonic = new Tonic("Tonic of Vigor", AbsoluteStatTypeEnum.DAMAGE, 10496.0);
        //mage.setTonic(tonic);
        Physic physic = new Physic("Advanced Physic of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.18);
        //mage.setPhysic(physic);


        return mage;
    }

    public static Character sinasBuild() {
        Character mage = new Character(CharacterClassEnum.SPELLWEAVER);

        Map<AbsoluteStatTypeEnum, Double> amuletBaseStats = new HashMap<>();
        amuletBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1495.899);
        amuletBaseStats.put(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.460);
        amuletBaseStats.put(AbsoluteStatTypeEnum.HEALTH_POINTS, 23093.384);
        UniqueItem amulet = SpellweaverUniqueItems.SARGONS_SHADOW_AMULET.getItem();
        amulet.setBaseStats(amuletBaseStats);
        amulet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        amulet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        amulet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        amulet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(amulet, ItemSlotEnum.AMULET);

        MythicItem cloak = SpellweaverMythicItem.ANCESTRAL_GLORY_CLOAK.getItem();
        cloak.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(cloak, ItemSlotEnum.CLOAK);

        Map<AbsoluteStatTypeEnum, Double> beltBaseStats = new HashMap<>();
        beltBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1630.885);
        beltBaseStats.put(AbsoluteStatTypeEnum.HEALTH_POINTS, 20072.654);
        beltBaseStats.put(AbsoluteStatTypeEnum.RESISTANCE, 1679.873);
        UniqueItem belt = SpellweaverUniqueItems.BELT_OF_ZEAL.getItem();
        belt.setBaseStats(beltBaseStats);
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(belt, ItemSlotEnum.BELT);

        MythicItem ring1 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring1.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        ring1.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        ring1.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        ring1.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        mage.addItem(ring1, ItemSlotEnum.RING1);
        MythicItem ring2 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring2.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        ring2.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        ring2.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        ring2.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        mage.addItem(ring2, ItemSlotEnum.RING2);

        Map<AbsoluteStatTypeEnum, Double> helmetBaseStats = new HashMap<>();
        helmetBaseStats.put(AbsoluteStatTypeEnum.HEALTH_POINTS, 18008.718);
        helmetBaseStats.put(AbsoluteStatTypeEnum.ARMOR, 1066.76);
        helmetBaseStats.put(AbsoluteStatTypeEnum.FIRE_RESISTANCE, 3382.495);
        SetItem helmet = SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_HELMET.getItem();
        helmet.setBaseStats(helmetBaseStats);
        helmet.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.4452));
        helmet.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44364));
        helmet.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44483));
        helmet.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44430));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        mage.addItem(helmet, ItemSlotEnum.HELMET);

        SetItem shoulders = SpellweaverSetItems.SHOULDERS_OF_THE_BLACK_KNIGHT.getItem();
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44757));
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        mage.addItem(shoulders, ItemSlotEnum.SHOULDERS);

        UniqueItem torso = SpellweaverUniqueItems.RESEARCHERS_COAT.getItem();
        torso.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        torso.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        torso.addEnchant(new Enchant(EnchantTypeEnum.CRIT_VALUE, 0.24563));
        torso.addEnchant(new Enchant(EnchantTypeEnum.CRIT_VALUE, 0.24563));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        mage.addItem(torso, ItemSlotEnum.TORSO);

        Map<AbsoluteStatTypeEnum, Double> glovesBaseStats = new HashMap<>();
        glovesBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1584.734);
        glovesBaseStats.put(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.052);
        glovesBaseStats.put(AbsoluteStatTypeEnum.ARMOR, 653.453);
        UniqueItem gloves = SpellweaverUniqueItems.REIGN_OF_TERROR.getItem();
        gloves.setBaseStats(glovesBaseStats);
        gloves.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        gloves.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        gloves.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        gloves.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(gloves, ItemSlotEnum.GLOVES);

        Map<AbsoluteStatTypeEnum, Double> bootsBaseStats = new HashMap<>();
        bootsBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1510.415);
        bootsBaseStats.put(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 1.113);
        bootsBaseStats.put(AbsoluteStatTypeEnum.CRIT_VALUE, 1168.091);
        SetItem boots = SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_BOOTS.getItem();
        boots.setBaseStats(bootsBaseStats);
        boots.addEnchant(new Enchant(EnchantTypeEnum.MOVEMENT_SPEED, 0.22444));
        boots.addEnchant(new Enchant(EnchantTypeEnum.MOVEMENT_SPEED, 0.22444));
        boots.addEnchant(new Enchant(EnchantTypeEnum.MOVEMENT_SPEED, 0.22444));
        boots.addEnchant(new Enchant(EnchantTypeEnum.MOVEMENT_SPEED, 0.22444));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        mage.addItem(boots, ItemSlotEnum.BOOTS);

        Map<AbsoluteStatTypeEnum, Double> adornmentBaseStats = new HashMap<>();
        adornmentBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1876.970);
        adornmentBaseStats.put(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.047);
        adornmentBaseStats.put(AbsoluteStatTypeEnum.CRIT_VALUE, 2066.609);
        UniqueItem adornment = SpellweaverUniqueItems.STINGER.getItem();
        adornment.setBaseStats(adornmentBaseStats);
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        Opal opal = new Opal(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0), new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0), new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
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
        mage.addItem(adornment, ItemSlotEnum.WEAPON_ADORNMENT);

        Map<AbsoluteStatTypeEnum, Double> twoHandBaseStats = new HashMap<>();
        twoHandBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 24570.982);
        twoHandBaseStats.put(AbsoluteStatTypeEnum.CRIT_VALUE, 3321.515);
        UniqueItem twoHand = SpellweaverUniqueItems.GRIMACE_OF_THE_THUNDER_BEAST.getItem();
        twoHand.setBaseStats(twoHandBaseStats);
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(twoHand, ItemSlotEnum.TWO_HAND_WEAPON);

        RuneTrinket runeTrinket1 = new RuneTrinket();
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        mage.addRuneTrinket(runeTrinket1, 1);

        RuneTrinket runeTrinket2 = new RuneTrinket();
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        mage.addRuneTrinket(runeTrinket2, 2);

        RuneTrinket runeTrinket3 = new RuneTrinket();
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        mage.addRuneTrinket(runeTrinket3, 3);

        RuneTrinket runeTrinket4 = new RuneTrinket();
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        mage.addRuneTrinket(runeTrinket4, 4);

        RuneTrinket runeTrinket5 = new RuneTrinket();
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.065));
        runeTrinket5.addRune(new SpecialRune("Rune of the Realm Changer", Map.of(), "Increases the Realm Changer talent by 5."));
        runeTrinket5.addRune(new SpecialRune("Rune of the Andermant Fever", Map.of(), "Increases the Andermant Fever talent by 5."));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Materi Blessing", OverallRelativeBuffTypeEnum.MATERI_FRAGMENT_DROP_BONUS, 0.3));
        runeTrinket5.addRune(new Rune("Rune of Materi Blessing", OverallRelativeBuffTypeEnum.MATERI_FRAGMENT_DROP_BONUS, 0.3));
        runeTrinket5.addRune(new SpecialRune("Rune of Rising Vigor", Map.of(OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.10, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.06), ""));
        mage.addRuneTrinket(runeTrinket5, 5);

        JewelTrinket jewelTrinket1 = new JewelTrinket();
        jewelTrinket1.addJewel(new Jewel("Jewel of Eternal Scorn", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.15, "..."));
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
        jewelTrinket2.addJewel(new Jewel("Jewel of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Ambidextrous Vigor", OverallRelativeBuffTypeEnum.TWO_HAND_DAMAGE, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Encouragement", "..."));
        jewelTrinket2.addJewel(new Jewel("Jewel of Contribution", "..."));
        mage.addJewelTrinket(jewelTrinket2, 2);

        JewelTrinket jewelTrinket3 = new JewelTrinket();
        jewelTrinket3.addJewel(new Jewel("Jewel of Lasting Health", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Converse", "..."));
        jewelTrinket3.addJewel(new Jewel("Fiery Flower Jewel", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Strenuousness", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.1));
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

        Pet mortisPet = new Pet("Mortis Doll", Map.of(OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.3, OverallRelativeBuffTypeEnum.MANA, 0.3, OverallRelativeBuffTypeEnum.DAMAGE, 0.3, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.1), "");
        mage.setPet(mortisPet);
        mage.setCollectorBagBuff(Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.33, OverallRelativeBuffTypeEnum.RESISTANCE, 0.15, OverallRelativeBuffTypeEnum.DAMAGE, 0.06, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.02));

        Tonic tonic = new Tonic("Tonic of Vigor", AbsoluteStatTypeEnum.DAMAGE, 10496.0);
        //mage.setTonic(tonic);
        Physic physic = new Physic("Advanced Physic of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.18);
        //mage.setPhysic(physic);


        return mage;
    }

    public static Character sinasBuildNewDragan() {
        Character mage = new Character(CharacterClassEnum.SPELLWEAVER);

        Map<AbsoluteStatTypeEnum, Double> amuletBaseStats = new HashMap<>();
        amuletBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1495.899);
        amuletBaseStats.put(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.460);
        amuletBaseStats.put(AbsoluteStatTypeEnum.HEALTH_POINTS, 23093.384);
        UniqueItem amulet = SpellweaverUniqueItems.SARGONS_SHADOW_AMULET.getItem();
        amulet.setBaseStats(amuletBaseStats);
        amulet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        amulet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        amulet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        amulet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(amulet, ItemSlotEnum.AMULET);

        MythicItem cloak = SpellweaverMythicItem.ANCESTRAL_GLORY_CLOAK.getItem();
        cloak.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(cloak, ItemSlotEnum.CLOAK);

        Map<AbsoluteStatTypeEnum, Double> beltBaseStats = new HashMap<>();
        beltBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1630.885);
        beltBaseStats.put(AbsoluteStatTypeEnum.HEALTH_POINTS, 20072.654);
        beltBaseStats.put(AbsoluteStatTypeEnum.RESISTANCE, 1679.873);
        UniqueItem belt = SpellweaverUniqueItems.BELT_OF_ZEAL.getItem();
        belt.setBaseStats(beltBaseStats);
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(belt, ItemSlotEnum.BELT);

        MythicItem ring1 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring1.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        ring1.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        ring1.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        ring1.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        mage.addItem(ring1, ItemSlotEnum.RING1);
        MythicItem ring2 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring2.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        ring2.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        ring2.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        ring2.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        mage.addItem(ring2, ItemSlotEnum.RING2);

        SetItem helmet = SpellweaverSetItems.HELMET_OF_THE_BLACK_KNIGHT.getItem();
        helmet.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.4452));
        helmet.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44364));
        helmet.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44483));
        helmet.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44430));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        mage.addItem(helmet, ItemSlotEnum.HELMET);

        SetItem shoulders = SpellweaverSetItems.SHOULDERS_OF_THE_END.getItem();
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44757));
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        mage.addItem(shoulders, ItemSlotEnum.SHOULDERS);

        SetItem torso = SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_TORSO.getItem();
        torso.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        torso.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        torso.addEnchant(new Enchant(EnchantTypeEnum.CRIT_VALUE, 0.24563));
        torso.addEnchant(new Enchant(EnchantTypeEnum.CRIT_VALUE, 0.24563));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        mage.addItem(torso, ItemSlotEnum.TORSO);

        Map<AbsoluteStatTypeEnum, Double> glovesBaseStats = new HashMap<>();
        glovesBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1584.734);
        glovesBaseStats.put(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.052);
        glovesBaseStats.put(AbsoluteStatTypeEnum.ARMOR, 653.453);
        UniqueItem gloves = SpellweaverUniqueItems.REIGN_OF_TERROR.getItem();
        gloves.setBaseStats(glovesBaseStats);
        gloves.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        gloves.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        gloves.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        gloves.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(gloves, ItemSlotEnum.GLOVES);

        Map<AbsoluteStatTypeEnum, Double> bootsBaseStats = new HashMap<>();
        bootsBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1510.415);
        bootsBaseStats.put(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 1.113);
        bootsBaseStats.put(AbsoluteStatTypeEnum.CRIT_VALUE, 1168.091);
        SetItem boots = SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_BOOTS.getItem();
        boots.setBaseStats(bootsBaseStats);
        boots.addEnchant(new Enchant(EnchantTypeEnum.MOVEMENT_SPEED, 0.22444));
        boots.addEnchant(new Enchant(EnchantTypeEnum.MOVEMENT_SPEED, 0.22444));
        boots.addEnchant(new Enchant(EnchantTypeEnum.MOVEMENT_SPEED, 0.22444));
        boots.addEnchant(new Enchant(EnchantTypeEnum.MOVEMENT_SPEED, 0.22444));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        mage.addItem(boots, ItemSlotEnum.BOOTS);

        Map<AbsoluteStatTypeEnum, Double> adornmentBaseStats = new HashMap<>();
        adornmentBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1876.970);
        adornmentBaseStats.put(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.047);
        adornmentBaseStats.put(AbsoluteStatTypeEnum.CRIT_VALUE, 2066.609);
        UniqueItem adornment = SpellweaverUniqueItems.STINGER.getItem();
        adornment.setBaseStats(adornmentBaseStats);
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        Opal opal = new Opal(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0), new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0), new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
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
        mage.addItem(adornment, ItemSlotEnum.WEAPON_ADORNMENT);

        Map<AbsoluteStatTypeEnum, Double> twoHandBaseStats = new HashMap<>();
        twoHandBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 24570.982);
        twoHandBaseStats.put(AbsoluteStatTypeEnum.CRIT_VALUE, 3321.515);
        UniqueItem twoHand = SpellweaverUniqueItems.GRIMACE_OF_THE_THUNDER_BEAST.getItem();
        twoHand.setBaseStats(twoHandBaseStats);
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(twoHand, ItemSlotEnum.TWO_HAND_WEAPON);

        RuneTrinket runeTrinket1 = new RuneTrinket();
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        mage.addRuneTrinket(runeTrinket1, 1);

        RuneTrinket runeTrinket2 = new RuneTrinket();
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        mage.addRuneTrinket(runeTrinket2, 2);

        RuneTrinket runeTrinket3 = new RuneTrinket();
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        mage.addRuneTrinket(runeTrinket3, 3);

        RuneTrinket runeTrinket4 = new RuneTrinket();
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        mage.addRuneTrinket(runeTrinket4, 4);

        RuneTrinket runeTrinket5 = new RuneTrinket();
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.065));
        runeTrinket5.addRune(new SpecialRune("Rune of the Realm Changer", Map.of(), "Increases the Realm Changer talent by 5."));
        runeTrinket5.addRune(new SpecialRune("Rune of the Andermant Fever", Map.of(), "Increases the Andermant Fever talent by 5."));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Materi Blessing", OverallRelativeBuffTypeEnum.MATERI_FRAGMENT_DROP_BONUS, 0.3));
        runeTrinket5.addRune(new Rune("Rune of Materi Blessing", OverallRelativeBuffTypeEnum.MATERI_FRAGMENT_DROP_BONUS, 0.3));
        runeTrinket5.addRune(new SpecialRune("Rune of Rising Vigor", Map.of(OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.10, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.06), ""));
        mage.addRuneTrinket(runeTrinket5, 5);

        JewelTrinket jewelTrinket1 = new JewelTrinket();
        jewelTrinket1.addJewel(new Jewel("Jewel of Eternal Scorn", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.15, "..."));
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
        jewelTrinket2.addJewel(new Jewel("Jewel of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Ambidextrous Vigor", OverallRelativeBuffTypeEnum.TWO_HAND_DAMAGE, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Encouragement", "..."));
        jewelTrinket2.addJewel(new Jewel("Jewel of Contribution", "..."));
        mage.addJewelTrinket(jewelTrinket2, 2);

        JewelTrinket jewelTrinket3 = new JewelTrinket();
        jewelTrinket3.addJewel(new Jewel("Jewel of Lasting Health", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Converse", "..."));
        jewelTrinket3.addJewel(new Jewel("Fiery Flower Jewel", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Strenuousness", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.1));
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

        Pet mortisPet = new Pet("Mortis Doll", Map.of(OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.3, OverallRelativeBuffTypeEnum.MANA, 0.3, OverallRelativeBuffTypeEnum.DAMAGE, 0.3, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.1), "");
        mage.setPet(mortisPet);
        mage.setCollectorBagBuff(Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.33, OverallRelativeBuffTypeEnum.RESISTANCE, 0.15, OverallRelativeBuffTypeEnum.DAMAGE, 0.06, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.02));

        Tonic tonic = new Tonic("Tonic of Vigor", AbsoluteStatTypeEnum.DAMAGE, 10496.0);
        //mage.setTonic(tonic);
        Physic physic = new Physic("Advanced Physic of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.18);
        //mage.setPhysic(physic);


        return mage;
    }

    public static Character sinasBuildNewDragan2() {
        Character mage = new Character(CharacterClassEnum.SPELLWEAVER);

        Map<AbsoluteStatTypeEnum, Double> amuletBaseStats = new HashMap<>();
        amuletBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1495.899);
        amuletBaseStats.put(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.460);
        amuletBaseStats.put(AbsoluteStatTypeEnum.HEALTH_POINTS, 23093.384);
        UniqueItem amulet = SpellweaverUniqueItems.SARGONS_SHADOW_AMULET.getItem();
        amulet.setBaseStats(amuletBaseStats);
        amulet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        amulet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        amulet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        amulet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(amulet, ItemSlotEnum.AMULET);

        MythicItem cloak = SpellweaverMythicItem.ANCESTRAL_GLORY_CLOAK.getItem();
        cloak.addEnchant(new Enchant(EnchantTypeEnum.ATTACK_SPEED, 0.47122));
        cloak.addEnchant(new Enchant(EnchantTypeEnum.ATTACK_SPEED, 0.47122));
        cloak.addEnchant(new Enchant(EnchantTypeEnum.ATTACK_SPEED, 0.47122));
        cloak.addEnchant(new Enchant(EnchantTypeEnum.ATTACK_SPEED, 0.47122));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.017));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.017));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.017));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.017));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.017));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.017));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.017));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.017));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.017));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.017));
        mage.addItem(cloak, ItemSlotEnum.CLOAK);

        Map<AbsoluteStatTypeEnum, Double> beltBaseStats = new HashMap<>();
        beltBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1630.885);
        beltBaseStats.put(AbsoluteStatTypeEnum.HEALTH_POINTS, 20072.654);
        beltBaseStats.put(AbsoluteStatTypeEnum.RESISTANCE, 1679.873);
        UniqueItem belt = SpellweaverUniqueItems.BELT_OF_ZEAL.getItem();
        belt.setBaseStats(beltBaseStats);
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(belt, ItemSlotEnum.BELT);

        MythicItem ring1 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring1.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        ring1.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        ring1.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        ring1.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        mage.addItem(ring1, ItemSlotEnum.RING1);
        MythicItem ring2 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring2.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(ring2, ItemSlotEnum.RING2);

        SetItem helmet = SpellweaverSetItems.HELMET_OF_THE_BLACK_KNIGHT.getItem();
        helmet.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.4452));
        helmet.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44364));
        helmet.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44483));
        helmet.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44430));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        mage.addItem(helmet, ItemSlotEnum.HELMET);

        SetItem shoulders = SpellweaverSetItems.SHOULDERS_OF_THE_END.getItem();
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44757));
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        mage.addItem(shoulders, ItemSlotEnum.SHOULDERS);

        UniqueItem torso = SpellweaverUniqueItems.RESEARCHERS_COAT.getItem();
        torso.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        torso.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        torso.addEnchant(new Enchant(EnchantTypeEnum.CRIT_VALUE, 0.24563));
        torso.addEnchant(new Enchant(EnchantTypeEnum.CRIT_VALUE, 0.24563));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        mage.addItem(torso, ItemSlotEnum.TORSO);

        Map<AbsoluteStatTypeEnum, Double> glovesBaseStats = new HashMap<>();
        glovesBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1584.734);
        glovesBaseStats.put(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.052);
        glovesBaseStats.put(AbsoluteStatTypeEnum.ARMOR, 653.453);
        UniqueItem gloves = SpellweaverUniqueItems.REIGN_OF_TERROR.getItem();
        gloves.setBaseStats(glovesBaseStats);
        gloves.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        gloves.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        gloves.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        gloves.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(gloves, ItemSlotEnum.GLOVES);

        Map<AbsoluteStatTypeEnum, Double> bootsBaseStats = new HashMap<>();
        bootsBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1510.415);
        bootsBaseStats.put(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 1.113);
        bootsBaseStats.put(AbsoluteStatTypeEnum.CRIT_VALUE, 1168.091);
        SetItem boots = SpellweaverSetItems.BOOTS_OF_THE_FLAME_CONQUEROR.getItem();
        boots.setBaseStats(bootsBaseStats);
        boots.addEnchant(new Enchant(EnchantTypeEnum.MOVEMENT_SPEED, 0.22444));
        boots.addEnchant(new Enchant(EnchantTypeEnum.MOVEMENT_SPEED, 0.22444));
        boots.addEnchant(new Enchant(EnchantTypeEnum.MOVEMENT_SPEED, 0.22444));
        boots.addEnchant(new Enchant(EnchantTypeEnum.MOVEMENT_SPEED, 0.22444));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        mage.addItem(boots, ItemSlotEnum.BOOTS);

        Map<AbsoluteStatTypeEnum, Double> adornmentBaseStats = new HashMap<>();
        adornmentBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1876.970);
        adornmentBaseStats.put(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.047);
        adornmentBaseStats.put(AbsoluteStatTypeEnum.CRIT_VALUE, 2066.609);
        UniqueItem adornment = SpellweaverUniqueItems.STINGER.getItem();
        adornment.setBaseStats(adornmentBaseStats);
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        Opal opal = new Opal(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0), new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0), new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
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
        mage.addItem(adornment, ItemSlotEnum.WEAPON_ADORNMENT);

        Map<AbsoluteStatTypeEnum, Double> twoHandBaseStats = new HashMap<>();
        twoHandBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 24570.982);
        twoHandBaseStats.put(AbsoluteStatTypeEnum.CRIT_VALUE, 3321.515);
        UniqueItem twoHand = SpellweaverUniqueItems.GRIMACE_OF_THE_THUNDER_BEAST.getItem();
        twoHand.setBaseStats(twoHandBaseStats);
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(twoHand, ItemSlotEnum.TWO_HAND_WEAPON);

        RuneTrinket runeTrinket1 = new RuneTrinket();
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        mage.addRuneTrinket(runeTrinket1, 1);

        RuneTrinket runeTrinket2 = new RuneTrinket();
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        mage.addRuneTrinket(runeTrinket2, 2);

        RuneTrinket runeTrinket3 = new RuneTrinket();
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        mage.addRuneTrinket(runeTrinket3, 3);

        RuneTrinket runeTrinket4 = new RuneTrinket();
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        mage.addRuneTrinket(runeTrinket4, 4);

        RuneTrinket runeTrinket5 = new RuneTrinket();
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.065));
        runeTrinket5.addRune(new SpecialRune("Rune of the Realm Changer", Map.of(), "Increases the Realm Changer talent by 5."));
        runeTrinket5.addRune(new SpecialRune("Rune of the Andermant Fever", Map.of(), "Increases the Andermant Fever talent by 5."));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Materi Blessing", OverallRelativeBuffTypeEnum.MATERI_FRAGMENT_DROP_BONUS, 0.3));
        runeTrinket5.addRune(new Rune("Rune of Materi Blessing", OverallRelativeBuffTypeEnum.MATERI_FRAGMENT_DROP_BONUS, 0.3));
        runeTrinket5.addRune(new SpecialRune("Rune of Rising Vigor", Map.of(OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.10, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.06), ""));
        mage.addRuneTrinket(runeTrinket5, 5);

        JewelTrinket jewelTrinket1 = new JewelTrinket();
        jewelTrinket1.addJewel(new Jewel("Jewel of Eternal Scorn", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.15, "..."));
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
        jewelTrinket2.addJewel(new Jewel("Jewel of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Ambidextrous Vigor", OverallRelativeBuffTypeEnum.TWO_HAND_DAMAGE, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Encouragement", "..."));
        jewelTrinket2.addJewel(new Jewel("Jewel of Contribution", "..."));
        mage.addJewelTrinket(jewelTrinket2, 2);

        JewelTrinket jewelTrinket3 = new JewelTrinket();
        jewelTrinket3.addJewel(new Jewel("Jewel of Lasting Health", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Converse", "..."));
        jewelTrinket3.addJewel(new Jewel("Fiery Flower Jewel", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Strenuousness", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.1));
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

        Pet mortisPet = new Pet("Mortis Doll", Map.of(OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.3, OverallRelativeBuffTypeEnum.MANA, 0.3, OverallRelativeBuffTypeEnum.DAMAGE, 0.3, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.1), "");
        mage.setPet(mortisPet);
        mage.setCollectorBagBuff(Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.33, OverallRelativeBuffTypeEnum.RESISTANCE, 0.15, OverallRelativeBuffTypeEnum.DAMAGE, 0.06, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.02));

        Tonic tonic = new Tonic("Tonic of Vigor", AbsoluteStatTypeEnum.DAMAGE, 10496.0);
        //mage.setTonic(tonic);
        Physic physic = new Physic("Advanced Physic of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.18);
        //mage.setPhysic(physic);


        return mage;
    }

    public static Character sinasBuildNewDragan3() {
        Character mage = new Character(CharacterClassEnum.SPELLWEAVER);

        Map<AbsoluteStatTypeEnum, Double> amuletBaseStats = new HashMap<>();
        UniqueItem amulet = SpellweaverUniqueItems.AMULET_OF_THE_KRAKEN.getItem();
        amulet.setBaseStats(amuletBaseStats);
        amulet.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44563));
        amulet.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44563));
        amulet.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44563));
        amulet.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44563));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 700.0));
        mage.addItem(amulet, ItemSlotEnum.AMULET);

        MythicItem cloak = SpellweaverMythicItem.ANCESTRAL_GLORY_CLOAK.getItem();
        cloak.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(cloak, ItemSlotEnum.CLOAK);

        Map<AbsoluteStatTypeEnum, Double> beltBaseStats = new HashMap<>();
        beltBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1630.885);
        beltBaseStats.put(AbsoluteStatTypeEnum.HEALTH_POINTS, 20072.654);
        beltBaseStats.put(AbsoluteStatTypeEnum.RESISTANCE, 1679.873);
        UniqueItem belt = SpellweaverUniqueItems.BELT_OF_ZEAL.getItem();
        belt.setBaseStats(beltBaseStats);
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(belt, ItemSlotEnum.BELT);

        MythicItem ring1 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring1.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring1.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring1.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring1.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        Opal opal = new Opal(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0), new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0), new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        ring1.addGem(opal);
        ring1.addGem(opal);
        ring1.addGem(opal);
        ring1.addGem(opal);
        ring1.addGem(opal);
        ring1.addGem(opal);
        ring1.addGem(opal);
        ring1.addGem(opal);
        ring1.addGem(opal);
        ring1.addGem(opal);
        mage.addItem(ring1, ItemSlotEnum.RING1);
        MythicItem ring2 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring2.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        mage.addItem(ring2, ItemSlotEnum.RING2);

        SetItem helmet = SpellweaverSetItems.HELMET_OF_THE_BLACK_KNIGHT.getItem();
        helmet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        helmet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        helmet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        helmet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        mage.addItem(helmet, ItemSlotEnum.HELMET);

        SetItem shoulders = SpellweaverSetItems.SHOULDERS_OF_THE_END.getItem();
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44757));
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        mage.addItem(shoulders, ItemSlotEnum.SHOULDERS);

        SetItem torso = SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_TORSO.getItem();
        torso.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        torso.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        torso.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        torso.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        mage.addItem(torso, ItemSlotEnum.TORSO);

        Map<AbsoluteStatTypeEnum, Double> glovesBaseStats = new HashMap<>();
        glovesBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1584.734);
        glovesBaseStats.put(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.052);
        glovesBaseStats.put(AbsoluteStatTypeEnum.ARMOR, 653.453);
        UniqueItem gloves = SpellweaverUniqueItems.REIGN_OF_TERROR.getItem();
        gloves.setBaseStats(glovesBaseStats);
        gloves.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        gloves.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        gloves.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        gloves.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(gloves, ItemSlotEnum.GLOVES);

        Map<AbsoluteStatTypeEnum, Double> bootsBaseStats = new HashMap<>();
        bootsBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1510.415);
        bootsBaseStats.put(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 1.113);
        bootsBaseStats.put(AbsoluteStatTypeEnum.CRIT_VALUE, 1168.091);
        SetItem boots = SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_BOOTS.getItem();
        boots.setBaseStats(bootsBaseStats);
        boots.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        boots.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        boots.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        boots.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        mage.addItem(boots, ItemSlotEnum.BOOTS);

        UniqueItem adornment = SpellweaverUniqueItems.SIGRISMARRS_ETERNAL_GRASP.getItem();
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(adornment, ItemSlotEnum.WEAPON_ADORNMENT);

        Map<AbsoluteStatTypeEnum, Double> twoHandBaseStats = new HashMap<>();
        twoHandBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 24570.982);
        twoHandBaseStats.put(AbsoluteStatTypeEnum.CRIT_VALUE, 3321.515);
        UniqueItem twoHand = SpellweaverUniqueItems.GRIMACE_OF_THE_THUNDER_BEAST.getItem();
        twoHand.setBaseStats(twoHandBaseStats);
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(twoHand, ItemSlotEnum.TWO_HAND_WEAPON);

        RuneTrinket runeTrinket1 = new RuneTrinket();
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        mage.addRuneTrinket(runeTrinket1, 1);

        RuneTrinket runeTrinket2 = new RuneTrinket();
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        mage.addRuneTrinket(runeTrinket2, 2);

        RuneTrinket runeTrinket3 = new RuneTrinket();
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        mage.addRuneTrinket(runeTrinket3, 3);

        RuneTrinket runeTrinket4 = new RuneTrinket();
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        mage.addRuneTrinket(runeTrinket4, 4);

        RuneTrinket runeTrinket5 = new RuneTrinket();
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.065));
        runeTrinket5.addRune(new SpecialRune("Rune of the Realm Changer", Map.of(), "Increases the Realm Changer talent by 5."));
        runeTrinket5.addRune(new SpecialRune("Rune of the Andermant Fever", Map.of(), "Increases the Andermant Fever talent by 5."));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Materi Blessing", OverallRelativeBuffTypeEnum.MATERI_FRAGMENT_DROP_BONUS, 0.3));
        runeTrinket5.addRune(new Rune("Rune of Materi Blessing", OverallRelativeBuffTypeEnum.MATERI_FRAGMENT_DROP_BONUS, 0.3));
        runeTrinket5.addRune(new SpecialRune("Rune of Rising Vigor", Map.of(OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.10, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.06), ""));
        mage.addRuneTrinket(runeTrinket5, 5);

        JewelTrinket jewelTrinket1 = new JewelTrinket();
        jewelTrinket1.addJewel(new Jewel("Jewel of Eternal Scorn", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.15, "..."));
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
        jewelTrinket2.addJewel(new Jewel("Jewel of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Ambidextrous Vigor", OverallRelativeBuffTypeEnum.TWO_HAND_DAMAGE, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Encouragement", "..."));
        jewelTrinket2.addJewel(new Jewel("Jewel of Contribution", "..."));
        mage.addJewelTrinket(jewelTrinket2, 2);

        JewelTrinket jewelTrinket3 = new JewelTrinket();
        jewelTrinket3.addJewel(new Jewel("Jewel of Lasting Health", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Converse", "..."));
        jewelTrinket3.addJewel(new Jewel("Fiery Flower Jewel", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Strenuousness", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.1));
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

        Pet mortisPet = new Pet("Mortis Doll", Map.of(OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.3, OverallRelativeBuffTypeEnum.MANA, 0.3, OverallRelativeBuffTypeEnum.DAMAGE, 0.3, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.1), "");
        mage.setPet(mortisPet);
        mage.setCollectorBagBuff(Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.33, OverallRelativeBuffTypeEnum.RESISTANCE, 0.15, OverallRelativeBuffTypeEnum.DAMAGE, 0.06, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.02));

        Tonic tonic = new Tonic("Tonic of Vigor", AbsoluteStatTypeEnum.DAMAGE, 10496.0);
        //mage.setTonic(tonic);
        Physic physic = new Physic("Advanced Physic of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.18);
        //mage.setPhysic(physic);


        return mage;
    }

    public static Character sinasBuildNewDragan4() {
        Character mage = new Character(CharacterClassEnum.SPELLWEAVER);

        Map<AbsoluteStatTypeEnum, Double> amuletBaseStats = new HashMap<>();
        amuletBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1495.899);
        amuletBaseStats.put(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.460);
        amuletBaseStats.put(AbsoluteStatTypeEnum.HEALTH_POINTS, 23093.384);
        UniqueItem amulet = SpellweaverUniqueItems.SARGONS_SHADOW_AMULET.getItem();
        amulet.setBaseStats(amuletBaseStats);
        amulet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        amulet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        amulet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        amulet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(amulet, ItemSlotEnum.AMULET);

        MythicItem cloak = SpellweaverMythicItem.ANCESTRAL_GLORY_CLOAK.getItem();
        cloak.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        Opal opal = new Opal(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0), new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0), new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        cloak.addGem(opal);
        cloak.addGem(opal);
        cloak.addGem(opal);
        cloak.addGem(opal);
        cloak.addGem(opal);
        cloak.addGem(opal);
        cloak.addGem(opal);
        cloak.addGem(opal);
        cloak.addGem(opal);
        cloak.addGem(opal);
        mage.addItem(cloak, ItemSlotEnum.CLOAK);

        Map<AbsoluteStatTypeEnum, Double> beltBaseStats = new HashMap<>();
        beltBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1630.885);
        beltBaseStats.put(AbsoluteStatTypeEnum.HEALTH_POINTS, 20072.654);
        beltBaseStats.put(AbsoluteStatTypeEnum.RESISTANCE, 1679.873);
        UniqueItem belt = SpellweaverUniqueItems.BELT_OF_ZEAL.getItem();
        belt.setBaseStats(beltBaseStats);
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(belt, ItemSlotEnum.BELT);

        MythicItem ring1 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring1.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        ring1.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        ring1.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        ring1.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        mage.addItem(ring1, ItemSlotEnum.RING1);
        MythicItem ring2 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring2.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        mage.addItem(ring2, ItemSlotEnum.RING2);

        SetItem helmet = SpellweaverSetItems.HELMET_OF_THE_BLACK_KNIGHT.getItem();
        helmet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        helmet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        helmet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        helmet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        mage.addItem(helmet, ItemSlotEnum.HELMET);

        SetItem shoulders = SpellweaverSetItems.SHOULDERS_OF_THE_END.getItem();
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44757));
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        mage.addItem(shoulders, ItemSlotEnum.SHOULDERS);

        SetItem torso = SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_TORSO.getItem();
        torso.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        torso.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        torso.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        torso.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        mage.addItem(torso, ItemSlotEnum.TORSO);

        Map<AbsoluteStatTypeEnum, Double> glovesBaseStats = new HashMap<>();
        glovesBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1584.734);
        glovesBaseStats.put(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.052);
        glovesBaseStats.put(AbsoluteStatTypeEnum.ARMOR, 653.453);
        UniqueItem gloves = SpellweaverUniqueItems.REIGN_OF_TERROR.getItem();
        gloves.setBaseStats(glovesBaseStats);
        gloves.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        gloves.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        gloves.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        gloves.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(gloves, ItemSlotEnum.GLOVES);

        Map<AbsoluteStatTypeEnum, Double> bootsBaseStats = new HashMap<>();
        bootsBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1510.415);
        bootsBaseStats.put(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 1.113);
        bootsBaseStats.put(AbsoluteStatTypeEnum.CRIT_VALUE, 1168.091);
        SetItem boots = SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_BOOTS.getItem();
        boots.setBaseStats(bootsBaseStats);
        boots.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        boots.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        boots.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        boots.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        mage.addItem(boots, ItemSlotEnum.BOOTS);

        Map<AbsoluteStatTypeEnum, Double> adornmentBaseStats = new HashMap<>();
        adornmentBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1876.970);
        adornmentBaseStats.put(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.047);
        adornmentBaseStats.put(AbsoluteStatTypeEnum.CRIT_VALUE, 2066.609);
        UniqueItem adornment = SpellweaverUniqueItems.STINGER.getItem();
        adornment.setBaseStats(adornmentBaseStats);
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(adornment, ItemSlotEnum.WEAPON_ADORNMENT);

        Map<AbsoluteStatTypeEnum, Double> twoHandBaseStats = new HashMap<>();
        twoHandBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 24570.982);
        twoHandBaseStats.put(AbsoluteStatTypeEnum.CRIT_VALUE, 3321.515);
        UniqueItem twoHand = SpellweaverUniqueItems.GRIMACE_OF_THE_THUNDER_BEAST.getItem();
        twoHand.setBaseStats(twoHandBaseStats);
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(twoHand, ItemSlotEnum.TWO_HAND_WEAPON);

        RuneTrinket runeTrinket1 = new RuneTrinket();
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        mage.addRuneTrinket(runeTrinket1, 1);

        RuneTrinket runeTrinket2 = new RuneTrinket();
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        mage.addRuneTrinket(runeTrinket2, 2);

        RuneTrinket runeTrinket3 = new RuneTrinket();
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        mage.addRuneTrinket(runeTrinket3, 3);

        RuneTrinket runeTrinket4 = new RuneTrinket();
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        mage.addRuneTrinket(runeTrinket4, 4);

        RuneTrinket runeTrinket5 = new RuneTrinket();
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.065));
        runeTrinket5.addRune(new SpecialRune("Rune of the Realm Changer", Map.of(), "Increases the Realm Changer talent by 5."));
        runeTrinket5.addRune(new SpecialRune("Rune of the Andermant Fever", Map.of(), "Increases the Andermant Fever talent by 5."));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Materi Blessing", OverallRelativeBuffTypeEnum.MATERI_FRAGMENT_DROP_BONUS, 0.3));
        runeTrinket5.addRune(new Rune("Rune of Materi Blessing", OverallRelativeBuffTypeEnum.MATERI_FRAGMENT_DROP_BONUS, 0.3));
        runeTrinket5.addRune(new SpecialRune("Rune of Rising Vigor", Map.of(OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.10, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.06), ""));
        mage.addRuneTrinket(runeTrinket5, 5);

        JewelTrinket jewelTrinket1 = new JewelTrinket();
        jewelTrinket1.addJewel(new Jewel("Jewel of Eternal Scorn", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.15, "..."));
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
        jewelTrinket2.addJewel(new Jewel("Jewel of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Ambidextrous Vigor", OverallRelativeBuffTypeEnum.TWO_HAND_DAMAGE, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Encouragement", "..."));
        jewelTrinket2.addJewel(new Jewel("Jewel of Contribution", "..."));
        mage.addJewelTrinket(jewelTrinket2, 2);

        JewelTrinket jewelTrinket3 = new JewelTrinket();
        jewelTrinket3.addJewel(new Jewel("Jewel of Lasting Health", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Converse", "..."));
        jewelTrinket3.addJewel(new Jewel("Fiery Flower Jewel", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Strenuousness", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.1));
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

        Pet mortisPet = new Pet("Mortis Doll", Map.of(OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.3, OverallRelativeBuffTypeEnum.MANA, 0.3, OverallRelativeBuffTypeEnum.DAMAGE, 0.3, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.1), "");
        mage.setPet(mortisPet);
        mage.setCollectorBagBuff(Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.33, OverallRelativeBuffTypeEnum.RESISTANCE, 0.15, OverallRelativeBuffTypeEnum.DAMAGE, 0.06, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.02));

        Tonic tonic = new Tonic("Tonic of Vigor", AbsoluteStatTypeEnum.DAMAGE, 10496.0);
        //mage.setTonic(tonic);
        Physic physic = new Physic("Advanced Physic of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.18);
        //mage.setPhysic(physic);


        return mage;
    }


    public static Character bghMortis() {
        Character mage = new Character(CharacterClassEnum.SPELLWEAVER);

        SetItem amulet = SpellweaverSetItems.AMULET_OF_DEATH.getItem();
        amulet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        amulet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        amulet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        amulet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(amulet, ItemSlotEnum.AMULET);

        MythicItem cloak = SpellweaverMythicItem.ANCESTRAL_GLORY_CLOAK.getItem();
        cloak.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(cloak, ItemSlotEnum.CLOAK);

        UniqueItem belt = SpellweaverUniqueItems.BELT_OF_ZEAL.getItem();
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(belt, ItemSlotEnum.BELT);

        MythicItem ring1 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring1.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        ring1.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        ring1.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        ring1.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        mage.addItem(ring1, ItemSlotEnum.RING1);
        MythicItem ring2 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring2.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        Opal opal = new Opal(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0), new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0), new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        ring2.addGem(opal);
        ring2.addGem(opal);
        ring2.addGem(opal);
        ring2.addGem(opal);
        ring2.addGem(opal);
        ring2.addGem(opal);
        ring2.addGem(opal);
        ring2.addGem(opal);
        ring2.addGem(opal);
        ring2.addGem(opal);
        mage.addItem(ring2, ItemSlotEnum.RING2);

        SetItem helmet = SpellweaverSetItems.CAP_OF_DEATH.getItem();
        helmet.addEnchant(new Enchant(EnchantTypeEnum.CRIT_VALUE, 0.24563));
        helmet.addEnchant(new Enchant(EnchantTypeEnum.CRIT_VALUE, 0.24563));
        helmet.addEnchant(new Enchant(EnchantTypeEnum.CRIT_VALUE, 0.24563));
        helmet.addEnchant(new Enchant(EnchantTypeEnum.CRIT_VALUE, 0.24563));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        mage.addItem(helmet, ItemSlotEnum.HELMET);

        SetItem shoulders = SpellweaverSetItems.SHOULDERS_OF_THE_BLACK_KNIGHT.getItem();
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        mage.addItem(shoulders, ItemSlotEnum.SHOULDERS);

        UniqueItem torso = SpellweaverUniqueItems.RESEARCHERS_COAT.getItem();
        torso.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        torso.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        torso.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        torso.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        mage.addItem(torso, ItemSlotEnum.TORSO);

        SetItem gloves = SpellweaverSetItems.GLOVES_OF_THE_FLAME_CONQUEROR.getItem();
        gloves.addEnchant(new Enchant(EnchantTypeEnum.ATTACK_SPEED, 0.47112));
        gloves.addEnchant(new Enchant(EnchantTypeEnum.ATTACK_SPEED, 0.47112));
        gloves.addEnchant(new Enchant(EnchantTypeEnum.ATTACK_SPEED, 0.47112));
        gloves.addEnchant(new Enchant(EnchantTypeEnum.ATTACK_SPEED, 0.47112));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.017));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.017));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.017));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.017));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.017));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.017));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.017));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.017));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.017));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.017));
        mage.addItem(gloves, ItemSlotEnum.GLOVES);

        UniqueItem  boots = SpellweaverUniqueItems.RESEARCHERS_BOOTS.getItem();
        boots.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        boots.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        boots.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        boots.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        mage.addItem(boots, ItemSlotEnum.BOOTS);

        UniqueItem adornment = SpellweaverUniqueItems.STINGER.getItem();
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(adornment, ItemSlotEnum.WEAPON_ADORNMENT);

        UniqueItem twoHand = SpellweaverUniqueItems.GRIMACE_OF_THE_THUNDER_BEAST.getItem();
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(twoHand, ItemSlotEnum.TWO_HAND_WEAPON);

        RuneTrinket runeTrinket1 = new RuneTrinket();
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        mage.addRuneTrinket(runeTrinket1, 1);

        RuneTrinket runeTrinket2 = new RuneTrinket();
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        mage.addRuneTrinket(runeTrinket2, 2);

        RuneTrinket runeTrinket3 = new RuneTrinket();
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        mage.addRuneTrinket(runeTrinket3, 3);

        RuneTrinket runeTrinket4 = new RuneTrinket();
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        mage.addRuneTrinket(runeTrinket4, 4);

        RuneTrinket runeTrinket5 = new RuneTrinket();
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.065));
        runeTrinket5.addRune(new SpecialRune("Rune of the Realm Changer", Map.of(), "Increases the Realm Changer talent by 5."));
        runeTrinket5.addRune(new SpecialRune("Rune of the Andermant Fever", Map.of(), "Increases the Andermant Fever talent by 5."));
        runeTrinket5.addRune(new SpecialRune("Rune of Rising Vigor", Map.of(OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.10, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.06), ""));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Materi Blessing", OverallRelativeBuffTypeEnum.MATERI_FRAGMENT_DROP_BONUS, 0.3));
        runeTrinket5.addRune(new Rune("Rune of Materi Blessing", OverallRelativeBuffTypeEnum.MATERI_FRAGMENT_DROP_BONUS, 0.3));
        runeTrinket5.addRune(new Rune("Rune of Materi Blessing", OverallRelativeBuffTypeEnum.MATERI_FRAGMENT_DROP_BONUS, 0.3));
        mage.addRuneTrinket(runeTrinket5, 5);

        JewelTrinket jewelTrinket1 = new JewelTrinket();
        jewelTrinket1.addJewel(new Jewel("Jewel of Eternal Scorn", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.15, "..."));
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
        jewelTrinket2.addJewel(new Jewel("Jewel of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Ambidextrous Vigor", OverallRelativeBuffTypeEnum.TWO_HAND_DAMAGE, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Encouragement", "..."));
        jewelTrinket2.addJewel(new Jewel("Jewel of Contribution", "..."));
        mage.addJewelTrinket(jewelTrinket2, 2);

        JewelTrinket jewelTrinket3 = new JewelTrinket();
        jewelTrinket3.addJewel(new Jewel("Jewel of Lasting Health", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Converse", "..."));
        jewelTrinket3.addJewel(new Jewel("Fiery Flower Jewel", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Strenuousness", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.1));
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

        Pet mortisPet = new Pet("Paul", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.505, OverallRelativeBuffTypeEnum.ARMOR, 0.18), "");
        mage.setPet(mortisPet);
        mage.setCollectorBagBuff(Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.33, OverallRelativeBuffTypeEnum.RESISTANCE, 0.15, OverallRelativeBuffTypeEnum.DAMAGE, 0.06, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.02));

        Tonic tonic = new Tonic("Tonic of Vigor", AbsoluteStatTypeEnum.HEALTH_POINTS, 156068.0);
        mage.setTonic(tonic);
        Physic physic = new Physic("Advanced Physic of Vigor", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.18);
        mage.setPhysic(physic);


        return mage;
    }

    public static Character bghMaxDmgMageMortis() {
        Character mage = new Character(CharacterClassEnum.SPELLWEAVER);

        SetItem amulet = SpellweaverSetItems.AMULET_OF_DEATH.getItem();
        amulet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        amulet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        amulet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        amulet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(amulet, ItemSlotEnum.AMULET);

        MythicItem cloak = SpellweaverMythicItem.ANCESTRAL_GLORY_CLOAK.getItem();
        cloak.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        mage.addItem(cloak, ItemSlotEnum.CLOAK);

        UniqueItem belt = SpellweaverUniqueItems.BELT_OF_ZEAL.getItem();
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(belt, ItemSlotEnum.BELT);

        MythicItem ring1 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring1.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring1.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring1.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring1.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        mage.addItem(ring1, ItemSlotEnum.RING1);
        MythicItem ring2 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring2.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        Opal opal = new Opal(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0), new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0), new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        ring2.addGem(opal);
        ring2.addGem(opal);
        ring2.addGem(opal);
        ring2.addGem(opal);
        ring2.addGem(opal);
        ring2.addGem(opal);
        ring2.addGem(opal);
        ring2.addGem(opal);
        ring2.addGem(opal);
        ring2.addGem(opal);
        mage.addItem(ring2, ItemSlotEnum.RING2);

        SetItem helmet = SpellweaverSetItems.CAP_OF_DEATH.getItem();
        helmet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        helmet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        helmet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        helmet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        mage.addItem(helmet, ItemSlotEnum.HELMET);

        UniqueItem shoulders = SpellweaverUniqueItems.KHALYS_DARK_SCHEME.getItem();
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        mage.addItem(shoulders, ItemSlotEnum.SHOULDERS);

        SetItem torso = SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_TORSO.getItem();
        torso.addEnchant(new Enchant(EnchantTypeEnum.ARMOR, 0.44776));
        torso.addEnchant(new Enchant(EnchantTypeEnum.ARMOR, 0.44776));
        torso.addEnchant(new Enchant(EnchantTypeEnum.ARMOR, 0.44776));
        torso.addEnchant(new Enchant(EnchantTypeEnum.ARMOR, 0.44776));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        mage.addItem(torso, ItemSlotEnum.TORSO);

        UniqueItem gloves = SpellweaverUniqueItems.REIGN_OF_TERROR.getItem();
        gloves.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        gloves.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        gloves.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        gloves.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(gloves, ItemSlotEnum.GLOVES);

        SetItem  boots = SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_BOOTS.getItem();
        boots.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        boots.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        boots.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        boots.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        mage.addItem(boots, ItemSlotEnum.BOOTS);

        UniqueItem adornment = SpellweaverUniqueItems.STINGER.getItem();
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(adornment, ItemSlotEnum.WEAPON_ADORNMENT);

        UniqueItem twoHand = SpellweaverUniqueItems.GRIMACE_OF_THE_THUNDER_BEAST.getItem();
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(twoHand, ItemSlotEnum.TWO_HAND_WEAPON);

        RuneTrinket runeTrinket1 = new RuneTrinket();
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        mage.addRuneTrinket(runeTrinket1, 1);

        RuneTrinket runeTrinket2 = new RuneTrinket();
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        mage.addRuneTrinket(runeTrinket2, 2);

        RuneTrinket runeTrinket3 = new RuneTrinket();
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        mage.addRuneTrinket(runeTrinket3, 3);

        RuneTrinket runeTrinket4 = new RuneTrinket();
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        mage.addRuneTrinket(runeTrinket4, 4);

        RuneTrinket runeTrinket5 = new RuneTrinket();
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.065));
        runeTrinket5.addRune(new SpecialRune("Rune of the Realm Changer", Map.of(), "Increases the Realm Changer talent by 5."));
        runeTrinket5.addRune(new SpecialRune("Rune of the Andermant Fever", Map.of(), "Increases the Andermant Fever talent by 5."));
        runeTrinket5.addRune(new SpecialRune("Rune of Rising Vigor", Map.of(OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.10, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.06), ""));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Materi Blessing", OverallRelativeBuffTypeEnum.MATERI_FRAGMENT_DROP_BONUS, 0.3));
        runeTrinket5.addRune(new Rune("Rune of Materi Blessing", OverallRelativeBuffTypeEnum.MATERI_FRAGMENT_DROP_BONUS, 0.3));
        runeTrinket5.addRune(new Rune("Rune of Materi Blessing", OverallRelativeBuffTypeEnum.MATERI_FRAGMENT_DROP_BONUS, 0.3));
        mage.addRuneTrinket(runeTrinket5, 5);

        JewelTrinket jewelTrinket1 = new JewelTrinket();
        jewelTrinket1.addJewel(new Jewel("Jewel of Eternal Scorn", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.15, "..."));
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
        jewelTrinket2.addJewel(new Jewel("Jewel of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Ambidextrous Vigor", OverallRelativeBuffTypeEnum.TWO_HAND_DAMAGE, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Encouragement", "..."));
        jewelTrinket2.addJewel(new Jewel("Jewel of Contribution", "..."));
        mage.addJewelTrinket(jewelTrinket2, 2);

        JewelTrinket jewelTrinket3 = new JewelTrinket();
        jewelTrinket3.addJewel(new Jewel("Jewel of Lasting Health", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Converse", "..."));
        jewelTrinket3.addJewel(new Jewel("Fiery Flower Jewel", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Strenuousness", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.1));
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

        mage.setEssence(0.00);

        Pet mortisPet = new Pet("Mortis Doll", Map.of(OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.3, OverallRelativeBuffTypeEnum.MANA, 0.3, OverallRelativeBuffTypeEnum.DAMAGE, 0.3), "");
        mage.setPet(mortisPet);
        mage.setCollectorBagBuff(Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.33, OverallRelativeBuffTypeEnum.RESISTANCE, 0.15, OverallRelativeBuffTypeEnum.DAMAGE, 0.06, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.02));

        Tonic tonic = new Tonic("Tonic of Vigor", AbsoluteStatTypeEnum.DAMAGE, 10496.0);
        mage.setTonic(tonic);
        Physic physic = new Physic("Advanced Physic of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.18);
        mage.setPhysic(physic);


        return mage;
    }

    public static Character draganMage() {
        Character mage = new Character(CharacterClassEnum.SPELLWEAVER);

        Map<AbsoluteStatTypeEnum, Double> amuletBaseStats = new HashMap<>();
        amuletBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1495.899);
        amuletBaseStats.put(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.460);
        amuletBaseStats.put(AbsoluteStatTypeEnum.HEALTH_POINTS, 23093.384);
        UniqueItem amulet = SpellweaverUniqueItems.SARGONS_SHADOW_AMULET.getItem();
        amulet.setBaseStats(amuletBaseStats);
        amulet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44743));
        amulet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44749));
        amulet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44734));
        amulet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44746));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(amulet, ItemSlotEnum.AMULET);

        SetItem cloak = SpellweaverSetItems.CLOAK_OF_THE_BLACK_KNIGHT.getItem();
        cloak.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44750));
        cloak.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44750));
        cloak.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44750));
        cloak.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44750));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        mage.addItem(cloak, ItemSlotEnum.CLOAK);

        Map<AbsoluteStatTypeEnum, Double> beltBaseStats = new HashMap<>();
        beltBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1630.885);
        beltBaseStats.put(AbsoluteStatTypeEnum.HEALTH_POINTS, 20072.654);
        beltBaseStats.put(AbsoluteStatTypeEnum.RESISTANCE, 1679.873);
        UniqueItem belt = SpellweaverUniqueItems.BELT_OF_ZEAL.getItem();
        belt.setBaseStats(beltBaseStats);
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(belt, ItemSlotEnum.BELT);

        MythicItem ring1 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring1.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring1.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring1.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring1.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        Opal opal = new Opal(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0), new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0), new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        ring1.addGem(opal);
        ring1.addGem(opal);
        ring1.addGem(opal);
        ring1.addGem(opal);
        ring1.addGem(opal);
        ring1.addGem(opal);
        ring1.addGem(opal);
        ring1.addGem(opal);
        ring1.addGem(opal);
        ring1.addGem(opal);
        mage.addItem(ring1, ItemSlotEnum.RING1);
        MythicItem ring2 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring2.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(ring2, ItemSlotEnum.RING2);

        SetItem helmet = SpellweaverSetItems.HELMET_OF_THE_BLACK_KNIGHT.getItem();
        helmet.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44750));
        helmet.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44750));
        helmet.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44750));
        helmet.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44750));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        mage.addItem(helmet, ItemSlotEnum.HELMET);

        SetItem shoulders = SpellweaverSetItems.SHOULDERS_OF_THE_BLACK_KNIGHT.getItem();
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        mage.addItem(shoulders, ItemSlotEnum.SHOULDERS);

        Map<AbsoluteStatTypeEnum, Double> torsoBaseStats = new HashMap<>();
        torsoBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1566.12);
        torsoBaseStats.put(AbsoluteStatTypeEnum.HEALTH_POINTS, 15903.888);
        torsoBaseStats.put(AbsoluteStatTypeEnum.ARMOR, 1484.796);
        UniqueItem torso = SpellweaverUniqueItems.SIGRISMARRS_ETERNAL_WARD.getItem();
        torso.setBaseStats(torsoBaseStats);
        torso.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44750));
        torso.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44750));
        torso.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44750));
        torso.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44750));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        mage.addItem(torso, ItemSlotEnum.TORSO);

        Map<AbsoluteStatTypeEnum, Double> glovesBaseStats = new HashMap<>();
        glovesBaseStats.put(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.052);
        glovesBaseStats.put(AbsoluteStatTypeEnum.CRIT_VALUE, 1752.39);
        glovesBaseStats.put(AbsoluteStatTypeEnum.LIGHTNING_RESISTANCE, 3587.036);
        UniqueItem gloves = SpellweaverUniqueItems.ABYSSAL_TREASURE_GLOVES.getItem();
        gloves.setBaseStats(glovesBaseStats);
        gloves.addEnchant(new Enchant(EnchantTypeEnum.ATTACK_SPEED, 0.44776));
        gloves.addEnchant(new Enchant(EnchantTypeEnum.ATTACK_SPEED, 0.44776));
        gloves.addEnchant(new Enchant(EnchantTypeEnum.ATTACK_SPEED, 0.44776));
        gloves.addEnchant(new Enchant(EnchantTypeEnum.ATTACK_SPEED, 0.44776));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.017));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.017));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.017));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.017));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.017));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.017));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.017));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        mage.addItem(gloves, ItemSlotEnum.GLOVES);

        Map<AbsoluteStatTypeEnum, Double> bootsBaseStats = new HashMap<>();
        bootsBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1572.484);
        bootsBaseStats.put(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 1.180);
        bootsBaseStats.put(AbsoluteStatTypeEnum.CRIT_VALUE, 1265.479);
        UniqueItem boots = SpellweaverUniqueItems.RESEARCHERS_BOOTS.getItem();
        boots.setBaseStats(bootsBaseStats);
        boots.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44750));
        boots.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44750));
        boots.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44759));
        boots.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44759));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        mage.addItem(boots, ItemSlotEnum.BOOTS);

        Map<AbsoluteStatTypeEnum, Double> adornmentBaseStats = new HashMap<>();
        adornmentBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1885.747);
        adornmentBaseStats.put(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.039);
        adornmentBaseStats.put(AbsoluteStatTypeEnum.CRIT_VALUE, 1855.476);
        UniqueItem adornment = SpellweaverUniqueItems.STINGER.getItem();
        adornment.setBaseStats(adornmentBaseStats);
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44771));
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44767));
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44775));
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44772));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(adornment, ItemSlotEnum.WEAPON_ADORNMENT);

        Map<AbsoluteStatTypeEnum, Double> twoHandBaseStats = new HashMap<>();
        twoHandBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 24570.982);
        twoHandBaseStats.put(AbsoluteStatTypeEnum.CRIT_VALUE, 3321.515);
        Map<AbsoluteStatTypeEnum, Double> twoHandUniqueBaseStats = new HashMap<>();
        twoHandUniqueBaseStats.put(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.102);
        UniqueItem twoHand = SpellweaverUniqueItems.GRIMACE_OF_THE_THUNDER_BEAST.getItem();
        twoHand.setBaseStats(twoHandBaseStats);
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(twoHand, ItemSlotEnum.TWO_HAND_WEAPON);

        RuneTrinket runeTrinket1 = new RuneTrinket();
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        mage.addRuneTrinket(runeTrinket1, 1);

        RuneTrinket runeTrinket2 = new RuneTrinket();
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new Rune("Rune of Resilience", OverallRelativeBuffTypeEnum.RESISTANCE, 0.065));
        runeTrinket2.addRune(new SpecialRune("Rune of Rising Vigor", Map.of(OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.10, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.06), ""));
        mage.addRuneTrinket(runeTrinket2, 2);

        RuneTrinket runeTrinket3 = new RuneTrinket();
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        mage.addRuneTrinket(runeTrinket3, 3);

        RuneTrinket runeTrinket4 = new RuneTrinket();
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        mage.addRuneTrinket(runeTrinket4, 4);

        RuneTrinket runeTrinket5 = new RuneTrinket();
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.065));
        runeTrinket5.addRune(new SpecialRune("Rune of the Realm Changer", Map.of(), "Increases the Realm Changer talent by 5."));
        runeTrinket5.addRune(new SpecialRune("Rune of the Andermant Fever", Map.of(), "Increases the Andermant Fever talent by 5."));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Materi Blessing", OverallRelativeBuffTypeEnum.MATERI_FRAGMENT_DROP_BONUS, 0.3));
        runeTrinket5.addRune(new Rune("Rune of Materi Blessing", OverallRelativeBuffTypeEnum.MATERI_FRAGMENT_DROP_BONUS, 0.3));
        runeTrinket5.addRune(new Rune("Rune of Materi Blessing", OverallRelativeBuffTypeEnum.MATERI_FRAGMENT_DROP_BONUS, 0.3));
        mage.addRuneTrinket(runeTrinket5, 5);

        JewelTrinket jewelTrinket1 = new JewelTrinket();
        jewelTrinket1.addJewel(new Jewel("Jewel of Eternal Scorn", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.15, "..."));
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
        jewelTrinket2.addJewel(new Jewel("Jewel of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Ambidextrous Vigor", OverallRelativeBuffTypeEnum.TWO_HAND_DAMAGE, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Encouragement", "..."));
        jewelTrinket2.addJewel(new Jewel("Jewel of Contribution", "..."));
        mage.addJewelTrinket(jewelTrinket2, 2);

        JewelTrinket jewelTrinket3 = new JewelTrinket();
        jewelTrinket3.addJewel(new Jewel("Jewel of Lasting Health", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Converse", "..."));
        jewelTrinket3.addJewel(new Jewel("Fiery Flower Jewel", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Strenuousness", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.1));
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

        mage.setEssence(0.50);

        Pet mortisPet = new Pet("Mortis Doll", Map.of(OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.3, OverallRelativeBuffTypeEnum.MANA, 0.3, OverallRelativeBuffTypeEnum.DAMAGE, 0.3), "");
        mage.setPet(mortisPet);
        mage.setCollectorBagBuff(Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.33, OverallRelativeBuffTypeEnum.RESISTANCE, 0.15, OverallRelativeBuffTypeEnum.DAMAGE, 0.06, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.02));

        Tonic tonic = new Tonic("Tonic of Vigor", AbsoluteStatTypeEnum.DAMAGE, 10496.0);
        //mage.setTonic(tonic);
        Physic physic = new Physic("Advanced Physic of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.18);
        //mage.setPhysic(physic);


        return mage;
    }

    public static Character bghMaxDmgMage() {
        Character mage = new Character(CharacterClassEnum.SPELLWEAVER);

        UniqueItem amulet = SpellweaverUniqueItems.SARGONS_SHADOW_AMULET.getItem();
        amulet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        amulet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        amulet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        amulet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(amulet, ItemSlotEnum.AMULET);

        MythicItem cloak = SpellweaverMythicItem.ANCESTRAL_GLORY_CLOAK.getItem();
        cloak.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(cloak, ItemSlotEnum.CLOAK);

        UniqueItem belt = SpellweaverUniqueItems.BELT_OF_ZEAL.getItem();
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(belt, ItemSlotEnum.BELT);

        MythicItem ring1 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring1.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring1.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring1.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring1.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        mage.addItem(ring1, ItemSlotEnum.RING1);
        MythicItem ring2 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring2.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        Opal opal = new Opal(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0), new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0), new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        ring2.addGem(opal);
        ring2.addGem(opal);
        ring2.addGem(opal);
        ring2.addGem(opal);
        ring2.addGem(opal);
        ring2.addGem(opal);
        ring2.addGem(opal);
        ring2.addGem(opal);
        ring2.addGem(opal);
        ring2.addGem(opal);
        mage.addItem(ring2, ItemSlotEnum.RING2);

        SetItem helmet = SpellweaverSetItems.SARGONS_HORNS.getItem();
        helmet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        helmet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        helmet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        helmet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        mage.addItem(helmet, ItemSlotEnum.HELMET);

        SetItem shoulders = SpellweaverSetItems.SARGONS_PAULDRONS.getItem();
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        mage.addItem(shoulders, ItemSlotEnum.SHOULDERS);

        Map<AbsoluteStatTypeEnum, Double> torsoBaseStats = new HashMap<>();
        torsoBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1631.657);
        torsoBaseStats.put(AbsoluteStatTypeEnum.HEALTH_POINTS, 14232.794);
        torsoBaseStats.put(AbsoluteStatTypeEnum.ARMOR, 1639.716);
        SetItem torso = SpellweaverSetItems.SARGONS_TORSO.getItem();
        torso.setBaseStats(torsoBaseStats);
        torso.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        torso.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        torso.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        torso.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        mage.addItem(torso, ItemSlotEnum.TORSO);

        SetItem gloves = SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_GLOVES.getItem();
        gloves.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        gloves.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        gloves.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        gloves.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        mage.addItem(gloves, ItemSlotEnum.GLOVES);

        SetItem boots = SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_BOOTS.getItem();
        boots.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        boots.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        boots.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        boots.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        mage.addItem(boots, ItemSlotEnum.BOOTS);

        UniqueItem adornment = SpellweaverUniqueItems.STINGER.getItem();
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(adornment, ItemSlotEnum.WEAPON_ADORNMENT);

        UniqueItem twoHand = SpellweaverUniqueItems.GRIMACE_OF_THE_THUNDER_BEAST.getItem();
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(twoHand, ItemSlotEnum.TWO_HAND_WEAPON);

        RuneTrinket runeTrinket1 = new RuneTrinket();
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        mage.addRuneTrinket(runeTrinket1, 1);

        RuneTrinket runeTrinket2 = new RuneTrinket();
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        mage.addRuneTrinket(runeTrinket2, 2);

        RuneTrinket runeTrinket3 = new RuneTrinket();
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        mage.addRuneTrinket(runeTrinket3, 3);

        RuneTrinket runeTrinket4 = new RuneTrinket();
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        mage.addRuneTrinket(runeTrinket4, 4);

        RuneTrinket runeTrinket5 = new RuneTrinket();
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.065));
        runeTrinket5.addRune(new SpecialRune("Rune of the Realm Changer", Map.of(), "Increases the Realm Changer talent by 5."));
        runeTrinket5.addRune(new SpecialRune("Rune of the Andermant Fever", Map.of(), "Increases the Andermant Fever talent by 5."));
        runeTrinket5.addRune(new SpecialRune("Rune of Rising Vigor", Map.of(OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.10, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.06), ""));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Materi Blessing", OverallRelativeBuffTypeEnum.MATERI_FRAGMENT_DROP_BONUS, 0.3));
        runeTrinket5.addRune(new Rune("Rune of Materi Blessing", OverallRelativeBuffTypeEnum.MATERI_FRAGMENT_DROP_BONUS, 0.3));
        runeTrinket5.addRune(new Rune("Rune of Materi Blessing", OverallRelativeBuffTypeEnum.MATERI_FRAGMENT_DROP_BONUS, 0.3));
        mage.addRuneTrinket(runeTrinket5, 5);

        JewelTrinket jewelTrinket1 = new JewelTrinket();
        jewelTrinket1.addJewel(new Jewel("Jewel of Eternal Scorn", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.15, "..."));
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
        jewelTrinket2.addJewel(new Jewel("Jewel of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Ambidextrous Vigor", OverallRelativeBuffTypeEnum.TWO_HAND_DAMAGE, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Encouragement", "..."));
        jewelTrinket2.addJewel(new Jewel("Jewel of Contribution", "..."));
        mage.addJewelTrinket(jewelTrinket2, 2);

        JewelTrinket jewelTrinket3 = new JewelTrinket();
        jewelTrinket3.addJewel(new Jewel("Jewel of Lasting Health", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Converse", "..."));
        jewelTrinket3.addJewel(new Jewel("Fiery Flower Jewel", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Strenuousness", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.1));
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

        mage.setEssence(0.50);

        Pet mortisPet = new Pet("Mortis Doll", Map.of(OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.3, OverallRelativeBuffTypeEnum.MANA, 0.3, OverallRelativeBuffTypeEnum.DAMAGE, 0.3), "");
        mage.setPet(mortisPet);
        mage.setCollectorBagBuff(Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.33, OverallRelativeBuffTypeEnum.RESISTANCE, 0.15, OverallRelativeBuffTypeEnum.DAMAGE, 0.06, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.02));

        Tonic tonic = new Tonic("Tonic of Vigor", AbsoluteStatTypeEnum.DAMAGE, 10496.0);
        //mage.setTonic(tonic);
        Physic physic = new Physic("Advanced Physic of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.18);
        //mage.setPhysic(physic);


        return mage;
    }

    public static Character bghMaxDmgMage2() {
        Character mage = new Character(CharacterClassEnum.SPELLWEAVER);

        UniqueItem amulet = SpellweaverUniqueItems.AMULET_OF_THE_KRAKEN.getItem();
        amulet.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44776));
        amulet.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44776));
        amulet.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44776));
        amulet.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44776));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        mage.addItem(amulet, ItemSlotEnum.AMULET);

        MythicItem cloak = SpellweaverMythicItem.ANCESTRAL_GLORY_CLOAK.getItem();
        cloak.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(cloak, ItemSlotEnum.CLOAK);

        UniqueItem belt = SpellweaverUniqueItems.BELT_OF_ZEAL.getItem();
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(belt, ItemSlotEnum.BELT);

        MythicItem ring1 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring1.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring1.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring1.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring1.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(ring1, ItemSlotEnum.RING1);
        MythicItem ring2 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring2.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(ring2, ItemSlotEnum.RING2);

        SetItem helmet = SpellweaverSetItems.SARGONS_HORNS.getItem();
        helmet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        helmet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        helmet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        helmet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        mage.addItem(helmet, ItemSlotEnum.HELMET);

        SetItem shoulders = SpellweaverSetItems.SARGONS_PAULDRONS.getItem();
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        mage.addItem(shoulders, ItemSlotEnum.SHOULDERS);

        Map<AbsoluteStatTypeEnum, Double> torsoBaseStats = new HashMap<>();
        torsoBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1631.657);
        torsoBaseStats.put(AbsoluteStatTypeEnum.HEALTH_POINTS, 14232.794);
        torsoBaseStats.put(AbsoluteStatTypeEnum.ARMOR, 1639.716);
        SetItem torso = SpellweaverSetItems.SARGONS_TORSO.getItem();
        torso.setBaseStats(torsoBaseStats);
        torso.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        torso.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        torso.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        torso.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        mage.addItem(torso, ItemSlotEnum.TORSO);

        SetItem gloves = SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_GLOVES.getItem();
        gloves.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        gloves.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        gloves.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        gloves.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        mage.addItem(gloves, ItemSlotEnum.GLOVES);

        SetItem boots = SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_BOOTS.getItem();
        boots.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        boots.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        boots.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        boots.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        mage.addItem(boots, ItemSlotEnum.BOOTS);

        UniqueItem adornment = SpellweaverUniqueItems.SIGRISMARRS_ETERNAL_GRASP.getItem();
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        Opal opal = new Opal(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0), new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0), new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
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
        mage.addItem(adornment, ItemSlotEnum.WEAPON_ADORNMENT);

        UniqueItem twoHand = SpellweaverUniqueItems.GRIMACE_OF_THE_THUNDER_BEAST.getItem();
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(twoHand, ItemSlotEnum.TWO_HAND_WEAPON);

        RuneTrinket runeTrinket1 = new RuneTrinket();
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        mage.addRuneTrinket(runeTrinket1, 1);

        RuneTrinket runeTrinket2 = new RuneTrinket();
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        mage.addRuneTrinket(runeTrinket2, 2);

        RuneTrinket runeTrinket3 = new RuneTrinket();
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        mage.addRuneTrinket(runeTrinket3, 3);

        RuneTrinket runeTrinket4 = new RuneTrinket();
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        mage.addRuneTrinket(runeTrinket4, 4);

        RuneTrinket runeTrinket5 = new RuneTrinket();
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.065));
        runeTrinket5.addRune(new SpecialRune("Rune of the Realm Changer", Map.of(), "Increases the Realm Changer talent by 5."));
        runeTrinket5.addRune(new SpecialRune("Rune of the Andermant Fever", Map.of(), "Increases the Andermant Fever talent by 5."));
        runeTrinket5.addRune(new SpecialRune("Rune of Rising Vigor", Map.of(OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.10, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.06), ""));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Materi Blessing", OverallRelativeBuffTypeEnum.MATERI_FRAGMENT_DROP_BONUS, 0.3));
        runeTrinket5.addRune(new Rune("Rune of Materi Blessing", OverallRelativeBuffTypeEnum.MATERI_FRAGMENT_DROP_BONUS, 0.3));
        mage.addRuneTrinket(runeTrinket5, 5);

        JewelTrinket jewelTrinket1 = new JewelTrinket();
        jewelTrinket1.addJewel(new Jewel("Jewel of Eternal Scorn", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.15, "..."));
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
        jewelTrinket2.addJewel(new Jewel("Jewel of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Ambidextrous Vigor", OverallRelativeBuffTypeEnum.TWO_HAND_DAMAGE, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Encouragement", "..."));
        jewelTrinket2.addJewel(new Jewel("Jewel of Contribution", "..."));
        mage.addJewelTrinket(jewelTrinket2, 2);

        JewelTrinket jewelTrinket3 = new JewelTrinket();
        jewelTrinket3.addJewel(new Jewel("Jewel of Lasting Health", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Converse", "..."));
        jewelTrinket3.addJewel(new Jewel("Fiery Flower Jewel", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Strenuousness", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.1));
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

        mage.setEssence(0.50);

        Pet mortisPet = new Pet("Mortis Doll", Map.of(OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.3, OverallRelativeBuffTypeEnum.MANA, 0.3, OverallRelativeBuffTypeEnum.DAMAGE, 0.3), "");
        mage.setPet(mortisPet);
        mage.setCollectorBagBuff(Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.33, OverallRelativeBuffTypeEnum.RESISTANCE, 0.15, OverallRelativeBuffTypeEnum.DAMAGE, 0.06, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.02));

        Tonic tonic = new Tonic("Tonic of Vigor", AbsoluteStatTypeEnum.DAMAGE, 10496.0);
        //mage.setTonic(tonic);
        Physic physic = new Physic("Advanced Physic of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.18);
        //mage.setPhysic(physic);


        return mage;
    }

    public static Character swerdMage() {
        Character mage = new Character(CharacterClassEnum.SPELLWEAVER);

        Map<AbsoluteStatTypeEnum, Double> amuletBaseStats = new HashMap<>();
        amuletBaseStats.put(AbsoluteStatTypeEnum.HEALTH_POINTS, 24323.032);
        amuletBaseStats.put(AbsoluteStatTypeEnum.RESISTANCE, 1102.014);
        amuletBaseStats.put(AbsoluteStatTypeEnum.BLOCK_VALUE, 1979.579);
        UniqueItem amulet = SpellweaverUniqueItems.KINGSHILL_NECKLACE.getItem();
        amulet.setBaseStats(amuletBaseStats);
        amulet.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        amulet.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        amulet.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        amulet.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44537));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        mage.addItem(amulet, ItemSlotEnum.AMULET);

        UniqueItem cloak = SpellweaverUniqueItems.DUPLICITOUS_TROPHY.getItem();
        cloak.addEnchant(new Enchant(EnchantTypeEnum.BLOCK_VALUE, 0.2430));
        cloak.addEnchant(new Enchant(EnchantTypeEnum.BLOCK_VALUE, 0.2430));
        cloak.addEnchant(new Enchant(EnchantTypeEnum.BLOCK_VALUE, 0.2430));
        cloak.addEnchant(new Enchant(EnchantTypeEnum.BLOCK_VALUE, 0.2430));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.BLOCK_VALUE, 2520.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.BLOCK_VALUE, 2520.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.BLOCK_VALUE, 2520.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.BLOCK_VALUE, 2520.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.BLOCK_VALUE, 2520.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.BLOCK_VALUE, 2520.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.BLOCK_VALUE, 2520.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.BLOCK_VALUE, 2520.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.BLOCK_VALUE, 2520.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.BLOCK_VALUE, 2520.0));
        mage.addItem(cloak, ItemSlotEnum.CLOAK);

        Map<AbsoluteStatTypeEnum, Double> beltBaseStats = new HashMap<>();
        beltBaseStats.put(AbsoluteStatTypeEnum.HEALTH_POINTS, 22808.696);
        beltBaseStats.put(AbsoluteStatTypeEnum.FIRE_RESISTANCE, 5313.336);
        beltBaseStats.put(AbsoluteStatTypeEnum.ICE_RESISTANCE, 5348.49);
        UniqueItem belt = SpellweaverUniqueItems.INQUIRING_MIND.getItem();
        belt.setBaseStats(beltBaseStats);
        belt.addEnchant(new Enchant(EnchantTypeEnum.BLOCK_VALUE, 0.2430));
        belt.addEnchant(new Enchant(EnchantTypeEnum.BLOCK_VALUE, 0.2430));
        belt.addEnchant(new Enchant(EnchantTypeEnum.BLOCK_VALUE, 0.2430));
        belt.addEnchant(new Enchant(EnchantTypeEnum.BLOCK_VALUE, 0.2430));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.BLOCK_VALUE, 2520.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.BLOCK_VALUE, 2520.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.BLOCK_VALUE, 2520.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.BLOCK_VALUE, 2520.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.BLOCK_VALUE, 2520.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.BLOCK_VALUE, 2520.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.BLOCK_VALUE, 2520.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.BLOCK_VALUE, 2520.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.BLOCK_VALUE, 2520.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.BLOCK_VALUE, 2520.0));
        mage.addItem(belt, ItemSlotEnum.BELT);

        MythicItem ring1 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring1.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring1.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring1.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring1.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(ring1, ItemSlotEnum.RING1);
        MythicItem ring2 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring2.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(ring2, ItemSlotEnum.RING2);

        SetItem helmet = SpellweaverSetItems.HELMET_OF_THE_BLACK_KNIGHT.getItem();
        helmet.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.4452));
        helmet.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44364));
        helmet.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44483));
        helmet.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44430));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        helmet.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        mage.addItem(helmet, ItemSlotEnum.HELMET);

        Map<AbsoluteStatTypeEnum, Double> shouldersBaseStats = new HashMap<>();
        shouldersBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1733.935);
        shouldersBaseStats.put(AbsoluteStatTypeEnum.HEALTH_POINTS, 16173.498);
        shouldersBaseStats.put(AbsoluteStatTypeEnum.POISON_RESISTANCE, 3429.474);
        UniqueItem shoulders = SpellweaverUniqueItems.ABYSSAL_TREASURE_PAULDRONS.getItem();
        shoulders.setBaseStats(shouldersBaseStats);
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.4452));
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.4452));
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.4452));
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.4452));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        mage.addItem(shoulders, ItemSlotEnum.SHOULDERS);

        Map<AbsoluteStatTypeEnum, Double> torsoBaseStats = new HashMap<>();
        torsoBaseStats.put(AbsoluteStatTypeEnum.HEALTH_POINTS, 13176.974);
        torsoBaseStats.put(AbsoluteStatTypeEnum.ARMOR, 1555.369);
        torsoBaseStats.put(AbsoluteStatTypeEnum.RESISTANCE, 1632.456);
        UniqueItem torso = SpellweaverUniqueItems.RESEARCHERS_COAT.getItem();
        torso.setBaseStats(torsoBaseStats);
        torso.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44263));
        torso.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44415));
        torso.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44382));
        torso.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44237));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        mage.addItem(torso, ItemSlotEnum.TORSO);

        UniqueItem gloves = SpellweaverUniqueItems.GLOVES_OF_THE_BLACK_KNIGHT.getItem();
        gloves.addEnchant(new Enchant(EnchantTypeEnum.RESISTANCE, 0.26930));
        gloves.addEnchant(new Enchant(EnchantTypeEnum.RESISTANCE, 0.26930));
        gloves.addEnchant(new Enchant(EnchantTypeEnum.RESISTANCE, 0.26930));
        gloves.addEnchant(new Enchant(EnchantTypeEnum.RESISTANCE, 0.26930));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.RESISTANCE, 1110.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.RESISTANCE, 1110.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.RESISTANCE, 1110.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.RESISTANCE, 1110.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.RESISTANCE, 1110.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.RESISTANCE, 1110.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.RESISTANCE, 1110.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.RESISTANCE, 1110.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.RESISTANCE, 1110.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.RESISTANCE, 1110.0));
        mage.addItem(gloves, ItemSlotEnum.GLOVES);

        Map<AbsoluteStatTypeEnum, Double> bootsBaseStats = new HashMap<>();
        bootsBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1472.688);
        bootsBaseStats.put(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.986);
        bootsBaseStats.put(AbsoluteStatTypeEnum.CRIT_VALUE, 1271.924);
        SetItem boots = SpellweaverSetItems.BOOTS_OF_THE_FLAME_CONQUEROR.getItem();
        boots.setBaseStats(bootsBaseStats);
        boots.addEnchant(new Enchant(EnchantTypeEnum.MOVEMENT_SPEED, 0.22410));
        boots.addEnchant(new Enchant(EnchantTypeEnum.MOVEMENT_SPEED, 0.22410));
        boots.addEnchant(new Enchant(EnchantTypeEnum.MOVEMENT_SPEED, 0.22410));
        boots.addEnchant(new Enchant(EnchantTypeEnum.MOVEMENT_SPEED, 0.22410));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        mage.addItem(boots, ItemSlotEnum.BOOTS);

        Map<AbsoluteStatTypeEnum, Double> adornmentBaseStats = new HashMap<>();
        adornmentBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1885.747);
        adornmentBaseStats.put(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.039);
        adornmentBaseStats.put(AbsoluteStatTypeEnum.CRIT_VALUE, 1855.476);
        UniqueItem adornment = SpellweaverUniqueItems.STINGER.getItem();
        adornment.setBaseStats(adornmentBaseStats);
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44771));
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44767));
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44775));
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44772));
        Opal opal = new Opal(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0), new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0), new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
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
        mage.addItem(adornment, ItemSlotEnum.WEAPON_ADORNMENT);

        SetItem oneHand = SpellweaverSetItems.KRANPARUS_ICY_STAFF.getItem();
        oneHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        oneHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        oneHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        oneHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        oneHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        oneHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        oneHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        oneHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        oneHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        oneHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        oneHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        oneHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        oneHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        oneHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(oneHand, ItemSlotEnum.ONE_HAND_WEAPON);

        UniqueItem offHand = SpellweaverUniqueItems.SHARR_KHARABS_SCROLL.getItem();
        offHand.addEnchant(new Enchant(EnchantTypeEnum.CRIT_VALUE, 0.24563));
        offHand.addEnchant(new Enchant(EnchantTypeEnum.CRIT_VALUE, 0.24563));
        offHand.addEnchant(new Enchant(EnchantTypeEnum.CRIT_VALUE, 0.24563));
        offHand.addEnchant(new Enchant(EnchantTypeEnum.CRIT_VALUE, 0.24563));
        offHand.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        offHand.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        offHand.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        offHand.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        offHand.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        offHand.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        offHand.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        offHand.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        offHand.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        offHand.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        mage.addItem(offHand, ItemSlotEnum.OFF_HAND);

        RuneTrinket runeTrinket1 = new RuneTrinket();
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        mage.addRuneTrinket(runeTrinket1, 1);

        RuneTrinket runeTrinket2 = new RuneTrinket();
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new Rune("Rune of Resilience", OverallRelativeBuffTypeEnum.RESISTANCE, 0.065));
        runeTrinket2.addRune(new SpecialRune("Rune of Rising Vigor", Map.of(OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.10, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.06), ""));
        mage.addRuneTrinket(runeTrinket2, 2);

        RuneTrinket runeTrinket3 = new RuneTrinket();
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        mage.addRuneTrinket(runeTrinket3, 3);

        RuneTrinket runeTrinket4 = new RuneTrinket();
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        mage.addRuneTrinket(runeTrinket4, 4);

        RuneTrinket runeTrinket5 = new RuneTrinket();
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Persistence", OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Persistence", OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Persistence", OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Persistence", OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Persistence", OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Resilience", OverallRelativeBuffTypeEnum.RESISTANCE, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Resilience", OverallRelativeBuffTypeEnum.RESISTANCE, 0.065));
        mage.addRuneTrinket(runeTrinket5, 5);

        JewelTrinket jewelTrinket1 = new JewelTrinket();
        jewelTrinket1.addJewel(new Jewel("Jewel of Eternal Scorn", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.15, "..."));
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
        jewelTrinket2.addJewel(new Jewel("Jewel of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Ambidextrous Vigor", OverallRelativeBuffTypeEnum.TWO_HAND_DAMAGE, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Encouragement", "..."));
        jewelTrinket2.addJewel(new Jewel("Jewel of Contribution", "..."));
        mage.addJewelTrinket(jewelTrinket2, 2);

        JewelTrinket jewelTrinket3 = new JewelTrinket();
        jewelTrinket3.addJewel(new Jewel("Jewel of Lasting Health", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Converse", "..."));
        jewelTrinket3.addJewel(new Jewel("Fiery Flower Jewel", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Strenuousness", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.1));
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

        mage.setEssence(0.50);

        Pet mortisPet = new Pet("Golden Dragon Turtle", Map.of(OverallRelativeBuffTypeEnum.ARMOR, 0.22, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.22, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.22), "");
        mage.setPet(mortisPet);
        mage.setCollectorBagBuff(Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.33, OverallRelativeBuffTypeEnum.RESISTANCE, 0.15, OverallRelativeBuffTypeEnum.DAMAGE, 0.06, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.02));

        Tonic tonic = new Tonic("Tonic of Vigor", AbsoluteStatTypeEnum.HEALTH_POINTS, 156068.0);
        //mage.setTonic(tonic);
        Physic physic = new Physic("Advanced Physic of Vigor", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.18);
        //mage.setPhysic(physic);


        return mage;
    }

    //ess set + mortis
    public static Character bghEssMage() {
        Character mage = new Character(CharacterClassEnum.SPELLWEAVER, "ess set + mortis");

        Map<AbsoluteStatTypeEnum, Double> amuletBaseStats = new HashMap<>();
        amuletBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1456.734);
        amuletBaseStats.put(AbsoluteStatTypeEnum.CRIT_VALUE, 1471.185);
        amuletBaseStats.put(AbsoluteStatTypeEnum.RESISTANCE, 1148.60);
        SetItem amulet = SpellweaverSetItems.AMULET_OF_DEATH.getItem();
        amulet.setBaseStats(amuletBaseStats);
        amulet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44707));
        amulet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44702));
        amulet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.4471));
        amulet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44728));
        mage.addItem(amulet, ItemSlotEnum.AMULET);

        MythicItem cloak = SpellweaverMythicItem.ANCESTRAL_GLORY_CLOAK.getItem();
        cloak.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(cloak, ItemSlotEnum.CLOAK);

        Map<AbsoluteStatTypeEnum, Double> beltBaseStats = new HashMap<>();
        beltBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1630.885);
        beltBaseStats.put(AbsoluteStatTypeEnum.HEALTH_POINTS, 20072.654);
        beltBaseStats.put(AbsoluteStatTypeEnum.RESISTANCE, 1679.873);
        UniqueItem belt = SpellweaverUniqueItems.BELT_OF_ZEAL.getItem();
        belt.setBaseStats(beltBaseStats);
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(belt, ItemSlotEnum.BELT);

        MythicItem ring1 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring1.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring1.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring1.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring1.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(ring1, ItemSlotEnum.RING1);
        MythicItem ring2 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring2.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(ring2, ItemSlotEnum.RING2);

        Map<AbsoluteStatTypeEnum, Double> helmetBaseStats = new HashMap<>();
        helmetBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1453.087);
        helmetBaseStats.put(AbsoluteStatTypeEnum.CRIT_VALUE, 1220.018);
        helmetBaseStats.put(AbsoluteStatTypeEnum.RESISTANCE, 701.0);
        SetItem helmet = SpellweaverSetItems.CAP_OF_DEATH.getItem();
        helmet.setBaseStats(helmetBaseStats);
        helmet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44727));
        helmet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44736));
        helmet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44643));
        helmet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44611));
        mage.addItem(helmet, ItemSlotEnum.HELMET);

        Map<AbsoluteStatTypeEnum, Double> shouldersBaseStats = new HashMap<>();
        shouldersBaseStats.put(AbsoluteStatTypeEnum.HEALTH_POINTS, 8234.56);
        shouldersBaseStats.put(AbsoluteStatTypeEnum.ARMOR, 940.242);
        shouldersBaseStats.put(AbsoluteStatTypeEnum.RESISTANCE, 871.99);
        SetItem shoulders = SpellweaverSetItems.BLACK_ESSENCE_PAULDRONS.getItem();
        shoulders.setBaseStats(shouldersBaseStats);
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.CRIT_VALUE, 0.24563));
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.CRIT_VALUE, 0.24563));
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.CRIT_VALUE, 0.24563));
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.CRIT_VALUE, 0.24563));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        mage.addItem(shoulders, ItemSlotEnum.SHOULDERS);

        Map<AbsoluteStatTypeEnum, Double> torsoBaseStats = new HashMap<>();
        torsoBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1150.205);
        torsoBaseStats.put(AbsoluteStatTypeEnum.HEALTH_POINTS, 7280.996);
        torsoBaseStats.put(AbsoluteStatTypeEnum.ARMOR, 1426.286);
        SetItem torso = SpellweaverSetItems.BLACK_ESSENCE_ARMOR.getItem();
        torso.setBaseStats(torsoBaseStats);
        torso.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44515));
        torso.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.4451));
        torso.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44535));
        torso.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44513));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        mage.addItem(torso, ItemSlotEnum.TORSO);

        Map<AbsoluteStatTypeEnum, Double> glovesBaseStats = new HashMap<>();
        glovesBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1466.322);
        glovesBaseStats.put(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.049);
        glovesBaseStats.put(AbsoluteStatTypeEnum.ARMOR, 770.795);
        SetItem gloves = SpellweaverSetItems.BLACK_ESSENCE_GLOVES.getItem();
        gloves.setBaseStats(glovesBaseStats);
        gloves.addEnchant(new Enchant(EnchantTypeEnum.ATTACK_SPEED, 0.47122));
        gloves.addEnchant(new Enchant(EnchantTypeEnum.ATTACK_SPEED, 0.47122));
        gloves.addEnchant(new Enchant(EnchantTypeEnum.ATTACK_SPEED, 0.47122));
        gloves.addEnchant(new Enchant(EnchantTypeEnum.ATTACK_SPEED, 0.47122));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.017));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.017));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.017));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.017));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.017));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.017));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.017));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        mage.addItem(gloves, ItemSlotEnum.GLOVES);

        Map<AbsoluteStatTypeEnum, Double> bootsBaseStats = new HashMap<>();
        bootsBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1252.206);
        bootsBaseStats.put(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 1.054);
        bootsBaseStats.put(AbsoluteStatTypeEnum.HEALTH_POINTS, 10453.816);
        SetItem boots = SpellweaverSetItems.BLACK_ESSENCE_BOOTS.getItem();
        boots.setBaseStats(bootsBaseStats);
        boots.addEnchant(new Enchant(EnchantTypeEnum.MOVEMENT_SPEED, 0.22444));
        boots.addEnchant(new Enchant(EnchantTypeEnum.MOVEMENT_SPEED, 0.22445));
        boots.addEnchant(new Enchant(EnchantTypeEnum.MOVEMENT_SPEED, 0.22449));
        boots.addEnchant(new Enchant(EnchantTypeEnum.MOVEMENT_SPEED, 0.22448));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        mage.addItem(boots, ItemSlotEnum.BOOTS);

        Map<AbsoluteStatTypeEnum, Double> adornmentBaseStats = new HashMap<>();
        adornmentBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1870.52);
        adornmentBaseStats.put(AbsoluteStatTypeEnum.CRIT_VALUE, 2100.146);
        UniqueItem adornment = SpellweaverUniqueItems.SIGRISMARRS_ETERNAL_GRASP.getItem();
        adornment.setBaseStats(adornmentBaseStats);
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44771));
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44767));
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44775));
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44772));
        Opal opal = new Opal(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0), new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0), new Gem(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.017));
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
        mage.addItem(adornment, ItemSlotEnum.WEAPON_ADORNMENT);

        Map<AbsoluteStatTypeEnum, Double> twoHandBaseStats = new HashMap<>();
        twoHandBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 24570.982);
        twoHandBaseStats.put(AbsoluteStatTypeEnum.CRIT_VALUE, 3321.515);
        UniqueItem twoHand = SpellweaverUniqueItems.GRIMACE_OF_THE_THUNDER_BEAST.getItem();
        twoHand.setBaseStats(twoHandBaseStats);
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(twoHand, ItemSlotEnum.TWO_HAND_WEAPON);

        RuneTrinket runeTrinket1 = new RuneTrinket();
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        mage.addRuneTrinket(runeTrinket1, 1);

        RuneTrinket runeTrinket2 = new RuneTrinket();
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Rune of Rising Vigor", Map.of(OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.10, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.06), ""));
        mage.addRuneTrinket(runeTrinket2, 2);

        RuneTrinket runeTrinket3 = new RuneTrinket();
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        mage.addRuneTrinket(runeTrinket3, 3);

        RuneTrinket runeTrinket4 = new RuneTrinket();
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        mage.addRuneTrinket(runeTrinket4, 4);

        RuneTrinket runeTrinket5 = new RuneTrinket();
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.065));
        runeTrinket5.addRune(new SpecialRune("Rune of the Realm Changer", Map.of(), "Increases the Realm Changer talent by 5."));
        runeTrinket5.addRune(new SpecialRune("Rune of the Andermant Fever", Map.of(), "Increases the Andermant Fever talent by 5."));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Materi Blessing", OverallRelativeBuffTypeEnum.MATERI_FRAGMENT_DROP_BONUS, 0.3));
        runeTrinket5.addRune(new Rune("Rune of Materi Blessing", OverallRelativeBuffTypeEnum.MATERI_FRAGMENT_DROP_BONUS, 0.3));
        runeTrinket5.addRune(new Rune("Rune of Materi Blessing", OverallRelativeBuffTypeEnum.MATERI_FRAGMENT_DROP_BONUS, 0.3));
        mage.addRuneTrinket(runeTrinket5, 5);

        JewelTrinket jewelTrinket1 = new JewelTrinket();
        jewelTrinket1.addJewel(new Jewel("Jewel of Eternal Scorn", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.15, "..."));
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
        jewelTrinket2.addJewel(new Jewel("Jewel of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Ambidextrous Vigor", OverallRelativeBuffTypeEnum.TWO_HAND_DAMAGE, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Encouragement", "..."));
        jewelTrinket2.addJewel(new Jewel("Jewel of Contribution", "..."));
        mage.addJewelTrinket(jewelTrinket2, 2);

        JewelTrinket jewelTrinket3 = new JewelTrinket();
        jewelTrinket3.addJewel(new Jewel("Jewel of Lasting Health", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Converse", "..."));
        jewelTrinket3.addJewel(new Jewel("Fiery Flower Jewel", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Strenuousness", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.1));
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

        mage.setEssence(3.00);

        Pet mortisPet = new Pet("Mortis Doll", Map.of(OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.3, OverallRelativeBuffTypeEnum.MANA, 0.3, OverallRelativeBuffTypeEnum.DAMAGE, 0.3), "");
        mage.setPet(mortisPet);
        mage.setCollectorBagBuff(Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.33, OverallRelativeBuffTypeEnum.RESISTANCE, 0.15, OverallRelativeBuffTypeEnum.DAMAGE, 0.06, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.02));

        Tonic tonic = new Tonic("Tonic of Vigor", AbsoluteStatTypeEnum.DAMAGE, 10496.0);
        mage.setTonic(tonic);
        Physic physic = new Physic("Advanced Physic of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.18);
        mage.setPhysic(physic);


        return mage;
    }

    //ess set + mortis + destructor
    public static Character bghEssMage2() {
        Character mage = new Character(CharacterClassEnum.SPELLWEAVER, "ess set + mortis + destructor");

        Map<AbsoluteStatTypeEnum, Double> amuletBaseStats = new HashMap<>();
        amuletBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1456.734);
        amuletBaseStats.put(AbsoluteStatTypeEnum.CRIT_VALUE, 1471.185);
        amuletBaseStats.put(AbsoluteStatTypeEnum.RESISTANCE, 1148.60);
        SetItem amulet = SpellweaverSetItems.AMULET_OF_DEATH.getItem();
        amulet.setBaseStats(amuletBaseStats);
        amulet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44707));
        amulet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44702));
        amulet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.4471));
        amulet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44728));
        mage.addItem(amulet, ItemSlotEnum.AMULET);

        MythicItem cloak = SpellweaverMythicItem.ANCESTRAL_GLORY_CLOAK.getItem();
        cloak.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(cloak, ItemSlotEnum.CLOAK);

        SetItem belt = SpellweaverSetItems.AUTOMATED_BELT.getItem();
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        belt.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(belt, ItemSlotEnum.BELT);

        MythicItem ring1 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring1.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring1.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring1.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring1.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring1.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(ring1, ItemSlotEnum.RING1);
        MythicItem ring2 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring2.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        ring2.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(ring2, ItemSlotEnum.RING2);

        Map<AbsoluteStatTypeEnum, Double> helmetBaseStats = new HashMap<>();
        helmetBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1453.087);
        helmetBaseStats.put(AbsoluteStatTypeEnum.CRIT_VALUE, 1220.018);
        helmetBaseStats.put(AbsoluteStatTypeEnum.RESISTANCE, 701.0);
        SetItem helmet = SpellweaverSetItems.CAP_OF_DEATH.getItem();
        helmet.setBaseStats(helmetBaseStats);
        helmet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44727));
        helmet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44736));
        helmet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44643));
        helmet.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44611));
        mage.addItem(helmet, ItemSlotEnum.HELMET);

        Map<AbsoluteStatTypeEnum, Double> shouldersBaseStats = new HashMap<>();
        shouldersBaseStats.put(AbsoluteStatTypeEnum.HEALTH_POINTS, 8234.56);
        shouldersBaseStats.put(AbsoluteStatTypeEnum.ARMOR, 940.242);
        shouldersBaseStats.put(AbsoluteStatTypeEnum.RESISTANCE, 871.99);
        SetItem shoulders = SpellweaverSetItems.BLACK_ESSENCE_PAULDRONS.getItem();
        shoulders.setBaseStats(shouldersBaseStats);
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.CRIT_VALUE, 0.24563));
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.CRIT_VALUE, 0.24563));
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.CRIT_VALUE, 0.24563));
        shoulders.addEnchant(new Enchant(EnchantTypeEnum.CRIT_VALUE, 0.24563));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        mage.addItem(shoulders, ItemSlotEnum.SHOULDERS);

        Map<AbsoluteStatTypeEnum, Double> torsoBaseStats = new HashMap<>();
        torsoBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1150.205);
        torsoBaseStats.put(AbsoluteStatTypeEnum.HEALTH_POINTS, 7280.996);
        torsoBaseStats.put(AbsoluteStatTypeEnum.ARMOR, 1426.286);
        SetItem torso = SpellweaverSetItems.BLACK_ESSENCE_ARMOR.getItem();
        torso.setBaseStats(torsoBaseStats);
        torso.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44515));
        torso.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.4451));
        torso.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44535));
        torso.addEnchant(new Enchant(EnchantTypeEnum.HEALTH_POINTS, 0.44513));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        mage.addItem(torso, ItemSlotEnum.TORSO);

        Map<AbsoluteStatTypeEnum, Double> glovesBaseStats = new HashMap<>();
        glovesBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1466.322);
        glovesBaseStats.put(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.049);
        glovesBaseStats.put(AbsoluteStatTypeEnum.ARMOR, 770.795);
        SetItem gloves = SpellweaverSetItems.BLACK_ESSENCE_GLOVES.getItem();
        gloves.setBaseStats(glovesBaseStats);
        gloves.addEnchant(new Enchant(EnchantTypeEnum.ATTACK_SPEED, 0.47122));
        gloves.addEnchant(new Enchant(EnchantTypeEnum.ATTACK_SPEED, 0.47122));
        gloves.addEnchant(new Enchant(EnchantTypeEnum.ATTACK_SPEED, 0.47122));
        gloves.addEnchant(new Enchant(EnchantTypeEnum.ATTACK_SPEED, 0.47122));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.017));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.017));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.017));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.017));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.017));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.017));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.017));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        gloves.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        mage.addItem(gloves, ItemSlotEnum.GLOVES);

        Map<AbsoluteStatTypeEnum, Double> bootsBaseStats = new HashMap<>();
        bootsBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1550.720);
        bootsBaseStats.put(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 1.179);
        bootsBaseStats.put(AbsoluteStatTypeEnum.HEALTH_POINTS, 13136.770);
        SetItem boots = SpellweaverSetItems.AUTOMATED_SHINGUARDS.getItem();
        boots.setBaseStats(bootsBaseStats);
        boots.addEnchant(new Enchant(EnchantTypeEnum.MOVEMENT_SPEED, 0.22444));
        boots.addEnchant(new Enchant(EnchantTypeEnum.MOVEMENT_SPEED, 0.22445));
        boots.addEnchant(new Enchant(EnchantTypeEnum.MOVEMENT_SPEED, 0.22449));
        boots.addEnchant(new Enchant(EnchantTypeEnum.MOVEMENT_SPEED, 0.22448));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0));
        mage.addItem(boots, ItemSlotEnum.BOOTS);

        Map<AbsoluteStatTypeEnum, Double> adornmentBaseStats = new HashMap<>();
        adornmentBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1870.52);
        adornmentBaseStats.put(AbsoluteStatTypeEnum.CRIT_VALUE, 2100.146);
        UniqueItem adornment = SpellweaverUniqueItems.SIGRISMARRS_ETERNAL_GRASP.getItem();
        adornment.setBaseStats(adornmentBaseStats);
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44771));
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44767));
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44775));
        adornment.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44772));
        Opal opal = new Opal(new Gem(AbsoluteStatTypeEnum.CRIT_VALUE, 2520.0), new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0), new Gem(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.017));
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
        mage.addItem(adornment, ItemSlotEnum.WEAPON_ADORNMENT);

        Map<AbsoluteStatTypeEnum, Double> twoHandBaseStats = new HashMap<>();
        twoHandBaseStats.put(AbsoluteStatTypeEnum.DAMAGE, 24570.982);
        twoHandBaseStats.put(AbsoluteStatTypeEnum.CRIT_VALUE, 3321.515);
        UniqueItem twoHand = SpellweaverUniqueItems.GRIMACE_OF_THE_THUNDER_BEAST.getItem();
        twoHand.setBaseStats(twoHandBaseStats);
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addEnchant(new Enchant(EnchantTypeEnum.DAMAGE, 0.44776));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        twoHand.addGem(new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0));
        mage.addItem(twoHand, ItemSlotEnum.TWO_HAND_WEAPON);

        RuneTrinket runeTrinket1 = new RuneTrinket();
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        runeTrinket1.addRune(new Rune("Rune of Devastation", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065));
        mage.addRuneTrinket(runeTrinket1, 1);

        RuneTrinket runeTrinket2 = new RuneTrinket();
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Spring Rune", Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Concentrated Summer Rune", Map.of(OverallRelativeBuffTypeEnum.RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.065), ""));
        runeTrinket2.addRune(new SpecialRune("Rune of Rising Vigor", Map.of(OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.10, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.06), ""));
        mage.addRuneTrinket(runeTrinket2, 2);

        RuneTrinket runeTrinket3 = new RuneTrinket();
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Autumn Rune", Map.of(OverallRelativeBuffTypeEnum.ANDERMANT_DROP_BONUS, 0.05, OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065, OverallRelativeBuffTypeEnum.DAMAGE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        runeTrinket3.addRune(new SpecialRune("Concentrated Solstice Rune", Map.of(OverallRelativeBuffTypeEnum.ICE_RESISTANCE, 0.065, OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065, OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.065), ""));
        mage.addRuneTrinket(runeTrinket3, 3);

        RuneTrinket runeTrinket4 = new RuneTrinket();
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Celerity", OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        runeTrinket4.addRune(new Rune("Rune of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.065));
        mage.addRuneTrinket(runeTrinket4, 4);

        RuneTrinket runeTrinket5 = new RuneTrinket();
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.065));
        runeTrinket5.addRune(new SpecialRune("Rune of the Realm Changer", Map.of(), "Increases the Realm Changer talent by 5."));
        runeTrinket5.addRune(new SpecialRune("Rune of the Andermant Fever", Map.of(), "Increases the Andermant Fever talent by 5."));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Materi Blessing", OverallRelativeBuffTypeEnum.MATERI_FRAGMENT_DROP_BONUS, 0.3));
        runeTrinket5.addRune(new Rune("Rune of Materi Blessing", OverallRelativeBuffTypeEnum.MATERI_FRAGMENT_DROP_BONUS, 0.3));
        runeTrinket5.addRune(new Rune("Rune of Materi Blessing", OverallRelativeBuffTypeEnum.MATERI_FRAGMENT_DROP_BONUS, 0.3));
        mage.addRuneTrinket(runeTrinket5, 5);

        JewelTrinket jewelTrinket1 = new JewelTrinket();
        jewelTrinket1.addJewel(new Jewel("Jewel of Eternal Scorn", OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.15, "..."));
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
        jewelTrinket2.addJewel(new Jewel("Jewel of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Ambidextrous Vigor", OverallRelativeBuffTypeEnum.TWO_HAND_DAMAGE, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Vitality", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.1));
        jewelTrinket2.addJewel(new Jewel("Jewel of Encouragement", "..."));
        jewelTrinket2.addJewel(new Jewel("Jewel of Contribution", "..."));
        mage.addJewelTrinket(jewelTrinket2, 2);

        JewelTrinket jewelTrinket3 = new JewelTrinket();
        jewelTrinket3.addJewel(new Jewel("Jewel of Lasting Health", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Converse", "..."));
        jewelTrinket3.addJewel(new Jewel("Fiery Flower Jewel", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Strenuousness", "..."));
        jewelTrinket3.addJewel(new Jewel("Jewel of Fortitude", OverallRelativeBuffTypeEnum.ARMOR, 0.1));
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

        mage.setEssence(3.00);

        Pet mortisPet = new Pet("Mortis Doll", Map.of(OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.3, OverallRelativeBuffTypeEnum.MANA, 0.3, OverallRelativeBuffTypeEnum.DAMAGE, 0.3), "");
        mage.setPet(mortisPet);
        mage.setCollectorBagBuff(Map.of(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.33, OverallRelativeBuffTypeEnum.RESISTANCE, 0.15, OverallRelativeBuffTypeEnum.DAMAGE, 0.06, OverallRelativeBuffTypeEnum.BLOCK_VALUE, 0.02));

        Tonic tonic = new Tonic("Tonic of Vigor", AbsoluteStatTypeEnum.DAMAGE, 10496.0);
        mage.setTonic(tonic);
        Physic physic = new Physic("Advanced Physic of Vigor", OverallRelativeBuffTypeEnum.DAMAGE, 0.18);
        mage.setPhysic(physic);


        return mage;
    }


    public static void printStats(Character character)
    {
        Map<AbsoluteStatTypeEnum, Double> stats = character.getCharacterFinalStats();
        System.out.println("Character: " + character.getName());
        System.out.printf(AbsoluteStatTypeEnum.DAMAGE + ": %.2f%n", stats.get(AbsoluteStatTypeEnum.DAMAGE));
        System.out.printf(AbsoluteStatTypeEnum.ATTACK_SPEED + ": %.2f%n", stats.get(AbsoluteStatTypeEnum.ATTACK_SPEED));
        System.out.printf(AbsoluteStatTypeEnum.CRIT_VALUE + ": %.2f%n", stats.get(AbsoluteStatTypeEnum.CRIT_VALUE));
        System.out.printf(AbsoluteStatTypeEnum.MANA + ": %.2f%n", stats.get(AbsoluteStatTypeEnum.MANA));
        System.out.printf(AbsoluteStatTypeEnum.MANA_PER_SECOND + ": %.2f%n", stats.get(AbsoluteStatTypeEnum.MANA_PER_SECOND));
        System.out.printf(AbsoluteStatTypeEnum.MOVEMENT_SPEED + ": %.2f%n", stats.get(AbsoluteStatTypeEnum.MOVEMENT_SPEED));
        System.out.printf(AbsoluteStatTypeEnum.HEALTH_POINTS + ": %.2f%n", stats.get(AbsoluteStatTypeEnum.HEALTH_POINTS));
        System.out.printf(AbsoluteStatTypeEnum.HEALTH_PER_SECOND + ": %.2f%n", stats.get(AbsoluteStatTypeEnum.HEALTH_PER_SECOND));
        System.out.printf(AbsoluteStatTypeEnum.BLOCK_VALUE + ": %.2f%n", stats.get(AbsoluteStatTypeEnum.BLOCK_VALUE));
        System.out.printf(AbsoluteStatTypeEnum.ARMOR + ": %.2f%n", stats.get(AbsoluteStatTypeEnum.ARMOR));
        System.out.printf(AbsoluteStatTypeEnum.FIRE_RESISTANCE + ": %.2f%n", stats.get(AbsoluteStatTypeEnum.FIRE_RESISTANCE));
        System.out.printf(AbsoluteStatTypeEnum.ICE_RESISTANCE + ": %.2f%n", stats.get(AbsoluteStatTypeEnum.ICE_RESISTANCE));
        System.out.printf(AbsoluteStatTypeEnum.LIGHTNING_RESISTANCE + ": %.2f%n", stats.get(AbsoluteStatTypeEnum.LIGHTNING_RESISTANCE));
        System.out.printf(AbsoluteStatTypeEnum.ANDERMAGIC_RESISTANCE + ": %.2f%n", stats.get(AbsoluteStatTypeEnum.ANDERMAGIC_RESISTANCE));
        System.out.printf(AbsoluteStatTypeEnum.POISON_RESISTANCE + ": %.2f%n", stats.get(AbsoluteStatTypeEnum.POISON_RESISTANCE));
    }
}