package com.langleon.dsobuildsim.enchantments;

import com.langleon.dsobuildsim.common.StatType;

import java.util.Map;

public record EnchantmentConfig(Map<StatType, EnchantmentDefinition> enchantments) {
}
