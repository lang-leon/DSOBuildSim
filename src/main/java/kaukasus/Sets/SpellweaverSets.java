package kaukasus.Sets;

import kaukasus.Items.ItemDatabase.Item;
import kaukasus.Items.ItemDatabase.MythicItems.SpellweaverMythicItem;
import kaukasus.OverallBuffs.OverallBuff;
import kaukasus.OverallBuffs.OverallDescriptionBuff;

import java.util.List;
import java.util.Map;

public enum SpellweaverSets implements SetEnumInterface {

    SET1("Forgotton Glory", Map.of()),
    FORGOTTON_GLORY("Forgotton Glory", Map.of(2, new OverallDescriptionBuff("..."))),
    ANCESTRAL_GLORY("Forgotton Glory", Map.of(2, new OverallDescriptionBuff("...")));

    private final String name;
    private final Map<Integer, OverallBuff> setBonus;
    private List<Item> setItems;

    SpellweaverSets(String name, Map<Integer, OverallBuff> setBonus)
    {
        this.name = name;
        this.setBonus = setBonus;
    }

    public String getName() {
        return name;
    }

    public Map<Integer, OverallBuff> getSetBonus() {
        return setBonus;
    }

    public List<Item> getSetItems() {
        return setItems;
    }

    static
    {
        FORGOTTON_GLORY.setItems = List.of(SpellweaverMythicItem.OLD_GLORY, SpellweaverMythicItem.RING_OF_OLD_GLORY);
        ANCESTRAL_GLORY.setItems = List.of(SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY, SpellweaverMythicItem.ANCESTRAL_GLORY_CLOAK);
    }

}
