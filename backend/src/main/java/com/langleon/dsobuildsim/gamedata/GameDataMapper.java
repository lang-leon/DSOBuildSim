package com.langleon.dsobuildsim.gamedata;

import com.langleon.dsobuildsim.buffs.BuffMapper;
import com.langleon.dsobuildsim.buffs.dto.BuffDefinitionDTO;
import com.langleon.dsobuildsim.character.CharacterClass;
import com.langleon.dsobuildsim.collectorbagbonus.CollectorBagMapper;
import com.langleon.dsobuildsim.collectorbagbonus.dto.definition.CollectorBagBonusDefinitionDTO;
import com.langleon.dsobuildsim.collectorbagbonus.dto.definition.CollectorBagCategoryBonusDefinitionDTO;
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
import com.langleon.dsobuildsim.items.dto.ItemDefinitionDTO;
import com.langleon.dsobuildsim.jewels.JewelMapper;
import com.langleon.dsobuildsim.jewels.dto.JewelDefinitionDTO;
import com.langleon.dsobuildsim.items.core.ItemDefinitionMapper;
import com.langleon.dsobuildsim.wisdomskilltree.WisdomSkillTreeMapper;
import com.langleon.dsobuildsim.pets.PetMapper;
import com.langleon.dsobuildsim.pets.dto.PetDefinitionDTO;
import com.langleon.dsobuildsim.runes.RuneMapper;
import com.langleon.dsobuildsim.runes.dto.RuneDefinitionDTO;
import com.langleon.dsobuildsim.sets.SetMapper;
import com.langleon.dsobuildsim.sets.dto.SetDTO;
import com.langleon.dsobuildsim.wisdomskilltree.dto.definition.WisdomSkillTreeDefinitionDTO;

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
        Map<CharacterClass, List<ItemDefinitionDTO>> items =
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
                                        .toList()
                        ));

        Map<CharacterClass, List<SetDTO>> sets =
                mapPerClass(config.sets(), SetMapper::from);

        Map<CharacterClass, List<JewelDefinitionDTO>> jewels =
                mapPerClass(config.jewels(), JewelMapper::from);

        List<EnchantmentDTO> enchantments = config.enchantments().values().stream().map(EnchantmentMapper::from).toList();

        List<GemDefinitionDTO> gems = config.gems().values().stream().map(GemMapper::from).toList();

        List<RuneDefinitionDTO> runes = config.runes().values().stream().map(RuneMapper::from).toList();

        List<DragonStoneDefinitionDTO> dragonStones = config.dragonStones().values().stream().map(DragonStoneMapper::from).toList();

        List<PetDefinitionDTO> pets = config.pets().values().stream().map(PetMapper::from).toList();

        List<EssenceDefinitionDTO> essences = config.essences().values().stream().map(EssenceMapper::from).toList();

        List<BuffDefinitionDTO> tonics = config.buffConfig().tonics().values().stream().map(BuffMapper::from).toList();

        List<BuffDefinitionDTO> physics = config.buffConfig().physics().values().stream().map(BuffMapper::from).toList();

        LevelMultiplierTableDTO levelMultiplierTable = LevelMultiplierTableMapper.from(config.levelMultiplierTable());

        WisdomSkillTreeDefinitionDTO wisdomSkillTree = WisdomSkillTreeMapper.from(config.wisdomSkillConfig());

        List<CollectorBagCategoryBonusDefinitionDTO> collectorBagBuffs = config.collectorBagConfig().categoryBonuses().values().stream().map(categoryBonus -> CollectorBagMapper.from(categoryBonus, config.collectorBagConfig())).toList();

        return new GameDataDTO(config.classStats(), items, sets, jewels, enchantments, gems, runes, dragonStones, pets, essences, tonics, physics, levelMultiplierTable, wisdomSkillTree, collectorBagBuffs);
    }

    private static <K, S, T> Map<CharacterClass, List<T>> mapPerClass(Map<CharacterClass, Map<K, S>> source, Function<S, T> mapper)
    {
        return source.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue().values().stream()
                                .map(mapper)
                                .toList()
                ));
    }
}
