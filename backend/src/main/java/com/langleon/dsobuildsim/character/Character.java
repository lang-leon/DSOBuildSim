package com.langleon.dsobuildsim.character;

import com.langleon.dsobuildsim.buffs.Physic;
import com.langleon.dsobuildsim.buffs.Tonic;
import com.langleon.dsobuildsim.collectorbagbonus.collectorbagcategorybonus.CollectorBagCategoryBonus;
import com.langleon.dsobuildsim.collectorbagbonus.enums.CollectorBagCategory;
import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.dragonstones.DragonCrestTrinket;
import com.langleon.dsobuildsim.exceptions.InvalidItemsEquippedException;
import com.langleon.dsobuildsim.exceptions.LimitExceededException;
import com.langleon.dsobuildsim.exceptions.LimitType;
import com.langleon.dsobuildsim.gems.enums.GemLimitGroup;
import com.langleon.dsobuildsim.items.core.enums.ItemSlot;
import com.langleon.dsobuildsim.jewels.JewelType;
import com.langleon.dsobuildsim.runes.enums.RuneLimitGroup;
import com.langleon.dsobuildsim.sets.SetType;
import com.langleon.dsobuildsim.essences.Essence;
import com.langleon.dsobuildsim.items.core.UniqueStatProvider;
import com.langleon.dsobuildsim.sets.*;
import com.langleon.dsobuildsim.items.core.Item;
import com.langleon.dsobuildsim.jewels.JewelTrinket;
import com.langleon.dsobuildsim.pets.Pet;
import com.langleon.dsobuildsim.runes.RuneTrinket;
import com.langleon.dsobuildsim.wisdomskilltree.WisdomSkillTree;

import java.util.*;

public class Character {

    private final CharacterClass characterClass;
    private final String name;

    private final MasteryType elementalMasteryType;
    private final int elementalMasteryLevel; // 0-10
    private final boolean experienceBonusPath;
    private final int experienceBonusPathLevel;

    private final List<RuneTrinket> runeTrinkets;
    private final List<JewelTrinket> jewelTrinkets;
    private final DragonCrestTrinket dragonCrestTrinket;

    private final Map<ItemSlot, Item> equippedItems;
    private final Map<SetType, SetInstance> equippedSets;

    private final Pet pet;
    private final Map<CollectorBagCategory, CollectorBagCategoryBonus> collectorBagBuffs;

    private final Essence essence;
    private final Tonic tonic;
    private final Physic physic;

    private final WisdomSkillTree wisdomSkillTree;

    public Character(CharacterClass characterClass,
                     MasteryType masteryType,
                     int masteryLevel,
                     boolean experienceBonusPath,
                     int experienceBonusPathLevel,
                     List<RuneTrinket> runeTrinkets,
                     List<JewelTrinket> jewelTrinkets,
                     DragonCrestTrinket dragonCrest,
                     Map<ItemSlot, Item> items,
                     Map<SetType, SetInstance> equippedSets,
                     Pet pet,
                     Essence essence,
                     Tonic tonic,
                     Physic physic,
                     WisdomSkillTree wisdomSkillTree,
                     Map<CollectorBagCategory, CollectorBagCategoryBonus> collectorBagBuffs
                     )
    {
        this.characterClass = characterClass;
        this.name = characterClass.getName();
        this.elementalMasteryType = masteryType;
        if (masteryLevel > 10 || masteryLevel < 0) throw new LimitExceededException(LimitType.MASTERY_TYPE, "Mastery level must be between 0 and 10, but was "+masteryLevel);
        this.elementalMasteryLevel = masteryLevel;
        this.experienceBonusPath = experienceBonusPath;
        if (experienceBonusPathLevel > 5 || experienceBonusPathLevel < 0) throw new LimitExceededException(LimitType.EXPERIENCE_SKILL_TREE, "Experience path level must be between 0 and 10, but was "+experienceBonusPathLevel);
        this.experienceBonusPathLevel = experienceBonusPathLevel;

        this.validateRunes(runeTrinkets);
        this.runeTrinkets = runeTrinkets;
        this.validateJewels(jewelTrinkets);
        this.jewelTrinkets = jewelTrinkets;
        this.dragonCrestTrinket = dragonCrest;

        if (items.containsKey(ItemSlot.TWO_HAND_WEAPON) && (items.containsKey(ItemSlot.ONE_HAND_WEAPON) || items.containsKey(ItemSlot.OFF_HAND))) throw new InvalidItemsEquippedException("Equipped one hand and two hand items");
        this.validateGems(items.values().stream().toList());
        this.equippedItems = items;
        this.equippedSets = equippedSets;

        this.pet = pet;
        this.essence = essence;
        this.tonic = tonic;
        this.physic = physic;

        this.collectorBagBuffs = collectorBagBuffs;
        this.wisdomSkillTree = wisdomSkillTree;
    }

    public CharacterClass getCharacterClass() {
        return characterClass;
    }

    public String getName() {
        return name;
    }

    public Pet getPet() {
        return pet;
    }

    public Map<CollectorBagCategory, CollectorBagCategoryBonus> getCollectorBagBuffs() {
        return collectorBagBuffs;
    }

    public Essence getEssence() {
        return essence;
    }

    public Tonic getTonic() {
        return tonic;
    }

    public Physic getPhysic() {
        return physic;
    }

    public WisdomSkillTree getWisdomSkillTree() {
        return wisdomSkillTree;
    }

    private void validateRunes(List<RuneTrinket> runeTrinkets)
    {
        if (runeTrinkets.size() > 7) throw new LimitExceededException(LimitType.RUNE_TRINKET, "Up to 7 rune trinkets allowed per character, but was "+runeTrinkets.size());
        Map<RuneLimitGroup, Integer> runeCount = new EnumMap<>(RuneLimitGroup.class);
        runeTrinkets.forEach(runeTrinket -> {
            runeTrinket.getRunes().forEach(rune -> {
                runeCount.merge(rune.getRuneLimitGroup(), 1, Integer::sum);
            });
        });

        runeCount.forEach((runeLimitGroup, amount) -> {
            if (runeLimitGroup.getLimit() < amount) throw new LimitExceededException(LimitType.RUNE, "Rune limit exceeded for "+runeLimitGroup);
        });
    }

    private void validateJewels(List<JewelTrinket> jewelTrinkets)
    {
        if (jewelTrinkets.size() > 3) throw new LimitExceededException(LimitType.JEWEL_TRINKET, "Up to 3 jewel trinkets allowed per character, but was "+jewelTrinkets.size());
        Map<JewelType, Integer> jewelCount = new EnumMap<>(JewelType.class);
        jewelTrinkets.forEach(jewelTrinket -> {
            jewelTrinket.getJewels().forEach(jewel -> {
                jewelCount.merge(jewel.getJewelType(), 1, Integer::sum);
            });
        });

        jewelCount.forEach((jewelType, amount) -> {
            if (jewelType.getLimit() < amount) throw new LimitExceededException(LimitType.JEWEL, "Jewel limit exceeded for "+jewelType);
        });
    }

    private void validateGems(List<Item> items)
    {
        Map<GemLimitGroup, Integer> gemCount = new EnumMap<>(GemLimitGroup.class);
        items.forEach(item -> {
            item.getGems().forEach(gem -> {
                gemCount.merge(gem.getGemLimitGroup(), 1, Integer::sum);
            });
        });

        gemCount.forEach((gemLimitGroup, amount) -> {
            if (gemLimitGroup.getLimit() < amount) throw new LimitExceededException(LimitType.GEM, "Gem limit exceeded for "+gemLimitGroup);
        });
    }

    public Map<StatType, Double> calculateCharacterStats()
    {
        Map<StatType, Double> baseStats = this.calculateTotalBaseStats();
        Map<StatType, Double> relativeBonusStats = this.calculateTotalRelativeStats();

        //temporary fix for wisdomskilltree coin drop size
        relativeBonusStats.merge(StatType.COIN_DROP_BONUS, baseStats.getOrDefault(StatType.COIN_DROP_BONUS, 0.0), Double::sum);
        baseStats.remove(StatType.COIN_DROP_BONUS);

        if (this.equippedItems.containsKey(ItemSlot.ONE_HAND_WEAPON))
        {
            Double absoluteOneHandDamage = baseStats.getOrDefault(StatType.ONE_HAND_DAMAGE, 0.0);
            Double relativeOneHandDamage = relativeBonusStats.getOrDefault(StatType.ONE_HAND_DAMAGE, 0.0);
            double bonusOneHandDamage = this.equippedItems.get(ItemSlot.ONE_HAND_WEAPON).calculateTotalStats().get(StatType.DAMAGE) * relativeOneHandDamage;
            bonusOneHandDamage += absoluteOneHandDamage * (1 + relativeOneHandDamage);
            baseStats.merge(StatType.DAMAGE, bonusOneHandDamage, Double::sum);

            Double absoluteOneHandAttackSpeed = baseStats.getOrDefault(StatType.ONE_HAND_ATTACK_SPEED, 0.0);
            baseStats.merge(StatType.ATTACK_SPEED, absoluteOneHandAttackSpeed, Double::sum);
        }
        else if (this.equippedItems.containsKey(ItemSlot.TWO_HAND_WEAPON))
        {
            Double absoluteTwoHandDamage = baseStats.getOrDefault(StatType.TWO_HAND_DAMAGE, 0.0);
            Double relativeTwoHandDamage = relativeBonusStats.getOrDefault(StatType.TWO_HAND_DAMAGE, 0.0);
            double bonusTwoHandDamage = this.equippedItems.get(ItemSlot.TWO_HAND_WEAPON).calculateTotalStats().get(StatType.DAMAGE) * relativeTwoHandDamage;
            bonusTwoHandDamage += absoluteTwoHandDamage * (1 + relativeTwoHandDamage);
            baseStats.merge(StatType.DAMAGE, bonusTwoHandDamage, Double::sum);

            Double absoluteTwoHandAttackSpeed = baseStats.getOrDefault(StatType.TWO_HAND_ATTACK_SPEED, 0.0);
            baseStats.merge(StatType.ATTACK_SPEED, absoluteTwoHandAttackSpeed, Double::sum);
        }
        baseStats.remove(StatType.TWO_HAND_ATTACK_SPEED);
        baseStats.remove(StatType.TWO_HAND_DAMAGE);
        relativeBonusStats.remove(StatType.TWO_HAND_DAMAGE);
        baseStats.remove(StatType.ONE_HAND_ATTACK_SPEED);
        baseStats.remove(StatType.ONE_HAND_DAMAGE);
        relativeBonusStats.remove(StatType.ONE_HAND_DAMAGE);

        Map<StatType, Double> finalStats = new EnumMap<>(StatType.class);

        baseStats.forEach(((statType, baseValue) -> {
            double relativeBonus = relativeBonusStats.getOrDefault(statType, 0.0);
            double finalValue = baseValue * (1 + relativeBonus);

            finalStats.put(statType, finalValue);
        }));

        return finalStats;
    }

    private Map<StatType, Double> calculateTotalBaseStats()
    {
        Map<StatType, Double> baseStats = new EnumMap<>(StatType.class);
        this.characterClass.getBaseStats().forEach((key, value) -> baseStats.merge(key, value, Double::sum));
        this.wisdomSkillTree.calculateStats().forEach((key, value) -> baseStats.merge(key, value, Double::sum));
        this.calculateTotalItemBaseStats().forEach((key, value) -> baseStats.merge(key, value, Double::sum));
        this.equippedSets.forEach((setType, setInstance) -> setInstance.getActiveBaseValues().forEach((key, value) -> baseStats.merge(key, value, Double::sum)));
        if (this.tonic != null) baseStats.merge(this.tonic.statType(), this.tonic.statValue(), Double::sum);

        Double resistanceValue = baseStats.remove(StatType.RESISTANCE_VALUE);
        if(resistanceValue == null) resistanceValue = 0.0;
        baseStats.merge(StatType.FIRE_RESISTANCE, resistanceValue, Double::sum);
        baseStats.merge(StatType.ICE_RESISTANCE, resistanceValue, Double::sum);
        baseStats.merge(StatType.LIGHTNING_RESISTANCE, resistanceValue, Double::sum);
        baseStats.merge(StatType.POISON_RESISTANCE, resistanceValue, Double::sum);
        baseStats.merge(StatType.ANDERMAGIC_RESISTANCE, resistanceValue, Double::sum);

        return baseStats;
    }

    private Map<StatType, Double> calculateTotalItemBaseStats()
    {
        Map<StatType, Double> itemsTotalStats = new EnumMap<>(StatType.class);
        for (Item entry : equippedItems.values())
        {
            entry.calculateTotalStats().forEach((key, value) -> itemsTotalStats.merge(key, value, Double::sum));
        }
        return itemsTotalStats;
    }

    private Map<StatType, Double> calculateTotalRelativeStats()
    {
        Map<StatType, Double> relativeBonusStats = new EnumMap<>(StatType.class);
        this.characterClass.getRelativeStats().forEach((key, value) -> relativeBonusStats.merge(key, value, Double::sum));
        this.calculateExperienceSkillTreeRelativeStats().forEach((key, value) -> relativeBonusStats.merge(key, value, Double::sum));
        this.calculateTotalItemRelativeStats().forEach((key, value) -> relativeBonusStats.merge(key, value, Double::sum));
        this.equippedSets.forEach((setType, setInstance) -> setInstance.getActiveRelativeValues().forEach((key, value) -> relativeBonusStats.merge(key, value, Double::sum)));
        this.runeTrinkets.forEach(trinket -> trinket.getTotalRelativeStats().forEach((key, value) -> relativeBonusStats.merge(key, value, Double::sum)));
        this.jewelTrinkets.forEach(trinket -> trinket.getTotalRelativeStats().forEach((key, value) -> relativeBonusStats.merge(key, value, Double::sum)));
        this.dragonCrestTrinket.getTotalRelativeStats().forEach((key, value) -> relativeBonusStats.merge(key, value, Double::sum));
        if (this.pet !=null)
        {
            this.pet.getRelativeStats().forEach((key, value) -> relativeBonusStats.merge(key, value, Double::sum));
            this.collectorBagBuffs.forEach((_, bonus) -> {
                bonus.calculateStats().forEach((key, value) -> relativeBonusStats.merge(key, value, Double::sum));
            });
        }
        if (this.essence != null) relativeBonusStats.merge(StatType.DAMAGE, this.essence.damageIncrease(), Double::sum);
        if (this.physic != null) relativeBonusStats.merge(this.physic.statType(), this.physic.statValue(), Double::sum);

        Double resistanceValue = relativeBonusStats.remove(StatType.RESISTANCE_VALUE);
        if(resistanceValue == null) resistanceValue = 0.0;
        relativeBonusStats.merge(StatType.FIRE_RESISTANCE, resistanceValue, Double::sum);
        relativeBonusStats.merge(StatType.ICE_RESISTANCE, resistanceValue, Double::sum);
        relativeBonusStats.merge(StatType.LIGHTNING_RESISTANCE, resistanceValue, Double::sum);
        relativeBonusStats.merge(StatType.POISON_RESISTANCE, resistanceValue, Double::sum);
        relativeBonusStats.merge(StatType.ANDERMAGIC_RESISTANCE, resistanceValue, Double::sum);

        return relativeBonusStats;
    }

    private Map<StatType, Double> calculateExperienceSkillTreeRelativeStats()
    {
        Map<StatType, Double> relativeStats = new EnumMap<>(StatType.class);

        if (experienceBonusPath && experienceBonusPathLevel >= 1)
        {
            switch (this.characterClass)
            {
                case SPELLWEAVER -> relativeStats.put(StatType.DAMAGE, 0.3 + (experienceBonusPathLevel-1) * 0.05);
                case DRAGONKNIGHT -> relativeStats.put(StatType.ATTACK_SPEED, 0.3 + (experienceBonusPathLevel-1) * 0.05);
            }
        }

        if (elementalMasteryType == MasteryType.NONE || elementalMasteryLevel <= 0) {
            return relativeStats;
        }

        double masteryResValue = 0.5 + (elementalMasteryLevel-1) * 0.05;
        StatType masteryResType = switch (elementalMasteryType)
        {
            case FIRE -> StatType.FIRE_RESISTANCE;
            case ICE -> StatType.ICE_RESISTANCE;
            case LIGHTNING -> StatType.LIGHTNING_RESISTANCE;
            case POISON -> StatType.POISON_RESISTANCE;
            default -> null;
        };
        relativeStats.put(masteryResType, masteryResValue);

        for (StatType stat : List.of(StatType.FIRE_RESISTANCE, StatType.ICE_RESISTANCE, StatType.LIGHTNING_RESISTANCE, StatType.POISON_RESISTANCE))
        {
            if (stat!=masteryResType) relativeStats.put(stat, -0.25);
        }
        return relativeStats;
    }

    private Map<StatType, Double> calculateTotalItemRelativeStats()
    {
        Map<StatType, Double> itemsTotalStats = new EnumMap<>(StatType.class);
        for (Item entry : equippedItems.values())
        {
            if (entry instanceof UniqueStatProvider) ((UniqueStatProvider) entry).getUniqueRelativeValues().forEach((key, value) -> itemsTotalStats.merge(key, value, Double::sum));
        }
        return itemsTotalStats;
    }
}
