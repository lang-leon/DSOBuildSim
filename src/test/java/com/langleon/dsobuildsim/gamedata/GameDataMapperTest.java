package com.langleon.dsobuildsim.gamedata;

import com.langleon.dsobuildsim.buffs.BuffMapper;
import com.langleon.dsobuildsim.buffs.dto.BuffDefinitionDTO;
import com.langleon.dsobuildsim.dragonstones.dto.DragonStoneDefinitionDTO;
import com.langleon.dsobuildsim.dragonstones.DragonStoneMapper;
import com.langleon.dsobuildsim.enchantments.EnchantmentMapper;
import com.langleon.dsobuildsim.enchantments.dto.EnchantmentDTO;
import com.langleon.dsobuildsim.essences.EssenceMapper;
import com.langleon.dsobuildsim.essences.dto.EssenceDefinitionDTO;
import com.langleon.dsobuildsim.gamedata.dto.ClassStatsDTO;
import com.langleon.dsobuildsim.gamedata.dto.GameDataDTO;
import com.langleon.dsobuildsim.gems.GemMapper;
import com.langleon.dsobuildsim.gems.dto.GemDefinitionDTO;
import com.langleon.dsobuildsim.items.core.ItemDefinitionMapper;
import com.langleon.dsobuildsim.items.dto.ItemDefinitionDTO;
import com.langleon.dsobuildsim.jewels.JewelMapper;
import com.langleon.dsobuildsim.jewels.dto.JewelDefinitionDTO;
import com.langleon.dsobuildsim.pets.PetMapper;
import com.langleon.dsobuildsim.pets.dto.PetDefinitionDTO;
import com.langleon.dsobuildsim.runes.RuneMapper;
import com.langleon.dsobuildsim.runes.dto.RuneDefinitionDTO;
import com.langleon.dsobuildsim.sets.SetMapper;
import com.langleon.dsobuildsim.sets.dto.SetDTO;
import com.langleon.dsobuildsim.character.CharacterClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameDataMapperTest {

    @Test
    void shouldMapGameDataConfigToGameDataDTO()
    {
        GameDataConfig config = new GameDataLoader().loadGameDataConfig();
        GameDataDTO dto = GameDataMapper.toDTO(config);

        Map<CharacterClass, ClassStatsDTO> classStats2 = config.classStats();
        Map<CharacterClass, List<ItemDefinitionDTO>> items2 = new HashMap<>();

        Stream.of(
                config.mythicItems(),
                config.setItems(),
                config.uniqueItems()
        ).forEach(source ->
                source.forEach((clazz, items) ->
                        items2.merge(
                                clazz,
                                items.values().stream().map(ItemDefinitionMapper::from).toList(),
                                (a, b) -> {
                                    List<ItemDefinitionDTO> merged = new ArrayList<>(a);
                                    merged.addAll(b);
                                    return merged;
                                }
                        )
                )
        );

        Map<CharacterClass, List<SetDTO>> sets2 = config.sets().entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue().values().stream()
                                .map(SetMapper::from)
                                .toList()
                ));
        Map<CharacterClass, List<JewelDefinitionDTO>> jewels2 = config.jewels().entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue().values().stream()
                                .map(JewelMapper::from)
                                .toList()
                ));
        List<EnchantmentDTO> enchantments = config.enchantments().values().stream().map(EnchantmentMapper::from).toList();
        List<GemDefinitionDTO> gems = config.gems().values().stream().map(GemMapper::from).toList();
        List<RuneDefinitionDTO> runes = config.runes().values().stream().map(RuneMapper::from).toList();
        List<DragonStoneDefinitionDTO> dragonStones = config.dragonStones().values().stream().map(DragonStoneMapper::from).toList();
        List<PetDefinitionDTO> pets = config.pets().values().stream().map(PetMapper::from).toList();
        List<EssenceDefinitionDTO> essences = config.essences().values().stream().map(EssenceMapper::from).toList();
        List<BuffDefinitionDTO> tonics = config.buffConfig().tonics().values().stream().map(BuffMapper::from).toList();
        List<BuffDefinitionDTO> physics = config.buffConfig().physics().values().stream().map(BuffMapper::from).toList();

        Assertions.assertEquals(classStats2, dto.characterClassClassStats());
        Assertions.assertEquals(items2, dto.items());
        Assertions.assertEquals(sets2, dto.sets());
        Assertions.assertEquals(jewels2, dto.jewels());
        Assertions.assertEquals(enchantments, dto.enchantments());
        Assertions.assertEquals(gems, dto.gems());
        Assertions.assertEquals(runes, dto.runes());
        Assertions.assertEquals(dragonStones, dto.dragonStones());
        Assertions.assertEquals(pets, dto.pets());
        Assertions.assertEquals(essences, dto.essences());
        Assertions.assertEquals(tonics, dto.tonics());
        Assertions.assertEquals(physics, dto.physics());
        Assertions.assertEquals(LevelMultiplierTableMapper.from(config.levelMultiplierTable()), dto.levelMultiplierTable());
    }
}
