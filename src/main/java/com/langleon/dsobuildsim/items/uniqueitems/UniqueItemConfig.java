package com.langleon.dsobuildsim.items.uniqueitems;

import java.util.Map;

public record UniqueItemConfig (Map<UniqueItemType, UniqueItemDefinition> spellweaverItems, Map<UniqueItemType, UniqueItemDefinition> dragonknightItems,
                                Map<UniqueItemType, UniqueItemDefinition> rangerItems, Map<UniqueItemType, UniqueItemDefinition> steamMechanicusItems){
}
