package com.langleon.dsobuildsim.mapper;

import com.langleon.dsobuildsim.character.CharacterClass;
import com.langleon.dsobuildsim.gamedata.GameDataConfig;
import com.langleon.dsobuildsim.dto.*;

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
                                        .flatMap(List::stream)
                                        .map(ItemDefinitionMapper::from)
                                        .toList()
                        ));

        Map<CharacterClass, List<SetDTO>> sets =
                mapPerClass(config.sets(), SetMapper::from);

        Map<CharacterClass, List<JewelDTO>> jewels =
                mapPerClass(config.jewels(), JewelMapper::from);

        List<EnchantmentDTO> enchantments = config.enchantments().stream().map(EnchantmentMapper::from).toList();

        List<GemDTO> gems = config.gems().stream().map(GemMapper::from).toList();

        List<RuneDTO> runes = config.runes().stream().map(RuneMapper::from).toList();

        List<DragonStoneDTO> dragonStones = config.dragonStones().stream().map(DragonStoneMapper::from).toList();

        List<PetDTO> pets = config.pets().stream().map(PetMapper::from).toList();

        List<EssenceDTO> essences = config.essences().stream().map(EssenceMapper::from).toList();

        List<BuffDTO> tonics = config.tonics().stream().map(BuffMapper::from).toList();

        List<BuffDTO> physics = config.physics().stream().map(BuffMapper::from).toList();

        LevelMultiplierTableDTO levelMultiplierTable = LevelMultiplierTableMapper.from(config.levelMultiplierTable());

        WisdomSkillTreeDTO wisdomSkillTree = WisdomSkillTreeMapper.from(config.wisdomSkillConfig());

        return new GameDataDTO(config.classStats(), items, sets, jewels, enchantments, gems, runes, dragonStones, pets, essences, tonics, physics, levelMultiplierTable, wisdomSkillTree);
    }

    private static <S, T> Map<CharacterClass, List<T>> mapPerClass(Map<CharacterClass, List<S>> source, Function<S, T> mapper)
    {
        return source.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue().stream()
                                .map(mapper)
                                .toList()
                ));
    }
}
