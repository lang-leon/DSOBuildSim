package com.langleon.dsobuildsim.gems;

import com.langleon.dsobuildsim.gamedata.GameDataConfig;
import com.langleon.dsobuildsim.gems.dto.*;
import com.langleon.dsobuildsim.gems.enums.GemType;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class GemFactory {
    private final Map<GemType, GemDefinition> gems;

    public GemFactory(GameDataConfig config) {
        this.gems = config.gems();
    }

    public Gem createGem(GemType gemType, int tier) {
        GemDefinition gemDefinition = this.gems.get(gemType);
        Double value = gemDefinition.statsPerTier().get(tier);
        if (value == null) throw new IllegalArgumentException("Invalid gem tier: " + tier + "!");
        return new Gem(gemDefinition.gemType(), gemDefinition.gemUpgradeType(), gemDefinition.gemLimitGroup(), tier, Map.of(gemDefinition.statType(), gemDefinition.statsPerTier().get(tier)));
    }

    public Opal createOpal(GemType gemType1, GemType gemType2, GemType gemType3, int tier) {
        GemDefinition gemDefinition1 = this.gems.get(gemType1);
        GemDefinition gemDefinition2 = this.gems.get(gemType2);
        GemDefinition gemDefinition3 = this.gems.get(gemType3);
        if (gemDefinition1.statsPerTier().get(tier) == null) throw new IllegalArgumentException("Invalid gem tier: " + tier + "!");
        return new Opal(tier, Map.of(gemDefinition1.statType(), gemDefinition1.statsPerTier().get(tier)*0.75, gemDefinition2.statType(), gemDefinition2.statsPerTier().get(tier)*0.75 , gemDefinition3.statType(), gemDefinition3.statsPerTier().get(tier)*0.75));
    }

    public AbstractGem fromDTO(AbstractGemInstanceDTO dto)
    {
        if (dto instanceof GemInstanceDTO(GemType gemType, int tier))
        {
            return createGem(gemType, tier);
        }
        if (dto instanceof OpalInstanceDTO(GemType gemType1, GemType gemType2, GemType gemType3, int tier))
        {
            return createOpal(gemType1, gemType2, gemType3, tier);
        }
        throw new IllegalArgumentException("Unknown DTO type: " + dto);
    }

    public List<AbstractGem> fromDTOList(List<AbstractGemInstanceDTO> dtos)
    {
        if (dtos == null) return List.of();
        return dtos.stream()
                .map(this::fromDTO)
                .toList();
    }
}
