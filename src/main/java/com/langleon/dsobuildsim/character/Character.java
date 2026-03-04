package com.langleon.dsobuildsim.character;

import com.langleon.dsobuildsim.buffs.Physic;
import com.langleon.dsobuildsim.buffs.Tonic;
import com.langleon.dsobuildsim.dragonstones.DragonCrestTrinket;
import com.langleon.dsobuildsim.dragonstones.DragonStone;
import com.langleon.dsobuildsim.enums.*;
import com.langleon.dsobuildsim.enums.items.SetType;
import com.langleon.dsobuildsim.essences.Essence;
import com.langleon.dsobuildsim.items.core.SettableItem;
import com.langleon.dsobuildsim.sets.*;
import com.langleon.dsobuildsim.items.core.AbstractItem;
import com.langleon.dsobuildsim.items.mythicitems.MythicItem;
import com.langleon.dsobuildsim.items.setitems.SetItem;
import com.langleon.dsobuildsim.items.uniqueitems.UniqueItem;
import com.langleon.dsobuildsim.jewels.Jewel;
import com.langleon.dsobuildsim.jewels.JewelTrinket;
import com.langleon.dsobuildsim.mapper.AbsoluteToRelativeStatTypeMapper;
import com.langleon.dsobuildsim.overallbuffs.OverallAbsolutBuff;
import com.langleon.dsobuildsim.overallbuffs.OverallBuff;
import com.langleon.dsobuildsim.overallbuffs.OverallRelativeBuff;
import com.langleon.dsobuildsim.pets.Pet;
import com.langleon.dsobuildsim.runes.Rune;
import com.langleon.dsobuildsim.runes.RuneTrinket;
import com.langleon.dsobuildsim.skilltrees.wisdomskilltree.WisdomSkillTree;

import java.util.*;

public class Character {

    private final CharacterClass characterClass;
    private String name;

    private List<RuneTrinket> runeTrinkets;
    private List<JewelTrinket> jewelTrinkets;
    private DragonCrestTrinket dragonCrestTrinket;

    private Map<ItemSlot, AbstractItem> equippedItems;
    private Map<SetType, SetInstance> equippedSets;

    private Pet pet;
    private Map<StatType, Double> collectorBagBuffs;

    private Essence essence;
    private Tonic tonic;
    private Physic physic;

    private WisdomSkillTree wisdomSkillTree;

    //default constructor
    public Character(CharacterClass characterClass)
    {
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

    public void equipItem(AbstractItem item, ItemSlot slot)
    {
        if (item.getItemSlotType() != slot.getAllowedItemType()) throw new IllegalArgumentException("Item "+item.getName()+" not allowed in slot "+slot+"!");

    }

    public void unequipItem(ItemSlot slot)
    {
        AbstractItem removedItem = this.equippedItems.remove(slot);
        if (removedItem != null)
        {
            if (removedItem instanceof SettableItem settableItem)
            {
                this.updateEquippedSetsOnRemoval(settableItem);
            }
        }
    }

    private void updateEquippedSetsOnRemoval(SettableItem settableItem)
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
}
