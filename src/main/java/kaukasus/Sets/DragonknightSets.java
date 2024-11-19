package kaukasus.Sets;

import kaukasus.Items.ItemDatabase.Item;
import kaukasus.Items.ItemDatabase.MythicItems.DragonknightMythicItem;
import kaukasus.OverallBuffs.OverallBuff;
import kaukasus.OverallBuffs.OverallDescriptionBuff;

import java.util.List;
import java.util.Map;

public enum DragonknightSets implements SetEnumInterface {

    FORGOTTON_GLORY("Forgotton Glory", Map.of(2, new OverallDescriptionBuff("..."))),
    ANCESTRAL_GLORY("Forgotton Glory", Map.of(2, new OverallDescriptionBuff("...")));

    private final String name;
    private final Map<Integer, OverallBuff> setBonus;
    private List<Item> setItems;

    DragonknightSets(String name, Map<Integer, OverallBuff> setBonus)
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
        FORGOTTON_GLORY.setItems = List.of(DragonknightMythicItem.OLD_GLORY, DragonknightMythicItem.RING_OF_OLD_GLORY);
        ANCESTRAL_GLORY.setItems = List.of(DragonknightMythicItem.RING_OF_ANCESTRAL_GLORY, DragonknightMythicItem.ANCESTRAL_GLORY_CLOAK);
    }
}
