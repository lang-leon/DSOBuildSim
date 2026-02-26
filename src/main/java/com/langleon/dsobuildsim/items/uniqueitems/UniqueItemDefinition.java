package com.langleon.dsobuildsim.items.uniqueitems;

import com.langleon.dsobuildsim.enchantments.EnchantmentDefinition;
import com.langleon.dsobuildsim.enums.ItemSlotType;
import com.langleon.dsobuildsim.enums.StatType;
import com.langleon.dsobuildsim.enums.items.UniqueItemType;

import java.util.List;
import java.util.Map;

public record UniqueItemDefinition (UniqueItemType itemType, String name, int defaultLevel, int tier, ItemSlotType itemSlotType, Map<StatType, Double> baseValues, Map<StatType, Double> uniqueBaseValues, Map<StatType, Double> uniqueRelativeValues, List<EnchantmentDefinition> uniqueEnchantments, String uniqueDescription){
}
