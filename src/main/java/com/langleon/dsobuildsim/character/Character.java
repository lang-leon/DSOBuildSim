package com.langleon.dsobuildsim.character;

import com.langleon.dsobuildsim.buffs.Physic;
import com.langleon.dsobuildsim.buffs.Tonic;
import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.dragonstones.DragonCrestTrinket;
import com.langleon.dsobuildsim.dragonstones.DragonStone;
import com.langleon.dsobuildsim.gems.AbstractGem;
import com.langleon.dsobuildsim.gems.enums.GemLimitGroup;
import com.langleon.dsobuildsim.items.core.enums.ItemSlot;
import com.langleon.dsobuildsim.jewels.JewelType;
import com.langleon.dsobuildsim.runes.enums.RuneLimitGroup;
import com.langleon.dsobuildsim.sets.SetType;
import com.langleon.dsobuildsim.essences.Essence;
import com.langleon.dsobuildsim.items.core.SetBonusProvider;
import com.langleon.dsobuildsim.items.core.UniqueStatProvider;
import com.langleon.dsobuildsim.sets.*;
import com.langleon.dsobuildsim.items.core.Item;
import com.langleon.dsobuildsim.jewels.Jewel;
import com.langleon.dsobuildsim.jewels.JewelTrinket;
import com.langleon.dsobuildsim.pets.Pet;
import com.langleon.dsobuildsim.runes.Rune;
import com.langleon.dsobuildsim.runes.RuneTrinket;
import com.langleon.dsobuildsim.skilltrees.wisdomskilltree.WisdomSkillTree;

import java.util.*;
import java.util.function.Function;

public class Character {

    private final SetFactory setFactory;

    private final CharacterClass characterClass;
    private String name;

    private MasteryType elementalMasteryType;
    private int elementalMasteryLevel; // 0-10
    private boolean experienceBonusPath;
    private int experienceBonusPathLevel;

    private List<RuneTrinket> runeTrinkets;
    private List<JewelTrinket> jewelTrinkets;
    private DragonCrestTrinket dragonCrestTrinket;

    private Map<ItemSlot, Item> equippedItems;
    private Map<SetType, SetInstance> equippedSets;
    private Map<GemLimitGroup, Integer> gemLimits;
    private Map<RuneLimitGroup, Integer> runeLimits;
    private Map<JewelType, Integer> jewelLimits;

    private Pet pet;
    private Map<StatType, Double> collectorBagBuffs;

    private Essence essence;
    private Tonic tonic;
    private Physic physic;

    private WisdomSkillTree wisdomSkillTree;

    //default constructor
    public Character(CharacterClass characterClass, SetFactory setFactory)
    {
        this.setFactory = setFactory;

        this.characterClass = characterClass;
        this.name = characterClass.getClassName();
        this.elementalMasteryType = MasteryType.NONE;
        this.elementalMasteryLevel = 0;
        this.experienceBonusPath = false;
        this.experienceBonusPathLevel = 0;
        this.gemLimits = new EnumMap<>(GemLimitGroup.class);
        this.runeLimits = new EnumMap<>(RuneLimitGroup.class);
        this.jewelLimits = new EnumMap<>(JewelType.class);

        this.runeTrinkets = new ArrayList<>(7);
        for (int i = 0; i < 7; i++) {
            this.runeTrinkets.add(new RuneTrinket());
        }
        this.jewelTrinkets = new ArrayList<>(3);
        for (int i = 0; i < 3; i++) {
            jewelTrinkets.add(new JewelTrinket());
        }
        this.dragonCrestTrinket = new DragonCrestTrinket();

        this.equippedItems = new EnumMap<>(ItemSlot.class);
        this.equippedSets = new EnumMap<>(SetType.class);

        this.collectorBagBuffs = new EnumMap<>(StatType.class);
        this.wisdomSkillTree = new WisdomSkillTree();
    }

    public CharacterClass getCharacterClass() {
        return characterClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MasteryType getElementalMasteryType() {
        return elementalMasteryType;
    }

    public void setElementalMasteryType(MasteryType masteryType) {
        this.elementalMasteryType = masteryType;
    }

    public int getElementalMasteryLevel() {
        return elementalMasteryLevel;
    }

    public void setElementalMasteryLevel(int masteryLevel) {
        if (masteryLevel < 0 || masteryLevel > 10) throw new IllegalArgumentException("Experience skill tree bonus level must be in range 0-10.");
        this.elementalMasteryLevel = masteryLevel;
    }

    public boolean isExperienceBonusPath() {
        return experienceBonusPath;
    }

    public int getExperienceBonusPathLevel() {
        return experienceBonusPathLevel;
    }

    public void setExperienceBonusPathLevel(int level) {
        if (level < 0 || level > 5) throw new IllegalArgumentException("Experience skill tree bonus level must be in range 0-5.");
        this.experienceBonusPath = level != 0;
        this.experienceBonusPathLevel = level;
    }

    public List<RuneTrinket> getRuneTrinkets() {
        return runeTrinkets;
    }

    public RuneTrinket getRuneTrinket(int index) {
        return runeTrinkets.get(index);
    }

    public void updateRuneTrinket(int index, Rune[] runes)
    {
        Map<RuneLimitGroup, Integer> oldRunes = this.countByLimitGroup(this.runeTrinkets.get(index).getRunes(), Rune::getRuneLimitGroup, RuneLimitGroup.class);
        Map<RuneLimitGroup, Integer> newRunes = this.countByLimitGroup(runes, Rune::getRuneLimitGroup, RuneLimitGroup.class);

        for (Map.Entry<RuneLimitGroup, Integer> entry : newRunes.entrySet()) {
            RuneLimitGroup group = entry.getKey();
            int globalCount = this.runeLimits.getOrDefault(group, 0);
            int oldCount = oldRunes.getOrDefault(group, 0);
            int newCount = entry.getValue();

            if (globalCount - oldCount + newCount > group.getLimit()) {
                throw new IllegalArgumentException("Rune limit exceeded for " + group + ".");
            }
        }

        this.updateGlobalLimits(oldRunes, newRunes, this.runeLimits);
        this.runeTrinkets.get(index).updateRunes(runes);
    }

    public List<JewelTrinket> getJewelTrinkets() {
        return jewelTrinkets;
    }

    public JewelTrinket getJewelTrinket(int index) {
        return jewelTrinkets.get(index);
    }

    public void updateJewelTrinket(int index, Jewel[] jewels)
    {
        Map<JewelType, Integer> oldJewels = this.countByLimitGroup(this.jewelTrinkets.get(index).getJewels(), Jewel::getJewelType, JewelType.class);
        Map<JewelType, Integer> newJewels = this.countByLimitGroup(jewels, Jewel::getJewelType, JewelType.class);

        for (Map.Entry<JewelType, Integer> entry : newJewels.entrySet()) {
            JewelType group = entry.getKey();
            int globalCount = this.jewelLimits.getOrDefault(group, 0);
            int oldCount = oldJewels.getOrDefault(group, 0);
            int newCount = entry.getValue();

            if (globalCount - oldCount + newCount > group.getLimit()) {
                throw new IllegalArgumentException("Jewel limit exceeded for " + group + ".");
            }
        }

        this.updateGlobalLimits(oldJewels, newJewels, this.jewelLimits);
        this.jewelTrinkets.get(index).updateJewels(jewels);
    }

    public DragonCrestTrinket getDragonCrestTrinket() {
        return dragonCrestTrinket;
    }

    public void updateDragonCrestTrinket(DragonStone[] dragonStones)
    {
        this.dragonCrestTrinket.updateDragonStones(dragonStones);
    }

    public void equipItem(ItemSlot slot, Item item)
    {
        if (item.getItemSlotType() != slot.getAllowedItemType()) throw new IllegalArgumentException("Item "+item.getItemType()+" not allowed in slot "+slot+"!");

        Item oldItem = this.equippedItems.get(slot);
        if (oldItem instanceof SetBonusProvider oldSetItem) {
            updateEquippedSetsOnRemoval(oldSetItem);
        }

        this.equippedItems.put(slot, item);
        if (item instanceof SetBonusProvider settableItem)
        {
            SetInstance setInstance = this.equippedSets.computeIfAbsent(settableItem.getSetType(), k -> this.setFactory.createSet(settableItem.getSetType(), CharacterClass.SPELLWEAVER));
            setInstance.addSetItem(settableItem.getSetItemIdentifier());
        }

        Map<GemLimitGroup, Integer> newGems = this.countByLimitGroup(item.getGems(), AbstractGem::getGemLimitGroup, GemLimitGroup.class);
        for (Map.Entry<GemLimitGroup, Integer> entry : newGems.entrySet()) {
            GemLimitGroup group = entry.getKey();
            int globalCount = this.gemLimits.getOrDefault(group, 0);
            int newCount = entry.getValue();

            if (globalCount + newCount > group.getLimit()) {
                throw new IllegalArgumentException("Gem limit exceeded for " + group + ".");
            }
        }

        this.updateGlobalLimits(Map.of(), newGems, this.gemLimits);
    }

    public void unequipItem(ItemSlot slot)
    {
        Item removedItem = this.equippedItems.remove(slot);
        if (removedItem != null)
        {
            if (removedItem instanceof SetBonusProvider settableItem)
            {
                this.updateEquippedSetsOnRemoval(settableItem);
            }
        }
    }

    public void updateItemGems(ItemSlot slot, AbstractGem[] gems)
    {
        Item eqippedItem = this.equippedItems.get(slot);
        if (eqippedItem == null) throw new IllegalArgumentException("Can't update gems for non equipped item in slot "+slot+".");
        Map<GemLimitGroup, Integer> oldGems = this.countByLimitGroup(eqippedItem.getGems(), AbstractGem::getGemLimitGroup, GemLimitGroup.class);
        Map<GemLimitGroup, Integer> newGems = this.countByLimitGroup(gems, AbstractGem::getGemLimitGroup, GemLimitGroup.class);

        for (Map.Entry<GemLimitGroup, Integer> entry : newGems.entrySet()) {
            GemLimitGroup group = entry.getKey();
            int globalCount = this.gemLimits.getOrDefault(group, 0);
            int oldCount = oldGems.getOrDefault(group, 0);
            int newCount = entry.getValue();

            if (globalCount - oldCount + newCount > group.getLimit()) {
                throw new IllegalArgumentException("Gem limit exceeded for " + group + ".");
            }
        }

        this.updateGlobalLimits(oldGems, newGems, this.gemLimits);
        this.equippedItems.get(slot).setGems(gems);
    }

    private <T, G extends Enum<G>> Map<G, Integer> countByLimitGroup(T[] items, Function<T, G> groupExtractor, Class<G> enumClass)
    {
        Map<G, Integer> result = new EnumMap<>(enumClass);

        for (T item : items)
        {
            if (item == null) continue;
            result.merge(groupExtractor.apply(item), 1, Integer::sum);
        }

        return result;
    }

    private <G extends Enum<G>> void updateGlobalLimits(Map<G, Integer> oldCount, Map<G, Integer> newCount, Map<G, Integer> globalCount)
    {
        for (Map.Entry<G, Integer> entry : oldCount.entrySet()) {
            globalCount.computeIfPresent(entry.getKey(), (_, amount) -> {
                int result = amount - entry.getValue();
                return result <= 0 ? null : result;
            });
        }

        for (Map.Entry<G, Integer> entry : newCount.entrySet()) {
            globalCount.merge(entry.getKey(), entry.getValue(), Integer::sum);
        }
    }

    private void updateEquippedSetsOnRemoval(SetBonusProvider settableItem)
    {
        SetInstance setInstance = this.equippedSets.get(settableItem.getSetType());

        if (setInstance != null)
        {
            setInstance.removeSetItem(settableItem.getSetType().toString());
            if (setInstance.getEquippedSetItems().isEmpty())
            {
                this.equippedSets.remove(settableItem.getSetType());
            }
        }
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Map<StatType, Double> getCollectorBagBuffs() {
        return collectorBagBuffs;
    }

    public void setCollectorBagBuffs(Map<StatType, Double> collectorBagBuffs) {
        this.collectorBagBuffs = collectorBagBuffs;
    }

    public Essence getEssence() {
        return essence;
    }

    public void setEssence(Essence essence) {
        this.essence = essence;
    }

    public Tonic getTonic() {
        return tonic;
    }

    public void setTonic(Tonic tonic) {
        this.tonic = tonic;
    }

    public Physic getPhysic() {
        return physic;
    }

    public void setPhysic(Physic physic) {
        this.physic = physic;
    }

    public WisdomSkillTree getWisdomSkillTree() {
        return wisdomSkillTree;
    }

    public void setWisdomSkillTree(WisdomSkillTree wisdomSkillTree) {
        this.wisdomSkillTree = wisdomSkillTree;
    }

    public Map<StatType, Double> calculateCharacterStats()
    {
        Map<StatType, Double> baseStats = this.calculateTotalBaseStats();
        Map<StatType, Double> relativeBonusStats = this.calculateTotalRelativeStats();

        if (this.equippedItems.containsKey(ItemSlot.ONE_HAND_WEAPON))
        {
            Double absoluteOneHandDamage = baseStats.getOrDefault(StatType.ONE_HAND_DAMAGE, 0.0);
            baseStats.remove(StatType.ONE_HAND_DAMAGE);
            Double relativeOneHandDamage = relativeBonusStats.getOrDefault(StatType.ONE_HAND_DAMAGE, 0.0);
            relativeBonusStats.remove(StatType.ONE_HAND_DAMAGE);
            double bonusOneHandDamage = this.equippedItems.get(ItemSlot.ONE_HAND_WEAPON).calculateTotalStats().get(StatType.DAMAGE) * relativeOneHandDamage;
            bonusOneHandDamage += absoluteOneHandDamage * (1 + relativeOneHandDamage);
            baseStats.merge(StatType.DAMAGE, bonusOneHandDamage, Double::sum);

            Double absoluteOneHandAttackSpeed = baseStats.getOrDefault(StatType.ONE_HAND_ATTACK_SPEED, 0.0);
            baseStats.remove(StatType.ONE_HAND_ATTACK_SPEED);
            baseStats.merge(StatType.ATTACK_SPEED, absoluteOneHandAttackSpeed, Double::sum);
        }
        else if (this.equippedItems.containsKey(ItemSlot.TWO_HAND_WEAPON))
        {
            Double absoluteTwoHandDamage = baseStats.getOrDefault(StatType.TWO_HAND_DAMAGE, 0.0);
            baseStats.remove(StatType.TWO_HAND_DAMAGE);
            Double relativeTwoHandDamage = relativeBonusStats.getOrDefault(StatType.TWO_HAND_DAMAGE, 0.0);
            relativeBonusStats.remove(StatType.TWO_HAND_DAMAGE);
            double bonusTwoHandDamage = this.equippedItems.get(ItemSlot.TWO_HAND_WEAPON).calculateTotalStats().get(StatType.DAMAGE) * relativeTwoHandDamage;
            bonusTwoHandDamage += absoluteTwoHandDamage * (1 + relativeTwoHandDamage);
            baseStats.merge(StatType.DAMAGE, bonusTwoHandDamage, Double::sum);

            Double absoluteTwoHandAttackSpeed = baseStats.getOrDefault(StatType.TWO_HAND_ATTACK_SPEED, 0.0);
            baseStats.remove(StatType.TWO_HAND_ATTACK_SPEED);
            baseStats.merge(StatType.ATTACK_SPEED, absoluteTwoHandAttackSpeed, Double::sum);
        }

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
        this.characterClass.getClassBaseStats().forEach((key, value) -> baseStats.merge(key, value, Double::sum));
        this.wisdomSkillTree.getAbsoluteBuffs().forEach((key, value) -> baseStats.merge(key, value, Double::sum));
        this.calculateTotalItemBaseStats().forEach((key, value) -> baseStats.merge(key, value, Double::sum));
        this.equippedSets.forEach((setType, setInstance) -> setInstance.getActiveBaseValues().forEach((key, value) -> baseStats.merge(key, value, Double::sum)));
        if (this.tonic != null) baseStats.merge(this.tonic.statType(), this.tonic.statValue(), Double::sum);

        Double resistanceValue = baseStats.remove(StatType.RESISTANCE_VALUE);
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
        this.characterClass.getClassRelativeStats().forEach((key, value) -> relativeBonusStats.merge(key, value, Double::sum));
        this.calculateExperienceSkillTreeRelativeStats().forEach((key, value) -> relativeBonusStats.merge(key, value, Double::sum));
        this.calculateTotalItemRelativeStats().forEach((key, value) -> relativeBonusStats.merge(key, value, Double::sum));
        this.equippedSets.forEach((setType, setInstance) -> setInstance.getActiveRelativeValues().forEach((key, value) -> relativeBonusStats.merge(key, value, Double::sum)));
        this.runeTrinkets.forEach(trinket -> trinket.getTotalRelativeStats().forEach((key, value) -> relativeBonusStats.merge(key, value, Double::sum)));
        this.jewelTrinkets.forEach(trinket -> trinket.getTotalRelativeStats().forEach((key, value) -> relativeBonusStats.merge(key, value, Double::sum)));
        this.dragonCrestTrinket.getTotalRelativeStats().forEach((key, value) -> relativeBonusStats.merge(key, value, Double::sum));
        if (this.pet !=null)
        {
            this.pet.getRelativeStats().forEach((key, value) -> relativeBonusStats.merge(key, value, Double::sum));
            this.collectorBagBuffs.forEach((key, value) -> relativeBonusStats.merge(key, value, Double::sum));
        }
        if (this.essence != null) relativeBonusStats.merge(StatType.DAMAGE, this.essence.damageIncrease(), Double::sum);
        if (this.physic != null) relativeBonusStats.merge(this.physic.statType(), this.physic.statValue(), Double::sum);

        Double resistanceValue = relativeBonusStats.remove(StatType.RESISTANCE_VALUE);
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
