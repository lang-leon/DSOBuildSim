package com.langleon.dsobuildsim.collectorbagbonus;

import com.langleon.dsobuildsim.collectorbagbonus.dto.definition.CollectorBagBonusDefinitionDTO;
import com.langleon.dsobuildsim.collectorbagbonus.dto.definition.CollectorBagCategoryBonusDefinitionDTO;
import com.langleon.dsobuildsim.collectorbagbonus.enums.CollectorBagBonusType;
import com.langleon.dsobuildsim.collectorbagbonus.enums.CollectorBagCategory;
import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.gamedata.GameDataConfig;
import com.langleon.dsobuildsim.gamedata.GameDataLoader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CollectorBagMapperTest {

    private CollectorBagConfig collectorBagConfig;

    @BeforeEach
    void setup()
    {
        GameDataConfig config = new GameDataLoader().loadGameDataConfig();
        collectorBagConfig = config.collectorBagConfig();
    }

    @Test
    void shouldMapDefinitionToDTO()
    {
        CollectorBagBonusDefinitionDTO dto = CollectorBagMapper.from(collectorBagConfig.bonuses().get(CollectorBagBonusType.TRIAD_OF_LIFE));

        Assertions.assertEquals(CollectorBagBonusType.TRIAD_OF_LIFE, dto.type());
        Assertions.assertTrue(dto.stats().containsKey(StatType.HEALTH_POINTS));
        Assertions.assertEquals(0.03, dto.stats().get(StatType.HEALTH_POINTS));
        Assertions.assertEquals("Triad of Life", dto.type().getName());
    }

    @Test
    void shouldMapCategoryDefinitionToDTO()
    {
        CollectorBagCategoryBonusDefinitionDTO dto = CollectorBagMapper.from(collectorBagConfig.categoryBonuses().get(CollectorBagCategory.DRAGON_SPAWN), collectorBagConfig);

        Assertions.assertEquals(3, dto.bonuses().size());
        Assertions.assertEquals(CollectorBagBonusType.TRIAD_OF_LIFE, dto.bonuses().getFirst().type());
        Assertions.assertEquals(0.03, dto.bonuses().getFirst().stats().get(StatType.HEALTH_POINTS));
        Assertions.assertEquals("Triad of Life", dto.bonuses().getFirst().type().getName());
        Assertions.assertEquals(CollectorBagBonusType.RESISTANCE_OF_SIX, dto.bonuses().get(1).type());
        Assertions.assertEquals(0.03, dto.bonuses().get(1).stats().get(StatType.RESISTANCE_VALUE));
        Assertions.assertEquals("Resistance of Six", dto.bonuses().get(1).type().getName());
        Assertions.assertEquals(CollectorBagBonusType.STRENGTH_OF_NINE, dto.bonuses().get(2).type());
        Assertions.assertEquals(0.02, dto.bonuses().get(2).stats().get(StatType.DAMAGE));
        Assertions.assertEquals("Strength of Nine", dto.bonuses().get(2).type().getName());
    }
}
