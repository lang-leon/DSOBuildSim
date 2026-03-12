package com.langleon.dsobuildsim.resolver;

import com.langleon.dsobuildsim.dto.EnchantmentDTO;
import com.langleon.dsobuildsim.enchantments.Enchantment;

import java.util.Set;
import java.util.stream.Collectors;

public class EnchantmentResolver {

    public static Enchantment resolveEnchantment(EnchantmentDTO enchantmentDTO)
    {
        return new Enchantment(enchantmentDTO.statType(), enchantmentDTO.value());
    }

    public static Set<Enchantment> resolveEnchantments(Set<EnchantmentDTO> dtos)
    {
        if (dtos == null) return Set.of();
        return dtos.stream()
                .map(EnchantmentResolver::resolveEnchantment)
                .collect(Collectors.toSet());
    }
}
