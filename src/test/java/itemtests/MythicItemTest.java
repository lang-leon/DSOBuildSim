package itemtests;

import com.langleon.dsobuildsim.enchantments.Enchant;
import com.langleon.dsobuildsim.enchantments.UniqueEnchant;
import com.langleon.dsobuildsim.enums.*;
import com.langleon.dsobuildsim.gems.Gem;
import com.langleon.dsobuildsim.items.actualitems.MythicItem;
import com.langleon.dsobuildsim.overallbuffs.OverallAbsolutBuff;
import com.langleon.dsobuildsim.overallbuffs.OverallBuff;
import com.langleon.dsobuildsim.overallbuffs.OverallRelativeBuff;
import com.langleon.dsobuildsim.sets.SpellweaverSets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MythicItemTest {
    public static void main(String[] args) {
        Map<AbsoluteStatType, Double> baseStats = new HashMap<>();
        baseStats.put(AbsoluteStatType.DAMAGE, 1891.513);
        baseStats.put(AbsoluteStatType.ATTACK_SPEED, 0.06);
        baseStats.put(AbsoluteStatType.HEALTH_POINTS, 16507.200);
        Map<AbsoluteStatType, Double> uniqueBaseStats = new HashMap<>();
        List<UniqueEnchant> uniqueEnchants = new ArrayList<>();
        List<OverallBuff> overallBuffs = new ArrayList<>();
        overallBuffs.add(new OverallRelativeBuff(OverallRelativeBuffType.DAMAGE, 0.1));
        overallBuffs.add(new OverallAbsolutBuff(AbsoluteStatType.DAMAGE, 5000.0));

        MythicItem mythicItem = new MythicItem("Ancestral Glory Cloak (Mage)", CharacterClass.SPELLWEAVER, ItemType.CLOAK, baseStats, uniqueBaseStats, uniqueEnchants, overallBuffs, 145, SpellweaverSets.SET1);

        Gem dmg = new Gem(AbsoluteStatType.DAMAGE, 700.0);
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

        Map<AbsoluteStatType, Double> totalStats = mythicItem.calculateTotalStats();
        for (AbsoluteStatType entry : totalStats.keySet()){
            System.out.println(entry + " : " + totalStats.get(entry));
        }
    }
}
