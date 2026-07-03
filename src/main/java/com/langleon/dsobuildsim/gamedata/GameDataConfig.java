package com.langleon.dsobuildsim.gamedata;

import com.langleon.dsobuildsim.buffs.BuffConfig;
import com.langleon.dsobuildsim.character.CharacterClass;
import com.langleon.dsobuildsim.collectorbagbonus.CollectorBagConfig;
import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.dragonstones.DragonStoneDefinition;
import com.langleon.dsobuildsim.dragonstones.DragonStoneType;
import com.langleon.dsobuildsim.essences.EssenceType;
import com.langleon.dsobuildsim.gamedata.dto.ClassStatsDTO;
import com.langleon.dsobuildsim.enchantments.EnchantmentDefinition;
import com.langleon.dsobuildsim.essences.EssenceDefinition;
import com.langleon.dsobuildsim.gems.GemDefinition;
import com.langleon.dsobuildsim.gems.enums.GemType;
import com.langleon.dsobuildsim.items.mythicitems.MythicItemDefinition;
import com.langleon.dsobuildsim.items.mythicitems.MythicItemType;
import com.langleon.dsobuildsim.items.setitems.SetItemDefinition;
import com.langleon.dsobuildsim.items.setitems.SetItemType;
import com.langleon.dsobuildsim.items.uniqueitems.UniqueItemDefinition;
import com.langleon.dsobuildsim.items.uniqueitems.UniqueItemType;
import com.langleon.dsobuildsim.jewels.JewelDefinition;
import com.langleon.dsobuildsim.jewels.JewelType;
import com.langleon.dsobuildsim.pets.PetDefinition;
import com.langleon.dsobuildsim.pets.enums.PetType;
import com.langleon.dsobuildsim.runes.RuneDefinition;
import com.langleon.dsobuildsim.runes.enums.RuneType;
import com.langleon.dsobuildsim.sets.SetDefinition;
import com.langleon.dsobuildsim.sets.SetType;
import com.langleon.dsobuildsim.wisdomskilltree.WisdomSkillTreeConfig;

import java.util.Map;

public record GameDataConfig(
        Map<CharacterClass, ClassStatsDTO> classStats,
        Map<CharacterClass, Map<MythicItemType, MythicItemDefinition>> mythicItems,
        Map<CharacterClass, Map<SetItemType, SetItemDefinition>> setItems,
        Map<CharacterClass, Map<UniqueItemType, UniqueItemDefinition>> uniqueItems,
        Map<CharacterClass, Map<SetType, SetDefinition>> sets,
        Map<CharacterClass, Map<JewelType, JewelDefinition>> jewels,
        Map<StatType, EnchantmentDefinition> enchantments,
        Map<GemType, GemDefinition> gems,
        Map<RuneType, RuneDefinition> runes,
        Map<DragonStoneType, DragonStoneDefinition> dragonStones,
        Map<PetType, PetDefinition> pets,
        Map<EssenceType, EssenceDefinition> essences,
        BuffConfig buffConfig,
        LevelMultiplierTable levelMultiplierTable,
        WisdomSkillTreeConfig wisdomSkillConfig,
        CollectorBagConfig collectorBagConfig
) {
}
