package com.langleon.dsobuildsim.items.itemdatabase.mythicitems;

import com.langleon.dsobuildsim.enchantments.UniqueEnchant;
import com.langleon.dsobuildsim.enums.CharacterClass;
import com.langleon.dsobuildsim.enums.ItemType;
import com.langleon.dsobuildsim.enums.StatType;
import com.langleon.dsobuildsim.items.itemdatabase.Item;
import com.langleon.dsobuildsim.items.actualitems.MythicItem;
import com.langleon.dsobuildsim.overallbuffs.OverallAbsolutBuff;
import com.langleon.dsobuildsim.overallbuffs.OverallBuff;
import com.langleon.dsobuildsim.overallbuffs.OverallRelativeBuff;
import com.langleon.dsobuildsim.sets.RangerSets;

import java.util.List;
import java.util.Map;

public enum RangerMythicItem implements Item {

    OLD_GLORY("Old Glory", ItemType.CLOAK, Map.of(StatType.DAMAGE, 1891.513, StatType.ATTACK_SPEED, 0.06, StatType.HEALTH_POINTS, 49521.596), Map.of(), List.of(), List.of(new OverallRelativeBuff(StatType.DAMAGE, 0.1)),145),
    RING_OF_OLD_GLORY("Ring of Old Glory", ItemType.RING, Map.of(StatType.DAMAGE, 1891.513, StatType.CRIT_VALUE, 1753.505, StatType.HEALTH_POINTS, 74282.408), Map.of(), List.of(), List.of(new OverallRelativeBuff(StatType.DAMAGE, 0.05), new OverallRelativeBuff(StatType.CRIT_VALUE, 0.05)),145),
    ANCESTRAL_GLORY_CLOAK("Ancestral Glory Cloak (Ranger)", ItemType.CLOAK, Map.of(StatType.DAMAGE, 1891.513, StatType.ATTACK_SPEED, 0.06, StatType.HEALTH_POINTS, 49521.596), Map.of(), List.of(), List.of(new OverallRelativeBuff(StatType.DAMAGE, 0.1), new OverallAbsolutBuff(StatType.DAMAGE, 5000.0)),145),
    RING_OF_ANCESTRAL_GLORY("Ancestral Glory Ring", ItemType.RING, Map.of(StatType.DAMAGE, 1891.513, StatType.CRIT_VALUE, 1753.505, StatType.HEALTH_POINTS, 74282.408), Map.of(), List.of(), List.of(new OverallRelativeBuff(StatType.DAMAGE, 0.1), new OverallRelativeBuff(StatType.CRIT_VALUE, 0.1)),145);

    private final String name;
    private final ItemType itemType;
    private final Map<StatType, Double> baseStats;
    private final Map<StatType, Double> uniqueBaseStats;
    private final List<UniqueEnchant> uniqueEnchants;
    private final List<OverallBuff> overallBuffs;
    private final CharacterClass characterClass;
    private final int itemLevel;
    private RangerSets set;

    RangerMythicItem(String name, ItemType itemType, Map<StatType, Double> baseStats, Map<StatType, Double> uniqueBaseStats, List<UniqueEnchant> uniqueEnchants, List<OverallBuff> overallBuffs, int itemLevel) {
        this.characterClass = CharacterClass.RANGER;
        this.name = name;
        this.itemType = itemType;
        this.baseStats = baseStats;
        this.uniqueBaseStats = uniqueBaseStats;
        this.uniqueEnchants = uniqueEnchants;
        this.overallBuffs = overallBuffs;
        this.itemLevel = itemLevel;
    }

    public MythicItem getItem() {
        return new MythicItem(this.name, CharacterClass.RANGER, this.itemType, this.baseStats, this.uniqueBaseStats, this.uniqueEnchants, this.overallBuffs, this.itemLevel, this.set);
    }

    public CharacterClass getCharacterClass() {
        return characterClass;
    }

    static
    {
        OLD_GLORY.set = RangerSets.FORGOTTON_GLORY;
        RING_OF_OLD_GLORY.set = RangerSets.FORGOTTON_GLORY;
        ANCESTRAL_GLORY_CLOAK.set = RangerSets.ANCESTRAL_GLORY;
        RING_OF_ANCESTRAL_GLORY.set = RangerSets.ANCESTRAL_GLORY;
    }

}
