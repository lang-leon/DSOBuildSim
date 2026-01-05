package com.langleon.dsobuildsim.itemtests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.langleon.dsobuildsim.enchantments.Enchant;
import com.langleon.dsobuildsim.enchantments.UniqueEnchant;
import com.langleon.dsobuildsim.enums.*;
import com.langleon.dsobuildsim.enums.gems.GemType;
import com.langleon.dsobuildsim.gems.Gem;
import com.langleon.dsobuildsim.gems.GemFactory;
import com.langleon.dsobuildsim.items.mythicitems.MythicItem;
import com.langleon.dsobuildsim.overallbuffs.OverallAbsolutBuff;
import com.langleon.dsobuildsim.overallbuffs.OverallBuff;
import com.langleon.dsobuildsim.overallbuffs.OverallRelativeBuff;
import com.langleon.dsobuildsim.sets.SpellweaverSets;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MythicItemTest {
    public static void main(String[] args) throws IOException {
        Map<StatType, Double> baseStats = new HashMap<>();
        baseStats.put(StatType.DAMAGE, 1891.513);
        baseStats.put(StatType.ATTACK_SPEED, 0.06);
        baseStats.put(StatType.HEALTH_POINTS, 16507.200);
        Map<StatType, Double> uniqueBaseStats = new HashMap<>();
        List<UniqueEnchant> uniqueEnchants = new ArrayList<>();
        List<OverallBuff> overallBuffs = new ArrayList<>();
        overallBuffs.add(new OverallRelativeBuff(StatType.DAMAGE, 0.1));
        overallBuffs.add(new OverallAbsolutBuff(StatType.DAMAGE, 5000.0));

        MythicItem mythicItem = new MythicItem("Ancestral Glory Cloak (Mage)", CharacterClass.SPELLWEAVER, ItemSlotType.CLOAK, baseStats, uniqueBaseStats, uniqueEnchants, overallBuffs, 145, SpellweaverSets.SET1);

        ObjectMapper objectMapper = new ObjectMapper();
        InputStream is = MythicItemTest.class.getClassLoader().getResourceAsStream("data/gems.json");
        Reader reader = new InputStreamReader(is);
        GemFactory gemFactory = objectMapper.readValue(reader, GemFactory.class);
        Gem dmg = gemFactory.createGem(GemType.RUBY, 17);
        mythicItem.addGem(dmg);
        mythicItem.addGem(dmg);
        mythicItem.addGem(dmg);
        mythicItem.addGem(dmg);
        mythicItem.addGem(dmg);
        mythicItem.addGem(dmg);
        mythicItem.addGem(dmg);
        mythicItem.addGem(dmg);
        mythicItem.addGem(dmg);
        mythicItem.addGem(dmg);

        Enchant enchant = new Enchant(EnchantType.DAMAGE, 0.44776);

        mythicItem.addEnchant(enchant);
        mythicItem.addEnchant(enchant);
        mythicItem.addEnchant(enchant);
        mythicItem.addEnchant(enchant);

        Map<StatType, Double> totalStats = mythicItem.calculateTotalStats();
        for (StatType entry : totalStats.keySet()){
            System.out.println(entry + " : " + totalStats.get(entry));
        }
    }
}
