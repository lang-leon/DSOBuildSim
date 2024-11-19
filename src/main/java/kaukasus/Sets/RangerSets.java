package kaukasus.Sets;

import kaukasus.Items.Item;
import kaukasus.Items.MythicItems.RangerMythicItem;
import kaukasus.OverallBuffs.OverallBuff;
import kaukasus.OverallBuffs.OverallDescriptionBuff;

import java.util.List;
import java.util.Map;

public enum RangerSets implements SetEnum{

    FORGOTTON_GLORY("Forgotton Glory", Map.of(2, new OverallDescriptionBuff("..."))),
    ANCESTRAL_GLORY("Forgotton Glory", Map.of(2, new OverallDescriptionBuff("...")));

    private final String name;
    private final Map<Integer, OverallBuff> setBonus;
    private List<Item> setItems;

    RangerSets(String name, Map<Integer, OverallBuff> setBonus)
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
        FORGOTTON_GLORY.setItems = List.of(RangerMythicItem.OLD_GLORY, RangerMythicItem.RING_OF_OLD_GLORY);
        ANCESTRAL_GLORY.setItems = List.of(RangerMythicItem.RING_OF_ANCESTRAL_GLORY, RangerMythicItem.ANCESTRAL_GLORY_CLOAK);
    }
}
