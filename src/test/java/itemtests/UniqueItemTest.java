package itemtests;

import com.langleon.dsobuildsim.enchantments.Enchant;
import com.langleon.dsobuildsim.enchantments.UniqueEnchant;
import com.langleon.dsobuildsim.enums.*;
import com.langleon.dsobuildsim.gems.Gem;
import com.langleon.dsobuildsim.gems.Opal;
import com.langleon.dsobuildsim.items.actualitems.UniqueItem;
import com.langleon.dsobuildsim.overallbuffs.OverallBuff;
import com.langleon.dsobuildsim.overallbuffs.OverallRelativeBuff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniqueItemTest {
    public static void main(String[] args) {
        Map<AbsoluteStatType, Double> baseStats = new HashMap<>();
        baseStats.put(AbsoluteStatType.DAMAGE, 1463.431);
        baseStats.put(AbsoluteStatType.CRIT_VALUE, 1217.356);
        baseStats.put(AbsoluteStatType.MOVEMENT_SPEED, 1.172);
        Map<AbsoluteStatType, Double> uniqueBaseStats = new HashMap<>();
        uniqueBaseStats.put(AbsoluteStatType.ARMOR, 1337.0);
        List<UniqueEnchant> uniqueEnchants = new ArrayList<>();
        uniqueEnchants.add(new UniqueEnchant(EnchantType.MOVEMENT_SPEED, 0.25558));
        List< OverallBuff > overallBuffs = new ArrayList<>();
        overallBuffs.add(new OverallRelativeBuff(OverallRelativeBuffType.CRIT_VALUE, 0.1));

        UniqueItem setItem = new UniqueItem("Researcher's Boots", CharacterClass.SPELLWEAVER, ItemType.BOOTS, baseStats, uniqueBaseStats, uniqueEnchants, overallBuffs, 145);

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

        Enchant enchant1 = new Enchant(EnchantType.MOVEMENT_SPEED, 0.22442);
        Enchant enchant2 = new Enchant(EnchantType.MOVEMENT_SPEED, 0.22437);
        Enchant enchant3 = new Enchant(EnchantType.MOVEMENT_SPEED, 0.22439);
        Enchant enchant4 = new Enchant(EnchantType.MOVEMENT_SPEED, 0.22442);

        setItem.addEnchant(enchant1);
        setItem.addEnchant(enchant2);
        setItem.addEnchant(enchant3);
        setItem.addEnchant(enchant4);

        Map<AbsoluteStatType, Double> totalStats = setItem.calculateTotalStats();
        for (AbsoluteStatType entry : totalStats.keySet()){
            System.out.println(entry + " : " + totalStats.get(entry));
        }
    }
}
