package com.langleon.dsobuildsim.enchantments;

import com.langleon.dsobuildsim.gamedata.GameDataConfig;
import com.langleon.dsobuildsim.gamedata.GameDataLoader;
import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.enchantments.dto.EnchantmentDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class EnchantmentMapperTest {

    private Map<StatType, EnchantmentDefinition> enchantments;

    @BeforeEach
    void setup()
    {
        GameDataConfig config = new GameDataLoader().loadGameDataConfig();
        enchantments = config.enchantments();
    }

    @Test
    void shouldMapEnchantmentDefinitionToEnchantmentDTO()
    {
        EnchantmentDTO dto = EnchantmentMapper.from(enchantments.get(StatType.DAMAGE));

        Assertions.assertEquals(StatType.DAMAGE, dto.statType());
        Assertions.assertEquals(0.44776, dto.value());
    }
}
