package kaukasus.Items.ItemDatabase.UniqueItems;

import kaukasus.Enchants.UniqueEnchant;
import kaukasus.Enums.*;
import kaukasus.Items.ActualItems.UniqueItem;
import kaukasus.Items.ItemDatabase.Item;
import kaukasus.OverallBuffs.OverallBuff;
import kaukasus.OverallBuffs.OverallDescriptionBuff;
import kaukasus.OverallBuffs.OverallRelativeBuff;

import java.util.List;
import java.util.Map;

public enum SpellweaverUniqueItems implements Item {

    BLUEPRINT("blueprint", ItemTypeEnum.AMULET, Map.of(AbsoluteStatTypeEnum.CRIT_VALUE, 0.0, AbsoluteStatTypeEnum.HEALTH_POINTS, 0.0, AbsoluteStatTypeEnum.POISON_RESISTANCE, 0.0), Map.of(), List.of(), List.of(), 145),

    ABYSSAL_TREASURE_GLOVES("Abyssal Treasure Gloves", ItemTypeEnum.GLOVES, Map.of(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.055, AbsoluteStatTypeEnum.CRIT_VALUE, 1753.505, AbsoluteStatTypeEnum.LIGHTNING_RESISTANCE, 4150.0), Map.of(AbsoluteStatTypeEnum.LIGHTNING_RESISTANCE, 4865.0), List.of(), List.of(new OverallDescriptionBuff("Increases the Frozen Sphere talent by 10. Frozen Sphere has a 5% chance to petrify hit enemies.")), 145),
    AMULET_OF_THE_KRAKEN("Amulet of the Kraken", ItemTypeEnum.AMULET, Map.of(AbsoluteStatTypeEnum.CRIT_VALUE, 1753.505, AbsoluteStatTypeEnum.HEALTH_POINTS, 24760.80, AbsoluteStatTypeEnum.POISON_RESISTANCE, 4150.0), Map.of(AbsoluteStatTypeEnum.POISON_RESISTANCE, 3406.0), List.of(), List.of(new OverallDescriptionBuff("Increases the Frost Wind talent by 4.")), 145),
    BELT_OF_ZEAL("Belt of Zeal", ItemTypeEnum.BELT, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1644.883, AbsoluteStatTypeEnum.HEALTH_POINTS, 24760.80, AbsoluteStatTypeEnum.RESISTANCE, 1743.0), Map.of(), List.of(new UniqueEnchant(EnchantTypeEnum.DAMAGE, 0.22384)), List.of(new OverallDescriptionBuff("Belt of Zeal Buff")), 145),
    GRIMACE_OF_THE_THUNDER_BEAST("Grimace of the Thunder Beast", ItemTypeEnum.TWO_HAND_WEAPON, Map.of(AbsoluteStatTypeEnum.DAMAGE, 26326.0, AbsoluteStatTypeEnum.CRIT_VALUE, 3506.0), Map.of(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.102), List.of(), List.of(new OverallDescriptionBuff("Anni Weapon Buff")), 145),
    RESEARCHERS_BOOTS("Researcher's Boots", ItemTypeEnum.BOOTS, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1601.0, AbsoluteStatTypeEnum.MOVEMENT_SPEED, 1.208, AbsoluteStatTypeEnum.CRIT_VALUE, 1366.0), Map.of(), List.of(new UniqueEnchant(EnchantTypeEnum.MOVEMENT_SPEED, 0.25558)), List.of(new OverallRelativeBuff(OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.1)), 140),
    SARGONS_SHADOW_AMULET("Sargon's Shadow Amulet", ItemTypeEnum.AMULET, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1601.0, AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.489, AbsoluteStatTypeEnum.HEALTH_POINTS, 24761.0), Map.of(AbsoluteStatTypeEnum.DAMAGE, 3771.0), List.of(), List.of(), 140),
    SIGRISMARRS_ETERNAL_GRASP("Sigrismarr's Eternal Grasp", ItemTypeEnum.WEAPON_ADORNMENT, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1891.513, AbsoluteStatTypeEnum.CRIT_VALUE, 2104.0), Map.of(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.06), List.of(), List.of(new OverallDescriptionBuff("Increases the Ice Missile talent by 5")), 145),
    SIGRISMARRS_ETERNAL_WARD("Sigrismarr's Eternal Ward", ItemTypeEnum.TORSO, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1644.883, AbsoluteStatTypeEnum.HEALTH_POINTS, 16507.0, AbsoluteStatTypeEnum.ARMOR, 1648.0), Map.of(AbsoluteStatTypeEnum.ICE_RESISTANCE, 3459.0), List.of(), List.of(new OverallDescriptionBuff("Increases the Frozen Sphere talent by 3.")), 145),
    STINGER("Stinger", ItemTypeEnum.WEAPON_ADORNMENT, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1891.513, AbsoluteStatTypeEnum.ATTACK_SPEED, 0.055, AbsoluteStatTypeEnum.CRIT_VALUE, 2104.0), Map.of(), List.of(new UniqueEnchant(EnchantTypeEnum.DAMAGE, 0.67637), new UniqueEnchant(EnchantTypeEnum.CRIT_VALUE, 0.60126)), List.of(), 145),
    ;

    private final String name;
    private final ItemTypeEnum itemType;
    private final Map<AbsoluteStatTypeEnum, Double> baseStats;
    private final CharacterClassEnum characterClass;
    private final Map<AbsoluteStatTypeEnum, Double> uniqueBaseStat;
    private final List<UniqueEnchant> uniqueEnchants;
    private final List<OverallBuff> overallBuffs;
    private final int itemLevel;

    SpellweaverUniqueItems(String name, ItemTypeEnum itemType, Map<AbsoluteStatTypeEnum, Double> baseStats, Map<AbsoluteStatTypeEnum, Double> uniqueBaseStats, java.util.List<UniqueEnchant> uniqueEnchants, List<OverallBuff> overallBuffs, int itemLevel) {
        this.characterClass = CharacterClassEnum.SPELLWEAVER;
        this.name = name;
        this.itemType = itemType;
        this.baseStats = baseStats;
        this.uniqueBaseStat = uniqueBaseStats;
        this.uniqueEnchants = uniqueEnchants;
        this.overallBuffs = overallBuffs;
        this.itemLevel = itemLevel;
    }

    public UniqueItem getItem() {
        return new UniqueItem(this.name, CharacterClassEnum.SPELLWEAVER, this.itemType, this.baseStats, this.uniqueBaseStat, this.uniqueEnchants, this.overallBuffs, this.itemLevel);
    }

    public CharacterClassEnum getCharacterClass() {
        return characterClass;
    }

}
