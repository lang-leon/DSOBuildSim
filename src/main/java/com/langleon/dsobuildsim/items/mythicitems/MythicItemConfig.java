package com.langleon.dsobuildsim.items.mythicitems;

import com.langleon.dsobuildsim.enums.items.MythicItemType;

import java.util.Map;

public record MythicItemConfig (Map<MythicItemType, MythicItemDefinition> spellweaverMythicItems, Map<MythicItemType, MythicItemDefinition> dragonknightMythicItems,
                                Map<MythicItemType, MythicItemDefinition> rangerMythicItems, Map<MythicItemType, MythicItemDefinition> steamMechanicusMythicItems){
}
