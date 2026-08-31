package com.langleon.dsobuildsim.items.core;

import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.enchantments.Enchantment;
import com.langleon.dsobuildsim.character.CharacterClass;
import com.langleon.dsobuildsim.enchantments.EnchantmentDefinition;
import com.langleon.dsobuildsim.exceptions.LimitExceededException;
import com.langleon.dsobuildsim.exceptions.LimitType;
import com.langleon.dsobuildsim.gamedata.GameDataConfig;
import com.langleon.dsobuildsim.gamedata.LevelMultiplierTable;
import com.langleon.dsobuildsim.gems.AbstractGem;
import com.langleon.dsobuildsim.items.mythicitems.MythicItemType;
import com.langleon.dsobuildsim.items.setitems.SetItemType;
import com.langleon.dsobuildsim.items.uniqueitems.UniqueItemType;
import com.langleon.dsobuildsim.items.mythicitems.MythicItem;
import com.langleon.dsobuildsim.items.mythicitems.MythicItemDefinition;
import com.langleon.dsobuildsim.items.setitems.SetItem;
import com.langleon.dsobuildsim.items.setitems.SetItemDefinition;
import com.langleon.dsobuildsim.items.uniqueitems.UniqueItem;
import com.langleon.dsobuildsim.items.uniqueitems.UniqueItemDefinition;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ItemFactory {
    private final Map<CharacterClass, Map<MythicItemType, MythicItemDefinition>> mythicItems;
    private final Map<CharacterClass, Map<SetItemType, SetItemDefinition>> setItems;
    private final Map<CharacterClass, Map<UniqueItemType, UniqueItemDefinition>> uniqueItems;
    private final LevelMultiplierTable levelMultiplierTable;
    private static final double EPSILON = 0.002;

    public ItemFactory(GameDataConfig config) {
        this.mythicItems = config.mythicItems();
        this.setItems = config.setItems();
        this.uniqueItems = config.uniqueItems();
        this.levelMultiplierTable = config.levelMultiplierTable();
    }

    public MythicItem createItem(MythicItemType itemType, CharacterClass characterClass, Map<StatType, Double> baseValues, int level, List<AbstractGem> gems, List<Enchantment> enchantments)
    {
        MythicItemDefinition itemDefinition = this.mythicItems.get(characterClass).get(itemType);
        this.validateBaseValues(itemDefinition, level, baseValues);
        return new MythicItem(itemDefinition, baseValues, level, gems, enchantments);
    }

    public UniqueItem createItem(UniqueItemType itemType, CharacterClass characterClass, Map<StatType, Double> baseValues, int level, List<AbstractGem> gems, List<Enchantment> enchantments, Map<StatType, Double> uniqueBaseValues, List<Enchantment> uniqueEnchantments)
    {
        UniqueItemDefinition itemDefinition = this.uniqueItems.get(characterClass).get(itemType);
        this.validateBaseValues(itemDefinition, level, baseValues);
        this.validateUniqueBaseValues(itemDefinition, uniqueBaseValues);
        this.validateUniqueEnchantments(itemDefinition, uniqueEnchantments);
        return new UniqueItem(itemDefinition, baseValues, level, gems, enchantments, uniqueBaseValues, uniqueEnchantments);
    }

    public SetItem createItem(SetItemType itemType, CharacterClass characterClass, Map<StatType, Double> baseValues, int level, List<AbstractGem> gems, List<Enchantment> enchantments)
    {
        SetItemDefinition itemDefinition = this.setItems.get(characterClass).get(itemType);
        this.validateBaseValues(itemDefinition, level, baseValues);
        return new SetItem(itemDefinition, baseValues, level, gems, enchantments);
    }

    private void validateBaseValues(ItemDefinition itemDefinition, int level, Map<StatType, Double> actualBaseValues)
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
                throw new LimitExceededException(
                        LimitType.ITEM_BASE_VALUES,
                        "Stat " + stat + " value " + actual + " exceeds allowed value " + allowed
                );
            }
        }
    }

    private void validateUniqueBaseValues(UniqueItemDefinition itemDefinition, Map<StatType, Double> actualBaseValues)
    {
        Map<StatType, Double> allowedBaseValues = itemDefinition.uniqueBaseValues();

        if (!allowedBaseValues.keySet().equals(actualBaseValues.keySet())) throw new IllegalArgumentException("Stat keys do not match allowed stats");

        for (StatType stat : allowedBaseValues.keySet()) {
            double allowed = allowedBaseValues.get(stat);
            double actual = actualBaseValues.get(stat);
            if (actual - allowed > EPSILON) {
                throw new LimitExceededException(
                        LimitType.ITEM_BASE_VALUES,
                        "Stat " + stat + " value " + actual + " exceeds allowed value " + allowed
                );
            }
        }
    }

    private void validateUniqueEnchantments(UniqueItemDefinition itemDefinition, List<Enchantment> enchantments)
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
                throw new LimitExceededException(
                        LimitType.ENCHANTMENT,
                        "Enchant " + e.getStatType() + " value " + e.getValue() + " exceeds allowed value " + max);
            }
        }
    }
}
