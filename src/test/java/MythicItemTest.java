import kaukasus.Enchants.Enchant;
import kaukasus.Enchants.UniqueEnchant;
import kaukasus.Enums.*;
import kaukasus.Gems.Gem;
import kaukasus.Items.MythicItems.MythicItem;
import kaukasus.OverallBuffs.OverallAbsolutBuff;
import kaukasus.OverallBuffs.OverallBuff;
import kaukasus.OverallBuffs.OverallRelativeBuff;
import kaukasus.Sets.SetEnum;
import kaukasus.Sets.SpellweaverSets;

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

        MythicItem mythicItem = new MythicItem("Ancestral Glory Cloak (Mage)", ItemTypeEnum.CLOAK, baseStats, uniqueBaseStats, uniqueEnchants, overallBuffs, SpellweaverSets.SET1);

        Gem dmg = new Gem(AbsoluteStatTypeEnum.DAMAGE, 700.0);
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

        Enchant enchant = new Enchant(EnchantTypeEnum.DAMAGE, 0.44776);

        mythicItem.addEnchant(enchant);
        mythicItem.addEnchant(enchant);
        mythicItem.addEnchant(enchant);
        mythicItem.addEnchant(enchant);

        Map<AbsoluteStatTypeEnum, Double> totalStats = mythicItem.calculateTotalStats();
        for (AbsoluteStatTypeEnum entry : totalStats.keySet()){
            System.out.println(entry + " : " + totalStats.get(entry));
        }
    }
}
