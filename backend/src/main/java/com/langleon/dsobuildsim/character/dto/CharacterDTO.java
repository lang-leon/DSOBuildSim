package com.langleon.dsobuildsim.character.dto;

import com.langleon.dsobuildsim.buffs.dto.BuffInstanceDTO;
import com.langleon.dsobuildsim.character.CharacterClass;
import com.langleon.dsobuildsim.character.ClassSkillType;
import com.langleon.dsobuildsim.character.MasteryType;
import com.langleon.dsobuildsim.collectorbagbonus.dto.instance.CollectorBagCategoryBonusInstanceDTO;
import com.langleon.dsobuildsim.dragonstones.dto.DragonCrestTrinketDTO;
import com.langleon.dsobuildsim.essences.dto.EssenceInstanceDTO;
import com.langleon.dsobuildsim.items.core.enums.ItemSlot;
import com.langleon.dsobuildsim.items.dto.ItemInstanceDTO;
import com.langleon.dsobuildsim.jewels.dto.JewelTrinketDTO;
import com.langleon.dsobuildsim.pets.dto.PetInstanceDTO;
import com.langleon.dsobuildsim.runes.dto.RuneTrinketDTO;
import com.langleon.dsobuildsim.wisdomskilltree.dto.instance.WisdomSkillTreeInstanceDTO;

import java.util.List;
import java.util.Map;

public record CharacterDTO(CharacterClass characterClass,
                           String name,
                           MasteryType masteryType,
                           int masteryLevel,
                           ClassSkillType classSkillType,
                           int classSkillLevel,
                           List<RuneTrinketDTO> runeTrinkets,
                           List<JewelTrinketDTO> jewelTrinkets,
                           DragonCrestTrinketDTO dragonCrest,
                           Map<ItemSlot, ItemInstanceDTO> items,
                           PetInstanceDTO pet,
                           EssenceInstanceDTO essence,
                           BuffInstanceDTO tonic,
                           BuffInstanceDTO physic,
                           WisdomSkillTreeInstanceDTO wisdomSkillTree,
                           List<CollectorBagCategoryBonusInstanceDTO> collectorBagBuffs
                           ) {
}
