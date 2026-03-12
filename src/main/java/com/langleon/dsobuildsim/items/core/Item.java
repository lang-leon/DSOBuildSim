package com.langleon.dsobuildsim.items.core;

import com.langleon.dsobuildsim.enchantments.Enchantment;
import com.langleon.dsobuildsim.items.core.enums.ItemSlotType;
import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.gems.AbstractGem;
import com.langleon.dsobuildsim.utils.MapUtils;

import java.util.EnumMap;
import java.util.Map;

public abstract class Item {
    protected int level;
    protected final ItemSlotType itemSlotType;
    protected Map<StatType, Double> baseValues;
    protected Enchantment[] enchantments;
    protected AbstractGem[] gems;

    public Item(ItemSlotType itemSlotType, Map<StatType, Double> actualBaseValues, int level) {
        this.itemSlotType = itemSlotType;
        this.baseValues = new EnumMap<>(actualBaseValues);
        this.level = level;
        this.gems = new AbstractGem[10];
        this.enchantments = new Enchantment[4];
    }

    public abstract ItemType getItemType();

    public Map<StatType, Double> getBaseValues()
    {
        return baseValues;
    }

    public void updateBaseValues(Map<StatType, Double> newBaseValues)
    {
        MapUtils.replaceExisting(this.baseValues, newBaseValues);
    }

    public AbstractGem[] getGems() {
        return gems;
    }

    public void setGems(AbstractGem[] gems)
    {
        if (gems.length!=10) throw new IllegalArgumentException("Invalid array length!");
        this.gems = gems;
    }

    public Enchantment[] getEnchantments()
    {
        return enchantments;
    }

    public void setEnchantments(Enchantment[] enchantments)
    {
        if (enchantments.length!=4) throw new IllegalArgumentException("Invalid array length!");
        this.enchantments = enchantments;
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
        for (int i=0; i<10; i++){
            if (gems[i]!=null)
            {
                for(Map.Entry<StatType, Double> entry : gems[i].getStats().entrySet())
                {
                    stats.merge(entry.getKey(), entry.getValue(), Double::sum);
                }
            }
        }
        return stats;
    }

    public Map<StatType, Double> calculateEnchantStats()
    {
        Map<StatType, Double> totalEnchants = new EnumMap<>(StatType.class);
        for (int i=0; i<4; i++){
            if (enchantments[i]!=null)
            {
                totalEnchants.merge(enchantments[i].getStatType(), enchantments[i].getValue(), Double::sum);
            }
        }
        return totalEnchants;
    }

    public abstract Map<StatType, Double> calculateTotalStats();
}