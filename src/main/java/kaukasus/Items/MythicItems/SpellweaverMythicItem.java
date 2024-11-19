package kaukasus.Items.MythicItems;

import kaukasus.Enchants.UniqueEnchant;
import kaukasus.Enums.*;
import kaukasus.Items.Item;
import kaukasus.OverallBuffs.OverallAbsolutBuff;
import kaukasus.OverallBuffs.OverallBuff;
import kaukasus.OverallBuffs.OverallRelativeBuff;
import kaukasus.Sets.SpellweaverSets;

import java.util.List;
import java.util.Map;

public enum SpellweaverMythicItem implements Item {

    OLD_GLORY("Old Glory", ItemTypeEnum.CLOAK, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1891.513, AbsoluteStatTypeEnum.ATTACK_SPEED, 0.06, AbsoluteStatTypeEnum.HEALTH_POINTS, 16507.200), Map.of(), List.of(), List.of(new OverallRelativeBuff(OverallRelativeBuffTypeEnum.DAMAGE, 0.1)),145),
    RING_OF_OLD_GLORY("Ring of Old Glory", ItemTypeEnum.RING, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1891.513, AbsoluteStatTypeEnum.CRIT_VALUE, 1753.505, AbsoluteStatTypeEnum.HEALTH_POINTS, 24760.80), Map.of(), List.of(), List.of(new OverallRelativeBuff(OverallRelativeBuffTypeEnum.DAMAGE, 0.05), new OverallRelativeBuff(OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.05)),145),
    ANCESTRAL_GLORY_CLOAK("Ancestral Glory Cloak (Mage)", ItemTypeEnum.CLOAK, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1891.513, AbsoluteStatTypeEnum.ATTACK_SPEED, 0.06, AbsoluteStatTypeEnum.HEALTH_POINTS, 16507.200), Map.of(), List.of(), List.of(new OverallRelativeBuff(OverallRelativeBuffTypeEnum.DAMAGE, 0.1), new OverallAbsolutBuff(AbsoluteStatTypeEnum.DAMAGE, 5000.0)),15),
    RING_OF_ANCESTRAL_GLORY("Ancestral Glory Ring", ItemTypeEnum.RING, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1891.513, AbsoluteStatTypeEnum.CRIT_VALUE, 1753.505, AbsoluteStatTypeEnum.HEALTH_POINTS, 24760.80), Map.of(), List.of(), List.of(new OverallRelativeBuff(OverallRelativeBuffTypeEnum.DAMAGE, 0.1), new OverallRelativeBuff(OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.1)),145);

    private final String name;
    private final ItemTypeEnum itemType;
    private final Map<AbsoluteStatTypeEnum, Double> baseStats;
    private final Map<AbsoluteStatTypeEnum, Double> uniqueBaseStats;
    private final List<UniqueEnchant> uniqueEnchants;
    private final List<OverallBuff> overallBuffs;
    private final CharacterClassEnum characterClass;
    private final int itemLevel;
    private SpellweaverSets set;

    SpellweaverMythicItem(String name, ItemTypeEnum itemType, Map<AbsoluteStatTypeEnum, Double> baseStats, Map<AbsoluteStatTypeEnum, Double> uniqueBaseStats, List<UniqueEnchant> uniqueEnchants, List<OverallBuff> overallBuffs, int itemLevel) {
        this.characterClass = CharacterClassEnum.SPELLWEAVER;
        this.name = name;
        this.itemType = itemType;
        this.baseStats = baseStats;
        this.uniqueBaseStats = uniqueBaseStats;
        this.uniqueEnchants = uniqueEnchants;
        this.overallBuffs = overallBuffs;
        this.itemLevel = itemLevel;
    }

    public MythicItem getItem() {
        return new MythicItem(this.name, this.itemType, this.baseStats, this.uniqueBaseStats, this.uniqueEnchants, this.overallBuffs, this.set, this.itemLevel);
    }

    public CharacterClassEnum getCharacterClass() {
        return characterClass;
    }

    static
    {
        OLD_GLORY.set = SpellweaverSets.FORGOTTON_GLORY;
        RING_OF_OLD_GLORY.set = SpellweaverSets.FORGOTTON_GLORY;
        ANCESTRAL_GLORY_CLOAK.set = SpellweaverSets.ANCESTRAL_GLORY;
        RING_OF_ANCESTRAL_GLORY.set = SpellweaverSets.ANCESTRAL_GLORY;
    }

}
