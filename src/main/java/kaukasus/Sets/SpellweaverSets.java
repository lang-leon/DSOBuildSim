package kaukasus.Sets;

import kaukasus.Enums.AbsoluteStatTypeEnum;
import kaukasus.Items.ItemDatabase.Item;
import kaukasus.Items.ItemDatabase.MythicItems.SpellweaverMythicItem;
import kaukasus.Items.ItemDatabase.SetItems.SpellweaverSetItems;
import kaukasus.OverallBuffs.OverallAbsolutBuff;
import kaukasus.OverallBuffs.OverallBuff;
import kaukasus.OverallBuffs.OverallDescriptionBuff;

import java.awt.datatransfer.FlavorEvent;
import java.util.List;
import java.util.Map;

public enum SpellweaverSets implements SetEnumInterface {

    SET1("Forgotton Glory", Map.of(), -1),
    ANCESTRAL_GLORY("Forgotton Glory", Map.of(2, List.of(new OverallDescriptionBuff("..."))), 145),
    FORGOTTON_GLORY("Forgotton Glory", Map.of(2, List.of(new OverallDescriptionBuff("..."))), 145),
    MIGHTY_VISIONARY_SEEKER("Mighty Visionary Seeker", Map.of(2, List.of(new OverallAbsolutBuff(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.79)), 4, List.of(new OverallAbsolutBuff(AbsoluteStatTypeEnum.DAMAGE, 8657.0)), 6, List.of(new OverallAbsolutBuff(AbsoluteStatTypeEnum.MANA, 68.0), new OverallDescriptionBuff("..."))), 140),
    SARGONS_IMMORTAL_TERROR_ARMOR("Sargon's Immortal Terror Armor", Map.of(2, List.of(new OverallAbsolutBuff(AbsoluteStatTypeEnum.DAMAGE, 2776.0)), 3, List.of(new OverallAbsolutBuff(AbsoluteStatTypeEnum.HEALTH_POINTS, 33347.0), new OverallAbsolutBuff(AbsoluteStatTypeEnum.DAMAGE, 5553.0))), 145),;


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
        ANCESTRAL_GLORY.setItems = List.of(SpellweaverMythicItem.RING_OF_ANCESTRAL_GLORY, SpellweaverMythicItem.ANCESTRAL_GLORY_CLOAK);
        FORGOTTON_GLORY.setItems = List.of(SpellweaverMythicItem.OLD_GLORY, SpellweaverMythicItem.RING_OF_OLD_GLORY);
        MIGHTY_VISIONARY_SEEKER.setItems = List.of(SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_HELMET, SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_SHOULDERS, SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_TORSO, SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_GLOVES, SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_BOOTS, SpellweaverSetItems.MIGHTY_WRATHFUL_SEEKERS_CAPE);
        SARGONS_IMMORTAL_TERROR_ARMOR.setItems = List.of(SpellweaverSetItems.SARGONS_HORNS, SpellweaverSetItems.SARGONS_PAULDRONS, SpellweaverSetItems.SARGONS_TORSO);
    }

}
