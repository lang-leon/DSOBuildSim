package com.langleon.dsobuildsim.mapper;

import com.langleon.dsobuildsim.character.CharacterClass;
import com.langleon.dsobuildsim.gamedata.GameDataConfig;
import com.langleon.dsobuildsim.dto.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GameDataMapper {

    public static GameDataDTO toDTO(GameDataConfig config)
    {
        Map<CharacterClass, List<ItemDefinitionDTO>> items = config.items().entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue().stream()
                                .map(ItemDefinitionMapper::from)
                                .toList()
                ));

        Map<CharacterClass, List<SetDTO>> sets = config.sets().entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue().stream()
                                .map(SetMapper::from)
                                .toList()
                ));

        Map<CharacterClass, List<JewelDTO>> jewels = config.jewels().entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue().stream()
                                .map(JewelMapper::from)
                                .toList()
                ));

        List<EnchantmentDTO> enchantments = config.enchantments().stream().map(EnchantmentMapper::from).toList();

        List<GemDTO> gems = config.gems().stream().map(GemMapper::from).toList();

        List<RuneDTO> runes = config.runes().stream().map(RuneMapper::from).toList();

        List<DragonStoneDTO> dragonStones = config.dragonStones().stream().map(DragonStoneMapper::from).toList();

        List<PetDTO> pets = config.pets().stream().map(PetMapper::from).toList();

        List<EssenceDTO> essences = config.essences().stream().map(EssenceMapper::from).toList();

        List<BuffDTO> tonics = config.tonics().stream().map(BuffMapper::from).toList();

        List<BuffDTO> physics = config.physics().stream().map(BuffMapper::from).toList();

        LevelMultiplierTableDTO levelMultiplierTable = LevelMultiplierTableMapper.from(config.levelMultiplierTable());

        return new GameDataDTO(config.classStats(), items, sets, jewels, enchantments, gems, runes, dragonStones, pets, essences, tonics, physics, levelMultiplierTable);
    }
}
