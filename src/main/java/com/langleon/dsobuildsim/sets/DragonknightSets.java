package com.langleon.dsobuildsim.sets;

import com.langleon.dsobuildsim.enums.StatType;
import com.langleon.dsobuildsim.items.itemdatabase.Item;
import com.langleon.dsobuildsim.items.itemdatabase.mythicitems.DragonknightMythicItem;
import com.langleon.dsobuildsim.items.itemdatabase.setitems.DragonknightSetItems;
import com.langleon.dsobuildsim.overallbuffs.OverallAbsolutBuff;
import com.langleon.dsobuildsim.overallbuffs.OverallBuff;
import com.langleon.dsobuildsim.overallbuffs.OverallDescriptionBuff;
import com.langleon.dsobuildsim.overallbuffs.OverallRelativeBuff;

import java.util.List;
import java.util.Map;

public enum DragonknightSets implements SetEnumInterface {

    ANCESTRAL_GLORY("Forgotton Glory", Map.of(2, List.of(new OverallDescriptionBuff("..."))), 145),
    AT_DEATHS_DOOR("At Death's Door", Map.of(2, List.of(new OverallAbsolutBuff(StatType.MANA, 19.0), new OverallRelativeBuff(StatType.DAMAGE, 5.0), new OverallRelativeBuff(StatType.HEALTH_POINTS, -2.5), new OverallDescriptionBuff("Mortis Set Buff"))), 145),
    BLACK_WARLORD_REGALIA("Black Warlord Regalia",Map.of(1, List.of(new OverallRelativeBuff(StatType.HEALTH_POINTS, 0.15), new OverallRelativeBuff(StatType.ARMOR_VALUE, 0.20)), 2, List.of(new OverallRelativeBuff(StatType.CRIT_VALUE, 0.075), new OverallDescriptionBuff("Doubles the amount of dropped quest items for side quests.")), 3, List.of(new OverallRelativeBuff(StatType.DAMAGE, 0.075), new OverallDescriptionBuff("..."))), 145),
    END_OF_THE_EMPIRE("End of the Empire",Map.of(1, List.of(new OverallRelativeBuff(StatType.HEALTH_POINTS, 0.20), new OverallRelativeBuff(StatType.ARMOR_VALUE, 0.25)), 2, List.of(new OverallRelativeBuff(StatType.CRIT_VALUE, 0.075), new OverallDescriptionBuff("Doubles the amount of dropped quest items for side quests.")), 3, List.of(new OverallRelativeBuff(StatType.DAMAGE, 0.1), new OverallDescriptionBuff("..."))), 145),
    FORGOTTON_GLORY("Forgotton Glory", Map.of(2, List.of(new OverallDescriptionBuff("..."))), 145),
    MIGHTY_VISIONARY_SEEKER("Mighty Visionary Seeker", Map.of(2, List.of(new OverallAbsolutBuff(StatType.ATTACK_SPEED, 0.79)), 4, List.of(new OverallAbsolutBuff(StatType.DAMAGE, 8657.0)), 6, List.of(new OverallAbsolutBuff(StatType.MANA, 68.0), new OverallDescriptionBuff("..."))), 140),
    SARGONS_IMMORTAL_TERROR_ARMOR("Sargon's Immortal Terror Armor", Map.of(2, List.of(new OverallAbsolutBuff(StatType.DAMAGE, 2776.0)), 3, List.of(new OverallAbsolutBuff(StatType.HEALTH_POINTS, 33347.0), new OverallAbsolutBuff(StatType.DAMAGE, 5553.0))), 145),
    MACHINE_POWER("Machine Power", Map.of(2, List.of(new OverallAbsolutBuff(StatType.DAMAGE, 4165.0)), 3, List.of(new OverallAbsolutBuff(StatType.CRIT_VALUE, 4331.0)), 4, List.of(new OverallAbsolutBuff(StatType.ATTACK_SPEED, 0.214)), 5, List.of(new OverallAbsolutBuff(StatType.MANA, 29.0))), 145),
    ENRAGED_EMPORER("Enraged Emporer", Map.of(1, List.of(new OverallRelativeBuff(StatType.HEALTH_POINTS, 0.1)), 2, List.of(new OverallRelativeBuff(StatType.CRIT_VALUE, 0.05), new OverallRelativeBuff(StatType.ATTACK_SPEED, 0.05)), 3, List.of(new OverallDescriptionBuff("Each successful hit with Meteor aplies 30% reduced fire resistance)"))), 140),
    KRANPARUS_TREASURES("Kranparus' Treasureas", Map.of(1, List.of(new OverallAbsolutBuff(StatType.HEALTH_POINTS, 67615.0)), 2, List.of(new OverallAbsolutBuff(StatType.DAMAGE, 1248.0)), 3, List.of(new OverallAbsolutBuff(StatType.CRIT_VALUE, 4677.0))), 140),
    ;

    private final String name;
    private Map<Integer, List<OverallBuff>> setBonus;
    private List<Item> setItems;
    private int level;

    DragonknightSets(String name, Map<Integer, List<OverallBuff>> setBonus, int level)
    {
        this.name = name;
        this.setBonus = setBonus;
        this.level = level;
    }

    public String getName() {
        return this.name;
    }

    public Map<Integer, List<OverallBuff>> getSetBonus() {
        return this.setBonus;
    }

    public List<Item> getSetItems() {
        return this.setItems;
    }

    public int getLevel() {
        return level;
    }

    static
    {
        ANCESTRAL_GLORY.setItems = List.of(DragonknightMythicItem.RING_OF_ANCESTRAL_GLORY, DragonknightMythicItem.ANCESTRAL_GLORY_CLOAK);
        AT_DEATHS_DOOR.setItems = List.of(DragonknightSetItems.HELMET_OF_DEATH, DragonknightSetItems.SEAL_OF_DEATH);
        BLACK_WARLORD_REGALIA.setItems = List.of(DragonknightSetItems.HELMET_OF_THE_BLACK_KNIGHT, DragonknightSetItems.SHOULDERS_OF_THE_BLACK_KNIGHT, DragonknightSetItems.CLOAK_OF_THE_BLACK_KNIGHT);
        END_OF_THE_EMPIRE.setItems = List.of(DragonknightSetItems.HELMET_OF_THE_END, DragonknightSetItems.SHOULDERS_OF_THE_END, DragonknightSetItems.CLOAK_OF_THE_END);
        FORGOTTON_GLORY.setItems = List.of(DragonknightMythicItem.OLD_GLORY, DragonknightMythicItem.RING_OF_OLD_GLORY);
        MIGHTY_VISIONARY_SEEKER.setItems = List.of(DragonknightSetItems.MIGHTY_WRATHFUL_SEEKERS_HELMET, DragonknightSetItems.MIGHTY_WRATHFUL_SEEKERS_SHOULDERS, DragonknightSetItems.MIGHTY_WRATHFUL_SEEKERS_TORSO, DragonknightSetItems.MIGHTY_WRATHFUL_SEEKERS_GLOVES, DragonknightSetItems.MIGHTY_WRATHFUL_SEEKERS_BOOTS, DragonknightSetItems.MIGHTY_WRATHFUL_SEEKERS_CAPE);
        SARGONS_IMMORTAL_TERROR_ARMOR.setItems = List.of(DragonknightSetItems.SARGONS_HORNS, DragonknightSetItems.SARGONS_PAULDRONS, DragonknightSetItems.SARGONS_TORSO);
        MACHINE_POWER.setItems = List.of(DragonknightSetItems.MACHINE_HELMET, DragonknightSetItems.MACHINE_SHOULDERS, DragonknightSetItems.MACHINE_ARMOR, DragonknightSetItems.MACHINE_FISTS, DragonknightSetItems.MACHINE_BOOTS, DragonknightSetItems.MACHINE_BELT, DragonknightSetItems.LARGE_MACHINE_AXE, DragonknightSetItems.LARGE_MACHINE_BLADE, DragonknightSetItems.LARGE_MACHINE_HAMMER);
        ENRAGED_EMPORER. setItems = List.of(DragonknightSetItems.ARMOR_OF_THE_FLAME_CONQUEROR, DragonknightSetItems.GLOVES_OF_THE_FLAME_CONQUEROR, DragonknightSetItems.BOOTS_OF_THE_FLAME_CONQUEROR);
        KRANPARUS_TREASURES.setItems = List.of(DragonknightSetItems.KRANPARUS_ICY_BATTLE_MACE, DragonknightSetItems.KRANPARUS_ICY_SHIELD, DragonknightSetItems.KRANPARUS_ICY_AMULET);
    }
}
