package com.langleon.dsobuildsim.sets;

import com.langleon.dsobuildsim.enums.CharacterClass;
import com.langleon.dsobuildsim.enums.items.SetType;

public class SetFactory {
    private final SetConfig setConfig;

    public SetFactory(SetConfig setConfig) {
        this.setConfig = setConfig;
    }

    public SetInstance createSet(SetType setType, CharacterClass characterClass)
    {
        SetDefinition setDefinition;
        switch (characterClass)
        {
            case SPELLWEAVER -> setDefinition = setConfig.spellweaverSets().get(setType);
            case DRAGONKNIGHT -> setDefinition = setConfig.dragonknightSets().get(setType);
            case RANGER -> setDefinition = setConfig.rangerSets().get(setType);
            case STEAM_MECHANICUS -> setDefinition = setConfig.steamMechanicusSets().get(setType);
            default -> throw new IllegalArgumentException("Unsupported character class: " + characterClass);
        }
        return new SetInstance(setType, setDefinition.name(), setDefinition.defaultLevel(), setDefinition.setItems(), setDefinition.baseValuesPerTier(), setDefinition.relativeValuesPerTier(), setDefinition.descriptionPerTier());
    }
}