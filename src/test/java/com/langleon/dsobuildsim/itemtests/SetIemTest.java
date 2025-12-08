package com.langleon.dsobuildsim.itemtests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.langleon.dsobuildsim.enchantments.Enchant;
import com.langleon.dsobuildsim.enums.*;
import com.langleon.dsobuildsim.enums.gems.GemType;
import com.langleon.dsobuildsim.gems.Gem;
import com.langleon.dsobuildsim.gems.GemFactory;
import com.langleon.dsobuildsim.gems.Opal;
import com.langleon.dsobuildsim.items.actualitems.SetItem;
import com.langleon.dsobuildsim.sets.SpellweaverSets;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public class SetIemTest {
    public static void main(String[] args) throws IOException {
        Map<AbsoluteStatType, Double> basestats = new HashMap<>();
        basestats.put(AbsoluteStatType.DAMAGE, 1644.883);
        basestats.put(AbsoluteStatType.CRIT_VALUE, 1401.911);
        basestats.put(AbsoluteStatType.HEALTH_POINTS, 20637.978);
        SetItem setItem = new SetItem("Helmet of the Black Knight", CharacterClass.SPELLWEAVER, ItemType.HELMET, basestats, 145, SpellweaverSets.SET1);

        ObjectMapper objectMapper = new ObjectMapper();
        InputStream is = SetIemTest.class.getClassLoader().getResourceAsStream("data/gems.json");
        Reader reader = new InputStreamReader(is);
        GemFactory gemFactory = objectMapper.readValue(reader, GemFactory.class);
        Gem poison = gemFactory.createGem(GemType.POISON_DIAMOND, 17);
        setItem.addGem(poison);
        setItem.addGem(poison);
        setItem.addGem(poison);
        Gem dmg = gemFactory.createGem(GemType.RUBY, 17);
        setItem.addGem(dmg);
        setItem.addGem(dmg);
        setItem.addGem(dmg);
        setItem.addGem(dmg);
        setItem.addGem(dmg);
        setItem.addGem(dmg);
        Opal opal = gemFactory.createOpal(GemType.RUBY, GemType.ONYX, GemType.RHODOLITE, 17);
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
    }
}
