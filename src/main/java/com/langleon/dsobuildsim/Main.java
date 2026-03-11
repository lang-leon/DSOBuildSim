package com.langleon.dsobuildsim;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.langleon.dsobuildsim.character.Character;
import com.langleon.dsobuildsim.character.CharacterClass;
import com.langleon.dsobuildsim.character.MasteryType;
import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.dragonstones.DragonStone;
import com.langleon.dsobuildsim.dragonstones.DragonStoneConfig;
import com.langleon.dsobuildsim.dragonstones.DragonStoneFactory;
import com.langleon.dsobuildsim.enchantments.Enchantment;
import com.langleon.dsobuildsim.dragonstones.DragonStoneType;
import com.langleon.dsobuildsim.enchantments.EnchantmentConfig;
import com.langleon.dsobuildsim.enchantments.EnchantmentDefinition;
import com.langleon.dsobuildsim.essences.EssenceType;
import com.langleon.dsobuildsim.gems.AbstractGem;
import com.langleon.dsobuildsim.gems.enums.GemType;
import com.langleon.dsobuildsim.items.core.enums.ItemSlot;
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

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException {
        var reader = new InputStreamReader(Objects.requireNonNull(Main.class.getResourceAsStream("/data/runes.json")));
        ObjectMapper objectMapper = new ObjectMapper();
        RuneConfig runeConfig = objectMapper.readValue(reader, RuneConfig.class);
        RuneFactory runeFactory = new RuneFactory(runeConfig);
        reader = new InputStreamReader(Objects.requireNonNull(Main.class.getResourceAsStream("/data/jewels.json")));
        JewelConfig jewelConfig = objectMapper.readValue(reader, JewelConfig.class);
        JewelFactory jewelFactory = new JewelFactory(jewelConfig);
        reader = new InputStreamReader(Objects.requireNonNull(Main.class.getResourceAsStream("/data/dragonstones.json")));
        DragonStoneConfig dragonStoneConfig = objectMapper.readValue(reader, DragonStoneConfig.class);
        DragonStoneFactory dragonStoneFactory = new DragonStoneFactory(dragonStoneConfig);
        reader = new InputStreamReader(Objects.requireNonNull(Main.class.getResourceAsStream("/data/mythicitems.json")));
        MythicItemConfig mythicItemConfig = objectMapper.readValue(reader, MythicItemConfig.class);
        reader = new InputStreamReader(Objects.requireNonNull(Main.class.getResourceAsStream("/data/uniqueitems.json")));
        UniqueItemConfig uniqueItemConfig = objectMapper.readValue(reader, UniqueItemConfig.class);
        reader = new InputStreamReader(Objects.requireNonNull(Main.class.getResourceAsStream("/data/setitems.json")));
        SetItemConfig setItemConfig = objectMapper.readValue(reader, SetItemConfig.class);
        reader = new InputStreamReader(Objects.requireNonNull(Main.class.getResourceAsStream("/data/levelMultiplierTable.json")));
        LevelMultiplierTable levelMultiplierTable = objectMapper.readValue(reader, LevelMultiplierTable.class);
        ItemFactory itemFactory = new ItemFactory(mythicItemConfig, uniqueItemConfig, setItemConfig, levelMultiplierTable);
        reader = new InputStreamReader(Objects.requireNonNull(Main.class.getResourceAsStream("/data/gems.json")));
        GemConfig gemConfig = objectMapper.readValue(reader, GemConfig.class);
        GemFactory gemFactory = new GemFactory(gemConfig);
        reader = new InputStreamReader(Objects.requireNonNull(Main.class.getResourceAsStream("/data/essences.json")));
        EssenceConfig essenceConfig = objectMapper.readValue(reader, EssenceConfig.class);
        EssenceFactory essenceFactory = new EssenceFactory(essenceConfig);
        reader = new InputStreamReader(Objects.requireNonNull(Main.class.getResourceAsStream("/data/pets.json")));
        PetConfig petConfig = objectMapper.readValue(reader, PetConfig.class);
        PetFactory petFactory = new PetFactory(petConfig);
        reader = new InputStreamReader(Objects.requireNonNull(Main.class.getResourceAsStream("/data/sets.json")));
        SetConfig setConfig = objectMapper.readValue(reader, SetConfig.class);
        SetFactory setFactory = new SetFactory(setConfig);
        reader = new InputStreamReader(Objects.requireNonNull(Main.class.getResourceAsStream("/data/enchantments.json")));
        EnchantmentConfig enchantmentConfig = objectMapper.readValue(reader, EnchantmentConfig.class);

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

        Item amulet = itemFactory.createItem(SetItemType.WINTER_AMULET, CharacterClass.SPELLWEAVER);
        amulet.setEnchants(new Enchantment(enchantDefHP.statType(), enchantDefHP.value()));
        character.equipItem(ItemSlot.AMULET, amulet);
        character.updateItemGems(ItemSlot.AMULET, new AbstractGem[]{gemFactory.createGem(GemType.AMETHYST, 17), gemFactory.createGem(GemType.AMETHYST, 17), gemFactory.createGem(GemType.AMETHYST, 17), gemFactory.createGem(GemType.AMETHYST, 17), gemFactory.createGem(GemType.AMETHYST, 17),gemFactory.createGem(GemType.AMETHYST, 17), gemFactory.createGem(GemType.AMETHYST, 17), gemFactory.createGem(GemType.AMETHYST, 17), gemFactory.createGem(GemType.AMETHYST, 17), gemFactory.createGem(GemType.AMETHYST, 17)});

        Item cloak = itemFactory.createItem(MythicItemType.ANCESTRAL_GLORY_CLOAK, CharacterClass.SPELLWEAVER);
        cloak.setEnchants(new Enchantment(enchantDefDMG.statType(), enchantDefDMG.value()));
        character.equipItem(ItemSlot.CLOAK, cloak);
        character.updateItemGems(ItemSlot.CLOAK, new AbstractGem[]{gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17),gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17)});

        Item belt = itemFactory.createItem(UniqueItemType.BELT_OF_ZEAL, CharacterClass.SPELLWEAVER);
        belt.updateBaseValues(Map.of(StatType.DAMAGE, 1630.885, StatType.HEALTH_POINTS, 20072.654, StatType.RESISTANCE_VALUE, 1679.873));
        belt.setEnchants(new Enchantment(enchantDefDMG.statType(), enchantDefDMG.value()));
        character.equipItem(ItemSlot.BELT, belt);
        character.updateItemGems(ItemSlot.BELT, new AbstractGem[]{gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17),gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17)});

        Item ring1 = itemFactory.createItem(MythicItemType.ANCESTRAL_GLORY_RING, CharacterClass.SPELLWEAVER);
        ring1.setEnchants(new Enchantment(enchantDefHP.statType(), enchantDefHP.value()));
        character.equipItem(ItemSlot.RING1, ring1);
        character.updateItemGems(ItemSlot.RING1, new AbstractGem[]{gemFactory.createGem(GemType.AMETHYST, 17), gemFactory.createGem(GemType.AMETHYST, 17), gemFactory.createGem(GemType.AMETHYST, 17), gemFactory.createGem(GemType.AMETHYST, 17), gemFactory.createGem(GemType.AMETHYST, 17),gemFactory.createGem(GemType.AMETHYST, 17), gemFactory.createGem(GemType.AMETHYST, 17), gemFactory.createGem(GemType.AMETHYST, 17), gemFactory.createGem(GemType.AMETHYST, 17), gemFactory.createGem(GemType.AMETHYST, 17)});

        Item ring2 = itemFactory.createItem(MythicItemType.ANCESTRAL_GLORY_RING, CharacterClass.SPELLWEAVER);
        ring2.setEnchants(new Enchantment(enchantDefDMG.statType(), enchantDefDMG.value()));
        character.equipItem(ItemSlot.RING2, ring2);
        character.updateItemGems(ItemSlot.RING2, new AbstractGem[]{gemFactory.createOpal(GemType.ONYX, GemType.RUBY, GemType.EMERALD, 17), gemFactory.createOpal(GemType.ONYX, GemType.RUBY, GemType.EMERALD, 17), gemFactory.createOpal(GemType.ONYX, GemType.RUBY, GemType.EMERALD, 17), gemFactory.createOpal(GemType.ONYX, GemType.RUBY, GemType.EMERALD, 17), gemFactory.createOpal(GemType.ONYX, GemType.RUBY, GemType.EMERALD, 17), gemFactory.createOpal(GemType.ONYX, GemType.RUBY, GemType.EMERALD, 17), gemFactory.createOpal(GemType.ONYX, GemType.RUBY, GemType.EMERALD, 17), gemFactory.createOpal(GemType.ONYX, GemType.RUBY, GemType.EMERALD, 17), gemFactory.createOpal(GemType.ONYX, GemType.RUBY, GemType.EMERALD, 17), gemFactory.createOpal(GemType.ONYX, GemType.RUBY, GemType.EMERALD, 17)});

        Item helmet = itemFactory.createItem(SetItemType.STELLAR_WALKER_HELMET, CharacterClass.SPELLWEAVER);
        helmet.updateBaseValues(Map.of(StatType.DAMAGE, 1426.117, StatType.CRIT_VALUE, 1298.723, StatType.HEALTH_POINTS, 19630.458));
        helmet.setEnchants(new Enchantment(enchantDefHP.statType(), enchantDefHP.value()));
        character.equipItem(ItemSlot.HELMET, helmet);
        character.updateItemGems(ItemSlot.HELMET, new AbstractGem[]{gemFactory.createGem(GemType.AMETHYST, 17), gemFactory.createGem(GemType.AMETHYST, 17), gemFactory.createGem(GemType.AMETHYST, 17), gemFactory.createGem(GemType.AMETHYST, 17), gemFactory.createGem(GemType.AMETHYST, 17),gemFactory.createGem(GemType.AMETHYST, 17), gemFactory.createGem(GemType.AMETHYST, 17), gemFactory.createGem(GemType.AMETHYST, 17), gemFactory.createGem(GemType.AMETHYST, 17), gemFactory.createGem(GemType.AMETHYST, 17)});

        Item shoulders = itemFactory.createItem(SetItemType.STELLAR_WALKER_SHOULDERS, CharacterClass.SPELLWEAVER);
        shoulders.updateBaseValues(Map.of(StatType.DAMAGE, 1639.564, StatType.CRIT_VALUE, 1361.727, StatType.HEALTH_POINTS, 15625.218));
        shoulders.setEnchants(new Enchantment(enchantDefBlock.statType(), enchantDefBlock.value()));
        character.equipItem(ItemSlot.SHOULDERS, shoulders);
        character.updateItemGems(ItemSlot.SHOULDERS, new AbstractGem[]{gemFactory.createGem(GemType.EMERALD, 17), gemFactory.createGem(GemType.EMERALD, 17), gemFactory.createGem(GemType.EMERALD, 17), gemFactory.createGem(GemType.EMERALD, 17), gemFactory.createGem(GemType.EMERALD, 17),gemFactory.createGem(GemType.EMERALD, 17), gemFactory.createGem(GemType.EMERALD, 17), gemFactory.createGem(GemType.EMERALD, 17), gemFactory.createGem(GemType.EMERALD, 17), gemFactory.createGem(GemType.EMERALD, 17)});

        Item torso = itemFactory.createItem(SetItemType.WINTER_TORSO, CharacterClass.SPELLWEAVER);
        torso.setEnchants(new Enchantment(enchantDefBlock.statType(), enchantDefBlock.value()));
        character.equipItem(ItemSlot.TORSO, torso);
        character.updateItemGems(ItemSlot.TORSO, new AbstractGem[]{gemFactory.createGem(GemType.EMERALD, 17), gemFactory.createGem(GemType.EMERALD, 17), gemFactory.createGem(GemType.EMERALD, 17), gemFactory.createGem(GemType.EMERALD, 17), gemFactory.createGem(GemType.EMERALD, 17),gemFactory.createGem(GemType.EMERALD, 17), gemFactory.createGem(GemType.EMERALD, 17), gemFactory.createGem(GemType.EMERALD, 17), gemFactory.createGem(GemType.EMERALD, 17), gemFactory.createGem(GemType.EMERALD, 17)});

        Item gloves = itemFactory.createItem(SetItemType.WINTER_GLOVES, CharacterClass.SPELLWEAVER);
        gloves.setEnchants(new Enchantment(enchantDefCrit.statType(), enchantDefCrit.value()));
        character.equipItem(ItemSlot.GLOVES, gloves);
        character.updateItemGems(ItemSlot.GLOVES, new AbstractGem[]{gemFactory.createGem(GemType.ONYX, 17), gemFactory.createGem(GemType.ONYX, 17), gemFactory.createGem(GemType.ONYX, 17), gemFactory.createGem(GemType.ONYX, 17), gemFactory.createGem(GemType.ONYX, 17),gemFactory.createGem(GemType.ONYX, 17), gemFactory.createGem(GemType.ONYX, 17), gemFactory.createGem(GemType.ONYX, 17), gemFactory.createGem(GemType.ONYX, 17), gemFactory.createGem(GemType.ONYX, 17)});

        Item boots = itemFactory.createItem(SetItemType.WINTER_BOOTS, CharacterClass.SPELLWEAVER);
        boots.setEnchant(new Enchantment(enchantDefMS.statType(), enchantDefMS.value()), 0);
        boots.setEnchant(new Enchantment(enchantDefMS.statType(), enchantDefMS.value()), 1);
        boots.setEnchant(new Enchantment(enchantDefDMG.statType(), enchantDefDMG.value()), 2);
        boots.setEnchant(new Enchantment(enchantDefDMG.statType(), enchantDefDMG.value()), 3);
        character.equipItem(ItemSlot.BOOTS, boots);
        character.updateItemGems(ItemSlot.BOOTS, new AbstractGem[]{gemFactory.createGem(GemType.RHODOLITE, 17), gemFactory.createGem(GemType.EMERALD, 17), gemFactory.createGem(GemType.ONYX, 17), gemFactory.createGem(GemType.ONYX, 17), gemFactory.createGem(GemType.ONYX, 17),gemFactory.createGem(GemType.ONYX, 17), gemFactory.createGem(GemType.ONYX, 17), gemFactory.createGem(GemType.ONYX, 17), gemFactory.createGem(GemType.ONYX, 17), gemFactory.createGem(GemType.ONYX, 17)});

        Item adornment = itemFactory.createItem(UniqueItemType.SIGRISMARRS_ADORNMENT, CharacterClass.SPELLWEAVER);
        adornment.updateBaseValues(Map.of(StatType.DAMAGE, 1870.52, StatType.CRIT_VALUE, 2100.146));
        adornment.setEnchants(new Enchantment(enchantDefDMG.statType(), enchantDefDMG.value()));
        character.equipItem(ItemSlot.WEAPON_ADORNMENT, adornment);
        character.updateItemGems(ItemSlot.WEAPON_ADORNMENT, new AbstractGem[]{gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17),gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17), gemFactory.createGem(GemType.RUBY, 17)});

        Item twohand = itemFactory.createItem(UniqueItemType.ANNIVERSARY_TWO_HAND_UPGRADED, CharacterClass.SPELLWEAVER);
        twohand.setEnchants(new Enchantment(enchantDefDMG.statType(), enchantDefDMG.value()));
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
        character.setCollectorBagBuffs(Map.of(StatType.RESISTANCE_VALUE, 0.15, StatType.BLOCK_VALUE, 0.02, StatType.DAMAGE, 0.06, StatType.HEALTH_POINTS, 0.33));

        printStats(character.calculateCharacterStats());
    }

    public static void printStats(Map<StatType, Double> stats)
    {
        System.out.println("Character:");
        System.out.printf("%s: %.3f%n", StatType.DAMAGE, stats.get(StatType.DAMAGE));
        System.out.printf("%s: %.3f%n", StatType.ATTACK_SPEED, stats.get(StatType.ATTACK_SPEED));
        System.out.printf("%s: %.3f%n", StatType.CRIT_VALUE, stats.get(StatType.CRIT_VALUE));
        System.out.printf("%s: %.3f%n", StatType.MANA, stats.get(StatType.MANA));
        System.out.printf("%s: %.3f%n", StatType.MANA_PER_SECOND, stats.get(StatType.MANA_PER_SECOND));
        System.out.printf("%s: %.3f%n", StatType.MOVEMENT_SPEED, stats.get(StatType.MOVEMENT_SPEED));
        System.out.printf("%s: %.3f%n", StatType.HEALTH_POINTS, stats.get(StatType.HEALTH_POINTS));
        System.out.printf("%s: %.3f%n", StatType.HEALTH_PER_SECOND, stats.get(StatType.HEALTH_PER_SECOND));
        System.out.printf("%s: %.3f%n", StatType.BLOCK_VALUE, stats.get(StatType.BLOCK_VALUE));
        System.out.printf("%s: %.3f%n", StatType.ARMOR_VALUE, stats.get(StatType.ARMOR_VALUE));
        System.out.printf("%s: %.3f%n", StatType.FIRE_RESISTANCE, stats.get(StatType.FIRE_RESISTANCE));
        System.out.printf("%s: %.3f%n", StatType.ICE_RESISTANCE, stats.get(StatType.ICE_RESISTANCE));
        System.out.printf("%s: %.3f%n", StatType.LIGHTNING_RESISTANCE, stats.get(StatType.LIGHTNING_RESISTANCE));
        System.out.printf("%s: %.3f%n", StatType.ANDERMAGIC_RESISTANCE, stats.get(StatType.ANDERMAGIC_RESISTANCE));
        System.out.printf("%s: %.3f%n", StatType.POISON_RESISTANCE, stats.get(StatType.POISON_RESISTANCE));
    }
}