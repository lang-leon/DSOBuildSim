package kaukasus.SkillTrees;

public class AbstractSkillTree {

    String name;
    int level;
    int maxLevel;
    int pointsPerLevel;
    int usePoints;
    int totalPointsAvailable;


    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public int getPointsPerLevel() {
        return pointsPerLevel;
    }

    public int getUsePoints() {
        return usePoints;
    }

    public int getTotalPointsAvailable() {
        return totalPointsAvailable;
    }
}
