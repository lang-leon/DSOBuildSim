package com.langleon.dsobuildsim.collectorbagbonus;

import com.langleon.dsobuildsim.collectorbagbonus.collectorbagbonus.CollectorBagBonus;
import com.langleon.dsobuildsim.collectorbagbonus.collectorbagbonus.CollectorBagBonusDefinition;
import com.langleon.dsobuildsim.collectorbagbonus.collectorbagcategorybonus.CollectorBagCategoryBonus;
import com.langleon.dsobuildsim.collectorbagbonus.collectorbagcategorybonus.CollectorBagCategoryBonusDefinition;
import com.langleon.dsobuildsim.collectorbagbonus.dto.instance.CollectorBagCategoryBonusInstanceDTO;
import com.langleon.dsobuildsim.collectorbagbonus.enums.CollectorBagBonusType;
import com.langleon.dsobuildsim.collectorbagbonus.enums.CollectorBagCategory;
import com.langleon.dsobuildsim.collectorbagbonus.enums.CollectorBagTier;

import java.util.*;

public class CollectorBagFactory {

    private final EnumMap<CollectorBagBonusType, CollectorBagBonusDefinition> bonusConfig;
    private final EnumMap<CollectorBagCategory, CollectorBagCategoryBonusDefinition> categoryConfig;

    public CollectorBagFactory(CollectorBagConfig bonusConfig) {
        this.bonusConfig = new EnumMap<>(bonusConfig.bonuses());
        this.categoryConfig = new EnumMap<>(bonusConfig.categoryBonuses());
    }

    public CollectorBagBonus createCollectorBagBonus(CollectorBagBonusType type)
    {
        CollectorBagBonusDefinition definition = bonusConfig.get(type);
        return new CollectorBagBonus(type, definition.stats());
    }

    public CollectorBagCategoryBonus createCollectorBagCategoryBonus(CollectorBagCategory category, CollectorBagTier tier)
    {
        CollectorBagCategoryBonusDefinition definition = categoryConfig.get(category);
        List<CollectorBagBonus> bonuses = new ArrayList<>();
        for (int i=0; i<tier.getTier(); i++)
        {
            bonuses.add(this.createCollectorBagBonus(definition.bonuses().get(i)));
        }

        return new CollectorBagCategoryBonus(category, bonuses);
    }

    public CollectorBagCategoryBonus fromDTO(CollectorBagCategoryBonusInstanceDTO dto)
    {
        return createCollectorBagCategoryBonus(dto.category(), dto.tier());
    }

    public Map<CollectorBagCategory, CollectorBagCategoryBonus> fromDTOList(List<CollectorBagCategoryBonusInstanceDTO> dtos)
    {
        if (dtos == null) return Map.of();
        Map<CollectorBagCategory, CollectorBagCategoryBonus> bonuses = new HashMap<>();
        dtos.forEach(dto -> {
            bonuses.put(dto.category(), this.fromDTO(dto));
        });
        return bonuses;
    }
}
