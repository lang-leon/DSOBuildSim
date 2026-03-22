package com.langleon.dsobuildsim.mapper;

import com.langleon.dsobuildsim.items.mythicitems.MythicItemDefinition;
import com.langleon.dsobuildsim.items.mythicitems.MythicItemType;
import com.langleon.dsobuildsim.items.setitems.SetItemDefinition;
import com.langleon.dsobuildsim.items.setitems.SetItemType;
import com.langleon.dsobuildsim.items.uniqueitems.UniqueItemDefinition;
import com.langleon.dsobuildsim.items.uniqueitems.UniqueItemType;
import tools.jackson.databind.ObjectMapper;
import com.langleon.dsobuildsim.buffs.BuffConfig;
import com.langleon.dsobuildsim.character.CharacterClass;
import com.langleon.dsobuildsim.gamedata.ClassStatsConfig;
import com.langleon.dsobuildsim.gamedata.GameDataConfig;
import com.langleon.dsobuildsim.dragonstones.DragonStoneConfig;
import com.langleon.dsobuildsim.dto.*;
import com.langleon.dsobuildsim.enchantments.EnchantmentConfig;
import com.langleon.dsobuildsim.essences.EssenceConfig;
import com.langleon.dsobuildsim.gems.GemConfig;
import com.langleon.dsobuildsim.items.core.ItemDefinition;
import com.langleon.dsobuildsim.items.core.LevelMultiplierTable;
import com.langleon.dsobuildsim.items.mythicitems.MythicItemConfig;
import com.langleon.dsobuildsim.items.setitems.SetItemConfig;
import com.langleon.dsobuildsim.items.uniqueitems.UniqueItemConfig;
import com.langleon.dsobuildsim.jewels.JewelConfig;
import com.langleon.dsobuildsim.jewels.JewelDefinition;
import com.langleon.dsobuildsim.pets.PetConfig;
import com.langleon.dsobuildsim.runes.RuneConfig;
import com.langleon.dsobuildsim.sets.SetConfig;
import com.langleon.dsobuildsim.sets.SetDefinition;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameDataMapperTest {

    private MythicItemConfig mythicItemConfig;
    private UniqueItemConfig uniqueItemConfig;
    private SetItemConfig setItemConfig;
    private EssenceConfig essenceConfig;
    private DragonStoneConfig dragonStoneConfig;
    private GemConfig gemConfig;
    private JewelConfig jewelConfig;
    private PetConfig petConfig;
    private RuneConfig runeConfig;
    private SetConfig setConfig;
    private EnchantmentConfig enchantmentConfig;
    private BuffConfig buffConfig;
    private ClassStatsConfig classStatsConfig;
    LevelMultiplierTable levelMultiplierTable;

    @BeforeEach
    void setup() throws IOException
    {
        try (var reader = new InputStreamReader(Objects.requireNonNull(getClass().getResourceAsStream("/gamedata/essences.json"))))
        {
            ObjectMapper objectMapper = new ObjectMapper();
            essenceConfig = objectMapper.readValue(reader, EssenceConfig.class);
        }
        try (var reader = new InputStreamReader(Objects.requireNonNull(getClass().getResourceAsStream("/gamedata/dragonstones.json"))))
        {
            ObjectMapper objectMapper = new ObjectMapper();
            dragonStoneConfig = objectMapper.readValue(reader, DragonStoneConfig.class);
        }
        try (var reader = new InputStreamReader(Objects.requireNonNull(getClass().getResourceAsStream("/gamedata/gems.json"))))
        {
            ObjectMapper objectMapper = new ObjectMapper();
            gemConfig = objectMapper.readValue(reader, GemConfig.class);
        }
        try (var reader = new InputStreamReader(Objects.requireNonNull(getClass().getResourceAsStream("/gamedata/jewels.json"))))
        {
            ObjectMapper objectMapper = new ObjectMapper();
            jewelConfig = objectMapper.readValue(reader, JewelConfig.class);
        }
        try (var reader = new InputStreamReader(Objects.requireNonNull(getClass().getResourceAsStream("/gamedata/pets.json"))))
        {
            ObjectMapper objectMapper = new ObjectMapper();
            petConfig = objectMapper.readValue(reader, PetConfig.class);
        }
        try (var reader = new InputStreamReader(Objects.requireNonNull(getClass().getResourceAsStream("/gamedata/runes.json"))))
        {
            ObjectMapper objectMapper = new ObjectMapper();
            runeConfig = objectMapper.readValue(reader, RuneConfig.class);
        }
        try (var reader = new InputStreamReader(Objects.requireNonNull(getClass().getResourceAsStream("/gamedata/sets.json")))) {
            ObjectMapper objectMapper = new ObjectMapper();
            setConfig = objectMapper.readValue(reader, SetConfig.class);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        try (var reader = new InputStreamReader(Objects.requireNonNull(getClass().getResourceAsStream("/gamedata/mythicitems.json"))))
        {
            mythicItemConfig = objectMapper.readValue(reader, MythicItemConfig.class);
        }
        try (var reader = new InputStreamReader(Objects.requireNonNull(getClass().getResourceAsStream("/gamedata/uniqueitems.json"))))
        {
            uniqueItemConfig = objectMapper.readValue(reader, UniqueItemConfig.class);
        }
        try (var reader = new InputStreamReader(Objects.requireNonNull(getClass().getResourceAsStream("/gamedata/setitems.json"))))
        {
            setItemConfig = objectMapper.readValue(reader, SetItemConfig.class);
        }
        try (var reader = new InputStreamReader(Objects.requireNonNull(getClass().getResourceAsStream("/gamedata/levelMultiplierTable.json"))))
        {
            levelMultiplierTable = objectMapper.readValue(reader, LevelMultiplierTable.class);
        }
        try (var reader = new InputStreamReader(Objects.requireNonNull(getClass().getResourceAsStream("/gamedata/enchantments.json"))))
        {
            enchantmentConfig = objectMapper.readValue(reader, EnchantmentConfig.class);
        }
        try (var reader = new InputStreamReader(Objects.requireNonNull(getClass().getResourceAsStream("/gamedata/buffs.json"))))
        {
            buffConfig = objectMapper.readValue(reader, BuffConfig.class);
        }
        try (var reader = new InputStreamReader(Objects.requireNonNull(getClass().getResourceAsStream("/gamedata/classStats.json"))))
        {
            classStatsConfig = objectMapper.readValue(reader, ClassStatsConfig.class);
        }
    }

    @Test
    void shouldMapGameDataConfigToGameDataDTO()
    {
        Map<CharacterClass, ClassStatsDTO> classStats = new EnumMap<>(CharacterClass.class);
        classStats.put(CharacterClass.DRAGONKNIGHT, classStatsConfig.classStats().get(CharacterClass.DRAGONKNIGHT));
        classStats.put(CharacterClass.RANGER, classStatsConfig.classStats().get(CharacterClass.RANGER));
        classStats.put(CharacterClass.SPELLWEAVER, classStatsConfig.classStats().get(CharacterClass.SPELLWEAVER));
        classStats.put(CharacterClass.STEAM_MECHANICUS, classStatsConfig.classStats().get(CharacterClass.STEAM_MECHANICUS));

        Map<CharacterClass, List<MythicItemDefinition>> mythicItems = new EnumMap<>(CharacterClass.class);
        Map<CharacterClass, List<SetItemDefinition>> setItems = new EnumMap<>(CharacterClass.class);
        Map<CharacterClass, List<UniqueItemDefinition>> uniqueItems = new EnumMap<>(CharacterClass.class);
        mythicItems.put(CharacterClass.DRAGONKNIGHT, mythicItemConfig.dragonknightItems().values().stream().toList());
        setItems.put(CharacterClass.DRAGONKNIGHT, setItemConfig.dragonknightItems().values().stream().toList());
        uniqueItems.put(CharacterClass.DRAGONKNIGHT, uniqueItemConfig.dragonknightItems().values().stream().toList());
        mythicItems.put(CharacterClass.RANGER, mythicItemConfig.rangerItems().values().stream().toList());
        setItems.put(CharacterClass.RANGER, setItemConfig.rangerItems().values().stream().toList());
        uniqueItems.put(CharacterClass.RANGER, uniqueItemConfig.rangerItems().values().stream().toList());
        mythicItems.put(CharacterClass.SPELLWEAVER, mythicItemConfig.spellweaverItems().values().stream().toList());
        setItems.put(CharacterClass.SPELLWEAVER, setItemConfig.spellweaverItems().values().stream().toList());
        uniqueItems.put(CharacterClass.SPELLWEAVER, uniqueItemConfig.spellweaverItems().values().stream().toList());
        mythicItems.put(CharacterClass.STEAM_MECHANICUS, mythicItemConfig.steamMechanicusItems().values().stream().toList());
        setItems.put(CharacterClass.STEAM_MECHANICUS, setItemConfig.steamMechanicusItems().values().stream().toList());
        uniqueItems.put(CharacterClass.STEAM_MECHANICUS, uniqueItemConfig.steamMechanicusItems().values().stream().toList());

        Map<CharacterClass, List<SetDefinition>> sets = new EnumMap<>(CharacterClass.class);
        sets.put(CharacterClass.DRAGONKNIGHT, setConfig.dragonknightSets().values().stream().toList());
        sets.put(CharacterClass.RANGER, setConfig.rangerSets().values().stream().toList());
        sets.put(CharacterClass.SPELLWEAVER, setConfig.spellweaverSets().values().stream().toList());
        sets.put(CharacterClass.STEAM_MECHANICUS, setConfig.steamMechanicusSets().values().stream().toList());

        Map<CharacterClass, List<JewelDefinition>> jewels = new EnumMap<>(CharacterClass.class);
        jewels.put(CharacterClass.DRAGONKNIGHT, jewelConfig.dragonknightJewels().values().stream().toList());
        jewels.put(CharacterClass.RANGER, jewelConfig.rangerJewels().values().stream().toList());
        jewels.put(CharacterClass.SPELLWEAVER, jewelConfig.spellweaverJewels().values().stream().toList());
        jewels.put(CharacterClass.STEAM_MECHANICUS, jewelConfig.steamMechanicusJewels().values().stream().toList());

        GameDataConfig config = new GameDataConfig(
                classStats,
                mythicItems,
                setItems,
                uniqueItems,
                sets,
                jewels,
                enchantmentConfig.enchantments().values().stream().toList(),
                gemConfig.gems().values().stream().toList(),
                runeConfig.runes().values().stream().toList(),
                dragonStoneConfig.dragonStones().values().stream().toList(),
                petConfig.pets().values().stream().toList(),
                essenceConfig.essences().values().stream().toList(),
                buffConfig.tonics().values().stream().toList(),
                buffConfig.physics().values().stream().toList(),
                levelMultiplierTable
        );
        GameDataDTO dto = GameDataMapper.toDTO(config);

        Map<CharacterClass, ClassStatsDTO> classStats2 = new EnumMap<>(CharacterClass.class);
        classStats2.put(CharacterClass.DRAGONKNIGHT, classStatsConfig.classStats().get(CharacterClass.DRAGONKNIGHT));
        classStats2.put(CharacterClass.RANGER, classStatsConfig.classStats().get(CharacterClass.RANGER));
        classStats2.put(CharacterClass.SPELLWEAVER, classStatsConfig.classStats().get(CharacterClass.SPELLWEAVER));
        classStats2.put(CharacterClass.STEAM_MECHANICUS, classStatsConfig.classStats().get(CharacterClass.STEAM_MECHANICUS));
        Map<CharacterClass, List<ItemDefinitionDTO>> items2 = new HashMap<>();

        Stream.of(
                config.mythicItems(),
                config.setItems(),
                config.uniqueItems()
        ).forEach(source ->
                source.forEach((clazz, items) ->
                        items2.merge(
                                clazz,
                                items.stream().map(ItemDefinitionMapper::from).toList(),
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
                        e -> e.getValue().stream()
                                .map(SetMapper::from)
                                .toList()
                ));
        Map<CharacterClass, List<JewelDTO>> jewels2 = config.jewels().entrySet().stream()
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
        Assertions.assertEquals(LevelMultiplierTableMapper.from(levelMultiplierTable), dto.levelMultiplierTable());
    }
}
