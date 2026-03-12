package com.langleon.dsobuildsim.dto;

import com.langleon.dsobuildsim.character.CharacterClass;
import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.items.core.ItemType;
import com.langleon.dsobuildsim.items.core.enums.ItemCategory;

import java.util.Map;
import java.util.Set;

public record ItemDTO(
        ItemCategory itemCategory,
        CharacterClass characterClass,
        ItemType itemType,
        int level,
        Map<StatType, Double> baseValues,
        GemDTO[] gems,
        EnchantmentDTO[] enchantments,

        //optional fields depending on category
        Map<StatType, Double> uniqueBaseValues,
        Set<EnchantmentDTO> uniqueEnchantments
) {
}
