package com.langleon.dsobuildsim.items.core;

import com.langleon.dsobuildsim.enums.ItemSlotType;
import com.langleon.dsobuildsim.enums.StatType;
import com.langleon.dsobuildsim.enums.items.ItemType;

import java.util.EnumMap;

public interface ItemDefinition {
    ItemType itemType();
    String name();
    int defaultLevel();
    int tier();
    ItemSlotType itemSlotType();
    EnumMap<StatType, Double> rawBaseValues();
}
