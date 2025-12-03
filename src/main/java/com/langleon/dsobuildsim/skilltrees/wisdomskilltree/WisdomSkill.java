package com.langleon.dsobuildsim.skilltrees.wisdomskilltree;

import com.langleon.dsobuildsim.enums.AbsoluteStatType;
import com.langleon.dsobuildsim.enums.OverallRelativeBuffType;

public enum WisdomSkill {

    RISING_VIGOR("Rising Vigor", 60, 3, 3250.0, AbsoluteStatType.HEALTH_POINTS, false, 0.0, ""),
    VIVACIOUS_VITALITY("Vivacious Vitality", 60, 3, 165.0,  AbsoluteStatType.HEALTH_PER_SECOND, false, 0.0, ""),
    CONJURED_DISTILLATION("Conjured Distillation", 60, 3, 1.0,  AbsoluteStatType.MANA, false, 0.0, ""),
    RISING_POWER("Rising Power", 80, 3, 75.0,  AbsoluteStatType.DAMAGE, false, 0.0, ""),
    DECISIVE_STRIKE("Decisive Strike", 80, 3, 845.0,  AbsoluteStatType.CRIT_VALUE, false, 0.0, ""),
    HANGMANS_PRIDE("Hangman's Pride", 80, 3, 165.0 , false, 0.0, "Regenerates %f Health Points per final Blow"),
    STURDY_SHIELD("Sturdy Shield", 80, 3, 845.0,  AbsoluteStatType.BLOCK_VALUE, false, 0.0, ""),
    HARD_AS_A_ROCK("Hard as a Rock", 80, 3, 545.0,  AbsoluteStatType.ARMOR_VALUE, false, 0.0, ""),
    ELEMENTAL_PROTECTION("Elemental Protection", 80, 3, 545.0,  AbsoluteStatType.RESISTANCE_VALUE, false, 0.0, ""),
    SECOND_CHANCE("Second Chance", 1, 300, 0.0, false, 0.0, "Saves you from death if your Health Points drop to 0."),
    EMERGENCY_RESERVES("Emergency Reserves", 1, 300, 0.0, false, 0.0, "Regenerates 15 Resource Points whenever you get hit while your Health Points are below 33%"),
    ENERGETIC_FORCE("Energetic Force", 1, 300, 0.0, false, 0.0, "Each critical hit grants the Energetic Force buff"),
    DEXTROUS_SMITING("Dextrous Smiting", 60, 3, 100.0,  AbsoluteStatType.ONE_HAND_DAMAGE, false, 0.0, ""),
    DEXTROUS_AGILITY("Dextrous Agility", 60, 3, 0.01,  AbsoluteStatType.ONE_HAND_ATTACK_SPEED, false, 0.0, ""),
    A_HANDFUL_OF_RESOURCES("A Handful of Resources", 60, 3, 0.0025, true, 0.01, "Each final blow with an one-handed weapon grants the A Handful of Resources buff"),
    AMBIDEXTROUS_SMITING("Ambidextrous Smiting", 60, 3, 200.0,  AbsoluteStatType.TWO_HAND_DAMAGE, false, 0.0, ""),
    AMBIDEXTROUS_AGILITY("Ambidextrous Agility", 60, 3, 0.005,  AbsoluteStatType.TWO_HAND_ATTACK_SPEED, false, 0.0, ""),
    LIFETIME_THIEF("Lifetime Thief", 60, 3, 0.0025, false, 0.01, "Each final blow with a two-handed weapon reduces your active skill cool-down times by %f%"),
    BONANZA("Bonanza", 150, 1, 0.007, OverallRelativeBuffType.COIN_DROP_BONUS,false, 0.01, ""),
    PEDDLER("Peddler", 1, 45, 0.0, false, 0.0, "Unlocks o portable shop window to sell your items wherever you are."),
    PORTABLE_WORKBENCH("Portable Workbench", 1, 45, 0.0, false, 0.0, "Unlocks a portable workbench for crafting wherever you are."),
    HOME_SWEET_HOME("Home Sweet Home", 15, 3, 0.02, true, 0.01, "%f% less time to use the Urban Area Teleportation"),
    ON_HORSEBACK("On Horseback", 15, 3, 0.02, true, 0.01, "%f% less time to summon mounts"),
    RACING_SLIPPERS("Racing Slippers", 15, 3, 0.02, true, 0.01, "%f% movement speed in hubs");




    private final String name;
    private final int maxLevel;
    private final int costPerLevel;
    private final Double increasePerLevel;
    private final AbsoluteStatType statType;
    private final OverallRelativeBuffType relativeBuffType;
    private final boolean biggerIncreaseWithFirstLevel;
    private final Double firstLevelBoost;
    private int currentLevel;
    private final String description;

    WisdomSkill(String name, int maxLevel, int costPerLevel, Double increasePerLevel, AbsoluteStatType statType, boolean biggerIncreaseWithFirstLevel, Double firstLevelBoost, String description)
    {
        this.name = name;
        this.maxLevel = maxLevel;
        this.costPerLevel = costPerLevel;
        this.increasePerLevel = increasePerLevel;
        this.statType = statType;
        this.biggerIncreaseWithFirstLevel = biggerIncreaseWithFirstLevel;
        this.firstLevelBoost = firstLevelBoost;
        this.currentLevel = 0;
        this.description = description;
        this.relativeBuffType = null;
    }

    WisdomSkill(String name, int maxLevel, int costPerLevel, Double increasePerLevel, OverallRelativeBuffType relativeBuffType, boolean biggerIncreaseWithFirstLevel, Double firstLevelBoost, String description)
    {
        this.name = name;
        this.maxLevel = maxLevel;
        this.costPerLevel = costPerLevel;
        this.increasePerLevel = increasePerLevel;
        this.statType = null;
        this.biggerIncreaseWithFirstLevel = biggerIncreaseWithFirstLevel;
        this.firstLevelBoost = firstLevelBoost;
        this.currentLevel = 0;
        this.description = description;
        this.relativeBuffType = relativeBuffType;
    }

    WisdomSkill(String name, int maxLevel, int costPerLevel, Double increasePerLevel, boolean biggerIncreaseWithFirstLevel, Double firstLevelBoost, String description)
    {
        this.name = name;
        this.maxLevel = maxLevel;
        this.costPerLevel = costPerLevel;
        this.increasePerLevel = increasePerLevel;
        this.statType = null;
        this.biggerIncreaseWithFirstLevel = biggerIncreaseWithFirstLevel;
        this.firstLevelBoost = firstLevelBoost;
        this.currentLevel = 0;
        this.description = description;
        this.relativeBuffType = null;
    }

    public void setLevel(int level){
        if (level>=0 && level<=this.maxLevel)
        {
            this.currentLevel = level;
        }
        else if (level<0)
        {
            this.currentLevel = 0;
        }
        else
        {
            this.currentLevel = this.maxLevel;
        }
    }

    public void increaseLevel(){
        if (this.currentLevel<this.maxLevel)
        {
            this.currentLevel+=1;
        }
    }

    public void decreaseLevel(){
        if (this.currentLevel>0)
        {
            this.currentLevel-=1;
        }
    }

    public String getName() {
        return name;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public int getCostPerLevel() {
        return costPerLevel;
    }

    public Double getIncreasePerLevel() {
        return increasePerLevel;
    }

    public AbsoluteStatType getStatType() {
        return statType;
    }

    public OverallRelativeBuffType getRelativeBuffType() {
        return relativeBuffType;
    }

    public boolean isBiggerIncreaseWithFirstLevel() {
        return biggerIncreaseWithFirstLevel;
    }

    public Double getFirstLevelBoost() {
        return firstLevelBoost;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public String getDescription() {
        return description;
    }
}
