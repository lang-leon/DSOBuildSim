import kaukasus.Enchants.Enchant;
import kaukasus.Enchants.UniqueEnchant;
import kaukasus.Enums.*;
import kaukasus.Gems.Gem;
import kaukasus.Items.MythicItem;
import kaukasus.OverallBuffs.OverallAbsolutBuff;
import kaukasus.OverallBuffs.OverallBuff;
import kaukasus.OverallBuffs.OverallRelativeBuff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MythicItemTest {
    public static void main(String[] args) {
        Map<AbsoluteStatTypeEnum, Double> baseStats = new HashMap<>();
        baseStats.put(AbsoluteStatTypeEnum.DAMAGE, 1891.513);
        baseStats.put(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.06);
        baseStats.put(AbsoluteStatTypeEnum.HEALTH_POINTS, 16507.200);
        Map<AbsoluteStatTypeEnum, Double> uniqueBaseStats = new HashMap<>();
        List<UniqueEnchant> uniqueEnchants = new ArrayList<>();
        List<OverallBuff> overallBuffs = new ArrayList<>();
        overallBuffs.add(new OverallRelativeBuff(OverallRelativeBuffTypeEnum.DAMAGE, 0.1));
        overallBuffs.add(new OverallAbsolutBuff(AbsoluteStatTypeEnum.DAMAGE, 5000.0));

        MythicItem setItem = new MythicItem("Ancestral Glory Cloak (Mage)", ItemTypeEnum.CLOAK, baseStats, uniqueBaseStats, uniqueEnchants, overallBuffs, SetTypeEnum.SET1);

        Gem dmg = new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0);
        setItem.addGem(dmg);
        setItem.addGem(dmg);
        setItem.addGem(dmg);
        setItem.addGem(dmg);
        setItem.addGem(dmg);
        setItem.addGem(dmg);
        setItem.addGem(dmg);
        setItem.addGem(dmg);
        setItem.addGem(dmg);
        setItem.addGem(dmg);

        Enchant enchant = new Enchant(EnchantTypeEnum.DAMAGE, 0.44776);

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
