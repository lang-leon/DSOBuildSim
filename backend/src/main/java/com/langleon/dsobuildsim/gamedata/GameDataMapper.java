package com.langleon.dsobuildsim.gamedata;

import com.langleon.dsobuildsim.buffs.BuffMapper;
import com.langleon.dsobuildsim.buffs.dto.BuffDefinitionDTO;
import com.langleon.dsobuildsim.character.CharacterClass;
import com.langleon.dsobuildsim.collectorbagbonus.CollectorBagMapper;
import com.langleon.dsobuildsim.collectorbagbonus.dto.definition.CollectorBagCategoryBonusDefinitionDTO;
import com.langleon.dsobuildsim.dragonstones.DragonStoneType;
import com.langleon.dsobuildsim.dragonstones.dto.DragonStoneDefinitionDTO;
import com.langleon.dsobuildsim.dragonstones.DragonStoneMapper;
import com.langleon.dsobuildsim.enchantments.EnchantmentMapper;
import com.langleon.dsobuildsim.enchantments.dto.EnchantmentDTO;
import com.langleon.dsobuildsim.essences.EssenceMapper;
import com.langleon.dsobuildsim.essences.dto.EssenceDefinitionDTO;
import com.langleon.dsobuildsim.gamedata.dto.GameDataDTO;
import com.langleon.dsobuildsim.gamedata.dto.LevelMultiplierTableDTO;
import com.langleon.dsobuildsim.gems.GemMapper;
import com.langleon.dsobuildsim.gems.dto.GemDefinitionDTO;
import com.langleon.dsobuildsim.gems.enums.GemLimitGroup;
import com.langleon.dsobuildsim.gems.enums.GemType;
import com.langleon.dsobuildsim.items.core.enums.ItemType;
import com.langleon.dsobuildsim.items.dto.ItemDefinitionDTO;
import com.langleon.dsobuildsim.jewels.JewelLimitGroup;
import com.langleon.dsobuildsim.jewels.JewelMapper;
import com.langleon.dsobuildsim.jewels.JewelType;
import com.langleon.dsobuildsim.jewels.dto.JewelDefinitionDTO;
import com.langleon.dsobuildsim.items.core.ItemDefinitionMapper;
import com.langleon.dsobuildsim.runes.enums.RuneLimitGroup;
import com.langleon.dsobuildsim.runes.enums.RuneType;
import com.langleon.dsobuildsim.sets.SetType;
import com.langleon.dsobuildsim.wisdomskilltree.WisdomSkillTreeMapper;
import com.langleon.dsobuildsim.pets.PetMapper;
import com.langleon.dsobuildsim.pets.dto.PetDefinitionDTO;
import com.langleon.dsobuildsim.runes.RuneMapper;
import com.langleon.dsobuildsim.runes.dto.RuneDefinitionDTO;
import com.langleon.dsobuildsim.sets.SetMapper;
import com.langleon.dsobuildsim.sets.dto.SetDTO;
import com.langleon.dsobuildsim.wisdomskilltree.dto.definition.WisdomGroupDefinitionDTO;
import com.langleon.dsobuildsim.wisdomskilltree.dto.definition.WisdomSkillDefinitionDTO;
import com.langleon.dsobuildsim.wisdomskilltree.wisdomgroup.WisdomGroupType;
import com.langleon.dsobuildsim.wisdomskilltree.wisdomskill.WisdomSkillType;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameDataMapper {

    public static GameDataDTO toDTO(GameDataConfig config)
    {
        Map<CharacterClass, Map<ItemType, ItemDefinitionDTO>> items =
                Arrays.stream(CharacterClass.values())
                        .collect(Collectors.toMap(
                                clazz -> clazz,
                                clazz -> Stream.of(
                                                config.mythicItems().get(clazz),
                                                config.setItems().get(clazz),
                                                config.uniqueItems().get(clazz)
                                        )
                                        .filter(Objects::nonNull)
                                        .flatMap(map -> map.values().stream())
                                        .map(ItemDefinitionMapper::from)
                                        .collect(Collectors.toMap(
                                                ItemDefinitionDTO::itemType,
                                                Function.identity()
                                        ))
                        ));

        Map<CharacterClass, Map<SetType, SetDTO>> sets =
                mapPerClass(config.sets(), SetMapper::from);

        Map<CharacterClass, Map<JewelType, JewelDefinitionDTO>> jewels =
                mapPerClass(config.jewels(), JewelMapper::from);

        Map<JewelLimitGroup, Integer> jewelLimits = Arrays.stream(JewelLimitGroup.values())
                .collect(Collectors.toMap(
                        group -> group,
                        JewelLimitGroup::getLimit
                ));

        List<EnchantmentDTO> enchantments = config.enchantments().values().stream().map(EnchantmentMapper::from).toList();

        Map<GemType, GemDefinitionDTO> gems = config.gems().entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, entry -> GemMapper.from(entry.getValue())));

        Map<GemLimitGroup, Integer> gemLimits = Arrays.stream(GemLimitGroup.values())
                .collect(Collectors.toMap(
                        group -> group,
                        GemLimitGroup::getLimit
                ));

        Map<RuneType, RuneDefinitionDTO> runes = config.runes().entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, entry -> RuneMapper.from(entry.getValue())));

        Map<RuneLimitGroup, Integer> runeLimits = Arrays.stream(RuneLimitGroup.values())
                .collect(Collectors.toMap(
                        group -> group,
                        RuneLimitGroup::getLimit
                ));

        Map<DragonStoneType, DragonStoneDefinitionDTO> dragonStones = config.dragonStones().entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, entry -> DragonStoneMapper.from(entry.getValue())));

        List<PetDefinitionDTO> pets = config.pets().values().stream().map(PetMapper::from).toList();

        List<EssenceDefinitionDTO> essences = config.essences().values().stream().map(EssenceMapper::from).toList();

        List<BuffDefinitionDTO> tonics = config.buffConfig().tonics().values().stream().map(BuffMapper::from).toList();

        List<BuffDefinitionDTO> physics = config.buffConfig().physics().values().stream().map(BuffMapper::from).toList();

        LevelMultiplierTableDTO levelMultiplierTable = LevelMultiplierTableMapper.from(config.levelMultiplierTable());

        Map<WisdomSkillType, WisdomSkillDefinitionDTO> wisdomSkills = WisdomSkillTreeMapper.fromSkills(config.wisdomSkills());

        Map<WisdomGroupType, WisdomGroupDefinitionDTO> wisdomGroups = WisdomSkillTreeMapper.fromGroups(config.wisdomGroups());

        List<CollectorBagCategoryBonusDefinitionDTO> collectorBagBuffs = config.collectorBagConfig().categoryBonuses().values().stream().map(categoryBonus -> CollectorBagMapper.from(categoryBonus, config.collectorBagConfig())).toList();

        return new GameDataDTO(config.classStats(), items, sets, jewels, jewelLimits, enchantments, gems, gemLimits, runes, runeLimits, dragonStones, pets, essences, tonics, physics, levelMultiplierTable, wisdomSkills, wisdomGroups, collectorBagBuffs);
    }

    private static <K, S, T> Map<CharacterClass, Map<K, T>> mapPerClass(
            Map<CharacterClass, Map<K, S>> source,
            Function<S, T> mapper)
    {
        return source.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue().entrySet().stream()
                                .collect(Collectors.toMap(
                                        Map.Entry::getKey,
                                        entry -> mapper.apply(entry.getValue())
                                ))
                ));
    }
}
