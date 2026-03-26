package com.langleon.dsobuildsim.dto;

import com.langleon.dsobuildsim.character.CharacterClass;
import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.enchantments.dto.EnchantmentDTO;
import com.langleon.dsobuildsim.gems.dto.AbstractGemInstanceDTO;
import com.langleon.dsobuildsim.gems.dto.GemDefinitionDTO;
import com.langleon.dsobuildsim.items.core.ItemType;
import com.langleon.dsobuildsim.items.core.enums.ItemCategory;

import java.util.List;
import java.util.Map;

public record ItemDTO(
        ItemCategory itemCategory,
        CharacterClass characterClass,
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
