package com.langleon.dsobuildsim.items.dto;

import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.enchantments.dto.EnchantmentDTO;
import com.langleon.dsobuildsim.gems.dto.AbstractGemInstanceDTO;
import com.langleon.dsobuildsim.items.core.enums.ItemType;
import com.langleon.dsobuildsim.items.core.enums.ItemCategory;

import java.util.List;
import java.util.Map;

public record ItemDTO(
        ItemCategory itemCategory,
        ItemType itemType,
        int level,
        Map<StatType, Double> baseValues,
        AbstractGemInstanceDTO[] gems,
        EnchantmentDTO[] enchantments,

        //optional fields depending on category
        Map<StatType, Double> uniqueBaseValues,
        List<EnchantmentDTO> uniqueEnchantments
) {
}
