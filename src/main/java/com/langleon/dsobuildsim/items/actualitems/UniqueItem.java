package com.langleon.dsobuildsim.items.actualitems;

import com.langleon.dsobuildsim.enchantments.Enchant;
import com.langleon.dsobuildsim.enchantments.UniqueEnchant;
import com.langleon.dsobuildsim.enums.AbsoluteStatType;
import com.langleon.dsobuildsim.enums.CharacterClass;
import com.langleon.dsobuildsim.enums.ItemType;
import com.langleon.dsobuildsim.gems.AbstractGem;
import com.langleon.dsobuildsim.gems.Gem;
import com.langleon.dsobuildsim.gems.Opal;
import com.langleon.dsobuildsim.mapper.EnchantToAbsoluteStatTypeMapper;
import com.langleon.dsobuildsim.overallbuffs.OverallBuff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniqueItem extends AbstractItem {

    private Map<AbsoluteStatType, Double> uniqueBaseStat;
    private List<UniqueEnchant> uniqueEnchants;
    private List<OverallBuff> overallBuffs;

    public UniqueItem(String name, CharacterClass characterClass, ItemType itemType, Map<AbsoluteStatType, Double> baseStats, Map<AbsoluteStatType, Double> uniqueBaseStats, List<UniqueEnchant> uniqueEnchants, List<OverallBuff> overallBuffs, int itemLevel){
        this.name = name;
        this.characterClass = characterClass;
        this.itemType = itemType;
        this.baseStats = baseStats;
        this.gems = new ArrayList<>();
        this.enchants = new ArrayList<>();
        this.uniqueBaseStat = uniqueBaseStats;
        this.uniqueEnchants = uniqueEnchants;
        this.overallBuffs = overallBuffs;
        this.itemLevel = itemLevel;
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

    public Map<AbsoluteStatType, Double> getUniqueBaseStat() {
        return uniqueBaseStat;
    }

    public void setUniqueBaseStat(Map<AbsoluteStatType, Double> uniqueBaseStat) {
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
    public Map<AbsoluteStatType, Double> calculateTotalStats() {
        Map<AbsoluteStatType, Double> totalAbsoluteStats = new HashMap<>();
        totalAbsoluteStats.putAll(getBaseStats());

        for (AbstractGem gem : this.getGems()){
            if (gem instanceof Gem){
                if (totalAbsoluteStats.containsKey(gem.getType())){
                    Double gemValue = gem.getValue();
                    Double totalValueOld = totalAbsoluteStats.get(gem.getType());
                    totalAbsoluteStats.put(gem.getType(), gemValue+totalValueOld);
                }else{
                    totalAbsoluteStats.put(gem.getType(), gem.getValue());
                }
            }else if (gem instanceof Opal){
                for (Gem gem2 : ((Opal) gem).getGems()){
                    if (totalAbsoluteStats.containsKey(gem2.getType())){
                        Double gemValue = gem2.getValue();
                        Double totalValueOld = totalAbsoluteStats.get(gem2.getType());
                        totalAbsoluteStats.put(gem2.getType(), gemValue+totalValueOld);
                    }else{
                        totalAbsoluteStats.put(gem2.getType(), gem2.getValue());
                    }
                }
            }
        }
        for (Map.Entry<AbsoluteStatType, Double> entry : this.uniqueBaseStat.entrySet()){
            if (totalAbsoluteStats.containsKey(entry.getKey())){
                Double uniqueBaseStat = entry.getValue();
                Double totalValueOld = totalAbsoluteStats.get(entry.getKey());
                totalAbsoluteStats.put(entry.getKey(), uniqueBaseStat+totalValueOld);
            }else{
                totalAbsoluteStats.put(entry.getKey(), entry.getValue());
            }
        }

        Map<AbsoluteStatType, Double> finalAbsoluteStats = new HashMap<>(totalAbsoluteStats);

        for (Enchant enchant : this.enchants){
            AbsoluteStatType baseValueType = EnchantToAbsoluteStatTypeMapper.getAbsoluteType(enchant.getType());
            finalAbsoluteStats.put(baseValueType, finalAbsoluteStats.get(baseValueType) + totalAbsoluteStats.get(baseValueType)*enchant.getValue());
        }
        for (UniqueEnchant uniqueEnchant : this.uniqueEnchants){
            AbsoluteStatType baseValueType = EnchantToAbsoluteStatTypeMapper.getAbsoluteType(uniqueEnchant.getType());
            finalAbsoluteStats.put(baseValueType, finalAbsoluteStats.get(baseValueType)+ totalAbsoluteStats.get(baseValueType)*uniqueEnchant.getValue());
        }

        return finalAbsoluteStats;
    }
}
