package com.langleon.dsobuildsim.items.core;

import com.langleon.dsobuildsim.enums.CharacterClass;
import com.langleon.dsobuildsim.enums.items.MythicItemType;
import com.langleon.dsobuildsim.enums.items.SetItemType;
import com.langleon.dsobuildsim.enums.items.UniqueItemType;
import com.langleon.dsobuildsim.items.mythicitems.MythicItem;
import com.langleon.dsobuildsim.items.mythicitems.MythicItemConfig;
import com.langleon.dsobuildsim.items.mythicitems.MythicItemDefinition;
import com.langleon.dsobuildsim.items.setitems.SetItem;
import com.langleon.dsobuildsim.items.setitems.SetItemConfig;
import com.langleon.dsobuildsim.items.setitems.SetItemDefinition;
import com.langleon.dsobuildsim.items.uniqueitems.UniqueItem;
import com.langleon.dsobuildsim.items.uniqueitems.UniqueItemConfig;
import com.langleon.dsobuildsim.items.uniqueitems.UniqueItemDefinition;

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
            case SPELLWEAVER -> itemDefinition = mythicItemConfig.spellweaverItems().get(itemType);
            case DRAGONKNIGHT -> itemDefinition = mythicItemConfig.dragonknightItems().get(itemType);
            case RANGER -> itemDefinition = mythicItemConfig.rangerItems().get(itemType);
            case STEAM_MECHANICUS -> itemDefinition = mythicItemConfig.steamMechanicusItems().get(itemType);
            default -> throw new IllegalArgumentException("Unsupported character class: " + characterClass);
        }
        return new MythicItem(itemType, itemDefinition.name(), itemDefinition.defaultLevel(), itemDefinition.tier(), itemDefinition.itemSlotType(), itemDefinition.baseValues(), itemDefinition.uniqueRelativeValues(), itemDefinition.uniqueAbsoluteValues(), itemDefinition.set());
    }

    public AbstractItem createItem(UniqueItemType itemType, CharacterClass characterClass)
    {
        UniqueItemDefinition itemDefinition;
        switch (characterClass)
        {
            case SPELLWEAVER -> itemDefinition = uniqueItemConfig.spellweaverItems().get(itemType);
            case DRAGONKNIGHT -> itemDefinition = uniqueItemConfig.dragonknightItems().get(itemType);
            case RANGER -> itemDefinition = uniqueItemConfig.rangerItems().get(itemType);
            case STEAM_MECHANICUS -> itemDefinition = uniqueItemConfig.steamMechanicusItems().get(itemType);
            default -> throw new IllegalArgumentException("Unsupported character class: " + characterClass);
        }
        return new UniqueItem(itemType, itemDefinition.name(), itemDefinition.defaultLevel(), itemDefinition.tier(), itemDefinition.itemSlotType(), itemDefinition.baseValues(), itemDefinition.uniqueBaseValues(), itemDefinition.uniqueRelativeValues(), itemDefinition.uniqueEnchantments());
    }

    public AbstractItem createItem(SetItemType itemType, CharacterClass characterClass)
    {
        SetItemDefinition itemDefinition;
        switch (characterClass)
        {
            case SPELLWEAVER -> itemDefinition = setItemConfig.spellweaverItems().get(itemType);
            case DRAGONKNIGHT -> itemDefinition = setItemConfig.dragonknightItems().get(itemType);
            case RANGER -> itemDefinition = setItemConfig.rangerItems().get(itemType);
            case STEAM_MECHANICUS -> itemDefinition = setItemConfig.steamMechanicusItems().get(itemType);
            default -> throw new IllegalArgumentException("Unsupported character class: " + characterClass);
        }
        return new SetItem(itemType, itemDefinition.name(), itemDefinition.defaultLevel(), itemDefinition.tier(), itemDefinition.itemSlotType(), itemDefinition.baseValues(), itemDefinition.set());
    }
}
