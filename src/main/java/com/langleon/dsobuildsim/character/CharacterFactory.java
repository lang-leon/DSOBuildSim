package com.langleon.dsobuildsim.character;

import com.langleon.dsobuildsim.buffs.BuffFactory;
import com.langleon.dsobuildsim.character.dto.CharacterDTO;
import com.langleon.dsobuildsim.collectorbagbonus.CollectorBagFactory;
import com.langleon.dsobuildsim.dragonstones.DragonStoneFactory;
import com.langleon.dsobuildsim.essences.EssenceFactory;
import com.langleon.dsobuildsim.items.core.Item;
import com.langleon.dsobuildsim.items.core.ItemResolver;
import com.langleon.dsobuildsim.items.core.SetBonusProvider;
import com.langleon.dsobuildsim.items.core.enums.ItemSlot;
import com.langleon.dsobuildsim.jewels.JewelFactory;
import com.langleon.dsobuildsim.pets.PetFactory;
import com.langleon.dsobuildsim.runes.RuneFactory;
import com.langleon.dsobuildsim.sets.SetFactory;
import com.langleon.dsobuildsim.sets.SetInstance;
import com.langleon.dsobuildsim.sets.SetType;
import com.langleon.dsobuildsim.wisdomskilltree.WisdomSkillTreeResolver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CharacterFactory {

    private final RuneFactory runeFactory;
    private final JewelFactory jewelFactory;
    private final DragonStoneFactory dragonStoneFactory;
    private final ItemResolver itemResolver;
    private final SetFactory setFactory;
    private final PetFactory petFactory;
    private final EssenceFactory essenceFactory;
    private final BuffFactory buffFactory;
    private final WisdomSkillTreeResolver wisdomSkillTreeResolver;
    private final CollectorBagFactory collectorBagFactory;

    public CharacterFactory(RuneFactory runeFactory, JewelFactory jewelFactory, DragonStoneFactory dragonStoneFactory, ItemResolver itemResolver, SetFactory setFactory, PetFactory petFactory, EssenceFactory essenceFactory, BuffFactory buffFactory, WisdomSkillTreeResolver wisdomSkillTreeResolver, CollectorBagFactory collectorBagFactory) {
        this.runeFactory = runeFactory;
        this.jewelFactory = jewelFactory;
        this.dragonStoneFactory = dragonStoneFactory;
        this.itemResolver = itemResolver;
        this.setFactory = setFactory;
        this.petFactory = petFactory;
        this.essenceFactory = essenceFactory;
        this.buffFactory = buffFactory;
        this.wisdomSkillTreeResolver = wisdomSkillTreeResolver;
        this.collectorBagFactory = collectorBagFactory;
    }

    public Character fromDTO(CharacterDTO dto)
    {
        Map<ItemSlot, Item> items = itemResolver.fromDTOMap(dto.items(), dto.characterClass());

        return new Character(
                dto.characterClass(),
                dto.masteryType(),
                dto.masteryLevel(),
                dto.experienceBonus(),
                dto.experienceBonusLevel(),
                runeFactory.fromTrinketDTOList(dto.runeTrinkets()),
                jewelFactory.fromTrinketDTOs(dto.jewelTrinkets(), dto.characterClass()),
                dragonStoneFactory.fromDTO(dto.dragonCrest()),
                items,
                this.calculateEquippedSets(items.values().stream().toList()),
                petFactory.fromDTO(dto.pet()),
                essenceFactory.fromDTO(dto.essence()),
                buffFactory.tonicFromDTO(dto.tonic()),
                buffFactory.physicFromDTO(dto.physic()),
                wisdomSkillTreeResolver.resolveWisdomSkillTree(dto.wisdomSkillTree()),
                collectorBagFactory.fromDTOList(dto.collectorBagBuffs())
        );
    }

    private Map<SetType, SetInstance> calculateEquippedSets(List<Item> items)
    {
        Map<SetType, SetInstance> equippedSets = new HashMap<>();

        items.forEach(item -> {
            if (item instanceof SetBonusProvider settableItem)
            {
                SetInstance setInstance = equippedSets.computeIfAbsent(settableItem.getSetType(), k -> this.setFactory.createSet(settableItem.getSetType(), CharacterClass.SPELLWEAVER));
                setInstance.addSetItem(settableItem.getSetItemIdentifier());
            }
        });

        return equippedSets;
    }
}
