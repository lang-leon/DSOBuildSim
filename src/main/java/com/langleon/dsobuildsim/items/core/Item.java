package com.langleon.dsobuildsim.items.core;

import com.langleon.dsobuildsim.enchantments.Enchantment;
import com.langleon.dsobuildsim.enums.ItemSlotType;
import com.langleon.dsobuildsim.enums.StatType;
import com.langleon.dsobuildsim.enums.items.ItemType;
import com.langleon.dsobuildsim.gems.AbstractGem;
import com.langleon.dsobuildsim.utils.MapUtils;

import java.util.EnumMap;
import java.util.Map;

public abstract class Item {
    protected final ItemDefinition itemDefinition;
    protected final LevelMultiplierTable levelMultipliers;
    protected int level;
    protected Map<StatType, Double> baseValues;
    protected Enchantment[] enchantments;
    protected AbstractGem[] gems;

    public Item(ItemDefinition itemDefinition, LevelMultiplierTable levelMultipliers) {
        this.itemDefinition = itemDefinition;
        this.levelMultipliers = levelMultipliers;
        this.level = itemDefinition.defaultLevel();
        this.baseValues = new EnumMap<>(StatType.class);
        this.itemDefinition.rawBaseValues().forEach((statType, value) ->
                baseValues.put(statType, value * this.levelMultipliers.getMultiplier(level, statType)));
        this.gems = new AbstractGem[10];
        this.enchantments = new Enchantment[10];
    }

    public String getName()
    {
        return this.itemDefinition.name();
    }

    public ItemType getItemType()
    {
        return this.itemDefinition.itemType();
    }

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

    public void setGem(AbstractGem gem, int slot)
    {
        if (slot>=0 && slot<10)
        {
            gems[slot] = gem;
        }else
        {
            throw new IllegalArgumentException("Invalid slot index!");
        }
    }

    public void setGems(AbstractGem gem)
    {
        for (int i=0; i<10; i++)
        {
            gems[i]=gem;
        }
    }

    public void removeGem(int slot)
    {
        if (slot>=0 && slot<10)
        {
            gems[slot] = null;
        }else
        {
            throw new IllegalArgumentException("Invalid slot index!");
        }
    }

    public void removeGems()
    {
        for (int i=0; i<10; i++)
        {
            gems[i]=null;
        }
    }

    public Enchantment[] getEnchants()
    {
        return enchantments;
    }

    public void setEnchant(Enchantment enchantment, int slot)
    {
        if (slot>=0 && slot<10)
        {
            enchantments[slot] = enchantment;
        }else
        {
            throw new IllegalArgumentException("Invalid slot index!");
        }
    }

    public void setEnchants(Enchantment enchantment)
    {
        for (int i=0; i<4; i++) enchantments[i] = enchantment;;
    }

    public void removeEnchant(int slot)
    {
        enchantments[slot] = null;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getTier()
    {
        return this.itemDefinition.tier();
    }

    public ItemSlotType getItemSlotType()
    {
        return this.itemDefinition.itemSlotType();
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