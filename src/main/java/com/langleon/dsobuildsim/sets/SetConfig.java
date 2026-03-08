package com.langleon.dsobuildsim.sets;

import java.util.Map;

public record SetConfig (Map<SetType, SetDefinition> spellweaverSets, Map<SetType, SetDefinition> dragonknightSets,
                         Map<SetType, SetDefinition> rangerSets, Map<SetType, SetDefinition> steamMechanicusSets) {
}