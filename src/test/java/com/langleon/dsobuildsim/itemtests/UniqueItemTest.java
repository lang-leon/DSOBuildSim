package com.langleon.dsobuildsim.itemtests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.langleon.dsobuildsim.enchantments.Enchant;
import com.langleon.dsobuildsim.enchantments.UniqueEnchant;
import com.langleon.dsobuildsim.enums.*;
import com.langleon.dsobuildsim.enums.gems.GemType;
import com.langleon.dsobuildsim.gems.*;
import com.langleon.dsobuildsim.items.uniqueitems.UniqueItem;
import com.langleon.dsobuildsim.overallbuffs.OverallBuff;
import com.langleon.dsobuildsim.overallbuffs.OverallRelativeBuff;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniqueItemTest {
    public static void main(String[] args) throws IOException {
        Map<StatType, Double> baseStats = new HashMap<>();
        baseStats.put(StatType.DAMAGE, 1463.431);
        baseStats.put(StatType.CRIT_VALUE, 1217.356);
        baseStats.put(StatType.MOVEMENT_SPEED, 1.172);
        Map<StatType, Double> uniqueBaseStats = new HashMap<>();
        uniqueBaseStats.put(StatType.ARMOR_VALUE, 1337.0);
        List<UniqueEnchant> uniqueEnchants = new ArrayList<>();
        uniqueEnchants.add(new UniqueEnchant(EnchantType.MOVEMENT_SPEED, 0.25558));
        List< OverallBuff > overallBuffs = new ArrayList<>();
        overallBuffs.add(new OverallRelativeBuff(StatType.CRIT_VALUE, 0.1));

        UniqueItem uniqueItem = new UniqueItem("Researcher's Boots", CharacterClass.SPELLWEAVER, ItemSlotType.BOOTS, baseStats, uniqueBaseStats, uniqueEnchants, overallBuffs, 145);

        ObjectMapper objectMapper = new ObjectMapper();
        InputStream is = UniqueItemTest.class.getClassLoader().getResourceAsStream("data/gems.json");
        Reader reader = new InputStreamReader(is);
        GemFactory gemFactory = objectMapper.readValue(reader, GemFactory.class);
        Gem poison = gemFactory.createGem(GemType.POISON_DIAMOND, 17);
        uniqueItem.addGem(poison);
        uniqueItem.addGem(poison);
        uniqueItem.addGem(poison);
        Gem dmg = gemFactory.createGem(GemType.RUBY, 17);
        uniqueItem.addGem(dmg);
        uniqueItem.addGem(dmg);
        uniqueItem.addGem(dmg);
        uniqueItem.addGem(dmg);
        uniqueItem.addGem(dmg);
        uniqueItem.addGem(dmg);
        Opal opal = gemFactory.createOpal(GemType.RUBY, GemType.ONYX, GemType.RHODOLITE, 17);
        uniqueItem.addGem(opal);

        Enchant enchant1 = new Enchant(EnchantType.MOVEMENT_SPEED, 0.22442);
        Enchant enchant2 = new Enchant(EnchantType.MOVEMENT_SPEED, 0.22437);
        Enchant enchant3 = new Enchant(EnchantType.MOVEMENT_SPEED, 0.22439);
        Enchant enchant4 = new Enchant(EnchantType.MOVEMENT_SPEED, 0.22442);

        uniqueItem.addEnchant(enchant1);
        uniqueItem.addEnchant(enchant2);
        uniqueItem.addEnchant(enchant3);
        uniqueItem.addEnchant(enchant4);

        Map<StatType, Double> totalStats = uniqueItem.calculateTotalStats();
        for (StatType entry : totalStats.keySet()){
            System.out.println(entry + " : " + totalStats.get(entry));
        }
    }
}
