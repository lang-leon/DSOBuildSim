package kaukasus.Sets;

import kaukasus.Enums.AbsoluteStatTypeEnum;
import kaukasus.Enums.OverallRelativeBuffTypeEnum;
import kaukasus.Items.ItemDatabase.Item;
import kaukasus.Items.ItemDatabase.MythicItems.DragonknightMythicItem;
import kaukasus.Items.ItemDatabase.SetItems.DragonknightSetItems;
import kaukasus.OverallBuffs.OverallAbsolutBuff;
import kaukasus.OverallBuffs.OverallBuff;
import kaukasus.OverallBuffs.OverallDescriptionBuff;
import kaukasus.OverallBuffs.OverallRelativeBuff;

import java.util.List;
import java.util.Map;

public enum DragonknightSets implements SetEnumInterface {

    ANCESTRAL_GLORY("Forgotton Glory", Map.of(2, List.of(new OverallDescriptionBuff("..."))), 145),
    BLACK_WARLORD_REGALIA("Black Warlord Regalia",Map.of(1, List.of(new OverallRelativeBuff(OverallRelativeBuffTypeEnum.HEALTH_POINTS, 0.15), new OverallRelativeBuff(OverallRelativeBuffTypeEnum.ARMOR, 0.20)), 2, List.of(new OverallRelativeBuff(OverallRelativeBuffTypeEnum.CRIT_VALUE, 0.075), new OverallDescriptionBuff("Doubles the amount of dropped quest items for side quests.")), 3, List.of(new OverallRelativeBuff(OverallRelativeBuffTypeEnum.DAMAGE, 0.075), new OverallDescriptionBuff("..."))), 145),
    FORGOTTON_GLORY("Forgotton Glory", Map.of(2, List.of(new OverallDescriptionBuff("..."))), 145),
    MIGHTY_VISIONARY_SEEKER("Mighty Visionary Seeker", Map.of(2, List.of(new OverallAbsolutBuff(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.79)), 4, List.of(new OverallAbsolutBuff(AbsoluteStatTypeEnum.DAMAGE, 8657.0)), 6, List.of(new OverallAbsolutBuff(AbsoluteStatTypeEnum.MANA, 68.0), new OverallDescriptionBuff("..."))), 140),
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
        BLACK_WARLORD_REGALIA.setItems = List.of(DragonknightSetItems.HELMET_OF_THE_BLACK_KNIGHT, DragonknightSetItems.SHOULDERS_OF_THE_BLACK_KNIGHT, DragonknightSetItems.CLOAK_OF_THE_BLACK_KNIGHT);
        FORGOTTON_GLORY.setItems = List.of(DragonknightMythicItem.OLD_GLORY, DragonknightMythicItem.RING_OF_OLD_GLORY);
        MIGHTY_VISIONARY_SEEKER.setItems = List.of(DragonknightSetItems.MIGHTY_WRATHFUL_SEEKERS_HELMET, DragonknightSetItems.MIGHTY_WRATHFUL_SEEKERS_SHOULDERS, DragonknightSetItems.MIGHTY_WRATHFUL_SEEKERS_TORSO, DragonknightSetItems.MIGHTY_WRATHFUL_SEEKERS_GLOVES, DragonknightSetItems.MIGHTY_WRATHFUL_SEEKERS_BOOTS, DragonknightSetItems.MIGHTY_WRATHFUL_SEEKERS_CAPE);
    }
}
