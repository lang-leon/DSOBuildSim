package com.langleon.dsobuildsim.dragonstones;

import com.langleon.dsobuildsim.dragonstones.dto.DragonCrestTrinketDTO;
import com.langleon.dsobuildsim.dragonstones.dto.DragonStoneInstanceDTO;

import java.util.List;

public class DragonStoneFactory {

    private final DragonStoneConfig config;

    public DragonStoneFactory(DragonStoneConfig config) {
        this.config = config;
    }

    public DragonStone createDragonStone(DragonStoneType dragonStoneType, int tier)
    {
        DragonStoneDefinition dragonStoneDefinition = this.config.dragonStones().get(dragonStoneType);
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
