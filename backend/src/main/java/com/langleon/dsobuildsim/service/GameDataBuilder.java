package com.langleon.dsobuildsim.service;

import com.langleon.dsobuildsim.character.CharacterClass;
import com.langleon.dsobuildsim.gamedata.GameDataConfig;
import com.langleon.dsobuildsim.gamedata.GameDataLoader;
import com.langleon.dsobuildsim.items.mythicitems.MythicItemDefinition;
import com.langleon.dsobuildsim.items.mythicitems.MythicItemType;
import com.langleon.dsobuildsim.items.setitems.SetItemDefinition;
import com.langleon.dsobuildsim.items.setitems.SetItemType;
import com.langleon.dsobuildsim.items.uniqueitems.UniqueItemDefinition;
import com.langleon.dsobuildsim.items.uniqueitems.UniqueItemType;
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
        GameDataLoader gameDataLoader = new GameDataLoader();
        return gameDataLoader.loadGameDataConfig();
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
