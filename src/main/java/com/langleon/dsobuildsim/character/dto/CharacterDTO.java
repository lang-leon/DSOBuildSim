package com.langleon.dsobuildsim.character.dto;

import com.langleon.dsobuildsim.character.CharacterClass;
import com.langleon.dsobuildsim.character.MasteryType;
import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.dto.*;
import com.langleon.dsobuildsim.items.core.enums.ItemSlot;

import java.util.List;
import java.util.Map;

public record CharacterDTO(CharacterClass characterClass,
                           String name,
                           MasteryType masteryType,
                           int masteryLevel,
                           boolean experienceBonus,
                           int experienceBonusLevel,
                           List<List<RuneDTO>> runeTrinkets,
                           List<List<JewelDTO>> jewelTrinkets,
                           List<DragonStoneDTO> dragonCrest,
                           Map<ItemSlot, ItemDTO> items,
                           PetDTO pet,
                           Map<StatType, Double> collectorBagBuffs,
                           EssenceDTO essence,
                           BuffDTO tonic,
                           BuffDTO physic,
                           WisdomSkillTreeDTO wisdomSkillTree
                           ) {
}
