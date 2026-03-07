package com.langleon.dsobuildsim.items.mythicitems;

import com.langleon.dsobuildsim.enums.ItemSlotType;
import com.langleon.dsobuildsim.enums.StatType;
import com.langleon.dsobuildsim.enums.items.MythicItemType;
import com.langleon.dsobuildsim.enums.items.SetType;
import com.langleon.dsobuildsim.items.core.ItemDefinition;

import java.util.EnumMap;

public record MythicItemDefinition (MythicItemType itemType, String name, int defaultLevel, int tier, ItemSlotType itemSlotType, EnumMap<StatType, Double> rawBaseValues, EnumMap<StatType, Double> uniqueRelativeValues, EnumMap<StatType, Double> uniqueAbsoluteValues, SetType set) implements ItemDefinition {
}
