package com.langleon.dsobuildsim.character;

import com.langleon.dsobuildsim.buffs.Physic;
import com.langleon.dsobuildsim.buffs.Tonic;
import com.langleon.dsobuildsim.enums.*;
import com.langleon.dsobuildsim.sets.*;
import com.langleon.dsobuildsim.items.actualitems.AbstractItem;
import com.langleon.dsobuildsim.items.actualitems.MythicItem;
import com.langleon.dsobuildsim.items.actualitems.SetItem;
import com.langleon.dsobuildsim.items.actualitems.UniqueItem;
import com.langleon.dsobuildsim.jewels.Jewel;
import com.langleon.dsobuildsim.jewels.JewelTrinket;
import com.langleon.dsobuildsim.mapper.AbsoluteToRelativeStatTypeMapper;
import com.langleon.dsobuildsim.overallbuffs.OverallAbsolutBuff;
import com.langleon.dsobuildsim.overallbuffs.OverallBuff;
import com.langleon.dsobuildsim.overallbuffs.OverallRelativeBuff;
import com.langleon.dsobuildsim.pets.Pet;
import com.langleon.dsobuildsim.runes.Rune;
import com.langleon.dsobuildsim.runes.RuneTrinket;
import com.langleon.dsobuildsim.skilltrees.wisdomskilltree.WisdomSkillTree;

import java.util.*;

public class Character {

    //class
    CharacterClass characterClass;
    String name;

    //character base stats
    Map<StatType, Double> classBaseStats;

    //character special stats
    Map<StatType, Double> classSpecialStats;

    //character absolute stats (before % addition)
    Map<StatType, Double> characterAbsoluteStats;

    //%boosts
    Map<StatType, Double> characterRelativeBuffs;

    //character final stats
    Map<StatType, Double> characterFinalStats;

    //booleans


    //trinkets
    RuneTrinket runeTrinket1;
    RuneTrinket runeTrinket2;
    RuneTrinket runeTrinket3;
    RuneTrinket runeTrinket4;
    RuneTrinket runeTrinket5;
    JewelTrinket jewelTrinket1;
    JewelTrinket jewelTrinket2;
    JewelTrinket jewelTrinket3;

    //items
    AbstractItem amulet;
    AbstractItem cloak;
    AbstractItem belt;
    AbstractItem ring1;
    AbstractItem ring2;
    AbstractItem weapon_adornment;
    AbstractItem two_hand_weapon;
    AbstractItem one_hand_weapon;
    AbstractItem off_hand;
    AbstractItem helmet;
    AbstractItem shoulders;
    AbstractItem torso;
    AbstractItem gloves;
    AbstractItem boots;

    //sets
    Map<SetEnumInterface, List<String>> sets;

    //pet
    Pet pet;

    //collectors bag buffs
    Map<StatType, Double> collectorBagBuffs;

    //ess
    double essDmg = 0.0;

    //buffs
    Tonic tonic;
    Physic physic;

    //wisdom tree
    WisdomSkillTree wisdomSkillTree;

    //buffs from skill tree (f.e. blood mage)
    //todo

    //Constructors
    public Character(CharacterClass characterClass)
    {
        this.characterClass = characterClass;
        this.classBaseStats = new HashMap<>();
        this.characterAbsoluteStats = new HashMap<>();
        this.characterFinalStats = new HashMap<>();
        this.characterRelativeBuffs = new HashMap<>();
        this.classSpecialStats = new HashMap<>();
        this.collectorBagBuffs = new HashMap<>();
        this.wisdomSkillTree = new WisdomSkillTree();
        this.sets = new HashMap<>();
        this.runeTrinket1 = new RuneTrinket();
        this.runeTrinket2 = new RuneTrinket();
        this.runeTrinket3 = new RuneTrinket();
        this.runeTrinket4 = new RuneTrinket();
        this.runeTrinket5 = new RuneTrinket();
        this.jewelTrinket1 = new JewelTrinket();
        this.jewelTrinket2 = new JewelTrinket();
        this.jewelTrinket3 = new JewelTrinket();

        if (characterClass == CharacterClass.SPELLWEAVER)
        {
            this.classBaseStats.put(StatType.DAMAGE, 50400.0);
            this.classBaseStats.put(StatType.MANA_PER_SECOND, 12.0);
            this.classBaseStats.put(StatType.HEALTH_POINTS, 150000.0);
        }
        else if (characterClass == CharacterClass.DRAGONKNIGHT)
        {
            this.classBaseStats.put(StatType.DAMAGE, 16800.0);
            this.classBaseStats.put(StatType.MANA_PER_SECOND, 0.0);
            this.classBaseStats.put(StatType.HEALTH_POINTS, 450000.0);
        }
        else if (characterClass == CharacterClass.RANGER)
        {
            this.classBaseStats.put(StatType.DAMAGE, 29400.0);
            this.classBaseStats.put(StatType.MANA_PER_SECOND, 8.0);
            this.classBaseStats.put(StatType.HEALTH_POINTS, 345000.0);
        }
        else if (characterClass == CharacterClass.STEAM_MECHANICUS)
        {
            this.classBaseStats.put(StatType.DAMAGE, 38640.0);
            this.classBaseStats.put(StatType.MANA_PER_SECOND, 3.0);
            this.classBaseStats.put(StatType.HEALTH_POINTS, 262500.0);
        }

        this.classBaseStats.put(StatType.MOVEMENT_SPEED, 5.0);
        this.classBaseStats.put(StatType.MANA, 100.0);
        this.classBaseStats.put(StatType.ATTACK_SPEED, 1.00);
        this.classBaseStats.put(StatType.CRIT_VALUE, 0.0);
        this.classBaseStats.put(StatType.HEALTH_PER_SECOND, 0.0);
        this.classBaseStats.put(StatType.BLOCK_VALUE, 0.0);
        this.classBaseStats.put(StatType.ARMOR_VALUE, 0.0);
        this.classBaseStats.put(StatType.FIRE_RESISTANCE, 0.0);
        this.classBaseStats.put(StatType.ICE_RESISTANCE, 0.0);
        this.classBaseStats.put(StatType.LIGHTNING_RESISTANCE, 0.0);
        this.classBaseStats.put(StatType.ANDERMAGIC_RESISTANCE, 0.0);
        this.classBaseStats.put(StatType.POISON_RESISTANCE, 0.0);


        this.characterRelativeBuffs.put(StatType.ANDERMAGIC_RESISTANCE, 0.0);
        this.characterRelativeBuffs.put(StatType.ANDERMANT_DROP_BONUS, 0.0);
        this.characterRelativeBuffs.put(StatType.ARMOR_VALUE, 0.0);
        this.characterRelativeBuffs.put(StatType.ATTACK_SPEED, 0.0);
        this.characterRelativeBuffs.put(StatType.BLOCK_VALUE, 0.0);
        this.characterRelativeBuffs.put(StatType.COIN_DROP_BONUS, 0.0);
        this.characterRelativeBuffs.put(StatType.CRIT_VALUE, 0.0);
        this.characterRelativeBuffs.put(StatType.DAMAGE, 0.0);
        this.characterRelativeBuffs.put(StatType.FIRE_RESISTANCE, 0.0);
        this.characterRelativeBuffs.put(StatType.HEALTH_POINTS, 0.0);
        this.characterRelativeBuffs.put(StatType.HEALTH_PER_SECOND, 0.0);
        this.characterRelativeBuffs.put(StatType.HONOR_GAIN, 100.0);
        this.characterRelativeBuffs.put(StatType.ICE_RESISTANCE, 0.0);
        this.characterRelativeBuffs.put(StatType.LIGHTNING_RESISTANCE, 0.0);
        this.characterRelativeBuffs.put(StatType.MANA, 0.0);
        this.characterRelativeBuffs.put(StatType.MANA_PER_SECOND, 0.0);
        this.characterRelativeBuffs.put(StatType.MATERI_FRAGMENT_DROP_BONUS, 0.0);
        this.characterRelativeBuffs.put(StatType.MOVEMENT_SPEED, 0.0);
        this.characterRelativeBuffs.put(StatType.ONE_HAND_DAMAGE, 0.0);
        this.characterRelativeBuffs.put(StatType.POISON_RESISTANCE, 0.0);
        this.characterRelativeBuffs.put(StatType.RESISTANCE_VALUE, 0.0);
        this.characterRelativeBuffs.put(StatType.TWO_HAND_DAMAGE, 0.0);
        this.characterRelativeBuffs.put(StatType.ANCIENT_WISDOM_DROP_BONUS, 0.0);
        this.characterRelativeBuffs.put(StatType.XP_GAIN, 100.0);
    }

    public Character(CharacterClass characterClass, String name)
    {
        this.characterClass = characterClass;
        this.name = name;
        this.classBaseStats = new HashMap<>();
        this.characterAbsoluteStats = new HashMap<>();
        this.characterFinalStats = new HashMap<>();
        this.characterRelativeBuffs = new HashMap<>();
        this.classSpecialStats = new HashMap<>();
        this.collectorBagBuffs = new HashMap<>();
        this.wisdomSkillTree = new WisdomSkillTree();
        this.sets = new HashMap<>();
        this.runeTrinket1 = new RuneTrinket();
        this.runeTrinket2 = new RuneTrinket();
        this.runeTrinket3 = new RuneTrinket();
        this.runeTrinket4 = new RuneTrinket();
        this.runeTrinket5 = new RuneTrinket();
        this.jewelTrinket1 = new JewelTrinket();
        this.jewelTrinket2 = new JewelTrinket();
        this.jewelTrinket3 = new JewelTrinket();

        if (characterClass == CharacterClass.SPELLWEAVER)
        {
            this.classBaseStats.put(StatType.DAMAGE, 50400.0);
            this.classBaseStats.put(StatType.MANA_PER_SECOND, 12.0);
            this.classBaseStats.put(StatType.HEALTH_POINTS, 150000.0);
        }
        else if (characterClass == CharacterClass.DRAGONKNIGHT)
        {
            this.classBaseStats.put(StatType.DAMAGE, 16800.0);
            this.classBaseStats.put(StatType.MANA_PER_SECOND, 0.0);
            this.classBaseStats.put(StatType.HEALTH_POINTS, 450000.0);
        }
        else if (characterClass == CharacterClass.RANGER)
        {
            this.classBaseStats.put(StatType.DAMAGE, 29400.0);
            this.classBaseStats.put(StatType.MANA_PER_SECOND, 8.0);
            this.classBaseStats.put(StatType.HEALTH_POINTS, 345000.0);
        }
        else if (characterClass == CharacterClass.STEAM_MECHANICUS)
        {
            this.classBaseStats.put(StatType.DAMAGE, 38640.0);
            this.classBaseStats.put(StatType.MANA_PER_SECOND, 3.0);
            this.classBaseStats.put(StatType.HEALTH_POINTS, 262500.0);
        }

        this.classBaseStats.put(StatType.MOVEMENT_SPEED, 5.0);
        this.classBaseStats.put(StatType.MANA, 100.0);
        this.classBaseStats.put(StatType.ATTACK_SPEED, 1.00);
        this.classBaseStats.put(StatType.CRIT_VALUE, 0.0);
        this.classBaseStats.put(StatType.HEALTH_PER_SECOND, 0.0);
        this.classBaseStats.put(StatType.BLOCK_VALUE, 0.0);
        this.classBaseStats.put(StatType.ARMOR_VALUE, 0.0);
        this.classBaseStats.put(StatType.FIRE_RESISTANCE, 0.0);
        this.classBaseStats.put(StatType.ICE_RESISTANCE, 0.0);
        this.classBaseStats.put(StatType.LIGHTNING_RESISTANCE, 0.0);
        this.classBaseStats.put(StatType.ANDERMAGIC_RESISTANCE, 0.0);
        this.classBaseStats.put(StatType.POISON_RESISTANCE, 0.0);


        this.characterRelativeBuffs.put(StatType.ANDERMAGIC_RESISTANCE, 0.0);
        this.characterRelativeBuffs.put(StatType.ANDERMANT_DROP_BONUS, 0.0);
        this.characterRelativeBuffs.put(StatType.ARMOR_VALUE, 0.0);
        this.characterRelativeBuffs.put(StatType.ATTACK_SPEED, 0.0);
        this.characterRelativeBuffs.put(StatType.BLOCK_VALUE, 0.0);
        this.characterRelativeBuffs.put(StatType.COIN_DROP_BONUS, 0.0);
        this.characterRelativeBuffs.put(StatType.CRIT_VALUE, 0.0);
        this.characterRelativeBuffs.put(StatType.DAMAGE, 0.0);
        this.characterRelativeBuffs.put(StatType.FIRE_RESISTANCE, 0.0);
        this.characterRelativeBuffs.put(StatType.HEALTH_POINTS, 0.0);
        this.characterRelativeBuffs.put(StatType.HEALTH_PER_SECOND, 0.0);
        this.characterRelativeBuffs.put(StatType.HONOR_GAIN, 100.0);
        this.characterRelativeBuffs.put(StatType.ICE_RESISTANCE, 0.0);
        this.characterRelativeBuffs.put(StatType.LIGHTNING_RESISTANCE, 0.0);
        this.characterRelativeBuffs.put(StatType.MANA, 0.0);
        this.characterRelativeBuffs.put(StatType.MANA_PER_SECOND, 0.0);
        this.characterRelativeBuffs.put(StatType.MATERI_FRAGMENT_DROP_BONUS, 0.0);
        this.characterRelativeBuffs.put(StatType.MOVEMENT_SPEED, 0.0);
        this.characterRelativeBuffs.put(StatType.ONE_HAND_DAMAGE, 0.0);
        this.characterRelativeBuffs.put(StatType.POISON_RESISTANCE, 0.0);
        this.characterRelativeBuffs.put(StatType.RESISTANCE_VALUE, 0.0);
        this.characterRelativeBuffs.put(StatType.TWO_HAND_DAMAGE, 0.0);
        this.characterRelativeBuffs.put(StatType.ANCIENT_WISDOM_DROP_BONUS, 0.0);
        this.characterRelativeBuffs.put(StatType.XP_GAIN, 100.0);
    }

    //items
    public void addItem(AbstractItem item, ItemSlot slot)
    {
        //item.getCharacterClass()
        if (this.characterClass == item.getCharacterClass())
        {
            if (slot == ItemSlot.AMULET && item.getItemType() == ItemType.AMULET)
            {
                if (this.amulet !=null)
                {
                    if (this.amulet instanceof SetItem)
                    {
                        this.sets.get(((SetItem) this.amulet).getSet()).remove(this.amulet.getName());
                    }
                    else if (this.amulet instanceof MythicItem)
                    {
                        this.sets.get(((MythicItem) this.amulet).getSet()).remove(this.amulet.getName());
                    }
                }
                this.amulet = item;
            }
            else if (slot == ItemSlot.CLOAK && item.getItemType() == ItemType.CLOAK)
            {
                if (this.cloak !=null)
                {
                    if (this.cloak instanceof SetItem)
                    {
                        this.sets.get(((SetItem) this.cloak).getSet()).remove(this.cloak.getName());
                    }
                    else if (this.cloak instanceof MythicItem)
                    {
                        this.sets.get(((MythicItem) this.cloak).getSet()).remove(this.cloak.getName());
                    }
                }
                this.cloak = item;
            }
            else if (slot == ItemSlot.BELT && item.getItemType() == ItemType.BELT)
            {
                if (this.belt !=null)
                {
                    if (this.belt instanceof SetItem)
                    {
                        this.sets.get(((SetItem) this.belt).getSet()).remove(this.belt.getName());
                    }
                    else if (this.belt instanceof MythicItem)
                    {
                        this.sets.get(((MythicItem) this.belt).getSet()).remove(this.belt.getName());
                    }
                }
                this.belt = item;
            }
            else if (slot == ItemSlot.RING1 && item.getItemType() == ItemType.RING)
            {
                if (this.ring1 !=null)
                {
                    if (this.ring1 instanceof SetItem)
                    {
                        this.sets.get(((SetItem) this.ring1).getSet()).remove(this.ring1.getName());
                    }
                    else if (this.ring1 instanceof MythicItem)
                    {
                        this.sets.get(((MythicItem) this.ring1).getSet()).remove(this.ring1.getName());
                    }
                }
                this.ring1 = item;
            }
            else if (slot == ItemSlot.RING2 && item.getItemType() == ItemType.RING)
            {
                if (this.ring2 !=null)
                {
                    if (this.ring2 instanceof SetItem)
                    {
                        this.sets.get(((SetItem) this.ring2).getSet()).remove(this.ring2.getName());
                    }
                    else if (this.ring2 instanceof MythicItem)
                    {
                        this.sets.get(((MythicItem) this.ring2).getSet()).remove(this.ring2.getName());
                    }
                }
                this.ring2 = item;
            }
            else if (slot == ItemSlot.HELMET && item.getItemType() == ItemType.HELMET)
            {
                if (this.helmet !=null)
                {
                    if (this.helmet instanceof SetItem)
                    {
                        this.sets.get(((SetItem) this.helmet).getSet()).remove(this.helmet.getName());
                    }
                    else if (this.helmet instanceof MythicItem)
                    {
                        this.sets.get(((MythicItem) this.helmet).getSet()).remove(this.helmet.getName());
                    }
                }
                this.helmet = item;
            }
            else if (slot == ItemSlot.SHOULDERS && item.getItemType() == ItemType.SHOULDERS)
            {
                if (this.shoulders !=null)
                {
                    if (this.shoulders instanceof SetItem)
                    {
                        this.sets.get(((SetItem) this.shoulders).getSet()).remove(this.shoulders.getName());
                    }
                    else if (this.shoulders instanceof MythicItem)
                    {
                        this.sets.get(((MythicItem) this.shoulders).getSet()).remove(this.shoulders.getName());
                    }
                }
                this.shoulders = item;
            }
            else if (slot == ItemSlot.TORSO && item.getItemType() == ItemType.TORSO)
            {
                if (this.torso !=null)
                {
                    if (this.torso instanceof SetItem)
                    {
                        this.sets.get(((SetItem) this.torso).getSet()).remove(this.torso.getName());
                    }
                    else if (this.torso instanceof MythicItem)
                    {
                        this.sets.get(((MythicItem) this.torso).getSet()).remove(this.torso.getName());
                    }
                }
                this.torso = item;
            }
            else if (slot == ItemSlot.GLOVES && item.getItemType() == ItemType.GLOVES)
            {
                if (this.gloves !=null)
                {
                    if (this.gloves instanceof SetItem)
                    {
                        this.sets.get(((SetItem) this.gloves).getSet()).remove(this.gloves.getName());
                    }
                    else if (this.gloves instanceof MythicItem)
                    {
                        this.sets.get(((MythicItem) this.gloves).getSet()).remove(this.gloves.getName());
                    }
                }
                this.gloves = item;
            }
            else if (slot == ItemSlot.BOOTS && item.getItemType() == ItemType.BOOTS)
            {
                if (this.boots !=null)
                {
                    if (this.boots instanceof SetItem)
                    {
                        this.sets.get(((SetItem) this.boots).getSet()).remove(this.boots.getName());
                    }
                    else if (this.boots instanceof MythicItem)
                    {
                        this.sets.get(((MythicItem) this.boots).getSet()).remove(this.boots.getName());
                    }
                }
                this.boots = item;
            }
            else if (slot == ItemSlot.WEAPON_ADORNMENT && item.getItemType() == ItemType.WEAPON_ADORNMENT)
            {
                if (this.weapon_adornment !=null)
                {
                    if (this.weapon_adornment instanceof SetItem)
                    {
                        this.sets.get(((SetItem) this.weapon_adornment).getSet()).remove(this.weapon_adornment.getName());
                    }
                    else if (this.weapon_adornment instanceof MythicItem)
                    {
                        this.sets.get(((MythicItem) this.weapon_adornment).getSet()).remove(this.weapon_adornment.getName());
                    }
                }
                this.weapon_adornment = item;
            }
            else if (slot == ItemSlot.TWO_HAND_WEAPON && item.getItemType() == ItemType.TWO_HAND_WEAPON)
            {
                if (this.two_hand_weapon !=null)
                {
                    if (this.two_hand_weapon instanceof SetItem)
                    {
                        this.sets.get(((SetItem) this.two_hand_weapon).getSet()).remove(this.two_hand_weapon.getName());
                    }
                    else if (this.two_hand_weapon instanceof MythicItem)
                    {
                        this.sets.get(((MythicItem) this.two_hand_weapon).getSet()).remove(this.two_hand_weapon.getName());
                    }
                }
                this.two_hand_weapon = item;
                this.removeItem(ItemSlot.ONE_HAND_WEAPON);
                this.removeItem(ItemSlot.OFF_HAND);
            }
            else if (slot == ItemSlot.ONE_HAND_WEAPON && item.getItemType() == ItemType.ONE_HAND_WEAPON)
            {
                if (this.one_hand_weapon !=null)
                {
                    if (this.one_hand_weapon instanceof SetItem)
                    {
                        this.sets.get(((SetItem) this.one_hand_weapon).getSet()).remove(this.one_hand_weapon.getName());
                    }
                    else if (this.one_hand_weapon instanceof MythicItem)
                    {
                        this.sets.get(((MythicItem) this.one_hand_weapon).getSet()).remove(this.one_hand_weapon.getName());
                    }
                }
                this.one_hand_weapon = item;
                this.removeItem(ItemSlot.TWO_HAND_WEAPON);
            }
            else if (slot == ItemSlot.OFF_HAND && item.getItemType() == ItemType.OFF_HAND)
            {
                if (this.off_hand !=null)
                {
                    if (this.off_hand instanceof SetItem)
                    {
                        this.sets.get(((SetItem) this.off_hand).getSet()).remove(this.off_hand.getName());
                    }
                    else if (this.off_hand instanceof MythicItem)
                    {
                        this.sets.get(((MythicItem) this.off_hand).getSet()).remove(this.off_hand.getName());
                    }
                }
                this.off_hand = item;
                this.removeItem(ItemSlot.TWO_HAND_WEAPON);
            }
            else
            {
                throw new IllegalArgumentException("Failed to add item.");
            }

            if (item instanceof SetItem setItem)
            {
                if (!this.sets.containsKey(setItem.getSet()))
                {
                    this.sets.put(setItem.getSet(), new ArrayList<>());
                }
                this.sets.get(setItem.getSet()).add(item.getName());
            }
            else if (item instanceof MythicItem mythicItem)
            {
                if (!this.sets.containsKey(mythicItem.getSet()))
                {
                    this.sets.put(mythicItem.getSet(), new ArrayList<>());
                }
                this.sets.get(mythicItem.getSet()).add(item.getName());
            }
        }
        else
        {
            throw new IllegalArgumentException("Failed to add item, wrong character class.");
        }
    }

    public void removeItem(ItemSlot slot)
    {
        switch (slot)
        {
            case AMULET -> {
                if (this.amulet instanceof SetItem)
                {
                    this.sets.get(((SetItem) this.amulet).getSet()).remove(this.amulet.getName());
                }
                else if (this.amulet instanceof MythicItem)
                {
                    this.sets.get(((MythicItem) this.amulet).getSet()).remove(this.amulet.getName());
                }
                this.amulet = null;
            }
            case CLOAK -> {
                if (this.cloak instanceof SetItem)
                {
                    this.sets.get(((SetItem) this.cloak).getSet()).remove(this.cloak.getName());
                }
                else if (this.cloak instanceof MythicItem)
                {
                    this.sets.get(((MythicItem) this.cloak).getSet()).remove(this.cloak.getName());
                }
                this.cloak = null;
            }
            case BELT -> {
                if (this.belt instanceof SetItem)
                {
                    this.sets.get(((SetItem) this.belt).getSet()).remove(this.belt.getName());
                }
                else if (this.belt instanceof MythicItem)
                {
                    this.sets.get(((MythicItem) this.belt).getSet()).remove(this.belt.getName());
                }
                this.belt = null;
            }
            case RING1 -> {
                if (this.ring1 instanceof SetItem)
                {
                    this.sets.get(((SetItem) this.ring1).getSet()).remove(this.ring1.getName());
                }
                else if (this.ring1 instanceof MythicItem)
                {
                    this.sets.get(((MythicItem) this.ring1).getSet()).remove(this.ring1.getName());
                }
                this.ring1 = null;
            }
            case RING2 -> {
                if (this.ring2 instanceof SetItem)
                {
                    this.sets.get(((SetItem) this.ring2).getSet()).remove(this.ring2.getName());
                }
                else if (this.ring2 instanceof MythicItem)
                {
                    this.sets.get(((MythicItem) this.ring2).getSet()).remove(this.ring2.getName());
                }
                this.ring2 = null;
            }
            case HELMET -> {
                if (this.helmet instanceof SetItem)
                {
                    this.sets.get(((SetItem) this.helmet).getSet()).remove(this.helmet.getName());
                }
                else if (this.helmet instanceof MythicItem)
                {
                    this.sets.get(((MythicItem) this.helmet).getSet()).remove(this.helmet.getName());
                }
                this.helmet = null;
            }
            case SHOULDERS -> {
                if (this.shoulders instanceof SetItem)
                {
                    this.sets.get(((SetItem) this.shoulders).getSet()).remove(this.shoulders.getName());
                }
                else if (this.shoulders instanceof MythicItem)
                {
                    this.sets.get(((MythicItem) this.shoulders).getSet()).remove(this.shoulders.getName());
                }
                this.shoulders = null;
            }
            case TORSO-> {
                if (this.torso instanceof SetItem)
                {
                    this.sets.get(((SetItem) this.torso).getSet()).remove(this.torso.getName());
                }
                else if (this.torso instanceof MythicItem)
                {
                    this.sets.get(((MythicItem) this.torso).getSet()).remove(this.torso.getName());
                }
                this.torso = null;
            }
            case GLOVES -> {
                if (this.gloves instanceof SetItem)
                {
                    this.sets.get(((SetItem) this.gloves).getSet()).remove(this.gloves.getName());
                }
                else if (this.gloves instanceof MythicItem)
                {
                    this.sets.get(((MythicItem) this.gloves).getSet()).remove(this.gloves.getName());
                }
                this.gloves = null;
            }
            case BOOTS -> {
                if (this.boots instanceof SetItem)
                {
                    this.sets.get(((SetItem) this.boots).getSet()).remove(this.boots.getName());
                }
                else if (this.boots instanceof MythicItem)
                {
                    this.sets.get(((MythicItem) this.boots).getSet()).remove(this.boots.getName());
                }
                this.boots = null;
            }
            case WEAPON_ADORNMENT -> {
                if (this.weapon_adornment instanceof SetItem)
                {
                    this.sets.get(((SetItem) this.weapon_adornment).getSet()).remove(this.weapon_adornment.getName());
                }
                else if (this.weapon_adornment instanceof MythicItem)
                {
                    this.sets.get(((MythicItem) this.weapon_adornment).getSet()).remove(this.weapon_adornment.getName());
                }
                this.weapon_adornment = null;
            }
            case TWO_HAND_WEAPON -> {
                if (this.two_hand_weapon instanceof SetItem)
                {
                    this.sets.get(((SetItem) this.two_hand_weapon).getSet()).remove(this.two_hand_weapon.getName());
                }
                else if (this.two_hand_weapon instanceof MythicItem)
                {
                    this.sets.get(((MythicItem) this.two_hand_weapon).getSet()).remove(this.two_hand_weapon.getName());
                }
                this.two_hand_weapon = null;
            }
            case ONE_HAND_WEAPON -> {
                if (this.one_hand_weapon instanceof SetItem)
                {
                    this.sets.get(((SetItem) this.one_hand_weapon).getSet()).remove(this.one_hand_weapon.getName());
                }
                else if (this.one_hand_weapon instanceof MythicItem)
                {
                    this.sets.get(((MythicItem) this.one_hand_weapon).getSet()).remove(this.one_hand_weapon.getName());
                }
                this.one_hand_weapon = null;
            }
            case OFF_HAND -> {
                if (this.off_hand instanceof SetItem)
                {
                    this.sets.get(((SetItem) this.off_hand).getSet()).remove(this.off_hand.getName());
                }
                else if (this.off_hand instanceof MythicItem)
                {
                    this.sets.get(((MythicItem) this.off_hand).getSet()).remove(this.off_hand.getName());
                }
                this.off_hand = null;
            }
        }
    }

    public AbstractItem getItem(ItemSlot slot)
    {
        AbstractItem item = null;
        switch (slot)
        {
            case AMULET -> item = this.amulet;
            case CLOAK -> item = this.cloak;
            case BELT -> item = this.belt;
            case RING1 -> item = this.ring1;
            case RING2 -> item = this.ring2;
            case HELMET -> item = this.helmet;
            case SHOULDERS -> item = this.shoulders;
            case TORSO-> item = this.torso;
            case GLOVES -> item = this.gloves;
            case BOOTS -> item = this.boots;
            case WEAPON_ADORNMENT -> item = this.weapon_adornment;
            case TWO_HAND_WEAPON -> item = this.two_hand_weapon;
            case ONE_HAND_WEAPON -> item = this.one_hand_weapon;
            case OFF_HAND -> item = this.off_hand;
        }
        return item;
    }

    //trinkets
    public void addRuneTrinket(RuneTrinket runeTrinket, int runeTrinketSlot)
    {
        switch (runeTrinketSlot)
        {
            case 1 -> this.runeTrinket1 = runeTrinket;
            case 2 -> this.runeTrinket2 = runeTrinket;
            case 3 -> this.runeTrinket3 = runeTrinket;
            case 4 -> this.runeTrinket4 = runeTrinket;
            case 5 -> this.runeTrinket5 = runeTrinket;
        }
    }

    public void removeRuneTrinket(int runeTrinketSlot)
    {
        switch (runeTrinketSlot)
        {
            case 1 -> this.runeTrinket1 = null;
            case 2 -> this.runeTrinket2 = null;
            case 3 -> this.runeTrinket3 = null;
            case 4 -> this.runeTrinket4 = null;
            case 5 -> this.runeTrinket5 = null;
        }
    }

    public RuneTrinket getRuneTrinket(int runeTrinketSlot)
    {
        RuneTrinket runeTrinket = null;
        switch (runeTrinketSlot)
        {
            case 1 -> runeTrinket = this.runeTrinket1;
            case 2 -> runeTrinket = this.runeTrinket2;
            case 3 -> runeTrinket = this.runeTrinket3;
            case 4 -> runeTrinket = this.runeTrinket4;
            case 5 -> runeTrinket = this.runeTrinket5;
        }
        return runeTrinket;
    }

    public void addJewelTrinket(JewelTrinket jewelTrinket, int jewelTrinketSlot)
    {
        switch (jewelTrinketSlot)
        {
            case 1 -> this.jewelTrinket1 = jewelTrinket;
            case 2 -> this.jewelTrinket2 = jewelTrinket;
            case 3 -> this.jewelTrinket3 = jewelTrinket;
        }
    }

    public void removeJewelTrinket(int jewelTrinketSlot)
    {
        switch (jewelTrinketSlot)
        {
            case 1 -> this.jewelTrinket1 = null;
            case 2 -> this.jewelTrinket2 = null;
            case 3 -> this.jewelTrinket3 = null;
        }
    }

    public JewelTrinket getJewelTrinket(int jewelTrinketSlot)
    {
        JewelTrinket jewelTrinket = null;
        switch (jewelTrinketSlot)
        {
            case 1 -> jewelTrinket = this.jewelTrinket1;
            case 2 -> jewelTrinket = this.jewelTrinket2;
            case 3 -> jewelTrinket = this.jewelTrinket3;
        }
        return jewelTrinket;
    }

    //pet + buffs
    public void setPet(Pet pet)
    {
        this.pet = pet;
    }

    public void removePet()
    {
        this.pet = null;
    }

    public Pet getPet()
    {
        return this.pet;
    }

    public void setEssence(double essDmg)
    {
        this.essDmg = essDmg;
    }

    public void removeEssence()
    {
        this.essDmg = 0.0;
    }

    public double getEssence()
    {
        return this.essDmg;
    }

    public void setTonic(Tonic tonic)
    {
        this.tonic = tonic;
    }

    public void removeTonic()
    {
        this.tonic = null;
    }

    public Tonic getTonic()
    {
        return tonic;
    }

    public void setPhysic(Physic physic)
    {
        this.physic = physic;
    }

    public void removePhysic()
    {
        this.physic = null;
    }

    public Physic getPhysic()
    {
        return physic;
    }

    public Map<StatType, Double> getCollectorBagBuffs()
    {
        return collectorBagBuffs;
    }

    public void setCollectorBagBuff(Map<StatType, Double> collectorBagBuffs)
    {
        this.collectorBagBuffs = collectorBagBuffs;
    }

    //TODO editable
    public WisdomSkillTree getWisdomSkillTree() {
        return wisdomSkillTree;
    }

    public void setWisdomSkillTree(WisdomSkillTree wisdomSkillTree) {
        this.wisdomSkillTree = wisdomSkillTree;
    }

    //stats
    public Map<StatType, Double> getClassBaseStats()
    {
        return this.classBaseStats;
    }

    public CharacterClass getCharacterClass()
    {
        return characterClass;
    }

    public String getName() {
        return name;
    }

    public Map<StatType, Double> getClassSpecialStats()
    {
        return classSpecialStats;
    }

    public Map<StatType, Double> getCharacterAbsoluteStats()
    {
        return characterAbsoluteStats;
    }

    public Map<StatType, Double> getCharacterFinalStats()
    {
        return characterFinalStats;
    }


    //stat calculation
    public void calculateFinalStats()
    {
        //bases stats
        this.characterAbsoluteStats.putAll(this.classBaseStats);
        //absolute stats via items/gems
        if (this.amulet != null)
        {
            for (Map.Entry<StatType, Double> entry : this.amulet.calculateTotalStats().entrySet())
            {
                if (entry.getKey() == StatType.RESISTANCE_VALUE)
                {
                    this.characterAbsoluteStats.put(StatType.ANDERMAGIC_RESISTANCE, this.characterAbsoluteStats.get(StatType.ANDERMAGIC_RESISTANCE)+ entry.getValue());
                    this.characterAbsoluteStats.put(StatType.FIRE_RESISTANCE, this.characterAbsoluteStats.get(StatType.FIRE_RESISTANCE)+ entry.getValue());
                    this.characterAbsoluteStats.put(StatType.ICE_RESISTANCE, this.characterAbsoluteStats.get(StatType.ICE_RESISTANCE)+ entry.getValue());
                    this.characterAbsoluteStats.put(StatType.LIGHTNING_RESISTANCE, this.characterAbsoluteStats.get(StatType.LIGHTNING_RESISTANCE)+ entry.getValue());
                    this.characterAbsoluteStats.put(StatType.POISON_RESISTANCE, this.characterAbsoluteStats.get(StatType.POISON_RESISTANCE)+ entry.getValue());
                }
                else
                {
                    StatType type = entry.getKey();
                    this.characterAbsoluteStats.put(type, this.characterAbsoluteStats.get(type)+ entry.getValue());
                }
            }
            if (this.amulet instanceof UniqueItem uniqueItem)
            {
                for (OverallBuff buff : uniqueItem.getOverallBuffs())
                {
                    if (buff instanceof OverallRelativeBuff relativeBuff)
                    {
                        this.characterRelativeBuffs.put(relativeBuff.getType(), this.characterRelativeBuffs.get(relativeBuff.getType())+relativeBuff.getValue());
                    }
                    else if (buff instanceof OverallAbsolutBuff absolutBuff)
                    {
                        this.characterAbsoluteStats.put(absolutBuff.getType(), this.characterAbsoluteStats.get(absolutBuff.getType())+ absolutBuff.getValue());
                    }
                }
            }else if (this.amulet instanceof MythicItem mythicItem)
            {
                for (OverallBuff buff : mythicItem.getOverallBuffs())
                {
                    if (buff instanceof OverallRelativeBuff relativeBuff)
                    {
                        this.characterRelativeBuffs.put(relativeBuff.getType(), this.characterRelativeBuffs.get(relativeBuff.getType())+relativeBuff.getValue());
                    }
                    else if (buff instanceof OverallAbsolutBuff absolutBuff)
                    {
                        this.characterAbsoluteStats.put(absolutBuff.getType(), this.characterAbsoluteStats.get(absolutBuff.getType())+ absolutBuff.getValue());
                    }
                }
            }
        }
        if (this.cloak != null)
        {
            for (Map.Entry<StatType, Double> entry : this.cloak.calculateTotalStats().entrySet())
            {
                if (entry.getKey() == StatType.RESISTANCE_VALUE)
                {
                    this.characterAbsoluteStats.put(StatType.ANDERMAGIC_RESISTANCE, this.characterAbsoluteStats.get(StatType.ANDERMAGIC_RESISTANCE)+ entry.getValue());
                    this.characterAbsoluteStats.put(StatType.FIRE_RESISTANCE, this.characterAbsoluteStats.get(StatType.FIRE_RESISTANCE)+ entry.getValue());
                    this.characterAbsoluteStats.put(StatType.ICE_RESISTANCE, this.characterAbsoluteStats.get(StatType.ICE_RESISTANCE)+ entry.getValue());
                    this.characterAbsoluteStats.put(StatType.LIGHTNING_RESISTANCE, this.characterAbsoluteStats.get(StatType.LIGHTNING_RESISTANCE)+ entry.getValue());
                    this.characterAbsoluteStats.put(StatType.POISON_RESISTANCE, this.characterAbsoluteStats.get(StatType.POISON_RESISTANCE)+ entry.getValue());
                }
                else
                {
                    StatType type = entry.getKey();
                    this.characterAbsoluteStats.put(type, this.characterAbsoluteStats.get(type)+ entry.getValue());
                }
            }
            if (this.cloak instanceof UniqueItem uniqueItem)
            {
                for (OverallBuff buff : uniqueItem.getOverallBuffs())
                {
                    if (buff instanceof OverallRelativeBuff relativeBuff)
                    {
                        this.characterRelativeBuffs.put(relativeBuff.getType(), this.characterRelativeBuffs.get(relativeBuff.getType())+relativeBuff.getValue());
                    }
                    else if (buff instanceof OverallAbsolutBuff absolutBuff)
                    {
                        this.characterAbsoluteStats.put(absolutBuff.getType(), this.characterAbsoluteStats.get(absolutBuff.getType())+ absolutBuff.getValue());
                    }
                }
            }else if (this.cloak instanceof MythicItem mythicItem)
            {
                for (OverallBuff buff : mythicItem.getOverallBuffs())
                {
                    if (buff instanceof OverallRelativeBuff relativeBuff)
                    {
                        this.characterRelativeBuffs.put(relativeBuff.getType(), this.characterRelativeBuffs.get(relativeBuff.getType())+relativeBuff.getValue());
                    }
                    else if (buff instanceof OverallAbsolutBuff absolutBuff)
                    {
                        this.characterAbsoluteStats.put(absolutBuff.getType(), this.characterAbsoluteStats.get(absolutBuff.getType())+ absolutBuff.getValue());
                    }
                }
            }
        }
        if (this.belt != null)
        {
            for (Map.Entry<StatType, Double> entry : this.belt.calculateTotalStats().entrySet())
            {
                if (entry.getKey() == StatType.RESISTANCE_VALUE)
                {
                    this.characterAbsoluteStats.put(StatType.ANDERMAGIC_RESISTANCE, this.characterAbsoluteStats.get(StatType.ANDERMAGIC_RESISTANCE)+ entry.getValue());
                    this.characterAbsoluteStats.put(StatType.FIRE_RESISTANCE, this.characterAbsoluteStats.get(StatType.FIRE_RESISTANCE)+ entry.getValue());
                    this.characterAbsoluteStats.put(StatType.ICE_RESISTANCE, this.characterAbsoluteStats.get(StatType.ICE_RESISTANCE)+ entry.getValue());
                    this.characterAbsoluteStats.put(StatType.LIGHTNING_RESISTANCE, this.characterAbsoluteStats.get(StatType.LIGHTNING_RESISTANCE)+ entry.getValue());
                    this.characterAbsoluteStats.put(StatType.POISON_RESISTANCE, this.characterAbsoluteStats.get(StatType.POISON_RESISTANCE)+ entry.getValue());
                }
                else
                {
                    StatType type = entry.getKey();
                    this.characterAbsoluteStats.put(type, this.characterAbsoluteStats.get(type)+ entry.getValue());
                }
            }
            if (this.belt instanceof UniqueItem uniqueItem)
            {
                for (OverallBuff buff : uniqueItem.getOverallBuffs())
                {
                    if (buff instanceof OverallRelativeBuff relativeBuff)
                    {
                        this.characterRelativeBuffs.put(relativeBuff.getType(), this.characterRelativeBuffs.get(relativeBuff.getType())+relativeBuff.getValue());
                    }
                    else if (buff instanceof OverallAbsolutBuff absolutBuff)
                    {
                        this.characterAbsoluteStats.put(absolutBuff.getType(), this.characterAbsoluteStats.get(absolutBuff.getType())+ absolutBuff.getValue());
                    }
                }
            }else if (this.belt instanceof MythicItem mythicItem)
            {
                for (OverallBuff buff : mythicItem.getOverallBuffs())
                {
                    if (buff instanceof OverallRelativeBuff relativeBuff)
                    {
                        this.characterRelativeBuffs.put(relativeBuff.getType(), this.characterRelativeBuffs.get(relativeBuff.getType())+relativeBuff.getValue());
                    }
                    else if (buff instanceof OverallAbsolutBuff absolutBuff)
                    {
                        this.characterAbsoluteStats.put(absolutBuff.getType(), this.characterAbsoluteStats.get(absolutBuff.getType())+ absolutBuff.getValue());
                    }
                }
            }
        }
        if (this.ring1 != null)
        {
            for (Map.Entry<StatType, Double> entry : this.ring1.calculateTotalStats().entrySet())
            {
                if (entry.getKey() == StatType.RESISTANCE_VALUE)
                {
                    this.characterAbsoluteStats.put(StatType.ANDERMAGIC_RESISTANCE, this.characterAbsoluteStats.get(StatType.ANDERMAGIC_RESISTANCE)+ entry.getValue());
                    this.characterAbsoluteStats.put(StatType.FIRE_RESISTANCE, this.characterAbsoluteStats.get(StatType.FIRE_RESISTANCE)+ entry.getValue());
                    this.characterAbsoluteStats.put(StatType.ICE_RESISTANCE, this.characterAbsoluteStats.get(StatType.ICE_RESISTANCE)+ entry.getValue());
                    this.characterAbsoluteStats.put(StatType.LIGHTNING_RESISTANCE, this.characterAbsoluteStats.get(StatType.LIGHTNING_RESISTANCE)+ entry.getValue());
                    this.characterAbsoluteStats.put(StatType.POISON_RESISTANCE, this.characterAbsoluteStats.get(StatType.POISON_RESISTANCE)+ entry.getValue());
                }
                else
                {
                    StatType type = entry.getKey();
                    this.characterAbsoluteStats.put(type, this.characterAbsoluteStats.get(type)+ entry.getValue());
                }
            }
            if (this.ring1 instanceof UniqueItem uniqueItem)
            {
                for (OverallBuff buff : uniqueItem.getOverallBuffs())
                {
                    if (buff instanceof OverallRelativeBuff relativeBuff)
                    {
                        this.characterRelativeBuffs.put(relativeBuff.getType(), this.characterRelativeBuffs.get(relativeBuff.getType())+relativeBuff.getValue());
                    }
                    else if (buff instanceof OverallAbsolutBuff absolutBuff)
                    {
                        this.characterAbsoluteStats.put(absolutBuff.getType(), this.characterAbsoluteStats.get(absolutBuff.getType())+ absolutBuff.getValue());
                    }
                }
            }else if (this.ring1 instanceof MythicItem mythicItem)
            {
                for (OverallBuff buff : mythicItem.getOverallBuffs())
                {
                    if (buff instanceof OverallRelativeBuff relativeBuff)
                    {
                        this.characterRelativeBuffs.put(relativeBuff.getType(), this.characterRelativeBuffs.get(relativeBuff.getType())+relativeBuff.getValue());
                    }
                    else if (buff instanceof OverallAbsolutBuff absolutBuff)
                    {
                        this.characterAbsoluteStats.put(absolutBuff.getType(), this.characterAbsoluteStats.get(absolutBuff.getType())+ absolutBuff.getValue());
                    }
                }
            }
        }
        if (this.ring2 != null)
        {
            for (Map.Entry<StatType, Double> entry : this.ring2.calculateTotalStats().entrySet())
            {
                if (entry.getKey() == StatType.RESISTANCE_VALUE)
                {
                    this.characterAbsoluteStats.put(StatType.ANDERMAGIC_RESISTANCE, this.characterAbsoluteStats.get(StatType.ANDERMAGIC_RESISTANCE)+ entry.getValue());
                    this.characterAbsoluteStats.put(StatType.FIRE_RESISTANCE, this.characterAbsoluteStats.get(StatType.FIRE_RESISTANCE)+ entry.getValue());
                    this.characterAbsoluteStats.put(StatType.ICE_RESISTANCE, this.characterAbsoluteStats.get(StatType.ICE_RESISTANCE)+ entry.getValue());
                    this.characterAbsoluteStats.put(StatType.LIGHTNING_RESISTANCE, this.characterAbsoluteStats.get(StatType.LIGHTNING_RESISTANCE)+ entry.getValue());
                    this.characterAbsoluteStats.put(StatType.POISON_RESISTANCE, this.characterAbsoluteStats.get(StatType.POISON_RESISTANCE)+ entry.getValue());
                }
                else
                {
                    StatType type = entry.getKey();
                    this.characterAbsoluteStats.put(type, this.characterAbsoluteStats.get(type)+ entry.getValue());
                }
            }
            if (this.ring2 instanceof UniqueItem uniqueItem)
            {
                for (OverallBuff buff : uniqueItem.getOverallBuffs())
                {
                    if (buff instanceof OverallRelativeBuff relativeBuff)
                    {
                        this.characterRelativeBuffs.put(relativeBuff.getType(), this.characterRelativeBuffs.get(relativeBuff.getType())+relativeBuff.getValue());
                    }
                    else if (buff instanceof OverallAbsolutBuff absolutBuff)
                    {
                        this.characterAbsoluteStats.put(absolutBuff.getType(), this.characterAbsoluteStats.get(absolutBuff.getType())+ absolutBuff.getValue());
                    }
                }
            }else if (this.ring2 instanceof MythicItem mythicItem)
            {
                for (OverallBuff buff : mythicItem.getOverallBuffs())
                {
                    if (buff instanceof OverallRelativeBuff relativeBuff)
                    {
                        this.characterRelativeBuffs.put(relativeBuff.getType(), this.characterRelativeBuffs.get(relativeBuff.getType())+relativeBuff.getValue());
                    }
                    else if (buff instanceof OverallAbsolutBuff absolutBuff)
                    {
                        this.characterAbsoluteStats.put(absolutBuff.getType(), this.characterAbsoluteStats.get(absolutBuff.getType())+ absolutBuff.getValue());
                    }
                }
            }
        }
        if (this.helmet != null)
        {
            for (Map.Entry<StatType, Double> entry : this.helmet.calculateTotalStats().entrySet())
            {
                if (entry.getKey() == StatType.RESISTANCE_VALUE)
                {
                    this.characterAbsoluteStats.put(StatType.ANDERMAGIC_RESISTANCE, this.characterAbsoluteStats.get(StatType.ANDERMAGIC_RESISTANCE)+ entry.getValue());
                    this.characterAbsoluteStats.put(StatType.FIRE_RESISTANCE, this.characterAbsoluteStats.get(StatType.FIRE_RESISTANCE)+ entry.getValue());
                    this.characterAbsoluteStats.put(StatType.ICE_RESISTANCE, this.characterAbsoluteStats.get(StatType.ICE_RESISTANCE)+ entry.getValue());
                    this.characterAbsoluteStats.put(StatType.LIGHTNING_RESISTANCE, this.characterAbsoluteStats.get(StatType.LIGHTNING_RESISTANCE)+ entry.getValue());
                    this.characterAbsoluteStats.put(StatType.POISON_RESISTANCE, this.characterAbsoluteStats.get(StatType.POISON_RESISTANCE)+ entry.getValue());
                }
                else
                {
                    StatType type = entry.getKey();
                    this.characterAbsoluteStats.put(type, this.characterAbsoluteStats.get(type)+ entry.getValue());
                }
            }
            if (this.helmet instanceof UniqueItem uniqueItem)
            {
                for (OverallBuff buff : uniqueItem.getOverallBuffs())
                {
                    if (buff instanceof OverallRelativeBuff relativeBuff)
                    {
                        this.characterRelativeBuffs.put(relativeBuff.getType(), this.characterRelativeBuffs.get(relativeBuff.getType())+relativeBuff.getValue());
                    }
                    else if (buff instanceof OverallAbsolutBuff absolutBuff)
                    {
                        this.characterAbsoluteStats.put(absolutBuff.getType(), this.characterAbsoluteStats.get(absolutBuff.getType())+ absolutBuff.getValue());
                    }
                }
            }else if (this.helmet instanceof MythicItem mythicItem)
            {
                for (OverallBuff buff : mythicItem.getOverallBuffs())
                {
                    if (buff instanceof OverallRelativeBuff relativeBuff)
                    {
                        this.characterRelativeBuffs.put(relativeBuff.getType(), this.characterRelativeBuffs.get(relativeBuff.getType())+relativeBuff.getValue());
                    }
                    else if (buff instanceof OverallAbsolutBuff absolutBuff)
                    {
                        this.characterAbsoluteStats.put(absolutBuff.getType(), this.characterAbsoluteStats.get(absolutBuff.getType())+ absolutBuff.getValue());
                    }
                }
            }
        }
        if (this.shoulders != null)
        {
            for (Map.Entry<StatType, Double> entry : this.shoulders.calculateTotalStats().entrySet())
            {
                if (entry.getKey() == StatType.RESISTANCE_VALUE)
                {
                    this.characterAbsoluteStats.put(StatType.ANDERMAGIC_RESISTANCE, this.characterAbsoluteStats.get(StatType.ANDERMAGIC_RESISTANCE)+ entry.getValue());
                    this.characterAbsoluteStats.put(StatType.FIRE_RESISTANCE, this.characterAbsoluteStats.get(StatType.FIRE_RESISTANCE)+ entry.getValue());
                    this.characterAbsoluteStats.put(StatType.ICE_RESISTANCE, this.characterAbsoluteStats.get(StatType.ICE_RESISTANCE)+ entry.getValue());
                    this.characterAbsoluteStats.put(StatType.LIGHTNING_RESISTANCE, this.characterAbsoluteStats.get(StatType.LIGHTNING_RESISTANCE)+ entry.getValue());
                    this.characterAbsoluteStats.put(StatType.POISON_RESISTANCE, this.characterAbsoluteStats.get(StatType.POISON_RESISTANCE)+ entry.getValue());
                }
                else
                {
                    StatType type = entry.getKey();
                    this.characterAbsoluteStats.put(type, this.characterAbsoluteStats.get(type)+ entry.getValue());
                }
            }
            if (this.shoulders instanceof UniqueItem uniqueItem)
            {
                for (OverallBuff buff : uniqueItem.getOverallBuffs())
                {
                    if (buff instanceof OverallRelativeBuff relativeBuff)
                    {
                        this.characterRelativeBuffs.put(relativeBuff.getType(), this.characterRelativeBuffs.get(relativeBuff.getType())+relativeBuff.getValue());
                    }
                    else if (buff instanceof OverallAbsolutBuff absolutBuff)
                    {
                        this.characterAbsoluteStats.put(absolutBuff.getType(), this.characterAbsoluteStats.get(absolutBuff.getType())+ absolutBuff.getValue());
                    }
                }
            }else if (this.shoulders instanceof MythicItem mythicItem)
            {
                for (OverallBuff buff : mythicItem.getOverallBuffs())
                {
                    if (buff instanceof OverallRelativeBuff relativeBuff)
                    {
                        this.characterRelativeBuffs.put(relativeBuff.getType(), this.characterRelativeBuffs.get(relativeBuff.getType())+relativeBuff.getValue());
                    }
                    else if (buff instanceof OverallAbsolutBuff absolutBuff)
                    {
                        this.characterAbsoluteStats.put(absolutBuff.getType(), this.characterAbsoluteStats.get(absolutBuff.getType())+ absolutBuff.getValue());
                    }
                }
            }
        }
        if (this.torso != null)
        {
            for (Map.Entry<StatType, Double> entry : this.torso.calculateTotalStats().entrySet())
            {
                if (entry.getKey() == StatType.RESISTANCE_VALUE)
                {
                    this.characterAbsoluteStats.put(StatType.ANDERMAGIC_RESISTANCE, this.characterAbsoluteStats.get(StatType.ANDERMAGIC_RESISTANCE)+ entry.getValue());
                    this.characterAbsoluteStats.put(StatType.FIRE_RESISTANCE, this.characterAbsoluteStats.get(StatType.FIRE_RESISTANCE)+ entry.getValue());
                    this.characterAbsoluteStats.put(StatType.ICE_RESISTANCE, this.characterAbsoluteStats.get(StatType.ICE_RESISTANCE)+ entry.getValue());
                    this.characterAbsoluteStats.put(StatType.LIGHTNING_RESISTANCE, this.characterAbsoluteStats.get(StatType.LIGHTNING_RESISTANCE)+ entry.getValue());
                    this.characterAbsoluteStats.put(StatType.POISON_RESISTANCE, this.characterAbsoluteStats.get(StatType.POISON_RESISTANCE)+ entry.getValue());
                }
                else
                {
                    StatType type = entry.getKey();
                    this.characterAbsoluteStats.put(type, this.characterAbsoluteStats.get(type)+ entry.getValue());
                }
            }
            if (this.torso instanceof UniqueItem uniqueItem)
            {
                for (OverallBuff buff : uniqueItem.getOverallBuffs())
                {
                    if (buff instanceof OverallRelativeBuff relativeBuff)
                    {
                        this.characterRelativeBuffs.put(relativeBuff.getType(), this.characterRelativeBuffs.get(relativeBuff.getType())+relativeBuff.getValue());
                    }
                    else if (buff instanceof OverallAbsolutBuff absolutBuff)
                    {
                        this.characterAbsoluteStats.put(absolutBuff.getType(), this.characterAbsoluteStats.get(absolutBuff.getType())+ absolutBuff.getValue());
                    }
                }
            }else if (this.torso instanceof MythicItem mythicItem)
            {
                for (OverallBuff buff : mythicItem.getOverallBuffs())
                {
                    if (buff instanceof OverallRelativeBuff relativeBuff)
                    {
                        this.characterRelativeBuffs.put(relativeBuff.getType(), this.characterRelativeBuffs.get(relativeBuff.getType())+relativeBuff.getValue());
                    }
                    else if (buff instanceof OverallAbsolutBuff absolutBuff)
                    {
                        this.characterAbsoluteStats.put(absolutBuff.getType(), this.characterAbsoluteStats.get(absolutBuff.getType())+ absolutBuff.getValue());
                    }
                }
            }
        }
        if (this.gloves != null)
        {
            for (Map.Entry<StatType, Double> entry : this.gloves.calculateTotalStats().entrySet())
            {
                if (entry.getKey() == StatType.RESISTANCE_VALUE)
                {
                    this.characterAbsoluteStats.put(StatType.ANDERMAGIC_RESISTANCE, this.characterAbsoluteStats.get(StatType.ANDERMAGIC_RESISTANCE)+ entry.getValue());
                    this.characterAbsoluteStats.put(StatType.FIRE_RESISTANCE, this.characterAbsoluteStats.get(StatType.FIRE_RESISTANCE)+ entry.getValue());
                    this.characterAbsoluteStats.put(StatType.ICE_RESISTANCE, this.characterAbsoluteStats.get(StatType.ICE_RESISTANCE)+ entry.getValue());
                    this.characterAbsoluteStats.put(StatType.LIGHTNING_RESISTANCE, this.characterAbsoluteStats.get(StatType.LIGHTNING_RESISTANCE)+ entry.getValue());
                    this.characterAbsoluteStats.put(StatType.POISON_RESISTANCE, this.characterAbsoluteStats.get(StatType.POISON_RESISTANCE)+ entry.getValue());
                }
                else
                {
                    StatType type = entry.getKey();
                    this.characterAbsoluteStats.put(type, this.characterAbsoluteStats.get(type)+ entry.getValue());
                }
            }
            if (this.gloves instanceof UniqueItem uniqueItem)
            {
                for (OverallBuff buff : uniqueItem.getOverallBuffs())
                {
                    if (buff instanceof OverallRelativeBuff relativeBuff)
                    {
                        this.characterRelativeBuffs.put(relativeBuff.getType(), this.characterRelativeBuffs.get(relativeBuff.getType())+relativeBuff.getValue());
                    }
                    else if (buff instanceof OverallAbsolutBuff absolutBuff)
                    {
                        this.characterAbsoluteStats.put(absolutBuff.getType(), this.characterAbsoluteStats.get(absolutBuff.getType())+ absolutBuff.getValue());
                    }
                }
            }else if (this.gloves instanceof MythicItem mythicItem)
            {
                for (OverallBuff buff : mythicItem.getOverallBuffs())
                {
                    if (buff instanceof OverallRelativeBuff relativeBuff)
                    {
                        this.characterRelativeBuffs.put(relativeBuff.getType(), this.characterRelativeBuffs.get(relativeBuff.getType())+relativeBuff.getValue());
                    }
                    else if (buff instanceof OverallAbsolutBuff absolutBuff)
                    {
                        this.characterAbsoluteStats.put(absolutBuff.getType(), this.characterAbsoluteStats.get(absolutBuff.getType())+ absolutBuff.getValue());
                    }
                }
            }
        }
        if (this.boots != null)
        {
            for (Map.Entry<StatType, Double> entry : this.boots.calculateTotalStats().entrySet())
            {
                if (entry.getKey() == StatType.RESISTANCE_VALUE)
                {
                    this.characterAbsoluteStats.put(StatType.ANDERMAGIC_RESISTANCE, this.characterAbsoluteStats.get(StatType.ANDERMAGIC_RESISTANCE)+ entry.getValue());
                    this.characterAbsoluteStats.put(StatType.FIRE_RESISTANCE, this.characterAbsoluteStats.get(StatType.FIRE_RESISTANCE)+ entry.getValue());
                    this.characterAbsoluteStats.put(StatType.ICE_RESISTANCE, this.characterAbsoluteStats.get(StatType.ICE_RESISTANCE)+ entry.getValue());
                    this.characterAbsoluteStats.put(StatType.LIGHTNING_RESISTANCE, this.characterAbsoluteStats.get(StatType.LIGHTNING_RESISTANCE)+ entry.getValue());
                    this.characterAbsoluteStats.put(StatType.POISON_RESISTANCE, this.characterAbsoluteStats.get(StatType.POISON_RESISTANCE)+ entry.getValue());
                }
                else
                {
                    StatType type = entry.getKey();
                    this.characterAbsoluteStats.put(type, this.characterAbsoluteStats.get(type)+ entry.getValue());
                }
            }
            if (this.boots instanceof UniqueItem uniqueItem)
            {
                for (OverallBuff buff : uniqueItem.getOverallBuffs())
                {
                    if (buff instanceof OverallRelativeBuff relativeBuff)
                    {
                        this.characterRelativeBuffs.put(relativeBuff.getType(), this.characterRelativeBuffs.get(relativeBuff.getType())+relativeBuff.getValue());
                    }
                    else if (buff instanceof OverallAbsolutBuff absolutBuff)
                    {
                        this.characterAbsoluteStats.put(absolutBuff.getType(), this.characterAbsoluteStats.get(absolutBuff.getType())+ absolutBuff.getValue());
                    }
                }
            }else if (this.boots instanceof MythicItem mythicItem)
            {
                for (OverallBuff buff : mythicItem.getOverallBuffs())
                {
                    if (buff instanceof OverallRelativeBuff relativeBuff)
                    {
                        this.characterRelativeBuffs.put(relativeBuff.getType(), this.characterRelativeBuffs.get(relativeBuff.getType())+relativeBuff.getValue());
                    }
                    else if (buff instanceof OverallAbsolutBuff absolutBuff)
                    {
                        this.characterAbsoluteStats.put(absolutBuff.getType(), this.characterAbsoluteStats.get(absolutBuff.getType())+ absolutBuff.getValue());
                    }
                }
            }
        }
        if (this.weapon_adornment != null)
        {
            for (Map.Entry<StatType, Double> entry : this.weapon_adornment.calculateTotalStats().entrySet())
            {
                if (entry.getKey() == StatType.RESISTANCE_VALUE)
                {
                    this.characterAbsoluteStats.put(StatType.ANDERMAGIC_RESISTANCE, this.characterAbsoluteStats.get(StatType.ANDERMAGIC_RESISTANCE)+ entry.getValue());
                    this.characterAbsoluteStats.put(StatType.FIRE_RESISTANCE, this.characterAbsoluteStats.get(StatType.FIRE_RESISTANCE)+ entry.getValue());
                    this.characterAbsoluteStats.put(StatType.ICE_RESISTANCE, this.characterAbsoluteStats.get(StatType.ICE_RESISTANCE)+ entry.getValue());
                    this.characterAbsoluteStats.put(StatType.LIGHTNING_RESISTANCE, this.characterAbsoluteStats.get(StatType.LIGHTNING_RESISTANCE)+ entry.getValue());
                    this.characterAbsoluteStats.put(StatType.POISON_RESISTANCE, this.characterAbsoluteStats.get(StatType.POISON_RESISTANCE)+ entry.getValue());
                }
                else
                {
                    StatType type = entry.getKey();
                    this.characterAbsoluteStats.put(type, this.characterAbsoluteStats.get(type)+ entry.getValue());
                }
            }
            if (this.weapon_adornment instanceof UniqueItem uniqueItem)
            {
                for (OverallBuff buff : uniqueItem.getOverallBuffs())
                {
                    if (buff instanceof OverallRelativeBuff relativeBuff)
                    {
                        this.characterRelativeBuffs.put(relativeBuff.getType(), this.characterRelativeBuffs.get(relativeBuff.getType())+relativeBuff.getValue());
                    }
                    else if (buff instanceof OverallAbsolutBuff absolutBuff)
                    {
                        this.characterAbsoluteStats.put(absolutBuff.getType(), this.characterAbsoluteStats.get(absolutBuff.getType())+ absolutBuff.getValue());
                    }
                }
            }else if (this.weapon_adornment instanceof MythicItem mythicItem)
            {
                for (OverallBuff buff : mythicItem.getOverallBuffs())
                {
                    if (buff instanceof OverallRelativeBuff relativeBuff)
                    {
                        this.characterRelativeBuffs.put(relativeBuff.getType(), this.characterRelativeBuffs.get(relativeBuff.getType())+relativeBuff.getValue());
                    }
                    else if (buff instanceof OverallAbsolutBuff absolutBuff)
                    {
                        this.characterAbsoluteStats.put(absolutBuff.getType(), this.characterAbsoluteStats.get(absolutBuff.getType())+ absolutBuff.getValue());
                    }
                }
            }
        }
        if (this.one_hand_weapon != null)
        {
            for (Map.Entry<StatType, Double> entry : this.one_hand_weapon.calculateTotalStats().entrySet())
            {
                if (entry.getKey() == StatType.RESISTANCE_VALUE)
                {
                    this.characterAbsoluteStats.put(StatType.ANDERMAGIC_RESISTANCE, this.characterAbsoluteStats.get(StatType.ANDERMAGIC_RESISTANCE)+ entry.getValue());
                    this.characterAbsoluteStats.put(StatType.FIRE_RESISTANCE, this.characterAbsoluteStats.get(StatType.FIRE_RESISTANCE)+ entry.getValue());
                    this.characterAbsoluteStats.put(StatType.ICE_RESISTANCE, this.characterAbsoluteStats.get(StatType.ICE_RESISTANCE)+ entry.getValue());
                    this.characterAbsoluteStats.put(StatType.LIGHTNING_RESISTANCE, this.characterAbsoluteStats.get(StatType.LIGHTNING_RESISTANCE)+ entry.getValue());
                    this.characterAbsoluteStats.put(StatType.POISON_RESISTANCE, this.characterAbsoluteStats.get(StatType.POISON_RESISTANCE)+ entry.getValue());
                }
                else
                {
                    StatType type = entry.getKey();
                    this.characterAbsoluteStats.put(type, this.characterAbsoluteStats.get(type)+ entry.getValue());
                }
            }
            if (this.one_hand_weapon instanceof UniqueItem uniqueItem)
            {
                for (OverallBuff buff : uniqueItem.getOverallBuffs())
                {
                    if (buff instanceof OverallRelativeBuff relativeBuff)
                    {
                        this.characterRelativeBuffs.put(relativeBuff.getType(), this.characterRelativeBuffs.get(relativeBuff.getType())+relativeBuff.getValue());
                    }
                    else if (buff instanceof OverallAbsolutBuff absolutBuff)
                    {
                        this.characterAbsoluteStats.put(absolutBuff.getType(), this.characterAbsoluteStats.get(absolutBuff.getType())+ absolutBuff.getValue());
                    }
                }
            }else if (this.one_hand_weapon instanceof MythicItem mythicItem)
            {
                for (OverallBuff buff : mythicItem.getOverallBuffs())
                {
                    if (buff instanceof OverallRelativeBuff relativeBuff)
                    {
                        this.characterRelativeBuffs.put(relativeBuff.getType(), this.characterRelativeBuffs.get(relativeBuff.getType())+relativeBuff.getValue());
                    }
                    else if (buff instanceof OverallAbsolutBuff absolutBuff)
                    {
                        this.characterAbsoluteStats.put(absolutBuff.getType(), this.characterAbsoluteStats.get(absolutBuff.getType())+ absolutBuff.getValue());
                    }
                }
            }
        }
        if (this.off_hand != null)
        {
            for (Map.Entry<StatType, Double> entry : this.off_hand.calculateTotalStats().entrySet())
            {
                if (entry.getKey() == StatType.RESISTANCE_VALUE)
                {
                    this.characterAbsoluteStats.put(StatType.ANDERMAGIC_RESISTANCE, this.characterAbsoluteStats.get(StatType.ANDERMAGIC_RESISTANCE)+ entry.getValue());
                    this.characterAbsoluteStats.put(StatType.FIRE_RESISTANCE, this.characterAbsoluteStats.get(StatType.FIRE_RESISTANCE)+ entry.getValue());
                    this.characterAbsoluteStats.put(StatType.ICE_RESISTANCE, this.characterAbsoluteStats.get(StatType.ICE_RESISTANCE)+ entry.getValue());
                    this.characterAbsoluteStats.put(StatType.LIGHTNING_RESISTANCE, this.characterAbsoluteStats.get(StatType.LIGHTNING_RESISTANCE)+ entry.getValue());
                    this.characterAbsoluteStats.put(StatType.POISON_RESISTANCE, this.characterAbsoluteStats.get(StatType.POISON_RESISTANCE)+ entry.getValue());
                }
                else
                {
                    StatType type = entry.getKey();
                    this.characterAbsoluteStats.put(type, this.characterAbsoluteStats.get(type)+ entry.getValue());
                }
            }
            if (this.off_hand instanceof UniqueItem uniqueItem)
            {
                for (OverallBuff buff : uniqueItem.getOverallBuffs())
                {
                    if (buff instanceof OverallRelativeBuff relativeBuff)
                    {
                        this.characterRelativeBuffs.put(relativeBuff.getType(), this.characterRelativeBuffs.get(relativeBuff.getType())+relativeBuff.getValue());
                    }
                    else if (buff instanceof OverallAbsolutBuff absolutBuff)
                    {
                        this.characterAbsoluteStats.put(absolutBuff.getType(), this.characterAbsoluteStats.get(absolutBuff.getType())+ absolutBuff.getValue());
                    }
                }
            }else if (this.off_hand instanceof MythicItem mythicItem)
            {
                for (OverallBuff buff : mythicItem.getOverallBuffs())
                {
                    if (buff instanceof OverallRelativeBuff relativeBuff)
                    {
                        this.characterRelativeBuffs.put(relativeBuff.getType(), this.characterRelativeBuffs.get(relativeBuff.getType())+relativeBuff.getValue());
                    }
                    else if (buff instanceof OverallAbsolutBuff absolutBuff)
                    {
                        this.characterAbsoluteStats.put(absolutBuff.getType(), this.characterAbsoluteStats.get(absolutBuff.getType())+ absolutBuff.getValue());
                    }
                }
            }
        }
        if (this.two_hand_weapon != null)
        {
            for (Map.Entry<StatType, Double> entry : this.two_hand_weapon.calculateTotalStats().entrySet())
            {
                if (entry.getKey() == StatType.RESISTANCE_VALUE)
                {
                    this.characterAbsoluteStats.put(StatType.ANDERMAGIC_RESISTANCE, this.characterAbsoluteStats.get(StatType.ANDERMAGIC_RESISTANCE)+ entry.getValue());
                    this.characterAbsoluteStats.put(StatType.FIRE_RESISTANCE, this.characterAbsoluteStats.get(StatType.FIRE_RESISTANCE)+ entry.getValue());
                    this.characterAbsoluteStats.put(StatType.ICE_RESISTANCE, this.characterAbsoluteStats.get(StatType.ICE_RESISTANCE)+ entry.getValue());
                    this.characterAbsoluteStats.put(StatType.LIGHTNING_RESISTANCE, this.characterAbsoluteStats.get(StatType.LIGHTNING_RESISTANCE)+ entry.getValue());
                    this.characterAbsoluteStats.put(StatType.POISON_RESISTANCE, this.characterAbsoluteStats.get(StatType.POISON_RESISTANCE)+ entry.getValue());
                }
                else
                {
                    StatType type = entry.getKey();
                    this.characterAbsoluteStats.put(type, this.characterAbsoluteStats.get(type)+ entry.getValue());
                }
            }
            if (this.two_hand_weapon instanceof UniqueItem uniqueItem)
            {
                for (OverallBuff buff : uniqueItem.getOverallBuffs())
                {
                    if (buff instanceof OverallRelativeBuff relativeBuff)
                    {
                        this.characterRelativeBuffs.put(relativeBuff.getType(), this.characterRelativeBuffs.get(relativeBuff.getType())+relativeBuff.getValue());
                    }
                    else if (buff instanceof OverallAbsolutBuff absolutBuff)
                    {
                        this.characterAbsoluteStats.put(absolutBuff.getType(), this.characterAbsoluteStats.get(absolutBuff.getType())+ absolutBuff.getValue());
                    }
                }
            }else if (this.two_hand_weapon instanceof MythicItem mythicItem)
            {
                for (OverallBuff buff : mythicItem.getOverallBuffs())
                {
                    if (buff instanceof OverallRelativeBuff relativeBuff)
                    {
                        this.characterRelativeBuffs.put(relativeBuff.getType(), this.characterRelativeBuffs.get(relativeBuff.getType())+relativeBuff.getValue());
                    }
                    else if (buff instanceof OverallAbsolutBuff absolutBuff)
                    {
                        this.characterAbsoluteStats.put(absolutBuff.getType(), this.characterAbsoluteStats.get(absolutBuff.getType())+ absolutBuff.getValue());
                    }
                }
            }
        }

        //runes
        for (Rune rune : this.runeTrinket1.getRunes())
        {
            for (Map.Entry<StatType, Double> stat : rune.getStats().entrySet())
            {
                if (this.characterRelativeBuffs.containsKey(stat.getKey()))
                {
                    this.characterRelativeBuffs.put(stat.getKey(), this.characterRelativeBuffs.get(stat.getValue()));
                }
                else
                {
                    this.characterRelativeBuffs.put(stat.getKey(), this.characterRelativeBuffs.get(stat.getKey())+stat.getValue());
                }
            }
        }
        for (Rune rune : this.runeTrinket2.getRunes())
        {
            for (Map.Entry<StatType, Double> stat : rune.getStats().entrySet())
            {
                if (this.characterRelativeBuffs.containsKey(stat.getKey()))
                {
                    this.characterRelativeBuffs.put(stat.getKey(), this.characterRelativeBuffs.get(stat.getValue()));
                }
                else
                {
                    this.characterRelativeBuffs.put(stat.getKey(), this.characterRelativeBuffs.get(stat.getKey())+stat.getValue());
                }
            }
        }
        for (Rune rune : this.runeTrinket3.getRunes())
        {
            for (Map.Entry<StatType, Double> stat : rune.getStats().entrySet())
            {
                if (this.characterRelativeBuffs.containsKey(stat.getKey()))
                {
                    this.characterRelativeBuffs.put(stat.getKey(), this.characterRelativeBuffs.get(stat.getValue()));
                }
                else
                {
                    this.characterRelativeBuffs.put(stat.getKey(), this.characterRelativeBuffs.get(stat.getKey())+stat.getValue());
                }
            }
        }
        for (Rune rune : this.runeTrinket4.getRunes())
        {
            for (Map.Entry<StatType, Double> stat : rune.getStats().entrySet())
            {
                if (this.characterRelativeBuffs.containsKey(stat.getKey()))
                {
                    this.characterRelativeBuffs.put(stat.getKey(), this.characterRelativeBuffs.get(stat.getValue()));
                }
                else
                {
                    this.characterRelativeBuffs.put(stat.getKey(), this.characterRelativeBuffs.get(stat.getKey())+stat.getValue());
                }
            }
        }
        for (Rune rune : this.runeTrinket5.getRunes())
        {
            for (Map.Entry<StatType, Double> stat : rune.getStats().entrySet())
            {
                if (this.characterRelativeBuffs.containsKey(stat.getKey()))
                {
                    this.characterRelativeBuffs.put(stat.getKey(), this.characterRelativeBuffs.get(stat.getValue()));
                }
                else
                {
                    this.characterRelativeBuffs.put(stat.getKey(), this.characterRelativeBuffs.get(stat.getKey())+stat.getValue());
                }
            }
        }

        //jewels
        for (Jewel jewel : this.jewelTrinket1.getJewels())
        {
            for (Map.Entry<StatType, Double> stat : jewel.getStats().entrySet())
            {
                if (this.characterRelativeBuffs.containsKey(stat.getKey()))
                {
                    this.characterRelativeBuffs.put(stat.getKey(), this.characterRelativeBuffs.get(stat.getValue()));
                }
                else
                {
                    this.characterRelativeBuffs.put(stat.getKey(), this.characterRelativeBuffs.get(stat.getKey())+stat.getValue());
                }
            }
        }
        for (Jewel jewel : this.jewelTrinket2.getJewels())
        {
            for (Map.Entry<StatType, Double> stat : jewel.getStats().entrySet())
            {
                if (this.characterRelativeBuffs.containsKey(stat.getKey()))
                {
                    this.characterRelativeBuffs.put(stat.getKey(), this.characterRelativeBuffs.get(stat.getValue()));
                }
                else
                {
                    this.characterRelativeBuffs.put(stat.getKey(), this.characterRelativeBuffs.get(stat.getKey())+stat.getValue());
                }
            }
        }
        for (Jewel jewel : this.jewelTrinket3.getJewels())
        {
            for (Map.Entry<StatType, Double> stat : jewel.getStats().entrySet())
            {
                if (this.characterRelativeBuffs.containsKey(stat.getKey()))
                {
                    this.characterRelativeBuffs.put(stat.getKey(), this.characterRelativeBuffs.get(stat.getValue()));
                }
                else
                {
                    this.characterRelativeBuffs.put(stat.getKey(), this.characterRelativeBuffs.get(stat.getKey())+stat.getValue());
                }
            }
        }

        //set boni
        for (Map.Entry<SetEnumInterface, List<String>> entry : this.sets.entrySet())
        {
            int usedItems = new  HashSet<>(entry.getValue()).size();
            if (entry.getKey() instanceof SpellweaverSets spellweaverSet)
            {
                for (int i=1; i<=usedItems; i++)
                {
                    for (OverallBuff buff : spellweaverSet.getSetBonus().getOrDefault(i, List.of()))
                    {
                        if (buff instanceof OverallAbsolutBuff absolutBuff)
                        {
                            if (absolutBuff.getType() == StatType.RESISTANCE_VALUE)
                            {
                                this.characterAbsoluteStats.put(StatType.ANDERMAGIC_RESISTANCE, this.characterAbsoluteStats.get(StatType.ANDERMAGIC_RESISTANCE)+ absolutBuff.getValue());
                                this.characterAbsoluteStats.put(StatType.FIRE_RESISTANCE, this.characterAbsoluteStats.get(StatType.FIRE_RESISTANCE)+ absolutBuff.getValue());
                                this.characterAbsoluteStats.put(StatType.ICE_RESISTANCE, this.characterAbsoluteStats.get(StatType.ICE_RESISTANCE)+ absolutBuff.getValue());
                                this.characterAbsoluteStats.put(StatType.LIGHTNING_RESISTANCE, this.characterAbsoluteStats.get(StatType.LIGHTNING_RESISTANCE)+ absolutBuff.getValue());
                                this.characterAbsoluteStats.put(StatType.POISON_RESISTANCE, this.characterAbsoluteStats.get(StatType.POISON_RESISTANCE)+ absolutBuff.getValue());
                            }
                            else
                            {
                                this.characterAbsoluteStats.put(absolutBuff.getType(), this.characterAbsoluteStats.get(absolutBuff.getType()) + absolutBuff.getValue());
                            }
                        }
                        else if (buff instanceof OverallRelativeBuff relativeBuff)
                        {
                            this.characterRelativeBuffs.put(relativeBuff.getType(), this.characterRelativeBuffs.get(relativeBuff.getType())+relativeBuff.getValue());
                        }
                    }
                }
            }
            else if (entry.getKey() instanceof DragonknightSets dragonknightSet)
            {
                for (int i=1; i<=usedItems; i++)
                {
                    for (OverallBuff buff : dragonknightSet.getSetBonus().getOrDefault(i, List.of()))
                    {
                        if (buff instanceof OverallAbsolutBuff absolutBuff)
                        {
                            this.characterAbsoluteStats.put(absolutBuff.getType(), this.characterAbsoluteStats.get(absolutBuff.getType())+absolutBuff.getValue());
                        }
                        else if (buff instanceof OverallRelativeBuff relativeBuff)
                        {
                            this.characterRelativeBuffs.put(relativeBuff.getType(), this.characterRelativeBuffs.get(relativeBuff.getType())+relativeBuff.getValue());
                        }
                    }
                }
            }
            else if (entry.getKey() instanceof RangerSets rangerSet)
            {
                for (int i=1; i<=usedItems; i++)
                {
                    for (OverallBuff buff : rangerSet.getSetBonus().getOrDefault(i, List.of()))
                    {
                        if (buff instanceof OverallAbsolutBuff absolutBuff)
                        {
                            this.characterAbsoluteStats.put(absolutBuff.getType(), this.characterAbsoluteStats.get(absolutBuff.getType())+absolutBuff.getValue());
                        }
                        else if (buff instanceof OverallRelativeBuff relativeBuff)
                        {
                            this.characterRelativeBuffs.put(relativeBuff.getType(), this.characterRelativeBuffs.get(relativeBuff.getType())+relativeBuff.getValue());
                        }
                    }
                }
            }
            else if (entry.getKey() instanceof SteamMechanicusSets steamMechanicusSet)
            {
                for (int i=1; i<=usedItems; i++)
                {
                    for (OverallBuff buff : steamMechanicusSet.getSetBonus().getOrDefault(i, List.of()))
                    {
                        if (buff instanceof OverallAbsolutBuff absolutBuff)
                        {
                            this.characterAbsoluteStats.put(absolutBuff.getType(), this.characterAbsoluteStats.get(absolutBuff.getType())+absolutBuff.getValue());
                        }
                        else if (buff instanceof OverallRelativeBuff relativeBuff)
                        {
                            this.characterRelativeBuffs.put(relativeBuff.getType(), this.characterRelativeBuffs.get(relativeBuff.getType())+relativeBuff.getValue());
                        }
                    }
                }
            }
        }

        //wisdom 1/2
        Map<StatType, Double> absoluteWisdomBuffs = this.wisdomSkillTree.getAbsoluteBuffs();

        //check for one hand or two hand jewel
        if (two_hand_weapon != null)
        {
            this.characterAbsoluteStats.put(StatType.DAMAGE, this.characterAbsoluteStats.get(StatType.DAMAGE) + absoluteWisdomBuffs.get(StatType.TWO_HAND_DAMAGE) + (this.two_hand_weapon.calculateTotalStats().get(StatType.DAMAGE) +
                    absoluteWisdomBuffs.get(StatType.TWO_HAND_DAMAGE)) *
                    this.characterRelativeBuffs.get(StatType.TWO_HAND_DAMAGE));
            this.characterAbsoluteStats.put(StatType.ATTACK_SPEED, this.characterAbsoluteStats.get(StatType.ATTACK_SPEED)+absoluteWisdomBuffs.get(StatType.TWO_HAND_ATTACK_SPEED));
            absoluteWisdomBuffs.remove(StatType.ONE_HAND_DAMAGE);
            absoluteWisdomBuffs.remove(StatType.ONE_HAND_ATTACK_SPEED);
            absoluteWisdomBuffs.remove(StatType.TWO_HAND_DAMAGE);
            absoluteWisdomBuffs.remove(StatType.TWO_HAND_ATTACK_SPEED);
        }
        else if (one_hand_weapon != null)
        {
            this.characterAbsoluteStats.put(StatType.DAMAGE, this.characterAbsoluteStats.get(StatType.DAMAGE) + absoluteWisdomBuffs.get(StatType.ONE_HAND_DAMAGE) + (this.one_hand_weapon.calculateTotalStats().get(StatType.DAMAGE) +
                    absoluteWisdomBuffs.get(StatType.ONE_HAND_DAMAGE)) *
                    this.characterRelativeBuffs.get(StatType.ONE_HAND_DAMAGE));
            this.characterAbsoluteStats.put(StatType.ATTACK_SPEED, this.characterAbsoluteStats.get(StatType.ATTACK_SPEED)+absoluteWisdomBuffs.get(StatType.ONE_HAND_ATTACK_SPEED));
            absoluteWisdomBuffs.remove(StatType.ONE_HAND_DAMAGE);
            absoluteWisdomBuffs.remove(StatType.ONE_HAND_ATTACK_SPEED);
            absoluteWisdomBuffs.remove(StatType.TWO_HAND_DAMAGE);
            absoluteWisdomBuffs.remove(StatType.TWO_HAND_ATTACK_SPEED);
        }

        //wisdom 2/2
        double allResistanceValue = absoluteWisdomBuffs.get(StatType.RESISTANCE_VALUE);
        absoluteWisdomBuffs.remove(StatType.RESISTANCE_VALUE);
        this.characterAbsoluteStats.put(StatType.FIRE_RESISTANCE, this.characterAbsoluteStats.get(StatType.FIRE_RESISTANCE)+allResistanceValue);
        this.characterAbsoluteStats.put(StatType.ICE_RESISTANCE, this.characterAbsoluteStats.get(StatType.ICE_RESISTANCE)+allResistanceValue);
        this.characterAbsoluteStats.put(StatType.LIGHTNING_RESISTANCE, this.characterAbsoluteStats.get(StatType.LIGHTNING_RESISTANCE)+allResistanceValue);
        this.characterAbsoluteStats.put(StatType.ANDERMAGIC_RESISTANCE, this.characterAbsoluteStats.get(StatType.ANDERMAGIC_RESISTANCE)+allResistanceValue);
        this.characterAbsoluteStats.put(StatType.POISON_RESISTANCE, this.characterAbsoluteStats.get(StatType.POISON_RESISTANCE)+allResistanceValue);
        for (Map.Entry<StatType, Double> entry : absoluteWisdomBuffs.entrySet())
        {
            this.characterAbsoluteStats.put(entry.getKey(), this.characterAbsoluteStats.get(entry.getKey())+entry.getValue());
        }
        for (Map.Entry<StatType, Double> entry : this.wisdomSkillTree.getRelativeBuffs().entrySet())
        {
            this.characterRelativeBuffs.put(entry.getKey(), this.characterRelativeBuffs.get(entry.getKey())+ entry.getValue());
        }

        //essence
        this.characterRelativeBuffs.put(StatType.DAMAGE, this.characterRelativeBuffs.get(StatType.DAMAGE)+this.essDmg);

        //pet, collector bag
        if (this.pet != null)
        {
            for (Map.Entry<StatType, Double> entry : this.pet.getStats().entrySet())
            {
                this.characterRelativeBuffs.put(entry.getKey(), this.characterRelativeBuffs.get(entry.getKey())+entry.getValue());
            }
            for (Map.Entry<StatType, Double> entry : this.collectorBagBuffs.entrySet())
            {
                this.characterRelativeBuffs.put(entry.getKey(), this.characterRelativeBuffs.get(entry.getKey())+entry.getValue());
            }
        }
        //buffs
        if (this.tonic != null)
        {
            this.characterAbsoluteStats.put(this.tonic.statType(), this.characterAbsoluteStats.get(this.tonic.statType())+this.tonic.value());
        }
        if (this.physic != null)
        {
            this.characterRelativeBuffs.put(this.physic.statType(), this.characterRelativeBuffs.get(this.physic.statType())+this.physic.value());
        }

        //TODO
        //bloodmage/war skill tree buffs
        if (this.characterClass == CharacterClass.SPELLWEAVER)
        {
            this.characterRelativeBuffs.put(StatType.DAMAGE, this.characterRelativeBuffs.get(StatType.DAMAGE)+0.5);
        }
        else if (this.characterClass == CharacterClass.DRAGONKNIGHT)
        {
            this.characterRelativeBuffs.put(StatType.ATTACK_SPEED, this.characterRelativeBuffs.get(StatType.ATTACK_SPEED)+0.5);
        }


        //calculate final stats (absolut*relative)
        this.characterRelativeBuffs.put(StatType.ANDERMAGIC_RESISTANCE, this.characterRelativeBuffs.get(StatType.ANDERMAGIC_RESISTANCE) + this.characterRelativeBuffs.get(StatType.RESISTANCE_VALUE));
        this.characterRelativeBuffs.put(StatType.FIRE_RESISTANCE, this.characterRelativeBuffs.get(StatType.FIRE_RESISTANCE) + this.characterRelativeBuffs.get(StatType.RESISTANCE_VALUE));
        this.characterRelativeBuffs.put(StatType.ICE_RESISTANCE, this.characterRelativeBuffs.get(StatType.ICE_RESISTANCE) + this.characterRelativeBuffs.get(StatType.RESISTANCE_VALUE));
        this.characterRelativeBuffs.put(StatType.LIGHTNING_RESISTANCE, this.characterRelativeBuffs.get(StatType.LIGHTNING_RESISTANCE) + this.characterRelativeBuffs.get(StatType.RESISTANCE_VALUE));
        this.characterRelativeBuffs.put(StatType.POISON_RESISTANCE, this.characterRelativeBuffs.get(StatType.POISON_RESISTANCE) + this.characterRelativeBuffs.get(StatType.RESISTANCE_VALUE));
        this.characterRelativeBuffs.remove(StatType.RESISTANCE_VALUE);
        for (Map.Entry<StatType, Double> entry : this.characterAbsoluteStats.entrySet())
        {
            this.characterFinalStats.put(entry.getKey(), entry.getValue()+entry.getValue()*this.characterRelativeBuffs.get(AbsoluteToRelativeStatTypeMapper.getRelativeType(entry.getKey())));
        }
    }




}
