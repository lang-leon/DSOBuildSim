package com.langleon.dsobuildsim.jewels;

import com.langleon.dsobuildsim.enums.CharacterClass;
import com.langleon.dsobuildsim.enums.jewels.JewelType;

import java.util.Map;

public class JewelFactory {
    private final JewelConfig config;

    public JewelFactory(JewelConfig config) {
        this.config = config;
    }

    public int getUpgradeCost(Jewel jewel)
    {
        return this.config.upgradeCosts().get(jewel.getTier());
    }

    public Jewel createJewel(JewelType jewelType, int tier)
    {
        JewelDefinition jewelDefinition = this.config.jewels().get(jewelType);
        Map<Integer, String> descriptionSpellweaver = jewelDefinition.descriptionPerClassPerTier().get(CharacterClass.SPELLWEAVER);
        Map<Integer, String> descriptionDragonknight = jewelDefinition.descriptionPerClassPerTier().get(CharacterClass.DRAGONKNIGHT);
        Map<Integer, String> descriptionRanger = jewelDefinition.descriptionPerClassPerTier().get(CharacterClass.RANGER);
        Map<Integer, String> descriptionSteamMechanicus = jewelDefinition.descriptionPerClassPerTier().get(CharacterClass.STEAM_MECHANICUS);
        if (descriptionSpellweaver.get(tier) == null && descriptionDragonknight.get(tier) == null && descriptionRanger.get(tier) == null && descriptionSteamMechanicus.get(tier) == null)
            throw new IllegalArgumentException("Invalid jewel tier: " + tier + "!");
        return new Jewel(jewelType, tier, jewelDefinition.statsPerTier().getOrDefault(tier, Map.of()), jewelDefinition.descriptionPerClassPerTier().get(CharacterClass.SPELLWEAVER).get(tier));
    }

    public Jewel createJewel(JewelType jewelType, int tier, CharacterClass characterClass)
    {
        JewelDefinition jewelDefinition = this.config.jewels().get(jewelType);
        Map<Integer, String> descriptionSpellweaver = jewelDefinition.descriptionPerClassPerTier().get(CharacterClass.SPELLWEAVER);
        Map<Integer, String> descriptionDragonknight = jewelDefinition.descriptionPerClassPerTier().get(CharacterClass.DRAGONKNIGHT);
        Map<Integer, String> descriptionRanger = jewelDefinition.descriptionPerClassPerTier().get(CharacterClass.RANGER);
        Map<Integer, String> descriptionSteamMechanicus = jewelDefinition.descriptionPerClassPerTier().get(CharacterClass.STEAM_MECHANICUS);
        if (descriptionSpellweaver.get(tier) == null && descriptionDragonknight.get(tier) == null && descriptionRanger.get(tier) == null && descriptionSteamMechanicus.get(tier) == null)
            throw new IllegalArgumentException("Invalid jewel tier: " + tier + "!");
        return new Jewel(jewelType, tier, jewelDefinition.statsPerTier().getOrDefault(tier, Map.of()), jewelDefinition.descriptionPerClassPerTier().get(characterClass).get(tier));
    }
}
