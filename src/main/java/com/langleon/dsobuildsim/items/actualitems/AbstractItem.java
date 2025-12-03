package com.langleon.dsobuildsim.items.actualitems;

import com.langleon.dsobuildsim.enchantments.Enchant;
import com.langleon.dsobuildsim.enums.AbsoluteStatType;
import com.langleon.dsobuildsim.enums.CharacterClass;
import com.langleon.dsobuildsim.enums.EnchantType;
import com.langleon.dsobuildsim.enums.ItemType;
import com.langleon.dsobuildsim.gems.AbstractGem;
import com.langleon.dsobuildsim.gems.Gem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractItem {
    protected String name;
    protected ItemType itemType;
    protected Map<AbsoluteStatType, Double> baseStats;
    protected List<Enchant> enchants;
    protected List<AbstractGem> gems;
    protected int itemLevel;
    protected CharacterClass characterClass;

    public String getName()
    {
        return name;
    }

    public ItemType getItemType()
    {
        return this.itemType;
    }

    public Map<AbsoluteStatType, Double> getBaseStats()
    {
        return baseStats;
    }

    public void setBaseStats(Map<AbsoluteStatType, Double> baseStats)
    {
        this.baseStats = baseStats;
    }

    public List<AbstractGem> getGems() {
        return gems;
    }

    public void addGem(AbstractGem gem)
    {
        if (this.gems.size()<10){
            this.gems.add(gem);
        }else{
            throw new IllegalArgumentException("Can't add more than 10 gems per item.");
        }
    }

    public void addGems(AbstractGem gem, int amount)
    {
        if (amount>0 && amount<=10)
        {
            for (int i=0; i<amount; i++)
            {
                addGem(gem);
            }
        }
    }

    public void setGems(Gem gem)
    {
        this.gems.clear();
        for (int i=0; i<10; i++) this.addGem(gem.copyGem());
    }

    public void removeGem(AbstractGem gem)
    {
        this.gems.remove(gem);
    }

    public Map<AbsoluteStatType, Double> calculateGemStats()
    {
        Map<AbsoluteStatType, Double> stats = new HashMap<>();
        for (AbstractGem gem : this.getGems()){
            for (Map.Entry<AbsoluteStatType, Double> stat : gem.getStats().entrySet())
            {
                if (stats.containsKey(stat.getKey())){
                    Double gemValue = stat.getValue();
                    stats.compute(stat.getKey(), (k, totalValueOld) -> gemValue + totalValueOld);
                }else{
                    stats.put(stat.getKey(), stat.getValue());
                }
            }
        }
        return stats;
    }

    public List<Enchant> getEnchants()
    {
        return enchants;
    }

    public void addEnchant(Enchant enchant)
    {
        if (this.enchants.size()<4){
            this.enchants.add(enchant);
        }
    }

    public void addEnchant(EnchantType type)
    {
        this.addEnchant(new Enchant(type, type.getMaxValue()));
    }

    public void setEnchants(EnchantType type)
    {
        this.enchants.clear();
        for (int i=0; i<4; i++) this.enchants.add(new Enchant(type, type.getMaxValue()));
    }

    public void addEnchants(Enchant enchant, int amount)
    {
        if (amount>0 && amount<=4)
        {
            for (int i=0; i<amount; i++)
            {
                this.enchants.add(enchant.copyEnchant());
            }
        }
    }

    public void removeEnchant(Enchant enchant)
    {
        this.enchants.remove(enchant);
    }

    public int getItemLevel() {
        return itemLevel;
    }

    public void setItemLevel(int itemLevel) {
        this.itemLevel = itemLevel;
    }

    public CharacterClass getCharacterClass() {
        return characterClass;
    }

    public abstract Map<AbsoluteStatType, Double> calculateTotalStats();
}