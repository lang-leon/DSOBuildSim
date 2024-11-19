package kaukasus.Items;

import kaukasus.Enchants.Enchant;
import kaukasus.Enums.AbsoluteStatTypeEnum;
import kaukasus.Enums.ItemTypeEnum;
import kaukasus.Gems.AbstractGem;

import java.util.List;
import java.util.Map;

public abstract class AbstractItem {
    protected String name;
    protected ItemTypeEnum itemType;
    protected Map<AbsoluteStatTypeEnum, Double> baseStats;
    protected List<Enchant> enchants;
    protected List<AbstractGem> gems;

    public String getName()
    {
        return name;
    }

    public ItemTypeEnum getItemType()
    {
        return this.itemType;
    }

    public Map<AbsoluteStatTypeEnum, Double> getBaseStats()
    {
        return baseStats;
    }

    public void setBaseStats(Map<AbsoluteStatTypeEnum, Double> baseStats)
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
                addGem(gem.copyGem());
            }
        }
    }

    public void removeGem(AbstractGem gem)
    {
        this.gems.remove(gem);
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

    public abstract Map<AbsoluteStatTypeEnum, Double> calculateTotalStats();
}