package com.langleon.dsobuildsim.items.uniqueitems;

import com.langleon.dsobuildsim.enchantments.EnchantmentDefinition;
import com.langleon.dsobuildsim.items.core.enums.ItemSlotType;
import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.items.core.ItemDefinition;

import java.util.EnumMap;
import java.util.Map;
import java.util.Set;

public record UniqueItemDefinition (UniqueItemType itemType, String name, int defaultLevel, int tier, ItemSlotType itemSlotType, EnumMap<StatType, Double> rawBaseValues, Map<StatType, Double> uniqueBaseValues, Map<StatType, Double> uniqueRelativeValues, Set<EnchantmentDefinition> uniqueEnchantments, String uniqueDescription) implements ItemDefinition {
}
