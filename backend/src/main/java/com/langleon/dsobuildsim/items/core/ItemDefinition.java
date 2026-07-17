package com.langleon.dsobuildsim.items.core;

import com.langleon.dsobuildsim.items.core.enums.ItemSlotType;
import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.items.core.enums.ItemType;

import java.util.EnumMap;

public interface ItemDefinition {
    ItemType itemType();
    String name();
    int defaultLevel();
    int tier();
    ItemSlotType itemSlotType();
    EnumMap<StatType, Double> rawBaseValues();
}
