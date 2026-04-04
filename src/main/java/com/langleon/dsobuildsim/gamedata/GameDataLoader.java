package com.langleon.dsobuildsim.gamedata;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.langleon.dsobuildsim.buffs.BuffConfig;
import com.langleon.dsobuildsim.wisdomskilltree.WisdomSkillTreeConfig;
import com.langleon.dsobuildsim.wisdomskilltree.wisdomgroup.WisdomGroupConfig;
import com.langleon.dsobuildsim.wisdomskilltree.wisdomskill.WisdomSkillConfig;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Component
public class GameDataLoader {

    private final ObjectMapper mapper = new ObjectMapper();

    public GameDataConfig loadGameDataConfig()
    {
        return new GameDataConfig(
                load("/gamedata/classStats.json", new TypeReference<>() {}),
                load("/gamedata/mythicitems.json", new TypeReference<>() {}),
                load("/gamedata/setitems.json", new TypeReference<>() {}),
                load("/gamedata/uniqueitems.json", new TypeReference<>() {}),
                load("/gamedata/sets.json", new TypeReference<>() {}),
                load("/gamedata/jewels.json", new TypeReference<>() {}),
                load("/gamedata/enchantments.json", new TypeReference<>() {}),
                load("/gamedata/gems.json", new TypeReference<>() {}),
                load("/gamedata/runes.json", new TypeReference<>() {}),
                load("/gamedata/dragonstones.json", new TypeReference<>() {}),
                load("/gamedata/pets.json", new TypeReference<>() {}),
                load("/gamedata/essences.json", new TypeReference<>() {}),
                load("/gamedata/buffs.json", BuffConfig.class),
                load("/gamedata/levelMultiplierTable.json", new TypeReference<>() {}),
                loadWisdomSkillTreeConfig(),
                load("/gamedata/collectorBagBonuses.json", new TypeReference<>() {})
        );
    }

    private WisdomSkillConfig loadWisdomSkillConfig()
    {
        return load("/gamedata/wisdomSkills.json", WisdomSkillConfig.class);
    }

    private WisdomGroupConfig loadWisdomGroupConfig()
    {
        return load("/gamedata/wisdomGroups.json", WisdomGroupConfig.class);
    }

    private WisdomSkillTreeConfig loadWisdomSkillTreeConfig()
    {
        return new WisdomSkillTreeConfig(loadWisdomSkillConfig().wisdomSkills(), loadWisdomGroupConfig().wisdomGroups());
    }

    private <T> T load(String path, Class<T> clazz)
    {
        try (InputStream is = getClass().getResourceAsStream(path))
        {
            return mapper.readValue(is, clazz);
        }
        catch (IOException e)
        {
            throw new RuntimeException("Failed to load "+path, e);
        }
    }

    private <T> T load(String path, TypeReference<T> typeRef) {
        try (InputStream is = getClass().getResourceAsStream(path)) {
            return mapper.readValue(is, typeRef);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load " + path, e);
        }
    }
}
