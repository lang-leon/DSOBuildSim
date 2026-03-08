package com.langleon.dsobuildsim.items.mythicitems;

import java.util.Map;

public record MythicItemConfig (Map<MythicItemType, MythicItemDefinition> spellweaverItems, Map<MythicItemType, MythicItemDefinition> dragonknightItems,
                                Map<MythicItemType, MythicItemDefinition> rangerItems, Map<MythicItemType, MythicItemDefinition> steamMechanicusItems){
}
