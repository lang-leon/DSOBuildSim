package com.langleon.dsobuildsim.resolver;

import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.dto.EnchantmentDTO;
import com.langleon.dsobuildsim.enchantments.Enchantment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class EnchantmentResolverTest {

    @Test
    void shouldResolveEnchantmentFromEnchantmentDTO()
    {
        EnchantmentDTO dto = new EnchantmentDTO(StatType.DAMAGE, 0.4321);

        Enchantment enchantment = EnchantmentResolver.resolveEnchantment(dto);

        Assertions.assertEquals(StatType.DAMAGE, enchantment.getStatType());
        Assertions.assertEquals(0.4321, enchantment.getValue());
    }

    @Test
    void shouldResolveEnchantmentsFromEnchantmentDTOs()
    {
        EnchantmentDTO dto1 = new EnchantmentDTO(StatType.DAMAGE, 0.4321);
        EnchantmentDTO dto2 = new EnchantmentDTO(StatType.HEALTH_POINTS, 0.321);
        Set<EnchantmentDTO> enchantmentDTOs = Set.of(dto1, dto2);
        Set<Enchantment> enchantments = EnchantmentResolver.resolveEnchantments(enchantmentDTOs);

        Assertions.assertTrue(enchantments.stream()
                .anyMatch(e -> e.getStatType() == StatType.DAMAGE && e.getValue() == 0.4321));
        Assertions.assertTrue(enchantments.stream()
                .anyMatch(e -> e.getStatType() == StatType.HEALTH_POINTS && e.getValue() == 0.321));
    }
}
