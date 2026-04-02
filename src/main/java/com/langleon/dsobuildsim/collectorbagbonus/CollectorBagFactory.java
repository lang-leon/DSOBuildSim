package com.langleon.dsobuildsim.collectorbagbonus;

import com.langleon.dsobuildsim.collectorbagbonus.collectorbagbonus.CollectorBagBonus;
import com.langleon.dsobuildsim.collectorbagbonus.collectorbagbonus.CollectorBagBonusDefinition;
import com.langleon.dsobuildsim.collectorbagbonus.collectorbagcategorybonus.CollectorBagCategoryBonus;
import com.langleon.dsobuildsim.collectorbagbonus.collectorbagcategorybonus.CollectorBagCategoryBonusDefinition;
import com.langleon.dsobuildsim.collectorbagbonus.dto.instance.CollectorBagCategoryBonusInstanceDTO;
import com.langleon.dsobuildsim.collectorbagbonus.enums.CollectorBagBonusType;
import com.langleon.dsobuildsim.collectorbagbonus.enums.CollectorBagCategory;
import com.langleon.dsobuildsim.collectorbagbonus.enums.CollectorBagTier;
import com.langleon.dsobuildsim.gamedata.GameDataConfig;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CollectorBagFactory {

    private final CollectorBagConfig config;

    public CollectorBagFactory(GameDataConfig config) {
        this.config = config.collectorBagConfig();
    }

    public CollectorBagBonus createCollectorBagBonus(CollectorBagBonusType type)
    {
        CollectorBagBonusDefinition definition = config.bonuses().get(type);
        return new CollectorBagBonus(type, definition.stats());
    }

    public CollectorBagCategoryBonus createCollectorBagCategoryBonus(CollectorBagCategory category, CollectorBagTier tier)
    {
        CollectorBagCategoryBonusDefinition definition = config.categoryBonuses().get(category);
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
