package com.langleon.dsobuildsim.resolver;

import com.langleon.dsobuildsim.dto.RuneDTO;
import com.langleon.dsobuildsim.runes.Rune;
import com.langleon.dsobuildsim.runes.RuneFactory;

import java.util.List;

public class RuneResolver {

    private final RuneFactory runeFactory;

    public RuneResolver(RuneFactory runeFactory) {
        this.runeFactory = runeFactory;
    }

    public Rune resolveRune(RuneDTO runeDTO)
    {
        try
        {
            return runeFactory.createRune(runeDTO.runeType(), runeDTO.tier());
        }
        catch (IllegalArgumentException e)
        {
            throw new IllegalArgumentException("Unknown rune type: " + runeDTO.runeType(), e);
        }
    }

    public List<Rune> resolveRunes(List<RuneDTO> dtos)
    {
        if (dtos == null) return List.of();
        return dtos.stream()
                .map(this::resolveRune)
                .toList();
    }
}
