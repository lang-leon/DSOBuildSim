package com.langleon.dsobuildsim.items.setitems;

import com.langleon.dsobuildsim.enums.items.SetItemType;

import java.util.Map;

public record SetItemConfig (Map<SetItemType, SetItemDefinition> spellweaverItems, Map<SetItemType, SetItemDefinition> dragonknightItems,
                             Map<SetItemType, SetItemDefinition> rangerItems, Map<SetItemType, SetItemDefinition> steamMechanicusItems){
}
