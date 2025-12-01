package charactertests;

import com.langleon.dsobuildsim.buffs.Physic;
import com.langleon.dsobuildsim.buffs.Tonic;
import com.langleon.dsobuildsim.character.Character;
import com.langleon.dsobuildsim.enchantments.Enchant;
import com.langleon.dsobuildsim.enums.*;
import com.langleon.dsobuildsim.gems.Gem;
import com.langleon.dsobuildsim.gems.Opal;
import com.langleon.dsobuildsim.items.actualitems.AbstractItem;
import com.langleon.dsobuildsim.items.actualitems.MythicItem;
import com.langleon.dsobuildsim.items.itemdatabase.mythicitems.SpellweaverMythicItem;
import com.langleon.dsobuildsim.items.actualitems.SetItem;
import com.langleon.dsobuildsim.items.actualitems.UniqueItem;
import com.langleon.dsobuildsim.items.itemdatabase.setitems.SpellweaverSetItems;
import com.langleon.dsobuildsim.items.itemdatabase.uniqueitems.SpellweaverUniqueItems;
import com.langleon.dsobuildsim.jewels.Jewel;
import com.langleon.dsobuildsim.jewels.JewelTrinket;
import com.langleon.dsobuildsim.pets.Pet;
import com.langleon.dsobuildsim.runes.Rune;
import com.langleon.dsobuildsim.runes.RuneTrinket;
import com.langleon.dsobuildsim.runes.SpecialRune;
import com.langleon.dsobuildsim.skilltrees.wisdomskilltree.WisdomSkillTree;

import java.util.*;

public class RealMageTest {
    public static void main(String[] args) {
        Character mage = zohan();
        mage.calculateFinalStats();
        printStats(mage);
    }

    public static Character pveNormal() {
        //3p sargon, 2p seeker, q8, q9
        Character mage = new Character(CharacterClass.SPELLWEAVER, "3p sargon, 2p seeker, q8, q9");

        AbstractItem amulet = SpellweaverUniqueItems.AMULET_OF_THE_KRAKEN.getItem();
        amulet.setEnchants(EnchantType.HEALTH_POINTS);
        amulet.setGems(AbsoluteStatType.HEALTH_POINTS);
        mage.addItem(amulet, ItemSlot.AMULET);

        AbstractItem cloak = SpellweaverMythicItem.ANCESTRAL_GLORY_CLOAK.getItem();
        cloak.setEnchants(EnchantType.DAMAGE);
        cloak.setGems(AbsoluteStatType.DAMAGE);
        mage.addItem(cloak, ItemSlot.CLOAK);

        AbstractItem belt = SpellweaverUniqueItems.BELT_OF_ZEAL.getItem();
        belt.setEnchants(EnchantType.DAMAGE);
        belt.setGems(AbsoluteStatType.DAMAGE);
        mage.addItem(belt, ItemSlot.BELT);

        AbstractItem ring1 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring1.setEnchants(EnchantType.DAMAGE);
        ring1.setGems(AbsoluteStatType.DAMAGE);
        mage.addItem(ring1, ItemSlot.RING1);

        AbstractItem ring2 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring2.setEnchants(EnchantType.DAMAGE);
        Opal opal = new Opal(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0), new Gem(AbsoluteStatType.DAMAGE, 700.0), new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        ring2.addGems(opal, 10);
        mage.addItem(ring2, ItemSlot.RING2);

        AbstractItem helmet = SpellweaverSetItems.SARGONS_HORNS.getItem();
        helmet.setEnchants(EnchantType.HEALTH_POINTS);
        helmet.setGems(AbsoluteStatType.HEALTH_POINTS);
        mage.addItem(helmet, ItemSlot.HELMET);

        AbstractItem shoulders = SpellweaverSetItems.SARGONS_PAULDRONS.getItem();
        shoulders.setEnchants(EnchantType.DAMAGE);
        shoulders.setGems(AbsoluteStatType.CRIT_VALUE);
        mage.addItem(shoulders, ItemSlot.SHOULDERS);

        AbstractItem torso = SpellweaverSetItems.SARGONS_TORSO.getItem();
        torso.setEnchants(EnchantType.HEALTH_POINTS);
        torso.setGems(AbsoluteStatType.HEALTH_POINTS);
        mage.addItem(torso, ItemSlot.TORSO);

        AbstractItem gloves = SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_GLOVES.getItem();
        gloves.setEnchants(EnchantType.DAMAGE);
        gloves.setGems(AbsoluteStatType.CRIT_VALUE);
        mage.addItem(gloves, ItemSlot.GLOVES);

        AbstractItem boots = SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_BOOTS.getItem();
        boots.setEnchants(EnchantType.DAMAGE);
        boots.addGems(AbsoluteStatType.CRIT_VALUE, 8);
        boots.addGems(AbsoluteStatType.MOVEMENT_SPEED, 2);
        mage.addItem(boots, ItemSlot.BOOTS);

        AbstractItem adornment = SpellweaverUniqueItems.SIGRISMARRS_ETERNAL_GRASP.getItem();
        adornment.setEnchants(EnchantType.DAMAGE);
        adornment.setGems(AbsoluteStatType.DAMAGE);
        mage.addItem(adornment, ItemSlot.WEAPON_ADORNMENT);

        AbstractItem twoHand = SpellweaverUniqueItems.GRIMACE_OF_THE_THUNDER_BEAST.getItem();
        twoHand.setEnchants(EnchantType.DAMAGE);
        twoHand.setGems(AbsoluteStatType.DAMAGE);
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

        Tonic tonic = new Tonic("Tonic of Vigor", AbsoluteStatType.HEALTH_POINTS, 156068.0);
        //mage.setTonic(tonic);
        Physic physic = new Physic("Advanced Physic of Vigor", OverallRelativeBuffType.HEALTH_POINTS, 0.18);
        //mage.setPhysic(physic);

        return mage;
    }

    public static Character pveNormal2() {
        //2p destructor, sargon gloves, 2p seeker, q8, q9
        Character mage = new Character(CharacterClass.SPELLWEAVER, "2p destructor, sargon gloves, 2p seeker, q8, q9");

        AbstractItem amulet = SpellweaverUniqueItems.AMULET_OF_THE_KRAKEN.getItem();
        amulet.setEnchants(EnchantType.HEALTH_POINTS);
        amulet.setGems(AbsoluteStatType.HEALTH_POINTS);
        mage.addItem(amulet, ItemSlot.AMULET);

        AbstractItem cloak = SpellweaverMythicItem.ANCESTRAL_GLORY_CLOAK.getItem();
        cloak.setEnchants(EnchantType.DAMAGE);
        cloak.setGems(AbsoluteStatType.CRIT_VALUE);
        mage.addItem(cloak, ItemSlot.CLOAK);

        AbstractItem belt = SpellweaverUniqueItems.BELT_OF_ZEAL.getItem();
        belt.setEnchants(EnchantType.DAMAGE);
        belt.setGems(AbsoluteStatType.DAMAGE);
        mage.addItem(belt, ItemSlot.BELT);

        AbstractItem ring1 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring1.setEnchants(EnchantType.DAMAGE);
        ring1.setGems(AbsoluteStatType.DAMAGE);
        mage.addItem(ring1, ItemSlot.RING1);

        AbstractItem ring2 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring2.setEnchants(EnchantType.DAMAGE);
        Opal opal = new Opal(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0), new Gem(AbsoluteStatType.DAMAGE, 700.0), new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        ring2.addGems(opal, 10);
        mage.addItem(ring2, ItemSlot.RING2);

        AbstractItem helmet = SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_HELMET.getItem();
        helmet.setEnchants(EnchantType.HEALTH_POINTS);
        helmet.setGems(AbsoluteStatType.HEALTH_POINTS);
        mage.addItem(helmet, ItemSlot.HELMET);

        AbstractItem shoulders = SpellweaverSetItems.AUTOMATED_SHOULDERGUARDS.getItem();
        shoulders.setEnchants(EnchantType.HEALTH_POINTS);
        shoulders.setGems(AbsoluteStatType.HEALTH_POINTS);
        mage.addItem(shoulders, ItemSlot.SHOULDERS);

        AbstractItem torso = SpellweaverSetItems.AUTOMATED_STERNUM_GUARD.getItem();
        torso.setEnchants(EnchantType.DAMAGE);
        torso.setGems(AbsoluteStatType.CRIT_VALUE);
        mage.addItem(torso, ItemSlot.TORSO);

        AbstractItem gloves = SpellweaverUniqueItems.REIGN_OF_TERROR.getItem();
        gloves.setEnchants(EnchantType.DAMAGE);
        gloves.setGems(AbsoluteStatType.DAMAGE);
        mage.addItem(gloves, ItemSlot.GLOVES);

        AbstractItem boots = SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_BOOTS.getItem();
        boots.setEnchants(EnchantType.DAMAGE);
        boots.addGems(AbsoluteStatType.CRIT_VALUE, 8);
        boots.addGems(AbsoluteStatType.MOVEMENT_SPEED, 2);
        mage.addItem(boots, ItemSlot.BOOTS);

        AbstractItem adornment = SpellweaverUniqueItems.SIGRISMARRS_ETERNAL_GRASP.getItem();
        adornment.setEnchants(EnchantType.DAMAGE);
        adornment.setGems(AbsoluteStatType.DAMAGE);
        mage.addItem(adornment, ItemSlot.WEAPON_ADORNMENT);

        AbstractItem twoHand = SpellweaverUniqueItems.GRIMACE_OF_THE_THUNDER_BEAST.getItem();
        twoHand.setEnchants(EnchantType.DAMAGE);
        twoHand.setGems(AbsoluteStatType.DAMAGE);
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

        Tonic tonic = new Tonic("Tonic of Vigor", AbsoluteStatType.HEALTH_POINTS, 156068.0);
        //mage.setTonic(tonic);
        Physic physic = new Physic("Advanced Physic of Vigor", OverallRelativeBuffType.HEALTH_POINTS, 0.18);
        //mage.setPhysic(physic);

        return mage;
    }

    public static Character zohan() {
        //2p destructor, sargon gloves, 2p seeker, q8, q9
        Character mage = new Character(CharacterClass.SPELLWEAVER, "2p destructor, sargon gloves, 2p seeker, q8, q9");

        AbstractItem amulet = SpellweaverUniqueItems.AMULET_OF_THE_KRAKEN.getItem();
        amulet.setEnchants(EnchantType.HEALTH_POINTS);
        amulet.setGems(AbsoluteStatType.HEALTH_POINTS);
        mage.addItem(amulet, ItemSlot.AMULET);

        AbstractItem cloak = SpellweaverMythicItem.ANCESTRAL_GLORY_CLOAK.getItem();
        cloak.setEnchants(EnchantType.DAMAGE);
        cloak.setGems(AbsoluteStatType.CRIT_VALUE);
        mage.addItem(cloak, ItemSlot.CLOAK);

        AbstractItem belt = SpellweaverUniqueItems.BELT_OF_ZEAL.getItem();
        belt.setEnchants(EnchantType.DAMAGE);
        belt.setGems(AbsoluteStatType.DAMAGE);
        mage.addItem(belt, ItemSlot.BELT);

        AbstractItem ring1 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring1.setEnchants(EnchantType.DAMAGE);
        ring1.setGems(AbsoluteStatType.DAMAGE);
        mage.addItem(ring1, ItemSlot.RING1);

        AbstractItem ring2 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring2.setEnchants(EnchantType.DAMAGE);
        Opal opal = new Opal(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0), new Gem(AbsoluteStatType.DAMAGE, 700.0), new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        ring2.addGems(opal, 10);
        mage.addItem(ring2, ItemSlot.RING2);

        AbstractItem helmet = SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_HELMET.getItem();
        helmet.setEnchants(EnchantType.HEALTH_POINTS);
        helmet.setGems(AbsoluteStatType.HEALTH_POINTS);
        mage.addItem(helmet, ItemSlot.HELMET);

        AbstractItem shoulders = SpellweaverSetItems.AUTOMATED_SHOULDERGUARDS.getItem();
        shoulders.setEnchants(EnchantType.HEALTH_POINTS);
        shoulders.setGems(AbsoluteStatType.HEALTH_POINTS);
        mage.addItem(shoulders, ItemSlot.SHOULDERS);

        AbstractItem torso = SpellweaverSetItems.AUTOMATED_STERNUM_GUARD.getItem();
        torso.setEnchants(EnchantType.DAMAGE);
        torso.setGems(AbsoluteStatType.CRIT_VALUE);
        mage.addItem(torso, ItemSlot.TORSO);

        AbstractItem gloves = SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_GLOVES.getItem();
        gloves.setEnchants(EnchantType.ATTACK_SPEED);
        gloves.setGems(AbsoluteStatType.ATTACK_SPEED);
        mage.addItem(gloves, ItemSlot.GLOVES);

        AbstractItem boots = SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_BOOTS.getItem();
        boots.setEnchants(EnchantType.DAMAGE);
        boots.addGems(AbsoluteStatType.CRIT_VALUE, 8);
        boots.addGems(AbsoluteStatType.MOVEMENT_SPEED, 2);
        mage.addItem(boots, ItemSlot.BOOTS);

        AbstractItem adornment = SpellweaverUniqueItems.STINGER.getItem();
        adornment.setEnchants(EnchantType.DAMAGE);
        adornment.setGems(AbsoluteStatType.DAMAGE);
        mage.addItem(adornment, ItemSlot.WEAPON_ADORNMENT);

        AbstractItem twoHand = SpellweaverUniqueItems.GRIMACE_OF_THE_THUNDER_BEAST.getItem();
        twoHand.setEnchants(EnchantType.DAMAGE);
        twoHand.setGems(AbsoluteStatType.DAMAGE);
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
        mage.addRuneTrinket(runeTrinket2, 2);

        RuneTrinket runeTrinket3 = new RuneTrinket();
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
        //runeTrinket5.addRune(new SpecialRune("Rune of Rising Vigor", Map.of(OverallRelativeBuffTypeEnum.MOVEMENT_SPEED, 0.10, OverallRelativeBuffTypeEnum.ATTACK_SPEED, 0.06), ""));
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

        Pet mortisPet = new Pet("Mortis Doll", Map.of(OverallRelativeBuffType.DAMAGE, 0.3, OverallRelativeBuffType.CRIT_VALUE, 0.3, OverallRelativeBuffType.HEALTH_POINTS, 0.175), "");
        mage.setPet(mortisPet);
        mage.setCollectorBagBuff(Map.of(OverallRelativeBuffType.HEALTH_POINTS, 0.33, OverallRelativeBuffType.RESISTANCE, 0.15, OverallRelativeBuffType.DAMAGE, 0.06, OverallRelativeBuffType.BLOCK_VALUE, 0.02));

        Tonic tonic = new Tonic("Tonic of Vigor", AbsoluteStatType.HEALTH_POINTS, 156068.0);
        //mage.setTonic(tonic);
        Physic physic = new Physic("Advanced Physic of Vigor", OverallRelativeBuffType.HEALTH_POINTS, 0.18);
        //mage.setPhysic(physic);

        return mage;
    }

    public static Character mortisMage1() {
        //prem belt, mob gloves, seeker boots
        Character mage = new Character(CharacterClass.SPELLWEAVER);

        AbstractItem amulet = SpellweaverSetItems.AMULET_OF_DEATH.getItem();
        amulet.setEnchants(EnchantType.HEALTH_POINTS);
        amulet.setGems(AbsoluteStatType.HEALTH_POINTS);
        mage.addItem(amulet, ItemSlot.AMULET);

        AbstractItem cloak = SpellweaverMythicItem.ANCESTRAL_GLORY_CLOAK.getItem();
        cloak.setEnchants(EnchantType.DAMAGE);
        cloak.setGems(AbsoluteStatType.DAMAGE);
        mage.addItem(cloak, ItemSlot.CLOAK);

        AbstractItem belt = SpellweaverUniqueItems.BELT_OF_ZEAL.getItem();
        belt.setEnchants(EnchantType.DAMAGE);
        belt.setGems(AbsoluteStatType.DAMAGE);
        mage.addItem(belt, ItemSlot.BELT);

        AbstractItem ring1 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring1.setEnchants(EnchantType.HEALTH_POINTS);
        ring1.setGems(AbsoluteStatType.HEALTH_POINTS);
        mage.addItem(ring1, ItemSlot.RING1);

        AbstractItem ring2 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring2.setEnchants(EnchantType.DAMAGE);
        Opal opal = new Opal(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0), new Gem(AbsoluteStatType.DAMAGE, 700.0), new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        ring2.addGems(opal, 10);
        mage.addItem(ring2, ItemSlot.RING2);

        AbstractItem helmet = SpellweaverSetItems.CAP_OF_DEATH.getItem();
        helmet.setEnchants(EnchantType.HEALTH_POINTS);
        helmet.setGems(AbsoluteStatType.HEALTH_POINTS);
        mage.addItem(helmet, ItemSlot.HELMET);

        AbstractItem shoulders = SpellweaverSetItems.SHOULDERS_OF_THE_END.getItem();
        shoulders.setEnchants(EnchantType.HEALTH_POINTS);
        shoulders.setEnchants(EnchantType.HEALTH_POINTS);
        mage.addItem(shoulders, ItemSlot.SHOULDERS);

        AbstractItem torso = SpellweaverUniqueItems.RESEARCHERS_COAT.getItem();
        torso.setEnchants(EnchantType.HEALTH_POINTS);
        torso.addGems(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0),6);
        torso.addGems(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0),4);
        mage.addItem(torso, ItemSlot.TORSO);

        AbstractItem gloves = SpellweaverSetItems.GLOVES_OF_THE_FLAME_CONQUEROR.getItem();
        gloves.setEnchants(EnchantType.ATTACK_SPEED);
        gloves.setGems(AbsoluteStatType.ATTACK_SPEED);
        mage.addItem(gloves, ItemSlot.GLOVES);

        AbstractItem boots = SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_BOOTS.getItem();
        boots.setEnchants(EnchantType.DAMAGE);
        boots.setGems(AbsoluteStatType.CRIT_VALUE);
        mage.addItem(boots, ItemSlot.BOOTS);

        AbstractItem adornment = SpellweaverUniqueItems.STINGER.getItem();
        adornment.setGems(AbsoluteStatType.CRIT_VALUE);
        adornment.setGems(AbsoluteStatType.CRIT_VALUE);
        mage.addItem(adornment, ItemSlot.WEAPON_ADORNMENT);

        AbstractItem twoHand = SpellweaverUniqueItems.GRIMACE_OF_THE_THUNDER_BEAST.getItem();
        twoHand.setEnchants(EnchantType.DAMAGE);
        twoHand.setGems(AbsoluteStatType.DAMAGE);
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

        Pet mortisPet = new Pet("Mortis Doll", Map.of(OverallRelativeBuffType.HEALTH_POINTS, 0.48, OverallRelativeBuffType.ARMOR, 0.18), "");
        mage.setPet(mortisPet);
        mage.setCollectorBagBuff(Map.of(OverallRelativeBuffType.HEALTH_POINTS, 0.33, OverallRelativeBuffType.RESISTANCE, 0.15, OverallRelativeBuffType.DAMAGE, 0.06, OverallRelativeBuffType.BLOCK_VALUE, 0.02));

        Tonic tonic = new Tonic("Tonic of Vigor", AbsoluteStatType.HEALTH_POINTS, 156068.0);
        mage.setTonic(tonic);
        Physic physic = new Physic("Advanced Physic of Vigor", OverallRelativeBuffType.HEALTH_POINTS, 0.18);
        mage.setPhysic(physic);

        return mage;
    }

    public static Character mortisMage2() {
        //prem belt, mob gloves, briga boots
        Character mage = new Character(CharacterClass.SPELLWEAVER);

        AbstractItem amulet = SpellweaverSetItems.AMULET_OF_DEATH.getItem();
        amulet.setEnchants(EnchantType.HEALTH_POINTS);
        amulet.setGems(AbsoluteStatType.HEALTH_POINTS);
        mage.addItem(amulet, ItemSlot.AMULET);

        AbstractItem cloak = SpellweaverMythicItem.ANCESTRAL_GLORY_CLOAK.getItem();
        cloak.setEnchants(EnchantType.DAMAGE);
        cloak.setGems(AbsoluteStatType.DAMAGE);
        mage.addItem(cloak, ItemSlot.CLOAK);

        AbstractItem belt = SpellweaverUniqueItems.BELT_OF_ZEAL.getItem();
        belt.setEnchants(EnchantType.DAMAGE);
        belt.setGems(AbsoluteStatType.DAMAGE);
        mage.addItem(belt, ItemSlot.BELT);

        AbstractItem ring1 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring1.setEnchants(EnchantType.HEALTH_POINTS);
        ring1.setGems(AbsoluteStatType.HEALTH_POINTS);
        mage.addItem(ring1, ItemSlot.RING1);

        AbstractItem ring2 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring2.setEnchants(EnchantType.DAMAGE);
        Opal opal = new Opal(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0), new Gem(AbsoluteStatType.DAMAGE, 700.0), new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        ring2.addGems(opal, 10);
        mage.addItem(ring2, ItemSlot.RING2);

        AbstractItem helmet = SpellweaverSetItems.CAP_OF_DEATH.getItem();
        helmet.setEnchants(EnchantType.HEALTH_POINTS);
        helmet.setGems(AbsoluteStatType.HEALTH_POINTS);
        mage.addItem(helmet, ItemSlot.HELMET);

        AbstractItem shoulders = SpellweaverSetItems.SHOULDERS_OF_THE_END.getItem();
        shoulders.setEnchants(EnchantType.HEALTH_POINTS);
        shoulders.setEnchants(EnchantType.HEALTH_POINTS);
        mage.addItem(shoulders, ItemSlot.SHOULDERS);

        AbstractItem torso = SpellweaverUniqueItems.RESEARCHERS_COAT.getItem();
        torso.setEnchants(EnchantType.HEALTH_POINTS);
        torso.addGems(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0),6);
        torso.addGems(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0),4);
        mage.addItem(torso, ItemSlot.TORSO);

        AbstractItem gloves = SpellweaverSetItems.GLOVES_OF_THE_FLAME_CONQUEROR.getItem();
        gloves.setEnchants(EnchantType.ATTACK_SPEED);
        gloves.setGems(AbsoluteStatType.ATTACK_SPEED);
        mage.addItem(gloves, ItemSlot.GLOVES);

        AbstractItem boots = SpellweaverUniqueItems.RESEARCHERS_BOOTS.getItem();
        boots.setEnchants(EnchantType.CRIT_VALUE);
        boots.setGems(AbsoluteStatType.CRIT_VALUE);
        mage.addItem(boots, ItemSlot.BOOTS);

        AbstractItem adornment = SpellweaverUniqueItems.STINGER.getItem();
        adornment.setGems(AbsoluteStatType.DAMAGE);
        adornment.setGems(AbsoluteStatType.DAMAGE);
        mage.addItem(adornment, ItemSlot.WEAPON_ADORNMENT);

        AbstractItem twoHand = SpellweaverUniqueItems.GRIMACE_OF_THE_THUNDER_BEAST.getItem();
        twoHand.setEnchants(EnchantType.DAMAGE);
        twoHand.setGems(AbsoluteStatType.DAMAGE);
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

        Pet mortisPet = new Pet("Mortis Doll", Map.of(OverallRelativeBuffType.HEALTH_POINTS, 0.48, OverallRelativeBuffType.ARMOR, 0.18, OverallRelativeBuffType.DAMAGE, 0.2), "");
        mage.setPet(mortisPet);
        mage.setCollectorBagBuff(Map.of(OverallRelativeBuffType.HEALTH_POINTS, 0.33, OverallRelativeBuffType.RESISTANCE, 0.15, OverallRelativeBuffType.DAMAGE, 0.06, OverallRelativeBuffType.BLOCK_VALUE, 0.02));

        Tonic tonic = new Tonic("Tonic of Vigor", AbsoluteStatType.HEALTH_POINTS, 156068.0);
        mage.setTonic(tonic);
        Physic physic = new Physic("Advanced Physic of Vigor", OverallRelativeBuffType.HEALTH_POINTS, 0.18);
        mage.setPhysic(physic);

        return mage;
    }

    public static Character mortisMage3() {
        //prem belt, sargon gloves, mob boots
        Character mage = new Character(CharacterClass.SPELLWEAVER);

        AbstractItem amulet = SpellweaverSetItems.AMULET_OF_DEATH.getItem();
        amulet.setEnchants(EnchantType.HEALTH_POINTS);
        amulet.setGems(AbsoluteStatType.HEALTH_POINTS);
        mage.addItem(amulet, ItemSlot.AMULET);

        AbstractItem cloak = SpellweaverMythicItem.ANCESTRAL_GLORY_CLOAK.getItem();
        cloak.setEnchants(EnchantType.ATTACK_SPEED);
        cloak.setGems(AbsoluteStatType.ATTACK_SPEED);
        mage.addItem(cloak, ItemSlot.CLOAK);

        AbstractItem belt = SpellweaverUniqueItems.BELT_OF_ZEAL.getItem();
        belt.setEnchants(EnchantType.DAMAGE);
        belt.setGems(AbsoluteStatType.DAMAGE);
        mage.addItem(belt, ItemSlot.BELT);

        AbstractItem ring1 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring1.setEnchants(EnchantType.HEALTH_POINTS);
        ring1.setGems(AbsoluteStatType.HEALTH_POINTS);
        mage.addItem(ring1, ItemSlot.RING1);

        AbstractItem ring2 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring2.setEnchants(EnchantType.DAMAGE);
        Opal opal = new Opal(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0), new Gem(AbsoluteStatType.DAMAGE, 700.0), new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        ring2.addGems(opal, 10);
        mage.addItem(ring2, ItemSlot.RING2);

        AbstractItem helmet = SpellweaverSetItems.CAP_OF_DEATH.getItem();
        helmet.setEnchants(EnchantType.HEALTH_POINTS);
        helmet.setGems(AbsoluteStatType.HEALTH_POINTS);
        mage.addItem(helmet, ItemSlot.HELMET);

        AbstractItem shoulders = SpellweaverSetItems.SHOULDERS_OF_THE_END.getItem();
        shoulders.setEnchants(EnchantType.HEALTH_POINTS);
        shoulders.setEnchants(EnchantType.HEALTH_POINTS);
        mage.addItem(shoulders, ItemSlot.SHOULDERS);

        AbstractItem torso = SpellweaverUniqueItems.RESEARCHERS_COAT.getItem();
        torso.setEnchants(EnchantType.HEALTH_POINTS);
        torso.addGems(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0),2);
        torso.addGems(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0),6);
        torso.addGems(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17),2);
        mage.addItem(torso, ItemSlot.TORSO);

        AbstractItem gloves = SpellweaverUniqueItems.REIGN_OF_TERROR.getItem();
        gloves.setEnchants(EnchantType.DAMAGE);
        gloves.setGems(AbsoluteStatType.DAMAGE);
        mage.addItem(gloves, ItemSlot.GLOVES);

        AbstractItem boots = SpellweaverSetItems.BOOTS_OF_THE_FLAME_CONQUEROR.getItem();
        boots.setEnchants(EnchantType.CRIT_VALUE);
        boots.setGems(AbsoluteStatType.CRIT_VALUE);
        mage.addItem(boots, ItemSlot.BOOTS);

        AbstractItem adornment = SpellweaverUniqueItems.STINGER.getItem();
        adornment.setGems(AbsoluteStatType.DAMAGE);
        adornment.setGems(AbsoluteStatType.DAMAGE);
        mage.addItem(adornment, ItemSlot.WEAPON_ADORNMENT);

        AbstractItem twoHand = SpellweaverUniqueItems.GRIMACE_OF_THE_THUNDER_BEAST.getItem();
        twoHand.setEnchants(EnchantType.DAMAGE);
        twoHand.setGems(AbsoluteStatType.DAMAGE);
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

        Pet mortisPet = new Pet("Mortis Doll", Map.of(OverallRelativeBuffType.HEALTH_POINTS, 0.38, OverallRelativeBuffType.ARMOR, 0.18), "");
        mage.setPet(mortisPet);
        mage.setCollectorBagBuff(Map.of(OverallRelativeBuffType.HEALTH_POINTS, 0.33, OverallRelativeBuffType.RESISTANCE, 0.15, OverallRelativeBuffType.DAMAGE, 0.06, OverallRelativeBuffType.BLOCK_VALUE, 0.02));

        Tonic tonic = new Tonic("Tonic of Vigor", AbsoluteStatType.HEALTH_POINTS, 156068.0);
        mage.setTonic(tonic);
        Physic physic = new Physic("Advanced Physic of Vigor", OverallRelativeBuffType.HEALTH_POINTS, 0.18);
        mage.setPhysic(physic);

        return mage;
    }

    public static Character mortisMage4() {
        //prem belt, sargon gloves, mob boots
        Character mage = new Character(CharacterClass.SPELLWEAVER);

        AbstractItem amulet = SpellweaverSetItems.AMULET_OF_DEATH.getItem();
        amulet.setEnchants(EnchantType.HEALTH_POINTS);
        amulet.setGems(AbsoluteStatType.HEALTH_POINTS);
        mage.addItem(amulet, ItemSlot.AMULET);

        AbstractItem cloak = SpellweaverMythicItem.ANCESTRAL_GLORY_CLOAK.getItem();
        cloak.setEnchants(EnchantType.ATTACK_SPEED);
        cloak.setGems(AbsoluteStatType.ATTACK_SPEED);
        mage.addItem(cloak, ItemSlot.CLOAK);

        AbstractItem belt = SpellweaverSetItems.AUTOMATED_BELT.getItem();
        belt.setEnchants(EnchantType.DAMAGE);
        belt.setGems(AbsoluteStatType.DAMAGE);
        mage.addItem(belt, ItemSlot.BELT);

        AbstractItem ring1 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring1.setEnchants(EnchantType.HEALTH_POINTS);
        ring1.setGems(AbsoluteStatType.HEALTH_POINTS);
        mage.addItem(ring1, ItemSlot.RING1);

        AbstractItem ring2 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring2.setEnchants(EnchantType.DAMAGE);
        Opal opal = new Opal(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0), new Gem(AbsoluteStatType.DAMAGE, 700.0), new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        ring2.addGems(opal, 10);
        mage.addItem(ring2, ItemSlot.RING2);

        AbstractItem helmet = SpellweaverSetItems.CAP_OF_DEATH.getItem();
        helmet.setEnchants(EnchantType.HEALTH_POINTS);
        helmet.setGems(AbsoluteStatType.HEALTH_POINTS);
        mage.addItem(helmet, ItemSlot.HELMET);

        AbstractItem shoulders = SpellweaverSetItems.SHOULDERS_OF_THE_END.getItem();
        shoulders.setEnchants(EnchantType.HEALTH_POINTS);
        shoulders.setEnchants(EnchantType.HEALTH_POINTS);
        mage.addItem(shoulders, ItemSlot.SHOULDERS);

        AbstractItem torso = SpellweaverUniqueItems.RESEARCHERS_COAT.getItem();
        torso.setEnchants(EnchantType.HEALTH_POINTS);
        torso.addGems(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0),2);
        torso.addGems(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0),6);
        torso.addGems(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17),2);
        mage.addItem(torso, ItemSlot.TORSO);

        AbstractItem gloves = SpellweaverSetItems.AUTOMATED_ARMGUARDS.getItem();
        gloves.setEnchants(EnchantType.DAMAGE);
        gloves.setGems(AbsoluteStatType.DAMAGE);
        mage.addItem(gloves, ItemSlot.GLOVES);

        AbstractItem boots = SpellweaverSetItems.BOOTS_OF_THE_FLAME_CONQUEROR.getItem();
        boots.setEnchants(EnchantType.CRIT_VALUE);
        boots.setGems(AbsoluteStatType.CRIT_VALUE);
        mage.addItem(boots, ItemSlot.BOOTS);

        AbstractItem adornment = SpellweaverUniqueItems.STINGER.getItem();
        adornment.setGems(AbsoluteStatType.DAMAGE);
        adornment.setGems(AbsoluteStatType.DAMAGE);
        mage.addItem(adornment, ItemSlot.WEAPON_ADORNMENT);

        AbstractItem twoHand = SpellweaverUniqueItems.GRIMACE_OF_THE_THUNDER_BEAST.getItem();
        twoHand.setEnchants(EnchantType.DAMAGE);
        twoHand.setGems(AbsoluteStatType.DAMAGE);
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

        Pet mortisPet = new Pet("Mortis Doll", Map.of(OverallRelativeBuffType.HEALTH_POINTS, 0.38, OverallRelativeBuffType.ARMOR, 0.18), "");
        mage.setPet(mortisPet);
        mage.setCollectorBagBuff(Map.of(OverallRelativeBuffType.HEALTH_POINTS, 0.33, OverallRelativeBuffType.RESISTANCE, 0.15, OverallRelativeBuffType.DAMAGE, 0.06, OverallRelativeBuffType.BLOCK_VALUE, 0.02));

        Tonic tonic = new Tonic("Tonic of Vigor", AbsoluteStatType.HEALTH_POINTS, 156068.0);
        mage.setTonic(tonic);
        Physic physic = new Physic("Advanced Physic of Vigor", OverallRelativeBuffType.HEALTH_POINTS, 0.18);
        mage.setPhysic(physic);

        return mage;
    }

    public static Character bghMage() {
        Character mage = new Character(CharacterClass.SPELLWEAVER);

        Map<AbsoluteStatType, Double> amuletBaseStats = new HashMap<>();
        amuletBaseStats.put(AbsoluteStatType.CRIT_VALUE, 1731.466);
        amuletBaseStats.put(AbsoluteStatType.HEALTH_POINTS, 24127.76);
        UniqueItem amulet = SpellweaverUniqueItems.AMULET_OF_THE_KRAKEN.getItem();
        amulet.setBaseStats(amuletBaseStats);
        amulet.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        amulet.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        amulet.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        amulet.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        mage.addItem(amulet, ItemSlot.AMULET);

        MythicItem cloak = SpellweaverMythicItem.ANCESTRAL_GLORY_CLOAK.getItem();
        cloak.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        mage.addItem(cloak, ItemSlot.CLOAK);

        Map<AbsoluteStatType, Double> beltBaseStats = new HashMap<>();
        beltBaseStats.put(AbsoluteStatType.DAMAGE, 1630.885);
        beltBaseStats.put(AbsoluteStatType.HEALTH_POINTS, 20072.654);
        beltBaseStats.put(AbsoluteStatType.RESISTANCE, 1679.873);
        UniqueItem belt = SpellweaverUniqueItems.BELT_OF_ZEAL.getItem();
        belt.setBaseStats(beltBaseStats);
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
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
        mage.addItem(belt, ItemSlot.BELT);

        MythicItem ring1 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
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
        mage.addItem(ring1, ItemSlot.RING1);
        MythicItem ring2 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring2.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        Opal opal = new Opal(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0), new Gem(AbsoluteStatType.DAMAGE, 700.0), new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
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
        mage.addItem(ring2, ItemSlot.RING2);

        Map<AbsoluteStatType, Double> helmetBaseStats = new HashMap<>();
        helmetBaseStats.put(AbsoluteStatType.DAMAGE, 1512.772);
        helmetBaseStats.put(AbsoluteStatType.CRIT_VALUE, 1394.209);
        helmetBaseStats.put(AbsoluteStatType.HEALTH_POINTS, 18258.694);
        SetItem helmet = SpellweaverSetItems.SARGONS_HORNS.getItem();
        helmet.setBaseStats(helmetBaseStats);
        helmet.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.4452));
        helmet.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44364));
        helmet.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44483));
        helmet.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44430));
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
        mage.addItem(helmet, ItemSlot.HELMET);

        Map<AbsoluteStatType, Double> shouldersBaseStats = new HashMap<>();
        shouldersBaseStats.put(AbsoluteStatType.DAMAGE, 1876.316);
        shouldersBaseStats.put(AbsoluteStatType.CRIT_VALUE, 1282.912);
        shouldersBaseStats.put(AbsoluteStatType.ANDERMAGIC_RESISTANCE, 3443.896);
        SetItem shoulders = SpellweaverSetItems.SARGONS_PAULDRONS.getItem();
        shoulders.setBaseStats(shouldersBaseStats);
        shoulders.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44757));
        shoulders.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44766));
        shoulders.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44757));
        shoulders.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44750));
        shoulders.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        mage.addItem(shoulders, ItemSlot.SHOULDERS);

        Map<AbsoluteStatType, Double> torsoBaseStats = new HashMap<>();
        torsoBaseStats.put(AbsoluteStatType.DAMAGE, 1631.657);
        torsoBaseStats.put(AbsoluteStatType.HEALTH_POINTS, 14232.794);
        torsoBaseStats.put(AbsoluteStatType.ARMOR, 1639.716);
        SetItem torso = SpellweaverSetItems.SARGONS_TORSO.getItem();
        torso.setBaseStats(torsoBaseStats);
        torso.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44263));
        torso.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44415));
        torso.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44382));
        torso.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44237));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        mage.addItem(torso, ItemSlot.TORSO);

        Map<AbsoluteStatType, Double> glovesBaseStats = new HashMap<>();
        glovesBaseStats.put(AbsoluteStatType.DAMAGE, 1514.933);
        glovesBaseStats.put(AbsoluteStatType.ATTACK_SPEED, 0.053);
        glovesBaseStats.put(AbsoluteStatType.CRIT_VALUE, 1494.107);
        SetItem gloves = SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_GLOVES.getItem();
        gloves.setBaseStats(glovesBaseStats);
        gloves.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44743));
        gloves.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44768));
        gloves.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44738));
        gloves.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44766));
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
        mage.addItem(gloves, ItemSlot.GLOVES);

        Map<AbsoluteStatType, Double> bootsBaseStats = new HashMap<>();
        bootsBaseStats.put(AbsoluteStatType.DAMAGE, 1510.415);
        bootsBaseStats.put(AbsoluteStatType.MOVEMENT_SPEED, 1.113);
        bootsBaseStats.put(AbsoluteStatType.CRIT_VALUE, 1168.091);
        SetItem boots = SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_BOOTS.getItem();
        boots.setBaseStats(bootsBaseStats);
        boots.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44760));
        boots.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44763));
        boots.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44762));
        boots.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44751));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        mage.addItem(boots, ItemSlot.BOOTS);

        Map<AbsoluteStatType, Double> adornmentBaseStats = new HashMap<>();
        adornmentBaseStats.put(AbsoluteStatType.DAMAGE, 1870.52);
        adornmentBaseStats.put(AbsoluteStatType.CRIT_VALUE, 2100.146);
        UniqueItem adornment = SpellweaverUniqueItems.SIGRISMARRS_ETERNAL_GRASP.getItem();
        adornment.setBaseStats(adornmentBaseStats);
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        mage.addItem(adornment, ItemSlot.WEAPON_ADORNMENT);

        Map<AbsoluteStatType, Double> twoHandBaseStats = new HashMap<>();
        twoHandBaseStats.put(AbsoluteStatType.DAMAGE, 24570.982);
        twoHandBaseStats.put(AbsoluteStatType.CRIT_VALUE, 3321.515);
        UniqueItem twoHand = SpellweaverUniqueItems.GRIMACE_OF_THE_THUNDER_BEAST.getItem();
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

        Pet mortisPet = new Pet("Mortis Doll", Map.of(OverallRelativeBuffType.ATTACK_SPEED, 0.3, OverallRelativeBuffType.MANA, 0.3, OverallRelativeBuffType.DAMAGE, 0.3, OverallRelativeBuffType.HEALTH_POINTS, 10.0), "");
        mage.setPet(mortisPet);
        mage.setCollectorBagBuff(Map.of(OverallRelativeBuffType.HEALTH_POINTS, 0.33, OverallRelativeBuffType.RESISTANCE, 0.15, OverallRelativeBuffType.DAMAGE, 0.06, OverallRelativeBuffType.BLOCK_VALUE, 0.02));

        Tonic tonic = new Tonic("Tonic of Vigor", AbsoluteStatType.DAMAGE, 10496.0);
        //mage.setTonic(tonic);
        Physic physic = new Physic("Advanced Physic of Vigor", OverallRelativeBuffType.DAMAGE, 0.18);
        //mage.setPhysic(physic);


        return mage;
    }

    public static Character q5Mage() {
        Character mage = new Character(CharacterClass.SPELLWEAVER);

        Map<AbsoluteStatType, Double> amuletBaseStats = new HashMap<>();
        amuletBaseStats.put(AbsoluteStatType.DAMAGE, 1495.899);
        amuletBaseStats.put(AbsoluteStatType.MOVEMENT_SPEED, 0.460);
        amuletBaseStats.put(AbsoluteStatType.HEALTH_POINTS, 23093.384);
        AbstractItem amulet = SpellweaverUniqueItems.SARGONS_SHADOW_AMULET.getItem();
        amulet.setBaseStats(amuletBaseStats);
        amulet.setEnchants(EnchantType.HEALTH_POINTS);
        amulet.setGems(AbsoluteStatType.DAMAGE);
        mage.addItem(amulet, ItemSlot.AMULET);

        MythicItem cloak = SpellweaverMythicItem.ANCESTRAL_GLORY_CLOAK.getItem();
        cloak.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        mage.addItem(cloak, ItemSlot.CLOAK);

        Map<AbsoluteStatType, Double> beltBaseStats = new HashMap<>();
        beltBaseStats.put(AbsoluteStatType.DAMAGE, 1630.885);
        beltBaseStats.put(AbsoluteStatType.HEALTH_POINTS, 20072.654);
        beltBaseStats.put(AbsoluteStatType.RESISTANCE, 1679.873);
        UniqueItem belt = SpellweaverUniqueItems.BELT_OF_ZEAL.getItem();
        belt.setBaseStats(beltBaseStats);
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
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
        mage.addItem(belt, ItemSlot.BELT);

        MythicItem ring1 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring1.setEnchants(EnchantType.HEALTH_POINTS);
        ring1.setGems(AbsoluteStatType.HEALTH_POINTS);
        mage.addItem(ring1, ItemSlot.RING1);
        MythicItem ring2 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring2.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        Opal opal = new Opal(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0), new Gem(AbsoluteStatType.DAMAGE, 700.0), new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
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
        mage.addItem(ring2, ItemSlot.RING2);

        Map<AbsoluteStatType, Double> helmetBaseStats = new HashMap<>();
        helmetBaseStats.put(AbsoluteStatType.MOVEMENT_SPEED, 0.427);
        helmetBaseStats.put(AbsoluteStatType.HEALTH_POINTS, 20345.704);
        helmetBaseStats.put(AbsoluteStatType.POISON_RESISTANCE, 4145.679);
        AbstractItem helmet = SpellweaverSetItems.POISON_EXTINGUISHER_HAT.getItem();
        helmet.setBaseStats(helmetBaseStats);
        helmet.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.4452));
        helmet.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44364));
        helmet.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44483));
        helmet.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44430));
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
        mage.addItem(helmet, ItemSlot.HELMET);

        AbstractItem shoulders = SpellweaverUniqueItems.ROYAL_PAULDRONS_OF_SINGULARITY.getItem();
        shoulders.setEnchants(EnchantType.CRIT_VALUE);
        shoulders.setGems(AbsoluteStatType.CRIT_VALUE);
        mage.addItem(shoulders, ItemSlot.SHOULDERS);

        Map<AbsoluteStatType, Double> torsoBaseStats = new HashMap<>();
        torsoBaseStats.put(AbsoluteStatType.DAMAGE, 1631.657);
        torsoBaseStats.put(AbsoluteStatType.HEALTH_POINTS, 14232.794);
        torsoBaseStats.put(AbsoluteStatType.ARMOR, 1639.716);
        SetItem torso = SpellweaverSetItems.SARGONS_TORSO.getItem();
        torso.setBaseStats(torsoBaseStats);
        torso.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44263));
        torso.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44415));
        torso.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44382));
        torso.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44237));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        mage.addItem(torso, ItemSlot.TORSO);

        Map<AbsoluteStatType, Double> glovesBaseStats = new HashMap<>();
        glovesBaseStats.put(AbsoluteStatType.ATTACK_SPEED, 0.054);
        glovesBaseStats.put(AbsoluteStatType.MOVEMENT_SPEED, 0.424);
        glovesBaseStats.put(AbsoluteStatType.POISON_RESISTANCE, 3899.42);
        SetItem gloves = SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_GLOVES.getItem();
        gloves.setBaseStats(glovesBaseStats);
        gloves.setEnchants(EnchantType.ATTACK_SPEED);
        gloves.setGems(AbsoluteStatType.ATTACK_SPEED);
        mage.addItem(gloves, ItemSlot.GLOVES);

        Map<AbsoluteStatType, Double> bootsBaseStats = new HashMap<>();
        bootsBaseStats.put(AbsoluteStatType.MOVEMENT_SPEED, 1.198);
        bootsBaseStats.put(AbsoluteStatType.HEALTH_POINTS, 12495.802);
        bootsBaseStats.put(AbsoluteStatType.POISON_RESISTANCE, 3957.135);
        SetItem boots = SpellweaverSetItems.POISON_EXTINGUISHER_BOOTS.getItem();
        boots.setBaseStats(bootsBaseStats);
        boots.setEnchants(EnchantType.HEALTH_POINTS);
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        mage.addItem(boots, ItemSlot.BOOTS);

        Map<AbsoluteStatType, Double> adornmentBaseStats = new HashMap<>();
        adornmentBaseStats.put(AbsoluteStatType.DAMAGE, 1870.52);
        adornmentBaseStats.put(AbsoluteStatType.CRIT_VALUE, 2100.146);
        UniqueItem adornment = SpellweaverUniqueItems.SIGRISMARRS_ETERNAL_GRASP.getItem();
        adornment.setBaseStats(adornmentBaseStats);
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        mage.addItem(adornment, ItemSlot.WEAPON_ADORNMENT);

        Map<AbsoluteStatType, Double> twoHandBaseStats = new HashMap<>();
        twoHandBaseStats.put(AbsoluteStatType.DAMAGE, 24570.982);
        twoHandBaseStats.put(AbsoluteStatType.CRIT_VALUE, 3321.515);
        UniqueItem twoHand = SpellweaverUniqueItems.GRIMACE_OF_THE_THUNDER_BEAST.getItem();
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
        runeTrinket5.addRune(new SpecialRune("Rune of Rising Vigor", Map.of(OverallRelativeBuffType.MOVEMENT_SPEED, 0.10, OverallRelativeBuffType.ATTACK_SPEED, 0.06), ""));
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

        mage.setEssence(1.50);

        Pet mortisPet = new Pet("Mortis Doll", Map.of(OverallRelativeBuffType.DAMAGE, 0.1, OverallRelativeBuffType.HEALTH_POINTS, 0.10), "");
        mage.setPet(mortisPet);
        mage.setCollectorBagBuff(Map.of(OverallRelativeBuffType.HEALTH_POINTS, 0.33, OverallRelativeBuffType.RESISTANCE, 0.15, OverallRelativeBuffType.DAMAGE, 0.06, OverallRelativeBuffType.BLOCK_VALUE, 0.02));

        Tonic tonic = new Tonic("Tonic of Vigor", AbsoluteStatType.DAMAGE, 10496.0);
        mage.setTonic(tonic);
        Physic physic = new Physic("Advanced Physic of Vigor", OverallRelativeBuffType.DAMAGE, 0.18);
        mage.setPhysic(physic);


        return mage;
    }

    public static Character bghMage10msrunes() {
        Character mage = new Character(CharacterClass.SPELLWEAVER);

        Map<AbsoluteStatType, Double> amuletBaseStats = new HashMap<>();
        amuletBaseStats.put(AbsoluteStatType.CRIT_VALUE, 1731.466);
        amuletBaseStats.put(AbsoluteStatType.HEALTH_POINTS, 24127.76);
        UniqueItem amulet = SpellweaverUniqueItems.AMULET_OF_THE_KRAKEN.getItem();
        amulet.setBaseStats(amuletBaseStats);
        amulet.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        amulet.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        amulet.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        amulet.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        mage.addItem(amulet, ItemSlot.AMULET);

        MythicItem cloak = SpellweaverMythicItem.ANCESTRAL_GLORY_CLOAK.getItem();
        cloak.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        Opal opal = new Opal(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0), new Gem(AbsoluteStatType.DAMAGE, 700.0), new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
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
        mage.addItem(cloak, ItemSlot.CLOAK);

        Map<AbsoluteStatType, Double> beltBaseStats = new HashMap<>();
        beltBaseStats.put(AbsoluteStatType.DAMAGE, 1630.885);
        beltBaseStats.put(AbsoluteStatType.HEALTH_POINTS, 20072.654);
        beltBaseStats.put(AbsoluteStatType.RESISTANCE, 1679.873);
        UniqueItem belt = SpellweaverUniqueItems.BELT_OF_ZEAL.getItem();
        belt.setBaseStats(beltBaseStats);
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
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
        mage.addItem(belt, ItemSlot.BELT);

        MythicItem ring1 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring1.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        ring1.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        ring1.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        ring1.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        mage.addItem(ring1, ItemSlot.RING1);
        MythicItem ring2 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring2.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        ring2.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        ring2.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        ring2.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        ring2.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        mage.addItem(ring2, ItemSlot.RING2);

        Map<AbsoluteStatType, Double> helmetBaseStats = new HashMap<>();
        helmetBaseStats.put(AbsoluteStatType.DAMAGE, 1512.772);
        helmetBaseStats.put(AbsoluteStatType.CRIT_VALUE, 1394.209);
        helmetBaseStats.put(AbsoluteStatType.HEALTH_POINTS, 18258.694);
        SetItem helmet = SpellweaverSetItems.SARGONS_HORNS.getItem();
        helmet.setBaseStats(helmetBaseStats);
        helmet.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.4452));
        helmet.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44364));
        helmet.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44483));
        helmet.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44430));
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
        mage.addItem(helmet, ItemSlot.HELMET);

        Map<AbsoluteStatType, Double> shouldersBaseStats = new HashMap<>();
        shouldersBaseStats.put(AbsoluteStatType.DAMAGE, 1876.316);
        shouldersBaseStats.put(AbsoluteStatType.CRIT_VALUE, 1282.912);
        shouldersBaseStats.put(AbsoluteStatType.ANDERMAGIC_RESISTANCE, 3443.896);
        SetItem shoulders = SpellweaverSetItems.SARGONS_PAULDRONS.getItem();
        shoulders.setBaseStats(shouldersBaseStats);
        shoulders.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        shoulders.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        shoulders.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        shoulders.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        shoulders.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        shoulders.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        shoulders.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        shoulders.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        shoulders.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        shoulders.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        shoulders.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        shoulders.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        shoulders.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        shoulders.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        mage.addItem(shoulders, ItemSlot.SHOULDERS);

        Map<AbsoluteStatType, Double> torsoBaseStats = new HashMap<>();
        torsoBaseStats.put(AbsoluteStatType.DAMAGE, 1631.657);
        torsoBaseStats.put(AbsoluteStatType.HEALTH_POINTS, 14232.794);
        torsoBaseStats.put(AbsoluteStatType.ARMOR, 1639.716);
        SetItem torso = SpellweaverSetItems.SARGONS_TORSO.getItem();
        torso.setBaseStats(torsoBaseStats);
        torso.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44263));
        torso.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44415));
        torso.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44382));
        torso.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44237));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        mage.addItem(torso, ItemSlot.TORSO);

        Map<AbsoluteStatType, Double> glovesBaseStats = new HashMap<>();
        glovesBaseStats.put(AbsoluteStatType.DAMAGE, 1514.933);
        glovesBaseStats.put(AbsoluteStatType.ATTACK_SPEED, 0.053);
        glovesBaseStats.put(AbsoluteStatType.CRIT_VALUE, 1494.107);
        SetItem gloves = SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_GLOVES.getItem();
        gloves.setBaseStats(glovesBaseStats);
        gloves.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44743));
        gloves.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44768));
        gloves.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44738));
        gloves.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44766));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        mage.addItem(gloves, ItemSlot.GLOVES);

        Map<AbsoluteStatType, Double> bootsBaseStats = new HashMap<>();
        bootsBaseStats.put(AbsoluteStatType.DAMAGE, 1510.415);
        bootsBaseStats.put(AbsoluteStatType.MOVEMENT_SPEED, 1.113);
        bootsBaseStats.put(AbsoluteStatType.CRIT_VALUE, 1168.091);
        SetItem boots = SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_BOOTS.getItem();
        boots.setBaseStats(bootsBaseStats);
        boots.addEnchant(new Enchant(EnchantType.CRIT_VALUE, 0.24563));
        boots.addEnchant(new Enchant(EnchantType.CRIT_VALUE, 0.24563));
        boots.addEnchant(new Enchant(EnchantType.CRIT_VALUE, 0.24563));
        boots.addEnchant(new Enchant(EnchantType.CRIT_VALUE, 0.24563));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        mage.addItem(boots, ItemSlot.BOOTS);

        Map<AbsoluteStatType, Double> adornmentBaseStats = new HashMap<>();
        adornmentBaseStats.put(AbsoluteStatType.DAMAGE, 1870.52);
        adornmentBaseStats.put(AbsoluteStatType.CRIT_VALUE, 2100.146);
        UniqueItem adornment = SpellweaverUniqueItems.SIGRISMARRS_ETERNAL_GRASP.getItem();
        adornment.setBaseStats(adornmentBaseStats);
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        mage.addItem(adornment, ItemSlot.WEAPON_ADORNMENT);

        Map<AbsoluteStatType, Double> twoHandBaseStats = new HashMap<>();
        twoHandBaseStats.put(AbsoluteStatType.DAMAGE, 24570.982);
        twoHandBaseStats.put(AbsoluteStatType.CRIT_VALUE, 3321.515);
        UniqueItem twoHand = SpellweaverUniqueItems.GRIMACE_OF_THE_THUNDER_BEAST.getItem();
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

        Pet mortisPet = new Pet("Mortis Doll", Map.of(OverallRelativeBuffType.ATTACK_SPEED, 0.3, OverallRelativeBuffType.MANA, 0.3, OverallRelativeBuffType.DAMAGE, 0.3, OverallRelativeBuffType.HEALTH_POINTS, 0.10), "");
        mage.setPet(mortisPet);
        mage.setCollectorBagBuff(Map.of(OverallRelativeBuffType.HEALTH_POINTS, 0.33, OverallRelativeBuffType.RESISTANCE, 0.15, OverallRelativeBuffType.DAMAGE, 0.06, OverallRelativeBuffType.BLOCK_VALUE, 0.02));

        Tonic tonic = new Tonic("Tonic of Vigor", AbsoluteStatType.DAMAGE, 10496.0);
        //mage.setTonic(tonic);
        Physic physic = new Physic("Advanced Physic of Vigor", OverallRelativeBuffType.DAMAGE, 0.18);
        //mage.setPhysic(physic);


        return mage;
    }

    public static Character bghMage10msrunes2() {
        Character mage = new Character(CharacterClass.SPELLWEAVER);

        Map<AbsoluteStatType, Double> amuletBaseStats = new HashMap<>();
        amuletBaseStats.put(AbsoluteStatType.CRIT_VALUE, 1731.466);
        amuletBaseStats.put(AbsoluteStatType.HEALTH_POINTS, 24127.76);
        UniqueItem amulet = SpellweaverUniqueItems.AMULET_OF_THE_KRAKEN.getItem();
        amulet.setBaseStats(amuletBaseStats);
        amulet.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        amulet.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        amulet.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        amulet.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        mage.addItem(amulet, ItemSlot.AMULET);

        MythicItem cloak = SpellweaverMythicItem.ANCESTRAL_GLORY_CLOAK.getItem();
        cloak.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        Opal opal = new Opal(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0), new Gem(AbsoluteStatType.DAMAGE, 700.0), new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
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
        mage.addItem(cloak, ItemSlot.CLOAK);

        Map<AbsoluteStatType, Double> beltBaseStats = new HashMap<>();
        beltBaseStats.put(AbsoluteStatType.DAMAGE, 1630.885);
        beltBaseStats.put(AbsoluteStatType.HEALTH_POINTS, 20072.654);
        beltBaseStats.put(AbsoluteStatType.RESISTANCE, 1679.873);
        UniqueItem belt = SpellweaverUniqueItems.BELT_OF_ZEAL.getItem();
        belt.setBaseStats(beltBaseStats);
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
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
        mage.addItem(belt, ItemSlot.BELT);

        MythicItem ring1 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring1.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        ring1.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        ring1.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        ring1.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        mage.addItem(ring1, ItemSlot.RING1);
        MythicItem ring2 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring2.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        ring2.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        ring2.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        ring2.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        ring2.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        mage.addItem(ring2, ItemSlot.RING2);

        Map<AbsoluteStatType, Double> helmetBaseStats = new HashMap<>();
        SetItem helmet = SpellweaverSetItems.HELMET_OF_THE_BLACK_KNIGHT.getItem();
        helmet.setBaseStats(helmetBaseStats);
        helmet.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        helmet.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        helmet.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        helmet.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        helmet.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        helmet.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        helmet.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        helmet.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        helmet.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        helmet.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        helmet.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        helmet.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        helmet.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        helmet.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        mage.addItem(helmet, ItemSlot.HELMET);

        Map<AbsoluteStatType, Double> shouldersBaseStats = new HashMap<>();
        SetItem shoulders = SpellweaverSetItems.SHOULDERS_OF_THE_END.getItem();
        shoulders.setBaseStats(shouldersBaseStats);
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
        mage.addItem(shoulders, ItemSlot.SHOULDERS);

        Map<AbsoluteStatType, Double> torsoBaseStats = new HashMap<>();
        SetItem torso = SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_TORSO.getItem();
        torso.setBaseStats(torsoBaseStats);
        torso.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44263));
        torso.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44415));
        torso.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44382));
        torso.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44237));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        mage.addItem(torso, ItemSlot.TORSO);

        Map<AbsoluteStatType, Double> glovesBaseStats = new HashMap<>();
        glovesBaseStats.put(AbsoluteStatType.DAMAGE, 1514.933);
        glovesBaseStats.put(AbsoluteStatType.ATTACK_SPEED, 0.053);
        glovesBaseStats.put(AbsoluteStatType.CRIT_VALUE, 1494.107);
        UniqueItem gloves = SpellweaverUniqueItems.REIGN_OF_TERROR.getItem();
        gloves.setBaseStats(glovesBaseStats);
        gloves.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44743));
        gloves.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44768));
        gloves.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44738));
        gloves.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44766));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        mage.addItem(gloves, ItemSlot.GLOVES);

        Map<AbsoluteStatType, Double> bootsBaseStats = new HashMap<>();
        bootsBaseStats.put(AbsoluteStatType.DAMAGE, 1510.415);
        bootsBaseStats.put(AbsoluteStatType.MOVEMENT_SPEED, 1.113);
        bootsBaseStats.put(AbsoluteStatType.CRIT_VALUE, 1168.091);
        SetItem boots = SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_BOOTS.getItem();
        boots.setBaseStats(bootsBaseStats);
        boots.addEnchant(new Enchant(EnchantType.CRIT_VALUE, 0.24563));
        boots.addEnchant(new Enchant(EnchantType.CRIT_VALUE, 0.24563));
        boots.addEnchant(new Enchant(EnchantType.CRIT_VALUE, 0.24563));
        boots.addEnchant(new Enchant(EnchantType.CRIT_VALUE, 0.24563));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        mage.addItem(boots, ItemSlot.BOOTS);

        Map<AbsoluteStatType, Double> adornmentBaseStats = new HashMap<>();
        adornmentBaseStats.put(AbsoluteStatType.DAMAGE, 1870.52);
        adornmentBaseStats.put(AbsoluteStatType.CRIT_VALUE, 2100.146);
        UniqueItem adornment = SpellweaverUniqueItems.SIGRISMARRS_ETERNAL_GRASP.getItem();
        adornment.setBaseStats(adornmentBaseStats);
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        mage.addItem(adornment, ItemSlot.WEAPON_ADORNMENT);

        Map<AbsoluteStatType, Double> twoHandBaseStats = new HashMap<>();
        twoHandBaseStats.put(AbsoluteStatType.DAMAGE, 24570.982);
        twoHandBaseStats.put(AbsoluteStatType.CRIT_VALUE, 3321.515);
        UniqueItem twoHand = SpellweaverUniqueItems.GRIMACE_OF_THE_THUNDER_BEAST.getItem();
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

        Pet mortisPet = new Pet("Mortis Doll", Map.of(OverallRelativeBuffType.ATTACK_SPEED, 0.3, OverallRelativeBuffType.MANA, 0.3, OverallRelativeBuffType.DAMAGE, 0.3, OverallRelativeBuffType.HEALTH_POINTS, 0.10), "");
        mage.setPet(mortisPet);
        mage.setCollectorBagBuff(Map.of(OverallRelativeBuffType.HEALTH_POINTS, 0.33, OverallRelativeBuffType.RESISTANCE, 0.15, OverallRelativeBuffType.DAMAGE, 0.06, OverallRelativeBuffType.BLOCK_VALUE, 0.02));

        Tonic tonic = new Tonic("Tonic of Vigor", AbsoluteStatType.DAMAGE, 10496.0);
        //mage.setTonic(tonic);
        Physic physic = new Physic("Advanced Physic of Vigor", OverallRelativeBuffType.DAMAGE, 0.18);
        //mage.setPhysic(physic);


        return mage;
    }

    public static Character sinasBuildmax() {
        Character mage = new Character(CharacterClass.SPELLWEAVER);

        Map<AbsoluteStatType, Double> amuletBaseStats = new HashMap<>();
        UniqueItem amulet = SpellweaverUniqueItems.SARGONS_SHADOW_AMULET.getItem();
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
        mage.addItem(amulet, ItemSlot.AMULET);

        MythicItem cloak = SpellweaverMythicItem.ANCESTRAL_GLORY_CLOAK.getItem();
        cloak.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        mage.addItem(cloak, ItemSlot.CLOAK);

        UniqueItem belt = SpellweaverUniqueItems.BELT_OF_ZEAL.getItem();
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
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
        mage.addItem(belt, ItemSlot.BELT);

        MythicItem ring1 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring1.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        ring1.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        ring1.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        ring1.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        mage.addItem(ring1, ItemSlot.RING1);
        MythicItem ring2 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring2.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        ring2.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        ring2.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        ring2.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        ring2.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        ring2.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        ring2.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        mage.addItem(ring2, ItemSlot.RING2);

        SetItem helmet = SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_HELMET.getItem();
        helmet.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.4452));
        helmet.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44364));
        helmet.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44483));
        helmet.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44430));
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
        mage.addItem(helmet, ItemSlot.HELMET);

        SetItem shoulders = SpellweaverSetItems.SHOULDERS_OF_THE_BLACK_KNIGHT.getItem();
        shoulders.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        shoulders.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        shoulders.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44757));
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
        mage.addItem(shoulders, ItemSlot.SHOULDERS);

        UniqueItem torso = SpellweaverUniqueItems.RESEARCHERS_COAT.getItem();
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
        mage.addItem(torso, ItemSlot.TORSO);

        //UniqueItem gloves = SpellweaverUniqueItems.REIGN_OF_TERROR.getItem();
        SetItem gloves = SpellweaverSetItems.GLOVES_OF_THE_FLAME_CONQUEROR.getItem();
        gloves.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        gloves.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        gloves.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        gloves.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        mage.addItem(gloves, ItemSlot.GLOVES);

        SetItem boots = SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_BOOTS.getItem();
        boots.addEnchant(new Enchant(EnchantType.CRIT_VALUE, 0.22444));
        boots.addEnchant(new Enchant(EnchantType.CRIT_VALUE, 0.22444));
        boots.addEnchant(new Enchant(EnchantType.CRIT_VALUE, 0.22444));
        boots.addEnchant(new Enchant(EnchantType.CRIT_VALUE, 0.22444));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        mage.addItem(boots, ItemSlot.BOOTS);

        UniqueItem adornment = SpellweaverUniqueItems.STINGER.getItem();
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        Opal opal = new Opal(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0), new Gem(AbsoluteStatType.DAMAGE, 700.0), new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        adornment.addGem(opal);
        adornment.addGem(opal);
        adornment.addGem(opal);
        adornment.addGem(opal);
        adornment.addGem(opal);
        adornment.addGem(opal);
        opal = new Opal(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0), new Gem(AbsoluteStatType.DAMAGE, 700.0), new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        adornment.addGem(opal);
        adornment.addGem(opal);
        adornment.addGem(opal);
        adornment.addGem(opal);
        mage.addItem(adornment, ItemSlot.WEAPON_ADORNMENT);

        UniqueItem twoHand = SpellweaverUniqueItems.GRIMACE_OF_THE_THUNDER_BEAST.getItem();
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
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffType.ARMOR, 0.065));
        runeTrinket5.addRune(new SpecialRune("Rune of the Realm Changer", Map.of(), "Increases the Realm Changer talent by 5."));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffType.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffType.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffType.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffType.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffType.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new SpecialRune("Rune of Rising Vigor", Map.of(OverallRelativeBuffType.MOVEMENT_SPEED, 0.10, OverallRelativeBuffType.ATTACK_SPEED, 0.06), ""));
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

        Pet mortisPet = new Pet("Mortis Doll", Map.of(OverallRelativeBuffType.ATTACK_SPEED, 0.3, OverallRelativeBuffType.MANA, 0.3, OverallRelativeBuffType.DAMAGE, 0.3, OverallRelativeBuffType.HEALTH_POINTS, 0.1), "");
        mage.setPet(mortisPet);
        mage.setCollectorBagBuff(Map.of(OverallRelativeBuffType.HEALTH_POINTS, 0.33, OverallRelativeBuffType.RESISTANCE, 0.15, OverallRelativeBuffType.DAMAGE, 0.06, OverallRelativeBuffType.BLOCK_VALUE, 0.02));

        Tonic tonic = new Tonic("Tonic of Vigor", AbsoluteStatType.DAMAGE, 10496.0);
        //Tonic tonic = new Tonic("Tonic of Vigor", AbsoluteStatTypeEnum.HEALTH_POINTS, 156068.0);
        mage.setTonic(tonic);
        Physic physic = new Physic("Advanced Physic of Vigor", OverallRelativeBuffType.DAMAGE, 0.18);
        //Physic physic = new Physic("Advanced Physic of Vigor", OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.18);
        mage.setPhysic(physic);


        return mage;
    }

    public static Character bghMageNewDragan2() {
        Character mage = new Character(CharacterClass.SPELLWEAVER);

        Map<AbsoluteStatType, Double> amuletBaseStats = new HashMap<>();
        amuletBaseStats.put(AbsoluteStatType.CRIT_VALUE, 1731.466);
        amuletBaseStats.put(AbsoluteStatType.HEALTH_POINTS, 24127.76);
        UniqueItem amulet = SpellweaverUniqueItems.AMULET_OF_THE_KRAKEN.getItem();
        amulet.setBaseStats(amuletBaseStats);
        amulet.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        amulet.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        amulet.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        amulet.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        mage.addItem(amulet, ItemSlot.AMULET);

        MythicItem cloak = SpellweaverMythicItem.ANCESTRAL_GLORY_CLOAK.getItem();
        cloak.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        mage.addItem(cloak, ItemSlot.CLOAK);

        Map<AbsoluteStatType, Double> beltBaseStats = new HashMap<>();
        beltBaseStats.put(AbsoluteStatType.DAMAGE, 1630.885);
        beltBaseStats.put(AbsoluteStatType.HEALTH_POINTS, 20072.654);
        beltBaseStats.put(AbsoluteStatType.RESISTANCE, 1679.873);
        UniqueItem belt = SpellweaverUniqueItems.BELT_OF_ZEAL.getItem();
        belt.setBaseStats(beltBaseStats);
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
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
        mage.addItem(belt, ItemSlot.BELT);

        MythicItem ring1 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring1.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        ring1.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        ring1.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        ring1.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        ring1.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        ring1.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        ring1.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        ring1.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        ring1.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        ring1.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        ring1.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        ring1.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        ring1.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        ring1.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        mage.addItem(ring1, ItemSlot.RING1);
        MythicItem ring2 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring2.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        Opal opal = new Opal(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0), new Gem(AbsoluteStatType.DAMAGE, 700.0), new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
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
        mage.addItem(ring2, ItemSlot.RING2);

        SetItem helmet = SpellweaverSetItems.HELMET_OF_THE_BLACK_KNIGHT.getItem();
        helmet.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        helmet.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        helmet.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        helmet.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        helmet.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        mage.addItem(helmet, ItemSlot.HELMET);

        SetItem shoulders = SpellweaverSetItems.SHOULDERS_OF_THE_BLACK_KNIGHT.getItem();
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
        mage.addItem(shoulders, ItemSlot.SHOULDERS);

        SetItem torso = SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_TORSO.getItem();
        torso.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44263));
        torso.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44415));
        torso.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44382));
        torso.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44237));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        mage.addItem(torso, ItemSlot.TORSO);

        Map<AbsoluteStatType, Double> glovesBaseStats = new HashMap<>();
        glovesBaseStats.put(AbsoluteStatType.DAMAGE, 1584.734);
        glovesBaseStats.put(AbsoluteStatType.ATTACK_SPEED, 0.052);
        glovesBaseStats.put(AbsoluteStatType.ARMOR, 653.453);
        UniqueItem gloves = SpellweaverUniqueItems.REIGN_OF_TERROR.getItem();
        gloves.setBaseStats(glovesBaseStats);
        gloves.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44743));
        gloves.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44768));
        gloves.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44738));
        gloves.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44766));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        mage.addItem(gloves, ItemSlot.GLOVES);

        Map<AbsoluteStatType, Double> bootsBaseStats = new HashMap<>();
        bootsBaseStats.put(AbsoluteStatType.DAMAGE, 1510.415);
        bootsBaseStats.put(AbsoluteStatType.MOVEMENT_SPEED, 1.113);
        bootsBaseStats.put(AbsoluteStatType.CRIT_VALUE, 1168.091);
        SetItem boots = SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_BOOTS.getItem();
        boots.setBaseStats(bootsBaseStats);
        boots.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44760));
        boots.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44763));
        boots.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44762));
        boots.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44751));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        mage.addItem(boots, ItemSlot.BOOTS);

        Map<AbsoluteStatType, Double> adornmentBaseStats = new HashMap<>();
        adornmentBaseStats.put(AbsoluteStatType.DAMAGE, 1870.52);
        adornmentBaseStats.put(AbsoluteStatType.CRIT_VALUE, 2100.146);
        UniqueItem adornment = SpellweaverUniqueItems.SIGRISMARRS_ETERNAL_GRASP.getItem();
        adornment.setBaseStats(adornmentBaseStats);
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44771));
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44767));
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44775));
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44772));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        mage.addItem(adornment, ItemSlot.WEAPON_ADORNMENT);

        Map<AbsoluteStatType, Double> twoHandBaseStats = new HashMap<>();
        twoHandBaseStats.put(AbsoluteStatType.DAMAGE, 24570.982);
        twoHandBaseStats.put(AbsoluteStatType.CRIT_VALUE, 3321.515);
        UniqueItem twoHand = SpellweaverUniqueItems.GRIMACE_OF_THE_THUNDER_BEAST.getItem();
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
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffType.ARMOR, 0.065));
        runeTrinket5.addRune(new SpecialRune("Rune of the Realm Changer", Map.of(), "Increases the Realm Changer talent by 5."));
        runeTrinket5.addRune(new SpecialRune("Rune of the Andermant Fever", Map.of(), "Increases the Andermant Fever talent by 5."));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffType.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffType.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Materi Blessing", OverallRelativeBuffType.MATERI_FRAGMENT_DROP_BONUS, 0.3));
        runeTrinket5.addRune(new Rune("Rune of Materi Blessing", OverallRelativeBuffType.MATERI_FRAGMENT_DROP_BONUS, 0.3));
        runeTrinket5.addRune(new SpecialRune("Rune of Rising Vigor", Map.of(OverallRelativeBuffType.MOVEMENT_SPEED, 0.10, OverallRelativeBuffType.ATTACK_SPEED, 0.06), ""));
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

        Pet mortisPet = new Pet("Mortis Doll", Map.of(OverallRelativeBuffType.ATTACK_SPEED, 0.3, OverallRelativeBuffType.MANA, 0.3, OverallRelativeBuffType.DAMAGE, 0.4
                , OverallRelativeBuffType.HEALTH_POINTS, 0.05, OverallRelativeBuffType.ARMOR, 0.1), "");
        mage.setPet(mortisPet);
        mage.setCollectorBagBuff(Map.of(OverallRelativeBuffType.HEALTH_POINTS, 0.33, OverallRelativeBuffType.RESISTANCE, 0.15, OverallRelativeBuffType.DAMAGE, 0.06, OverallRelativeBuffType.BLOCK_VALUE, 0.02));

        Tonic tonic = new Tonic("Tonic of Vigor", AbsoluteStatType.DAMAGE, 10496.0);
        //mage.setTonic(tonic);
        Physic physic = new Physic("Advanced Physic of Vigor", OverallRelativeBuffType.DAMAGE, 0.18);
        //mage.setPhysic(physic);


        return mage;
    }

    public static Character bghMageNewDragan() {
        Character mage = new Character(CharacterClass.SPELLWEAVER);

        Map<AbsoluteStatType, Double> amuletBaseStats = new HashMap<>();
        amuletBaseStats.put(AbsoluteStatType.CRIT_VALUE, 1731.466);
        amuletBaseStats.put(AbsoluteStatType.HEALTH_POINTS, 24127.76);
        UniqueItem amulet = SpellweaverUniqueItems.AMULET_OF_THE_KRAKEN.getItem();
        amulet.setBaseStats(amuletBaseStats);
        amulet.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        amulet.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        amulet.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        amulet.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        mage.addItem(amulet, ItemSlot.AMULET);

        MythicItem cloak = SpellweaverMythicItem.ANCESTRAL_GLORY_CLOAK.getItem();
        cloak.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        mage.addItem(cloak, ItemSlot.CLOAK);

        Map<AbsoluteStatType, Double> beltBaseStats = new HashMap<>();
        beltBaseStats.put(AbsoluteStatType.DAMAGE, 1630.885);
        beltBaseStats.put(AbsoluteStatType.HEALTH_POINTS, 20072.654);
        beltBaseStats.put(AbsoluteStatType.RESISTANCE, 1679.873);
        UniqueItem belt = SpellweaverUniqueItems.BELT_OF_ZEAL.getItem();
        belt.setBaseStats(beltBaseStats);
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
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
        mage.addItem(belt, ItemSlot.BELT);

        MythicItem ring1 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
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
        mage.addItem(ring1, ItemSlot.RING1);
        MythicItem ring2 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring2.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        Opal opal = new Opal(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0), new Gem(AbsoluteStatType.DAMAGE, 700.0), new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
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
        mage.addItem(ring2, ItemSlot.RING2);

        SetItem helmet = SpellweaverSetItems.HELMET_OF_THE_BLACK_KNIGHT.getItem();
        helmet.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        helmet.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        helmet.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        helmet.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        helmet.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        mage.addItem(helmet, ItemSlot.HELMET);

        SetItem shoulders = SpellweaverSetItems.SHOULDERS_OF_THE_BLACK_KNIGHT.getItem();
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
        mage.addItem(shoulders, ItemSlot.SHOULDERS);

        Map<AbsoluteStatType, Double> torsoBaseStats = new HashMap<>();
        torsoBaseStats.put(AbsoluteStatType.DAMAGE, 1631.657);
        torsoBaseStats.put(AbsoluteStatType.HEALTH_POINTS, 14232.794);
        torsoBaseStats.put(AbsoluteStatType.ARMOR, 1639.716);
        UniqueItem torso = SpellweaverUniqueItems.RESEARCHERS_COAT.getItem();
        torso.setBaseStats(torsoBaseStats);
        torso.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44263));
        torso.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44415));
        torso.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44382));
        torso.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44237));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        mage.addItem(torso, ItemSlot.TORSO);

        Map<AbsoluteStatType, Double> glovesBaseStats = new HashMap<>();
        glovesBaseStats.put(AbsoluteStatType.DAMAGE, 1514.933);
        glovesBaseStats.put(AbsoluteStatType.ATTACK_SPEED, 0.053);
        glovesBaseStats.put(AbsoluteStatType.CRIT_VALUE, 1494.107);
        SetItem gloves = SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_GLOVES.getItem();
        gloves.setBaseStats(glovesBaseStats);
        gloves.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44743));
        gloves.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44768));
        gloves.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44738));
        gloves.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44766));
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
        mage.addItem(gloves, ItemSlot.GLOVES);

        Map<AbsoluteStatType, Double> bootsBaseStats = new HashMap<>();
        bootsBaseStats.put(AbsoluteStatType.DAMAGE, 1510.415);
        bootsBaseStats.put(AbsoluteStatType.MOVEMENT_SPEED, 1.113);
        bootsBaseStats.put(AbsoluteStatType.CRIT_VALUE, 1168.091);
        SetItem boots = SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_BOOTS.getItem();
        boots.setBaseStats(bootsBaseStats);
        boots.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44760));
        boots.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44763));
        boots.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44762));
        boots.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44751));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        mage.addItem(boots, ItemSlot.BOOTS);

        Map<AbsoluteStatType, Double> adornmentBaseStats = new HashMap<>();
        adornmentBaseStats.put(AbsoluteStatType.DAMAGE, 1870.52);
        adornmentBaseStats.put(AbsoluteStatType.CRIT_VALUE, 2100.146);
        UniqueItem adornment = SpellweaverUniqueItems.SIGRISMARRS_ETERNAL_GRASP.getItem();
        adornment.setBaseStats(adornmentBaseStats);
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44771));
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44767));
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44775));
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44772));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        mage.addItem(adornment, ItemSlot.WEAPON_ADORNMENT);

        Map<AbsoluteStatType, Double> twoHandBaseStats = new HashMap<>();
        twoHandBaseStats.put(AbsoluteStatType.DAMAGE, 24570.982);
        twoHandBaseStats.put(AbsoluteStatType.CRIT_VALUE, 3321.515);
        UniqueItem twoHand = SpellweaverUniqueItems.GRIMACE_OF_THE_THUNDER_BEAST.getItem();
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
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffType.ARMOR, 0.065));
        runeTrinket5.addRune(new SpecialRune("Rune of the Realm Changer", Map.of(), "Increases the Realm Changer talent by 5."));
        runeTrinket5.addRune(new SpecialRune("Rune of the Andermant Fever", Map.of(), "Increases the Andermant Fever talent by 5."));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffType.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffType.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Materi Blessing", OverallRelativeBuffType.MATERI_FRAGMENT_DROP_BONUS, 0.3));
        runeTrinket5.addRune(new Rune("Rune of Materi Blessing", OverallRelativeBuffType.MATERI_FRAGMENT_DROP_BONUS, 0.3));
        runeTrinket5.addRune(new SpecialRune("Rune of Rising Vigor", Map.of(OverallRelativeBuffType.MOVEMENT_SPEED, 0.10, OverallRelativeBuffType.ATTACK_SPEED, 0.06), ""));
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

        mage.setEssence(0.50);

        Pet mortisPet = new Pet("Mortis Doll", Map.of(OverallRelativeBuffType.ATTACK_SPEED, 0.3, OverallRelativeBuffType.MANA, 0.3, OverallRelativeBuffType.DAMAGE, 0.4
        , OverallRelativeBuffType.HEALTH_POINTS, 0.05, OverallRelativeBuffType.ARMOR, 0.1), "");
        mage.setPet(mortisPet);
        mage.setCollectorBagBuff(Map.of(OverallRelativeBuffType.HEALTH_POINTS, 0.33, OverallRelativeBuffType.RESISTANCE, 0.15, OverallRelativeBuffType.DAMAGE, 0.06, OverallRelativeBuffType.BLOCK_VALUE, 0.02));

        Tonic tonic = new Tonic("Tonic of Vigor", AbsoluteStatType.DAMAGE, 10496.0);
        //mage.setTonic(tonic);
        Physic physic = new Physic("Advanced Physic of Vigor", OverallRelativeBuffType.DAMAGE, 0.18);
        //mage.setPhysic(physic);


        return mage;
    }

    public static Character sinasBuild() {
        Character mage = new Character(CharacterClass.SPELLWEAVER);

        Map<AbsoluteStatType, Double> amuletBaseStats = new HashMap<>();
        amuletBaseStats.put(AbsoluteStatType.DAMAGE, 1495.899);
        amuletBaseStats.put(AbsoluteStatType.MOVEMENT_SPEED, 0.460);
        amuletBaseStats.put(AbsoluteStatType.HEALTH_POINTS, 23093.384);
        UniqueItem amulet = SpellweaverUniqueItems.SARGONS_SHADOW_AMULET.getItem();
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
        mage.addItem(amulet, ItemSlot.AMULET);

        MythicItem cloak = SpellweaverMythicItem.ANCESTRAL_GLORY_CLOAK.getItem();
        cloak.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        mage.addItem(cloak, ItemSlot.CLOAK);

        Map<AbsoluteStatType, Double> beltBaseStats = new HashMap<>();
        beltBaseStats.put(AbsoluteStatType.DAMAGE, 1630.885);
        beltBaseStats.put(AbsoluteStatType.HEALTH_POINTS, 20072.654);
        beltBaseStats.put(AbsoluteStatType.RESISTANCE, 1679.873);
        UniqueItem belt = SpellweaverUniqueItems.BELT_OF_ZEAL.getItem();
        belt.setBaseStats(beltBaseStats);
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
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
        mage.addItem(belt, ItemSlot.BELT);

        MythicItem ring1 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring1.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        ring1.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        ring1.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        ring1.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        mage.addItem(ring1, ItemSlot.RING1);
        MythicItem ring2 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring2.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        ring2.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        ring2.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        ring2.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        ring2.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        mage.addItem(ring2, ItemSlot.RING2);

        Map<AbsoluteStatType, Double> helmetBaseStats = new HashMap<>();
        helmetBaseStats.put(AbsoluteStatType.HEALTH_POINTS, 18008.718);
        helmetBaseStats.put(AbsoluteStatType.ARMOR, 1066.76);
        helmetBaseStats.put(AbsoluteStatType.FIRE_RESISTANCE, 3382.495);
        SetItem helmet = SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_HELMET.getItem();
        helmet.setBaseStats(helmetBaseStats);
        helmet.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.4452));
        helmet.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44364));
        helmet.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44483));
        helmet.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44430));
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
        mage.addItem(helmet, ItemSlot.HELMET);

        SetItem shoulders = SpellweaverSetItems.SHOULDERS_OF_THE_BLACK_KNIGHT.getItem();
        shoulders.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        shoulders.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        shoulders.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44757));
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
        mage.addItem(shoulders, ItemSlot.SHOULDERS);

        UniqueItem torso = SpellweaverUniqueItems.RESEARCHERS_COAT.getItem();
        torso.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        torso.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        torso.addEnchant(new Enchant(EnchantType.CRIT_VALUE, 0.24563));
        torso.addEnchant(new Enchant(EnchantType.CRIT_VALUE, 0.24563));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        mage.addItem(torso, ItemSlot.TORSO);

        Map<AbsoluteStatType, Double> glovesBaseStats = new HashMap<>();
        glovesBaseStats.put(AbsoluteStatType.DAMAGE, 1584.734);
        glovesBaseStats.put(AbsoluteStatType.ATTACK_SPEED, 0.052);
        glovesBaseStats.put(AbsoluteStatType.ARMOR, 653.453);
        UniqueItem gloves = SpellweaverUniqueItems.REIGN_OF_TERROR.getItem();
        gloves.setBaseStats(glovesBaseStats);
        gloves.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        gloves.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        gloves.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        gloves.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        mage.addItem(gloves, ItemSlot.GLOVES);

        Map<AbsoluteStatType, Double> bootsBaseStats = new HashMap<>();
        bootsBaseStats.put(AbsoluteStatType.DAMAGE, 1510.415);
        bootsBaseStats.put(AbsoluteStatType.MOVEMENT_SPEED, 1.113);
        bootsBaseStats.put(AbsoluteStatType.CRIT_VALUE, 1168.091);
        SetItem boots = SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_BOOTS.getItem();
        boots.setBaseStats(bootsBaseStats);
        boots.addEnchant(new Enchant(EnchantType.MOVEMENT_SPEED, 0.22444));
        boots.addEnchant(new Enchant(EnchantType.MOVEMENT_SPEED, 0.22444));
        boots.addEnchant(new Enchant(EnchantType.MOVEMENT_SPEED, 0.22444));
        boots.addEnchant(new Enchant(EnchantType.MOVEMENT_SPEED, 0.22444));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        mage.addItem(boots, ItemSlot.BOOTS);

        Map<AbsoluteStatType, Double> adornmentBaseStats = new HashMap<>();
        adornmentBaseStats.put(AbsoluteStatType.DAMAGE, 1876.970);
        adornmentBaseStats.put(AbsoluteStatType.ATTACK_SPEED, 0.047);
        adornmentBaseStats.put(AbsoluteStatType.CRIT_VALUE, 2066.609);
        UniqueItem adornment = SpellweaverUniqueItems.STINGER.getItem();
        adornment.setBaseStats(adornmentBaseStats);
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        Opal opal = new Opal(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0), new Gem(AbsoluteStatType.DAMAGE, 700.0), new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
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
        mage.addItem(adornment, ItemSlot.WEAPON_ADORNMENT);

        Map<AbsoluteStatType, Double> twoHandBaseStats = new HashMap<>();
        twoHandBaseStats.put(AbsoluteStatType.DAMAGE, 24570.982);
        twoHandBaseStats.put(AbsoluteStatType.CRIT_VALUE, 3321.515);
        UniqueItem twoHand = SpellweaverUniqueItems.GRIMACE_OF_THE_THUNDER_BEAST.getItem();
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
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffType.ARMOR, 0.065));
        runeTrinket5.addRune(new SpecialRune("Rune of the Realm Changer", Map.of(), "Increases the Realm Changer talent by 5."));
        runeTrinket5.addRune(new SpecialRune("Rune of the Andermant Fever", Map.of(), "Increases the Andermant Fever talent by 5."));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffType.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffType.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Materi Blessing", OverallRelativeBuffType.MATERI_FRAGMENT_DROP_BONUS, 0.3));
        runeTrinket5.addRune(new Rune("Rune of Materi Blessing", OverallRelativeBuffType.MATERI_FRAGMENT_DROP_BONUS, 0.3));
        runeTrinket5.addRune(new SpecialRune("Rune of Rising Vigor", Map.of(OverallRelativeBuffType.MOVEMENT_SPEED, 0.10, OverallRelativeBuffType.ATTACK_SPEED, 0.06), ""));
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

        Pet mortisPet = new Pet("Mortis Doll", Map.of(OverallRelativeBuffType.ATTACK_SPEED, 0.3, OverallRelativeBuffType.MANA, 0.3, OverallRelativeBuffType.DAMAGE, 0.3, OverallRelativeBuffType.HEALTH_POINTS, 0.1), "");
        mage.setPet(mortisPet);
        mage.setCollectorBagBuff(Map.of(OverallRelativeBuffType.HEALTH_POINTS, 0.33, OverallRelativeBuffType.RESISTANCE, 0.15, OverallRelativeBuffType.DAMAGE, 0.06, OverallRelativeBuffType.BLOCK_VALUE, 0.02));

        Tonic tonic = new Tonic("Tonic of Vigor", AbsoluteStatType.DAMAGE, 10496.0);
        //mage.setTonic(tonic);
        Physic physic = new Physic("Advanced Physic of Vigor", OverallRelativeBuffType.DAMAGE, 0.18);
        //mage.setPhysic(physic);


        return mage;
    }

    public static Character sinasBuildNewDragan() {
        Character mage = new Character(CharacterClass.SPELLWEAVER);

        Map<AbsoluteStatType, Double> amuletBaseStats = new HashMap<>();
        amuletBaseStats.put(AbsoluteStatType.DAMAGE, 1495.899);
        amuletBaseStats.put(AbsoluteStatType.MOVEMENT_SPEED, 0.460);
        amuletBaseStats.put(AbsoluteStatType.HEALTH_POINTS, 23093.384);
        UniqueItem amulet = SpellweaverUniqueItems.SARGONS_SHADOW_AMULET.getItem();
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
        mage.addItem(amulet, ItemSlot.AMULET);

        MythicItem cloak = SpellweaverMythicItem.ANCESTRAL_GLORY_CLOAK.getItem();
        cloak.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        mage.addItem(cloak, ItemSlot.CLOAK);

        Map<AbsoluteStatType, Double> beltBaseStats = new HashMap<>();
        beltBaseStats.put(AbsoluteStatType.DAMAGE, 1630.885);
        beltBaseStats.put(AbsoluteStatType.HEALTH_POINTS, 20072.654);
        beltBaseStats.put(AbsoluteStatType.RESISTANCE, 1679.873);
        UniqueItem belt = SpellweaverUniqueItems.BELT_OF_ZEAL.getItem();
        belt.setBaseStats(beltBaseStats);
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
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
        mage.addItem(belt, ItemSlot.BELT);

        MythicItem ring1 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring1.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        ring1.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        ring1.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        ring1.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        mage.addItem(ring1, ItemSlot.RING1);
        MythicItem ring2 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring2.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        ring2.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        ring2.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        ring2.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        ring2.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring2.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        mage.addItem(ring2, ItemSlot.RING2);

        SetItem helmet = SpellweaverSetItems.HELMET_OF_THE_BLACK_KNIGHT.getItem();
        helmet.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.4452));
        helmet.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44364));
        helmet.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44483));
        helmet.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44430));
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
        mage.addItem(helmet, ItemSlot.HELMET);

        SetItem shoulders = SpellweaverSetItems.SHOULDERS_OF_THE_END.getItem();
        shoulders.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        shoulders.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        shoulders.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44757));
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
        mage.addItem(shoulders, ItemSlot.SHOULDERS);

        SetItem torso = SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_TORSO.getItem();
        torso.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        torso.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        torso.addEnchant(new Enchant(EnchantType.CRIT_VALUE, 0.24563));
        torso.addEnchant(new Enchant(EnchantType.CRIT_VALUE, 0.24563));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        mage.addItem(torso, ItemSlot.TORSO);

        Map<AbsoluteStatType, Double> glovesBaseStats = new HashMap<>();
        glovesBaseStats.put(AbsoluteStatType.DAMAGE, 1584.734);
        glovesBaseStats.put(AbsoluteStatType.ATTACK_SPEED, 0.052);
        glovesBaseStats.put(AbsoluteStatType.ARMOR, 653.453);
        UniqueItem gloves = SpellweaverUniqueItems.REIGN_OF_TERROR.getItem();
        gloves.setBaseStats(glovesBaseStats);
        gloves.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        gloves.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        gloves.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        gloves.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        mage.addItem(gloves, ItemSlot.GLOVES);

        Map<AbsoluteStatType, Double> bootsBaseStats = new HashMap<>();
        bootsBaseStats.put(AbsoluteStatType.DAMAGE, 1510.415);
        bootsBaseStats.put(AbsoluteStatType.MOVEMENT_SPEED, 1.113);
        bootsBaseStats.put(AbsoluteStatType.CRIT_VALUE, 1168.091);
        SetItem boots = SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_BOOTS.getItem();
        boots.setBaseStats(bootsBaseStats);
        boots.addEnchant(new Enchant(EnchantType.MOVEMENT_SPEED, 0.22444));
        boots.addEnchant(new Enchant(EnchantType.MOVEMENT_SPEED, 0.22444));
        boots.addEnchant(new Enchant(EnchantType.MOVEMENT_SPEED, 0.22444));
        boots.addEnchant(new Enchant(EnchantType.MOVEMENT_SPEED, 0.22444));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        mage.addItem(boots, ItemSlot.BOOTS);

        Map<AbsoluteStatType, Double> adornmentBaseStats = new HashMap<>();
        adornmentBaseStats.put(AbsoluteStatType.DAMAGE, 1876.970);
        adornmentBaseStats.put(AbsoluteStatType.ATTACK_SPEED, 0.047);
        adornmentBaseStats.put(AbsoluteStatType.CRIT_VALUE, 2066.609);
        UniqueItem adornment = SpellweaverUniqueItems.STINGER.getItem();
        adornment.setBaseStats(adornmentBaseStats);
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        Opal opal = new Opal(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0), new Gem(AbsoluteStatType.DAMAGE, 700.0), new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
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
        mage.addItem(adornment, ItemSlot.WEAPON_ADORNMENT);

        Map<AbsoluteStatType, Double> twoHandBaseStats = new HashMap<>();
        twoHandBaseStats.put(AbsoluteStatType.DAMAGE, 24570.982);
        twoHandBaseStats.put(AbsoluteStatType.CRIT_VALUE, 3321.515);
        UniqueItem twoHand = SpellweaverUniqueItems.GRIMACE_OF_THE_THUNDER_BEAST.getItem();
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
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffType.ARMOR, 0.065));
        runeTrinket5.addRune(new SpecialRune("Rune of the Realm Changer", Map.of(), "Increases the Realm Changer talent by 5."));
        runeTrinket5.addRune(new SpecialRune("Rune of the Andermant Fever", Map.of(), "Increases the Andermant Fever talent by 5."));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffType.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffType.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Materi Blessing", OverallRelativeBuffType.MATERI_FRAGMENT_DROP_BONUS, 0.3));
        runeTrinket5.addRune(new Rune("Rune of Materi Blessing", OverallRelativeBuffType.MATERI_FRAGMENT_DROP_BONUS, 0.3));
        runeTrinket5.addRune(new SpecialRune("Rune of Rising Vigor", Map.of(OverallRelativeBuffType.MOVEMENT_SPEED, 0.10, OverallRelativeBuffType.ATTACK_SPEED, 0.06), ""));
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

        Pet mortisPet = new Pet("Mortis Doll", Map.of(OverallRelativeBuffType.ATTACK_SPEED, 0.3, OverallRelativeBuffType.MANA, 0.3, OverallRelativeBuffType.DAMAGE, 0.3, OverallRelativeBuffType.HEALTH_POINTS, 0.1), "");
        mage.setPet(mortisPet);
        mage.setCollectorBagBuff(Map.of(OverallRelativeBuffType.HEALTH_POINTS, 0.33, OverallRelativeBuffType.RESISTANCE, 0.15, OverallRelativeBuffType.DAMAGE, 0.06, OverallRelativeBuffType.BLOCK_VALUE, 0.02));

        Tonic tonic = new Tonic("Tonic of Vigor", AbsoluteStatType.DAMAGE, 10496.0);
        //mage.setTonic(tonic);
        Physic physic = new Physic("Advanced Physic of Vigor", OverallRelativeBuffType.DAMAGE, 0.18);
        //mage.setPhysic(physic);


        return mage;
    }

    public static Character sinasBuildNewDragan2() {
        Character mage = new Character(CharacterClass.SPELLWEAVER);

        Map<AbsoluteStatType, Double> amuletBaseStats = new HashMap<>();
        amuletBaseStats.put(AbsoluteStatType.DAMAGE, 1495.899);
        amuletBaseStats.put(AbsoluteStatType.MOVEMENT_SPEED, 0.460);
        amuletBaseStats.put(AbsoluteStatType.HEALTH_POINTS, 23093.384);
        UniqueItem amulet = SpellweaverUniqueItems.SARGONS_SHADOW_AMULET.getItem();
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
        mage.addItem(amulet, ItemSlot.AMULET);

        MythicItem cloak = SpellweaverMythicItem.ANCESTRAL_GLORY_CLOAK.getItem();
        cloak.addEnchant(new Enchant(EnchantType.ATTACK_SPEED, 0.47122));
        cloak.addEnchant(new Enchant(EnchantType.ATTACK_SPEED, 0.47122));
        cloak.addEnchant(new Enchant(EnchantType.ATTACK_SPEED, 0.47122));
        cloak.addEnchant(new Enchant(EnchantType.ATTACK_SPEED, 0.47122));
        cloak.addGem(new Gem(AbsoluteStatType.ATTACK_SPEED, 0.017));
        cloak.addGem(new Gem(AbsoluteStatType.ATTACK_SPEED, 0.017));
        cloak.addGem(new Gem(AbsoluteStatType.ATTACK_SPEED, 0.017));
        cloak.addGem(new Gem(AbsoluteStatType.ATTACK_SPEED, 0.017));
        cloak.addGem(new Gem(AbsoluteStatType.ATTACK_SPEED, 0.017));
        cloak.addGem(new Gem(AbsoluteStatType.ATTACK_SPEED, 0.017));
        cloak.addGem(new Gem(AbsoluteStatType.ATTACK_SPEED, 0.017));
        cloak.addGem(new Gem(AbsoluteStatType.ATTACK_SPEED, 0.017));
        cloak.addGem(new Gem(AbsoluteStatType.ATTACK_SPEED, 0.017));
        cloak.addGem(new Gem(AbsoluteStatType.ATTACK_SPEED, 0.017));
        mage.addItem(cloak, ItemSlot.CLOAK);

        Map<AbsoluteStatType, Double> beltBaseStats = new HashMap<>();
        beltBaseStats.put(AbsoluteStatType.DAMAGE, 1630.885);
        beltBaseStats.put(AbsoluteStatType.HEALTH_POINTS, 20072.654);
        beltBaseStats.put(AbsoluteStatType.RESISTANCE, 1679.873);
        UniqueItem belt = SpellweaverUniqueItems.BELT_OF_ZEAL.getItem();
        belt.setBaseStats(beltBaseStats);
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
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
        mage.addItem(belt, ItemSlot.BELT);

        MythicItem ring1 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring1.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        ring1.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        ring1.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        ring1.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        mage.addItem(ring1, ItemSlot.RING1);
        MythicItem ring2 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
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
        mage.addItem(ring2, ItemSlot.RING2);

        SetItem helmet = SpellweaverSetItems.HELMET_OF_THE_BLACK_KNIGHT.getItem();
        helmet.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.4452));
        helmet.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44364));
        helmet.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44483));
        helmet.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44430));
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
        mage.addItem(helmet, ItemSlot.HELMET);

        SetItem shoulders = SpellweaverSetItems.SHOULDERS_OF_THE_END.getItem();
        shoulders.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        shoulders.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        shoulders.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44757));
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
        mage.addItem(shoulders, ItemSlot.SHOULDERS);

        UniqueItem torso = SpellweaverUniqueItems.RESEARCHERS_COAT.getItem();
        torso.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        torso.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        torso.addEnchant(new Enchant(EnchantType.CRIT_VALUE, 0.24563));
        torso.addEnchant(new Enchant(EnchantType.CRIT_VALUE, 0.24563));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        mage.addItem(torso, ItemSlot.TORSO);

        Map<AbsoluteStatType, Double> glovesBaseStats = new HashMap<>();
        glovesBaseStats.put(AbsoluteStatType.DAMAGE, 1584.734);
        glovesBaseStats.put(AbsoluteStatType.ATTACK_SPEED, 0.052);
        glovesBaseStats.put(AbsoluteStatType.ARMOR, 653.453);
        UniqueItem gloves = SpellweaverUniqueItems.REIGN_OF_TERROR.getItem();
        gloves.setBaseStats(glovesBaseStats);
        gloves.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        gloves.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        gloves.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        gloves.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        mage.addItem(gloves, ItemSlot.GLOVES);

        Map<AbsoluteStatType, Double> bootsBaseStats = new HashMap<>();
        bootsBaseStats.put(AbsoluteStatType.DAMAGE, 1510.415);
        bootsBaseStats.put(AbsoluteStatType.MOVEMENT_SPEED, 1.113);
        bootsBaseStats.put(AbsoluteStatType.CRIT_VALUE, 1168.091);
        SetItem boots = SpellweaverSetItems.BOOTS_OF_THE_FLAME_CONQUEROR.getItem();
        boots.setBaseStats(bootsBaseStats);
        boots.addEnchant(new Enchant(EnchantType.MOVEMENT_SPEED, 0.22444));
        boots.addEnchant(new Enchant(EnchantType.MOVEMENT_SPEED, 0.22444));
        boots.addEnchant(new Enchant(EnchantType.MOVEMENT_SPEED, 0.22444));
        boots.addEnchant(new Enchant(EnchantType.MOVEMENT_SPEED, 0.22444));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        mage.addItem(boots, ItemSlot.BOOTS);

        Map<AbsoluteStatType, Double> adornmentBaseStats = new HashMap<>();
        adornmentBaseStats.put(AbsoluteStatType.DAMAGE, 1876.970);
        adornmentBaseStats.put(AbsoluteStatType.ATTACK_SPEED, 0.047);
        adornmentBaseStats.put(AbsoluteStatType.CRIT_VALUE, 2066.609);
        UniqueItem adornment = SpellweaverUniqueItems.STINGER.getItem();
        adornment.setBaseStats(adornmentBaseStats);
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        Opal opal = new Opal(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0), new Gem(AbsoluteStatType.DAMAGE, 700.0), new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
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
        mage.addItem(adornment, ItemSlot.WEAPON_ADORNMENT);

        Map<AbsoluteStatType, Double> twoHandBaseStats = new HashMap<>();
        twoHandBaseStats.put(AbsoluteStatType.DAMAGE, 24570.982);
        twoHandBaseStats.put(AbsoluteStatType.CRIT_VALUE, 3321.515);
        UniqueItem twoHand = SpellweaverUniqueItems.GRIMACE_OF_THE_THUNDER_BEAST.getItem();
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
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffType.ARMOR, 0.065));
        runeTrinket5.addRune(new SpecialRune("Rune of the Realm Changer", Map.of(), "Increases the Realm Changer talent by 5."));
        runeTrinket5.addRune(new SpecialRune("Rune of the Andermant Fever", Map.of(), "Increases the Andermant Fever talent by 5."));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffType.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffType.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Materi Blessing", OverallRelativeBuffType.MATERI_FRAGMENT_DROP_BONUS, 0.3));
        runeTrinket5.addRune(new Rune("Rune of Materi Blessing", OverallRelativeBuffType.MATERI_FRAGMENT_DROP_BONUS, 0.3));
        runeTrinket5.addRune(new SpecialRune("Rune of Rising Vigor", Map.of(OverallRelativeBuffType.MOVEMENT_SPEED, 0.10, OverallRelativeBuffType.ATTACK_SPEED, 0.06), ""));
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

        Pet mortisPet = new Pet("Mortis Doll", Map.of(OverallRelativeBuffType.ATTACK_SPEED, 0.3, OverallRelativeBuffType.MANA, 0.3, OverallRelativeBuffType.DAMAGE, 0.3, OverallRelativeBuffType.HEALTH_POINTS, 0.1), "");
        mage.setPet(mortisPet);
        mage.setCollectorBagBuff(Map.of(OverallRelativeBuffType.HEALTH_POINTS, 0.33, OverallRelativeBuffType.RESISTANCE, 0.15, OverallRelativeBuffType.DAMAGE, 0.06, OverallRelativeBuffType.BLOCK_VALUE, 0.02));

        Tonic tonic = new Tonic("Tonic of Vigor", AbsoluteStatType.DAMAGE, 10496.0);
        //mage.setTonic(tonic);
        Physic physic = new Physic("Advanced Physic of Vigor", OverallRelativeBuffType.DAMAGE, 0.18);
        //mage.setPhysic(physic);


        return mage;
    }

    public static Character sinasBuildNewDragan3() {
        Character mage = new Character(CharacterClass.SPELLWEAVER);

        Map<AbsoluteStatType, Double> amuletBaseStats = new HashMap<>();
        UniqueItem amulet = SpellweaverUniqueItems.AMULET_OF_THE_KRAKEN.getItem();
        amulet.setBaseStats(amuletBaseStats);
        amulet.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44563));
        amulet.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44563));
        amulet.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44563));
        amulet.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44563));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 700.0));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 700.0));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 700.0));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 700.0));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 700.0));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 700.0));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 700.0));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 700.0));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 700.0));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 700.0));
        mage.addItem(amulet, ItemSlot.AMULET);

        MythicItem cloak = SpellweaverMythicItem.ANCESTRAL_GLORY_CLOAK.getItem();
        cloak.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        mage.addItem(cloak, ItemSlot.CLOAK);

        Map<AbsoluteStatType, Double> beltBaseStats = new HashMap<>();
        beltBaseStats.put(AbsoluteStatType.DAMAGE, 1630.885);
        beltBaseStats.put(AbsoluteStatType.HEALTH_POINTS, 20072.654);
        beltBaseStats.put(AbsoluteStatType.RESISTANCE, 1679.873);
        UniqueItem belt = SpellweaverUniqueItems.BELT_OF_ZEAL.getItem();
        belt.setBaseStats(beltBaseStats);
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
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
        mage.addItem(belt, ItemSlot.BELT);

        MythicItem ring1 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring1.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        ring1.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        ring1.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        ring1.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        Opal opal = new Opal(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0), new Gem(AbsoluteStatType.DAMAGE, 700.0), new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
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
        mage.addItem(ring1, ItemSlot.RING1);
        MythicItem ring2 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring2.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        ring2.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        ring2.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        ring2.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        ring2.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        ring2.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        ring2.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        ring2.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        ring2.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        ring2.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        ring2.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        mage.addItem(ring2, ItemSlot.RING2);

        SetItem helmet = SpellweaverSetItems.HELMET_OF_THE_BLACK_KNIGHT.getItem();
        helmet.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        helmet.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        helmet.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        helmet.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        helmet.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        mage.addItem(helmet, ItemSlot.HELMET);

        SetItem shoulders = SpellweaverSetItems.SHOULDERS_OF_THE_END.getItem();
        shoulders.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        shoulders.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        shoulders.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44757));
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
        mage.addItem(shoulders, ItemSlot.SHOULDERS);

        SetItem torso = SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_TORSO.getItem();
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
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        mage.addItem(torso, ItemSlot.TORSO);

        Map<AbsoluteStatType, Double> glovesBaseStats = new HashMap<>();
        glovesBaseStats.put(AbsoluteStatType.DAMAGE, 1584.734);
        glovesBaseStats.put(AbsoluteStatType.ATTACK_SPEED, 0.052);
        glovesBaseStats.put(AbsoluteStatType.ARMOR, 653.453);
        UniqueItem gloves = SpellweaverUniqueItems.REIGN_OF_TERROR.getItem();
        gloves.setBaseStats(glovesBaseStats);
        gloves.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        gloves.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        gloves.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        gloves.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        mage.addItem(gloves, ItemSlot.GLOVES);

        Map<AbsoluteStatType, Double> bootsBaseStats = new HashMap<>();
        bootsBaseStats.put(AbsoluteStatType.DAMAGE, 1510.415);
        bootsBaseStats.put(AbsoluteStatType.MOVEMENT_SPEED, 1.113);
        bootsBaseStats.put(AbsoluteStatType.CRIT_VALUE, 1168.091);
        SetItem boots = SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_BOOTS.getItem();
        boots.setBaseStats(bootsBaseStats);
        boots.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        boots.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        boots.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        boots.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        mage.addItem(boots, ItemSlot.BOOTS);

        UniqueItem adornment = SpellweaverUniqueItems.SIGRISMARRS_ETERNAL_GRASP.getItem();
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        mage.addItem(adornment, ItemSlot.WEAPON_ADORNMENT);

        Map<AbsoluteStatType, Double> twoHandBaseStats = new HashMap<>();
        twoHandBaseStats.put(AbsoluteStatType.DAMAGE, 24570.982);
        twoHandBaseStats.put(AbsoluteStatType.CRIT_VALUE, 3321.515);
        UniqueItem twoHand = SpellweaverUniqueItems.GRIMACE_OF_THE_THUNDER_BEAST.getItem();
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
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffType.ARMOR, 0.065));
        runeTrinket5.addRune(new SpecialRune("Rune of the Realm Changer", Map.of(), "Increases the Realm Changer talent by 5."));
        runeTrinket5.addRune(new SpecialRune("Rune of the Andermant Fever", Map.of(), "Increases the Andermant Fever talent by 5."));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffType.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffType.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Materi Blessing", OverallRelativeBuffType.MATERI_FRAGMENT_DROP_BONUS, 0.3));
        runeTrinket5.addRune(new Rune("Rune of Materi Blessing", OverallRelativeBuffType.MATERI_FRAGMENT_DROP_BONUS, 0.3));
        runeTrinket5.addRune(new SpecialRune("Rune of Rising Vigor", Map.of(OverallRelativeBuffType.MOVEMENT_SPEED, 0.10, OverallRelativeBuffType.ATTACK_SPEED, 0.06), ""));
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

        Pet mortisPet = new Pet("Mortis Doll", Map.of(OverallRelativeBuffType.ATTACK_SPEED, 0.3, OverallRelativeBuffType.MANA, 0.3, OverallRelativeBuffType.DAMAGE, 0.3, OverallRelativeBuffType.HEALTH_POINTS, 0.1), "");
        mage.setPet(mortisPet);
        mage.setCollectorBagBuff(Map.of(OverallRelativeBuffType.HEALTH_POINTS, 0.33, OverallRelativeBuffType.RESISTANCE, 0.15, OverallRelativeBuffType.DAMAGE, 0.06, OverallRelativeBuffType.BLOCK_VALUE, 0.02));

        Tonic tonic = new Tonic("Tonic of Vigor", AbsoluteStatType.DAMAGE, 10496.0);
        //mage.setTonic(tonic);
        Physic physic = new Physic("Advanced Physic of Vigor", OverallRelativeBuffType.DAMAGE, 0.18);
        //mage.setPhysic(physic);


        return mage;
    }

    public static Character sinasBuildNewDragan4() {
        Character mage = new Character(CharacterClass.SPELLWEAVER);

        Map<AbsoluteStatType, Double> amuletBaseStats = new HashMap<>();
        amuletBaseStats.put(AbsoluteStatType.DAMAGE, 1495.899);
        amuletBaseStats.put(AbsoluteStatType.MOVEMENT_SPEED, 0.460);
        amuletBaseStats.put(AbsoluteStatType.HEALTH_POINTS, 23093.384);
        UniqueItem amulet = SpellweaverUniqueItems.SARGONS_SHADOW_AMULET.getItem();
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
        mage.addItem(amulet, ItemSlot.AMULET);

        MythicItem cloak = SpellweaverMythicItem.ANCESTRAL_GLORY_CLOAK.getItem();
        cloak.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        Opal opal = new Opal(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0), new Gem(AbsoluteStatType.DAMAGE, 700.0), new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
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
        mage.addItem(cloak, ItemSlot.CLOAK);

        Map<AbsoluteStatType, Double> beltBaseStats = new HashMap<>();
        beltBaseStats.put(AbsoluteStatType.DAMAGE, 1630.885);
        beltBaseStats.put(AbsoluteStatType.HEALTH_POINTS, 20072.654);
        beltBaseStats.put(AbsoluteStatType.RESISTANCE, 1679.873);
        UniqueItem belt = SpellweaverUniqueItems.BELT_OF_ZEAL.getItem();
        belt.setBaseStats(beltBaseStats);
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
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
        mage.addItem(belt, ItemSlot.BELT);

        MythicItem ring1 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring1.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        ring1.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        ring1.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        ring1.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        mage.addItem(ring1, ItemSlot.RING1);
        MythicItem ring2 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring2.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        ring2.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        ring2.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        ring2.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        ring2.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        ring2.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        ring2.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        ring2.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        ring2.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        ring2.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        ring2.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        mage.addItem(ring2, ItemSlot.RING2);

        SetItem helmet = SpellweaverSetItems.HELMET_OF_THE_BLACK_KNIGHT.getItem();
        helmet.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        helmet.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        helmet.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        helmet.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        helmet.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        mage.addItem(helmet, ItemSlot.HELMET);

        SetItem shoulders = SpellweaverSetItems.SHOULDERS_OF_THE_END.getItem();
        shoulders.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        shoulders.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        shoulders.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44757));
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
        mage.addItem(shoulders, ItemSlot.SHOULDERS);

        SetItem torso = SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_TORSO.getItem();
        torso.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        torso.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        torso.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        torso.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        mage.addItem(torso, ItemSlot.TORSO);

        Map<AbsoluteStatType, Double> glovesBaseStats = new HashMap<>();
        glovesBaseStats.put(AbsoluteStatType.DAMAGE, 1584.734);
        glovesBaseStats.put(AbsoluteStatType.ATTACK_SPEED, 0.052);
        glovesBaseStats.put(AbsoluteStatType.ARMOR, 653.453);
        UniqueItem gloves = SpellweaverUniqueItems.REIGN_OF_TERROR.getItem();
        gloves.setBaseStats(glovesBaseStats);
        gloves.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        gloves.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        gloves.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        gloves.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        mage.addItem(gloves, ItemSlot.GLOVES);

        Map<AbsoluteStatType, Double> bootsBaseStats = new HashMap<>();
        bootsBaseStats.put(AbsoluteStatType.DAMAGE, 1510.415);
        bootsBaseStats.put(AbsoluteStatType.MOVEMENT_SPEED, 1.113);
        bootsBaseStats.put(AbsoluteStatType.CRIT_VALUE, 1168.091);
        SetItem boots = SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_BOOTS.getItem();
        boots.setBaseStats(bootsBaseStats);
        boots.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        boots.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        boots.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        boots.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        mage.addItem(boots, ItemSlot.BOOTS);

        Map<AbsoluteStatType, Double> adornmentBaseStats = new HashMap<>();
        adornmentBaseStats.put(AbsoluteStatType.DAMAGE, 1876.970);
        adornmentBaseStats.put(AbsoluteStatType.ATTACK_SPEED, 0.047);
        adornmentBaseStats.put(AbsoluteStatType.CRIT_VALUE, 2066.609);
        UniqueItem adornment = SpellweaverUniqueItems.STINGER.getItem();
        adornment.setBaseStats(adornmentBaseStats);
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        mage.addItem(adornment, ItemSlot.WEAPON_ADORNMENT);

        Map<AbsoluteStatType, Double> twoHandBaseStats = new HashMap<>();
        twoHandBaseStats.put(AbsoluteStatType.DAMAGE, 24570.982);
        twoHandBaseStats.put(AbsoluteStatType.CRIT_VALUE, 3321.515);
        UniqueItem twoHand = SpellweaverUniqueItems.GRIMACE_OF_THE_THUNDER_BEAST.getItem();
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
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffType.ARMOR, 0.065));
        runeTrinket5.addRune(new SpecialRune("Rune of the Realm Changer", Map.of(), "Increases the Realm Changer talent by 5."));
        runeTrinket5.addRune(new SpecialRune("Rune of the Andermant Fever", Map.of(), "Increases the Andermant Fever talent by 5."));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffType.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffType.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Materi Blessing", OverallRelativeBuffType.MATERI_FRAGMENT_DROP_BONUS, 0.3));
        runeTrinket5.addRune(new Rune("Rune of Materi Blessing", OverallRelativeBuffType.MATERI_FRAGMENT_DROP_BONUS, 0.3));
        runeTrinket5.addRune(new SpecialRune("Rune of Rising Vigor", Map.of(OverallRelativeBuffType.MOVEMENT_SPEED, 0.10, OverallRelativeBuffType.ATTACK_SPEED, 0.06), ""));
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

        Pet mortisPet = new Pet("Mortis Doll", Map.of(OverallRelativeBuffType.ATTACK_SPEED, 0.3, OverallRelativeBuffType.MANA, 0.3, OverallRelativeBuffType.DAMAGE, 0.3, OverallRelativeBuffType.HEALTH_POINTS, 0.1), "");
        mage.setPet(mortisPet);
        mage.setCollectorBagBuff(Map.of(OverallRelativeBuffType.HEALTH_POINTS, 0.33, OverallRelativeBuffType.RESISTANCE, 0.15, OverallRelativeBuffType.DAMAGE, 0.06, OverallRelativeBuffType.BLOCK_VALUE, 0.02));

        Tonic tonic = new Tonic("Tonic of Vigor", AbsoluteStatType.DAMAGE, 10496.0);
        //mage.setTonic(tonic);
        Physic physic = new Physic("Advanced Physic of Vigor", OverallRelativeBuffType.DAMAGE, 0.18);
        //mage.setPhysic(physic);


        return mage;
    }


    public static Character bghMortis() {
        Character mage = new Character(CharacterClass.SPELLWEAVER);

        SetItem amulet = SpellweaverSetItems.AMULET_OF_DEATH.getItem();
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
        mage.addItem(amulet, ItemSlot.AMULET);

        MythicItem cloak = SpellweaverMythicItem.ANCESTRAL_GLORY_CLOAK.getItem();
        cloak.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        mage.addItem(cloak, ItemSlot.CLOAK);

        UniqueItem belt = SpellweaverUniqueItems.BELT_OF_ZEAL.getItem();
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
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
        mage.addItem(belt, ItemSlot.BELT);

        MythicItem ring1 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring1.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        ring1.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        ring1.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        ring1.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        mage.addItem(ring1, ItemSlot.RING1);
        MythicItem ring2 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring2.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        Opal opal = new Opal(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0), new Gem(AbsoluteStatType.DAMAGE, 700.0), new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
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
        mage.addItem(ring2, ItemSlot.RING2);

        SetItem helmet = SpellweaverSetItems.CAP_OF_DEATH.getItem();
        helmet.addEnchant(new Enchant(EnchantType.CRIT_VALUE, 0.24563));
        helmet.addEnchant(new Enchant(EnchantType.CRIT_VALUE, 0.24563));
        helmet.addEnchant(new Enchant(EnchantType.CRIT_VALUE, 0.24563));
        helmet.addEnchant(new Enchant(EnchantType.CRIT_VALUE, 0.24563));
        helmet.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        mage.addItem(helmet, ItemSlot.HELMET);

        SetItem shoulders = SpellweaverSetItems.SHOULDERS_OF_THE_BLACK_KNIGHT.getItem();
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
        mage.addItem(shoulders, ItemSlot.SHOULDERS);

        UniqueItem torso = SpellweaverUniqueItems.RESEARCHERS_COAT.getItem();
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
        mage.addItem(torso, ItemSlot.TORSO);

        SetItem gloves = SpellweaverSetItems.GLOVES_OF_THE_FLAME_CONQUEROR.getItem();
        gloves.addEnchant(new Enchant(EnchantType.ATTACK_SPEED, 0.47112));
        gloves.addEnchant(new Enchant(EnchantType.ATTACK_SPEED, 0.47112));
        gloves.addEnchant(new Enchant(EnchantType.ATTACK_SPEED, 0.47112));
        gloves.addEnchant(new Enchant(EnchantType.ATTACK_SPEED, 0.47112));
        gloves.addGem(new Gem(AbsoluteStatType.ATTACK_SPEED, 0.017));
        gloves.addGem(new Gem(AbsoluteStatType.ATTACK_SPEED, 0.017));
        gloves.addGem(new Gem(AbsoluteStatType.ATTACK_SPEED, 0.017));
        gloves.addGem(new Gem(AbsoluteStatType.ATTACK_SPEED, 0.017));
        gloves.addGem(new Gem(AbsoluteStatType.ATTACK_SPEED, 0.017));
        gloves.addGem(new Gem(AbsoluteStatType.ATTACK_SPEED, 0.017));
        gloves.addGem(new Gem(AbsoluteStatType.ATTACK_SPEED, 0.017));
        gloves.addGem(new Gem(AbsoluteStatType.ATTACK_SPEED, 0.017));
        gloves.addGem(new Gem(AbsoluteStatType.ATTACK_SPEED, 0.017));
        gloves.addGem(new Gem(AbsoluteStatType.ATTACK_SPEED, 0.017));
        mage.addItem(gloves, ItemSlot.GLOVES);

        UniqueItem  boots = SpellweaverUniqueItems.RESEARCHERS_BOOTS.getItem();
        boots.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        boots.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        boots.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        boots.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        mage.addItem(boots, ItemSlot.BOOTS);

        UniqueItem adornment = SpellweaverUniqueItems.STINGER.getItem();
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        mage.addItem(adornment, ItemSlot.WEAPON_ADORNMENT);

        UniqueItem twoHand = SpellweaverUniqueItems.GRIMACE_OF_THE_THUNDER_BEAST.getItem();
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
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffType.ARMOR, 0.065));
        runeTrinket5.addRune(new SpecialRune("Rune of the Realm Changer", Map.of(), "Increases the Realm Changer talent by 5."));
        runeTrinket5.addRune(new SpecialRune("Rune of the Andermant Fever", Map.of(), "Increases the Andermant Fever talent by 5."));
        runeTrinket5.addRune(new SpecialRune("Rune of Rising Vigor", Map.of(OverallRelativeBuffType.MOVEMENT_SPEED, 0.10, OverallRelativeBuffType.ATTACK_SPEED, 0.06), ""));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffType.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Materi Blessing", OverallRelativeBuffType.MATERI_FRAGMENT_DROP_BONUS, 0.3));
        runeTrinket5.addRune(new Rune("Rune of Materi Blessing", OverallRelativeBuffType.MATERI_FRAGMENT_DROP_BONUS, 0.3));
        runeTrinket5.addRune(new Rune("Rune of Materi Blessing", OverallRelativeBuffType.MATERI_FRAGMENT_DROP_BONUS, 0.3));
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

        Pet mortisPet = new Pet("Paul", Map.of(OverallRelativeBuffType.HEALTH_POINTS, 0.505, OverallRelativeBuffType.ARMOR, 0.18), "");
        mage.setPet(mortisPet);
        mage.setCollectorBagBuff(Map.of(OverallRelativeBuffType.HEALTH_POINTS, 0.33, OverallRelativeBuffType.RESISTANCE, 0.15, OverallRelativeBuffType.DAMAGE, 0.06, OverallRelativeBuffType.BLOCK_VALUE, 0.02));

        Tonic tonic = new Tonic("Tonic of Vigor", AbsoluteStatType.HEALTH_POINTS, 156068.0);
        mage.setTonic(tonic);
        Physic physic = new Physic("Advanced Physic of Vigor", OverallRelativeBuffType.HEALTH_POINTS, 0.18);
        mage.setPhysic(physic);


        return mage;
    }

    public static Character bghMaxDmgMageMortis() {
        Character mage = new Character(CharacterClass.SPELLWEAVER);

        SetItem amulet = SpellweaverSetItems.AMULET_OF_DEATH.getItem();
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
        mage.addItem(amulet, ItemSlot.AMULET);

        MythicItem cloak = SpellweaverMythicItem.ANCESTRAL_GLORY_CLOAK.getItem();
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
        mage.addItem(cloak, ItemSlot.CLOAK);

        UniqueItem belt = SpellweaverUniqueItems.BELT_OF_ZEAL.getItem();
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
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
        mage.addItem(belt, ItemSlot.BELT);

        MythicItem ring1 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring1.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        ring1.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        ring1.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        ring1.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        mage.addItem(ring1, ItemSlot.RING1);
        MythicItem ring2 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring2.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        Opal opal = new Opal(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0), new Gem(AbsoluteStatType.DAMAGE, 700.0), new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
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
        mage.addItem(ring2, ItemSlot.RING2);

        SetItem helmet = SpellweaverSetItems.CAP_OF_DEATH.getItem();
        helmet.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        helmet.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        helmet.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        helmet.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        helmet.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        helmet.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        mage.addItem(helmet, ItemSlot.HELMET);

        UniqueItem shoulders = SpellweaverUniqueItems.KHALYS_DARK_SCHEME.getItem();
        shoulders.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        shoulders.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        shoulders.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        shoulders.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        shoulders.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        mage.addItem(shoulders, ItemSlot.SHOULDERS);

        SetItem torso = SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_TORSO.getItem();
        torso.addEnchant(new Enchant(EnchantType.ARMOR, 0.44776));
        torso.addEnchant(new Enchant(EnchantType.ARMOR, 0.44776));
        torso.addEnchant(new Enchant(EnchantType.ARMOR, 0.44776));
        torso.addEnchant(new Enchant(EnchantType.ARMOR, 0.44776));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        mage.addItem(torso, ItemSlot.TORSO);

        UniqueItem gloves = SpellweaverUniqueItems.REIGN_OF_TERROR.getItem();
        gloves.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        gloves.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        gloves.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        gloves.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        gloves.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        mage.addItem(gloves, ItemSlot.GLOVES);

        SetItem  boots = SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_BOOTS.getItem();
        boots.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        boots.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        boots.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        boots.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        mage.addItem(boots, ItemSlot.BOOTS);

        UniqueItem adornment = SpellweaverUniqueItems.STINGER.getItem();
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        mage.addItem(adornment, ItemSlot.WEAPON_ADORNMENT);

        UniqueItem twoHand = SpellweaverUniqueItems.GRIMACE_OF_THE_THUNDER_BEAST.getItem();
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
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffType.ARMOR, 0.065));
        runeTrinket5.addRune(new SpecialRune("Rune of the Realm Changer", Map.of(), "Increases the Realm Changer talent by 5."));
        runeTrinket5.addRune(new SpecialRune("Rune of the Andermant Fever", Map.of(), "Increases the Andermant Fever talent by 5."));
        runeTrinket5.addRune(new SpecialRune("Rune of Rising Vigor", Map.of(OverallRelativeBuffType.MOVEMENT_SPEED, 0.10, OverallRelativeBuffType.ATTACK_SPEED, 0.06), ""));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffType.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Materi Blessing", OverallRelativeBuffType.MATERI_FRAGMENT_DROP_BONUS, 0.3));
        runeTrinket5.addRune(new Rune("Rune of Materi Blessing", OverallRelativeBuffType.MATERI_FRAGMENT_DROP_BONUS, 0.3));
        runeTrinket5.addRune(new Rune("Rune of Materi Blessing", OverallRelativeBuffType.MATERI_FRAGMENT_DROP_BONUS, 0.3));
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

        mage.setEssence(0.00);

        Pet mortisPet = new Pet("Mortis Doll", Map.of(OverallRelativeBuffType.ATTACK_SPEED, 0.3, OverallRelativeBuffType.MANA, 0.3, OverallRelativeBuffType.DAMAGE, 0.3), "");
        mage.setPet(mortisPet);
        mage.setCollectorBagBuff(Map.of(OverallRelativeBuffType.HEALTH_POINTS, 0.33, OverallRelativeBuffType.RESISTANCE, 0.15, OverallRelativeBuffType.DAMAGE, 0.06, OverallRelativeBuffType.BLOCK_VALUE, 0.02));

        Tonic tonic = new Tonic("Tonic of Vigor", AbsoluteStatType.DAMAGE, 10496.0);
        mage.setTonic(tonic);
        Physic physic = new Physic("Advanced Physic of Vigor", OverallRelativeBuffType.DAMAGE, 0.18);
        mage.setPhysic(physic);


        return mage;
    }

    public static Character draganMage() {
        Character mage = new Character(CharacterClass.SPELLWEAVER);

        Map<AbsoluteStatType, Double> amuletBaseStats = new HashMap<>();
        amuletBaseStats.put(AbsoluteStatType.DAMAGE, 1495.899);
        amuletBaseStats.put(AbsoluteStatType.MOVEMENT_SPEED, 0.460);
        amuletBaseStats.put(AbsoluteStatType.HEALTH_POINTS, 23093.384);
        UniqueItem amulet = SpellweaverUniqueItems.SARGONS_SHADOW_AMULET.getItem();
        amulet.setBaseStats(amuletBaseStats);
        amulet.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44743));
        amulet.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44749));
        amulet.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44734));
        amulet.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44746));
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
        mage.addItem(amulet, ItemSlot.AMULET);

        SetItem cloak = SpellweaverSetItems.CLOAK_OF_THE_BLACK_KNIGHT.getItem();
        cloak.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44750));
        cloak.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44750));
        cloak.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44750));
        cloak.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44750));
        cloak.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        cloak.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        cloak.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        cloak.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        cloak.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        cloak.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        cloak.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        cloak.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        cloak.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        cloak.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        mage.addItem(cloak, ItemSlot.CLOAK);

        Map<AbsoluteStatType, Double> beltBaseStats = new HashMap<>();
        beltBaseStats.put(AbsoluteStatType.DAMAGE, 1630.885);
        beltBaseStats.put(AbsoluteStatType.HEALTH_POINTS, 20072.654);
        beltBaseStats.put(AbsoluteStatType.RESISTANCE, 1679.873);
        UniqueItem belt = SpellweaverUniqueItems.BELT_OF_ZEAL.getItem();
        belt.setBaseStats(beltBaseStats);
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
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
        mage.addItem(belt, ItemSlot.BELT);

        MythicItem ring1 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring1.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        ring1.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        ring1.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        ring1.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        Opal opal = new Opal(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0), new Gem(AbsoluteStatType.DAMAGE, 700.0), new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
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
        mage.addItem(ring1, ItemSlot.RING1);
        MythicItem ring2 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
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
        mage.addItem(ring2, ItemSlot.RING2);

        SetItem helmet = SpellweaverSetItems.HELMET_OF_THE_BLACK_KNIGHT.getItem();
        helmet.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44750));
        helmet.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44750));
        helmet.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44750));
        helmet.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44750));
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
        mage.addItem(helmet, ItemSlot.HELMET);

        SetItem shoulders = SpellweaverSetItems.SHOULDERS_OF_THE_BLACK_KNIGHT.getItem();
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
        mage.addItem(shoulders, ItemSlot.SHOULDERS);

        Map<AbsoluteStatType, Double> torsoBaseStats = new HashMap<>();
        torsoBaseStats.put(AbsoluteStatType.DAMAGE, 1566.12);
        torsoBaseStats.put(AbsoluteStatType.HEALTH_POINTS, 15903.888);
        torsoBaseStats.put(AbsoluteStatType.ARMOR, 1484.796);
        UniqueItem torso = SpellweaverUniqueItems.SIGRISMARRS_ETERNAL_WARD.getItem();
        torso.setBaseStats(torsoBaseStats);
        torso.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44750));
        torso.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44750));
        torso.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44750));
        torso.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44750));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        mage.addItem(torso, ItemSlot.TORSO);

        Map<AbsoluteStatType, Double> glovesBaseStats = new HashMap<>();
        glovesBaseStats.put(AbsoluteStatType.ATTACK_SPEED, 0.052);
        glovesBaseStats.put(AbsoluteStatType.CRIT_VALUE, 1752.39);
        glovesBaseStats.put(AbsoluteStatType.LIGHTNING_RESISTANCE, 3587.036);
        UniqueItem gloves = SpellweaverUniqueItems.ABYSSAL_TREASURE_GLOVES.getItem();
        gloves.setBaseStats(glovesBaseStats);
        gloves.addEnchant(new Enchant(EnchantType.ATTACK_SPEED, 0.44776));
        gloves.addEnchant(new Enchant(EnchantType.ATTACK_SPEED, 0.44776));
        gloves.addEnchant(new Enchant(EnchantType.ATTACK_SPEED, 0.44776));
        gloves.addEnchant(new Enchant(EnchantType.ATTACK_SPEED, 0.44776));
        gloves.addGem(new Gem(AbsoluteStatType.ATTACK_SPEED, 0.017));
        gloves.addGem(new Gem(AbsoluteStatType.ATTACK_SPEED, 0.017));
        gloves.addGem(new Gem(AbsoluteStatType.ATTACK_SPEED, 0.017));
        gloves.addGem(new Gem(AbsoluteStatType.ATTACK_SPEED, 0.017));
        gloves.addGem(new Gem(AbsoluteStatType.ATTACK_SPEED, 0.017));
        gloves.addGem(new Gem(AbsoluteStatType.ATTACK_SPEED, 0.017));
        gloves.addGem(new Gem(AbsoluteStatType.ATTACK_SPEED, 0.017));
        gloves.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        gloves.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        gloves.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        mage.addItem(gloves, ItemSlot.GLOVES);

        Map<AbsoluteStatType, Double> bootsBaseStats = new HashMap<>();
        bootsBaseStats.put(AbsoluteStatType.DAMAGE, 1572.484);
        bootsBaseStats.put(AbsoluteStatType.MOVEMENT_SPEED, 1.180);
        bootsBaseStats.put(AbsoluteStatType.CRIT_VALUE, 1265.479);
        UniqueItem boots = SpellweaverUniqueItems.RESEARCHERS_BOOTS.getItem();
        boots.setBaseStats(bootsBaseStats);
        boots.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44750));
        boots.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44750));
        boots.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44759));
        boots.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44759));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        mage.addItem(boots, ItemSlot.BOOTS);

        Map<AbsoluteStatType, Double> adornmentBaseStats = new HashMap<>();
        adornmentBaseStats.put(AbsoluteStatType.DAMAGE, 1885.747);
        adornmentBaseStats.put(AbsoluteStatType.ATTACK_SPEED, 0.039);
        adornmentBaseStats.put(AbsoluteStatType.CRIT_VALUE, 1855.476);
        UniqueItem adornment = SpellweaverUniqueItems.STINGER.getItem();
        adornment.setBaseStats(adornmentBaseStats);
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44771));
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44767));
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44775));
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44772));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        mage.addItem(adornment, ItemSlot.WEAPON_ADORNMENT);

        Map<AbsoluteStatType, Double> twoHandBaseStats = new HashMap<>();
        twoHandBaseStats.put(AbsoluteStatType.DAMAGE, 24570.982);
        twoHandBaseStats.put(AbsoluteStatType.CRIT_VALUE, 3321.515);
        Map<AbsoluteStatType, Double> twoHandUniqueBaseStats = new HashMap<>();
        twoHandUniqueBaseStats.put(AbsoluteStatType.ATTACK_SPEED, 0.102);
        UniqueItem twoHand = SpellweaverUniqueItems.GRIMACE_OF_THE_THUNDER_BEAST.getItem();
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
        runeTrinket2.addRune(new Rune("Rune of Resilience", OverallRelativeBuffType.RESISTANCE, 0.065));
        runeTrinket2.addRune(new SpecialRune("Rune of Rising Vigor", Map.of(OverallRelativeBuffType.MOVEMENT_SPEED, 0.10, OverallRelativeBuffType.ATTACK_SPEED, 0.06), ""));
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
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffType.ARMOR, 0.065));
        runeTrinket5.addRune(new SpecialRune("Rune of the Realm Changer", Map.of(), "Increases the Realm Changer talent by 5."));
        runeTrinket5.addRune(new SpecialRune("Rune of the Andermant Fever", Map.of(), "Increases the Andermant Fever talent by 5."));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffType.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffType.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Materi Blessing", OverallRelativeBuffType.MATERI_FRAGMENT_DROP_BONUS, 0.3));
        runeTrinket5.addRune(new Rune("Rune of Materi Blessing", OverallRelativeBuffType.MATERI_FRAGMENT_DROP_BONUS, 0.3));
        runeTrinket5.addRune(new Rune("Rune of Materi Blessing", OverallRelativeBuffType.MATERI_FRAGMENT_DROP_BONUS, 0.3));
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

        mage.setEssence(0.50);

        Pet mortisPet = new Pet("Mortis Doll", Map.of(OverallRelativeBuffType.ATTACK_SPEED, 0.3, OverallRelativeBuffType.MANA, 0.3, OverallRelativeBuffType.DAMAGE, 0.3), "");
        mage.setPet(mortisPet);
        mage.setCollectorBagBuff(Map.of(OverallRelativeBuffType.HEALTH_POINTS, 0.33, OverallRelativeBuffType.RESISTANCE, 0.15, OverallRelativeBuffType.DAMAGE, 0.06, OverallRelativeBuffType.BLOCK_VALUE, 0.02));

        Tonic tonic = new Tonic("Tonic of Vigor", AbsoluteStatType.DAMAGE, 10496.0);
        //mage.setTonic(tonic);
        Physic physic = new Physic("Advanced Physic of Vigor", OverallRelativeBuffType.DAMAGE, 0.18);
        //mage.setPhysic(physic);


        return mage;
    }

    public static Character bghMaxDmgMage() {
        Character mage = new Character(CharacterClass.SPELLWEAVER);

        UniqueItem amulet = SpellweaverUniqueItems.SARGONS_SHADOW_AMULET.getItem();
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
        mage.addItem(amulet, ItemSlot.AMULET);

        MythicItem cloak = SpellweaverMythicItem.ANCESTRAL_GLORY_CLOAK.getItem();
        cloak.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        mage.addItem(cloak, ItemSlot.CLOAK);

        UniqueItem belt = SpellweaverUniqueItems.BELT_OF_ZEAL.getItem();
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
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
        mage.addItem(belt, ItemSlot.BELT);

        MythicItem ring1 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring1.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        ring1.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        ring1.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        ring1.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        ring1.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        mage.addItem(ring1, ItemSlot.RING1);
        MythicItem ring2 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
        ring2.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        ring2.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        Opal opal = new Opal(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0), new Gem(AbsoluteStatType.DAMAGE, 700.0), new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
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
        mage.addItem(ring2, ItemSlot.RING2);

        SetItem helmet = SpellweaverSetItems.SARGONS_HORNS.getItem();
        helmet.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        helmet.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        helmet.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        helmet.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
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
        mage.addItem(helmet, ItemSlot.HELMET);

        SetItem shoulders = SpellweaverSetItems.SARGONS_PAULDRONS.getItem();
        shoulders.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        shoulders.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        shoulders.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        shoulders.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        shoulders.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        mage.addItem(shoulders, ItemSlot.SHOULDERS);

        Map<AbsoluteStatType, Double> torsoBaseStats = new HashMap<>();
        torsoBaseStats.put(AbsoluteStatType.DAMAGE, 1631.657);
        torsoBaseStats.put(AbsoluteStatType.HEALTH_POINTS, 14232.794);
        torsoBaseStats.put(AbsoluteStatType.ARMOR, 1639.716);
        SetItem torso = SpellweaverSetItems.SARGONS_TORSO.getItem();
        torso.setBaseStats(torsoBaseStats);
        torso.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        torso.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        torso.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        torso.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        mage.addItem(torso, ItemSlot.TORSO);

        SetItem gloves = SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_GLOVES.getItem();
        gloves.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        gloves.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        gloves.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        gloves.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
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
        mage.addItem(gloves, ItemSlot.GLOVES);

        SetItem boots = SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_BOOTS.getItem();
        boots.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        boots.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        boots.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        boots.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        mage.addItem(boots, ItemSlot.BOOTS);

        UniqueItem adornment = SpellweaverUniqueItems.STINGER.getItem();
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        adornment.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        mage.addItem(adornment, ItemSlot.WEAPON_ADORNMENT);

        UniqueItem twoHand = SpellweaverUniqueItems.GRIMACE_OF_THE_THUNDER_BEAST.getItem();
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
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffType.ARMOR, 0.065));
        runeTrinket5.addRune(new SpecialRune("Rune of the Realm Changer", Map.of(), "Increases the Realm Changer talent by 5."));
        runeTrinket5.addRune(new SpecialRune("Rune of the Andermant Fever", Map.of(), "Increases the Andermant Fever talent by 5."));
        runeTrinket5.addRune(new SpecialRune("Rune of Rising Vigor", Map.of(OverallRelativeBuffType.MOVEMENT_SPEED, 0.10, OverallRelativeBuffType.ATTACK_SPEED, 0.06), ""));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffType.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Materi Blessing", OverallRelativeBuffType.MATERI_FRAGMENT_DROP_BONUS, 0.3));
        runeTrinket5.addRune(new Rune("Rune of Materi Blessing", OverallRelativeBuffType.MATERI_FRAGMENT_DROP_BONUS, 0.3));
        runeTrinket5.addRune(new Rune("Rune of Materi Blessing", OverallRelativeBuffType.MATERI_FRAGMENT_DROP_BONUS, 0.3));
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

        mage.setEssence(0.50);

        Pet mortisPet = new Pet("Mortis Doll", Map.of(OverallRelativeBuffType.ATTACK_SPEED, 0.3, OverallRelativeBuffType.MANA, 0.3, OverallRelativeBuffType.DAMAGE, 0.3), "");
        mage.setPet(mortisPet);
        mage.setCollectorBagBuff(Map.of(OverallRelativeBuffType.HEALTH_POINTS, 0.33, OverallRelativeBuffType.RESISTANCE, 0.15, OverallRelativeBuffType.DAMAGE, 0.06, OverallRelativeBuffType.BLOCK_VALUE, 0.02));

        Tonic tonic = new Tonic("Tonic of Vigor", AbsoluteStatType.DAMAGE, 10496.0);
        //mage.setTonic(tonic);
        Physic physic = new Physic("Advanced Physic of Vigor", OverallRelativeBuffType.DAMAGE, 0.18);
        //mage.setPhysic(physic);


        return mage;
    }

    public static Character bghMaxDmgMage2() {
        Character mage = new Character(CharacterClass.SPELLWEAVER);

        UniqueItem amulet = SpellweaverUniqueItems.AMULET_OF_THE_KRAKEN.getItem();
        amulet.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44776));
        amulet.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44776));
        amulet.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44776));
        amulet.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44776));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        mage.addItem(amulet, ItemSlot.AMULET);

        MythicItem cloak = SpellweaverMythicItem.ANCESTRAL_GLORY_CLOAK.getItem();
        cloak.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        mage.addItem(cloak, ItemSlot.CLOAK);

        UniqueItem belt = SpellweaverUniqueItems.BELT_OF_ZEAL.getItem();
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
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
        mage.addItem(belt, ItemSlot.BELT);

        MythicItem ring1 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
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
        mage.addItem(ring1, ItemSlot.RING1);
        MythicItem ring2 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
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
        mage.addItem(ring2, ItemSlot.RING2);

        SetItem helmet = SpellweaverSetItems.SARGONS_HORNS.getItem();
        helmet.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        helmet.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        helmet.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        helmet.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
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
        mage.addItem(helmet, ItemSlot.HELMET);

        SetItem shoulders = SpellweaverSetItems.SARGONS_PAULDRONS.getItem();
        shoulders.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        shoulders.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        shoulders.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        shoulders.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        shoulders.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        mage.addItem(shoulders, ItemSlot.SHOULDERS);

        Map<AbsoluteStatType, Double> torsoBaseStats = new HashMap<>();
        torsoBaseStats.put(AbsoluteStatType.DAMAGE, 1631.657);
        torsoBaseStats.put(AbsoluteStatType.HEALTH_POINTS, 14232.794);
        torsoBaseStats.put(AbsoluteStatType.ARMOR, 1639.716);
        SetItem torso = SpellweaverSetItems.SARGONS_TORSO.getItem();
        torso.setBaseStats(torsoBaseStats);
        torso.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        torso.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        torso.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        torso.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        mage.addItem(torso, ItemSlot.TORSO);

        SetItem gloves = SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_GLOVES.getItem();
        gloves.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        gloves.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        gloves.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        gloves.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
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
        mage.addItem(gloves, ItemSlot.GLOVES);

        SetItem boots = SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_BOOTS.getItem();
        boots.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        boots.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        boots.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        boots.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        mage.addItem(boots, ItemSlot.BOOTS);

        UniqueItem adornment = SpellweaverUniqueItems.SIGRISMARRS_ETERNAL_GRASP.getItem();
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        Opal opal = new Opal(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0), new Gem(AbsoluteStatType.DAMAGE, 700.0), new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
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
        mage.addItem(adornment, ItemSlot.WEAPON_ADORNMENT);

        UniqueItem twoHand = SpellweaverUniqueItems.GRIMACE_OF_THE_THUNDER_BEAST.getItem();
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
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffType.ARMOR, 0.065));
        runeTrinket5.addRune(new SpecialRune("Rune of the Realm Changer", Map.of(), "Increases the Realm Changer talent by 5."));
        runeTrinket5.addRune(new SpecialRune("Rune of the Andermant Fever", Map.of(), "Increases the Andermant Fever talent by 5."));
        runeTrinket5.addRune(new SpecialRune("Rune of Rising Vigor", Map.of(OverallRelativeBuffType.MOVEMENT_SPEED, 0.10, OverallRelativeBuffType.ATTACK_SPEED, 0.06), ""));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffType.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffType.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Materi Blessing", OverallRelativeBuffType.MATERI_FRAGMENT_DROP_BONUS, 0.3));
        runeTrinket5.addRune(new Rune("Rune of Materi Blessing", OverallRelativeBuffType.MATERI_FRAGMENT_DROP_BONUS, 0.3));
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

        mage.setEssence(0.50);

        Pet mortisPet = new Pet("Mortis Doll", Map.of(OverallRelativeBuffType.ATTACK_SPEED, 0.3, OverallRelativeBuffType.MANA, 0.3, OverallRelativeBuffType.DAMAGE, 0.3), "");
        mage.setPet(mortisPet);
        mage.setCollectorBagBuff(Map.of(OverallRelativeBuffType.HEALTH_POINTS, 0.33, OverallRelativeBuffType.RESISTANCE, 0.15, OverallRelativeBuffType.DAMAGE, 0.06, OverallRelativeBuffType.BLOCK_VALUE, 0.02));

        Tonic tonic = new Tonic("Tonic of Vigor", AbsoluteStatType.DAMAGE, 10496.0);
        //mage.setTonic(tonic);
        Physic physic = new Physic("Advanced Physic of Vigor", OverallRelativeBuffType.DAMAGE, 0.18);
        //mage.setPhysic(physic);


        return mage;
    }

    public static Character swerdMage() {
        Character mage = new Character(CharacterClass.SPELLWEAVER);

        Map<AbsoluteStatType, Double> amuletBaseStats = new HashMap<>();
        amuletBaseStats.put(AbsoluteStatType.HEALTH_POINTS, 24323.032);
        amuletBaseStats.put(AbsoluteStatType.RESISTANCE, 1102.014);
        amuletBaseStats.put(AbsoluteStatType.BLOCK_VALUE, 1979.579);
        UniqueItem amulet = SpellweaverUniqueItems.KINGSHILL_NECKLACE.getItem();
        amulet.setBaseStats(amuletBaseStats);
        amulet.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        amulet.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        amulet.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        amulet.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44537));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        amulet.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        mage.addItem(amulet, ItemSlot.AMULET);

        UniqueItem cloak = SpellweaverUniqueItems.DUPLICITOUS_TROPHY.getItem();
        cloak.addEnchant(new Enchant(EnchantType.BLOCK_VALUE, 0.2430));
        cloak.addEnchant(new Enchant(EnchantType.BLOCK_VALUE, 0.2430));
        cloak.addEnchant(new Enchant(EnchantType.BLOCK_VALUE, 0.2430));
        cloak.addEnchant(new Enchant(EnchantType.BLOCK_VALUE, 0.2430));
        cloak.addGem(new Gem(AbsoluteStatType.BLOCK_VALUE, 2520.0));
        cloak.addGem(new Gem(AbsoluteStatType.BLOCK_VALUE, 2520.0));
        cloak.addGem(new Gem(AbsoluteStatType.BLOCK_VALUE, 2520.0));
        cloak.addGem(new Gem(AbsoluteStatType.BLOCK_VALUE, 2520.0));
        cloak.addGem(new Gem(AbsoluteStatType.BLOCK_VALUE, 2520.0));
        cloak.addGem(new Gem(AbsoluteStatType.BLOCK_VALUE, 2520.0));
        cloak.addGem(new Gem(AbsoluteStatType.BLOCK_VALUE, 2520.0));
        cloak.addGem(new Gem(AbsoluteStatType.BLOCK_VALUE, 2520.0));
        cloak.addGem(new Gem(AbsoluteStatType.BLOCK_VALUE, 2520.0));
        cloak.addGem(new Gem(AbsoluteStatType.BLOCK_VALUE, 2520.0));
        mage.addItem(cloak, ItemSlot.CLOAK);

        Map<AbsoluteStatType, Double> beltBaseStats = new HashMap<>();
        beltBaseStats.put(AbsoluteStatType.HEALTH_POINTS, 22808.696);
        beltBaseStats.put(AbsoluteStatType.FIRE_RESISTANCE, 5313.336);
        beltBaseStats.put(AbsoluteStatType.ICE_RESISTANCE, 5348.49);
        UniqueItem belt = SpellweaverUniqueItems.INQUIRING_MIND.getItem();
        belt.setBaseStats(beltBaseStats);
        belt.addEnchant(new Enchant(EnchantType.BLOCK_VALUE, 0.2430));
        belt.addEnchant(new Enchant(EnchantType.BLOCK_VALUE, 0.2430));
        belt.addEnchant(new Enchant(EnchantType.BLOCK_VALUE, 0.2430));
        belt.addEnchant(new Enchant(EnchantType.BLOCK_VALUE, 0.2430));
        belt.addGem(new Gem(AbsoluteStatType.BLOCK_VALUE, 2520.0));
        belt.addGem(new Gem(AbsoluteStatType.BLOCK_VALUE, 2520.0));
        belt.addGem(new Gem(AbsoluteStatType.BLOCK_VALUE, 2520.0));
        belt.addGem(new Gem(AbsoluteStatType.BLOCK_VALUE, 2520.0));
        belt.addGem(new Gem(AbsoluteStatType.BLOCK_VALUE, 2520.0));
        belt.addGem(new Gem(AbsoluteStatType.BLOCK_VALUE, 2520.0));
        belt.addGem(new Gem(AbsoluteStatType.BLOCK_VALUE, 2520.0));
        belt.addGem(new Gem(AbsoluteStatType.BLOCK_VALUE, 2520.0));
        belt.addGem(new Gem(AbsoluteStatType.BLOCK_VALUE, 2520.0));
        belt.addGem(new Gem(AbsoluteStatType.BLOCK_VALUE, 2520.0));
        mage.addItem(belt, ItemSlot.BELT);

        MythicItem ring1 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
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
        mage.addItem(ring1, ItemSlot.RING1);
        MythicItem ring2 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
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
        mage.addItem(ring2, ItemSlot.RING2);

        SetItem helmet = SpellweaverSetItems.HELMET_OF_THE_BLACK_KNIGHT.getItem();
        helmet.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.4452));
        helmet.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44364));
        helmet.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44483));
        helmet.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44430));
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
        mage.addItem(helmet, ItemSlot.HELMET);

        Map<AbsoluteStatType, Double> shouldersBaseStats = new HashMap<>();
        shouldersBaseStats.put(AbsoluteStatType.DAMAGE, 1733.935);
        shouldersBaseStats.put(AbsoluteStatType.HEALTH_POINTS, 16173.498);
        shouldersBaseStats.put(AbsoluteStatType.POISON_RESISTANCE, 3429.474);
        UniqueItem shoulders = SpellweaverUniqueItems.ABYSSAL_TREASURE_PAULDRONS.getItem();
        shoulders.setBaseStats(shouldersBaseStats);
        shoulders.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.4452));
        shoulders.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.4452));
        shoulders.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.4452));
        shoulders.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.4452));
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
        mage.addItem(shoulders, ItemSlot.SHOULDERS);

        Map<AbsoluteStatType, Double> torsoBaseStats = new HashMap<>();
        torsoBaseStats.put(AbsoluteStatType.HEALTH_POINTS, 13176.974);
        torsoBaseStats.put(AbsoluteStatType.ARMOR, 1555.369);
        torsoBaseStats.put(AbsoluteStatType.RESISTANCE, 1632.456);
        UniqueItem torso = SpellweaverUniqueItems.RESEARCHERS_COAT.getItem();
        torso.setBaseStats(torsoBaseStats);
        torso.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44263));
        torso.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44415));
        torso.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44382));
        torso.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44237));
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
        mage.addItem(torso, ItemSlot.TORSO);

        UniqueItem gloves = SpellweaverUniqueItems.GLOVES_OF_THE_BLACK_KNIGHT.getItem();
        gloves.addEnchant(new Enchant(EnchantType.RESISTANCE, 0.26930));
        gloves.addEnchant(new Enchant(EnchantType.RESISTANCE, 0.26930));
        gloves.addEnchant(new Enchant(EnchantType.RESISTANCE, 0.26930));
        gloves.addEnchant(new Enchant(EnchantType.RESISTANCE, 0.26930));
        gloves.addGem(new Gem(AbsoluteStatType.RESISTANCE, 1110.0));
        gloves.addGem(new Gem(AbsoluteStatType.RESISTANCE, 1110.0));
        gloves.addGem(new Gem(AbsoluteStatType.RESISTANCE, 1110.0));
        gloves.addGem(new Gem(AbsoluteStatType.RESISTANCE, 1110.0));
        gloves.addGem(new Gem(AbsoluteStatType.RESISTANCE, 1110.0));
        gloves.addGem(new Gem(AbsoluteStatType.RESISTANCE, 1110.0));
        gloves.addGem(new Gem(AbsoluteStatType.RESISTANCE, 1110.0));
        gloves.addGem(new Gem(AbsoluteStatType.RESISTANCE, 1110.0));
        gloves.addGem(new Gem(AbsoluteStatType.RESISTANCE, 1110.0));
        gloves.addGem(new Gem(AbsoluteStatType.RESISTANCE, 1110.0));
        mage.addItem(gloves, ItemSlot.GLOVES);

        Map<AbsoluteStatType, Double> bootsBaseStats = new HashMap<>();
        bootsBaseStats.put(AbsoluteStatType.DAMAGE, 1472.688);
        bootsBaseStats.put(AbsoluteStatType.MOVEMENT_SPEED, 0.986);
        bootsBaseStats.put(AbsoluteStatType.CRIT_VALUE, 1271.924);
        SetItem boots = SpellweaverSetItems.BOOTS_OF_THE_FLAME_CONQUEROR.getItem();
        boots.setBaseStats(bootsBaseStats);
        boots.addEnchant(new Enchant(EnchantType.MOVEMENT_SPEED, 0.22410));
        boots.addEnchant(new Enchant(EnchantType.MOVEMENT_SPEED, 0.22410));
        boots.addEnchant(new Enchant(EnchantType.MOVEMENT_SPEED, 0.22410));
        boots.addEnchant(new Enchant(EnchantType.MOVEMENT_SPEED, 0.22410));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        mage.addItem(boots, ItemSlot.BOOTS);

        Map<AbsoluteStatType, Double> adornmentBaseStats = new HashMap<>();
        adornmentBaseStats.put(AbsoluteStatType.DAMAGE, 1885.747);
        adornmentBaseStats.put(AbsoluteStatType.ATTACK_SPEED, 0.039);
        adornmentBaseStats.put(AbsoluteStatType.CRIT_VALUE, 1855.476);
        UniqueItem adornment = SpellweaverUniqueItems.STINGER.getItem();
        adornment.setBaseStats(adornmentBaseStats);
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44771));
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44767));
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44775));
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44772));
        Opal opal = new Opal(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0), new Gem(AbsoluteStatType.DAMAGE, 700.0), new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
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
        mage.addItem(adornment, ItemSlot.WEAPON_ADORNMENT);

        SetItem oneHand = SpellweaverSetItems.KRANPARUS_ICY_STAFF.getItem();
        oneHand.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        oneHand.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        oneHand.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        oneHand.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        oneHand.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        oneHand.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        oneHand.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        oneHand.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        oneHand.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        oneHand.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        oneHand.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        oneHand.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        oneHand.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        oneHand.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        mage.addItem(oneHand, ItemSlot.ONE_HAND_WEAPON);

        UniqueItem offHand = SpellweaverUniqueItems.SHARR_KHARABS_SCROLL.getItem();
        offHand.addEnchant(new Enchant(EnchantType.CRIT_VALUE, 0.24563));
        offHand.addEnchant(new Enchant(EnchantType.CRIT_VALUE, 0.24563));
        offHand.addEnchant(new Enchant(EnchantType.CRIT_VALUE, 0.24563));
        offHand.addEnchant(new Enchant(EnchantType.CRIT_VALUE, 0.24563));
        offHand.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        offHand.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        offHand.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        offHand.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        offHand.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        offHand.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        offHand.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        offHand.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        offHand.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        offHand.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        mage.addItem(offHand, ItemSlot.OFF_HAND);

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
        runeTrinket2.addRune(new Rune("Rune of Resilience", OverallRelativeBuffType.RESISTANCE, 0.065));
        runeTrinket2.addRune(new SpecialRune("Rune of Rising Vigor", Map.of(OverallRelativeBuffType.MOVEMENT_SPEED, 0.10, OverallRelativeBuffType.ATTACK_SPEED, 0.06), ""));
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
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffType.ARMOR, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Persistence", OverallRelativeBuffType.BLOCK_VALUE, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Persistence", OverallRelativeBuffType.BLOCK_VALUE, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Persistence", OverallRelativeBuffType.BLOCK_VALUE, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Persistence", OverallRelativeBuffType.BLOCK_VALUE, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Persistence", OverallRelativeBuffType.BLOCK_VALUE, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Resilience", OverallRelativeBuffType.RESISTANCE, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Resilience", OverallRelativeBuffType.RESISTANCE, 0.065));
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

        mage.setEssence(0.50);

        Pet mortisPet = new Pet("Golden Dragon Turtle", Map.of(OverallRelativeBuffType.ARMOR, 0.22, OverallRelativeBuffType.HEALTH_POINTS, 0.22, OverallRelativeBuffType.BLOCK_VALUE, 0.22), "");
        mage.setPet(mortisPet);
        mage.setCollectorBagBuff(Map.of(OverallRelativeBuffType.HEALTH_POINTS, 0.33, OverallRelativeBuffType.RESISTANCE, 0.15, OverallRelativeBuffType.DAMAGE, 0.06, OverallRelativeBuffType.BLOCK_VALUE, 0.02));

        Tonic tonic = new Tonic("Tonic of Vigor", AbsoluteStatType.HEALTH_POINTS, 156068.0);
        //mage.setTonic(tonic);
        Physic physic = new Physic("Advanced Physic of Vigor", OverallRelativeBuffType.HEALTH_POINTS, 0.18);
        //mage.setPhysic(physic);


        return mage;
    }

    //ess set + mortis
    public static Character bghEssMage() {
        Character mage = new Character(CharacterClass.SPELLWEAVER, "ess set + mortis");

        Map<AbsoluteStatType, Double> amuletBaseStats = new HashMap<>();
        amuletBaseStats.put(AbsoluteStatType.DAMAGE, 1456.734);
        amuletBaseStats.put(AbsoluteStatType.CRIT_VALUE, 1471.185);
        amuletBaseStats.put(AbsoluteStatType.RESISTANCE, 1148.60);
        SetItem amulet = SpellweaverSetItems.AMULET_OF_DEATH.getItem();
        amulet.setBaseStats(amuletBaseStats);
        amulet.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44707));
        amulet.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44702));
        amulet.addEnchant(new Enchant(EnchantType.DAMAGE, 0.4471));
        amulet.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44728));
        mage.addItem(amulet, ItemSlot.AMULET);

        MythicItem cloak = SpellweaverMythicItem.ANCESTRAL_GLORY_CLOAK.getItem();
        cloak.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        mage.addItem(cloak, ItemSlot.CLOAK);

        Map<AbsoluteStatType, Double> beltBaseStats = new HashMap<>();
        beltBaseStats.put(AbsoluteStatType.DAMAGE, 1630.885);
        beltBaseStats.put(AbsoluteStatType.HEALTH_POINTS, 20072.654);
        beltBaseStats.put(AbsoluteStatType.RESISTANCE, 1679.873);
        UniqueItem belt = SpellweaverUniqueItems.BELT_OF_ZEAL.getItem();
        belt.setBaseStats(beltBaseStats);
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
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
        mage.addItem(belt, ItemSlot.BELT);

        MythicItem ring1 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
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
        mage.addItem(ring1, ItemSlot.RING1);
        MythicItem ring2 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
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
        mage.addItem(ring2, ItemSlot.RING2);

        Map<AbsoluteStatType, Double> helmetBaseStats = new HashMap<>();
        helmetBaseStats.put(AbsoluteStatType.DAMAGE, 1453.087);
        helmetBaseStats.put(AbsoluteStatType.CRIT_VALUE, 1220.018);
        helmetBaseStats.put(AbsoluteStatType.RESISTANCE, 701.0);
        SetItem helmet = SpellweaverSetItems.CAP_OF_DEATH.getItem();
        helmet.setBaseStats(helmetBaseStats);
        helmet.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44727));
        helmet.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44736));
        helmet.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44643));
        helmet.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44611));
        mage.addItem(helmet, ItemSlot.HELMET);

        Map<AbsoluteStatType, Double> shouldersBaseStats = new HashMap<>();
        shouldersBaseStats.put(AbsoluteStatType.HEALTH_POINTS, 8234.56);
        shouldersBaseStats.put(AbsoluteStatType.ARMOR, 940.242);
        shouldersBaseStats.put(AbsoluteStatType.RESISTANCE, 871.99);
        SetItem shoulders = SpellweaverSetItems.BLACK_ESSENCE_PAULDRONS.getItem();
        shoulders.setBaseStats(shouldersBaseStats);
        shoulders.addEnchant(new Enchant(EnchantType.CRIT_VALUE, 0.24563));
        shoulders.addEnchant(new Enchant(EnchantType.CRIT_VALUE, 0.24563));
        shoulders.addEnchant(new Enchant(EnchantType.CRIT_VALUE, 0.24563));
        shoulders.addEnchant(new Enchant(EnchantType.CRIT_VALUE, 0.24563));
        shoulders.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        mage.addItem(shoulders, ItemSlot.SHOULDERS);

        Map<AbsoluteStatType, Double> torsoBaseStats = new HashMap<>();
        torsoBaseStats.put(AbsoluteStatType.DAMAGE, 1150.205);
        torsoBaseStats.put(AbsoluteStatType.HEALTH_POINTS, 7280.996);
        torsoBaseStats.put(AbsoluteStatType.ARMOR, 1426.286);
        SetItem torso = SpellweaverSetItems.BLACK_ESSENCE_ARMOR.getItem();
        torso.setBaseStats(torsoBaseStats);
        torso.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44515));
        torso.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.4451));
        torso.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44535));
        torso.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44513));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        mage.addItem(torso, ItemSlot.TORSO);

        Map<AbsoluteStatType, Double> glovesBaseStats = new HashMap<>();
        glovesBaseStats.put(AbsoluteStatType.DAMAGE, 1466.322);
        glovesBaseStats.put(AbsoluteStatType.ATTACK_SPEED, 0.049);
        glovesBaseStats.put(AbsoluteStatType.ARMOR, 770.795);
        SetItem gloves = SpellweaverSetItems.BLACK_ESSENCE_GLOVES.getItem();
        gloves.setBaseStats(glovesBaseStats);
        gloves.addEnchant(new Enchant(EnchantType.ATTACK_SPEED, 0.47122));
        gloves.addEnchant(new Enchant(EnchantType.ATTACK_SPEED, 0.47122));
        gloves.addEnchant(new Enchant(EnchantType.ATTACK_SPEED, 0.47122));
        gloves.addEnchant(new Enchant(EnchantType.ATTACK_SPEED, 0.47122));
        gloves.addGem(new Gem(AbsoluteStatType.ATTACK_SPEED, 0.017));
        gloves.addGem(new Gem(AbsoluteStatType.ATTACK_SPEED, 0.017));
        gloves.addGem(new Gem(AbsoluteStatType.ATTACK_SPEED, 0.017));
        gloves.addGem(new Gem(AbsoluteStatType.ATTACK_SPEED, 0.017));
        gloves.addGem(new Gem(AbsoluteStatType.ATTACK_SPEED, 0.017));
        gloves.addGem(new Gem(AbsoluteStatType.ATTACK_SPEED, 0.017));
        gloves.addGem(new Gem(AbsoluteStatType.ATTACK_SPEED, 0.017));
        gloves.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        gloves.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        gloves.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        mage.addItem(gloves, ItemSlot.GLOVES);

        Map<AbsoluteStatType, Double> bootsBaseStats = new HashMap<>();
        bootsBaseStats.put(AbsoluteStatType.DAMAGE, 1252.206);
        bootsBaseStats.put(AbsoluteStatType.MOVEMENT_SPEED, 1.054);
        bootsBaseStats.put(AbsoluteStatType.HEALTH_POINTS, 10453.816);
        SetItem boots = SpellweaverSetItems.BLACK_ESSENCE_BOOTS.getItem();
        boots.setBaseStats(bootsBaseStats);
        boots.addEnchant(new Enchant(EnchantType.MOVEMENT_SPEED, 0.22444));
        boots.addEnchant(new Enchant(EnchantType.MOVEMENT_SPEED, 0.22445));
        boots.addEnchant(new Enchant(EnchantType.MOVEMENT_SPEED, 0.22449));
        boots.addEnchant(new Enchant(EnchantType.MOVEMENT_SPEED, 0.22448));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        mage.addItem(boots, ItemSlot.BOOTS);

        Map<AbsoluteStatType, Double> adornmentBaseStats = new HashMap<>();
        adornmentBaseStats.put(AbsoluteStatType.DAMAGE, 1870.52);
        adornmentBaseStats.put(AbsoluteStatType.CRIT_VALUE, 2100.146);
        UniqueItem adornment = SpellweaverUniqueItems.SIGRISMARRS_ETERNAL_GRASP.getItem();
        adornment.setBaseStats(adornmentBaseStats);
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44771));
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44767));
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44775));
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44772));
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
        mage.addItem(adornment, ItemSlot.WEAPON_ADORNMENT);

        Map<AbsoluteStatType, Double> twoHandBaseStats = new HashMap<>();
        twoHandBaseStats.put(AbsoluteStatType.DAMAGE, 24570.982);
        twoHandBaseStats.put(AbsoluteStatType.CRIT_VALUE, 3321.515);
        UniqueItem twoHand = SpellweaverUniqueItems.GRIMACE_OF_THE_THUNDER_BEAST.getItem();
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
        runeTrinket2.addRune(new SpecialRune("Rune of Rising Vigor", Map.of(OverallRelativeBuffType.MOVEMENT_SPEED, 0.10, OverallRelativeBuffType.ATTACK_SPEED, 0.06), ""));
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
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffType.ARMOR, 0.065));
        runeTrinket5.addRune(new SpecialRune("Rune of the Realm Changer", Map.of(), "Increases the Realm Changer talent by 5."));
        runeTrinket5.addRune(new SpecialRune("Rune of the Andermant Fever", Map.of(), "Increases the Andermant Fever talent by 5."));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffType.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffType.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Materi Blessing", OverallRelativeBuffType.MATERI_FRAGMENT_DROP_BONUS, 0.3));
        runeTrinket5.addRune(new Rune("Rune of Materi Blessing", OverallRelativeBuffType.MATERI_FRAGMENT_DROP_BONUS, 0.3));
        runeTrinket5.addRune(new Rune("Rune of Materi Blessing", OverallRelativeBuffType.MATERI_FRAGMENT_DROP_BONUS, 0.3));
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

        mage.setEssence(3.00);

        Pet mortisPet = new Pet("Mortis Doll", Map.of(OverallRelativeBuffType.ATTACK_SPEED, 0.3, OverallRelativeBuffType.MANA, 0.3, OverallRelativeBuffType.DAMAGE, 0.3), "");
        mage.setPet(mortisPet);
        mage.setCollectorBagBuff(Map.of(OverallRelativeBuffType.HEALTH_POINTS, 0.33, OverallRelativeBuffType.RESISTANCE, 0.15, OverallRelativeBuffType.DAMAGE, 0.06, OverallRelativeBuffType.BLOCK_VALUE, 0.02));

        Tonic tonic = new Tonic("Tonic of Vigor", AbsoluteStatType.DAMAGE, 10496.0);
        mage.setTonic(tonic);
        Physic physic = new Physic("Advanced Physic of Vigor", OverallRelativeBuffType.DAMAGE, 0.18);
        mage.setPhysic(physic);


        return mage;
    }

    //ess set + mortis + destructor
    public static Character bghEssMage2() {
        Character mage = new Character(CharacterClass.SPELLWEAVER, "ess set + mortis + destructor");

        Map<AbsoluteStatType, Double> amuletBaseStats = new HashMap<>();
        amuletBaseStats.put(AbsoluteStatType.DAMAGE, 1456.734);
        amuletBaseStats.put(AbsoluteStatType.CRIT_VALUE, 1471.185);
        amuletBaseStats.put(AbsoluteStatType.RESISTANCE, 1148.60);
        SetItem amulet = SpellweaverSetItems.AMULET_OF_DEATH.getItem();
        amulet.setBaseStats(amuletBaseStats);
        amulet.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44707));
        amulet.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44702));
        amulet.addEnchant(new Enchant(EnchantType.DAMAGE, 0.4471));
        amulet.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44728));
        mage.addItem(amulet, ItemSlot.AMULET);

        MythicItem cloak = SpellweaverMythicItem.ANCESTRAL_GLORY_CLOAK.getItem();
        cloak.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        cloak.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        cloak.addGem(new Gem(AbsoluteStatType.DAMAGE, 700.0));
        mage.addItem(cloak, ItemSlot.CLOAK);

        SetItem belt = SpellweaverSetItems.AUTOMATED_BELT.getItem();
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
        belt.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44776));
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
        mage.addItem(belt, ItemSlot.BELT);

        MythicItem ring1 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
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
        mage.addItem(ring1, ItemSlot.RING1);
        MythicItem ring2 = SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY.getItem();
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
        mage.addItem(ring2, ItemSlot.RING2);

        Map<AbsoluteStatType, Double> helmetBaseStats = new HashMap<>();
        helmetBaseStats.put(AbsoluteStatType.DAMAGE, 1453.087);
        helmetBaseStats.put(AbsoluteStatType.CRIT_VALUE, 1220.018);
        helmetBaseStats.put(AbsoluteStatType.RESISTANCE, 701.0);
        SetItem helmet = SpellweaverSetItems.CAP_OF_DEATH.getItem();
        helmet.setBaseStats(helmetBaseStats);
        helmet.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44727));
        helmet.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44736));
        helmet.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44643));
        helmet.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44611));
        mage.addItem(helmet, ItemSlot.HELMET);

        Map<AbsoluteStatType, Double> shouldersBaseStats = new HashMap<>();
        shouldersBaseStats.put(AbsoluteStatType.HEALTH_POINTS, 8234.56);
        shouldersBaseStats.put(AbsoluteStatType.ARMOR, 940.242);
        shouldersBaseStats.put(AbsoluteStatType.RESISTANCE, 871.99);
        SetItem shoulders = SpellweaverSetItems.BLACK_ESSENCE_PAULDRONS.getItem();
        shoulders.setBaseStats(shouldersBaseStats);
        shoulders.addEnchant(new Enchant(EnchantType.CRIT_VALUE, 0.24563));
        shoulders.addEnchant(new Enchant(EnchantType.CRIT_VALUE, 0.24563));
        shoulders.addEnchant(new Enchant(EnchantType.CRIT_VALUE, 0.24563));
        shoulders.addEnchant(new Enchant(EnchantType.CRIT_VALUE, 0.24563));
        shoulders.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        shoulders.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        mage.addItem(shoulders, ItemSlot.SHOULDERS);

        Map<AbsoluteStatType, Double> torsoBaseStats = new HashMap<>();
        torsoBaseStats.put(AbsoluteStatType.DAMAGE, 1150.205);
        torsoBaseStats.put(AbsoluteStatType.HEALTH_POINTS, 7280.996);
        torsoBaseStats.put(AbsoluteStatType.ARMOR, 1426.286);
        SetItem torso = SpellweaverSetItems.BLACK_ESSENCE_ARMOR.getItem();
        torso.setBaseStats(torsoBaseStats);
        torso.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44515));
        torso.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.4451));
        torso.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44535));
        torso.addEnchant(new Enchant(EnchantType.HEALTH_POINTS, 0.44513));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0));
        torso.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        mage.addItem(torso, ItemSlot.TORSO);

        Map<AbsoluteStatType, Double> glovesBaseStats = new HashMap<>();
        glovesBaseStats.put(AbsoluteStatType.DAMAGE, 1466.322);
        glovesBaseStats.put(AbsoluteStatType.ATTACK_SPEED, 0.049);
        glovesBaseStats.put(AbsoluteStatType.ARMOR, 770.795);
        SetItem gloves = SpellweaverSetItems.BLACK_ESSENCE_GLOVES.getItem();
        gloves.setBaseStats(glovesBaseStats);
        gloves.addEnchant(new Enchant(EnchantType.ATTACK_SPEED, 0.47122));
        gloves.addEnchant(new Enchant(EnchantType.ATTACK_SPEED, 0.47122));
        gloves.addEnchant(new Enchant(EnchantType.ATTACK_SPEED, 0.47122));
        gloves.addEnchant(new Enchant(EnchantType.ATTACK_SPEED, 0.47122));
        gloves.addGem(new Gem(AbsoluteStatType.ATTACK_SPEED, 0.017));
        gloves.addGem(new Gem(AbsoluteStatType.ATTACK_SPEED, 0.017));
        gloves.addGem(new Gem(AbsoluteStatType.ATTACK_SPEED, 0.017));
        gloves.addGem(new Gem(AbsoluteStatType.ATTACK_SPEED, 0.017));
        gloves.addGem(new Gem(AbsoluteStatType.ATTACK_SPEED, 0.017));
        gloves.addGem(new Gem(AbsoluteStatType.ATTACK_SPEED, 0.017));
        gloves.addGem(new Gem(AbsoluteStatType.ATTACK_SPEED, 0.017));
        gloves.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        gloves.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        gloves.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        mage.addItem(gloves, ItemSlot.GLOVES);

        Map<AbsoluteStatType, Double> bootsBaseStats = new HashMap<>();
        bootsBaseStats.put(AbsoluteStatType.DAMAGE, 1550.720);
        bootsBaseStats.put(AbsoluteStatType.MOVEMENT_SPEED, 1.179);
        bootsBaseStats.put(AbsoluteStatType.HEALTH_POINTS, 13136.770);
        SetItem boots = SpellweaverSetItems.AUTOMATED_SHINGUARDS.getItem();
        boots.setBaseStats(bootsBaseStats);
        boots.addEnchant(new Enchant(EnchantType.MOVEMENT_SPEED, 0.22444));
        boots.addEnchant(new Enchant(EnchantType.MOVEMENT_SPEED, 0.22445));
        boots.addEnchant(new Enchant(EnchantType.MOVEMENT_SPEED, 0.22449));
        boots.addEnchant(new Enchant(EnchantType.MOVEMENT_SPEED, 0.22448));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.MOVEMENT_SPEED, 0.17));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        boots.addGem(new Gem(AbsoluteStatType.CRIT_VALUE, 2520.0));
        mage.addItem(boots, ItemSlot.BOOTS);

        Map<AbsoluteStatType, Double> adornmentBaseStats = new HashMap<>();
        adornmentBaseStats.put(AbsoluteStatType.DAMAGE, 1870.52);
        adornmentBaseStats.put(AbsoluteStatType.CRIT_VALUE, 2100.146);
        UniqueItem adornment = SpellweaverUniqueItems.SIGRISMARRS_ETERNAL_GRASP.getItem();
        adornment.setBaseStats(adornmentBaseStats);
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44771));
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44767));
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44775));
        adornment.addEnchant(new Enchant(EnchantType.DAMAGE, 0.44772));
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
        mage.addItem(adornment, ItemSlot.WEAPON_ADORNMENT);

        Map<AbsoluteStatType, Double> twoHandBaseStats = new HashMap<>();
        twoHandBaseStats.put(AbsoluteStatType.DAMAGE, 24570.982);
        twoHandBaseStats.put(AbsoluteStatType.CRIT_VALUE, 3321.515);
        UniqueItem twoHand = SpellweaverUniqueItems.GRIMACE_OF_THE_THUNDER_BEAST.getItem();
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
        runeTrinket2.addRune(new SpecialRune("Rune of Rising Vigor", Map.of(OverallRelativeBuffType.MOVEMENT_SPEED, 0.10, OverallRelativeBuffType.ATTACK_SPEED, 0.06), ""));
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
        runeTrinket5.addRune(new Rune("Rune of Fortitude", OverallRelativeBuffType.ARMOR, 0.065));
        runeTrinket5.addRune(new SpecialRune("Rune of the Realm Changer", Map.of(), "Increases the Realm Changer talent by 5."));
        runeTrinket5.addRune(new SpecialRune("Rune of the Andermant Fever", Map.of(), "Increases the Andermant Fever talent by 5."));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffType.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Acceleration", OverallRelativeBuffType.MOVEMENT_SPEED, 0.065));
        runeTrinket5.addRune(new Rune("Rune of Materi Blessing", OverallRelativeBuffType.MATERI_FRAGMENT_DROP_BONUS, 0.3));
        runeTrinket5.addRune(new Rune("Rune of Materi Blessing", OverallRelativeBuffType.MATERI_FRAGMENT_DROP_BONUS, 0.3));
        runeTrinket5.addRune(new Rune("Rune of Materi Blessing", OverallRelativeBuffType.MATERI_FRAGMENT_DROP_BONUS, 0.3));
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

        mage.setEssence(3.00);

        Pet mortisPet = new Pet("Mortis Doll", Map.of(OverallRelativeBuffType.ATTACK_SPEED, 0.3, OverallRelativeBuffType.MANA, 0.3, OverallRelativeBuffType.DAMAGE, 0.3), "");
        mage.setPet(mortisPet);
        mage.setCollectorBagBuff(Map.of(OverallRelativeBuffType.HEALTH_POINTS, 0.33, OverallRelativeBuffType.RESISTANCE, 0.15, OverallRelativeBuffType.DAMAGE, 0.06, OverallRelativeBuffType.BLOCK_VALUE, 0.02));

        Tonic tonic = new Tonic("Tonic of Vigor", AbsoluteStatType.DAMAGE, 10496.0);
        mage.setTonic(tonic);
        Physic physic = new Physic("Advanced Physic of Vigor", OverallRelativeBuffType.DAMAGE, 0.18);
        mage.setPhysic(physic);


        return mage;
    }


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
        System.out.printf(AbsoluteStatType.ARMOR + ": %.2f%n", stats.get(AbsoluteStatType.ARMOR));
        System.out.printf(AbsoluteStatType.FIRE_RESISTANCE + ": %.2f%n", stats.get(AbsoluteStatType.FIRE_RESISTANCE));
        System.out.printf(AbsoluteStatType.ICE_RESISTANCE + ": %.2f%n", stats.get(AbsoluteStatType.ICE_RESISTANCE));
        System.out.printf(AbsoluteStatType.LIGHTNING_RESISTANCE + ": %.2f%n", stats.get(AbsoluteStatType.LIGHTNING_RESISTANCE));
        System.out.printf(AbsoluteStatType.ANDERMAGIC_RESISTANCE + ": %.2f%n", stats.get(AbsoluteStatType.ANDERMAGIC_RESISTANCE));
        System.out.printf(AbsoluteStatType.POISON_RESISTANCE + ": %.2f%n", stats.get(AbsoluteStatType.POISON_RESISTANCE));
    }
}