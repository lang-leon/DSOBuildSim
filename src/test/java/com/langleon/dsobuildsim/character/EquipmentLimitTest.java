package com.langleon.dsobuildsim.character;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.langleon.dsobuildsim.gems.AbstractGem;
import com.langleon.dsobuildsim.gems.Gem;
import com.langleon.dsobuildsim.gems.GemConfig;
import com.langleon.dsobuildsim.gems.GemFactory;
import com.langleon.dsobuildsim.gems.enums.GemLimitGroup;
import com.langleon.dsobuildsim.gems.enums.GemType;
import com.langleon.dsobuildsim.items.core.ItemFactory;
import com.langleon.dsobuildsim.items.core.LevelMultiplierTable;
import com.langleon.dsobuildsim.items.core.enums.ItemSlot;
import com.langleon.dsobuildsim.items.mythicitems.MythicItemConfig;
import com.langleon.dsobuildsim.items.setitems.SetItemConfig;
import com.langleon.dsobuildsim.items.uniqueitems.UniqueItemConfig;
import com.langleon.dsobuildsim.items.uniqueitems.UniqueItemType;
import com.langleon.dsobuildsim.jewels.Jewel;
import com.langleon.dsobuildsim.jewels.JewelConfig;
import com.langleon.dsobuildsim.jewels.JewelFactory;
import com.langleon.dsobuildsim.jewels.JewelType;
import com.langleon.dsobuildsim.runes.Rune;
import com.langleon.dsobuildsim.runes.RuneConfig;
import com.langleon.dsobuildsim.runes.RuneFactory;
import com.langleon.dsobuildsim.runes.enums.RuneLimitGroup;
import com.langleon.dsobuildsim.runes.enums.RuneType;
import com.langleon.dsobuildsim.sets.SetConfig;
import com.langleon.dsobuildsim.sets.SetFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Objects;

public class EquipmentLimitTest {

    private ItemFactory itemFactory;
    private GemFactory gemFactory;
    private JewelFactory jewelFactory;
    private RuneFactory runeFactory;
    private SetFactory setFactory;

    @BeforeEach
    void setup() throws IOException
    {
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
    }

    // Gems
    @Test
    void updateItemGems_succeedsIfWithinGemLimit() throws NoSuchFieldException, IllegalAccessException {
        Character character = new Character(CharacterClass.SPELLWEAVER, this.setFactory);
        character.equipItem(ItemSlot.AMULET, itemFactory.createItem(UniqueItemType.SARGONS_SHADOW_AMULET, CharacterClass.SPELLWEAVER));
        character.updateItemGems(ItemSlot.AMULET, new Gem[]{gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17)});
        character.equipItem(ItemSlot.CLOAK, itemFactory.createItem(UniqueItemType.CLOAK_OF_HEROES, CharacterClass.SPELLWEAVER));
        character.updateItemGems(ItemSlot.CLOAK, new Gem[]{gemFactory.createGem(GemType.AMETHYST, 17), gemFactory.createGem(GemType.AMETHYST, 17), gemFactory.createGem(GemType.AMETHYST, 17), gemFactory.createGem(GemType.AMETHYST, 17), gemFactory.createGem(GemType.AMETHYST, 17), gemFactory.createGem(GemType.AMETHYST, 17), gemFactory.createGem(GemType.AMETHYST, 17), gemFactory.createGem(GemType.AMETHYST, 17), gemFactory.createGem(GemType.AMETHYST, 17), gemFactory.createGem(GemType.AMETHYST, 17)});
        character.equipItem(ItemSlot.BELT, itemFactory.createItem(UniqueItemType.BELT_OF_ZEAL, CharacterClass.SPELLWEAVER));
        character.updateItemGems(ItemSlot.BELT, new Gem[]{gemFactory.createGem(GemType.ONYX, 17), gemFactory.createGem(GemType.ONYX, 17), gemFactory.createGem(GemType.ONYX, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.EMERALD, 17), gemFactory.createGem(GemType.EMERALD, 17), gemFactory.createGem(GemType.EMERALD, 17), gemFactory.createGem(GemType.EMERALD, 17)});

        Field gemLimitsField = Character.class.getDeclaredField("gemLimits");
        gemLimitsField.setAccessible(true);
        Map<GemLimitGroup, Integer> gemLimits = (Map<GemLimitGroup, Integer>) gemLimitsField.get(character);

        Assertions.assertEquals(13, gemLimits.get(GemLimitGroup.RUBY));
        Assertions.assertEquals(10, gemLimits.get(GemLimitGroup.AMETHYST));
        Assertions.assertEquals(4, gemLimits.get(GemLimitGroup.EMERALD));
        Assertions.assertEquals(3, gemLimits.get(GemLimitGroup.ONYX));
    }

    @Test
    void updateItemGems_throwsIfGemLimitExceeded()
    {
        Character character = new Character(CharacterClass.SPELLWEAVER, this.setFactory);
        character.equipItem(ItemSlot.AMULET, itemFactory.createItem(UniqueItemType.SARGONS_SHADOW_AMULET, CharacterClass.SPELLWEAVER));
        character.updateItemGems(ItemSlot.AMULET, new Gem[]{gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17)});
        character.equipItem(ItemSlot.CLOAK, itemFactory.createItem(UniqueItemType.CLOAK_OF_HEROES, CharacterClass.SPELLWEAVER));
        character.updateItemGems(ItemSlot.CLOAK, new Gem[]{gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17)});
        character.equipItem(ItemSlot.BELT, itemFactory.createItem(UniqueItemType.BELT_OF_ZEAL, CharacterClass.SPELLWEAVER));
        character.updateItemGems(ItemSlot.BELT, new Gem[]{gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17)});
        character.equipItem(ItemSlot.RING1, itemFactory.createItem(UniqueItemType.RING_OF_WINTER, CharacterClass.SPELLWEAVER));
        character.updateItemGems(ItemSlot.RING1, new Gem[]{gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17)});
        character.equipItem(ItemSlot.RING2, itemFactory.createItem(UniqueItemType.RING_OF_RENEWAL, CharacterClass.SPELLWEAVER));
        character.updateItemGems(ItemSlot.RING2, new Gem[]{gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17)});
        character.equipItem(ItemSlot.GLOVES, itemFactory.createItem(UniqueItemType.GLOVE_OF_ZEAL, CharacterClass.SPELLWEAVER));

        Assertions.assertThrows(IllegalArgumentException.class, () -> character.updateItemGems(ItemSlot.GLOVES, new Gem[]{gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17)}));
    }

    // Runes
    @Test
    void updateRuneTrinket_succeedsIfWithinRuneLimit() throws IllegalAccessException, NoSuchFieldException {
        Character character = new Character(CharacterClass.SPELLWEAVER, this.setFactory);
        character.updateRuneTrinket(0, new Rune[]{runeFactory.createRune(RuneType.VIGOR), runeFactory.createRune(RuneType.VIGOR), runeFactory.createRune(RuneType.VIGOR), runeFactory.createRune(RuneType.VIGOR), runeFactory.createRune(RuneType.VIGOR), runeFactory.createRune(RuneType.VITALITY), runeFactory.createRune(RuneType.VITALITY), runeFactory.createRune(RuneType.VITALITY), runeFactory.createRune(RuneType.VITALITY), runeFactory.createRune(RuneType.VITALITY)});
        character.updateRuneTrinket(1, new Rune[]{runeFactory.createRune(RuneType.CELERITY), runeFactory.createRune(RuneType.CELERITY), runeFactory.createRune(RuneType.CELERITY), runeFactory.createRune(RuneType.CELERITY), runeFactory.createRune(RuneType.CELERITY), runeFactory.createRune(RuneType.RESILIENCE), runeFactory.createRune(RuneType.RESILIENCE), runeFactory.createRune(RuneType.RESILIENCE), runeFactory.createRune(RuneType.RESILIENCE), runeFactory.createRune(RuneType.RESILIENCE)});
        character.updateRuneTrinket(2, new Rune[]{runeFactory.createRune(RuneType.MATERI_BLESSING), runeFactory.createRune(RuneType.MATERI_BLESSING), runeFactory.createRune(RuneType.MATERI_BLESSING), runeFactory.createRune(RuneType.MATERI_BLESSING), runeFactory.createRune(RuneType.MATERI_BLESSING), runeFactory.createRune(RuneType.WISDOM_SEEKER), runeFactory.createRune(RuneType.WISDOM_SEEKER), runeFactory.createRune(RuneType.WISDOM_SEEKER), runeFactory.createRune(RuneType.WISDOM_SEEKER), runeFactory.createRune(RuneType.WISDOM_SEEKER)});

        Field runeLimitsField = Character.class.getDeclaredField("runeLimits");
        runeLimitsField.setAccessible(true);
        Map<RuneLimitGroup, Integer> runeLimits = (Map<RuneLimitGroup, Integer>) runeLimitsField.get(character);

        Assertions.assertEquals(5, runeLimits.get(RuneLimitGroup.VIGOR));
        Assertions.assertEquals(5, runeLimits.get(RuneLimitGroup.VITALITY));
        Assertions.assertEquals(5, runeLimits.get(RuneLimitGroup.CELERITY));
        Assertions.assertEquals(5, runeLimits.get(RuneLimitGroup.RESILIENCE));
        Assertions.assertEquals(5, runeLimits.get(RuneLimitGroup.MATERI_BLESSING));
        Assertions.assertEquals(5, runeLimits.get(RuneLimitGroup.WISDOM_SEEKER));
    }

    @Test
    void updateRuneTrinket_throwsIfRuneLimitExceeded()
    {
        Character character = new Character(CharacterClass.SPELLWEAVER, this.setFactory);
        Assertions.assertThrows(IllegalArgumentException.class, () -> character.updateRuneTrinket(0, new Rune[]{runeFactory.createRune(RuneType.VIGOR), runeFactory.createRune(RuneType.VIGOR), runeFactory.createRune(RuneType.VIGOR), runeFactory.createRune(RuneType.VIGOR), runeFactory.createRune(RuneType.VIGOR), runeFactory.createRune(RuneType.VIGOR), runeFactory.createRune(RuneType.VIGOR), runeFactory.createRune(RuneType.VIGOR), runeFactory.createRune(RuneType.VIGOR), runeFactory.createRune(RuneType.VIGOR)}));
        Assertions.assertThrows(IllegalArgumentException.class, () -> character.updateRuneTrinket(0, new Rune[]{runeFactory.createRune(RuneType.RESILIENCE), runeFactory.createRune(RuneType.RESILIENCE), runeFactory.createRune(RuneType.RESILIENCE), runeFactory.createRune(RuneType.RESILIENCE), runeFactory.createRune(RuneType.FIRE_RESILIENCE), runeFactory.createRune(RuneType.FIRE_RESILIENCE), runeFactory.createRune(RuneType.FIRE_RESILIENCE), runeFactory.createRune(RuneType.FIRE_RESILIENCE), runeFactory.createRune(RuneType.ICE_RESILIENCE), runeFactory.createRune(RuneType.ICE_RESILIENCE)}));
        Assertions.assertThrows(IllegalArgumentException.class, () -> character.updateRuneTrinket(0, new Rune[]{runeFactory.createRune(RuneType.VIGOR), runeFactory.createRune(RuneType.VIGOR), runeFactory.createRune(RuneType.VIGOR), runeFactory.createRune(RuneType.VIGOR), runeFactory.createRune(RuneType.VIGOR), runeFactory.createRune(RuneType.VITALITY), runeFactory.createRune(RuneType.VITALITY), runeFactory.createRune(RuneType.VITALITY), runeFactory.createRune(RuneType.RISING_VIGOR), runeFactory.createRune(RuneType.RISING_POWER)}));
    }

    // Jewels
    @Test
    void updateJewelTrinket_succeedsIfWithinJewelLimit() throws IllegalAccessException, NoSuchFieldException {
        Character character = new Character(CharacterClass.SPELLWEAVER, this.setFactory);
        character.updateJewelTrinket(0, new Jewel[]{jewelFactory.createJewel(JewelType.FOCUS, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.FOCUS, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.FOCUS, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.RAGE, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.SCORCHING_RAY, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.ETERNAL_SCORN, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.ETERNAL_WRATH, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.INGREDIENT_HUNTER, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.AMBIDEXTROUS_VIGOR, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.VITALITY, CharacterClass.SPELLWEAVER)});

        Field jewelLimitsField = Character.class.getDeclaredField("jewelLimits");
        jewelLimitsField.setAccessible(true);
        Map<JewelType, Integer> jewelLimits = (Map<JewelType, Integer>) jewelLimitsField.get(character);

        Assertions.assertEquals(3, jewelLimits.get(JewelType.FOCUS));
        Assertions.assertEquals(1, jewelLimits.get(JewelType.RAGE));
        Assertions.assertEquals(1, jewelLimits.get(JewelType.SCORCHING_RAY));
        Assertions.assertEquals(1, jewelLimits.get(JewelType.ETERNAL_SCORN));
        Assertions.assertEquals(1, jewelLimits.get(JewelType.ETERNAL_WRATH));
        Assertions.assertEquals(1, jewelLimits.get(JewelType.INGREDIENT_HUNTER));
        Assertions.assertEquals(1, jewelLimits.get(JewelType.AMBIDEXTROUS_VIGOR));
        Assertions.assertEquals(1, jewelLimits.get(JewelType.VITALITY));
    }

    @Test
    void updateJewelTrinket_throwsIfJewelLimitExceeded()
    {
        Character character = new Character(CharacterClass.SPELLWEAVER, this.setFactory);
        character.updateJewelTrinket(0, new Jewel[]{jewelFactory.createJewel(JewelType.FOCUS, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.FOCUS, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.FOCUS, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.RAGE, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.SCORCHING_RAY, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.ETERNAL_SCORN, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.ETERNAL_WRATH, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.GEM_FORTUNE, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.AMBIDEXTROUS_VIGOR, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.VITALITY, CharacterClass.SPELLWEAVER)});

        Assertions.assertThrows(IllegalArgumentException.class, () -> character.updateJewelTrinket(1, new Jewel[]{jewelFactory.createJewel(JewelType.FOCUS, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.FOCUS, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.FOCUS, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.FOCUS, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.BLACK_KNIGHT_ORDER, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.INGREDIENT_HUNTER, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.INGREDIENT_HUNTER, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.INGREDIENT_HUNTER, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.VIGOR, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.GLORY, CharacterClass.SPELLWEAVER)}));
        Assertions.assertThrows(IllegalArgumentException.class, () -> character.updateJewelTrinket(1, new Jewel[]{jewelFactory.createJewel(JewelType.FOCUS, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.FOCUS, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.FOCUS, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.FOCUS, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.INGREDIENT_HUNTER, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.INGREDIENT_HUNTER, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.INGREDIENT_HUNTER, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.INGREDIENT_HUNTER, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.VIGOR, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.GLORY, CharacterClass.SPELLWEAVER)}));
    }
}
