package com.langleon.dsobuildsim.items.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.langleon.dsobuildsim.enchantments.Enchantment;
import com.langleon.dsobuildsim.enums.*;
import com.langleon.dsobuildsim.enums.items.MythicItemType;
import com.langleon.dsobuildsim.enums.items.SetItemType;
import com.langleon.dsobuildsim.enums.items.SetType;
import com.langleon.dsobuildsim.enums.items.UniqueItemType;
import com.langleon.dsobuildsim.items.mythicitems.MythicItem;
import com.langleon.dsobuildsim.items.mythicitems.MythicItemConfig;
import com.langleon.dsobuildsim.items.setitems.SetItem;
import com.langleon.dsobuildsim.items.setitems.SetItemConfig;
import com.langleon.dsobuildsim.items.uniqueitems.UniqueItem;
import com.langleon.dsobuildsim.items.uniqueitems.UniqueItemConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ItemFactoryTest {

    private ItemFactory itemFactory;

    @BeforeEach
    void setup() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        MythicItemConfig mythicItemConfig;
        UniqueItemConfig uniqueItemConfig;
        SetItemConfig setItemConfig;
        LevelMultiplierTable levelMultiplierTable;

        try (var reader = new InputStreamReader(Objects.requireNonNull(getClass().getResourceAsStream("/data/mythicitems.json"))))
        {
            mythicItemConfig = objectMapper.readValue(reader, MythicItemConfig.class);
        }
        try (var reader = new InputStreamReader(Objects.requireNonNull(getClass().getResourceAsStream("/data/uniqueitems.json"))))
        {
            uniqueItemConfig = objectMapper.readValue(reader, UniqueItemConfig.class);
        }
        try (var reader = new InputStreamReader(Objects.requireNonNull(getClass().getResourceAsStream("/data/setitems.json"))))
        {
            setItemConfig = objectMapper.readValue(reader, SetItemConfig.class);
        }
        try (var reader = new InputStreamReader(Objects.requireNonNull(getClass().getResourceAsStream("/data/levelMultiplierTable.json"))))
        {
            levelMultiplierTable = objectMapper.readValue(reader, LevelMultiplierTable.class);
        }

        itemFactory = new ItemFactory(mythicItemConfig, uniqueItemConfig, setItemConfig, levelMultiplierTable);
    }

    @Test
    void createAnniversaryTwoHandUpgraded() //Unique Item
    {
        UniqueItem item = itemFactory.createItem(UniqueItemType.ANNIVERSARY_TWO_HAND_UPGRADED, CharacterClass.SPELLWEAVER);
        Assertions.assertEquals(UniqueItemType.ANNIVERSARY_TWO_HAND_UPGRADED, item.getItemType());
        Assertions.assertEquals(145, item.getLevel());
        Assertions.assertEquals("Grimace of the Immortal Beast", item.getName());
        Assertions.assertEquals(ItemSlotType.TWO_HAND_WEAPON, item.getItemSlotType());
        Assertions.assertEquals(7, item.getTier());
        Assertions.assertEquals(26326.276, item.getBaseValues().get(StatType.DAMAGE), 0.001);
        Assertions.assertEquals(3505.894, item.getBaseValues().get(StatType.CRIT_VALUE), 0.001);
        for (int i = 0; i<item.getEnchants().length; i++)
        {
            Assertions.assertNull(item.getEnchants()[i]);
        }
        for (int i = 0; i<item.getGems().length; i++)
        {
            Assertions.assertNull(item.getGems()[i]);
        }
        Assertions.assertEquals(item.getUniqueBaseValues(), Map.of(StatType.ATTACK_SPEED, 0.102));
        Assertions.assertEquals(item.getUniqueRelativeValues(), Map.of(StatType.DAMAGE, 0.10));
        Assertions.assertEquals(item.getUniqueEnchants(), List.of());
        Assertions.assertEquals("Defeating an enemy has a chance to trigger a cross-shaped aura that deals up to 250% of your base damage to all enemies inside the cross depending, on how far away they are from the center of it. The damage type of the aura will change based on your chosen elemental mastery talents. Every level of your elemental mastery will increase the dealt damage by 60%.\n" +
                "When your Health Points drop below 33%, you will enter the Wind of Recovery state, which restores 1% of your maximum Health Points every second. It will last for 5 seconds and can be stacked up to 3 times.", item.getUniqueDescription());
    }

    @Test
    void createBrigavikGloves() //Unique Item
    {
        UniqueItem item = itemFactory.createItem(UniqueItemType.BRIGAVIK_GLOVES, CharacterClass.SPELLWEAVER);
        Assertions.assertEquals(UniqueItemType.BRIGAVIK_GLOVES, item.getItemType());
        Assertions.assertEquals(140, item.getLevel());
        Assertions.assertEquals("Researcher's Gauntlets", item.getName());
        Assertions.assertEquals(ItemSlotType.GLOVES, item.getItemSlotType());
        Assertions.assertEquals(1067.877, item.getBaseValues().get(StatType.ARMOR_VALUE), 0.001);
        Assertions.assertEquals(1131.275, item.getBaseValues().get(StatType.RESISTANCE_VALUE), 0.001);
        Assertions.assertEquals(0.483, item.getBaseValues().get(StatType.MOVEMENT_SPEED), 0.001);
        for (int i = 0; i<item.getEnchants().length; i++)
        {
            Assertions.assertNull(item.getEnchants()[i]);
        }
        for (int i = 0; i<item.getGems().length; i++)
        {
            Assertions.assertNull(item.getGems()[i]);
        }
        Assertions.assertEquals(Map.of(), item.getUniqueBaseValues());
        Assertions.assertEquals(Map.of(StatType.ARMOR_VALUE, 0.10), item.getUniqueRelativeValues());
        Assertions.assertEquals(List.of(new Enchantment(EnchantmentType.RESISTANCE, 0.27198)), item.getUniqueEnchants());
        Assertions.assertEquals("", item.getUniqueDescription());
    }

    @Test
    void createRocketmanAdornment() //Unique Item
    {
        UniqueItem item = itemFactory.createItem(UniqueItemType.ROCKETMAN_ADORNMENT, CharacterClass.SPELLWEAVER);
        Assertions.assertEquals(UniqueItemType.ROCKETMAN_ADORNMENT, item.getItemType());
        Assertions.assertEquals(145, item.getLevel());
        Assertions.assertEquals("Stinger", item.getName());
        Assertions.assertEquals(ItemSlotType.WEAPON_ADORNMENT, item.getItemSlotType());
        Assertions.assertEquals(6, item.getTier());
        Assertions.assertEquals(1891.513, item.getBaseValues().get(StatType.DAMAGE), 0.001);
        Assertions.assertEquals(0.055, item.getBaseValues().get(StatType.ATTACK_SPEED), 0.001);
        Assertions.assertEquals(2103.982, item.getBaseValues().get(StatType.CRIT_VALUE), 0.001);
        for (int i = 0; i<item.getEnchants().length; i++)
        {
            Assertions.assertNull(item.getEnchants()[i]);
        }
        for (int i = 0; i<item.getGems().length; i++)
        {
            Assertions.assertNull(item.getGems()[i]);
        }
        Assertions.assertEquals(Map.of(), item.getUniqueBaseValues());
        Assertions.assertEquals(Map.of(), item.getUniqueRelativeValues());
        Assertions.assertEquals(List.of(new Enchantment(EnchantmentType.DAMAGE, 0.67637), new Enchantment(EnchantmentType.CRIT_VALUE, 0.60126)), item.getUniqueEnchants());
        Assertions.assertEquals("", item.getUniqueDescription());
    }

    @Test
    void createRingOfOldGlory() //Mythic Item
    {
        MythicItem item = itemFactory.createItem(MythicItemType.RING_OF_OLD_GLORY, CharacterClass.SPELLWEAVER);
        Assertions.assertEquals(MythicItemType.RING_OF_OLD_GLORY, item.getItemType());
        Assertions.assertEquals(145, item.getLevel());
        Assertions.assertEquals("Ring of Old Glory", item.getName());
        Assertions.assertEquals(ItemSlotType.RING, item.getItemSlotType());
        Assertions.assertEquals(7, item.getTier());
        Assertions.assertEquals(1891.513, item.getBaseValues().get(StatType.DAMAGE), 0.001);
        Assertions.assertEquals(1753.505, item.getBaseValues().get(StatType.CRIT_VALUE), 0.001);
        Assertions.assertEquals(24760.80, item.getBaseValues().get(StatType.HEALTH_POINTS), 0.001);
        for (int i = 0; i<item.getEnchants().length; i++)
        {
            Assertions.assertNull(item.getEnchants()[i]);
        }
        for (int i = 0; i<item.getGems().length; i++)
        {
            Assertions.assertNull(item.getGems()[i]);
        }
        Assertions.assertEquals(Map.of(), item.getUniqueAbsoluteValues());
        Assertions.assertEquals(Map.of(StatType.DAMAGE, 0.05, StatType.CRIT_VALUE, 0.05), item.getUniqueRelativeValues());
        Assertions.assertEquals(SetType.FORGOTTEN_GLORY, item.getSetType());
    }

    @Test
    void createAncestralGloryCloak() //Mythic Item
    {
        MythicItem item = itemFactory.createItem(MythicItemType.ANCESTRAL_GLORY_CLOAK, CharacterClass.RANGER);
        Assertions.assertEquals(MythicItemType.ANCESTRAL_GLORY_CLOAK, item.getItemType());
        Assertions.assertEquals(145, item.getLevel());
        Assertions.assertEquals("Ancestral Glory Cloak (Archer)", item.getName());
        Assertions.assertEquals(ItemSlotType.CLOAK, item.getItemSlotType());
        Assertions.assertEquals(7, item.getTier());
        Assertions.assertEquals(1891.513, item.getBaseValues().get(StatType.DAMAGE), 0.001);
        Assertions.assertEquals(0.06, item.getBaseValues().get(StatType.ATTACK_SPEED), 0.001);
        Assertions.assertEquals(37966.560, item.getBaseValues().get(StatType.HEALTH_POINTS), 0.001);
        for (int i = 0; i<item.getEnchants().length; i++)
        {
            Assertions.assertNull(item.getEnchants()[i]);
        }
        for (int i = 0; i<item.getGems().length; i++)
        {
            Assertions.assertNull(item.getGems()[i]);
        }
        Assertions.assertEquals(Map.of(StatType.DAMAGE, 5000.0), item.getUniqueAbsoluteValues());
        Assertions.assertEquals(Map.of(StatType.DAMAGE, 0.10), item.getUniqueRelativeValues());
        Assertions.assertEquals(SetType.ANCESTRAL_GLORY, item.getSetType());
    }

    @Test
    void createSargonsHorns() //Set Item
    {
        SetItem item = itemFactory.createItem(SetItemType.SARGON_HELMET, CharacterClass.SPELLWEAVER);
        Assertions.assertEquals(SetItemType.SARGON_HELMET, item.getItemType());
        Assertions.assertEquals(145, item.getLevel());
        Assertions.assertEquals("Sargon's Horns", item.getName());
        Assertions.assertEquals(ItemSlotType.HELMET, item.getItemSlotType());
        Assertions.assertEquals(0, item.getTier());
        Assertions.assertEquals(1644.883, item.getBaseValues().get(StatType.DAMAGE), 0.001);
        Assertions.assertEquals(1401.911, item.getBaseValues().get(StatType.CRIT_VALUE), 0.001);
        Assertions.assertEquals(20637.979, item.getBaseValues().get(StatType.HEALTH_POINTS), 0.001);
        for (int i = 0; i<item.getEnchants().length; i++)
        {
            Assertions.assertNull(item.getEnchants()[i]);
        }
        for (int i = 0; i<item.getGems().length; i++)
        {
            Assertions.assertNull(item.getGems()[i]);
        }
        Assertions.assertEquals(SetType.SARGONS_IMMORTAL_TERROR_ARMOR, item.getSetType());
    }

    @Test
    void createBigPawsTwoHand() //Set Item
    {
        SetItem item = itemFactory.createItem(SetItemType.BIG_PAWS_TWO_HAND, CharacterClass.SPELLWEAVER);
        Assertions.assertEquals(SetItemType.BIG_PAWS_TWO_HAND, item.getItemType());
        Assertions.assertEquals(145, item.getLevel());
        Assertions.assertEquals("Big Paws' Frosty Scepter", item.getName());
        Assertions.assertEquals(ItemSlotType.TWO_HAND_WEAPON, item.getItemSlotType());
        Assertions.assertEquals(0, item.getTier());
        Assertions.assertEquals(13163.139, item.getBaseValues().get(StatType.DAMAGE), 0.001);
        Assertions.assertEquals(3505.893, item.getBaseValues().get(StatType.CRIT_VALUE), 0.001);
        for (int i = 0; i<item.getEnchants().length; i++)
        {
            Assertions.assertNull(item.getEnchants()[i]);
        }
        for (int i = 0; i<item.getGems().length; i++)
        {
            Assertions.assertNull(item.getGems()[i]);
        }
        Assertions.assertEquals(SetType.BIG_PAWS_FROSTY_GREED, item.getSetType());
    }


    @Test
    void createAndUpdateItemBaseStats()
    {
        SetItem item = itemFactory.createItem(SetItemType.SARGON_HELMET, CharacterClass.SPELLWEAVER);
        Assertions.assertEquals(1644.883, item.getBaseValues().get(StatType.DAMAGE), 0.001);
        Assertions.assertEquals(1401.911, item.getBaseValues().get(StatType.CRIT_VALUE), 0.001);
        Assertions.assertEquals(20637.979, item.getBaseValues().get(StatType.HEALTH_POINTS), 0.001);
        Map<StatType, Double> updatedValues = Map.of(StatType.DAMAGE, 1500.0, StatType.CRIT_VALUE, 1350.0);
        item.updateBaseValues(updatedValues);
        Assertions.assertEquals(1500.0, item.getBaseValues().get(StatType.DAMAGE), 0.001);
        Assertions.assertEquals(1350.0, item.getBaseValues().get(StatType.CRIT_VALUE), 0.001);
        Assertions.assertEquals(20637.979, item.getBaseValues().get(StatType.HEALTH_POINTS), 0.001);
    }

    @Test
    void shouldThrowOnUpdateWithInvalidKeys()
    {
        SetItem item = itemFactory.createItem(SetItemType.SARGON_HELMET, CharacterClass.SPELLWEAVER);
        Assertions.assertEquals(1644.883, item.getBaseValues().get(StatType.DAMAGE), 0.001);
        Assertions.assertEquals(1401.911, item.getBaseValues().get(StatType.CRIT_VALUE), 0.001);
        Assertions.assertEquals(20637.979, item.getBaseValues().get(StatType.HEALTH_POINTS), 0.001);
        Map<StatType, Double> updatedValues = Map.of(StatType.DAMAGE, 1500.0, StatType.MANA, 13.0, StatType.MOVEMENT_SPEED, 0.5);
        Assertions.assertThrows(IllegalArgumentException.class, () -> item.updateBaseValues(updatedValues));
        Assertions.assertEquals(1644.883, item.getBaseValues().get(StatType.DAMAGE), 0.001);
        Assertions.assertEquals(1401.911, item.getBaseValues().get(StatType.CRIT_VALUE), 0.001);
        Assertions.assertEquals(20637.979, item.getBaseValues().get(StatType.HEALTH_POINTS), 0.001);
    }
}
