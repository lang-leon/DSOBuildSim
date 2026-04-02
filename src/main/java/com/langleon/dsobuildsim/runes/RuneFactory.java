package com.langleon.dsobuildsim.runes;

import com.langleon.dsobuildsim.gamedata.GameDataConfig;
import com.langleon.dsobuildsim.runes.dto.RuneInstanceDTO;
import com.langleon.dsobuildsim.runes.dto.RuneTrinketDTO;
import com.langleon.dsobuildsim.runes.enums.RuneType;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class RuneFactory {
    private final Map<RuneType, RuneDefinition> runes;

    public RuneFactory(GameDataConfig config) {
        this.runes = config.runes();
    }

    public Rune createRune(RuneType runeType, int tier)
    {
        RuneDefinition runeDefinition = this.runes.get(runeType);
        if (!runeDefinition.statsPerTier().containsKey(tier)) throw new IllegalArgumentException("Invalid rune tier: " + tier + "!");
        return new Rune(runeType, runeDefinition.runeUpgradeType(), runeDefinition.runeLimitGroup(), tier, runeDefinition.statsPerTier().get(tier), runeDefinition.description());
    }

    public Rune fromDTO(RuneInstanceDTO runeDTO)
    {
        try
        {
            return this.createRune(runeDTO.runeType(), runeDTO.tier());
        }
        catch (IllegalArgumentException e)
        {
            throw new IllegalArgumentException("Unknown rune type: " + runeDTO.runeType(), e);
        }
    }

    public List<Rune> fromDTOList(List<RuneInstanceDTO> dtos)
    {
        if (dtos == null) return List.of();
        return dtos.stream()
                .map(this::fromDTO)
                .toList();
    }

    public RuneTrinket fromTrinketDTO(RuneTrinketDTO runeTrinketDTO)
    {
        return new RuneTrinket(fromDTOList(runeTrinketDTO.runes()));
    }

    public List<RuneTrinket> fromTrinketDTOList(List<RuneTrinketDTO> dtos)
    {
        if (dtos == null) return List.of();
        return dtos.stream()
                .map(this::fromTrinketDTO)
                .toList();
    }
}
