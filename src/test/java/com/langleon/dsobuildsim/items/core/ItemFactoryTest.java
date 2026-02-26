package com.langleon.dsobuildsim.items.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.langleon.dsobuildsim.enchantments.Enchantment;
import com.langleon.dsobuildsim.enums.*;
import com.langleon.dsobuildsim.enums.items.UniqueItemType;
import com.langleon.dsobuildsim.items.uniqueitems.UniqueItem;
import com.langleon.dsobuildsim.items.uniqueitems.UniqueItemConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

public class ItemFactoryTest {

    private ItemFactory itemFactory;

    @BeforeEach
    void setup() throws IOException {
        try (var reader = new InputStreamReader(getClass().getResourceAsStream("/data/uniqueitems.json")))
        {
            ObjectMapper objectMapper = new ObjectMapper();
            UniqueItemConfig uniqueItemConfig = objectMapper.readValue(reader, UniqueItemConfig.class);
            itemFactory = new ItemFactory(null, uniqueItemConfig, null);
        }
    }

    @Test
    void createAnniversaryTwoHandUpgraded()
    {
        UniqueItem item = itemFactory.createItem(UniqueItemType.ANNIVERSARY_TWO_HAND_UPGRADED, CharacterClass.SPELLWEAVER);
        Assertions.assertEquals(item.getItemType(), UniqueItemType.ANNIVERSARY_TWO_HAND_UPGRADED);
        Assertions.assertEquals(item.getLevel(), 145);
        Assertions.assertEquals(item.getName(), "Grimace of the Immortal Beast");
        Assertions.assertEquals(item.getItemSlotType(), ItemSlotType.TWO_HAND_WEAPON);
        Assertions.assertEquals(item.getTier(), 7);
        Assertions.assertEquals(item.getBaseValues(), Map.of(StatType.DAMAGE, 26326.278, StatType.CRIT_VALUE, 3505.894));
        for (int i = 0; i<item.getEnchants().length; i++)
        {
            Assertions.assertEquals(item.getEnchants()[i], null);
        }
        for (int i = 0; i<item.getGems().length; i++)
        {
            Assertions.assertEquals(item.getGems()[i], null);
        }
        Assertions.assertEquals(item.getUniqueBaseValues(), Map.of(StatType.ATTACK_SPEED, 0.102));
        Assertions.assertEquals(item.getUniqueRelativeValues(), Map.of(StatType.DAMAGE, 0.10));
        Assertions.assertEquals(item.getUniqueEnchants(), List.of());
        Assertions.assertEquals(item.getUniqueDescription(),"Defeating an enemy has a chance to trigger a cross-shaped aura that deals up to 250% of your base damage to all enemies inside the cross depending, on how far away they are from the center of it. The damage type of the aura will change based on your chosen elemental mastery talents. Every level of your elemental mastery will increase the dealt damage by 60%.\n" +
                "When your Health Points drop below 33%, you will enter the Wind of Recovery state, which restores 1% of your maximum Health Points every second. It will last for 5 seconds and can be stacked up to 3 times.");
    }

    @Test
    void createBrigavikGloves()
    {
        UniqueItem item = itemFactory.createItem(UniqueItemType.BRIGAVIK_GLOVES, CharacterClass.SPELLWEAVER);
        Assertions.assertEquals(item.getItemType(), UniqueItemType.BRIGAVIK_GLOVES);
        Assertions.assertEquals(item.getLevel(), 140);
        Assertions.assertEquals(item.getName(), "Researcher's Gauntlets");
        Assertions.assertEquals(item.getItemSlotType(), ItemSlotType.GLOVES);
        Assertions.assertEquals(item.getTier(), 6);
        Assertions.assertEquals(item.getBaseValues(), Map.of(StatType.MOVEMENT_SPEED, 0.484, StatType.ARMOR_VALUE, 1068.0, StatType.RESISTANCE_VALUE, 1131.0));
        for (int i = 0; i<item.getEnchants().length; i++)
        {
            Assertions.assertEquals(item.getEnchants()[i], null);
        }
        for (int i = 0; i<item.getGems().length; i++)
        {
            Assertions.assertEquals(item.getGems()[i], null);
        }
        Assertions.assertEquals(item.getUniqueBaseValues(), Map.of());
        Assertions.assertEquals(item.getUniqueRelativeValues(), Map.of(StatType.ARMOR_VALUE, 0.10));
        Assertions.assertEquals(item.getUniqueEnchants(), List.of(new Enchantment(EnchantmentType.RESISTANCE, 0.27198)));
        Assertions.assertEquals(item.getUniqueDescription(),"");
    }

    @Test
    void createRocketmanAdornment()
    {
        UniqueItem item = itemFactory.createItem(UniqueItemType.ROCKETMAN_ADORNMENT, CharacterClass.SPELLWEAVER);
        Assertions.assertEquals(item.getItemType(), UniqueItemType.ROCKETMAN_ADORNMENT);
        Assertions.assertEquals(item.getLevel(), 145);
        Assertions.assertEquals(item.getName(), "Stinger");
        Assertions.assertEquals(item.getItemSlotType(), ItemSlotType.WEAPON_ADORNMENT);
        Assertions.assertEquals(item.getTier(), 6);
        Assertions.assertEquals(item.getBaseValues(), Map.of(StatType.DAMAGE, 1891.513, StatType.ATTACK_SPEED, 0.055, StatType.CRIT_VALUE, 2104.0));
        for (int i = 0; i<item.getEnchants().length; i++)
        {
            Assertions.assertEquals(item.getEnchants()[i], null);
        }
        for (int i = 0; i<item.getGems().length; i++)
        {
            Assertions.assertEquals(item.getGems()[i], null);
        }
        Assertions.assertEquals(item.getUniqueBaseValues(), Map.of());
        Assertions.assertEquals(item.getUniqueRelativeValues(), Map.of());
        Assertions.assertEquals(item.getUniqueEnchants(), List.of(new Enchantment(EnchantmentType.DAMAGE, 0.67637), new Enchantment(EnchantmentType.CRIT_VALUE, 0.60126)));
        Assertions.assertEquals(item.getUniqueDescription(),"");
    }
}
