package com.langleon.dsobuildsim.sets;

import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.utils.MapUtils;

import java.util.*;

public class SetInstance {
    private final SetType setType;
    private final String name;
    private final int level;
    private final Set<String> setItems;
    private final Map<Integer, Map<StatType, Double>> baseValuesPerTier;
    private final Map<Integer, Map<StatType, Double>> relativeValuesPerTier;
    private final Map<Integer, String> descriptionPerTier;
    private final List<String> equippedSetItems;

    public SetInstance(SetType setType, String name, int level, Set<String> setItems, Map<Integer, Map<StatType, Double>> baseValuesPerTier, Map<Integer, Map<StatType, Double>> relativeValuesPerTier, Map<Integer, String> descriptionPerTier) {
        this.setType = setType;
        this.name = name;
        this.level = level;
        this.setItems = setItems;
        this.baseValuesPerTier = baseValuesPerTier;
        this.relativeValuesPerTier = relativeValuesPerTier;
        this.descriptionPerTier = descriptionPerTier;
        this.equippedSetItems = new ArrayList<>();
    }

    public SetType getSetType() {
        return setType;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public Set<String> getSetItems() {
        return setItems;
    }

    public Map<Integer, Map<StatType, Double>> getBaseValuesPerTier() {
        return baseValuesPerTier;
    }

    public Map<StatType, Double> getBaseValues(int tier)
    {
        return baseValuesPerTier.get(tier);
    }

    public void updateBaseValues(Map<StatType, Double> stats, int tier)
    {
        if (this.baseValuesPerTier.containsKey(tier))
        {
            MapUtils.replaceExisting(this.baseValuesPerTier.get(tier), stats);
        }
        else
        {
            throw new IllegalArgumentException("No set bonus for "+tier+" items equipped.");
        }
    }

    public Map<Integer, Map<StatType, Double>> getRelativeValuesPerTier() {
        return relativeValuesPerTier;
    }

    public Map<Integer, String> getDescriptionPerTier() {
        return descriptionPerTier;
    }

    public List<String> getEquippedSetItems() {
        return equippedSetItems;
    }

    public void addSetItem(String name)
    {
        if(this.setItems.contains(name))
        {
            this.equippedSetItems.add(name);
        }
        else
        {
            throw new IllegalArgumentException(name+" isn't part of this set!");
        }
    }

    public void removeSetItem(String name)
    {
        this.equippedSetItems.remove(name);
    }

    public int getCurrentSetBonusLevel()
    {
        return new HashSet<>(this.equippedSetItems).size();
    }

    public Map<StatType, Double> getActiveBaseValues()
    {
        int equippedSetItems = getCurrentSetBonusLevel();
        Map<StatType, Double> totalBaseValues = new EnumMap<>(StatType.class);

        for (int i=1; i<=equippedSetItems; i++)
        {
            Map<StatType, Double> currentTierStats = baseValuesPerTier.get(i);
            if (currentTierStats == null) continue;

            currentTierStats.forEach(
                    (stat, value) -> totalBaseValues.merge(stat, value, Double::sum)
            );
        }

        return totalBaseValues;
    }

    public Map<StatType, Double> getActiveRelativeValues() {
        int equippedSetItems = getCurrentSetBonusLevel();
        Map<StatType, Double> totalRelativeValues = new EnumMap<>(StatType.class);

        for (int i = 1; i <= equippedSetItems; i++) {
            Map<StatType, Double> currentTierStats = relativeValuesPerTier.get(i);
            if (currentTierStats == null) continue;

            currentTierStats.forEach(
                    (stat, value) -> totalRelativeValues.merge(stat, value, Double::sum)
            );
        }

        return totalRelativeValues;
    }

}