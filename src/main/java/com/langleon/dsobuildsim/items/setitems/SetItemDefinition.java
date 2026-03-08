package com.langleon.dsobuildsim.items.setitems;

import com.langleon.dsobuildsim.items.core.enums.ItemSlotType;
import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.sets.SetType;
import com.langleon.dsobuildsim.items.core.ItemDefinition;

import java.util.EnumMap;

public record SetItemDefinition (SetItemType itemType, String name, int defaultLevel, int tier, ItemSlotType itemSlotType, EnumMap<StatType, Double> rawBaseValues, SetType set) implements ItemDefinition {
}