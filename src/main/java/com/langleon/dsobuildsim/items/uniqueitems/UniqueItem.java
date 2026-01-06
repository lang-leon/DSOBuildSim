package com.langleon.dsobuildsim.items.uniqueitems;

import com.langleon.dsobuildsim.enchantments.Enchant;
import com.langleon.dsobuildsim.enchantments.UniqueEnchant;
import com.langleon.dsobuildsim.enums.CharacterClass;
import com.langleon.dsobuildsim.enums.ItemSlotType;
import com.langleon.dsobuildsim.enums.StatType;
import com.langleon.dsobuildsim.gems.AbstractGem;
import com.langleon.dsobuildsim.items.core.AbstractItem;
import com.langleon.dsobuildsim.mapper.EnchantToAbsoluteStatTypeMapper;
import com.langleon.dsobuildsim.overallbuffs.OverallBuff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniqueItem extends AbstractItem {

    private Map<StatType, Double> uniqueBaseStat;
    private List<UniqueEnchant> uniqueEnchants;
    private List<OverallBuff> overallBuffs;

    public UniqueItem(String name, CharacterClass characterClass, ItemSlotType itemSlotType, Map<StatType, Double> baseStats, Map<StatType, Double> uniqueBaseStats, List<UniqueEnchant> uniqueEnchants, List<OverallBuff> overallBuffs, int itemLevel){
        this.name = name;
        this.characterClass = characterClass;
        this.itemSlotType = itemSlotType;
        this.baseStats = baseStats;
        this.gems = new ArrayList<>();
        this.enchants = new ArrayList<>();
        this.uniqueBaseStat = uniqueBaseStats;
        this.uniqueEnchants = uniqueEnchants;
        this.overallBuffs = overallBuffs;
        this.level = itemLevel;
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
    public void setEnchant(Enchant enchant) {
        super.setEnchant(enchant);
    }

    @Override
    public void removeEnchant(Enchant enchant) {
        super.removeEnchant(enchant);
    }

    public Map<StatType, Double> getUniqueBaseStat() {
        return uniqueBaseStat;
    }

    public void setUniqueBaseStat(Map<StatType, Double> uniqueBaseStat) {
        this.uniqueBaseStat = uniqueBaseStat;
    }

    public List<UniqueEnchant> getUniqueEnchants() {
        return uniqueEnchants;
    }

    public void setUniqueEnchants(List<UniqueEnchant> uniqueEnchants) {
        this.uniqueEnchants = uniqueEnchants;
    }

    public List<OverallBuff> getOverallBuffs() {
        return overallBuffs;
    }

    public void setOverallBuffs(List<OverallBuff> overallBuffs) {
        this.overallBuffs = overallBuffs;
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

        for (Map.Entry<StatType, Double> entry : this.uniqueBaseStat.entrySet()){
            if (totalAbsoluteStats.containsKey(entry.getKey())){
                Double uniqueBaseStat = entry.getValue();
                totalAbsoluteStats.compute(entry.getKey(), (k, totalValueOld) -> uniqueBaseStat + totalValueOld);
            }else{
                totalAbsoluteStats.put(entry.getKey(), entry.getValue());
            }
        }

        Map<StatType, Double> finalAbsoluteStats = new HashMap<>(totalAbsoluteStats);

        for (Enchant enchant : this.enchants){
            StatType baseValueType = EnchantToAbsoluteStatTypeMapper.getAbsoluteType(enchant.getType());
            finalAbsoluteStats.put(baseValueType, finalAbsoluteStats.get(baseValueType) + totalAbsoluteStats.get(baseValueType)*enchant.getValue());
        }
        for (UniqueEnchant uniqueEnchant : this.uniqueEnchants){
            StatType baseValueType = EnchantToAbsoluteStatTypeMapper.getAbsoluteType(uniqueEnchant.getType());
            finalAbsoluteStats.put(baseValueType, finalAbsoluteStats.get(baseValueType)+ totalAbsoluteStats.get(baseValueType)*uniqueEnchant.getValue());
        }

        return finalAbsoluteStats;
    }
}
