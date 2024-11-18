package kaukasus.Items;

import kaukasus.Enchants.Enchant;
import kaukasus.Enchants.UniqueEnchant;
import kaukasus.Enums.AbsoluteStatTypeEnum;
import kaukasus.Enums.ItemTypeEnum;
import kaukasus.Enums.SetTypeEnum;
import kaukasus.Gems.AbstractGem;
import kaukasus.Gems.Gem;
import kaukasus.Gems.Opal;
import kaukasus.Mapper.EnchantToAbsoluteStatTypeMapper;
import kaukasus.OverallBuffs.OverallBuff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MythicItem extends AbstractItem{
    private Map<AbsoluteStatTypeEnum, Double> uniqueBaseStat;
    private List<UniqueEnchant> uniqueEnchants;
    private List<OverallBuff> overallBuffs;
    private SetTypeEnum set;

    public MythicItem(String name, ItemTypeEnum itemType, Map<AbsoluteStatTypeEnum, Double> baseStats, Map<AbsoluteStatTypeEnum, Double> uniqueBaseStats, List<UniqueEnchant> uniqueEnchants, List<OverallBuff> overallBuffs, SetTypeEnum set){
        this.name = name;
        this.itemType = itemType;
        this.baseStats = baseStats;
        this.gems = new ArrayList<>();
        this.enchants = new ArrayList<>();
        this.uniqueBaseStat = uniqueBaseStats;
        this.uniqueEnchants = uniqueEnchants;
        this.overallBuffs = overallBuffs;
        this.set = set;
    }

    public SetTypeEnum getSet() {
        return set;
    }

    @Override
    public Map<AbsoluteStatTypeEnum, Double> getBaseStats() {
        return super.getBaseStats();
    }

    @Override
    public void setBaseStats(Map<AbsoluteStatTypeEnum, Double> baseStats) {
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

    public Map<AbsoluteStatTypeEnum, Double> getUniqueBaseStat() {
        return uniqueBaseStat;
    }

    public void setUniqueBaseStat(Map<AbsoluteStatTypeEnum, Double> uniqueBaseStat) {
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
    public Map<AbsoluteStatTypeEnum, Double> calculateTotalStats() {
        Map<AbsoluteStatTypeEnum, Double> totalAbsoluteStats = new HashMap<>();
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
        for (Map.Entry<AbsoluteStatTypeEnum, Double> entry : this.uniqueBaseStat.entrySet()){
            if (totalAbsoluteStats.containsKey(entry.getKey())){
                Double gemValue = entry.getValue();
                Double totalValueOld = totalAbsoluteStats.get(entry.getKey());
                totalAbsoluteStats.put(entry.getKey(), gemValue+totalValueOld);
            }else{
                totalAbsoluteStats.put(entry.getKey(), entry.getValue());
            }
        }

        Map<AbsoluteStatTypeEnum, Double> finalAbsoluteStats = new HashMap<>(totalAbsoluteStats);

        for (Enchant enchant : this.enchants){
            AbsoluteStatTypeEnum baseValueType = EnchantToAbsoluteStatTypeMapper.getAbsoluteType(enchant.getType());
            finalAbsoluteStats.put(baseValueType, finalAbsoluteStats.get(baseValueType)+ totalAbsoluteStats.get(baseValueType)*enchant.getValue());
        }
        for (UniqueEnchant uniqueEnchant : this.uniqueEnchants){
            AbsoluteStatTypeEnum baseValueType = EnchantToAbsoluteStatTypeMapper.getAbsoluteType(uniqueEnchant.getType());
            finalAbsoluteStats.put(baseValueType, finalAbsoluteStats.get(baseValueType)+ totalAbsoluteStats.get(baseValueType)*uniqueEnchant.getValue());
        }
        return finalAbsoluteStats;
    }
}

