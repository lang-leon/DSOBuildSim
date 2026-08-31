package com.langleon.dsobuildsim.collectorbagbonus;

import com.langleon.dsobuildsim.collectorbagbonus.collectorbagbonus.CollectorBagBonusDefinition;
import com.langleon.dsobuildsim.collectorbagbonus.collectorbagcategorybonus.CollectorBagCategoryBonusDefinition;
import com.langleon.dsobuildsim.collectorbagbonus.dto.definition.CollectorBagBonusDefinitionDTO;
import com.langleon.dsobuildsim.collectorbagbonus.dto.definition.CollectorBagCategoryBonusDefinitionDTO;

import java.util.ArrayList;
import java.util.List;

public class CollectorBagMapper {

    public static CollectorBagBonusDefinitionDTO from(CollectorBagBonusDefinition definition)
    {
        return new CollectorBagBonusDefinitionDTO(definition.bonusType(), definition.bonusType().name(), definition.stats());
    }

    public static CollectorBagCategoryBonusDefinitionDTO from(CollectorBagCategoryBonusDefinition definition, CollectorBagConfig config)
    {
        List<CollectorBagBonusDefinitionDTO> bonusDTOs = new ArrayList<>();
        definition.bonuses().forEach(bonus -> bonusDTOs.add(from(config.bonuses().get(bonus))));
        return new CollectorBagCategoryBonusDefinitionDTO(definition.category(), definition.category().getName(), bonusDTOs);
    }
}
