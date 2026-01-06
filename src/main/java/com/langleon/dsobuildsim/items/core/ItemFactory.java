package com.langleon.dsobuildsim.items.core;

import com.langleon.dsobuildsim.enums.CharacterClass;
import com.langleon.dsobuildsim.enums.items.MythicItemType;
import com.langleon.dsobuildsim.items.mythicitems.MythicItem;
import com.langleon.dsobuildsim.items.mythicitems.MythicItemConfig;
import com.langleon.dsobuildsim.items.mythicitems.MythicItemDefinition;
import com.langleon.dsobuildsim.items.setitems.SetItemConfig;
import com.langleon.dsobuildsim.items.uniqueitems.UniqueItemConfig;

public class ItemFactory {
    private final MythicItemConfig mythicItemConfig;
    private final UniqueItemConfig uniqueItemConfig;
    private final SetItemConfig setItemConfig;

    public ItemFactory(MythicItemConfig mythicItemConfig, UniqueItemConfig uniqueItemConfig, SetItemConfig setItemConfig) {
        this.mythicItemConfig = mythicItemConfig;
        this.uniqueItemConfig = uniqueItemConfig;
        this.setItemConfig = setItemConfig;
    }

    public AbstractItem createItem(MythicItemType itemType, CharacterClass characterClass)
    {
        MythicItemDefinition itemDefinition;
        switch (characterClass)
        {
            case SPELLWEAVER -> itemDefinition = mythicItemConfig.spellweaverMythicItems().get(itemType);
            case DRAGONKNIGHT -> itemDefinition = mythicItemConfig.dragonknightMythicItems().get(itemType);
            case RANGER -> itemDefinition = mythicItemConfig.rangerMythicItems().get(itemType);
            case STEAM_MECHANICUS -> itemDefinition = mythicItemConfig.steamMechanicusMythicItems().get(itemType);
            default -> throw new IllegalArgumentException("Unsupported character class: " + characterClass);
        }
        return new MythicItem(itemType, itemDefinition.name(), itemDefinition.defaultLevel(), itemDefinition.tier(), itemDefinition.itemSlotType(), itemDefinition.baseValues(), itemDefinition.uniqueRelativeValues(), itemDefinition.uniqueAbsoluteValues(), itemDefinition.set());
    }
}
