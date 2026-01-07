package com.langleon.dsobuildsim.items.uniqueitems;

import com.langleon.dsobuildsim.enchantments.Enchant;
import com.langleon.dsobuildsim.enums.ItemSlotType;
import com.langleon.dsobuildsim.enums.StatType;
import com.langleon.dsobuildsim.enums.items.ItemType;

import java.util.List;
import java.util.Map;

public record UniqueItemDefinition (ItemType itemType, String name, int defaultLevel, int tier, ItemSlotType itemSlotType, Map<StatType, Double> baseValues, Map<StatType, Double> uniqueBaseValues, Map<StatType, Double> uniqueRelativeValues, List<Enchant> uniqueEnchants, String uniqueDescription){
}
