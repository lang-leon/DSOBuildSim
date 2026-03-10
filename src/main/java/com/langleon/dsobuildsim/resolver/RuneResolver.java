package com.langleon.dsobuildsim.resolver;

import com.langleon.dsobuildsim.dto.RuneDTO;
import com.langleon.dsobuildsim.runes.Rune;
import com.langleon.dsobuildsim.runes.RuneFactory;

public class RuneResolver {

    private final RuneFactory runeFactory;

    public RuneResolver(RuneFactory runeFactory) {
        this.runeFactory = runeFactory;
    }

    public Rune resolve(RuneDTO runeDTO)
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
}
