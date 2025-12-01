package com.langleon.dsobuildsim.skilltrees.wisdomskilltree;

import com.langleon.dsobuildsim.enums.AbsoluteStatType;
import com.langleon.dsobuildsim.enums.OverallRelativeBuffType;
import com.langleon.dsobuildsim.skilltrees.AbstractSkillTree;

import java.util.HashMap;
import java.util.Map;

public class WisdomSkillTree extends AbstractSkillTree {

    private WisdomSubTree healthResource;
    private WisdomSubTree attack;
    private WisdomSubTree defense;
    private WisdomSubTree combat;
    private WisdomSubTree oneHandedWeapon;
    private WisdomSubTree twoHandedWeapon;
    private WisdomSubTree prosperity;
    private WisdomSubTree travelMerits;
    int maxAvailablePoints;
    int currentlyUsedPoints;

    public WisdomSkillTree() {
        this.healthResource = WisdomSubTree.HEALTH_RESOURCE;
        this.attack = WisdomSubTree.ATTACK;
        this.defense = WisdomSubTree.DEFENSE;
        this.combat = WisdomSubTree.COMBAT;
        this.oneHandedWeapon = WisdomSubTree.ONE_HANDED_WEAPON;
        this.twoHandedWeapon = WisdomSubTree.TWO_HANDED_WEAPON;
        this.prosperity = WisdomSubTree.PROSPERITY;
        this.travelMerits = WisdomSubTree.TRAVEL_MERITS;
        this.maxAvailablePoints = 2865;
        this.currentlyUsedPoints = 0;
    }

    public void setLevel(int level, int wisdomSubTree, int wisdomSkill)
    {
        switch (wisdomSubTree)
        {
            case 1 -> {
                if (this.maxAvailablePoints-this.currentlyUsedPoints>=this.healthResource.getSkill(wisdomSkill).getCostPerLevel()*(level-this.healthResource.getSkill(wisdomSkill).getCurrentLevel()))
                {
                    int setLevel = this.healthResource.setSkillLevel(level, wisdomSkill);
                    this.currentlyUsedPoints+=setLevel*this.healthResource.getSkill(wisdomSkill).getCostPerLevel();
                }
                else
                {
                    int possLevelIncrease = this.maxAvailablePoints/this.healthResource.getSkill(wisdomSkill).getCostPerLevel();
                    int possLevel = this.healthResource.getSkill(wisdomSkill).getCurrentLevel()+possLevelIncrease;
                    int setLevel = this.healthResource.setSkillLevel(possLevel, wisdomSkill);
                    this.currentlyUsedPoints+=setLevel*this.healthResource.getSkill(wisdomSkill).getCostPerLevel();
                }
            }
            case 2 -> {
                if (this.maxAvailablePoints-this.currentlyUsedPoints>=this.attack.getSkill(wisdomSkill).getCostPerLevel()*(level-this.attack.getSkill(wisdomSkill).getCurrentLevel()))
                {
                    int setLevel = this.attack.setSkillLevel(level, wisdomSkill);
                    this.currentlyUsedPoints+=setLevel*this.attack.getSkill(wisdomSkill).getCostPerLevel();
                }
                else
                {
                    int possLevelIncrease = this.maxAvailablePoints/this.attack.getSkill(wisdomSkill).getCostPerLevel();
                    int possLevel = this.attack.getSkill(wisdomSkill).getCurrentLevel()+possLevelIncrease;
                    int setLevel = this.attack.setSkillLevel(possLevel, wisdomSkill);
                    this.currentlyUsedPoints+=setLevel*this.attack.getSkill(wisdomSkill).getCostPerLevel();
                }
            }
            case 3 -> {
                if (this.maxAvailablePoints-this.currentlyUsedPoints>=this.defense.getSkill(wisdomSkill).getCostPerLevel()*(level-this.defense.getSkill(wisdomSkill).getCurrentLevel()))
                {
                    int setLevel = this.defense.setSkillLevel(level, wisdomSkill);
                    this.currentlyUsedPoints+=setLevel*this.defense.getSkill(wisdomSkill).getCostPerLevel();
                }
                else
                {
                    int possLevelIncrease = this.maxAvailablePoints/this.defense.getSkill(wisdomSkill).getCostPerLevel();
                    int possLevel = this.defense.getSkill(wisdomSkill).getCurrentLevel()+possLevelIncrease;
                    int setLevel = this.defense.setSkillLevel(possLevel, wisdomSkill);
                    this.currentlyUsedPoints+=setLevel*this.defense.getSkill(wisdomSkill).getCostPerLevel();
                }
            }
            case 4 -> {
                if (this.maxAvailablePoints-this.currentlyUsedPoints>=this.combat.getSkill(wisdomSkill).getCostPerLevel()*(level-this.combat.getSkill(wisdomSkill).getCurrentLevel()))
                {
                    int setLevel = this.combat.setSkillLevel(level, wisdomSkill);
                    this.currentlyUsedPoints+=setLevel*this.combat.getSkill(wisdomSkill).getCostPerLevel();
                }
                else
                {
                    int possLevelIncrease = this.maxAvailablePoints/this.combat.getSkill(wisdomSkill).getCostPerLevel();
                    int possLevel = this.combat.getSkill(wisdomSkill).getCurrentLevel()+possLevelIncrease;
                    int setLevel = this.combat.setSkillLevel(possLevel, wisdomSkill);
                    this.currentlyUsedPoints+=setLevel*this.combat.getSkill(wisdomSkill).getCostPerLevel();
                }
            }
            case 5 -> {
                if (this.maxAvailablePoints-this.currentlyUsedPoints>=this.oneHandedWeapon.getSkill(wisdomSkill).getCostPerLevel()*(level-this.oneHandedWeapon.getSkill(wisdomSkill).getCurrentLevel()))
                {
                    int setLevel = this.oneHandedWeapon.setSkillLevel(level, wisdomSkill);
                    this.currentlyUsedPoints+=setLevel*this.oneHandedWeapon.getSkill(wisdomSkill).getCostPerLevel();
                }
                else
                {
                    int possLevelIncrease = this.maxAvailablePoints/this.oneHandedWeapon.getSkill(wisdomSkill).getCostPerLevel();
                    int possLevel = this.oneHandedWeapon.getSkill(wisdomSkill).getCurrentLevel()+possLevelIncrease;
                    int setLevel = this.oneHandedWeapon.setSkillLevel(possLevel, wisdomSkill);
                    this.currentlyUsedPoints+=setLevel*this.oneHandedWeapon.getSkill(wisdomSkill).getCostPerLevel();
                }
            }
            case 6 -> {
                if (this.maxAvailablePoints-this.currentlyUsedPoints>=this.twoHandedWeapon.getSkill(wisdomSkill).getCostPerLevel()*(level-this.twoHandedWeapon.getSkill(wisdomSkill).getCurrentLevel()))
                {
                    int setLevel = this.twoHandedWeapon.setSkillLevel(level, wisdomSkill);
                    this.currentlyUsedPoints+=setLevel*this.twoHandedWeapon.getSkill(wisdomSkill).getCostPerLevel();
                }
                else
                {
                    int possLevelIncrease = this.maxAvailablePoints/this.twoHandedWeapon.getSkill(wisdomSkill).getCostPerLevel();
                    int possLevel = this.twoHandedWeapon.getSkill(wisdomSkill).getCurrentLevel()+possLevelIncrease;
                    int setLevel = this.twoHandedWeapon.setSkillLevel(possLevel, wisdomSkill);
                    this.currentlyUsedPoints+=setLevel*this.twoHandedWeapon.getSkill(wisdomSkill).getCostPerLevel();
                }
            }
            case 7 -> {
                if (this.maxAvailablePoints-this.currentlyUsedPoints>=this.prosperity.getSkill(wisdomSkill).getCostPerLevel()*(level-this.prosperity.getSkill(wisdomSkill).getCurrentLevel()))
                {
                    int setLevel = this.prosperity.setSkillLevel(level, wisdomSkill);
                    this.currentlyUsedPoints+=setLevel*this.prosperity.getSkill(wisdomSkill).getCostPerLevel();
                }
                else
                {
                    int possLevelIncrease = this.maxAvailablePoints/this.prosperity.getSkill(wisdomSkill).getCostPerLevel();
                    int possLevel = this.prosperity.getSkill(wisdomSkill).getCurrentLevel()+possLevelIncrease;
                    int setLevel = this.prosperity.setSkillLevel(possLevel, wisdomSkill);
                    this.currentlyUsedPoints+=setLevel*this.prosperity.getSkill(wisdomSkill).getCostPerLevel();
                }
            }
            case 8 -> {
                if (this.maxAvailablePoints-this.currentlyUsedPoints>=this.travelMerits.getSkill(wisdomSkill).getCostPerLevel()*(level-this.travelMerits.getSkill(wisdomSkill).getCurrentLevel()))
                {
                    int setLevel = this.travelMerits.setSkillLevel(level, wisdomSkill);
                    this.currentlyUsedPoints+=setLevel*this.travelMerits.getSkill(wisdomSkill).getCostPerLevel();
                }
                else
                {
                    int possLevelIncrease = this.maxAvailablePoints/this.travelMerits.getSkill(wisdomSkill).getCostPerLevel();
                    int possLevel = this.travelMerits.getSkill(wisdomSkill).getCurrentLevel()+possLevelIncrease;
                    int setLevel = this.travelMerits.setSkillLevel(possLevel, wisdomSkill);
                    this.currentlyUsedPoints+=setLevel*this.travelMerits.getSkill(wisdomSkill).getCostPerLevel();
                }
            }
        }
    }

    public void increaseLevel(int wisdomSubTree, int wisdomSkill)
    {
        switch (wisdomSubTree)
        {
            case 1 -> {
                if (this.maxAvailablePoints-this.currentlyUsedPoints>=this.healthResource.getSkill(wisdomSkill).getCostPerLevel())
                {
                    if (this.healthResource.increaseSkillLevel(wisdomSkill))
                    {
                        this.currentlyUsedPoints+=this.healthResource.getSkill(wisdomSkill).getCostPerLevel();
                    }
                }
            }
            case 2 -> {
                if (this.maxAvailablePoints-this.currentlyUsedPoints>=this.attack.getSkill(wisdomSkill).getCostPerLevel())
                {
                    if (this.attack.increaseSkillLevel(wisdomSkill))
                    {
                        this.currentlyUsedPoints+=this.attack.getSkill(wisdomSkill).getCostPerLevel();
                    }
                }
            }
            case 3 -> {
                if (this.maxAvailablePoints-this.currentlyUsedPoints>=this.defense.getSkill(wisdomSkill).getCostPerLevel())
                {
                    if (this.defense.increaseSkillLevel(wisdomSkill))
                    {
                        this.currentlyUsedPoints+=this.defense.getSkill(wisdomSkill).getCostPerLevel();
                    }
                }
            }
            case 4 -> {
                if (this.maxAvailablePoints-this.currentlyUsedPoints>=this.combat.getSkill(wisdomSkill).getCostPerLevel())
                {
                    if (this.combat.increaseSkillLevel(wisdomSkill))
                    {
                        this.currentlyUsedPoints+=this.combat.getSkill(wisdomSkill).getCostPerLevel();
                    }
                }
            }
            case 5 -> {
                if (this.maxAvailablePoints-this.currentlyUsedPoints>=this.oneHandedWeapon.getSkill(wisdomSkill).getCostPerLevel())
                {
                    if (this.oneHandedWeapon.increaseSkillLevel(wisdomSkill))
                    {
                        this.currentlyUsedPoints+=this.oneHandedWeapon.getSkill(wisdomSkill).getCostPerLevel();
                    }
                }
            }
            case 6 -> {
                if (this.maxAvailablePoints-this.currentlyUsedPoints>=this.twoHandedWeapon.getSkill(wisdomSkill).getCostPerLevel())
                {
                    if (this.twoHandedWeapon.increaseSkillLevel(wisdomSkill))
                    {
                        this.currentlyUsedPoints+=this.twoHandedWeapon.getSkill(wisdomSkill).getCostPerLevel();
                    }
                }
            }
            case 7 -> {
                if (this.maxAvailablePoints-this.currentlyUsedPoints>=this.prosperity.getSkill(wisdomSkill).getCostPerLevel())
                {
                    if (this.prosperity.increaseSkillLevel(wisdomSkill))
                    {
                        this.currentlyUsedPoints+=this.prosperity.getSkill(wisdomSkill).getCostPerLevel();
                    }
                }
            }
            case 8 -> {
                if (this.maxAvailablePoints-this.currentlyUsedPoints>=this.travelMerits.getSkill(wisdomSkill).getCostPerLevel())
                {
                    if (this.travelMerits.increaseSkillLevel(wisdomSkill))
                    {
                        this.currentlyUsedPoints+=this.travelMerits.getSkill(wisdomSkill).getCostPerLevel();
                    }
                }
            }
        }
    }

    public void decreaseLevel(int wisdomSubTree, int wisdomSkill)
    {
        switch (wisdomSubTree)
        {
            case 1 -> {
                if (this.healthResource.decreaseSkillLevel(wisdomSkill))
                {
                    this.currentlyUsedPoints-=this.healthResource.getSkill(wisdomSkill).getCostPerLevel();
                }
            }
            case 2 -> {
                if (this.attack.decreaseSkillLevel(wisdomSkill))
                {
                    this.currentlyUsedPoints-=this.attack.getSkill(wisdomSkill).getCostPerLevel();
                }
            }
            case 3 -> {
                if (this.defense.decreaseSkillLevel(wisdomSkill))
                {
                    this.currentlyUsedPoints-=this.defense.getSkill(wisdomSkill).getCostPerLevel();
                }
            }
            case 4 -> {
                if (this.combat.decreaseSkillLevel(wisdomSkill))
                {
                    this.currentlyUsedPoints-=this.combat.getSkill(wisdomSkill).getCostPerLevel();
                }
            }
            case 5 -> {
                if (this.oneHandedWeapon.decreaseSkillLevel(wisdomSkill))
                {
                    this.currentlyUsedPoints-=this.oneHandedWeapon.getSkill(wisdomSkill).getCostPerLevel();
                }
            }
            case 6 -> {
                if (this.twoHandedWeapon.decreaseSkillLevel(wisdomSkill))
                {
                    this.currentlyUsedPoints-=this.twoHandedWeapon.getSkill(wisdomSkill).getCostPerLevel();
                }
            }
            case 7 -> {
                if (this.prosperity.decreaseSkillLevel(wisdomSkill))
                {
                    this.currentlyUsedPoints-=this.prosperity.getSkill(wisdomSkill).getCostPerLevel();
                }
            }
            case 8 -> {
                if (this.travelMerits.decreaseSkillLevel(wisdomSkill))
                {
                    this.currentlyUsedPoints-=this.travelMerits.getSkill(wisdomSkill).getCostPerLevel();
                }
            }
        }
    }

    public WisdomSubTree getHealthResource() {
        return healthResource;
    }

    public WisdomSubTree getAttack() {
        return attack;
    }

    public WisdomSubTree getDefense() {
        return defense;
    }

    public WisdomSubTree getCombat() {
        return combat;
    }

    public WisdomSubTree getOneHandedWeapon() {
        return oneHandedWeapon;
    }

    public WisdomSubTree getTwoHandedWeapon() {
        return twoHandedWeapon;
    }

    public WisdomSubTree getProsperity() {
        return prosperity;
    }

    public WisdomSubTree getTravelMerits() {
        return travelMerits;
    }

    public int getMaxAvailablePoints() {
        return maxAvailablePoints;
    }

    public int getCurrentlyUsedPoints() {
        return currentlyUsedPoints;
    }

    public Map<AbsoluteStatType, Double> getAbsoluteBuffs()
    {
        Map<AbsoluteStatType, Double> absoluteBuffs = new HashMap<>();
        absoluteBuffs.put(AbsoluteStatType.HEALTH_POINTS, this.healthResource.getSkill(1).getCurrentLevel()*this.healthResource.getSkill(1).getIncreasePerLevel());
        absoluteBuffs.put(AbsoluteStatType.HEALTH_PER_SECOND, this.healthResource.getSkill(2).getCurrentLevel()*this.healthResource.getSkill(2).getIncreasePerLevel());
        absoluteBuffs.put(AbsoluteStatType.MANA, this.healthResource.getSkill(3).getCurrentLevel()*this.healthResource.getSkill(3).getIncreasePerLevel());

        absoluteBuffs.put(AbsoluteStatType.DAMAGE, this.attack.getSkill(1).getCurrentLevel()*this.attack.getSkill(1).getIncreasePerLevel());
        absoluteBuffs.put(AbsoluteStatType.CRIT_VALUE, this.attack.getSkill(2).getCurrentLevel()*this.attack.getSkill(2).getIncreasePerLevel());

        absoluteBuffs.put(AbsoluteStatType.BLOCK_VALUE, this.defense.getSkill(1).getCurrentLevel()*this.defense.getSkill(1).getIncreasePerLevel());
        absoluteBuffs.put(AbsoluteStatType.ARMOR, this.defense.getSkill(2).getCurrentLevel()*this.defense.getSkill(2).getIncreasePerLevel());
        absoluteBuffs.put(AbsoluteStatType.RESISTANCE, this.defense.getSkill(3).getCurrentLevel()*this.defense.getSkill(3).getIncreasePerLevel());

        absoluteBuffs.put(AbsoluteStatType.ONE_HAND_DAMAGE, this.oneHandedWeapon.getSkill(1).getCurrentLevel()*this.oneHandedWeapon.getSkill(1).getIncreasePerLevel());
        absoluteBuffs.put(AbsoluteStatType.ONE_HAND_ATTACK_SPEED, this.oneHandedWeapon.getSkill(2).getCurrentLevel()*this.oneHandedWeapon.getSkill(2).getIncreasePerLevel());

        absoluteBuffs.put(AbsoluteStatType.TWO_HAND_DAMAGE, this.twoHandedWeapon.getSkill(1).getCurrentLevel()*this.twoHandedWeapon.getSkill(1).getIncreasePerLevel());
        absoluteBuffs.put(AbsoluteStatType.TWO_HAND_ATTACK_SPEED, this.twoHandedWeapon.getSkill(2).getCurrentLevel()*this.twoHandedWeapon.getSkill(2).getIncreasePerLevel());

        return absoluteBuffs;
    }

    public Map<OverallRelativeBuffType, Double> getRelativeBuffs()
    {
        WisdomSkill coins = this.prosperity.getSkill(1);
        return Map.of(OverallRelativeBuffType.COIN_DROP_BONUS, coins.getCurrentLevel()*coins.getIncreasePerLevel()+coins.getFirstLevelBoost());
    }
}
