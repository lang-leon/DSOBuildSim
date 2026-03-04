package com.langleon.dsobuildsim.items.setitems;

import com.langleon.dsobuildsim.enums.ItemSlotType;
import com.langleon.dsobuildsim.enums.StatType;
import com.langleon.dsobuildsim.enums.items.SetItemType;
import com.langleon.dsobuildsim.enums.items.SetType;

import java.util.Map;

public record SetItemDefinition (SetItemType itemType, String name, int defaultLevel, int tier, ItemSlotType itemSlotType, Map<StatType, Double> baseValues, SetType set){
}