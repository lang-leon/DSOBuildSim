package com.langleon.dsobuildsim.enchantments;

import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.dragonstones.DragonStoneConfig;
import com.langleon.dsobuildsim.dragonstones.DragonStoneFactory;
import com.langleon.dsobuildsim.enchantments.dto.EnchantmentDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;

public class EnchantmentFactoryTest {

    @Test
    void shouldResolveEnchantmentFromEnchantmentDTO()
    {
        EnchantmentDTO dto = new EnchantmentDTO(StatType.DAMAGE, 0.4321);

        Enchantment enchantment = EnchantmentFactory.fromDTO(dto);

        Assertions.assertEquals(StatType.DAMAGE, enchantment.getStatType());
        Assertions.assertEquals(0.4321, enchantment.getValue());
    }

    @Test
    void shouldResolveEnchantmentsFromEnchantmentDTOs()
    {
        EnchantmentDTO dto1 = new EnchantmentDTO(StatType.DAMAGE, 0.4321);
        EnchantmentDTO dto2 = new EnchantmentDTO(StatType.HEALTH_POINTS, 0.321);
        List<EnchantmentDTO> enchantmentDTOs = List.of(dto1, dto2);
        List<Enchantment> enchantments = EnchantmentFactory.fromDTOList(enchantmentDTOs);

        Assertions.assertTrue(enchantments.stream()
                .anyMatch(e -> e.getStatType() == StatType.DAMAGE && e.getValue() == 0.4321));
        Assertions.assertTrue(enchantments.stream()
                .anyMatch(e -> e.getStatType() == StatType.HEALTH_POINTS && e.getValue() == 0.321));
    }
}
