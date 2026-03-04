package com.langleon.dsobuildsim.items.mythicitems;

import com.langleon.dsobuildsim.enums.items.MythicItemType;

import java.util.Map;

public record MythicItemConfig (Map<MythicItemType, MythicItemDefinition> spellweaverItems, Map<MythicItemType, MythicItemDefinition> dragonknightItems,
                                Map<MythicItemType, MythicItemDefinition> rangerItems, Map<MythicItemType, MythicItemDefinition> steamMechanicusItems){
}
