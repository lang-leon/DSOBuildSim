package kaukasus.Items;

import kaukasus.Enchants.Enchant;
import kaukasus.Enums.AbsoluteStatTypeEnum;
import kaukasus.Enums.EnchantTypeEnum;
import kaukasus.Enums.ItemTypeEnum;
import kaukasus.Enums.SetTypeEnum;
import kaukasus.Gems.AbstractGem;
import kaukasus.Gems.Gem;
import kaukasus.Gems.Opal;
import kaukasus.Mapper.EnchantToAbsoluteStatTypeMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SetItem extends AbstractItem{
    private SetTypeEnum set;

    public SetItem(String name, ItemTypeEnum itemType, Map<AbsoluteStatTypeEnum, Double> baseStats, SetTypeEnum set){
        this.name = name;
        this.itemType = itemType;
        this.baseStats = baseStats;
        this.set = set;
        this.gems = new ArrayList<>();
        this.enchants = new ArrayList<>();
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
        Map<AbsoluteStatTypeEnum, Double> finalAbsoluteStats = new HashMap<>(totalAbsoluteStats);

        for (Enchant enchant : this.enchants){
            AbsoluteStatTypeEnum baseValueType = EnchantToAbsoluteStatTypeMapper.getAbsoluteType(enchant.getType());
            finalAbsoluteStats.put(baseValueType, finalAbsoluteStats.get(baseValueType)+ totalAbsoluteStats.get(baseValueType)*enchant.getValue());
        }

        return finalAbsoluteStats;
    }
}