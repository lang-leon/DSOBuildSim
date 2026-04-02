package com.langleon.dsobuildsim.dragonstones;

import com.langleon.dsobuildsim.dragonstones.dto.DragonCrestTrinketDTO;
import com.langleon.dsobuildsim.dragonstones.dto.DragonStoneInstanceDTO;
import com.langleon.dsobuildsim.gamedata.GameDataConfig;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class DragonStoneFactory {

    private final Map<DragonStoneType, DragonStoneDefinition> dragonStones;

    public DragonStoneFactory(GameDataConfig config) {
        this.dragonStones = config.dragonStones();
    }

    public DragonStone createDragonStone(DragonStoneType dragonStoneType, int tier)
    {
        DragonStoneDefinition dragonStoneDefinition = this.dragonStones.get(dragonStoneType);
        return new DragonStone(dragonStoneType, tier, dragonStoneDefinition.statsPerTier().get(tier), dragonStoneDefinition.descriptionPerTier().get(tier));
    }

    public DragonStone fromDTO(DragonStoneInstanceDTO dto)
    {
        return this.createDragonStone(dto.dragonStoneType(), dto.tier());
    }

    public List<DragonStone> fromDTOList(List<DragonStoneInstanceDTO> dtos)
    {
        if (dtos == null) return List.of();
        return dtos.stream()
                .map(this::fromDTO)
                .toList();
    }

    public DragonCrestTrinket fromDTO(DragonCrestTrinketDTO dragonCrest)
    {
        return new DragonCrestTrinket(fromDTOList(dragonCrest.dragonStones()));
    }
}
