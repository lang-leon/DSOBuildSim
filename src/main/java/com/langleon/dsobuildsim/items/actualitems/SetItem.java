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
        Map<AbsoluteStatType, Double> finalAbsoluteStats = new HashMap<>(totalAbsoluteStats);

        for (Enchant enchant : this.enchants){
            AbsoluteStatType baseValueType = EnchantToAbsoluteStatTypeMapper.getAbsoluteType(enchant.getType());
            finalAbsoluteStats.put(baseValueType, finalAbsoluteStats.get(baseValueType) + totalAbsoluteStats.get(baseValueType)*enchant.getValue());
        }

        return finalAbsoluteStats;
    }
}