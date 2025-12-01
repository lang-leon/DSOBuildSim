package com.langleon.dsobuildsim.sets;

import com.langleon.dsobuildsim.items.itemdatabase.Item;
import com.langleon.dsobuildsim.items.itemdatabase.mythicitems.RangerMythicItem;
import com.langleon.dsobuildsim.overallbuffs.OverallBuff;
import com.langleon.dsobuildsim.overallbuffs.OverallDescriptionBuff;

import java.util.List;
import java.util.Map;

public enum RangerSets implements SetEnumInterface {

    FORGOTTON_GLORY("Forgotton Glory", Map.of(2, List.of(new OverallDescriptionBuff("..."))), 145),
    ANCESTRAL_GLORY("Forgotton Glory", Map.of(2, List.of(new OverallDescriptionBuff("..."))), 145);

    private final String name;
    private Map<Integer, List<OverallBuff>> setBonus;
    private List<Item> setItems;
    private int level;

    RangerSets(String name, Map<Integer, List<OverallBuff>> setBonus, int level)
    {
        this.name = name;
        this.setBonus = setBonus;
        this.level = level;
    }

    public String getName() {
        return this.name;
    }

    public Map<Integer, List<OverallBuff>> getSetBonus() {
        return this.setBonus;
    }

    public List<Item> getSetItems() {
        return this.setItems;
    }

    public int getLevel() {
        return level;
    }

    static
    {
        FORGOTTON_GLORY.setItems = List.of(RangerMythicItem.OLD_GLORY, RangerMythicItem.RING_OF_OLD_GLORY);
        ANCESTRAL_GLORY.setItems = List.of(RangerMythicItem.RING_OF_ANCESTRAL_GLORY, RangerMythicItem.ANCESTRAL_GLORY_CLOAK);
    }
}
