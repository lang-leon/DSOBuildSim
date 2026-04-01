package com.langleon.dsobuildsim.items.core;

import com.langleon.dsobuildsim.enchantments.Enchantment;
import com.langleon.dsobuildsim.items.core.enums.ItemSlotType;
import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.gems.AbstractGem;
import com.langleon.dsobuildsim.items.core.enums.ItemType;
import com.langleon.dsobuildsim.utils.MapUtils;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public abstract class Item {
    protected int level;
    protected final ItemSlotType itemSlotType;
    protected Map<StatType, Double> baseValues;
    protected List<Enchantment> enchantments;
    protected List<AbstractGem> gems;

    public Item(ItemSlotType itemSlotType, Map<StatType, Double> actualBaseValues, int level, List<AbstractGem> gems, List<Enchantment> enchantments) {
        this.itemSlotType = itemSlotType;
        this.baseValues = new EnumMap<>(actualBaseValues);
        this.level = level;
        if (gems.size() > 10) throw new IllegalArgumentException("Can't have more than 10 gems per item");
        this.gems = new ArrayList<>(gems);
        if (enchantments.size() > 4) throw new IllegalArgumentException("Can't have more than 4 enchantments per item");
        this.enchantments = new ArrayList<>(enchantments);
    }

    public abstract ItemType getItemType();

    public Map<StatType, Double> getBaseValues()
    {
        return baseValues;
    }

    public List<AbstractGem> getGems() {
        return gems;
    }

    public List<Enchantment> getEnchantments()
    {
        return enchantments;
    }

    public int getLevel() {
        return level;
    }

    public ItemSlotType getItemSlotType()
    {
        return this.itemSlotType;
    }

    public Map<StatType, Double> calculateGemStats()
    {
        Map<StatType, Double> stats = new EnumMap<>(StatType.class);
        gems.forEach(gem -> {
            gem.getStats().forEach((type, value) -> {
                stats.merge(type, value, Double::sum);
            });
        });
        return stats;
    }

    public Map<StatType, Double> calculateEnchantStats()
    {
        Map<StatType, Double> totalEnchants = new EnumMap<>(StatType.class);
        enchantments.forEach(enchantment -> {
            totalEnchants.merge(enchantment.getStatType(), enchantment.getValue(), Double::sum);
        });
        return totalEnchants;
    }

    public abstract Map<StatType, Double> calculateTotalStats();
}