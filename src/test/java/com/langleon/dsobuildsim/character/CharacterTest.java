package com.langleon.dsobuildsim.character;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.langleon.dsobuildsim.dragonstones.DragonStone;
import com.langleon.dsobuildsim.dragonstones.DragonStoneConfig;
import com.langleon.dsobuildsim.dragonstones.DragonStoneFactory;
import com.langleon.dsobuildsim.enchantments.Enchantment;
import com.langleon.dsobuildsim.enchantments.EnchantmentConfig;
import com.langleon.dsobuildsim.enchantments.EnchantmentDefinition;
import com.langleon.dsobuildsim.gems.AbstractGem;
import com.langleon.dsobuildsim.items.core.enums.ItemSlot;
import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.dragonstones.DragonStoneType;
import com.langleon.dsobuildsim.essences.EssenceType;
import com.langleon.dsobuildsim.gems.enums.GemType;
import com.langleon.dsobuildsim.items.mythicitems.MythicItemType;
import com.langleon.dsobuildsim.items.setitems.SetItemType;
import com.langleon.dsobuildsim.items.uniqueitems.UniqueItemType;
import com.langleon.dsobuildsim.jewels.JewelType;
import com.langleon.dsobuildsim.pets.enums.PetType;
import com.langleon.dsobuildsim.runes.enums.RuneType;
import com.langleon.dsobuildsim.essences.EssenceConfig;
import com.langleon.dsobuildsim.essences.EssenceFactory;
import com.langleon.dsobuildsim.gems.GemConfig;
import com.langleon.dsobuildsim.gems.GemFactory;
import com.langleon.dsobuildsim.items.core.Item;
import com.langleon.dsobuildsim.items.core.ItemFactory;
import com.langleon.dsobuildsim.items.core.LevelMultiplierTable;
import com.langleon.dsobuildsim.items.mythicitems.MythicItemConfig;
import com.langleon.dsobuildsim.items.setitems.SetItemConfig;
import com.langleon.dsobuildsim.items.uniqueitems.UniqueItemConfig;
import com.langleon.dsobuildsim.jewels.Jewel;
import com.langleon.dsobuildsim.jewels.JewelConfig;
import com.langleon.dsobuildsim.jewels.JewelFactory;
import com.langleon.dsobuildsim.pets.PetConfig;
import com.langleon.dsobuildsim.pets.PetFactory;
import com.langleon.dsobuildsim.runes.Rune;
import com.langleon.dsobuildsim.runes.RuneConfig;
import com.langleon.dsobuildsim.runes.RuneFactory;
import com.langleon.dsobuildsim.sets.SetConfig;
import com.langleon.dsobuildsim.sets.SetFactory;
import com.langleon.dsobuildsim.skilltrees.wisdomskilltree.WisdomSkillTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class CharacterTest {

    private ItemFactory itemFactory;
    private EssenceFactory essenceFactory;
    private DragonStoneFactory dragonStoneFactory;
    private GemFactory gemFactory;
    private JewelFactory jewelFactory;
    private PetFactory petFactory;
    private RuneFactory runeFactory;
    private SetFactory setFactory;
    private EnchantmentConfig enchantmentConfig;

    @BeforeEach
    void setup() throws IOException
    {
        try (var reader = new InputStreamReader(Objects.requireNonNull(getClass().getResourceAsStream("/data/essences.json"))))
        {
            ObjectMapper objectMapper = new ObjectMapper();
            EssenceConfig essenceConfig = objectMapper.readValue(reader, EssenceConfig.class);
            essenceFactory = new EssenceFactory(essenceConfig);
        }
        try (var reader = new InputStreamReader(Objects.requireNonNull(getClass().getResourceAsStream("/data/dragonstones.json"))))
        {
            ObjectMapper objectMapper = new ObjectMapper();
            DragonStoneConfig dragonStoneConfig = objectMapper.readValue(reader, DragonStoneConfig.class);
            dragonStoneFactory = new DragonStoneFactory(dragonStoneConfig);
        }
        try (var reader = new InputStreamReader(Objects.requireNonNull(getClass().getResourceAsStream("/data/gems.json"))))
        {
            ObjectMapper objectMapper = new ObjectMapper();
            GemConfig gemConfig = objectMapper.readValue(reader, GemConfig.class);
            gemFactory = new GemFactory(gemConfig);
        }
        try (var reader = new InputStreamReader(Objects.requireNonNull(getClass().getResourceAsStream("/data/jewels.json"))))
        {
            ObjectMapper objectMapper = new ObjectMapper();
            JewelConfig jewelConfig = objectMapper.readValue(reader, JewelConfig.class);
            jewelFactory = new JewelFactory(jewelConfig);
        }
        try (var reader = new InputStreamReader(Objects.requireNonNull(getClass().getResourceAsStream("/data/pets.json"))))
        {
            ObjectMapper objectMapper = new ObjectMapper();
            PetConfig petConfig = objectMapper.readValue(reader, PetConfig.class);
            petFactory = new PetFactory(petConfig);
        }
        try (var reader = new InputStreamReader(Objects.requireNonNull(getClass().getResourceAsStream("/data/runes.json"))))
        {
            ObjectMapper objectMapper = new ObjectMapper();
            RuneConfig runeConfig = objectMapper.readValue(reader, RuneConfig.class);
            runeFactory = new RuneFactory(runeConfig);
        }
        try (var reader = new InputStreamReader(Objects.requireNonNull(getClass().getResourceAsStream("/data/sets.json")))) {
            ObjectMapper objectMapper = new ObjectMapper();
            SetConfig setConfig = objectMapper.readValue(reader, SetConfig.class);
            setFactory = new SetFactory(setConfig);
        }
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
        
        try (var reader = new InputStreamReader(Objects.requireNonNull(getClass().getResourceAsStream("/data/enchantments.json"))))
        {
            enchantmentConfig = objectMapper.readValue(reader, EnchantmentConfig.class);
        }
    }

    @Test
    void createCharacterAndCalculateStats()
    {
        Character character = createCharacter();
        Map<StatType, Double> stats = character.calculateCharacterStats();
        Assertions.assertEquals(1293650.547, stats.get(StatType.DAMAGE), 0.001);
        Assertions.assertEquals(4.456, stats.get(StatType.ATTACK_SPEED), 0.001);
        Assertions.assertEquals(401797.836, stats.get(StatType.CRIT_VALUE), 0.001);
        Assertions.assertEquals(100.000, stats.get(StatType.MANA), 0.001);
        Assertions.assertEquals(12.000, stats.get(StatType.MANA_PER_SECOND), 0.001);
        Assertions.assertEquals(13.132, stats.get(StatType.MOVEMENT_SPEED), 0.001);
        Assertions.assertEquals(2829236.013, stats.get(StatType.HEALTH_POINTS), 0.001);
        Assertions.assertEquals(9900.000, stats.get(StatType.HEALTH_PER_SECOND), 0.001);
        Assertions.assertEquals(319956.940, stats.get(StatType.BLOCK_VALUE), 0.001);
        Assertions.assertEquals(44480.716, stats.get(StatType.ARMOR_VALUE), 0.001);
        Assertions.assertEquals(48819.419, stats.get(StatType.FIRE_RESISTANCE), 0.001);
        Assertions.assertEquals(89215.770, stats.get(StatType.ICE_RESISTANCE), 0.001);
        Assertions.assertEquals(48819.419, stats.get(StatType.LIGHTNING_RESISTANCE), 0.001);
        Assertions.assertEquals(67811.756, stats.get(StatType.ANDERMAGIC_RESISTANCE), 0.001);
        Assertions.assertEquals(48819.419, stats.get(StatType.POISON_RESISTANCE), 0.001);
    }

    private Character createCharacter()
    {
        Character character = new Character(CharacterClass.SPELLWEAVER, setFactory);

        character.setExperienceBonusPathLevel(5);
        character.setElementalMasteryType(MasteryType.ICE);
        character.setElementalMasteryLevel(3);

        character.updateRuneTrinket(0, new Rune[]{runeFactory.createRune(RuneType.VIGOR), runeFactory.createRune(RuneType.VIGOR), runeFactory.createRune(RuneType.VIGOR), runeFactory.createRune(RuneType.VIGOR), runeFactory.createRune(RuneType.VIGOR), runeFactory.createRune(RuneType.DEVASTATION), runeFactory.createRune(RuneType.DEVASTATION), runeFactory.createRune(RuneType.DEVASTATION), runeFactory.createRune(RuneType.DEVASTATION), runeFactory.createRune(RuneType.DEVASTATION),});
        character.updateRuneTrinket(1, new Rune[]{runeFactory.createRune(RuneType.SPRING), runeFactory.createRune(RuneType.SPRING), runeFactory.createRune(RuneType.SPRING), runeFactory.createRune(RuneType.SPRING), runeFactory.createRune(RuneType.SPRING), runeFactory.createRune(RuneType.SUMMER), runeFactory.createRune(RuneType.SUMMER), runeFactory.createRune(RuneType.SUMMER), runeFactory.createRune(RuneType.SUMMER), runeFactory.createRune(RuneType.SUMMER),});
        character.updateRuneTrinket(2, new Rune[]{runeFactory.createRune(RuneType.AUTUMN), runeFactory.createRune(RuneType.AUTUMN), runeFactory.createRune(RuneType.AUTUMN), runeFactory.createRune(RuneType.AUTUMN), runeFactory.createRune(RuneType.AUTUMN), runeFactory.createRune(RuneType.WINTER), runeFactory.createRune(RuneType.WINTER), runeFactory.createRune(RuneType.WINTER), runeFactory.createRune(RuneType.WINTER), runeFactory.createRune(RuneType.WINTER),});
        character.updateRuneTrinket(3, new Rune[]{runeFactory.createRune(RuneType.CELERITY), runeFactory.createRune(RuneType.CELERITY), runeFactory.createRune(RuneType.CELERITY), runeFactory.createRune(RuneType.CELERITY), runeFactory.createRune(RuneType.CELERITY), runeFactory.createRune(RuneType.VITALITY), runeFactory.createRune(RuneType.VITALITY), runeFactory.createRune(RuneType.VITALITY), runeFactory.createRune(RuneType.VITALITY), runeFactory.createRune(RuneType.VITALITY),});
        character.updateRuneTrinket(4, new Rune[]{runeFactory.createRune(RuneType.PERSISTENCE), runeFactory.createRune(RuneType.PERSISTENCE), runeFactory.createRune(RuneType.PERSISTENCE), runeFactory.createRune(RuneType.PERSISTENCE), runeFactory.createRune(RuneType.PERSISTENCE), runeFactory.createRune(RuneType.ACCELERATION), runeFactory.createRune(RuneType.ACCELERATION), runeFactory.createRune(RuneType.ACCELERATION), runeFactory.createRune(RuneType.ACCELERATION), runeFactory.createRune(RuneType.ACCELERATION),});
        character.updateRuneTrinket(5, new Rune[]{runeFactory.createRune(RuneType.HOLY_STAR_SHARD), runeFactory.createRune(RuneType.RISING_VIGOR), runeFactory.createRune(RuneType.FORTITUDE), runeFactory.createRune(RuneType.FORTITUDE), runeFactory.createRune(RuneType.FORTITUDE), runeFactory.createRune(RuneType.ANDERMANT_FEVER), runeFactory.createRune(RuneType.REALM_CHANGER), runeFactory.createRune(RuneType.RESILIENCE), runeFactory.createRune(RuneType.RESILIENCE), runeFactory.createRune(RuneType.RESILIENCE),});

        character.updateJewelTrinket(0, new Jewel[]{jewelFactory.createJewel(JewelType.ETERNAL_SCORN, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.GLORY, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.RAGE, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.AMPLIFIED_HEALING, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.FROZEN_HEART, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.GEM_FORTUNE, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.ETERNAL_WRATH, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.INGREDIENT_HUNTER, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.INGREDIENT_HUNTER, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.INGREDIENT_HUNTER, CharacterClass.SPELLWEAVER),});
        character.updateJewelTrinket(1, new Jewel[]{jewelFactory.createJewel(JewelType.FOCUS, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.FOCUS, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.FOCUS, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.FOCUS, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.FOCUS, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.VIGOR, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.AMBIDEXTROUS_VIGOR, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.VITALITY, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.ENCOURAGEMENT, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.CONTRIBUTION, CharacterClass.SPELLWEAVER),});
        character.updateJewelTrinket(2, new Jewel[]{jewelFactory.createJewel(JewelType.LASTING_HEALTH, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.CONVERSE, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.FLOWER, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.STRENUOUSNESS, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.FORTITUDE, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.PROLONGATION, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.REVIVAL_BOON, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.EASTER_FEVER, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.SCORCHING_RAY, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.PENT_UP_POWER, CharacterClass.SPELLWEAVER),});

        character.updateDragonCrestTrinket(new DragonStone[]{dragonStoneFactory.createDragonStone(DragonStoneType.POWERSTONE, 5), dragonStoneFactory.createDragonStone(DragonStoneType.POWERSTONE, 5), dragonStoneFactory.createDragonStone(DragonStoneType.POWERSTONE, 3), dragonStoneFactory.createDragonStone(DragonStoneType.POWERSTONE, 3), dragonStoneFactory.createDragonStone(DragonStoneType.POWERSTONE, 3), null, null, null, null, null});

        EnchantmentDefinition enchantDefHP = enchantmentConfig.enchantments().get(StatType.HEALTH_POINTS);
        EnchantmentDefinition enchantDefDMG = enchantmentConfig.enchantments().get(StatType.DAMAGE);
        EnchantmentDefinition enchantDefCrit = enchantmentConfig.enchantments().get(StatType.CRIT_VALUE);
        EnchantmentDefinition enchantDefBlock = enchantmentConfig.enchantments().get(StatType.BLOCK_VALUE);
        EnchantmentDefinition enchantDefMS = enchantmentConfig.enchantments().get(StatType.MOVEMENT_SPEED);
        
        Item amulet = itemFactory.createItem(SetItemType.WINTER_AMULET, CharacterClass.SPELLWEAVER, Map.of(StatType.DAMAGE, 1644.883, StatType.MOVEMENT_SPEED, 0.489, StatType.HEALTH_POINTS, 24760.80), 145);
        amulet.setEnchantments(new Enchantment[]{new Enchantment(enchantDefHP.statType(), enchantDefHP.value()),new Enchantment(enchantDefHP.statType(), enchantDefHP.value()),new Enchantment(enchantDefHP.statType(), enchantDefHP.value()),new Enchantment(enchantDefHP.statType(), enchantDefHP.value())});
        character.equipItem(ItemSlot.AMULET, amulet);
        character.updateItemGems(ItemSlot.AMULET, new AbstractGem[]{gemFactory.createGem(GemType.AMETHYST, 17), gemFactory.createGem(GemType.AMETHYST, 17), gemFactory.createGem(GemType.AMETHYST, 17), gemFactory.createGem(GemType.AMETHYST, 17), gemFactory.createGem(GemType.AMETHYST, 17),gemFactory.createGem(GemType.AMETHYST, 17), gemFactory.createGem(GemType.AMETHYST, 17), gemFactory.createGem(GemType.AMETHYST, 17), gemFactory.createGem(GemType.AMETHYST, 17), gemFactory.createGem(GemType.AMETHYST, 17)});

        Item cloak = itemFactory.createItem(MythicItemType.ANCESTRAL_GLORY_CLOAK, CharacterClass.SPELLWEAVER, Map.of(StatType.DAMAGE, 1891.513, StatType.ATTACK_SPEED, 0.06, StatType.HEALTH_POINTS, 16507.200), 145);
        cloak.setEnchantments(new Enchantment[]{new Enchantment(enchantDefDMG.statType(), enchantDefDMG.value()),new Enchantment(enchantDefDMG.statType(), enchantDefDMG.value()),new Enchantment(enchantDefDMG.statType(), enchantDefDMG.value()),new Enchantment(enchantDefDMG.statType(), enchantDefDMG.value())});
        character.equipItem(ItemSlot.CLOAK, cloak);
        character.updateItemGems(ItemSlot.CLOAK, new AbstractGem[]{gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17),gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17)});

        Item belt = itemFactory.createItem(UniqueItemType.BELT_OF_ZEAL, CharacterClass.SPELLWEAVER, Map.of(StatType.DAMAGE, 1630.885, StatType.HEALTH_POINTS, 20072.654, StatType.RESISTANCE_VALUE, 1679.873), 145, Map.of(), Set.of(new Enchantment(StatType.DAMAGE, 0.22384)));
        belt.updateBaseValues(Map.of(StatType.DAMAGE, 1630.885, StatType.HEALTH_POINTS, 20072.654, StatType.RESISTANCE_VALUE, 1679.873));
        belt.setEnchantments(new Enchantment[]{new Enchantment(enchantDefDMG.statType(), enchantDefDMG.value()),new Enchantment(enchantDefDMG.statType(), enchantDefDMG.value()),new Enchantment(enchantDefDMG.statType(), enchantDefDMG.value()),new Enchantment(enchantDefDMG.statType(), enchantDefDMG.value())});
        character.equipItem(ItemSlot.BELT, belt);
        character.updateItemGems(ItemSlot.BELT, new AbstractGem[]{gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17),gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17)});

        Item ring1 = itemFactory.createItem(MythicItemType.ANCESTRAL_GLORY_RING, CharacterClass.SPELLWEAVER, Map.of(StatType.DAMAGE, 1891.513, StatType.CRIT_VALUE, 1753.505, StatType.HEALTH_POINTS, 24760.80), 145);
        ring1.setEnchantments(new Enchantment[]{new Enchantment(enchantDefHP.statType(), enchantDefHP.value()),new Enchantment(enchantDefHP.statType(), enchantDefHP.value()),new Enchantment(enchantDefHP.statType(), enchantDefHP.value()),new Enchantment(enchantDefHP.statType(), enchantDefHP.value())});
        character.equipItem(ItemSlot.RING1, ring1);
        character.updateItemGems(ItemSlot.RING1, new AbstractGem[]{gemFactory.createGem(GemType.AMETHYST, 17), gemFactory.createGem(GemType.AMETHYST, 17), gemFactory.createGem(GemType.AMETHYST, 17), gemFactory.createGem(GemType.AMETHYST, 17), gemFactory.createGem(GemType.AMETHYST, 17),gemFactory.createGem(GemType.AMETHYST, 17), gemFactory.createGem(GemType.AMETHYST, 17), gemFactory.createGem(GemType.AMETHYST, 17), gemFactory.createGem(GemType.AMETHYST, 17), gemFactory.createGem(GemType.AMETHYST, 17)});

        Item ring2 = itemFactory.createItem(MythicItemType.ANCESTRAL_GLORY_RING, CharacterClass.SPELLWEAVER, Map.of(StatType.DAMAGE, 1891.513, StatType.CRIT_VALUE, 1753.505, StatType.HEALTH_POINTS, 24760.80), 145);
        ring2.setEnchantments(new Enchantment[]{new Enchantment(enchantDefDMG.statType(), enchantDefDMG.value()),new Enchantment(enchantDefDMG.statType(), enchantDefDMG.value()),new Enchantment(enchantDefDMG.statType(), enchantDefDMG.value()),new Enchantment(enchantDefDMG.statType(), enchantDefDMG.value())});
        character.equipItem(ItemSlot.RING2, ring2);
        character.updateItemGems(ItemSlot.RING2, new AbstractGem[]{gemFactory.createOpal(GemType.ONYX, GemType.RUBY, GemType.EMERALD, 17), gemFactory.createOpal(GemType.ONYX, GemType.RUBY, GemType.EMERALD, 17), gemFactory.createOpal(GemType.ONYX, GemType.RUBY, GemType.EMERALD, 17), gemFactory.createOpal(GemType.ONYX, GemType.RUBY, GemType.EMERALD, 17), gemFactory.createOpal(GemType.ONYX, GemType.RUBY, GemType.EMERALD, 17), gemFactory.createOpal(GemType.ONYX, GemType.RUBY, GemType.EMERALD, 17), gemFactory.createOpal(GemType.ONYX, GemType.RUBY, GemType.EMERALD, 17), gemFactory.createOpal(GemType.ONYX, GemType.RUBY, GemType.EMERALD, 17), gemFactory.createOpal(GemType.ONYX, GemType.RUBY, GemType.EMERALD, 17), gemFactory.createOpal(GemType.ONYX, GemType.RUBY, GemType.EMERALD, 17)});

        Item helmet = itemFactory.createItem(SetItemType.STELLAR_WALKER_HELMET, CharacterClass.SPELLWEAVER, Map.of(StatType.DAMAGE, 1426.117, StatType.CRIT_VALUE, 1298.723, StatType.HEALTH_POINTS, 19630.458), 145);
        helmet.updateBaseValues(Map.of(StatType.DAMAGE, 1426.117, StatType.CRIT_VALUE, 1298.723, StatType.HEALTH_POINTS, 19630.458));
        helmet.setEnchantments(new Enchantment[]{new Enchantment(enchantDefHP.statType(), enchantDefHP.value()),new Enchantment(enchantDefHP.statType(), enchantDefHP.value()),new Enchantment(enchantDefHP.statType(), enchantDefHP.value()),new Enchantment(enchantDefHP.statType(), enchantDefHP.value())});
        character.equipItem(ItemSlot.HELMET, helmet);
        character.updateItemGems(ItemSlot.HELMET, new AbstractGem[]{gemFactory.createGem(GemType.AMETHYST, 17), gemFactory.createGem(GemType.AMETHYST, 17), gemFactory.createGem(GemType.AMETHYST, 17), gemFactory.createGem(GemType.AMETHYST, 17), gemFactory.createGem(GemType.AMETHYST, 17),gemFactory.createGem(GemType.AMETHYST, 17), gemFactory.createGem(GemType.AMETHYST, 17), gemFactory.createGem(GemType.AMETHYST, 17), gemFactory.createGem(GemType.AMETHYST, 17), gemFactory.createGem(GemType.AMETHYST, 17)});

        Item shoulders = itemFactory.createItem(SetItemType.STELLAR_WALKER_SHOULDERS, CharacterClass.SPELLWEAVER ,Map.of(StatType.DAMAGE, 1639.564, StatType.CRIT_VALUE, 1361.277, StatType.HEALTH_POINTS, 15625.218), 145);
        shoulders.updateBaseValues(Map.of(StatType.DAMAGE, 1639.564, StatType.CRIT_VALUE, 1361.727, StatType.HEALTH_POINTS, 15625.218));
        shoulders.setEnchantments(new Enchantment[]{new Enchantment(enchantDefBlock.statType(), enchantDefBlock.value()),new Enchantment(enchantDefBlock.statType(), enchantDefBlock.value()),new Enchantment(enchantDefBlock.statType(), enchantDefBlock.value()),new Enchantment(enchantDefBlock.statType(), enchantDefBlock.value())});
        character.equipItem(ItemSlot.SHOULDERS, shoulders);
        character.updateItemGems(ItemSlot.SHOULDERS, new AbstractGem[]{gemFactory.createGem(GemType.EMERALD, 17), gemFactory.createGem(GemType.EMERALD, 17), gemFactory.createGem(GemType.EMERALD, 17), gemFactory.createGem(GemType.EMERALD, 17), gemFactory.createGem(GemType.EMERALD, 17),gemFactory.createGem(GemType.EMERALD, 17), gemFactory.createGem(GemType.EMERALD, 17), gemFactory.createGem(GemType.EMERALD, 17), gemFactory.createGem(GemType.EMERALD, 17), gemFactory.createGem(GemType.EMERALD, 17)});

        Item torso = itemFactory.createItem(SetItemType.WINTER_TORSO, CharacterClass.SPELLWEAVER, Map.of(StatType.ARMOR_VALUE, 1648.043, StatType.ANDERMAGIC_RESISTANCE, 6225.969, StatType.BLOCK_VALUE, 1589.428), 145);
        torso.setEnchantments(new Enchantment[]{new Enchantment(enchantDefBlock.statType(), enchantDefBlock.value()),new Enchantment(enchantDefBlock.statType(), enchantDefBlock.value()),new Enchantment(enchantDefBlock.statType(), enchantDefBlock.value()),new Enchantment(enchantDefBlock.statType(), enchantDefBlock.value())});
        character.equipItem(ItemSlot.TORSO, torso);
        character.updateItemGems(ItemSlot.TORSO, new AbstractGem[]{gemFactory.createGem(GemType.EMERALD, 17), gemFactory.createGem(GemType.EMERALD, 17), gemFactory.createGem(GemType.EMERALD, 17), gemFactory.createGem(GemType.EMERALD, 17), gemFactory.createGem(GemType.EMERALD, 17),gemFactory.createGem(GemType.EMERALD, 17), gemFactory.createGem(GemType.EMERALD, 17), gemFactory.createGem(GemType.EMERALD, 17), gemFactory.createGem(GemType.EMERALD, 17), gemFactory.createGem(GemType.EMERALD, 17)});

        Item gloves = itemFactory.createItem(SetItemType.WINTER_GLOVES, CharacterClass.SPELLWEAVER, Map.of(StatType.DAMAGE, 1644.883, StatType.ATTACK_SPEED, 0.055, StatType.CRIT_VALUE, 1753.505), 145);
        gloves.setEnchantments(new Enchantment[]{new Enchantment(enchantDefCrit.statType(), enchantDefCrit.value()),new Enchantment(enchantDefCrit.statType(), enchantDefCrit.value()),new Enchantment(enchantDefCrit.statType(), enchantDefCrit.value()),new Enchantment(enchantDefCrit.statType(), enchantDefCrit.value())});
        character.equipItem(ItemSlot.GLOVES, gloves);
        character.updateItemGems(ItemSlot.GLOVES, new AbstractGem[]{gemFactory.createGem(GemType.ONYX, 17), gemFactory.createGem(GemType.ONYX, 17), gemFactory.createGem(GemType.ONYX, 17), gemFactory.createGem(GemType.ONYX, 17), gemFactory.createGem(GemType.ONYX, 17),gemFactory.createGem(GemType.ONYX, 17), gemFactory.createGem(GemType.ONYX, 17), gemFactory.createGem(GemType.ONYX, 17), gemFactory.createGem(GemType.ONYX, 17), gemFactory.createGem(GemType.ONYX, 17)});

        Item boots = itemFactory.createItem(SetItemType.WINTER_BOOTS, CharacterClass.SPELLWEAVER, Map.of(StatType.DAMAGE, 1644.883, StatType.MOVEMENT_SPEED, 1.221, StatType.CRIT_VALUE, 1401.911), 145);
        boots.setEnchantments(new Enchantment[]{new Enchantment(enchantDefMS.statType(), enchantDefMS.value()), new Enchantment(enchantDefMS.statType(), enchantDefMS.value()), new Enchantment(enchantDefDMG.statType(), enchantDefDMG.value()), new Enchantment(enchantDefDMG.statType(), enchantDefDMG.value())});
        character.equipItem(ItemSlot.BOOTS, boots);
        character.updateItemGems(ItemSlot.BOOTS, new AbstractGem[]{gemFactory.createGem(GemType.RHODOLITE, 17), gemFactory.createGem(GemType.EMERALD, 17), gemFactory.createGem(GemType.ONYX, 17), gemFactory.createGem(GemType.ONYX, 17), gemFactory.createGem(GemType.ONYX, 17),gemFactory.createGem(GemType.ONYX, 17), gemFactory.createGem(GemType.ONYX, 17), gemFactory.createGem(GemType.ONYX, 17), gemFactory.createGem(GemType.ONYX, 17), gemFactory.createGem(GemType.ONYX, 17)});

        Item adornment = itemFactory.createItem(UniqueItemType.SIGRISMARRS_ADORNMENT, CharacterClass.SPELLWEAVER, Map.of(StatType.DAMAGE, 1870.52, StatType.CRIT_VALUE, 2100.146), 145, Map.of(StatType.ATTACK_SPEED, 0.06), Set.of());
        adornment.updateBaseValues(Map.of(StatType.DAMAGE, 1870.52, StatType.CRIT_VALUE, 2100.146));
        adornment.setEnchantments(new Enchantment[]{new Enchantment(enchantDefDMG.statType(), enchantDefDMG.value()),new Enchantment(enchantDefDMG.statType(), enchantDefDMG.value()),new Enchantment(enchantDefDMG.statType(), enchantDefDMG.value()),new Enchantment(enchantDefDMG.statType(), enchantDefDMG.value())});
        character.equipItem(ItemSlot.WEAPON_ADORNMENT, adornment);
        character.updateItemGems(ItemSlot.WEAPON_ADORNMENT, new AbstractGem[]{gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17),gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17)});

        Item twohand = itemFactory.createItem(UniqueItemType.ANNIVERSARY_TWO_HAND_UPGRADED, CharacterClass.SPELLWEAVER, Map.of(StatType.DAMAGE, 26326.278, StatType.CRIT_VALUE, 3050.894), 145, Map.of(StatType.ATTACK_SPEED, 0.102), Set.of());
        twohand.setEnchantments(new Enchantment[]{new Enchantment(enchantDefDMG.statType(), enchantDefDMG.value()),new Enchantment(enchantDefDMG.statType(), enchantDefDMG.value()),new Enchantment(enchantDefDMG.statType(), enchantDefDMG.value()),new Enchantment(enchantDefDMG.statType(), enchantDefDMG.value())});
        character.equipItem(ItemSlot.TWO_HAND_WEAPON, twohand);
        character.updateItemGems(ItemSlot.TWO_HAND_WEAPON, new AbstractGem[]{gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17),gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17)});

        character.setEssence(essenceFactory.createEssence(EssenceType.VIGOR, 3));

        character.setPet(petFactory.createPet(PetType.THE_SOUL_OF_DRAGAN_DOLL));

        WisdomSkillTree wisdomSkillTree = new WisdomSkillTree();
        wisdomSkillTree.setLevel(60, 1, 1);
        wisdomSkillTree.setLevel(60, 1, 2);
        wisdomSkillTree.setLevel(80, 2, 1);
        wisdomSkillTree.setLevel(80, 2, 2);
        wisdomSkillTree.setLevel(40, 2, 3);
        wisdomSkillTree.setLevel(80, 3, 1);
        wisdomSkillTree.setLevel(60, 3, 2);
        wisdomSkillTree.setLevel(60, 3, 3);
        wisdomSkillTree.setLevel(1, 4, 1);
        wisdomSkillTree.setLevel(60, 5, 1);
        wisdomSkillTree.setLevel(60, 5, 2);
        wisdomSkillTree.setLevel(60, 6, 1);
        wisdomSkillTree.setLevel(30, 6, 2);
        wisdomSkillTree.setLevel(60, 6, 3);
        wisdomSkillTree.setLevel(15, 7, 1);
        wisdomSkillTree.setLevel(1, 7, 2);
        wisdomSkillTree.setLevel(1, 7, 3);
        wisdomSkillTree.setLevel(15, 8, 1);
        wisdomSkillTree.setLevel(15, 8, 2);
        character.setWisdomSkillTree(wisdomSkillTree);

        character.setCollectorBagBuffs(Map.of(StatType.RESISTANCE_VALUE, 0.15, StatType.BLOCK_VALUE, 0.02, StatType.DAMAGE, 0.06, StatType.HEALTH_POINTS, 0.33));

        return character;
    }
}
