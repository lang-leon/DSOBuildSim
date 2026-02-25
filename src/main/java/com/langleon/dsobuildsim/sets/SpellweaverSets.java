package com.langleon.dsobuildsim.sets;

import com.langleon.dsobuildsim.enums.StatType;
import com.langleon.dsobuildsim.items.itemdatabase.Item;
import com.langleon.dsobuildsim.items.itemdatabase.mythicitems.SpellweaverMythicItem;
import com.langleon.dsobuildsim.items.itemdatabase.setitems.SpellweaverSetItems;
import com.langleon.dsobuildsim.overallbuffs.OverallAbsolutBuff;
import com.langleon.dsobuildsim.overallbuffs.OverallBuff;
import com.langleon.dsobuildsim.overallbuffs.OverallDescriptionBuff;
import com.langleon.dsobuildsim.overallbuffs.OverallRelativeBuff;

import java.util.List;
import java.util.Map;

public enum SpellweaverSets implements SetEnumInterface {

    SET1("Forgotton Glory", Map.of(), -1),
    ANCESTRAL_GLORY("Forgotton Glory", Map.of(2, List.of(new OverallDescriptionBuff("..."))), 145),
    BLACK_WARLORD_REGALIA("Black Warlord Regalia", Map.of(1, List.of(new OverallRelativeBuff(StatType.HEALTH_POINTS, 0.15), new OverallRelativeBuff(StatType.ARMOR_VALUE, 0.15)), 2, List.of(new OverallDescriptionBuff("- Frozen Sphere% cooldown time for 20.00"), new OverallDescriptionBuff("Doubles the amount of dropped quest items for side quests.")), 3, List.of(new OverallRelativeBuff(StatType.DAMAGE, 0.075), new OverallDescriptionBuff("Your Frozen Spheres are doubled."))), 145),
    END_OF_THE_EMPIRE("End of the Empire", Map.of(1, List.of(new OverallRelativeBuff(StatType.HEALTH_POINTS, 0.20), new OverallRelativeBuff(StatType.ARMOR_VALUE, 0.20)), 2, List.of(new OverallDescriptionBuff("- Frozen Sphere% cooldown time for 20.00"), new OverallDescriptionBuff("Doubles the amount of dropped quest items for side quests.")), 3, List.of(new OverallRelativeBuff(StatType.DAMAGE, 0.1), new OverallDescriptionBuff("Your Frozen Spheres are doubled."))), 145),
    FORGOTTON_GLORY("Forgotton Glory", Map.of(2, List.of(new OverallDescriptionBuff("..."))), 145),
    MIGHTY_VISIONARY_SEEKER("Mighty Visionary Seeker", Map.of(2, List.of(new OverallAbsolutBuff(StatType.ATTACK_SPEED, 0.79)), 4, List.of(new OverallAbsolutBuff(StatType.DAMAGE, 8657.0)), 6, List.of(new OverallAbsolutBuff(StatType.MANA, 68.0), new OverallDescriptionBuff("..."))), 140),
    SARGONS_IMMORTAL_TERROR_ARMOR("Sargon's Immortal Terror Armor", Map.of(2, List.of(new OverallAbsolutBuff(StatType.DAMAGE, 2776.0)), 3, List.of(new OverallAbsolutBuff(StatType.HEALTH_POINTS, 33347.0), new OverallAbsolutBuff(StatType.DAMAGE, 5553.0))), 145),
    ENRAGED_EMPORER("Enraged Emporer", Map.of(1, List.of(new OverallRelativeBuff(StatType.HEALTH_POINTS, 0.1)), 2, List.of(new OverallRelativeBuff(StatType.CRIT_VALUE, 0.05), new OverallRelativeBuff(StatType.ATTACK_SPEED, 0.05)), 3, List.of(new OverallDescriptionBuff("Each successful hit with Meteor aplies 30% reduced fire resistance)"))), 140),
    KRANPARUS_TREASURES("Kranparus' Treasures", Map.of(1, List.of(new OverallAbsolutBuff(StatType.HEALTH_POINTS, 39954.0)), 3, List.of(new OverallAbsolutBuff(StatType.DAMAGE, 1248.0), new OverallAbsolutBuff(StatType.CRIT_VALUE, 4677.0))), 145),
    AT_DEATHS_DOOR("At Death's Door", Map.of(2, List.of(new OverallAbsolutBuff(StatType.MANA, 19.0), new OverallRelativeBuff(StatType.DAMAGE, 5.0), new OverallRelativeBuff(StatType.HEALTH_POINTS, -2.5))), 145),
    BLACK_ESSENCE_ARMAMENT("Black Essence Armament", Map.of(2, List.of(new OverallAbsolutBuff(StatType.RESISTANCE_VALUE, 2044.0)), 3, List.of(new OverallDescriptionBuff("Essence cost reduced by 1")), 4, List.of(new OverallAbsolutBuff(StatType.MANA, 19.0)), 5, List.of(new OverallDescriptionBuff("Ess cost 0 with 15% chance"))), 140),
    AUTOMATED_UNIT("Automated Unit", Map.of(2, List.of(new OverallAbsolutBuff(StatType.DAMAGE, 4165.0)), 3, List.of(new OverallAbsolutBuff(StatType.CRIT_VALUE, 4331.0)), 4, List.of(new OverallAbsolutBuff(StatType.ATTACK_SPEED, 0.214)), 5, List.of(new OverallAbsolutBuff(StatType.MANA, 29.0))), 145),
    POISON_EXTINGUISHER("Poison Extinguisher", Map.of(2, List.of(new OverallDescriptionBuff("...")), 3, List.of(new OverallDescriptionBuff("..."))), 145),
    ;

    private final String name;
    private Map<Integer, List<OverallBuff>> setBonus;
    private List<Item> setItems;
    private int level;

    SpellweaverSets(String name, Map<Integer, List<OverallBuff>> setBonus, int level)
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
        //ANCESTRAL_GLORY.setItems = List.of(SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY, SpellweaverMythicItem.ANCESTRAL_GLORY_CLOAK);
        //BLACK_WARLORD_REGALIA.setItems = List.of(SpellweaverSetItems.HELMET_OF_THE_BLACK_KNIGHT, SpellweaverSetItems.SHOULDERS_OF_THE_BLACK_KNIGHT, SpellweaverSetItems.CLOAK_OF_THE_BLACK_KNIGHT);
        //END_OF_THE_EMPIRE.setItems = List.of(SpellweaverSetItems.HELMET_OF_THE_BLACK_KNIGHT, SpellweaverSetItems.SHOULDERS_OF_THE_BLACK_KNIGHT, SpellweaverSetItems.CLOAK_OF_THE_BLACK_KNIGHT);
        //FORGOTTON_GLORY.setItems = List.of(SpellweaverMythicItem.OLD_GLORY, SpellweaverMythicItem.RING_OF_OLD_GLORY);
        //MIGHTY_VISIONARY_SEEKER.setItems = List.of(SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_HELMET, SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_SHOULDERS, SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_TORSO, SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_GLOVES, SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_BOOTS, SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_CAPE);
        //SARGONS_IMMORTAL_TERROR_ARMOR.setItems = List.of(SpellweaverSetItems.SARGONS_HORNS, SpellweaverSetItems.SARGONS_PAULDRONS, SpellweaverSetItems.SARGONS_TORSO);
        //ENRAGED_EMPORER.setItems = List.of(SpellweaverSetItems.ARMOR_OF_THE_FLAME_CONQUEROR, SpellweaverSetItems.GLOVES_OF_THE_FLAME_CONQUEROR, SpellweaverSetItems.BOOTS_OF_THE_FLAME_CONQUEROR);
        //KRANPARUS_TREASURES.setItems = List.of(SpellweaverSetItems.KRANPARUS_ICY_AMULET, SpellweaverSetItems.KRANPARUS_ICY_CONJURING_BOOK, SpellweaverSetItems.KRANPARUS_ICY_STAFF);
        //AT_DEATHS_DOOR.setItems = List.of(SpellweaverSetItems.AMULET_OF_DEATH, SpellweaverSetItems.CAP_OF_DEATH);
        //BLACK_ESSENCE_ARMAMENT.setItems = List.of(SpellweaverSetItems.BLACK_ESSENCE_HELMET, SpellweaverSetItems.BLACK_ESSENCE_PAULDRONS, SpellweaverSetItems.BLACK_ESSENCE_ARMOR, SpellweaverSetItems.BLACK_ESSENCE_GLOVES, SpellweaverSetItems.BLACK_ESSENCE_BOOTS);
        //AUTOMATED_UNIT.setItems = List.of(SpellweaverSetItems.AUTOMATED_SKULLCAP, SpellweaverSetItems.AUTOMATED_SHOULDERGUARDS, SpellweaverSetItems.AUTOMATED_STERNUM_GUARD, SpellweaverSetItems.AUTOMATED_ARMGUARDS, SpellweaverSetItems.AUTOMATED_SHINGUARDS, SpellweaverSetItems.AUTOMATED_BELT, SpellweaverSetItems.AUTOMATED_ARKAN_STAFF);
        //POISON_EXTINGUISHER.setItems = List.of(SpellweaverSetItems.POISON_EXTINGUISHER_HAT, SpellweaverSetItems.POISON_EXTINGUISHER_GLOVES, SpellweaverSetItems.POISON_EXTINGUISHER_BOOTS);
    }

}
