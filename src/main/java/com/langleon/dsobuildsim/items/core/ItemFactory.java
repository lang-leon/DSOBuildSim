package com.langleon.dsobuildsim.items.core;

import com.langleon.dsobuildsim.enchantments.Enchantment;
import com.langleon.dsobuildsim.enchantments.EnchantmentDefinition;
import com.langleon.dsobuildsim.enums.CharacterClass;
import com.langleon.dsobuildsim.enums.StatType;
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

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class ItemFactory {
    private final MythicItemConfig mythicItemConfig;
    private final UniqueItemConfig uniqueItemConfig;
    private final SetItemConfig setItemConfig;
    private final LevelMultiplierTable levelMultiplierTable;

    public ItemFactory(MythicItemConfig mythicItemConfig, UniqueItemConfig uniqueItemConfig, SetItemConfig setItemConfig, LevelMultiplierTable levelMultiplierTable) {
        this.mythicItemConfig = mythicItemConfig;
        this.uniqueItemConfig = uniqueItemConfig;
        this.setItemConfig = setItemConfig;
        this.levelMultiplierTable = levelMultiplierTable;
    }

    public MythicItem createItem(MythicItemType itemType, CharacterClass characterClass)
    {
        MythicItemDefinition itemDefinition = this.getDefinitionForClass(characterClass, mythicItemConfig.spellweaverItems(), mythicItemConfig.dragonknightItems(), mythicItemConfig.rangerItems(), mythicItemConfig.steamMechanicusItems(), itemType);
        return new MythicItem(itemDefinition, levelMultiplierTable, itemDefinition.uniqueRelativeValues(), itemDefinition.uniqueAbsoluteValues(), itemDefinition.set());
    }

    public UniqueItem createItem(UniqueItemType itemType, CharacterClass characterClass)
    {
        UniqueItemDefinition itemDefinition = this.getDefinitionForClass(characterClass, uniqueItemConfig.spellweaverItems(), uniqueItemConfig.dragonknightItems(), uniqueItemConfig.rangerItems(), uniqueItemConfig.steamMechanicusItems(), itemType);
        List<Enchantment> uniqueEnchantments = itemDefinition.uniqueEnchantments().stream().map(EnchantmentDefinition::toEnchantment).toList();
        return new UniqueItem(itemDefinition, levelMultiplierTable, itemDefinition.uniqueBaseValues(), itemDefinition.uniqueRelativeValues(), uniqueEnchantments, itemDefinition.uniqueDescription());
    }

    public SetItem createItem(SetItemType itemType, CharacterClass characterClass)
    {
        SetItemDefinition itemDefinition = this.getDefinitionForClass(characterClass, setItemConfig.spellweaverItems(), setItemConfig.dragonknightItems(), setItemConfig.rangerItems(), setItemConfig.steamMechanicusItems(), itemType);
        return new SetItem(itemDefinition, levelMultiplierTable,  itemDefinition.set());
    }

    private <K, T> T getDefinitionForClass(CharacterClass characterClass, Map<K, T> spellweaverItems, Map<K, T> dragonknightItems, Map<K, T> rangerItems, Map<K, T> steamMechanicusItems, K itemType)
    {
        return switch (characterClass)
        {
            case SPELLWEAVER -> spellweaverItems.get(itemType);
            case DRAGONKNIGHT -> dragonknightItems.get(itemType);
            case RANGER -> rangerItems.get(itemType);
            case STEAM_MECHANICUS -> steamMechanicusItems.get(itemType);
            default -> throw new IllegalArgumentException("Unsupported character class: " + characterClass);
        };
    }
}
