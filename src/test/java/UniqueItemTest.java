import kaukasus.Enchants.Enchant;
import kaukasus.Enchants.UniqueEnchant;
import kaukasus.Enums.AbsoluteStatTypeEnum;
import kaukasus.Enums.EnchantTypeEnum;
import kaukasus.Enums.OverallBuffTypeEnum;
import kaukasus.Gems.Gem;
import kaukasus.Gems.Opal;
import kaukasus.Items.UniqueItem;
import kaukasus.OverallBuffs.OverallBuff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniqueItemTest {
    public static void main(String[] args) {
        Map<AbsoluteStatTypeEnum, Double> basestats = new HashMap<>();
        basestats.put(AbsoluteStatTypeEnum.DAMAGE, 1463.431);
        basestats.put(AbsoluteStatTypeEnum.CRIT_VALUE, 1217.356);
        basestats.put(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 1.172);
        Map<AbsoluteStatTypeEnum, Double> uniqueBaseStats = new HashMap<>();
        uniqueBaseStats.put(AbsoluteStatTypeEnum.ARMOR, 1337.0);
        List<UniqueEnchant> uniqueEnchants = new ArrayList<>();
        uniqueEnchants.add(new UniqueEnchant(EnchantTypeEnum.MOVEMENT_SPEED, 0.25558));
        List< OverallBuff > overallBuffs = new ArrayList<>();
        overallBuffs.add(new OverallBuff(OverallBuffTypeEnum.CRIT_VALUE, 0.1));

        UniqueItem setItem = new UniqueItem("Researcher's Boots", basestats, uniqueBaseStats, uniqueEnchants, overallBuffs);

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

        Enchant enchant1 = new Enchant(EnchantTypeEnum.MOVEMENT_SPEED, 0.22442);
        Enchant enchant2 = new Enchant(EnchantTypeEnum.MOVEMENT_SPEED, 0.22437);
        Enchant enchant3 = new Enchant(EnchantTypeEnum.MOVEMENT_SPEED, 0.22439);
        Enchant enchant4 = new Enchant(EnchantTypeEnum.MOVEMENT_SPEED, 0.22442);

        setItem.addEnchant(enchant1);
        setItem.addEnchant(enchant2);
        setItem.addEnchant(enchant3);
        setItem.addEnchant(enchant4);

        Map<AbsoluteStatTypeEnum, Double> totalStats = setItem.calculateTotalStats();
        for (AbsoluteStatTypeEnum entry : totalStats.keySet()){
            System.out.println(entry + " : " + totalStats.get(entry));
        }
    }
}
