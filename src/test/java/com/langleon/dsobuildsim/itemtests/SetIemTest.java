package com.langleon.dsobuildsim.itemtests;

public class SetIemTest {
    /*
    public static void main(String[] args) throws IOException {
        Map<StatType, Double> basestats = new HashMap<>();
        basestats.put(StatType.DAMAGE, 1644.883);
        basestats.put(StatType.CRIT_VALUE, 1401.911);
        basestats.put(StatType.HEALTH_POINTS, 20637.978);
        SetItem setItem = new SetItem("Helmet of the Black Knight", CharacterClass.SPELLWEAVER, ItemSlotType.HELMET, basestats, 145, SpellweaverSets.SET1);

        ObjectMapper objectMapper = new ObjectMapper();
        InputStream is = SetIemTest.class.getClassLoader().getResourceAsStream("data/gems.json");
        Reader reader = new InputStreamReader(is);
        GemFactory gemFactory = objectMapper.readValue(reader, GemFactory.class);
        Gem poison = gemFactory.createGem(GemType.POISON_DIAMOND, 17);
        setItem.setGem(poison);
        setItem.setGem(poison);
        setItem.setGem(poison);
        Gem dmg = gemFactory.createGem(GemType.RUBY, 17);
        setItem.setGem(dmg);
        setItem.setGem(dmg);
        setItem.setGem(dmg);
        setItem.setGem(dmg);
        setItem.setGem(dmg);
        setItem.setGem(dmg);
        Opal opal = gemFactory.createOpal(GemType.RUBY, GemType.ONYX, GemType.RHODOLITE, 17);
        setItem.setGem(opal);
        Enchant enchant = new Enchant(EnchantType.CRIT_VALUE, 0.25);
        setItem.setEnchant(enchant);
        setItem.setEnchant(enchant);
        setItem.setEnchant(enchant);
        setItem.setEnchant(enchant);

        Map<StatType, Double> totalStats = setItem.calculateTotalStats();
        for (StatType entry : totalStats.keySet()){
            System.out.println(entry + " : " + totalStats.get(entry));
        }
    }
     */
}
