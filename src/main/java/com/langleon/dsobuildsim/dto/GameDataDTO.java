package com.langleon.dsobuildsim.dto;

import com.langleon.dsobuildsim.character.CharacterClass;

import java.util.List;
import java.util.Map;

public record GameDataDTO (
        Map<CharacterClass, ClassStatsDTO> characterClassClassStats,
        Map<CharacterClass, List<ItemDefinitionDTO>> items,
        Map<CharacterClass, List<SetDTO>> sets,
        Map<CharacterClass, List<JewelDTO>> jewels,
        List<EnchantmentDTO> enchantments,
        List<GemDTO> gems,
        List<RuneDTO> runes,
        List<DragonStoneDTO> dragonStones,
        List<PetDTO> pets,
        List<EssenceDTO> essences,
        List<BuffDTO> tonics,
        List<BuffDTO> physics,
        LevelMultiplierTableDTO levelMultiplierTable
        )
{
}
