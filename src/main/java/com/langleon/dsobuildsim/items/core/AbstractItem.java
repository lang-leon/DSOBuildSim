package com.langleon.dsobuildsim.items.core;

import com.langleon.dsobuildsim.enchantments.Enchantment;
import com.langleon.dsobuildsim.enums.ItemSlotType;
import com.langleon.dsobuildsim.enums.StatType;
import com.langleon.dsobuildsim.enums.items.ItemType;
import com.langleon.dsobuildsim.gems.AbstractGem;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractItem {
    protected ItemType itemType;
    protected String name;
    protected int level;
    protected int tier;
    protected ItemSlotType itemSlotType;
    protected Map<StatType, Double> baseValues;
    protected Enchantment[] enchantments;
    protected AbstractGem[] gems;

    public String getName()
    {
        return name;
    }

    public ItemType getItemType()
    {
        return this.itemType;
    }

    public Map<StatType, Double> getBaseValues()
    {
        return baseValues;
    }

    public void setBaseValues(Map<StatType, Double> baseValues)
    {
        this.baseValues = baseValues;
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
        return tier;
    }

    public ItemSlotType getItemSlotType()
    {
        return itemSlotType;
    }

    public Map<StatType, Double> calculateGemStats()
    {
        Map<StatType, Double> stats = new HashMap<>();
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
        Map<StatType, Double> totalEnchants = new HashMap<>();
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