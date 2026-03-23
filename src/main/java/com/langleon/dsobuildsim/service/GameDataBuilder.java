package com.langleon.dsobuildsim.service;

import com.langleon.dsobuildsim.buffs.BuffConfig;
import com.langleon.dsobuildsim.character.CharacterClass;
import com.langleon.dsobuildsim.dto.ClassStatsDTO;
import com.langleon.dsobuildsim.gamedata.ClassStatsConfig;
import com.langleon.dsobuildsim.gamedata.GameDataConfig;
import com.langleon.dsobuildsim.gamedata.GameDataLoader;
import com.langleon.dsobuildsim.items.mythicitems.MythicItemConfig;
import com.langleon.dsobuildsim.items.mythicitems.MythicItemDefinition;
import com.langleon.dsobuildsim.items.mythicitems.MythicItemType;
import com.langleon.dsobuildsim.items.setitems.SetItemConfig;
import com.langleon.dsobuildsim.items.setitems.SetItemDefinition;
import com.langleon.dsobuildsim.items.setitems.SetItemType;
import com.langleon.dsobuildsim.items.uniqueitems.UniqueItemConfig;
import com.langleon.dsobuildsim.items.uniqueitems.UniqueItemDefinition;
import com.langleon.dsobuildsim.items.uniqueitems.UniqueItemType;
import com.langleon.dsobuildsim.jewels.JewelConfig;
import com.langleon.dsobuildsim.jewels.JewelDefinition;
import com.langleon.dsobuildsim.sets.SetConfig;
import com.langleon.dsobuildsim.sets.SetDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Configuration
public class GameDataBuilder {

    @Bean
    public GameDataConfig gameDataConfig(GameDataLoader loader)
    {
        ClassStatsConfig classStatsConfig = loader.loadClassStatsConfig();
        Map<CharacterClass, ClassStatsDTO> classStats = Map.of(
                CharacterClass.SPELLWEAVER, classStatsConfig.classStats().get(CharacterClass.SPELLWEAVER),
                CharacterClass.DRAGONKNIGHT, classStatsConfig.classStats().get(CharacterClass.DRAGONKNIGHT),
                CharacterClass.RANGER, classStatsConfig.classStats().get(CharacterClass.RANGER),
                CharacterClass.STEAM_MECHANICUS, classStatsConfig.classStats().get(CharacterClass.STEAM_MECHANICUS)
        );

        MythicItemConfig mythicItemConfig = loader.loadMythicItemConfig();
        Map<CharacterClass, List<MythicItemDefinition>> mythicItems = toClassMap(mythicItemConfig.spellweaverItems(), mythicItemConfig.dragonknightItems(), mythicItemConfig.rangerItems(), mythicItemConfig.steamMechanicusItems());
        SetItemConfig setItemConfig = loader.loadSetItemConfig();
        Map<CharacterClass, List<SetItemDefinition>> setItems = toClassMap(setItemConfig.spellweaverItems(), setItemConfig.dragonknightItems(), setItemConfig.rangerItems(), setItemConfig.steamMechanicusItems());
        UniqueItemConfig uniqueItemConfig = loader.loadUniqueItemConfig();
        Map<CharacterClass, List<UniqueItemDefinition>> uniqueItems = toClassMap(uniqueItemConfig.spellweaverItems(), uniqueItemConfig.dragonknightItems(), uniqueItemConfig.rangerItems(), uniqueItemConfig.steamMechanicusItems());

        SetConfig setConfig = loader.loadSetConfig();
        Map<CharacterClass, List<SetDefinition>> sets = toClassMap(setConfig.spellweaverSets(), setConfig.dragonknightSets(), setConfig.rangerSets(), setConfig.steamMechanicusSets());

        JewelConfig jewelConfig = loader.loadJewelConfig();
        Map<CharacterClass, List<JewelDefinition>> jewels = toClassMap(jewelConfig.spellweaverJewels(), jewelConfig.dragonknightJewels(), jewelConfig.rangerJewels(), jewelConfig.steamMechanicusJewels());

        BuffConfig buffConfig = loader.loadBuffConfig();

        return new GameDataConfig(
                classStats,
                mythicItems,
                setItems,
                uniqueItems,
                sets,
                jewels,
                loader.loadEnchantmentConfig().enchantments().values().stream().toList(),
                loader.loadGemConfig().gems().values().stream().toList(),
                loader.loadRuneConfig().runes().values().stream().toList(),
                loader.loadDragonStoneConfig().dragonStones().values().stream().toList(),
                loader.loadPetConfig().pets().values().stream().toList(),
                loader.loadEssenceConfig().essences().values().stream().toList(),
                buffConfig.tonics().values().stream().toList(),
                buffConfig.physics().values().stream().toList(),
                loader.loadLevelMultiplierTable(),
                loader.loadWisdomSkillTreeConfig()
        );
    }


    private static List<Record> mergeMaps(
            Map<MythicItemType, MythicItemDefinition> mythics,
            Map<SetItemType, SetItemDefinition> setItems,
            Map<UniqueItemType, UniqueItemDefinition> uniques) {

        return Stream.of(
                        mythics.values(),
                        setItems.values(),
                        uniques.values()
                )
                .flatMap(Collection::stream)
                .map(r -> (Record) r)
                .toList();
    }

    private static <K, V> Map<CharacterClass, List<V>> toClassMap(
            Map<K, V> spellweaver,
            Map<K, V> dragonknight,
            Map<K, V> ranger,
            Map<K, V> steamMechanicus
    ) {
        return Map.of(
                CharacterClass.SPELLWEAVER, spellweaver.values().stream().toList(),
                CharacterClass.DRAGONKNIGHT, dragonknight.values().stream().toList(),
                CharacterClass.RANGER, ranger.values().stream().toList(),
                CharacterClass.STEAM_MECHANICUS, steamMechanicus.values().stream().toList()
        );
    }
}
