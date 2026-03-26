package com.langleon.dsobuildsim.items.core;

import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.enchantments.Enchantment;
import com.langleon.dsobuildsim.character.CharacterClass;
import com.langleon.dsobuildsim.enchantments.EnchantmentDefinition;
import com.langleon.dsobuildsim.gamedata.LevelMultiplierTable;
import com.langleon.dsobuildsim.items.mythicitems.MythicItemType;
import com.langleon.dsobuildsim.items.setitems.SetItemType;
import com.langleon.dsobuildsim.items.uniqueitems.UniqueItemType;
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
import java.util.stream.Collectors;

public class ItemFactory {
    private final MythicItemConfig mythicItemConfig;
    private final UniqueItemConfig uniqueItemConfig;
    private final SetItemConfig setItemConfig;
    private final LevelMultiplierTable levelMultiplierTable;
    private static final double EPSILON = 0.002;

    public ItemFactory(MythicItemConfig mythicItemConfig, UniqueItemConfig uniqueItemConfig, SetItemConfig setItemConfig, LevelMultiplierTable levelMultiplierTable) {
        this.mythicItemConfig = mythicItemConfig;
        this.uniqueItemConfig = uniqueItemConfig;
        this.setItemConfig = setItemConfig;
        this.levelMultiplierTable = levelMultiplierTable;
    }

    public MythicItem createItem(MythicItemType itemType, CharacterClass characterClass, Map<StatType, Double> baseValues, int level)
    {
        MythicItemDefinition itemDefinition = this.getDefinitionForClass(characterClass, mythicItemConfig.spellweaverItems(), mythicItemConfig.dragonknightItems(), mythicItemConfig.rangerItems(), mythicItemConfig.steamMechanicusItems(), itemType);
        this.checkBaseValues(itemDefinition, level, baseValues);
        return new MythicItem(itemDefinition, baseValues, level);
    }

    public UniqueItem createItem(UniqueItemType itemType, CharacterClass characterClass, Map<StatType, Double> baseValues, int level, Map<StatType, Double> uniqueBaseValues, List<Enchantment> uniqueEnchantments)
    {
        UniqueItemDefinition itemDefinition = this.getDefinitionForClass(characterClass, uniqueItemConfig.spellweaverItems(), uniqueItemConfig.dragonknightItems(), uniqueItemConfig.rangerItems(), uniqueItemConfig.steamMechanicusItems(), itemType);
        this.checkBaseValues(itemDefinition, level, baseValues);
        this.checkUniqueBaseValues(itemDefinition, uniqueBaseValues);
        this.checkUniqueEnchantments(itemDefinition, uniqueEnchantments);
        return new UniqueItem(itemDefinition, baseValues, level, uniqueBaseValues, uniqueEnchantments);
    }

    public SetItem createItem(SetItemType itemType, CharacterClass characterClass, Map<StatType, Double> baseValues, int level)
    {
        SetItemDefinition itemDefinition = this.getDefinitionForClass(characterClass, setItemConfig.spellweaverItems(), setItemConfig.dragonknightItems(), setItemConfig.rangerItems(), setItemConfig.steamMechanicusItems(), itemType);
        this.checkBaseValues(itemDefinition, level, baseValues);
        return new SetItem(itemDefinition, baseValues, level);
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

    private void checkBaseValues(ItemDefinition itemDefinition, int level, Map<StatType, Double> actualBaseValues)
    {
        Map<StatType, Double> allowedBaseValues = new EnumMap<>(StatType.class);

        itemDefinition.rawBaseValues().forEach((statType, value) ->
                allowedBaseValues.put(statType, value * levelMultiplierTable.getMultiplier(level, statType))
        );

        if (!allowedBaseValues.keySet().equals(actualBaseValues.keySet())) throw new IllegalArgumentException("Stat keys do not match allowed stats");

        for (StatType stat : allowedBaseValues.keySet()) {
            double allowed = allowedBaseValues.get(stat);
            double actual = actualBaseValues.get(stat);
            if (actual - allowed > EPSILON) {
                throw new IllegalArgumentException(
                        "Stat " + stat + " value " + actual + " exceeds allowed " + allowed
                );
            }
        }
    }

    private void checkUniqueBaseValues(UniqueItemDefinition itemDefinition, Map<StatType, Double> actualBaseValues)
    {
        Map<StatType, Double> allowedBaseValues = itemDefinition.uniqueBaseValues();

        if (!allowedBaseValues.keySet().equals(actualBaseValues.keySet())) throw new IllegalArgumentException("Stat keys do not match allowed stats");

        for (StatType stat : allowedBaseValues.keySet()) {
            double allowed = allowedBaseValues.get(stat);
            double actual = actualBaseValues.get(stat);
            if (actual - allowed > EPSILON) {
                throw new IllegalArgumentException(
                        "Stat " + stat + " value " + actual + " exceeds allowed " + allowed
                );
            }
        }
    }

    private void checkUniqueEnchantments(UniqueItemDefinition itemDefinition, List<Enchantment> enchantments)
    {
        if (enchantments.size() != itemDefinition.uniqueEnchantments().size()) throw new IllegalArgumentException("Unique enchantment amount invalid");

        Map<StatType, Double> allowedEnchantmentStats = itemDefinition.uniqueEnchantments().stream()
                .collect(Collectors.toMap(EnchantmentDefinition::statType, EnchantmentDefinition::value));

        for (Enchantment e : enchantments) {
            if (!allowedEnchantmentStats.containsKey(e.getStatType())) {
                throw new IllegalArgumentException("Invalid unique enchant stat: " + e.getStatType());
            }

            double max = allowedEnchantmentStats.get(e.getStatType());
            if (e.getValue() - max > EPSILON) {
                throw new IllegalArgumentException(
                        "Enchant " + e.getStatType() + " value " + e.getValue() + " exceeds max allowed " + max
                );
            }
        }
    }
}
