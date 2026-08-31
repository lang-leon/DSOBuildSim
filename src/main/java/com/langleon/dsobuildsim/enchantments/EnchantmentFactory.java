package com.langleon.dsobuildsim.enchantments;

import com.langleon.dsobuildsim.enchantments.dto.EnchantmentDTO;

import java.util.List;

public class EnchantmentFactory {

    public static Enchantment fromDTO(EnchantmentDTO enchantmentDTO)
    {
        return new Enchantment(enchantmentDTO.statType(), enchantmentDTO.value());
    }

    public static List<Enchantment> fromDTOList(List<EnchantmentDTO> dtos)
    {
        if (dtos == null) return List.of();
        return dtos.stream()
                .map(EnchantmentFactory::fromDTO)
                .toList();
    }
}
