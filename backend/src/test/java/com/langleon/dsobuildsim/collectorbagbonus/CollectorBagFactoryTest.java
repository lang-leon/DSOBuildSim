package com.langleon.dsobuildsim.collectorbagbonus;

import com.langleon.dsobuildsim.collectorbagbonus.collectorbagbonus.CollectorBagBonus;
import com.langleon.dsobuildsim.collectorbagbonus.collectorbagcategorybonus.CollectorBagCategoryBonus;
import com.langleon.dsobuildsim.collectorbagbonus.dto.instance.CollectorBagCategoryBonusInstanceDTO;
import com.langleon.dsobuildsim.collectorbagbonus.enums.CollectorBagBonusType;
import com.langleon.dsobuildsim.collectorbagbonus.enums.CollectorBagCategory;
import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.gamedata.GameDataConfig;
import com.langleon.dsobuildsim.gamedata.GameDataLoader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class CollectorBagFactoryTest {

    private CollectorBagFactory collectorBagFactory;

    @BeforeEach
    void setup()
    {
        GameDataConfig config = new GameDataLoader().loadGameDataConfig();
        collectorBagFactory = new CollectorBagFactory(config);
    }

    @Test
    void createCollectorBagBonus()
    {
        CollectorBagBonus bonus = collectorBagFactory.createCollectorBagBonus(CollectorBagBonusType.TRIAD_OF_LIFE);
        Assertions.assertEquals(CollectorBagBonusType.TRIAD_OF_LIFE, bonus.type());
        Assertions.assertEquals(0.03, bonus.stats().get(StatType.HEALTH_POINTS));
    }

    @Test
    void createCollectorBagCategoryBonus()
    {
        CollectorBagCategoryBonus bonus = collectorBagFactory.createCollectorBagCategoryBonus(CollectorBagCategory.DRAGON_SPAWN, 2);
        Assertions.assertEquals(CollectorBagCategory.DRAGON_SPAWN, bonus.category());
        Assertions.assertEquals(2, bonus.calculateStats().size());
        Assertions.assertEquals(0.03, bonus.calculateStats().get(StatType.HEALTH_POINTS));
        Assertions.assertEquals(0.03, bonus.calculateStats().get(StatType.RESISTANCE_VALUE));
    }

    @Test
    void createFromDTO()
    {
        CollectorBagCategoryBonusInstanceDTO dto = new CollectorBagCategoryBonusInstanceDTO(CollectorBagCategory.DRAGON_SPAWN, 2);
        CollectorBagCategoryBonus bonus = collectorBagFactory.fromDTO(dto);
        Assertions.assertEquals(2, bonus.calculateStats().size());
        Assertions.assertEquals(0.03, bonus.calculateStats().get(StatType.HEALTH_POINTS));
        Assertions.assertEquals(0.03, bonus.calculateStats().get(StatType.RESISTANCE_VALUE));
    }

    @Test
    void createFromDTOs()
    {
        CollectorBagCategoryBonusInstanceDTO dto1 = new CollectorBagCategoryBonusInstanceDTO(CollectorBagCategory.DRAGON_SPAWN, 2);
        CollectorBagCategoryBonusInstanceDTO dto2 = new CollectorBagCategoryBonusInstanceDTO(CollectorBagCategory.TAMED_FOES, 3);
        Map<CollectorBagCategory, CollectorBagCategoryBonus> bonuses = collectorBagFactory.fromDTOList(List.of(dto1, dto2));
        Assertions.assertEquals(2, bonuses.get(CollectorBagCategory.DRAGON_SPAWN).calculateStats().size());
        Assertions.assertEquals(0.03, bonuses.get(CollectorBagCategory.DRAGON_SPAWN).calculateStats().get(StatType.HEALTH_POINTS));
        Assertions.assertEquals(0.03, bonuses.get(CollectorBagCategory.DRAGON_SPAWN).calculateStats().get(StatType.RESISTANCE_VALUE));
        Assertions.assertEquals(3, bonuses.get(CollectorBagCategory.TAMED_FOES).calculateStats().size());
        Assertions.assertEquals(0.03, bonuses.get(CollectorBagCategory.TAMED_FOES).calculateStats().get(StatType.HEALTH_POINTS));
        Assertions.assertEquals(0.03, bonuses.get(CollectorBagCategory.TAMED_FOES).calculateStats().get(StatType.RESISTANCE_VALUE));
        Assertions.assertEquals(0.02, bonuses.get(CollectorBagCategory.TAMED_FOES).calculateStats().get(StatType.DAMAGE));
    }
}
