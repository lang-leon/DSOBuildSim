package com.langleon.dsobuildsim.items;

import com.langleon.dsobuildsim.enchantments.Enchant;
import com.langleon.dsobuildsim.enums.CharacterClass;
import com.langleon.dsobuildsim.enums.ItemType;
import com.langleon.dsobuildsim.enums.StatType;
import com.langleon.dsobuildsim.sets.SetEnumInterface;
import com.langleon.dsobuildsim.gems.AbstractGem;
import com.langleon.dsobuildsim.mapper.EnchantToAbsoluteStatTypeMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SetItem extends AbstractItem {
    private SetEnumInterface set;

    public SetItem(String name, CharacterClass characterClass, ItemType itemType, Map<StatType, Double> baseStats, int itemLevel, SetEnumInterface set){
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
    public Map<StatType, Double> getBaseStats() {
        return super.getBaseStats();
    }

    @Override
    public void setBaseStats(Map<StatType, Double> baseStats) {
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
    public Map<StatType, Double> calculateTotalStats() {
        Map<StatType, Double> totalAbsoluteStats = new HashMap<>(getBaseStats());

        for (Map.Entry<StatType, Double> entry : super.calculateGemStats().entrySet())
        {
            if (totalAbsoluteStats.containsKey(entry.getKey())){
                totalAbsoluteStats.compute(entry.getKey(), (k, totalValueOld) -> entry.getValue() + totalValueOld);
            }else{
                totalAbsoluteStats.put(entry.getKey(), entry.getValue());
            }
        }

        Map<StatType, Double> finalAbsoluteStats = new HashMap<>(totalAbsoluteStats);

        for (Enchant enchant : this.enchants){
            StatType baseValueType = EnchantToAbsoluteStatTypeMapper.getAbsoluteType(enchant.getType());
            finalAbsoluteStats.put(baseValueType, finalAbsoluteStats.get(baseValueType) + totalAbsoluteStats.get(baseValueType)*enchant.getValue());
        }

        return finalAbsoluteStats;
    }
}