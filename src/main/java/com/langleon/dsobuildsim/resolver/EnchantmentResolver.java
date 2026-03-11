package com.langleon.dsobuildsim.resolver;

import com.langleon.dsobuildsim.dto.EnchantmentDTO;
import com.langleon.dsobuildsim.enchantments.Enchantment;

import java.util.List;

public class EnchantmentResolver {

    public static Enchantment resolveEnchantment(EnchantmentDTO enchantmentDTO)
    {
        return new Enchantment(enchantmentDTO.statType(), enchantmentDTO.value());
    }

    public static List<Enchantment> resolveEnchantments(List<EnchantmentDTO> dtos)
    {
        if (dtos == null) return List.of();
        return dtos.stream()
                .map(EnchantmentResolver::resolveEnchantment)
                .toList();
    }
}
