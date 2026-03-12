package com.langleon.dsobuildsim.dto;

import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.items.core.ItemType;
import com.langleon.dsobuildsim.items.core.enums.ItemCategory;
import com.langleon.dsobuildsim.items.core.enums.ItemSlotType;
import com.langleon.dsobuildsim.sets.SetType;

import java.util.List;
import java.util.Map;
import java.util.Set;

public record ItemDefinitionDTO(
        ItemCategory itemCategory,
        ItemType itemType,
        String name,
        int defaultLevel,
        int tier,
        ItemSlotType itemSlotType,
        Map<StatType, Double> rawBaseValues,

        //optional fields depending on category
        Map<StatType, Double> uniqueBaseValues,
        Map<StatType, Double> uniqueRelativeValues,
        Map<StatType, Double> uniqueAbsoluteValues,
        Set<EnchantmentDTO> uniqueEnchantments,
        String uniqueDescription,

        SetType set
        ) {
}
