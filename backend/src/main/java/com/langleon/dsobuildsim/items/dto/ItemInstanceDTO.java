package com.langleon.dsobuildsim.items.dto;

import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.enchantments.dto.EnchantmentDTO;
import com.langleon.dsobuildsim.gems.dto.GemInstanceDTO;
import com.langleon.dsobuildsim.items.core.enums.ItemCategory;

import java.util.List;
import java.util.Map;

public record ItemInstanceDTO(
        ItemCategory itemCategory,
        String itemType,
        int level,
        Map<StatType, Double> baseValues,
        List<GemInstanceDTO> gems,
        List<EnchantmentDTO> enchantments,

        //optional fields depending on category
        Map<StatType, Double> uniqueBaseValues,
        List<EnchantmentDTO> uniqueEnchantments
) {
}
