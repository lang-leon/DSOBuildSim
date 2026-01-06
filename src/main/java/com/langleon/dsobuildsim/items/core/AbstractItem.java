package com.langleon.dsobuildsim.items.core;

import com.langleon.dsobuildsim.enchantments.Enchant;
import com.langleon.dsobuildsim.enums.EnchantType;
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
    protected Map<StatType, Double> baseStats;
    protected Enchant[] enchants;
    protected AbstractGem[] gems;

    public String getName()
    {
        return name;
    }

    public ItemSlotType getItemType()
    {
        return this.itemSlotType;
    }

    public Map<StatType, Double> getBaseStats()
    {
        return baseStats;
    }

    public void setBaseStats(Map<StatType, Double> baseStats)
    {
        this.baseStats = baseStats;
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

    public Enchant[] getEnchants()
    {
        return enchants;
    }

    public void setEnchant(Enchant enchant, int slot)
    {
        if (slot>=0 && slot<10)
        {
            enchants[slot] = enchant;
        }else
        {
            throw new IllegalArgumentException("Invalid slot index!");
        }
    }

    public void setEnchants(Enchant enchant)
    {
        for (int i=0; i<4; i++) enchants[i] = enchant;;
    }

    public void removeEnchant(int slot)
    {
        enchants[slot] = null;
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

    public Map<EnchantType, Double> calculateEnchantStats()
    {
        Map<EnchantType, Double> totalEnchants = new HashMap<>();
        for (int i=0; i<4; i++){
            if (enchants[i]!=null)
            {
                totalEnchants.merge(enchants[i].getType(), enchants[i].getValue(), Double::sum);
            }
        }
        return totalEnchants;
    }
    public abstract Map<StatType, Double> calculateTotalStats();
}