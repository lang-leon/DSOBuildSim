package com.langleon.dsobuildsim.gamedata;

import com.langleon.dsobuildsim.buffs.PhysicDefinition;
import com.langleon.dsobuildsim.buffs.TonicDefinition;
import com.langleon.dsobuildsim.character.CharacterClass;
import com.langleon.dsobuildsim.dragonstones.DragonStoneDefinition;
import com.langleon.dsobuildsim.dto.ClassStatsDTO;
import com.langleon.dsobuildsim.enchantments.EnchantmentDefinition;
import com.langleon.dsobuildsim.essences.EssenceDefinition;
import com.langleon.dsobuildsim.gems.GemDefinition;
import com.langleon.dsobuildsim.items.core.ItemDefinition;
import com.langleon.dsobuildsim.items.core.LevelMultiplierTable;
import com.langleon.dsobuildsim.jewels.JewelDefinition;
import com.langleon.dsobuildsim.pets.PetDefinition;
import com.langleon.dsobuildsim.runes.RuneDefinition;
import com.langleon.dsobuildsim.sets.SetDefinition;

import java.util.List;
import java.util.Map;

public record GameDataConfig(
        Map<CharacterClass, ClassStatsDTO> classStats,
        Map<CharacterClass, List<ItemDefinition>> items,
        Map<CharacterClass, List<SetDefinition>> sets,
        Map<CharacterClass, List<JewelDefinition>> jewels,
        List<EnchantmentDefinition> enchantments,
        List<GemDefinition> gems,
        List<RuneDefinition> runes,
        List<DragonStoneDefinition> dragonStones,
        List<PetDefinition> pets,
        List<EssenceDefinition> essences,
        List<TonicDefinition> tonics,
        List<PhysicDefinition> physics,
        LevelMultiplierTable levelMultiplierTable
) {
}
