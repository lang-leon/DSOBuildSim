package com.langleon.dsobuildsim.sets;

import com.langleon.dsobuildsim.character.CharacterClass;
import com.langleon.dsobuildsim.gamedata.GameDataConfig;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SetFactory {
    private final Map<CharacterClass, Map<SetType, SetDefinition>> sets;

    public SetFactory(GameDataConfig config) {
        this.sets = config.sets();
    }

    public SetInstance createSet(SetType setType, CharacterClass characterClass)
    {
        SetDefinition setDefinition = sets.get(characterClass).get(setType);
        return new SetInstance(setType, setDefinition.name(), setDefinition.defaultLevel(), setDefinition.setItems(), setDefinition.baseValuesPerTier(), setDefinition.relativeValuesPerTier(), setDefinition.descriptionPerTier());
    }
}