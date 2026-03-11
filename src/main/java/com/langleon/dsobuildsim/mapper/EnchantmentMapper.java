package com.langleon.dsobuildsim.mapper;

import com.langleon.dsobuildsim.dto.EnchantmentDTO;
import com.langleon.dsobuildsim.enchantments.EnchantmentDefinition;

public class EnchantmentMapper {

    public static EnchantmentDTO from(EnchantmentDefinition enchantmentDefinition)
    {
        return new EnchantmentDTO(enchantmentDefinition.statType(), enchantmentDefinition.value());
    }
}
