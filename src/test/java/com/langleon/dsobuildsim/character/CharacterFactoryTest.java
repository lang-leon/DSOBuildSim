package com.langleon.dsobuildsim.character;

import com.langleon.dsobuildsim.buffs.BuffFactory;
import com.langleon.dsobuildsim.character.dto.CharacterDTO;
import com.langleon.dsobuildsim.collectorbagbonus.CollectorBagFactory;
import com.langleon.dsobuildsim.collectorbagbonus.dto.instance.CollectorBagCategoryBonusInstanceDTO;
import com.langleon.dsobuildsim.collectorbagbonus.enums.CollectorBagCategory;
import com.langleon.dsobuildsim.collectorbagbonus.enums.CollectorBagTier;
import com.langleon.dsobuildsim.dragonstones.*;
import com.langleon.dsobuildsim.dragonstones.dto.DragonCrestTrinketDTO;
import com.langleon.dsobuildsim.dragonstones.dto.DragonStoneInstanceDTO;
import com.langleon.dsobuildsim.enchantments.dto.EnchantmentDTO;
import com.langleon.dsobuildsim.essences.dto.EssenceInstanceDTO;
import com.langleon.dsobuildsim.gamedata.GameDataConfig;
import com.langleon.dsobuildsim.gamedata.GameDataLoader;
import com.langleon.dsobuildsim.gems.dto.AbstractGemInstanceDTO;
import com.langleon.dsobuildsim.gems.dto.GemInstanceDTO;
import com.langleon.dsobuildsim.gems.dto.OpalInstanceDTO;
import com.langleon.dsobuildsim.items.core.ItemResolver;
import com.langleon.dsobuildsim.items.core.enums.ItemCategory;
import com.langleon.dsobuildsim.items.dto.ItemInstanceDTO;
import com.langleon.dsobuildsim.jewels.*;
import com.langleon.dsobuildsim.jewels.dto.JewelInstanceDTO;
import com.langleon.dsobuildsim.jewels.dto.JewelTrinketDTO;
import com.langleon.dsobuildsim.pets.dto.PetInstanceDTO;
import com.langleon.dsobuildsim.runes.dto.RuneInstanceDTO;
import com.langleon.dsobuildsim.runes.dto.RuneTrinketDTO;
import com.langleon.dsobuildsim.wisdomskilltree.WisdomSkillTreeFactory;
import com.langleon.dsobuildsim.wisdomskilltree.WisdomSkillTreeResolver;
import com.langleon.dsobuildsim.wisdomskilltree.dto.instance.WisdomGroupInstanceDTO;
import com.langleon.dsobuildsim.wisdomskilltree.dto.instance.WisdomSkillInstanceDTO;
import com.langleon.dsobuildsim.wisdomskilltree.dto.instance.WisdomSkillTreeInstanceDTO;
import com.langleon.dsobuildsim.wisdomskilltree.wisdomgroup.WisdomGroupType;
import com.langleon.dsobuildsim.wisdomskilltree.wisdomskill.WisdomSkillType;
import com.langleon.dsobuildsim.items.core.enums.ItemSlot;
import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.essences.EssenceType;
import com.langleon.dsobuildsim.gems.enums.GemType;
import com.langleon.dsobuildsim.items.mythicitems.MythicItemType;
import com.langleon.dsobuildsim.items.setitems.SetItemType;
import com.langleon.dsobuildsim.items.uniqueitems.UniqueItemType;
import com.langleon.dsobuildsim.pets.enums.PetType;
import com.langleon.dsobuildsim.runes.enums.RuneType;
import com.langleon.dsobuildsim.essences.EssenceFactory;
import com.langleon.dsobuildsim.gems.GemFactory;
import com.langleon.dsobuildsim.items.core.ItemFactory;
import com.langleon.dsobuildsim.pets.PetFactory;
import com.langleon.dsobuildsim.runes.RuneFactory;
import com.langleon.dsobuildsim.sets.SetFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class CharacterFactoryTest {

    private CharacterFactory characterFactory;

    @BeforeEach
    void setup()
    {
        GameDataConfig config = new GameDataLoader().loadGameDataConfig();
        RuneFactory runeFactory = new RuneFactory(config);
        JewelFactory jewelFactory = new JewelFactory(config);
        DragonStoneFactory dragonStoneFactory = new DragonStoneFactory(config);
        ItemResolver itemResolver = new ItemResolver(new ItemFactory(config), new GemFactory(config));
        SetFactory setFactory = new SetFactory(config);
        PetFactory petFactory = new PetFactory(config);
        EssenceFactory essenceFactory = new EssenceFactory(config);
        BuffFactory buffFactory = new BuffFactory(config);
        WisdomSkillTreeResolver wisdomSkillTreeResolver = new WisdomSkillTreeResolver(new WisdomSkillTreeFactory(config));
        CollectorBagFactory collectorBagFactory = new CollectorBagFactory(config);
        characterFactory = new CharacterFactory(runeFactory, jewelFactory, dragonStoneFactory, itemResolver, setFactory, petFactory, essenceFactory, buffFactory, wisdomSkillTreeResolver, collectorBagFactory);
    }

    @Test
    void createCharacterAndCalculateStats()
    {
        CharacterDTO characterDTO = createCharacter();
        Character character = characterFactory.fromDTO(characterDTO);
        Map<StatType, Double> stats = character.calculateCharacterStats();
        Assertions.assertEquals(1336439.430, stats.get(StatType.DAMAGE), 0.001);
        Assertions.assertEquals(4.456, stats.get(StatType.ATTACK_SPEED), 0.001);
        Assertions.assertEquals(401796.790, stats.get(StatType.CRIT_VALUE), 0.001);
        Assertions.assertEquals(100.000, stats.get(StatType.MANA), 0.001);
        Assertions.assertEquals(12.000, stats.get(StatType.MANA_PER_SECOND), 0.001);
        Assertions.assertEquals(13.132, stats.get(StatType.MOVEMENT_SPEED), 0.001);
        Assertions.assertEquals(2958326.630, stats.get(StatType.HEALTH_POINTS), 0.001);
        Assertions.assertEquals(9900.000, stats.get(StatType.HEALTH_PER_SECOND), 0.001);
        Assertions.assertEquals(319956.940, stats.get(StatType.BLOCK_VALUE), 0.001);
        Assertions.assertEquals(48945.961, stats.get(StatType.ARMOR_VALUE), 0.001);
        Assertions.assertEquals(53288.803, stats.get(StatType.FIRE_RESISTANCE), 0.001);
        Assertions.assertEquals(93685.153, stats.get(StatType.ICE_RESISTANCE), 0.001);
        Assertions.assertEquals(53288.803, stats.get(StatType.LIGHTNING_RESISTANCE), 0.001);
        Assertions.assertEquals(73090.515, stats.get(StatType.ANDERMAGIC_RESISTANCE), 0.001);
        Assertions.assertEquals(53288.803, stats.get(StatType.POISON_RESISTANCE), 0.001);
    }

    private CharacterDTO createCharacter()
    {
        List<RuneTrinketDTO> runeTrinkets = new ArrayList<>();
        runeTrinkets.add(new RuneTrinketDTO(List.of(new RuneInstanceDTO(RuneType.VIGOR, 5), new RuneInstanceDTO(RuneType.VIGOR, 5), new RuneInstanceDTO(RuneType.VIGOR, 5), new RuneInstanceDTO(RuneType.VIGOR, 5), new RuneInstanceDTO(RuneType.VIGOR, 5), new RuneInstanceDTO(RuneType.DEVASTATION, 5), new RuneInstanceDTO(RuneType.DEVASTATION, 5), new RuneInstanceDTO(RuneType.DEVASTATION, 5), new RuneInstanceDTO(RuneType.DEVASTATION, 5), new RuneInstanceDTO(RuneType.DEVASTATION, 5))));
        runeTrinkets.add(new RuneTrinketDTO(List.of(new RuneInstanceDTO(RuneType.SPRING, 5), new RuneInstanceDTO(RuneType.SPRING, 5), new RuneInstanceDTO(RuneType.SPRING, 5), new RuneInstanceDTO(RuneType.SPRING, 5), new RuneInstanceDTO(RuneType.SPRING, 5), new RuneInstanceDTO(RuneType.SUMMER, 5), new RuneInstanceDTO(RuneType.SUMMER, 5), new RuneInstanceDTO(RuneType.SUMMER, 5), new RuneInstanceDTO(RuneType.SUMMER, 5), new RuneInstanceDTO(RuneType.SUMMER, 5))));
        runeTrinkets.add(new RuneTrinketDTO(List.of(new RuneInstanceDTO(RuneType.AUTUMN, 5), new RuneInstanceDTO(RuneType.AUTUMN, 5), new RuneInstanceDTO(RuneType.AUTUMN, 5), new RuneInstanceDTO(RuneType.AUTUMN, 5), new RuneInstanceDTO(RuneType.AUTUMN, 5), new RuneInstanceDTO(RuneType.WINTER, 5), new RuneInstanceDTO(RuneType.WINTER, 5), new RuneInstanceDTO(RuneType.WINTER, 5), new RuneInstanceDTO(RuneType.WINTER, 5), new RuneInstanceDTO(RuneType.WINTER, 5))));
        runeTrinkets.add(new RuneTrinketDTO(List.of(new RuneInstanceDTO(RuneType.CELERITY, 5), new RuneInstanceDTO(RuneType.CELERITY, 5), new RuneInstanceDTO(RuneType.CELERITY, 5), new RuneInstanceDTO(RuneType.CELERITY, 5), new RuneInstanceDTO(RuneType.CELERITY, 5), new RuneInstanceDTO(RuneType.VITALITY, 5), new RuneInstanceDTO(RuneType.VITALITY, 5), new RuneInstanceDTO(RuneType.VITALITY, 5), new RuneInstanceDTO(RuneType.VITALITY, 5), new RuneInstanceDTO(RuneType.VITALITY, 5))));
        runeTrinkets.add(new RuneTrinketDTO(List.of(new RuneInstanceDTO(RuneType.PERSISTENCE, 5), new RuneInstanceDTO(RuneType.PERSISTENCE, 5), new RuneInstanceDTO(RuneType.PERSISTENCE, 5), new RuneInstanceDTO(RuneType.PERSISTENCE, 5), new RuneInstanceDTO(RuneType.PERSISTENCE, 5), new RuneInstanceDTO(RuneType.ACCELERATION, 5), new RuneInstanceDTO(RuneType.ACCELERATION, 5), new RuneInstanceDTO(RuneType.ACCELERATION, 5), new RuneInstanceDTO(RuneType.ACCELERATION, 5), new RuneInstanceDTO(RuneType.ACCELERATION, 5))));
        runeTrinkets.add(new RuneTrinketDTO(List.of(new RuneInstanceDTO(RuneType.FORTITUDE, 5), new RuneInstanceDTO(RuneType.FORTITUDE, 5), new RuneInstanceDTO(RuneType.FORTITUDE, 5), new RuneInstanceDTO(RuneType.FORTITUDE, 5), new RuneInstanceDTO(RuneType.FORTITUDE, 5), new RuneInstanceDTO(RuneType.RESILIENCE, 5), new RuneInstanceDTO(RuneType.RESILIENCE, 5), new RuneInstanceDTO(RuneType.RESILIENCE, 5), new RuneInstanceDTO(RuneType.RESILIENCE, 5), new RuneInstanceDTO(RuneType.RESILIENCE, 5))));
        runeTrinkets.add(new RuneTrinketDTO(List.of(new RuneInstanceDTO(RuneType.HOLY_STAR_SHARD, 7), new RuneInstanceDTO(RuneType.RISING_VIGOR, 6), new RuneInstanceDTO(RuneType.ANDERMANT_FEVER, 5), new RuneInstanceDTO(RuneType.REALM_CHANGER, 5), new RuneInstanceDTO(RuneType.ANXIETY_KEEPER, 5), new RuneInstanceDTO(RuneType.MATERI_BLESSING, 5), new RuneInstanceDTO(RuneType.MATERI_BLESSING, 5), new RuneInstanceDTO(RuneType.MATERI_BLESSING, 5), new RuneInstanceDTO(RuneType.MATERI_BLESSING, 5), new RuneInstanceDTO(RuneType.MATERI_BLESSING, 5))));


        List<JewelTrinketDTO> jewelTrinkets = new ArrayList<>();
        jewelTrinkets.add(new JewelTrinketDTO(List.of(new JewelInstanceDTO(JewelType.ETERNAL_SCORN, 7), new JewelInstanceDTO(JewelType.GLORY, 7), new JewelInstanceDTO(JewelType.RAGE, 5), new JewelInstanceDTO(JewelType.AMPLIFIED_HEALING, 5), new JewelInstanceDTO(JewelType.FROZEN_HEART, 5), new JewelInstanceDTO(JewelType.GEM_FORTUNE, 5), new JewelInstanceDTO(JewelType.ETERNAL_WRATH, 5), new JewelInstanceDTO(JewelType.INGREDIENT_HUNTER, 5), new JewelInstanceDTO(JewelType.INGREDIENT_HUNTER, 5), new JewelInstanceDTO(JewelType.INGREDIENT_HUNTER, 5))));
        jewelTrinkets.add(new JewelTrinketDTO(List.of(new JewelInstanceDTO(JewelType.FOCUS, 5), new JewelInstanceDTO(JewelType.FOCUS, 5), new JewelInstanceDTO(JewelType.FOCUS, 5), new JewelInstanceDTO(JewelType.FOCUS, 5), new JewelInstanceDTO(JewelType.FOCUS, 5), new JewelInstanceDTO(JewelType.VIGOR, 5), new JewelInstanceDTO(JewelType.AMBIDEXTROUS_VIGOR, 5), new JewelInstanceDTO(JewelType.VITALITY, 5), new JewelInstanceDTO(JewelType.ENCOURAGEMENT, 5), new JewelInstanceDTO(JewelType.CONTRIBUTION, 5))));
        jewelTrinkets.add(new JewelTrinketDTO(List.of(new JewelInstanceDTO(JewelType.LASTING_HEALTH, 5), new JewelInstanceDTO(JewelType.CONVERSE, 5), new JewelInstanceDTO(JewelType.FLOWER, 5), new JewelInstanceDTO(JewelType.STRENUOUSNESS, 5), new JewelInstanceDTO(JewelType.FORTITUDE, 5), new JewelInstanceDTO(JewelType.PROLONGATION, 5), new JewelInstanceDTO(JewelType.REVIVAL_BOON, 5), new JewelInstanceDTO(JewelType.EASTER_FEVER, 5), new JewelInstanceDTO(JewelType.SCORCHING_RAY, 5), new JewelInstanceDTO(JewelType.PENT_UP_POWER, 5))));

        DragonCrestTrinketDTO dragonCrest = new DragonCrestTrinketDTO(List.of(new DragonStoneInstanceDTO(DragonStoneType.POWERSTONE, 5), new DragonStoneInstanceDTO(DragonStoneType.POWERSTONE, 5), new DragonStoneInstanceDTO(DragonStoneType.POWERSTONE, 3), new DragonStoneInstanceDTO(DragonStoneType.POWERSTONE, 3), new DragonStoneInstanceDTO(DragonStoneType.POWERSTONE, 3)));

        PetInstanceDTO pet = new PetInstanceDTO(PetType.THE_SOUL_OF_DRAGAN_DOLL, 5);
        EssenceInstanceDTO essence = new EssenceInstanceDTO(EssenceType.VIGOR, 3);

        EnchantmentDTO hpEnchant = new EnchantmentDTO(StatType.HEALTH_POINTS, 0.44537);
        List<EnchantmentDTO> hpEnchants = List.of(hpEnchant, hpEnchant, hpEnchant, hpEnchant);
        EnchantmentDTO dmgEnchant = new EnchantmentDTO(StatType.DAMAGE, 0.44776);
        List<EnchantmentDTO> dmgEnchants = List.of(dmgEnchant, dmgEnchant, dmgEnchant, dmgEnchant);
        EnchantmentDTO critEnchant = new EnchantmentDTO(StatType.CRIT_VALUE, 0.24563);
        List<EnchantmentDTO> critEnchants = List.of(critEnchant, critEnchant, critEnchant, critEnchant);
        EnchantmentDTO blockEnchant = new EnchantmentDTO(StatType.BLOCK_VALUE, 0.24323);
        List<EnchantmentDTO> blockEnchants = List.of(blockEnchant, blockEnchant, blockEnchant, blockEnchant);
        EnchantmentDTO msEnchant = new EnchantmentDTO(StatType.MOVEMENT_SPEED, 0.22450);
        List<EnchantmentDTO> bootEnchants = List.of(msEnchant, msEnchant, dmgEnchant, dmgEnchant);

        GemInstanceDTO ruby = new GemInstanceDTO(GemType.RUBY, 17);
        List<AbstractGemInstanceDTO> rubies = List.of(ruby, ruby, ruby, ruby, ruby, ruby, ruby, ruby, ruby, ruby);
        GemInstanceDTO onyx = new GemInstanceDTO(GemType.ONYX, 17);
        List<AbstractGemInstanceDTO> onyxes = List.of(onyx, onyx, onyx, onyx, onyx, onyx, onyx, onyx, onyx, onyx);
        GemInstanceDTO amethyst = new GemInstanceDTO(GemType.AMETHYST, 17);
        List<AbstractGemInstanceDTO> amethysts = List.of(amethyst, amethyst, amethyst, amethyst, amethyst, amethyst, amethyst, amethyst, amethyst, amethyst);
        GemInstanceDTO emerald = new GemInstanceDTO(GemType.EMERALD, 17);
        List<AbstractGemInstanceDTO> emeralds = List.of(emerald, emerald, emerald, emerald, emerald, emerald, emerald, emerald, emerald, emerald);
        GemInstanceDTO rhodolite = new GemInstanceDTO(GemType.RHODOLITE, 17);
        List<AbstractGemInstanceDTO> boots = List.of(rhodolite, emerald, onyx, onyx, onyx, onyx, onyx, onyx, onyx, onyx);
        OpalInstanceDTO opal = new OpalInstanceDTO(GemType.RUBY, GemType.ONYX, GemType.EMERALD, 17);
        List<AbstractGemInstanceDTO> opals = List.of(opal, opal, opal, opal, opal, opal, opal, opal, opal, opal);

        Map<ItemSlot, ItemInstanceDTO> items = new HashMap<>();
        items.put(ItemSlot.AMULET, new ItemInstanceDTO(ItemCategory.SET, SetItemType.WINTER_AMULET, 145, Map.of(StatType.DAMAGE, 1644.883, StatType.MOVEMENT_SPEED, 0.489, StatType.HEALTH_POINTS, 24760.80), amethysts, hpEnchants, Map.of(), List.of()));
        items.put(ItemSlot.CLOAK, new ItemInstanceDTO(ItemCategory.MYTHIC, MythicItemType.ANCESTRAL_GLORY_CLOAK, 145, Map.of(StatType.DAMAGE, 1891.513, StatType.ATTACK_SPEED, 0.06, StatType.HEALTH_POINTS, 16507.200), rubies, dmgEnchants, Map.of(), List.of()));
        items.put(ItemSlot.BELT, new ItemInstanceDTO(ItemCategory.UNIQUE, UniqueItemType.BELT_OF_ZEAL, 145, Map.of(StatType.DAMAGE, 1630.885, StatType.HEALTH_POINTS, 20072.654, StatType.RESISTANCE_VALUE, 1679.873), rubies, dmgEnchants, Map.of(), List.of(new EnchantmentDTO(StatType.DAMAGE, 0.22384))));
        items.put(ItemSlot.RING1, new ItemInstanceDTO(ItemCategory.MYTHIC, MythicItemType.ANCESTRAL_GLORY_RING, 145, Map.of(StatType.DAMAGE, 1891.513, StatType.CRIT_VALUE, 1753.505, StatType.HEALTH_POINTS, 24760.80), amethysts, hpEnchants, Map.of(), List.of()));
        items.put(ItemSlot.RING2, new ItemInstanceDTO(ItemCategory.MYTHIC, MythicItemType.ANCESTRAL_GLORY_RING, 145, Map.of(StatType.DAMAGE, 1891.513, StatType.CRIT_VALUE, 1753.505, StatType.HEALTH_POINTS, 24760.80), opals, dmgEnchants, Map.of(), List.of()));
        items.put(ItemSlot.HELMET, new ItemInstanceDTO(ItemCategory.SET, SetItemType.STELLAR_WALKER_HELMET, 145, Map.of(StatType.DAMAGE, 1426.117, StatType.CRIT_VALUE, 1298.723, StatType.HEALTH_POINTS, 19630.458), amethysts, hpEnchants, Map.of(), List.of()));
        items.put(ItemSlot.SHOULDERS, new ItemInstanceDTO(ItemCategory.SET, SetItemType.STELLAR_WALKER_SHOULDERS, 145, Map.of(StatType.DAMAGE, 1639.564, StatType.CRIT_VALUE, 1361.277, StatType.HEALTH_POINTS, 15625.218), emeralds, blockEnchants, Map.of(), List.of()));
        items.put(ItemSlot.TORSO, new ItemInstanceDTO(ItemCategory.SET, SetItemType.WINTER_TORSO, 145, Map.of(StatType.ARMOR_VALUE, 1648.043, StatType.ANDERMAGIC_RESISTANCE, 6225.969, StatType.BLOCK_VALUE, 1589.428), emeralds, blockEnchants, Map.of(), List.of()));
        items.put(ItemSlot.GLOVES, new ItemInstanceDTO(ItemCategory.SET, SetItemType.WINTER_GLOVES, 145, Map.of(StatType.DAMAGE, 1644.883, StatType.ATTACK_SPEED, 0.055, StatType.CRIT_VALUE, 1753.505), onyxes, critEnchants, Map.of(), List.of()));
        items.put(ItemSlot.BOOTS, new ItemInstanceDTO(ItemCategory.SET, SetItemType.WINTER_BOOTS, 145, Map.of(StatType.DAMAGE, 1644.883, StatType.MOVEMENT_SPEED, 1.221, StatType.CRIT_VALUE, 1401.911), boots, bootEnchants, Map.of(), List.of()));
        items.put(ItemSlot.WEAPON_ADORNMENT, new ItemInstanceDTO(ItemCategory.UNIQUE, UniqueItemType.SIGRISMARRS_ADORNMENT, 145, Map.of(StatType.DAMAGE, 1870.52, StatType.CRIT_VALUE, 2100.146), rubies, dmgEnchants, Map.of(StatType.ATTACK_SPEED, 0.060), List.of()));
        items.put(ItemSlot.TWO_HAND_WEAPON, new ItemInstanceDTO(ItemCategory.UNIQUE, UniqueItemType.ANNIVERSARY_TWO_HAND_UPGRADED, 145, Map.of(StatType.DAMAGE, 26326.278, StatType.CRIT_VALUE, 3050.894), rubies, dmgEnchants, Map.of(StatType.ATTACK_SPEED, 0.102), List.of()));

        EnumMap<WisdomGroupType, WisdomGroupInstanceDTO> wisdomGroups = new EnumMap<>(WisdomGroupType.class);

        EnumMap<WisdomSkillType, WisdomSkillInstanceDTO> healthResource = new EnumMap<>(WisdomSkillType.class);
        healthResource.put(WisdomSkillType.RISING_VIGOR, new WisdomSkillInstanceDTO(WisdomSkillType.RISING_VIGOR, 60));
        healthResource.put(WisdomSkillType.VIVACIOUS_VITALITY, new WisdomSkillInstanceDTO(WisdomSkillType.VIVACIOUS_VITALITY, 60));
        healthResource.put(WisdomSkillType.CONJURED_DISTILLATION, new WisdomSkillInstanceDTO(WisdomSkillType.CONJURED_DISTILLATION, 0));
        wisdomGroups.put(WisdomGroupType.HEALTH_RESOURCE, new WisdomGroupInstanceDTO(WisdomGroupType.HEALTH_RESOURCE, healthResource));

        EnumMap<WisdomSkillType, WisdomSkillInstanceDTO> attack = new EnumMap<>(WisdomSkillType.class);
        attack.put(WisdomSkillType.RISING_POWER, new WisdomSkillInstanceDTO(WisdomSkillType.RISING_POWER, 80));
        attack.put(WisdomSkillType.DECISIVE_STRIKE, new WisdomSkillInstanceDTO(WisdomSkillType.DECISIVE_STRIKE, 80));
        attack.put(WisdomSkillType.HANGMANS_PRIDE, new WisdomSkillInstanceDTO(WisdomSkillType.HANGMANS_PRIDE, 40));
        wisdomGroups.put(WisdomGroupType.ATTACK, new WisdomGroupInstanceDTO(WisdomGroupType.ATTACK, attack));

        EnumMap<WisdomSkillType, WisdomSkillInstanceDTO> defense = new EnumMap<>(WisdomSkillType.class);
        defense.put(WisdomSkillType.STURDY_SHIELD, new WisdomSkillInstanceDTO(WisdomSkillType.STURDY_SHIELD, 80));
        defense.put(WisdomSkillType.HARD_AS_A_ROCK, new WisdomSkillInstanceDTO(WisdomSkillType.HARD_AS_A_ROCK, 60));
        defense.put(WisdomSkillType.ELEMENTAL_PROTECTION, new WisdomSkillInstanceDTO(WisdomSkillType.ELEMENTAL_PROTECTION, 60));
        wisdomGroups.put(WisdomGroupType.DEFENSE, new WisdomGroupInstanceDTO(WisdomGroupType.DEFENSE, defense));

        EnumMap<WisdomSkillType, WisdomSkillInstanceDTO> combat = new EnumMap<>(WisdomSkillType.class);
        combat.put(WisdomSkillType.SECOND_CHANCE, new WisdomSkillInstanceDTO(WisdomSkillType.SECOND_CHANCE, 1));
        combat.put(WisdomSkillType.EMERGENCY_RESERVES, new WisdomSkillInstanceDTO(WisdomSkillType.EMERGENCY_RESERVES, 0));
        combat.put(WisdomSkillType.ENERGETIC_FORCE, new WisdomSkillInstanceDTO(WisdomSkillType.ENERGETIC_FORCE, 0));
        wisdomGroups.put(WisdomGroupType.COMBAT, new WisdomGroupInstanceDTO(WisdomGroupType.COMBAT, combat));

        EnumMap<WisdomSkillType, WisdomSkillInstanceDTO> oneHand = new EnumMap<>(WisdomSkillType.class);
        oneHand.put(WisdomSkillType.DEXTROUS_SMITING, new WisdomSkillInstanceDTO(WisdomSkillType.DEXTROUS_SMITING, 60));
        oneHand.put(WisdomSkillType.DEXTROUS_AGILITY, new WisdomSkillInstanceDTO(WisdomSkillType.DEXTROUS_AGILITY, 60));
        oneHand.put(WisdomSkillType.A_HANDFUL_OF_RESOURCES, new WisdomSkillInstanceDTO(WisdomSkillType.A_HANDFUL_OF_RESOURCES, 0));
        wisdomGroups.put(WisdomGroupType.ONE_HANDED_WEAPON, new WisdomGroupInstanceDTO(WisdomGroupType.ONE_HANDED_WEAPON, oneHand));

        EnumMap<WisdomSkillType, WisdomSkillInstanceDTO> twoHand = new EnumMap<>(WisdomSkillType.class);
        twoHand.put(WisdomSkillType.AMBIDEXTROUS_SMITING, new WisdomSkillInstanceDTO(WisdomSkillType.AMBIDEXTROUS_SMITING, 60));
        twoHand.put(WisdomSkillType.AMBIDEXTROUS_AGILITY, new WisdomSkillInstanceDTO(WisdomSkillType.AMBIDEXTROUS_AGILITY, 30));
        twoHand.put(WisdomSkillType.LIFETIME_THIEF, new WisdomSkillInstanceDTO(WisdomSkillType.LIFETIME_THIEF, 60));
        wisdomGroups.put(WisdomGroupType.TWO_HANDED_WEAPON, new WisdomGroupInstanceDTO(WisdomGroupType.TWO_HANDED_WEAPON, twoHand));

        EnumMap<WisdomSkillType, WisdomSkillInstanceDTO> prosperity = new EnumMap<>(WisdomSkillType.class);
        prosperity.put(WisdomSkillType.BONANZA, new WisdomSkillInstanceDTO(WisdomSkillType.BONANZA, 15));
        prosperity.put(WisdomSkillType.PEDDLER, new WisdomSkillInstanceDTO(WisdomSkillType.PEDDLER, 1));
        prosperity.put(WisdomSkillType.PORTABLE_WORKBENCH, new WisdomSkillInstanceDTO(WisdomSkillType.PORTABLE_WORKBENCH, 1));
        wisdomGroups.put(WisdomGroupType.PROSPERITY, new WisdomGroupInstanceDTO(WisdomGroupType.PROSPERITY, prosperity));

        EnumMap<WisdomSkillType, WisdomSkillInstanceDTO> travelMerits = new EnumMap<>(WisdomSkillType.class);
        travelMerits.put(WisdomSkillType.HOME_SWEET_HOME, new WisdomSkillInstanceDTO(WisdomSkillType.HOME_SWEET_HOME, 15));
        travelMerits.put(WisdomSkillType.ON_HORSEBACK, new WisdomSkillInstanceDTO(WisdomSkillType.ON_HORSEBACK, 15));
        travelMerits.put(WisdomSkillType.RACING_SLIPPERS, new WisdomSkillInstanceDTO(WisdomSkillType.RACING_SLIPPERS, 0));
        wisdomGroups.put(WisdomGroupType.TRAVEL_MERITS, new WisdomGroupInstanceDTO(WisdomGroupType.TRAVEL_MERITS, travelMerits));

        WisdomSkillTreeInstanceDTO wisdomSkillTree = new WisdomSkillTreeInstanceDTO(wisdomGroups);

        List<CollectorBagCategoryBonusInstanceDTO> collectorBagBuffs = new ArrayList<>();
        collectorBagBuffs.add(new CollectorBagCategoryBonusInstanceDTO(CollectorBagCategory.DRAGON_SPAWN, CollectorBagTier.TIER3));
        collectorBagBuffs.add(new CollectorBagCategoryBonusInstanceDTO(CollectorBagCategory.SCOUNDRELS, CollectorBagTier.TIER2));
        collectorBagBuffs.add(new CollectorBagCategoryBonusInstanceDTO(CollectorBagCategory.DOMESTICATED, CollectorBagTier.TIER2));
        collectorBagBuffs.add(new CollectorBagCategoryBonusInstanceDTO(CollectorBagCategory.WILD_BEASTS, CollectorBagTier.TIER1));
        collectorBagBuffs.add(new CollectorBagCategoryBonusInstanceDTO(CollectorBagCategory.AQUATICS, CollectorBagTier.TIER1));
        collectorBagBuffs.add(new CollectorBagCategoryBonusInstanceDTO(CollectorBagCategory.AVIANS, CollectorBagTier.TIER1));
        collectorBagBuffs.add(new CollectorBagCategoryBonusInstanceDTO(CollectorBagCategory.TAMED_FOES, CollectorBagTier.TIER4));
        collectorBagBuffs.add(new CollectorBagCategoryBonusInstanceDTO(CollectorBagCategory.FREE_SPIRITS, CollectorBagTier.TIER3));
        collectorBagBuffs.add(new CollectorBagCategoryBonusInstanceDTO(CollectorBagCategory.AUTOMATONS, CollectorBagTier.TIER2));
        collectorBagBuffs.add(new CollectorBagCategoryBonusInstanceDTO(CollectorBagCategory.LUCKY_CATS, CollectorBagTier.TIER0));
        collectorBagBuffs.add(new CollectorBagCategoryBonusInstanceDTO(CollectorBagCategory.SHADOW_SOULS, CollectorBagTier.TIER2));


        return new CharacterDTO(
                CharacterClass.SPELLWEAVER,
                "test",
                MasteryType.ICE,
                3,
                true,
                5,
                runeTrinkets,
                jewelTrinkets,
                dragonCrest,
                items,
                pet,
                essence,
                null,
                null,
                wisdomSkillTree,
                collectorBagBuffs
        );
    }
}
