package com.langleon.dsobuildsim.enchantments;

import tools.jackson.databind.ObjectMapper;
import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.enchantments.dto.EnchantmentDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class EnchantmentMapperTest {

    private EnchantmentConfig config;

    @BeforeEach
    void setup() throws IOException {
        try (var reader = new InputStreamReader(Objects.requireNonNull(getClass().getResourceAsStream("/gamedata/enchantments.json"))))
        {
            ObjectMapper objectMapper = new ObjectMapper();
            config = objectMapper.readValue(reader, EnchantmentConfig.class);
        }
    }

    @Test
    void shouldMapEnchantmentDefinitionToEnchantmentDTO()
    {
        EnchantmentDTO dto = EnchantmentMapper.from(config.enchantments().get(StatType.DAMAGE));

        Assertions.assertEquals(StatType.DAMAGE, dto.statType());
        Assertions.assertEquals(0.44776, dto.value());
    }
}
