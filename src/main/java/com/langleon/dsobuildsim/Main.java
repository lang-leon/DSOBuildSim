package com.langleon.dsobuildsim;

import com.langleon.dsobuildsim.character.Character;
import com.langleon.dsobuildsim.enchantments.Enchant;
import com.langleon.dsobuildsim.enums.*;
import com.langleon.dsobuildsim.gems.Gem;
import com.langleon.dsobuildsim.gems.Opal;
import com.langleon.dsobuildsim.items.actualitems.SetItem;
import com.langleon.dsobuildsim.sets.SpellweaverSets;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        test();
    }

    public static void test()
    {
        Map<AbsoluteStatType, Double> basestats = new HashMap<>();
        basestats.put(AbsoluteStatType.DAMAGE, 1644.883);
        basestats.put(AbsoluteStatType.CRIT_VALUE, 1401.911);
        basestats.put(AbsoluteStatType.HEALTH_POINTS, 20637.978);
        SetItem setItem = new SetItem("Helmet of the Black Knight", CharacterClass.SPELLWEAVER, ItemType.HELMET, basestats, 145, SpellweaverSets.SET1);

        Gem poison = new Gem(AbsoluteStatType.POISON_RESISTANCE, 1337.0);
        setItem.addGem(poison);
        setItem.addGem(poison);
        setItem.addGem(poison);
        Gem dmg = new Gem(AbsoluteStatType.DAMAGE, 700.0);
        setItem.addGem(dmg);
        setItem.addGem(dmg);
        setItem.addGem(dmg);
        setItem.addGem(dmg);
        setItem.addGem(dmg);
        setItem.addGem(dmg);
        Gem speed = new Gem(AbsoluteStatType.ATTACK_SPEED, 0.1);
        Gem hp = new Gem(AbsoluteStatType.HEALTH_POINTS, 5500.0);
        Opal opal = new Opal(dmg,speed,hp);
        setItem.addGem(opal);

        Enchant enchant = new Enchant(EnchantType.CRIT_VALUE, 0.25);
        setItem.addEnchant(enchant);
        setItem.addEnchant(enchant);
        setItem.addEnchant(enchant);
        setItem.addEnchant(enchant);

        Map<AbsoluteStatType, Double> totalStats = setItem.calculateTotalStats();
        for (AbsoluteStatType entry : totalStats.keySet()){
            System.out.println(entry + " : " + totalStats.get(entry));
        }

        System.out.println();

        Character mage = new Character(CharacterClass.SPELLWEAVER);
        mage.addItem(setItem, ItemSlot.HELMET);

        for (Map.Entry<AbsoluteStatType, Double> entry : mage.getClassBaseStats().entrySet())
        {
            System.out.println(entry);
        }

        System.out.println();

        mage.calculateFinalStats();
        printStats(mage.getCharacterFinalStats());
    }

    public static void printStats(Map<AbsoluteStatType, Double> stats)
    {
        System.out.println("Character:");
        System.out.println(AbsoluteStatType.DAMAGE + ": " + stats.get(AbsoluteStatType.DAMAGE));
        System.out.println(AbsoluteStatType.ATTACK_SPEED + ": " + stats.get(AbsoluteStatType.ATTACK_SPEED));
        System.out.println(AbsoluteStatType.CRIT_VALUE + ": " + stats.get(AbsoluteStatType.CRIT_VALUE));
        System.out.println(AbsoluteStatType.MANA + ": " + stats.get(AbsoluteStatType.MANA));
        System.out.println(AbsoluteStatType.MANA_PER_SECOND + ": " + stats.get(AbsoluteStatType.MANA_PER_SECOND));
        System.out.println(AbsoluteStatType.MOVEMENT_SPEED + ": " + stats.get(AbsoluteStatType.MOVEMENT_SPEED));
        System.out.println(AbsoluteStatType.HEALTH_POINTS + ": " + stats.get(AbsoluteStatType.HEALTH_POINTS));
        System.out.println(AbsoluteStatType.HEALTH_PER_SECOND + ": " + stats.get(AbsoluteStatType.HEALTH_PER_SECOND));
        System.out.println(AbsoluteStatType.BLOCK_VALUE + ": " + stats.get(AbsoluteStatType.BLOCK_VALUE));
        System.out.println(AbsoluteStatType.ARMOR + ": " + stats.get(AbsoluteStatType.ARMOR));
        System.out.println(AbsoluteStatType.FIRE_RESISTANCE + ": " + stats.get(AbsoluteStatType.FIRE_RESISTANCE));
        System.out.println(AbsoluteStatType.ICE_RESISTANCE + ": " + stats.get(AbsoluteStatType.ICE_RESISTANCE));
        System.out.println(AbsoluteStatType.LIGHTNING_RESISTANCE + ": " + stats.get(AbsoluteStatType.LIGHTNING_RESISTANCE));
        System.out.println(AbsoluteStatType.ANDERMAGIC_RESISTANCE + ": " + stats.get(AbsoluteStatType.ANDERMAGIC_RESISTANCE));
        System.out.println(AbsoluteStatType.POISON_RESISTANCE + ": " + stats.get(AbsoluteStatType.POISON_RESISTANCE));
    }
}