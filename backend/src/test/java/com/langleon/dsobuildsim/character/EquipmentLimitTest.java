package com.langleon.dsobuildsim.character;

import com.langleon.dsobuildsim.dragonstones.DragonCrestTrinket;
import com.langleon.dsobuildsim.exceptions.LimitExceededException;
import com.langleon.dsobuildsim.gamedata.GameDataConfig;
import com.langleon.dsobuildsim.gamedata.GameDataLoader;
import com.langleon.dsobuildsim.gems.AbstractGem;
import com.langleon.dsobuildsim.jewels.*;
import com.langleon.dsobuildsim.runes.RuneTrinket;
import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.gems.Gem;
import com.langleon.dsobuildsim.gems.GemFactory;
import com.langleon.dsobuildsim.gems.enums.GemType;
import com.langleon.dsobuildsim.items.core.Item;
import com.langleon.dsobuildsim.items.core.ItemFactory;
import com.langleon.dsobuildsim.items.core.enums.ItemSlot;
import com.langleon.dsobuildsim.items.setitems.SetItemType;
import com.langleon.dsobuildsim.runes.RuneFactory;
import com.langleon.dsobuildsim.runes.enums.RuneType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class EquipmentLimitTest {

    private ItemFactory itemFactory;
    private GemFactory gemFactory;
    private JewelFactory jewelFactory;
    private RuneFactory runeFactory;

    @BeforeEach
    void setup()
    {
        GameDataConfig config = new GameDataLoader().loadGameDataConfig();
        itemFactory = new ItemFactory(config);
        gemFactory = new GemFactory(config);
        jewelFactory = new JewelFactory(config);
        runeFactory = new RuneFactory(config);
    }

    // Gems
    @Test
    void updateItemGems_succeedsIfWithinGemLimit()
    {
        Map<ItemSlot, Item> items = new HashMap<>();
        Gem ruby = gemFactory.createGem(GemType.RUBY, 17);
        Gem amethyst = gemFactory.createGem(GemType.AMETHYST, 17);
        Gem onyx = gemFactory.createGem(GemType.ONYX, 17);
        List<AbstractGem> rubies = List.of(ruby, ruby, ruby, ruby, ruby, ruby, ruby, ruby, ruby, ruby);
        List<AbstractGem> amethysts = List.of(amethyst, amethyst, amethyst, amethyst, amethyst, amethyst, amethyst, amethyst, amethyst, amethyst);
        List<AbstractGem> onyxes = List.of(onyx, onyx, onyx, onyx, onyx, onyx, onyx, onyx, onyx, onyx);
        items.put(ItemSlot.AMULET, itemFactory.createItem(SetItemType.WINTER_AMULET, CharacterClass.SPELLWEAVER, Map.of(StatType.DAMAGE, 0.0, StatType.MOVEMENT_SPEED, 0.0, StatType.HEALTH_POINTS, 0.0), 145, rubies, List.of()));
        items.put(ItemSlot.CLOAK, itemFactory.createItem(SetItemType.DRAGAN_CLOAK, CharacterClass.SPELLWEAVER, Map.of(StatType.DAMAGE, 0.0, StatType.ATTACK_SPEED, 0.0, StatType.HEALTH_POINTS, 0.0), 145, amethysts, List.of()));
        items.put(ItemSlot.BELT, itemFactory.createItem(SetItemType.DRACO_BELT, CharacterClass.SPELLWEAVER, Map.of(StatType.DAMAGE, 0.0, StatType.RESISTANCE_VALUE, 0.0, StatType.HEALTH_POINTS, 0.0), 145, onyxes, List.of()));
        Assertions.assertDoesNotThrow(() -> new Character(CharacterClass.SPELLWEAVER, MasteryType.NONE, 0, ClassSkillType.NONE, 0, List.of(), List.of(), null, items, Map.of(), null, null, null, null, null, Map.of()));
    }

    @Test
    void equipItem_updateItemGems_throwsIfGemLimitExceeded()
    {
        Map<ItemSlot, Item> items = new HashMap<>();
        Gem ruby = gemFactory.createGem(GemType.RUBY, 17);
        List<AbstractGem> rubies = List.of(ruby, ruby, ruby, ruby, ruby, ruby, ruby, ruby, ruby, ruby);

        items.put(ItemSlot.AMULET, itemFactory.createItem(SetItemType.WINTER_AMULET, CharacterClass.SPELLWEAVER, Map.of(StatType.DAMAGE, 0.0, StatType.MOVEMENT_SPEED, 0.0, StatType.HEALTH_POINTS, 0.0), 145, rubies, List.of()));
        items.put(ItemSlot.CLOAK, itemFactory.createItem(SetItemType.DRAGAN_CLOAK, CharacterClass.SPELLWEAVER, Map.of(StatType.DAMAGE, 0.0, StatType.ATTACK_SPEED, 0.0, StatType.HEALTH_POINTS, 0.0), 145, rubies, List.of()));
        items.put(ItemSlot.BOOTS, itemFactory.createItem(SetItemType.DRACO_BELT, CharacterClass.SPELLWEAVER, Map.of(StatType.DAMAGE, 0.0, StatType.RESISTANCE_VALUE, 0.0, StatType.HEALTH_POINTS, 0.0), 145, rubies, List.of()));
        items.put(ItemSlot.RING1, itemFactory.createItem(SetItemType.BLOOD_RUNE_RING, CharacterClass.SPELLWEAVER, Map.of(StatType.DAMAGE, 0.0, StatType.MOVEMENT_SPEED, 0.0, StatType.HEALTH_POINTS, 0.0), 145, rubies, List.of()));
        items.put(ItemSlot.RING2, itemFactory.createItem(SetItemType.BLOOD_RUNE_RING, CharacterClass.SPELLWEAVER, Map.of(StatType.DAMAGE, 0.0, StatType.MOVEMENT_SPEED, 0.0, StatType.HEALTH_POINTS, 0.0), 145, rubies, List.of()));
        items.put(ItemSlot.GLOVES, itemFactory.createItem(SetItemType.AZAR_GLOVES, CharacterClass.SPELLWEAVER, Map.of(StatType.DAMAGE, 0.0, StatType.ATTACK_SPEED, 0.0, StatType.CRIT_VALUE, 0.0), 145, rubies, List.of()));

        Assertions.assertThrows(LimitExceededException.class, () -> new Character(CharacterClass.SPELLWEAVER, MasteryType.NONE, 0, ClassSkillType.NONE, 0, List.of(), List.of(), null, items, Map.of(), null, null, null, null, null, Map.of()));
    }

    // Runes
    @Test
    void updateRuneTrinket_succeedsIfWithinRuneLimit()
    {
        List<RuneTrinket> runeTrinkets = new ArrayList<>();
        runeTrinkets.add(new RuneTrinket(List.of(runeFactory.createRune(RuneType.VIGOR, 5), runeFactory.createRune(RuneType.VIGOR, 5), runeFactory.createRune(RuneType.VIGOR, 5), runeFactory.createRune(RuneType.VIGOR, 5), runeFactory.createRune(RuneType.VIGOR, 5), runeFactory.createRune(RuneType.VITALITY, 5), runeFactory.createRune(RuneType.VITALITY, 5), runeFactory.createRune(RuneType.VITALITY, 5), runeFactory.createRune(RuneType.VITALITY, 5), runeFactory.createRune(RuneType.VITALITY, 5))));
        runeTrinkets.add(new RuneTrinket(List.of(runeFactory.createRune(RuneType.CELERITY, 5), runeFactory.createRune(RuneType.CELERITY, 5), runeFactory.createRune(RuneType.CELERITY, 5), runeFactory.createRune(RuneType.CELERITY, 5), runeFactory.createRune(RuneType.CELERITY, 5), runeFactory.createRune(RuneType.RESILIENCE, 5), runeFactory.createRune(RuneType.RESILIENCE, 5), runeFactory.createRune(RuneType.RESILIENCE, 5), runeFactory.createRune(RuneType.RESILIENCE, 5), runeFactory.createRune(RuneType.RESILIENCE, 5))));
        runeTrinkets.add(new RuneTrinket(List.of(runeFactory.createRune(RuneType.MATERI_BLESSING, 5), runeFactory.createRune(RuneType.MATERI_BLESSING, 5), runeFactory.createRune(RuneType.MATERI_BLESSING, 5), runeFactory.createRune(RuneType.MATERI_BLESSING, 5), runeFactory.createRune(RuneType.MATERI_BLESSING, 5), runeFactory.createRune(RuneType.WISDOM_SEEKER, 5), runeFactory.createRune(RuneType.WISDOM_SEEKER, 5), runeFactory.createRune(RuneType.WISDOM_SEEKER, 5), runeFactory.createRune(RuneType.WISDOM_SEEKER, 5), runeFactory.createRune(RuneType.WISDOM_SEEKER, 5))));
        Assertions.assertDoesNotThrow(() -> new Character(CharacterClass.SPELLWEAVER, MasteryType.NONE, 0, ClassSkillType.NONE, 0, runeTrinkets, List.of(), new DragonCrestTrinket(List.of()),
                Map.of(), Map.of(), null, null, null, null, null, null));
    }

    @Test
    void updateRuneTrinket_throwsIfRuneLimitExceededOnOneTrinket()
    {
        List<RuneTrinket> runeTrinkets = new ArrayList<>();
        runeTrinkets.add(new RuneTrinket(List.of(runeFactory.createRune(RuneType.RESILIENCE, 5), runeFactory.createRune(RuneType.RESILIENCE, 5), runeFactory.createRune(RuneType.RESILIENCE, 5), runeFactory.createRune(RuneType.RESILIENCE, 5), runeFactory.createRune(RuneType.FIRE_RESILIENCE, 5), runeFactory.createRune(RuneType.FIRE_RESILIENCE, 5), runeFactory.createRune(RuneType.FIRE_RESILIENCE, 5), runeFactory.createRune(RuneType.FIRE_RESILIENCE, 5), runeFactory.createRune(RuneType.ICE_RESILIENCE, 5), runeFactory.createRune(RuneType.ICE_RESILIENCE, 5))));
        Assertions.assertThrows(LimitExceededException.class, () -> new Character(CharacterClass.SPELLWEAVER, MasteryType.NONE, 0, ClassSkillType.NONE, 0, runeTrinkets, List.of(), new DragonCrestTrinket(List.of()),
                Map.of(), Map.of(), null, null, null, null, null, null));
    }


    @Test
    void updateRuneTrinket_throwsIfRuneLimitExceededOnMultipleTrinkets()
    {
        List<RuneTrinket> runeTrinkets = new ArrayList<>();
        runeTrinkets.add(new RuneTrinket(List.of(runeFactory.createRune(RuneType.VIGOR, 5), runeFactory.createRune(RuneType.VIGOR, 5), runeFactory.createRune(RuneType.VIGOR, 5), runeFactory.createRune(RuneType.VIGOR, 5), runeFactory.createRune(RuneType.VIGOR, 5), runeFactory.createRune(RuneType.VIGOR, 5), runeFactory.createRune(RuneType.VIGOR, 5), runeFactory.createRune(RuneType.VIGOR, 5), runeFactory.createRune(RuneType.VIGOR, 5), runeFactory.createRune(RuneType.VIGOR, 5))));
        runeTrinkets.add(new RuneTrinket(List.of(runeFactory.createRune(RuneType.VIGOR, 5), runeFactory.createRune(RuneType.VIGOR, 5), runeFactory.createRune(RuneType.VIGOR, 5), runeFactory.createRune(RuneType.VIGOR, 5), runeFactory.createRune(RuneType.VIGOR, 5), runeFactory.createRune(RuneType.VITALITY, 5), runeFactory.createRune(RuneType.VITALITY, 5), runeFactory.createRune(RuneType.VITALITY, 5), runeFactory.createRune(RuneType.RISING_VIGOR, 6), runeFactory.createRune(RuneType.RISING_POWER, 6))));
        Assertions.assertThrows(LimitExceededException.class, () -> new Character(CharacterClass.SPELLWEAVER, MasteryType.NONE, 0, ClassSkillType.NONE, 0, runeTrinkets, List.of(), new DragonCrestTrinket(List.of()),
                Map.of(), Map.of(), null, null, null, null, null, null));
    }

    // Jewels
    @Test
    void updateJewelTrinket_succeedsIfWithinJewelLimit()
    {
        List<JewelTrinket> jewelTrinkets = new ArrayList<>();
        jewelTrinkets.add(new JewelTrinket(List.of(jewelFactory.createJewel(JewelType.FOCUS,  CharacterClass.SPELLWEAVER, 5), jewelFactory.createJewel(JewelType.FOCUS, CharacterClass.SPELLWEAVER, 5), jewelFactory.createJewel(JewelType.FOCUS, CharacterClass.SPELLWEAVER, 5), jewelFactory.createJewel(JewelType.RAGE, CharacterClass.SPELLWEAVER, 5), jewelFactory.createJewel(JewelType.SCORCHING_RAY, CharacterClass.SPELLWEAVER, 5), jewelFactory.createJewel(JewelType.ETERNAL_SCORN, CharacterClass.SPELLWEAVER, 7), jewelFactory.createJewel(JewelType.ETERNAL_WRATH, CharacterClass.SPELLWEAVER, 5), jewelFactory.createJewel(JewelType.GLACIAL_FANG, CharacterClass.SPELLWEAVER, 5), jewelFactory.createJewel(JewelType.AMBIDEXTROUS_VIGOR, CharacterClass.SPELLWEAVER, 5), jewelFactory.createJewel(JewelType.VITALITY, CharacterClass.SPELLWEAVER, 5))));
        jewelTrinkets.add(new JewelTrinket(List.of(jewelFactory.createJewel(JewelType.FOCUS,  CharacterClass.SPELLWEAVER, 5), jewelFactory.createJewel(JewelType.FOCUS, CharacterClass.SPELLWEAVER, 5), jewelFactory.createJewel(JewelType.INGREDIENT_HUNTER, CharacterClass.SPELLWEAVER, 5), jewelFactory.createJewel(JewelType.INGREDIENT_HUNTER, CharacterClass.SPELLWEAVER, 5), jewelFactory.createJewel(JewelType.INGREDIENT_HUNTER, CharacterClass.SPELLWEAVER, 5), jewelFactory.createJewel(JewelType.GEM_FORTUNE, CharacterClass.SPELLWEAVER, 5), jewelFactory.createJewel(JewelType.CONVERSE, CharacterClass.SPELLWEAVER, 5), jewelFactory.createJewel(JewelType.CONTRIBUTION, CharacterClass.SPELLWEAVER, 5), jewelFactory.createJewel(JewelType.DEXTROUS_VIGOR, CharacterClass.SPELLWEAVER, 5), jewelFactory.createJewel(JewelType.EASTER_FEVER, CharacterClass.SPELLWEAVER, 5))));
        Assertions.assertDoesNotThrow(() -> new Character(CharacterClass.SPELLWEAVER, MasteryType.NONE, 0, ClassSkillType.NONE, 0, List.of(), jewelTrinkets, new DragonCrestTrinket(List.of()),
                Map.of(), Map.of(), null, null, null, null, null, null));
    }

    @Test
    void updateJewelTrinket_throwsIfJewelLimitExceededOnOneTrinket()
    {
        List<JewelTrinket> jewelTrinkets = new ArrayList<>();
        jewelTrinkets.add(new JewelTrinket(List.of(jewelFactory.createJewel(JewelType.FOCUS,  CharacterClass.SPELLWEAVER, 5), jewelFactory.createJewel(JewelType.FOCUS, CharacterClass.SPELLWEAVER, 5), jewelFactory.createJewel(JewelType.RAGE, CharacterClass.SPELLWEAVER, 5), jewelFactory.createJewel(JewelType.RAGE, CharacterClass.SPELLWEAVER, 5), jewelFactory.createJewel(JewelType.SCORCHING_RAY, CharacterClass.SPELLWEAVER, 5), jewelFactory.createJewel(JewelType.ETERNAL_SCORN, CharacterClass.SPELLWEAVER, 7), jewelFactory.createJewel(JewelType.ETERNAL_WRATH, CharacterClass.SPELLWEAVER, 5), jewelFactory.createJewel(JewelType.INGREDIENT_HUNTER, CharacterClass.SPELLWEAVER, 5), jewelFactory.createJewel(JewelType.AMBIDEXTROUS_VIGOR, CharacterClass.SPELLWEAVER, 5), jewelFactory.createJewel(JewelType.VITALITY, CharacterClass.SPELLWEAVER, 5))));
        Assertions.assertThrows(LimitExceededException.class, () -> new Character(CharacterClass.SPELLWEAVER, MasteryType.NONE, 0, ClassSkillType.NONE, 0, List.of(), jewelTrinkets, new DragonCrestTrinket(List.of()),
                Map.of(), Map.of(), null, null, null, null, null, null));
    }

    @Test
    void updateJewelTrinket_throwsIfJewelLimitExceededOnMultipleTrinkets()
    {
        List<JewelTrinket> jewelTrinkets = new ArrayList<>();
        jewelTrinkets.add(new JewelTrinket(List.of(jewelFactory.createJewel(JewelType.FOCUS,  CharacterClass.SPELLWEAVER, 5), jewelFactory.createJewel(JewelType.FOCUS, CharacterClass.SPELLWEAVER, 5), jewelFactory.createJewel(JewelType.FOCUS, CharacterClass.SPELLWEAVER, 5), jewelFactory.createJewel(JewelType.RAGE, CharacterClass.SPELLWEAVER, 5), jewelFactory.createJewel(JewelType.SCORCHING_RAY, CharacterClass.SPELLWEAVER, 5), jewelFactory.createJewel(JewelType.ETERNAL_SCORN, CharacterClass.SPELLWEAVER, 7), jewelFactory.createJewel(JewelType.ETERNAL_WRATH, CharacterClass.SPELLWEAVER, 5), jewelFactory.createJewel(JewelType.INGREDIENT_HUNTER, CharacterClass.SPELLWEAVER, 5), jewelFactory.createJewel(JewelType.AMBIDEXTROUS_VIGOR, CharacterClass.SPELLWEAVER, 5), jewelFactory.createJewel(JewelType.VITALITY, CharacterClass.SPELLWEAVER, 5))));
        jewelTrinkets.add(new JewelTrinket(List.of(jewelFactory.createJewel(JewelType.FOCUS,  CharacterClass.SPELLWEAVER, 5), jewelFactory.createJewel(JewelType.FOCUS, CharacterClass.SPELLWEAVER, 5), jewelFactory.createJewel(JewelType.FOCUS, CharacterClass.SPELLWEAVER, 5), jewelFactory.createJewel(JewelType.INGREDIENT_HUNTER, CharacterClass.SPELLWEAVER, 5), jewelFactory.createJewel(JewelType.INGREDIENT_HUNTER, CharacterClass.SPELLWEAVER, 5), jewelFactory.createJewel(JewelType.GEM_FORTUNE, CharacterClass.SPELLWEAVER, 5), jewelFactory.createJewel(JewelType.CONVERSE, CharacterClass.SPELLWEAVER, 5), jewelFactory.createJewel(JewelType.CONTRIBUTION, CharacterClass.SPELLWEAVER, 5), jewelFactory.createJewel(JewelType.DEXTROUS_VIGOR, CharacterClass.SPELLWEAVER, 5), jewelFactory.createJewel(JewelType.EASTER_FEVER, CharacterClass.SPELLWEAVER, 5))));
        Assertions.assertThrows(LimitExceededException.class, () -> new Character(CharacterClass.SPELLWEAVER, MasteryType.NONE, 0, ClassSkillType.NONE, 0, List.of(), jewelTrinkets, new DragonCrestTrinket(List.of()),
                Map.of(), Map.of(), null, null, null, null, null, null));
    }
}
