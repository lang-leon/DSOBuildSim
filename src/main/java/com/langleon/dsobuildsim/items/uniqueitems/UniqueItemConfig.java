package com.langleon.dsobuildsim.items.uniqueitems;

import com.langleon.dsobuildsim.enums.items.UniqueItemType;

import java.util.Map;

public record UniqueItemConfig (Map<UniqueItemType, UniqueItemDefinition> spellweaverItems, Map<UniqueItemType, UniqueItemDefinition> dragonknightItems,
                                Map<UniqueItemType, UniqueItemDefinition> rangerItems, Map<UniqueItemType, UniqueItemDefinition> steamMechanicusItems){
}
