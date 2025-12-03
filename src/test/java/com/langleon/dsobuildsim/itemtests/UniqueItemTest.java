package com.langleon.dsobuildsim.itemtests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.langleon.dsobuildsim.enchantments.Enchant;
import com.langleon.dsobuildsim.enchantments.UniqueEnchant;
import com.langleon.dsobuildsim.enums.*;
import com.langleon.dsobuildsim.gems.*;
import com.langleon.dsobuildsim.items.actualitems.UniqueItem;
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
        Map<AbsoluteStatType, Double> baseStats = new HashMap<>();
        baseStats.put(AbsoluteStatType.DAMAGE, 1463.431);
        baseStats.put(AbsoluteStatType.CRIT_VALUE, 1217.356);
        baseStats.put(AbsoluteStatType.MOVEMENT_SPEED, 1.172);
        Map<AbsoluteStatType, Double> uniqueBaseStats = new HashMap<>();
        uniqueBaseStats.put(AbsoluteStatType.ARMOR_VALUE, 1337.0);
        List<UniqueEnchant> uniqueEnchants = new ArrayList<>();
        uniqueEnchants.add(new UniqueEnchant(EnchantType.MOVEMENT_SPEED, 0.25558));
        List< OverallBuff > overallBuffs = new ArrayList<>();
        overallBuffs.add(new OverallRelativeBuff(OverallRelativeBuffType.CRIT_VALUE, 0.1));

        UniqueItem uniqueItem = new UniqueItem("Researcher's Boots", CharacterClass.SPELLWEAVER, ItemType.BOOTS, baseStats, uniqueBaseStats, uniqueEnchants, overallBuffs, 145);

        ObjectMapper objectMapper = new ObjectMapper();
        InputStream is = GemTests.class.getClassLoader().getResourceAsStream("data/gems.json");
        Reader reader = new InputStreamReader(is);
        GemData gemData = objectMapper.readValue(reader, GemData.class);
        Gem poison = gemData.createGem(GemType.POISON_DIAMOND, 17);
        uniqueItem.addGem(poison);
        uniqueItem.addGem(poison);
        uniqueItem.addGem(poison);
        Gem dmg = gemData.createGem(GemType.RUBY, 17);
        uniqueItem.addGem(dmg);
        uniqueItem.addGem(dmg);
        uniqueItem.addGem(dmg);
        uniqueItem.addGem(dmg);
        uniqueItem.addGem(dmg);
        uniqueItem.addGem(dmg);
        Opal opal = gemData.createOpal(GemType.RUBY, GemType.ONYX, GemType.RHODOLITE, 17);
        uniqueItem.addGem(opal);

        Enchant enchant1 = new Enchant(EnchantType.MOVEMENT_SPEED, 0.22442);
        Enchant enchant2 = new Enchant(EnchantType.MOVEMENT_SPEED, 0.22437);
        Enchant enchant3 = new Enchant(EnchantType.MOVEMENT_SPEED, 0.22439);
        Enchant enchant4 = new Enchant(EnchantType.MOVEMENT_SPEED, 0.22442);

        uniqueItem.addEnchant(enchant1);
        uniqueItem.addEnchant(enchant2);
        uniqueItem.addEnchant(enchant3);
        uniqueItem.addEnchant(enchant4);

        Map<AbsoluteStatType, Double> totalStats = uniqueItem.calculateTotalStats();
        for (AbsoluteStatType entry : totalStats.keySet()){
            System.out.println(entry + " : " + totalStats.get(entry));
        }
    }
}
