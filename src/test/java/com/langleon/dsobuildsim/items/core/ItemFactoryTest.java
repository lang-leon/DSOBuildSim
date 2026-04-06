package com.langleon.dsobuildsim.items.core;

import com.langleon.dsobuildsim.gamedata.GameDataConfig;
import com.langleon.dsobuildsim.gamedata.GameDataLoader;
import com.langleon.dsobuildsim.character.CharacterClass;
import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.enchantments.Enchantment;
import com.langleon.dsobuildsim.items.core.enums.ItemSlotType;
import com.langleon.dsobuildsim.items.mythicitems.MythicItemType;
import com.langleon.dsobuildsim.items.setitems.SetItemType;
import com.langleon.dsobuildsim.sets.SetType;
import com.langleon.dsobuildsim.items.uniqueitems.UniqueItemType;
import com.langleon.dsobuildsim.items.mythicitems.MythicItem;
import com.langleon.dsobuildsim.items.setitems.SetItem;
import com.langleon.dsobuildsim.items.uniqueitems.UniqueItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class ItemFactoryTest {

    private ItemFactory itemFactory;

    @BeforeEach
    void setup()
    {
        GameDataConfig config = new GameDataLoader().loadGameDataConfig();
        itemFactory = new ItemFactory(config);
    }

    @Test
    void createAnniversaryTwoHandUpgraded() //Unique Item
    {
        UniqueItem item = itemFactory.createItem(UniqueItemType.ANNIVERSARY_TWO_HAND_UPGRADED, CharacterClass.SPELLWEAVER, Map.of(StatType.DAMAGE, 26326.276, StatType.CRIT_VALUE, 3505.894), 145, List.of(), List.of(), Map.of(StatType.ATTACK_SPEED, 0.102), List.of());
        Assertions.assertEquals(UniqueItemType.ANNIVERSARY_TWO_HAND_UPGRADED, item.getItemType());
        Assertions.assertEquals(145, item.getLevel());
        Assertions.assertEquals(ItemSlotType.TWO_HAND_WEAPON, item.getItemSlotType());
        Assertions.assertEquals(26326.276, item.getBaseValues().get(StatType.DAMAGE), 0.001);
        Assertions.assertEquals(3505.894, item.getBaseValues().get(StatType.CRIT_VALUE), 0.001);
        Assertions.assertEquals(0, item.getGems().size());
        Assertions.assertEquals(0, item.getEnchantments().size());
        Assertions.assertEquals(item.getUniqueBaseValues(), Map.of(StatType.ATTACK_SPEED, 0.102));
        Assertions.assertEquals(item.getUniqueRelativeValues(), Map.of(StatType.DAMAGE, 0.10));
        Assertions.assertEquals(item.getUniqueEnchants(), List.of());
    }

    @Test
    void createBrigavikGloves() //Unique Item
    {
        UniqueItem item = itemFactory.createItem(UniqueItemType.BRIGAVIK_GLOVES, CharacterClass.SPELLWEAVER, Map.of(StatType.ARMOR_VALUE, 1067.877, StatType.RESISTANCE_VALUE, 1131.275, StatType.MOVEMENT_SPEED, 0.483), 140, List.of(), List.of(), Map.of(), List.of(new Enchantment(StatType.RESISTANCE_VALUE, 0.27198)));
        Assertions.assertEquals(UniqueItemType.BRIGAVIK_GLOVES, item.getItemType());
        Assertions.assertEquals(140, item.getLevel());
        Assertions.assertEquals(ItemSlotType.GLOVES, item.getItemSlotType());
        Assertions.assertEquals(1067.877, item.getBaseValues().get(StatType.ARMOR_VALUE), 0.001);
        Assertions.assertEquals(1131.275, item.getBaseValues().get(StatType.RESISTANCE_VALUE), 0.001);
        Assertions.assertEquals(0.483, item.getBaseValues().get(StatType.MOVEMENT_SPEED), 0.001);
        Assertions.assertEquals(0, item.getGems().size());
        Assertions.assertEquals(0, item.getEnchantments().size());
        Assertions.assertEquals(Map.of(), item.getUniqueBaseValues());
        Assertions.assertEquals(Map.of(StatType.ARMOR_VALUE, 0.10), item.getUniqueRelativeValues());
        Assertions.assertEquals(List.of(new Enchantment(StatType.RESISTANCE_VALUE, 0.27198)), item.getUniqueEnchants());
    }

    @Test
    void createRocketmanAdornment() //Unique Item
    {
        UniqueItem item = itemFactory.createItem(UniqueItemType.ROCKETMAN_ADORNMENT, CharacterClass.SPELLWEAVER, Map.of(StatType.DAMAGE, 1891.513, StatType.ATTACK_SPEED, 0.055, StatType.CRIT_VALUE, 2103.982), 145, List.of(), List.of(), Map.of(), List.of(new Enchantment(StatType.DAMAGE, 0.67637), new Enchantment(StatType.CRIT_VALUE, 0.60126)));
        Assertions.assertEquals(UniqueItemType.ROCKETMAN_ADORNMENT, item.getItemType());
        Assertions.assertEquals(145, item.getLevel());
        Assertions.assertEquals(ItemSlotType.WEAPON_ADORNMENT, item.getItemSlotType());
        Assertions.assertEquals(1891.513, item.getBaseValues().get(StatType.DAMAGE), 0.001);
        Assertions.assertEquals(0.055, item.getBaseValues().get(StatType.ATTACK_SPEED), 0.001);
        Assertions.assertEquals(2103.982, item.getBaseValues().get(StatType.CRIT_VALUE), 0.001);
        Assertions.assertEquals(0, item.getGems().size());
        Assertions.assertEquals(0, item.getEnchantments().size());
        Assertions.assertEquals(Map.of(), item.getUniqueBaseValues());
        Assertions.assertEquals(Map.of(), item.getUniqueRelativeValues());
        Assertions.assertEquals(List.of(new Enchantment(StatType.DAMAGE, 0.67637), new Enchantment(StatType.CRIT_VALUE, 0.60126)), item.getUniqueEnchants());
    }

    @Test
    void createRingOfOldGlory() //Mythic Item
    {
        MythicItem item = itemFactory.createItem(MythicItemType.RING_OF_OLD_GLORY, CharacterClass.SPELLWEAVER, Map.of(StatType.DAMAGE, 1891.513, StatType.CRIT_VALUE, 1753.505, StatType.HEALTH_POINTS, 24760.80), 145, List.of(), List.of());
        Assertions.assertEquals(MythicItemType.RING_OF_OLD_GLORY, item.getItemType());
        Assertions.assertEquals(145, item.getLevel());
        Assertions.assertEquals(ItemSlotType.RING, item.getItemSlotType());
        Assertions.assertEquals(1891.513, item.getBaseValues().get(StatType.DAMAGE), 0.001);
        Assertions.assertEquals(1753.505, item.getBaseValues().get(StatType.CRIT_VALUE), 0.001);
        Assertions.assertEquals(24760.80, item.getBaseValues().get(StatType.HEALTH_POINTS), 0.001);
        Assertions.assertEquals(0, item.getGems().size());
        Assertions.assertEquals(0, item.getEnchantments().size());
        Assertions.assertEquals(Map.of(), item.getUniqueAbsoluteValues());
        Assertions.assertEquals(Map.of(StatType.DAMAGE, 0.05, StatType.CRIT_VALUE, 0.05), item.getUniqueRelativeValues());
        Assertions.assertEquals(SetType.FORGOTTEN_GLORY, item.getSetType());
    }

    @Test
    void createAncestralGloryCloak() //Mythic Item
    {
        MythicItem item = itemFactory.createItem(MythicItemType.ANCESTRAL_GLORY_CLOAK, CharacterClass.RANGER, Map.of(StatType.DAMAGE, 1891.513, StatType.ATTACK_SPEED, 0.06, StatType.HEALTH_POINTS, 37966.560), 145, List.of(), List.of());
        Assertions.assertEquals(MythicItemType.ANCESTRAL_GLORY_CLOAK, item.getItemType());
        Assertions.assertEquals(145, item.getLevel());
        Assertions.assertEquals(ItemSlotType.CLOAK, item.getItemSlotType());
        Assertions.assertEquals(1891.513, item.getBaseValues().get(StatType.DAMAGE), 0.001);
        Assertions.assertEquals(0.06, item.getBaseValues().get(StatType.ATTACK_SPEED), 0.001);
        Assertions.assertEquals(37966.560, item.getBaseValues().get(StatType.HEALTH_POINTS), 0.001);
        Assertions.assertEquals(0, item.getGems().size());
        Assertions.assertEquals(0, item.getEnchantments().size());
        Assertions.assertEquals(Map.of(StatType.DAMAGE, 5000.0), item.getUniqueAbsoluteValues());
        Assertions.assertEquals(Map.of(StatType.DAMAGE, 0.10), item.getUniqueRelativeValues());
        Assertions.assertEquals(SetType.ANCESTRAL_GLORY, item.getSetType());
    }

    @Test
    void createSargonsHorns() //Set Item
    {
        SetItem item = itemFactory.createItem(SetItemType.SARGON_HELMET, CharacterClass.SPELLWEAVER, Map.of(StatType.DAMAGE, 1644.883, StatType.CRIT_VALUE, 1401.911, StatType.HEALTH_POINTS, 20637.979), 145, List.of(), List.of());
        Assertions.assertEquals(SetItemType.SARGON_HELMET, item.getItemType());
        Assertions.assertEquals(145, item.getLevel());
        Assertions.assertEquals(ItemSlotType.HELMET, item.getItemSlotType());
        Assertions.assertEquals(1644.883, item.getBaseValues().get(StatType.DAMAGE), 0.001);
        Assertions.assertEquals(1401.911, item.getBaseValues().get(StatType.CRIT_VALUE), 0.001);
        Assertions.assertEquals(20637.979, item.getBaseValues().get(StatType.HEALTH_POINTS), 0.001);
        Assertions.assertEquals(0, item.getGems().size());
        Assertions.assertEquals(0, item.getEnchantments().size());
        Assertions.assertEquals(SetType.SARGONS_IMMORTAL_TERROR_ARMOR, item.getSetType());
    }

    @Test
    void createBigPawsTwoHand() //Set Item
    {
        SetItem item = itemFactory.createItem(SetItemType.BIG_PAWS_TWO_HAND, CharacterClass.SPELLWEAVER, Map.of(StatType.DAMAGE, 13163.139, StatType.CRIT_VALUE, 3505.893), 145, List.of(), List.of());
        Assertions.assertEquals(SetItemType.BIG_PAWS_TWO_HAND, item.getItemType());
        Assertions.assertEquals(145, item.getLevel());
        Assertions.assertEquals(ItemSlotType.TWO_HAND_WEAPON, item.getItemSlotType());
        Assertions.assertEquals(13163.139, item.getBaseValues().get(StatType.DAMAGE), 0.001);
        Assertions.assertEquals(3505.893, item.getBaseValues().get(StatType.CRIT_VALUE), 0.001);
        Assertions.assertEquals(0, item.getGems().size());
        Assertions.assertEquals(0, item.getEnchantments().size());
        Assertions.assertEquals(SetType.BIG_PAWS_FROSTY_GREED, item.getSetType());
    }
}
