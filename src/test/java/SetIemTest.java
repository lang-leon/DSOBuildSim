import kaukasus.Enchants.Enchant;
import kaukasus.Enums.AbsoluteStatTypeEnum;
import kaukasus.Enums.EnchantTypeEnum;
import kaukasus.Enums.ItemTypeEnum;
import kaukasus.Sets.SetEnum;
import kaukasus.Gems.Gem;
import kaukasus.Gems.Opal;
import kaukasus.Items.SetItem;
import kaukasus.Sets.SpellweaverSets;

import java.util.HashMap;
import java.util.Map;

public class SetIemTest {
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
    }
}
