package com.langleon.dsobuildsim.items.itemdatabase.mythicitems;

import com.langleon.dsobuildsim.enchantments.UniqueEnchant;
import com.langleon.dsobuildsim.enums.AbsoluteStatType;
import com.langleon.dsobuildsim.enums.CharacterClass;
import com.langleon.dsobuildsim.enums.ItemType;
import com.langleon.dsobuildsim.enums.OverallRelativeBuffType;
import com.langleon.dsobuildsim.items.itemdatabase.Item;
import com.langleon.dsobuildsim.items.actualitems.MythicItem;
import com.langleon.dsobuildsim.overallbuffs.OverallAbsolutBuff;
import com.langleon.dsobuildsim.overallbuffs.OverallBuff;
import com.langleon.dsobuildsim.overallbuffs.OverallRelativeBuff;
import com.langleon.dsobuildsim.sets.DragonknightSets;

import java.util.List;
import java.util.Map;

public enum DragonknightMythicItem implements Item {

    OLD_GLORY("Old Glory", ItemType.CLOAK, Map.of(AbsoluteStatType.DAMAGE, 1891.513, AbsoluteStatType.ATTACK_SPEED, 0.06, AbsoluteStatType.HEALTH_POINTS, 49521.596), Map.of(), List.of(), List.of(new OverallRelativeBuff(OverallRelativeBuffType.DAMAGE, 0.1)), 145),
    RING_OF_OLD_GLORY("Ring of Old Glory", ItemType.RING, Map.of(AbsoluteStatType.DAMAGE, 1891.513, AbsoluteStatType.CRIT_VALUE, 1753.505, AbsoluteStatType.HEALTH_POINTS, 74282.408), Map.of(), List.of(), List.of(new OverallRelativeBuff(OverallRelativeBuffType.DAMAGE, 0.05), new OverallRelativeBuff(OverallRelativeBuffType.CRIT_VALUE, 0.05)),145),
    ANCESTRAL_GLORY_CLOAK("Ancestral Glory Cloak (Dragonknight)", ItemType.CLOAK, Map.of(AbsoluteStatType.DAMAGE, 1891.513, AbsoluteStatType.ATTACK_SPEED, 0.06, AbsoluteStatType.HEALTH_POINTS, 49521.596), Map.of(), List.of(), List.of(new OverallRelativeBuff(OverallRelativeBuffType.DAMAGE, 0.1), new OverallAbsolutBuff(AbsoluteStatType.DAMAGE, 5000.0)),145),
    RING_OF_ANCESTRAL_GLORY("Ancestral Glory Ring", ItemType.RING, Map.of(AbsoluteStatType.DAMAGE, 1891.513, AbsoluteStatType.CRIT_VALUE, 1753.505, AbsoluteStatType.HEALTH_POINTS, 74282.408), Map.of(), List.of(), List.of(new OverallRelativeBuff(OverallRelativeBuffType.DAMAGE, 0.1), new OverallRelativeBuff(OverallRelativeBuffType.CRIT_VALUE, 0.1)),145);

    private final String name;
    private final ItemType itemType;
    private final Map<AbsoluteStatType, Double> baseStats;
    private final Map<AbsoluteStatType, Double> uniqueBaseStats;
    private final List<UniqueEnchant> uniqueEnchants;
    private final List<OverallBuff> overallBuffs;
    private final CharacterClass characterClass;
    private final int itemLevel;
    private DragonknightSets set;

    DragonknightMythicItem(String name, ItemType itemType, Map<AbsoluteStatType, Double> baseStats, Map<AbsoluteStatType, Double> uniqueBaseStats, List<UniqueEnchant> uniqueEnchants, List<OverallBuff> overallBuffs, int itemLevel) {
        this.characterClass = CharacterClass.DRAGONKNIGHT;
        this.name = name;
        this.itemType = itemType;
        this.baseStats = baseStats;
        this.uniqueBaseStats = uniqueBaseStats;
        this.uniqueEnchants = uniqueEnchants;
        this.overallBuffs = overallBuffs;
        this.itemLevel = itemLevel;
    }

    public MythicItem getItem() {
        return new MythicItem(this.name, CharacterClass.DRAGONKNIGHT, this.itemType, this.baseStats, this.uniqueBaseStats, this.uniqueEnchants, this.overallBuffs, this.itemLevel, this.set);
    }

    public CharacterClass getCharacterClass() {
        return characterClass;
    }

    static
    {
        OLD_GLORY.set = DragonknightSets.FORGOTTON_GLORY;
        RING_OF_OLD_GLORY.set = DragonknightSets.FORGOTTON_GLORY;
        ANCESTRAL_GLORY_CLOAK.set = DragonknightSets.ANCESTRAL_GLORY;
        RING_OF_ANCESTRAL_GLORY.set = DragonknightSets.ANCESTRAL_GLORY;
    }

}
