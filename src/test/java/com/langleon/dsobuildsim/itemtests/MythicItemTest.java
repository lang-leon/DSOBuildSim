package com.langleon.dsobuildsim.itemtests;

public class MythicItemTest {
    /*
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
        mythicItem.setGem(dmg);
        mythicItem.setGem(dmg);
        mythicItem.setGem(dmg);
        mythicItem.setGem(dmg);
        mythicItem.setGem(dmg);
        mythicItem.setGem(dmg);
        mythicItem.setGem(dmg);
        mythicItem.setGem(dmg);
        mythicItem.setGem(dmg);
        mythicItem.setGem(dmg);

        Enchant enchant = new Enchant(EnchantType.DAMAGE, 0.44776);

        mythicItem.setEnchant(enchant);
        mythicItem.setEnchant(enchant);
        mythicItem.setEnchant(enchant);
        mythicItem.setEnchant(enchant);

        Map<StatType, Double> totalStats = mythicItem.calculateTotalStats();
        for (StatType entry : totalStats.keySet()){
            System.out.println(entry + " : " + totalStats.get(entry));
        }
    }
     */
}
