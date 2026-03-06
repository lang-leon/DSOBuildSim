package com.langleon.dsobuildsim;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.langleon.dsobuildsim.character.Character;
import com.langleon.dsobuildsim.dragonstones.DragonStone;
import com.langleon.dsobuildsim.dragonstones.DragonStoneConfig;
import com.langleon.dsobuildsim.dragonstones.DragonStoneFactory;
import com.langleon.dsobuildsim.enchantments.Enchantment;
import com.langleon.dsobuildsim.enums.*;
import com.langleon.dsobuildsim.enums.dragonstones.DragonStoneType;
import com.langleon.dsobuildsim.enums.essences.EssenceType;
import com.langleon.dsobuildsim.enums.gems.GemType;
import com.langleon.dsobuildsim.enums.items.MythicItemType;
import com.langleon.dsobuildsim.enums.items.SetItemType;
import com.langleon.dsobuildsim.enums.items.UniqueItemType;
import com.langleon.dsobuildsim.enums.jewels.JewelType;
import com.langleon.dsobuildsim.enums.pets.PetType;
import com.langleon.dsobuildsim.enums.runes.RuneType;
import com.langleon.dsobuildsim.essences.EssenceConfig;
import com.langleon.dsobuildsim.essences.EssenceFactory;
import com.langleon.dsobuildsim.gems.GemConfig;
import com.langleon.dsobuildsim.gems.GemFactory;
import com.langleon.dsobuildsim.items.core.Item;
import com.langleon.dsobuildsim.items.core.ItemFactory;
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

public class Main {
    public static void main(String[] args) throws IOException {
        var reader = new InputStreamReader(Main.class.getResourceAsStream("/data/runes.json"));
        ObjectMapper objectMapper = new ObjectMapper();
        RuneConfig runeConfig = objectMapper.readValue(reader, RuneConfig.class);
        RuneFactory runeFactory = new RuneFactory(runeConfig);
        reader = new InputStreamReader(Main.class.getResourceAsStream("/data/jewels.json"));
        JewelConfig jewelConfig = objectMapper.readValue(reader, JewelConfig.class);
        JewelFactory jewelFactory = new JewelFactory(jewelConfig);
        reader = new InputStreamReader(Main.class.getResourceAsStream("/data/dragonstones.json"));
        DragonStoneConfig dragonStoneConfig = objectMapper.readValue(reader, DragonStoneConfig.class);
        DragonStoneFactory dragonStoneFactory = new DragonStoneFactory(dragonStoneConfig);
        reader = new InputStreamReader(Main.class.getResourceAsStream("/data/mythicitems.json"));
        MythicItemConfig mythicItemConfig = objectMapper.readValue(reader, MythicItemConfig.class);
        reader = new InputStreamReader(Main.class.getResourceAsStream("/data/uniqueitems.json"));
        UniqueItemConfig uniqueItemConfig = objectMapper.readValue(reader, UniqueItemConfig.class);
        reader = new InputStreamReader(Main.class.getResourceAsStream("/data/setitems.json"));
        SetItemConfig setItemConfig = objectMapper.readValue(reader, SetItemConfig.class);
        ItemFactory itemFactory = new ItemFactory(mythicItemConfig, uniqueItemConfig, setItemConfig);
        reader = new InputStreamReader(Main.class.getResourceAsStream("/data/gems.json"));
        GemConfig gemConfig = objectMapper.readValue(reader, GemConfig.class);
        GemFactory gemFactory = new GemFactory(gemConfig);
        reader = new InputStreamReader(Main.class.getResourceAsStream("/data/essences.json"));
        EssenceConfig essenceConfig = objectMapper.readValue(reader, EssenceConfig.class);
        EssenceFactory essenceFactory = new EssenceFactory(essenceConfig);
        reader = new InputStreamReader(Main.class.getResourceAsStream("/data/pets.json"));
        PetConfig petConfig = objectMapper.readValue(reader, PetConfig.class);
        PetFactory petFactory = new PetFactory(petConfig);
        reader = new InputStreamReader(Main.class.getResourceAsStream("/data/sets.json"));
        SetConfig setConfig = objectMapper.readValue(reader, SetConfig.class);
        SetFactory setFactory = new SetFactory(setConfig);

        Character kauka = new Character(CharacterClass.SPELLWEAVER, setFactory);
        kauka.updateRuneTrinket(0, new Rune[]{runeFactory.createRune(RuneType.VIGOR), runeFactory.createRune(RuneType.VIGOR), runeFactory.createRune(RuneType.VIGOR), runeFactory.createRune(RuneType.VIGOR), runeFactory.createRune(RuneType.VIGOR), runeFactory.createRune(RuneType.DEVASTATION), runeFactory.createRune(RuneType.DEVASTATION), runeFactory.createRune(RuneType.DEVASTATION), runeFactory.createRune(RuneType.DEVASTATION), runeFactory.createRune(RuneType.DEVASTATION),});
        kauka.updateRuneTrinket(1, new Rune[]{runeFactory.createRune(RuneType.SPRING), runeFactory.createRune(RuneType.SPRING), runeFactory.createRune(RuneType.SPRING), runeFactory.createRune(RuneType.SPRING), runeFactory.createRune(RuneType.SPRING), runeFactory.createRune(RuneType.SUMMER), runeFactory.createRune(RuneType.SUMMER), runeFactory.createRune(RuneType.SUMMER), runeFactory.createRune(RuneType.SUMMER), runeFactory.createRune(RuneType.SUMMER),});
        kauka.updateRuneTrinket(2, new Rune[]{runeFactory.createRune(RuneType.AUTUMN), runeFactory.createRune(RuneType.AUTUMN), runeFactory.createRune(RuneType.AUTUMN), runeFactory.createRune(RuneType.AUTUMN), runeFactory.createRune(RuneType.AUTUMN), runeFactory.createRune(RuneType.WINTER), runeFactory.createRune(RuneType.WINTER), runeFactory.createRune(RuneType.WINTER), runeFactory.createRune(RuneType.WINTER), runeFactory.createRune(RuneType.WINTER),});
        kauka.updateRuneTrinket(3, new Rune[]{runeFactory.createRune(RuneType.CELERITY), runeFactory.createRune(RuneType.CELERITY), runeFactory.createRune(RuneType.CELERITY), runeFactory.createRune(RuneType.CELERITY), runeFactory.createRune(RuneType.CELERITY), runeFactory.createRune(RuneType.VITALITY), runeFactory.createRune(RuneType.VITALITY), runeFactory.createRune(RuneType.VITALITY), runeFactory.createRune(RuneType.VITALITY), runeFactory.createRune(RuneType.VITALITY),});
        kauka.updateRuneTrinket(4, new Rune[]{runeFactory.createRune(RuneType.PERSISTENCE), runeFactory.createRune(RuneType.PERSISTENCE), runeFactory.createRune(RuneType.PERSISTENCE), runeFactory.createRune(RuneType.PERSISTENCE), runeFactory.createRune(RuneType.PERSISTENCE), runeFactory.createRune(RuneType.ACCELERATION), runeFactory.createRune(RuneType.ACCELERATION), runeFactory.createRune(RuneType.ACCELERATION), runeFactory.createRune(RuneType.ACCELERATION), runeFactory.createRune(RuneType.ACCELERATION),});
        kauka.updateRuneTrinket(5, new Rune[]{runeFactory.createRune(RuneType.HOLY_STAR_SHARD), runeFactory.createRune(RuneType.RISING_VIGOR), runeFactory.createRune(RuneType.FORTITUDE), runeFactory.createRune(RuneType.FORTITUDE), runeFactory.createRune(RuneType.FORTITUDE), runeFactory.createRune(RuneType.ANDERMANT_FEVER), runeFactory.createRune(RuneType.REALM_CHANGER), runeFactory.createRune(RuneType.RESILIENCE), runeFactory.createRune(RuneType.RESILIENCE), runeFactory.createRune(RuneType.RESILIENCE),});

        kauka.updateJewelTrinket(0, new Jewel[]{jewelFactory.createJewel(JewelType.ETERNAL_SCORN, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.GLORY, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.RAGE, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.AMPLIFIED_HEALING, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.FROZEN_HEART, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.GEM_FORTUNE, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.ETERNAL_WRATH, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.INGREDIENT_HUNTER, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.INGREDIENT_HUNTER, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.INGREDIENT_HUNTER, CharacterClass.SPELLWEAVER),});
        kauka.updateJewelTrinket(1, new Jewel[]{jewelFactory.createJewel(JewelType.FOCUS, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.FOCUS, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.FOCUS, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.FOCUS, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.FOCUS, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.VIGOR, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.AMBIDEXTROUS_VIGOR, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.VITALITY, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.ENCOURAGEMENT, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.CONTRIBUTION, CharacterClass.SPELLWEAVER),});
        kauka.updateJewelTrinket(2, new Jewel[]{jewelFactory.createJewel(JewelType.LASTING_HEALTH, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.CONVERSE, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.FIERY_FLOWER, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.STRENUOUSNESS, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.FORTITUDE, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.PROLONGATION, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.REVIVAL_BOON, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.EASTER_FEVER, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.SCORCHING_RAY, CharacterClass.SPELLWEAVER), jewelFactory.createJewel(JewelType.PENT_UP_POWER, CharacterClass.SPELLWEAVER),});

        kauka.updateDragonCrestTrinket(new DragonStone[]{dragonStoneFactory.createDragonStone(DragonStoneType.POWERSTONE, 5), dragonStoneFactory.createDragonStone(DragonStoneType.POWERSTONE, 5), dragonStoneFactory.createDragonStone(DragonStoneType.POWERSTONE, 3), dragonStoneFactory.createDragonStone(DragonStoneType.POWERSTONE, 3), dragonStoneFactory.createDragonStone(DragonStoneType.POWERSTONE, 3), null, null, null, null, null});

        Item amulet = itemFactory.createItem(SetItemType.WINTER_AMULET, CharacterClass.SPELLWEAVER);
        amulet.setEnchants(new Enchantment(EnchantmentType.HEALTH_POINTS));
        amulet.setGems(gemFactory.createGem(GemType.AMETHYST, 17));
        kauka.equipItem(ItemSlot.AMULET, amulet);

        Item cloak = itemFactory.createItem(MythicItemType.ANCESTRAL_GLORY_CLOAK, CharacterClass.SPELLWEAVER);
        cloak.setEnchants(new Enchantment(EnchantmentType.DAMAGE));
        cloak.setGems(gemFactory.createGem(GemType.RUBY, 17));
        kauka.equipItem(ItemSlot.CLOAK, cloak);

        Item belt = itemFactory.createItem(UniqueItemType.BELT_OF_ZEAL, CharacterClass.SPELLWEAVER);
        belt.updateBaseValues(Map.of(StatType.DAMAGE, 1630.885, StatType.HEALTH_POINTS, 20072.654, StatType.RESISTANCE_VALUE, 1679.873));
        belt.setEnchants(new Enchantment(EnchantmentType.DAMAGE));
        belt.setGems(gemFactory.createGem(GemType.RUBY, 17));
        kauka.equipItem(ItemSlot.BELT, belt);

        Item ring1 = itemFactory.createItem(MythicItemType.ANCESTRAL_GLORY_RING, CharacterClass.SPELLWEAVER);
        ring1.setEnchants(new Enchantment(EnchantmentType.HEALTH_POINTS));
        ring1.setGems(gemFactory.createGem(GemType.AMETHYST, 17));
        kauka.equipItem(ItemSlot.RING1, ring1);

        Item ring2 = itemFactory.createItem(MythicItemType.ANCESTRAL_GLORY_RING, CharacterClass.SPELLWEAVER);
        ring2.setEnchants(new Enchantment(EnchantmentType.DAMAGE));
        ring2.setGems(gemFactory.createOpal(GemType.ONYX, GemType.RUBY, GemType.EMERALD, 17));
        kauka.equipItem(ItemSlot.RING2, ring2);

        Item helmet = itemFactory.createItem(SetItemType.STELLAR_WALKER_HELMET, CharacterClass.SPELLWEAVER);
        helmet.updateBaseValues(Map.of(StatType.DAMAGE, 1426.117, StatType.CRIT_VALUE, 1298.723, StatType.HEALTH_POINTS, 19630.458));
        helmet.setEnchants(new Enchantment(EnchantmentType.HEALTH_POINTS));
        helmet.setGems(gemFactory.createGem(GemType.AMETHYST, 17));
        kauka.equipItem(ItemSlot.HELMET, helmet);

        Item shoulders = itemFactory.createItem(SetItemType.STELLAR_WALKER_SHOULDERS, CharacterClass.SPELLWEAVER);
        shoulders.updateBaseValues(Map.of(StatType.DAMAGE, 1639.564, StatType.CRIT_VALUE, 1361.727, StatType.HEALTH_POINTS, 15625.218));
        shoulders.setEnchants(new Enchantment(EnchantmentType.BLOCK_VALUE));
        shoulders.setGems(gemFactory.createGem(GemType.EMERALD, 17));
        kauka.equipItem(ItemSlot.SHOULDERS, shoulders);

        Item torso = itemFactory.createItem(SetItemType.WINTER_TORSO, CharacterClass.SPELLWEAVER);
        torso.setEnchants(new Enchantment(EnchantmentType.BLOCK_VALUE));
        torso.setGems(gemFactory.createGem(GemType.EMERALD, 17));
        kauka.equipItem(ItemSlot.TORSO, torso);

        Item gloves = itemFactory.createItem(SetItemType.WINTER_GLOVES, CharacterClass.SPELLWEAVER);
        gloves.setEnchants(new Enchantment(EnchantmentType.CRIT_VALUE));
        gloves.setGems(gemFactory.createGem(GemType.ONYX, 17));
        kauka.equipItem(ItemSlot.GLOVES, gloves);

        Item boots = itemFactory.createItem(SetItemType.WINTER_BOOTS, CharacterClass.SPELLWEAVER);
        boots.setEnchant(new Enchantment(EnchantmentType.MOVEMENT_SPEED), 0);
        boots.setEnchant(new Enchantment(EnchantmentType.MOVEMENT_SPEED), 1);
        boots.setEnchant(new Enchantment(EnchantmentType.DAMAGE), 2);
        boots.setEnchant(new Enchantment(EnchantmentType.DAMAGE), 3);
        boots.setGems(gemFactory.createGem(GemType.ONYX, 17));
        boots.setGem(gemFactory.createGem(GemType.RHODOLITE, 17), 0);
        boots.setGem(gemFactory.createGem(GemType.EMERALD, 17), 9);
        kauka.equipItem(ItemSlot.BOOTS, boots);

        Item adornment = itemFactory.createItem(UniqueItemType.SIGRISMARRS_ADORNMENT, CharacterClass.SPELLWEAVER);
        adornment.updateBaseValues(Map.of(StatType.DAMAGE, 1870.52, StatType.CRIT_VALUE, 2100.146));
        adornment.setEnchants(new Enchantment(EnchantmentType.DAMAGE));
        adornment.setGems(gemFactory.createGem(GemType.RUBY, 17));
        kauka.equipItem(ItemSlot.WEAPON_ADORNMENT, adornment);

        Item twohand = itemFactory.createItem(UniqueItemType.ANNIVERSARY_TWO_HAND_UPGRADED, CharacterClass.SPELLWEAVER);
        twohand.setEnchants(new Enchantment(EnchantmentType.DAMAGE));
        twohand.setGems(gemFactory.createGem(GemType.RUBY, 17));
        kauka.equipItem(ItemSlot.TWO_HAND_WEAPON, twohand);

        kauka.setEssence(essenceFactory.createEssence(EssenceType.VIGOR, 3));

        kauka.setPet(petFactory.createPet(PetType.THE_SOUL_OF_DRAGAN_DOLL));

        WisdomSkillTree wisdomSkillTree = new WisdomSkillTree();;
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
        kauka.setWisdomSkillTree(wisdomSkillTree);

        kauka.setCollectorBagBuffs(Map.of(StatType.RESISTANCE_VALUE, 0.15, StatType.BLOCK_VALUE, 0.02, StatType.DAMAGE, 0.06, StatType.HEALTH_POINTS, 0.33));

        printStats(kauka.calculateCharacterStats());
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