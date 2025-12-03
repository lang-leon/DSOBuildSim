package com.langleon.dsobuildsim.items.actualitems;

import com.langleon.dsobuildsim.enchantments.Enchant;
import com.langleon.dsobuildsim.enums.AbsoluteStatType;
import com.langleon.dsobuildsim.enums.CharacterClass;
import com.langleon.dsobuildsim.enums.ItemType;
import com.langleon.dsobuildsim.sets.SetEnumInterface;
import com.langleon.dsobuildsim.gems.AbstractGem;
import com.langleon.dsobuildsim.gems.Gem;
import com.langleon.dsobuildsim.gems.Opal;
import com.langleon.dsobuildsim.mapper.EnchantToAbsoluteStatTypeMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SetItem extends AbstractItem {
    private SetEnumInterface set;

    public SetItem(String name, CharacterClass characterClass, ItemType itemType, Map<AbsoluteStatType, Double> baseStats, int itemLevel, SetEnumInterface set){
        this.name = name;
        this.characterClass = characterClass;
        this.itemType = itemType;
        this.baseStats = baseStats;
        this.set = set;
        this.gems = new ArrayList<>();
        this.enchants = new ArrayList<>();
        this.itemLevel = itemLevel;
    }

    public SetEnumInterface getSet() {
        return set;
    }

    @Override
    public Map<AbsoluteStatType, Double> getBaseStats() {
        return super.getBaseStats();
    }

    @Override
    public void setBaseStats(Map<AbsoluteStatType, Double> baseStats) {
        super.setBaseStats(baseStats);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public List<AbstractGem> getGems() {
        return super.getGems();
    }

    @Override
    public List<Enchant> getEnchants() {
        return super.getEnchants();
    }

    @Override
    public void addEnchant(Enchant enchant) {
        super.addEnchant(enchant);
    }

    @Override
    public void removeEnchant(Enchant enchant) {
        super.removeEnchant(enchant);
    }

    @Override
    public Map<AbsoluteStatType, Double> calculateTotalStats() {
        Map<AbsoluteStatType, Double> totalAbsoluteStats = new HashMap<>(getBaseStats());

        for (Map.Entry<AbsoluteStatType, Double> entry : super.calculateGemStats().entrySet())
        {
            if (totalAbsoluteStats.containsKey(entry.getKey())){
                totalAbsoluteStats.compute(entry.getKey(), (k, totalValueOld) -> entry.getValue() + totalValueOld);
            }else{
                totalAbsoluteStats.put(entry.getKey(), entry.getValue());
            }
        }

        Map<AbsoluteStatType, Double> finalAbsoluteStats = new HashMap<>(totalAbsoluteStats);

        for (Enchant enchant : this.enchants){
            AbsoluteStatType baseValueType = EnchantToAbsoluteStatTypeMapper.getAbsoluteType(enchant.getType());
            finalAbsoluteStats.put(baseValueType, finalAbsoluteStats.get(baseValueType) + totalAbsoluteStats.get(baseValueType)*enchant.getValue());
        }

        return finalAbsoluteStats;
    }
}