package kaukasus;

import kaukasus.Character.Character;
import kaukasus.Enchants.Enchant;
import kaukasus.Enums.*;
import kaukasus.Gems.Gem;
import kaukasus.Gems.Opal;
import kaukasus.Items.SetItem;
import kaukasus.Sets.SetEnum;
import kaukasus.Sets.SpellweaverSets;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<AbsoluteStatTypeEnum, Double> basestats = new HashMap<>();
        basestats.put(AbsoluteStatTypeEnum.DAMAGE, 1644.883);
        basestats.put(AbsoluteStatTypeEnum.CRIT_VALUE, 1401.911);
        basestats.put(AbsoluteStatTypeEnum.HEALTH_POINTS, 20637.978);
        SetItem setItem = new SetItem("Helmet of the Black Knight", ItemTypeEnum.HELMET, basestats, 145, SpellweaverSets.SET1);

        Gem poison = new Gem(AbsoluteStatTypeEnum.POISON_RESISTANCE, 1337.0);
        setItem.addGem(poison);
        setItem.addGem(poison);
        setItem.addGem(poison);
        Gem dmg = new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0);
        setItem.addGem(dmg);
        setItem.addGem(dmg);
        setItem.addGem(dmg);
        setItem.addGem(dmg);
        setItem.addGem(dmg);
        setItem.addGem(dmg);
        Gem speed = new Gem(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.1);
        Gem hp = new Gem(AbsoluteStatTypeEnum.HEALTH_POINTS, 5500.0);
        Opal opal = new Opal(dmg,speed,hp);
        setItem.addGem(opal);

        Enchant enchant = new Enchant(EnchantTypeEnum.CRIT_VALUE, 0.25);
        setItem.addEnchant(enchant);
        setItem.addEnchant(enchant);
        setItem.addEnchant(enchant);
        setItem.addEnchant(enchant);

        Map<AbsoluteStatTypeEnum, Double> totalStats = setItem.calculateTotalStats();
        for (AbsoluteStatTypeEnum entry : totalStats.keySet()){
            System.out.println(entry + " : " + totalStats.get(entry));
        }

        System.out.println();

        Character mage = new Character(CharacterClassEnum.SPELLWEAVER);
        mage.addItem(setItem, ItemSlotEnum.HELMET);

        for (Map.Entry<AbsoluteStatTypeEnum, Double> entry : mage.getClassBaseStats().entrySet())
        {
            System.out.println(entry);
        }

        System.out.println();

        mage.calculateFinalStats();
        printStats(mage.getCharacterFinalStats());
    }

    public static void printStats(Map<AbsoluteStatTypeEnum, Double> stats)
    {
        System.out.println("Character:");
        System.out.println(AbsoluteStatTypeEnum.DAMAGE + ": " + stats.get(AbsoluteStatTypeEnum.DAMAGE));
        System.out.println(AbsoluteStatTypeEnum.ATTACK_SPEED + ": " + stats.get(AbsoluteStatTypeEnum.ATTACK_SPEED));
        System.out.println(AbsoluteStatTypeEnum.CRIT_VALUE + ": " + stats.get(AbsoluteStatTypeEnum.CRIT_VALUE));
        System.out.println(AbsoluteStatTypeEnum.MANA + ": " + stats.get(AbsoluteStatTypeEnum.MANA));
        System.out.println(AbsoluteStatTypeEnum.MANA_PER_SECOND + ": " + stats.get(AbsoluteStatTypeEnum.MANA_PER_SECOND));
        System.out.println(AbsoluteStatTypeEnum.MOVEMENT_SPEED + ": " + stats.get(AbsoluteStatTypeEnum.MOVEMENT_SPEED));
        System.out.println(AbsoluteStatTypeEnum.HEALTH_POINTS + ": " + stats.get(AbsoluteStatTypeEnum.HEALTH_POINTS));
        System.out.println(AbsoluteStatTypeEnum.HEALTH_PER_SECOND + ": " + stats.get(AbsoluteStatTypeEnum.HEALTH_PER_SECOND));
        System.out.println(AbsoluteStatTypeEnum.BLOCK_VALUE + ": " + stats.get(AbsoluteStatTypeEnum.BLOCK_VALUE));
        System.out.println(AbsoluteStatTypeEnum.ARMOR + ": " + stats.get(AbsoluteStatTypeEnum.ARMOR));
        System.out.println(AbsoluteStatTypeEnum.FIRE_RESISTANCE + ": " + stats.get(AbsoluteStatTypeEnum.FIRE_RESISTANCE));
        System.out.println(AbsoluteStatTypeEnum.ICE_RESISTANCE + ": " + stats.get(AbsoluteStatTypeEnum.ICE_RESISTANCE));
        System.out.println(AbsoluteStatTypeEnum.LIGHTNING_RESISTANCE + ": " + stats.get(AbsoluteStatTypeEnum.LIGHTNING_RESISTANCE));
        System.out.println(AbsoluteStatTypeEnum.ANDERMAGIC_RESISTANCE + ": " + stats.get(AbsoluteStatTypeEnum.ANDERMAGIC_RESISTANCE));
        System.out.println(AbsoluteStatTypeEnum.POISON_RESISTANCE + ": " + stats.get(AbsoluteStatTypeEnum.POISON_RESISTANCE));
    }
}