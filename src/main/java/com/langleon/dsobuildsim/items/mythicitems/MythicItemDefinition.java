package com.langleon.dsobuildsim.items.mythicitems;

import com.langleon.dsobuildsim.enums.ItemSlotType;
import com.langleon.dsobuildsim.enums.StatType;
import com.langleon.dsobuildsim.enums.items.ItemType;
import com.langleon.dsobuildsim.enums.items.SetType;

import java.util.Map;

public record MythicItemDefinition (ItemType itemType, String name, int defaultLevel, int tier, ItemSlotType itemSlotType, Map<StatType, Double> baseValues, Map<StatType, Double> uniqueRelativeValues, Map<StatType, Double> uniqueAbsoluteValues, SetType set){
}
