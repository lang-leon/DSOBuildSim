package com.langleon.dsobuildsim.items.mythicitems;

import com.langleon.dsobuildsim.items.core.enums.ItemSlotType;
import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.sets.SetType;
import com.langleon.dsobuildsim.items.core.ItemDefinition;

import java.util.EnumMap;

public record MythicItemDefinition (MythicItemType itemType, String name, int defaultLevel, int tier, ItemSlotType itemSlotType, EnumMap<StatType, Double> rawBaseValues, EnumMap<StatType, Double> uniqueRelativeValues, EnumMap<StatType, Double> uniqueAbsoluteValues, SetType set) implements ItemDefinition {
}
