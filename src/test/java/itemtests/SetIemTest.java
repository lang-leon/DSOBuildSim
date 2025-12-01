package itemtests;

import com.langleon.dsobuildsim.enchantments.Enchant;
import com.langleon.dsobuildsim.enums.AbsoluteStatType;
import com.langleon.dsobuildsim.enums.CharacterClass;
import com.langleon.dsobuildsim.enums.EnchantType;
import com.langleon.dsobuildsim.enums.ItemType;
import com.langleon.dsobuildsim.gems.Gem;
import com.langleon.dsobuildsim.gems.Opal;
import com.langleon.dsobuildsim.items.actualitems.SetItem;
import com.langleon.dsobuildsim.sets.SpellweaverSets;

import java.util.HashMap;
import java.util.Map;

public class SetIemTest {
    public static void main(String[] args) {
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
    }
}
