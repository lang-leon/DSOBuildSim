package com.langleon.dsobuildsim.gamedata.dto;

import com.langleon.dsobuildsim.buffs.dto.BuffDefinitionDTO;
import com.langleon.dsobuildsim.character.CharacterClass;
import com.langleon.dsobuildsim.collectorbagbonus.dto.definition.CollectorBagCategoryBonusDefinitionDTO;
import com.langleon.dsobuildsim.dragonstones.DragonStoneType;
import com.langleon.dsobuildsim.dragonstones.dto.DragonStoneDefinitionDTO;
import com.langleon.dsobuildsim.gems.enums.GemLimitGroup;
import com.langleon.dsobuildsim.gems.enums.GemType;
import com.langleon.dsobuildsim.items.core.enums.ItemType;
import com.langleon.dsobuildsim.items.dto.ItemDefinitionDTO;
import com.langleon.dsobuildsim.jewels.JewelLimitGroup;
import com.langleon.dsobuildsim.jewels.JewelType;
import com.langleon.dsobuildsim.runes.enums.RuneLimitGroup;
import com.langleon.dsobuildsim.runes.enums.RuneType;
import com.langleon.dsobuildsim.sets.SetType;
import com.langleon.dsobuildsim.wisdomskilltree.dto.definition.WisdomGroupDefinitionDTO;
import com.langleon.dsobuildsim.wisdomskilltree.dto.definition.WisdomSkillDefinitionDTO;
import com.langleon.dsobuildsim.enchantments.dto.EnchantmentDTO;
import com.langleon.dsobuildsim.essences.dto.EssenceDefinitionDTO;
import com.langleon.dsobuildsim.gems.dto.GemDefinitionDTO;
import com.langleon.dsobuildsim.jewels.dto.JewelDefinitionDTO;
import com.langleon.dsobuildsim.pets.dto.PetDefinitionDTO;
import com.langleon.dsobuildsim.runes.dto.RuneDefinitionDTO;
import com.langleon.dsobuildsim.sets.dto.SetDTO;
import com.langleon.dsobuildsim.wisdomskilltree.wisdomgroup.WisdomGroupType;
import com.langleon.dsobuildsim.wisdomskilltree.wisdomskill.WisdomSkillType;

import java.util.List;
import java.util.Map;

public record GameDataDTO (
        Map<CharacterClass, ClassStatsDTO> characterClassStats,
        Map<CharacterClass, Map<ItemType, ItemDefinitionDTO>> items,
        Map<CharacterClass, Map<SetType, SetDTO>> sets,
        Map<CharacterClass, Map<JewelType, JewelDefinitionDTO>> jewels,
        Map<JewelLimitGroup, Integer> jewelLimits,
        List<EnchantmentDTO> enchantments,
        Map<GemType, GemDefinitionDTO> gems,
        Map<GemLimitGroup, Integer> gemLimits,
        Map<RuneType, RuneDefinitionDTO> runes,
        Map<RuneLimitGroup, Integer> runeLimits,
        Map<DragonStoneType, DragonStoneDefinitionDTO> dragonStones,
        List<PetDefinitionDTO> pets,
        List<EssenceDefinitionDTO> essences,
        List<BuffDefinitionDTO> tonics,
        List<BuffDefinitionDTO> physics,
        LevelMultiplierTableDTO levelMultiplierTable,
        Map<WisdomSkillType, WisdomSkillDefinitionDTO> wisdomSkills,
        Map<WisdomGroupType, WisdomGroupDefinitionDTO> wisdomGroups,
        List<CollectorBagCategoryBonusDefinitionDTO> collectorBagBuffs
        )
{
}
