package com.langleon.dsobuildsim.collectorbagbonus;

import com.langleon.dsobuildsim.collectorbagbonus.collectorbagbonus.CollectorBagBonus;
import com.langleon.dsobuildsim.collectorbagbonus.collectorbagcategorybonus.CollectorBagCategoryBonus;
import com.langleon.dsobuildsim.collectorbagbonus.dto.instance.CollectorBagCategoryBonusInstanceDTO;
import com.langleon.dsobuildsim.collectorbagbonus.enums.CollectorBagBonusType;
import com.langleon.dsobuildsim.collectorbagbonus.enums.CollectorBagCategory;
import com.langleon.dsobuildsim.collectorbagbonus.enums.CollectorBagTier;
import com.langleon.dsobuildsim.common.StatType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;

public class CollectorBagFactoryTest {

    private CollectorBagFactory factory;

    @BeforeEach
    void setup() throws IOException
    {
        try (var reader = new InputStreamReader(Objects.requireNonNull(getClass().getResourceAsStream("/gamedata/collectorbagbonuses.json"))))
        {
            ObjectMapper objectMapper = new ObjectMapper();
            CollectorBagConfig config = objectMapper.readValue(reader, CollectorBagConfig.class);
            factory = new CollectorBagFactory(config);
        }
    }

    @Test
    void createCollectorBagBonus()
    {
        CollectorBagBonus bonus = factory.createCollectorBagBonus(CollectorBagBonusType.TRIAD_OF_LIFE);
        Assertions.assertEquals(CollectorBagBonusType.TRIAD_OF_LIFE, bonus.type());
        Assertions.assertEquals(0.03, bonus.stats().get(StatType.HEALTH_POINTS));
    }

    @Test
    void createCollectorBagCategoryBonus()
    {
        CollectorBagCategoryBonus bonus = factory.createCollectorBagCategoryBonus(CollectorBagCategory.DRAGON_SPAWN, CollectorBagTier.TIER2);
        Assertions.assertEquals(CollectorBagCategory.DRAGON_SPAWN, bonus.category());
        Assertions.assertEquals(2, bonus.calculateStats().size());
        Assertions.assertEquals(0.03, bonus.calculateStats().get(StatType.HEALTH_POINTS));
        Assertions.assertEquals(0.03, bonus.calculateStats().get(StatType.RESISTANCE_VALUE));
    }

    @Test
    void createFromDTO()
    {
        CollectorBagCategoryBonusInstanceDTO dto = new CollectorBagCategoryBonusInstanceDTO(CollectorBagCategory.DRAGON_SPAWN, CollectorBagTier.TIER2);
        CollectorBagCategoryBonus bonus = factory.fromDTO(dto);
        Assertions.assertEquals(2, bonus.calculateStats().size());
        Assertions.assertEquals(0.03, bonus.calculateStats().get(StatType.HEALTH_POINTS));
        Assertions.assertEquals(0.03, bonus.calculateStats().get(StatType.RESISTANCE_VALUE));
    }

    @Test
    void createFromDTOs()
    {
        CollectorBagCategoryBonusInstanceDTO dto1 = new CollectorBagCategoryBonusInstanceDTO(CollectorBagCategory.DRAGON_SPAWN, CollectorBagTier.TIER2);
        CollectorBagCategoryBonusInstanceDTO dto2 = new CollectorBagCategoryBonusInstanceDTO(CollectorBagCategory.TAMED_FOES, CollectorBagTier.TIER3);
        List<CollectorBagCategoryBonus> bonuses = factory.fromDTOList(List.of(dto1, dto2));
        Assertions.assertEquals(2, bonuses.getFirst().calculateStats().size());
        Assertions.assertEquals(0.03, bonuses.getFirst().calculateStats().get(StatType.HEALTH_POINTS));
        Assertions.assertEquals(0.03, bonuses.getFirst().calculateStats().get(StatType.RESISTANCE_VALUE));
        Assertions.assertEquals(3, bonuses.get(1).calculateStats().size());
        Assertions.assertEquals(0.03, bonuses.get(1).calculateStats().get(StatType.HEALTH_POINTS));
        Assertions.assertEquals(0.03, bonuses.get(1).calculateStats().get(StatType.RESISTANCE_VALUE));
        Assertions.assertEquals(0.02, bonuses.get(1).calculateStats().get(StatType.DAMAGE));
    }
}
