package com.langleon.dsobuildsim.service;

import com.langleon.dsobuildsim.character.Character;
import com.langleon.dsobuildsim.character.CharacterFactory;
import com.langleon.dsobuildsim.character.dto.CharacterDTO;
import com.langleon.dsobuildsim.character.dto.CharacterStatsDTO;
import org.springframework.stereotype.Service;

@Service
public class StatsService {

    private final CharacterFactory characterFactory;

    public StatsService(CharacterFactory characterFactory) {
        this.characterFactory = characterFactory;
    }

    public CharacterStatsDTO calculate(CharacterDTO dto)
    {
        return new CharacterStatsDTO(characterFactory.fromDTO(dto).calculateCharacterStats());
    }
}
