package com.langleon.dsobuildsim.enchantments;

import com.langleon.dsobuildsim.enchantments.dto.EnchantmentDTO;

public class EnchantmentMapper {

    public static EnchantmentDTO from(EnchantmentDefinition enchantmentDefinition)
    {
        return new EnchantmentDTO(enchantmentDefinition.statType(), enchantmentDefinition.value());
    }
}
