package com.langleon.dsobuildsim.gamedata.dto;

import com.langleon.dsobuildsim.buffs.dto.BuffDefinitionDTO;
import com.langleon.dsobuildsim.character.CharacterClass;
import com.langleon.dsobuildsim.dragonstones.dto.DragonStoneDefinitionDTO;
import com.langleon.dsobuildsim.items.dto.ItemDefinitionDTO;
import com.langleon.dsobuildsim.wisdomskilltree.dto.definition.WisdomSkillTreeDefinitionDTO;
import com.langleon.dsobuildsim.enchantments.dto.EnchantmentDTO;
import com.langleon.dsobuildsim.essences.dto.EssenceDefinitionDTO;
import com.langleon.dsobuildsim.gems.dto.GemDefinitionDTO;
import com.langleon.dsobuildsim.jewels.dto.JewelDefinitionDTO;
import com.langleon.dsobuildsim.pets.dto.PetDefinitionDTO;
import com.langleon.dsobuildsim.runes.dto.RuneDefinitionDTO;
import com.langleon.dsobuildsim.sets.dto.SetDTO;

import java.util.List;
import java.util.Map;

public record GameDataDTO (
        Map<CharacterClass, ClassStatsDTO> characterClassStats,
        Map<CharacterClass, List<ItemDefinitionDTO>> items,
        Map<CharacterClass, List<SetDTO>> sets,
        Map<CharacterClass, List<JewelDefinitionDTO>> jewels,
        List<EnchantmentDTO> enchantments,
        List<GemDefinitionDTO> gems,
        List<RuneDefinitionDTO> runes,
        List<DragonStoneDefinitionDTO> dragonStones,
        List<PetDefinitionDTO> pets,
        List<EssenceDefinitionDTO> essences,
        List<BuffDefinitionDTO> tonics,
        List<BuffDefinitionDTO> physics,
        LevelMultiplierTableDTO levelMultiplierTable,
        WisdomSkillTreeDefinitionDTO wisdomSkillTree
        )
{
}
