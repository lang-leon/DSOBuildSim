package com.langleon.dsobuildsim.character;

import com.langleon.dsobuildsim.buffs.Physic;
import com.langleon.dsobuildsim.buffs.Tonic;
import com.langleon.dsobuildsim.dragonstones.DragonCrestTrinket;
import com.langleon.dsobuildsim.dragonstones.DragonStone;
import com.langleon.dsobuildsim.enums.*;
import com.langleon.dsobuildsim.enums.items.SetType;
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

public class Character {

    private final SetFactory setFactory;

    private final CharacterClass characterClass;
    private String name;

    private List<RuneTrinket> runeTrinkets;
    private List<JewelTrinket> jewelTrinkets;
    private DragonCrestTrinket dragonCrestTrinket;

    private Map<ItemSlot, Item> equippedItems;
    private Map<SetType, SetInstance> equippedSets;

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

        this.runeTrinkets = new ArrayList<>(7);
        for (int i = 0; i < 7; i++) {
            this.runeTrinkets.add(new RuneTrinket());
        }
        this.jewelTrinkets = new ArrayList<>(3);
        for (int i = 0; i < 3; i++) {
            jewelTrinkets.add(new JewelTrinket());
        }
        this.dragonCrestTrinket = new DragonCrestTrinket();

        this.equippedItems = new HashMap<>();
        this.equippedSets = new HashMap<>();

        this.collectorBagBuffs = new HashMap<>();
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

    public void updateRuneTrinket(int index, Rune[] runes)
    {
        this.runeTrinkets.get(index).updateRunes(runes);
    }

    public List<RuneTrinket> getRuneTrinkets() {
        return runeTrinkets;
    }

    public RuneTrinket getRuneTrinket(int index) {
        return runeTrinkets.get(index);
    }

    public void updateJewelTrinket(int index, Jewel[] jewels)
    {
        this.jewelTrinkets.get(index).updateJewels(jewels);
    }

    public List<JewelTrinket> getJewelTrinkets() {
        return jewelTrinkets;
    }

    public JewelTrinket getJewelTrinket(int index) {
        return jewelTrinkets.get(index);
    }

    public void updateDragonCrestTrinket(DragonStone[] dragonStones)
    {
        this.dragonCrestTrinket.updateDragonStones(dragonStones);
    }

    public DragonCrestTrinket getDragonCrestTrinket() {
        return dragonCrestTrinket;
    }

    public void equipItem(ItemSlot slot, Item item)
    {
        if (item.getItemSlotType() != slot.getAllowedItemType()) throw new IllegalArgumentException("Item "+item.getName()+" not allowed in slot "+slot+"!");

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

        Map<StatType, Double> finalStats = new HashMap<>();

        baseStats.forEach(((statType, baseValue) -> {
            double relativeBonus = relativeBonusStats.getOrDefault(statType, 0.0);
            double finalValue = baseValue * (1 + relativeBonus);

            finalStats.put(statType, finalValue);
        }));

        return finalStats;
    }

    private Map<StatType, Double> calculateTotalBaseStats()
    {
        Map<StatType, Double> baseStats = new HashMap<>();
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
        Map<StatType, Double> itemsTotalStats = new HashMap<>();
        for (Item entry : equippedItems.values())
        {
            entry.calculateTotalStats().forEach((key, value) -> itemsTotalStats.merge(key, value, Double::sum));
        }
        return itemsTotalStats;
    }

    private Map<StatType, Double> calculateTotalRelativeStats()
    {
        Map<StatType, Double> relativeBonusStats = new HashMap<>();
        this.characterClass.getClassRelativeStats().forEach((key, value) -> relativeBonusStats.merge(key, value, Double::sum));
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

    private Map<StatType, Double> calculateTotalItemRelativeStats()
    {
        Map<StatType, Double> itemsTotalStats = new HashMap<>();
        for (Item entry : equippedItems.values())
        {
            if (entry instanceof UniqueStatProvider) ((UniqueStatProvider) entry).getUniqueRelativeValues().forEach((key, value) -> itemsTotalStats.merge(key, value, Double::sum));
        }
        return itemsTotalStats;
    }
}
