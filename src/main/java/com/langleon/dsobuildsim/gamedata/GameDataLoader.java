package com.langleon.dsobuildsim.gamedata;

import com.langleon.dsobuildsim.buffs.BuffConfig;
import com.langleon.dsobuildsim.dragonstones.DragonStoneConfig;
import com.langleon.dsobuildsim.enchantments.EnchantmentConfig;
import com.langleon.dsobuildsim.essences.EssenceConfig;
import com.langleon.dsobuildsim.gems.GemConfig;
import com.langleon.dsobuildsim.items.core.LevelMultiplierTable;
import com.langleon.dsobuildsim.items.mythicitems.MythicItemConfig;
import com.langleon.dsobuildsim.items.setitems.SetItemConfig;
import com.langleon.dsobuildsim.items.uniqueitems.UniqueItemConfig;
import com.langleon.dsobuildsim.jewels.JewelConfig;
import com.langleon.dsobuildsim.pets.PetConfig;
import com.langleon.dsobuildsim.runes.RuneConfig;
import com.langleon.dsobuildsim.sets.SetConfig;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

@Component
public class GameDataLoader {

    private final ObjectMapper mapper = new ObjectMapper();

    public ClassStatsConfig loadClassStatsConfig()
    {
        return load("/gamedata/classStats.json", ClassStatsConfig.class);
    }

    public MythicItemConfig loadMythicItemConfig()
    {
        return load("/gamedata/mythicitems.json", MythicItemConfig.class);
    }

    public SetItemConfig loadSetItemConfig()
    {
        return load("/gamedata/setitems.json", SetItemConfig.class);
    }

    public UniqueItemConfig loadUniqueItemConfig()
    {
        return load("/gamedata/uniqueitems.json", UniqueItemConfig.class);
    }

    public SetConfig loadSetConfig()
    {
        return load("/gamedata/sets.json", SetConfig.class);
    }

    public JewelConfig loadJewelConfig()
    {
        return load("/gamedata/jewels.json", JewelConfig.class);
    }

    public EnchantmentConfig loadEnchantmentConfig()
    {
        return load("/gamedata/enchantments.json", EnchantmentConfig.class);
    }

    public GemConfig loadGemConfig()
    {
        return load("/gamedata/gems.json", GemConfig.class);
    }

    public RuneConfig loadRuneConfig()
    {
        return load("/gamedata/runes.json", RuneConfig.class);
    }

    public DragonStoneConfig loadDragonStoneConfig()
    {
        return load("/gamedata/dragonstones.json", DragonStoneConfig.class);
    }

    public PetConfig loadPetConfig()
    {
        return load("/gamedata/pets.json", PetConfig.class);
    }

    public EssenceConfig loadEssenceConfig()
    {
        return load("/gamedata/essences.json", EssenceConfig.class);
    }

    public BuffConfig loadBuffConfig()
    {
        return load("/gamedata/buffs.json", BuffConfig.class);
    }

    public LevelMultiplierTable loadLevelMultiplierTable()
    {
        return load("/gamedata/levelMultiplierTable.json", LevelMultiplierTable.class);
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
}
