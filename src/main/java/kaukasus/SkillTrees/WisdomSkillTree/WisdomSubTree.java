package kaukasus.SkillTrees.WisdomSkillTree;

public enum WisdomSubTree {

    HEALTH_RESOURCE("Health/Resource", WisdomSkill.RISING_VIGOR, WisdomSkill.VIVACIOUS_VITALITY, WisdomSkill.CONJURED_DISTILLATION, 150),
    ATTACK("Attack", WisdomSkill.RISING_POWER, WisdomSkill.DECISIVE_STRIKE, WisdomSkill.HANGMANS_PRIDE, 200),
    DEFENSE("Defense", WisdomSkill.STURDY_SHIELD, WisdomSkill.HARD_AS_A_ROCK, WisdomSkill.ELEMENTAL_PROTECTION, 200),
    COMBAT("Combat", WisdomSkill.SECOND_CHANCE, WisdomSkill.EMERGENCY_RESERVES, WisdomSkill.ENERGETIC_FORCE, 1),
    ONE_HANDED_WEAPON("One-handed Weapon", WisdomSkill.DEXTROUS_SMITING, WisdomSkill.DEXTROUS_AGILITY, WisdomSkill.A_HANDFUL_OF_RESOURCES, 150),
    TWO_HANDED_WEAPON("Two-handed Weapon", WisdomSkill.AMBIDEXTROUS_SMITING, WisdomSkill.AMBIDEXTROUS_AGILITY, WisdomSkill.LIFETIME_THIEF, 150),
    PROSPERITY("Prosperity", WisdomSkill.BONANZA, WisdomSkill.PEDDLER, WisdomSkill.PORTABLE_WORKBENCH, 152),
    TRAVEL_MERITS("Travel Merits", WisdomSkill.HOME_SWEET_HOME, WisdomSkill.ON_HORSEBACK, WisdomSkill.RACING_SLIPPERS, 45);

    private final String name;
    private WisdomSkill skill1;
    private WisdomSkill skill2;
    private WisdomSkill skill3;
    private final int maxLevel;
    private int currentLevel;

    WisdomSubTree(String name, WisdomSkill skill1, WisdomSkill skill2, WisdomSkill skill3, int maxLevel)
    {
        this.name = name;
        this.skill1 = skill1;
        this.skill2 = skill2;
        this.skill3 = skill3;
        this.maxLevel = maxLevel;
        this.currentLevel = 0;
    }

    public int setSkillLevel(int level, int skillNumber)
    {
        switch (skillNumber)
        {
            case 1 -> {
                if (level>=0 && level<=this.skill1.getMaxLevel() && level-this.skill1.getCurrentLevel()<=this.maxLevel-this.currentLevel)
                {
                    this.skill1.setLevel(level);
                    this.currentLevel+=level;
                    return level;
                }
                else if(level>=0 && level<=this.skill1.getMaxLevel())
                {
                    int newLevel = this.maxLevel-this.currentLevel;
                    this.skill1.setLevel(newLevel);
                    this.currentLevel = this.maxLevel;
                    return newLevel;
                }
                else if (level < 0)
                {
                    this.currentLevel-=this.skill1.getCurrentLevel();
                    this.skill1.setLevel(0);
                    return 0;
                }

            }
            case 2 -> {
                if (level>=0 && level<=this.skill2.getMaxLevel() && level-this.skill2.getCurrentLevel()<=this.maxLevel-this.currentLevel)
                {
                    this.skill2.setLevel(level);
                    this.currentLevel+=level;
                    return level;
                }
                else if(level>=0 && level<=this.skill2.getMaxLevel())
                {
                    int newLevel = this.maxLevel-this.currentLevel;
                    this.skill2.setLevel(newLevel);
                    this.currentLevel = this.maxLevel;
                    return newLevel;
                }
                else if (level < 0)
                {
                    this.currentLevel-=this.skill2.getCurrentLevel();
                    this.skill2.setLevel(0);
                    return 0;
                }

            }
            case 3 -> {
                if (level>=0 && level<=this.skill3.getMaxLevel() && level-this.skill3.getCurrentLevel()<=this.maxLevel-this.currentLevel)
                {
                    this.skill3.setLevel(level);
                    this.currentLevel+=level;
                    return level;
                }
                else if(level>=0 && level<=this.skill3.getMaxLevel())
                {
                    int newLevel = this.maxLevel-this.currentLevel;
                    this.skill3.setLevel(newLevel);
                    this.currentLevel = this.maxLevel;
                    return newLevel;
                }
                else if (level < 0)
                {
                    this.currentLevel-=this.skill3.getCurrentLevel();
                    this.skill3.setLevel(0);
                    return 0;
                }

            }
        }
        return -1;
    }

    public boolean increaseSkillLevel(int skillNumber)
    {
        switch (skillNumber)
        {
            case 1 -> {
                if (this.currentLevel < this.maxLevel && this.skill1.getCurrentLevel() < this.skill1.getMaxLevel())
                {
                    this.skill1.increaseLevel();
                    this.currentLevel+=1;
                    return true;
                }
            }
            case 2 -> {
                if (this.currentLevel < this.maxLevel && this.skill2.getCurrentLevel() < this.skill2.getMaxLevel())
                {
                    this.skill2.increaseLevel();
                    this.currentLevel+=1;
                    return true;
                }
            }
            case 3 -> {
                if (this.currentLevel < this.maxLevel && this.skill3.getCurrentLevel() < this.skill3.getMaxLevel())
                {
                    this.skill3.increaseLevel();
                    this.currentLevel+=1;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean decreaseSkillLevel(int skillNumber)
    {
        switch (skillNumber)
        {
            case 1 -> {
                if (this.currentLevel > 0 && this.skill1.getCurrentLevel() > 0)
                {
                    this.skill1.decreaseLevel();
                    this.currentLevel-=1;
                    return true;
                }
            }
            case 2 -> {
                if (this.currentLevel > 0 && this.skill2.getCurrentLevel() > 0)
                {
                    this.skill2.decreaseLevel();
                    this.currentLevel-=1;
                    return true;
                }
            }
            case 3 -> {
                if (this.currentLevel > 0 && this.skill3.getCurrentLevel() > 0)
                {
                    this.skill3.decreaseLevel();
                    this.currentLevel-=1;
                    return true;
                }
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public WisdomSkill getSkill(int skillNumber) {
        switch (skillNumber)
        {
            case 1 -> {
                return this.skill1;
            }
            case 2 -> {
                return this.skill2;
            }
            case 3 -> {
                return this.skill3;
            }
        }
        return null;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }
}
