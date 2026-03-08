package com.langleon.dsobuildsim.jewels;

import com.langleon.dsobuildsim.character.CharacterClass;

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

    public Jewel createJewel(JewelType jewelType, CharacterClass characterClass)
    {
        JewelDefinition jewelDefinition = null;
        switch (characterClass)
        {
            case SPELLWEAVER -> jewelDefinition = this.config.spellweaverJewels().get(jewelType);
            case DRAGONKNIGHT -> jewelDefinition = this.config.dragonknightJewels().get(jewelType);
            case RANGER -> jewelDefinition = this.config.rangerJewels().get(jewelType);
            case STEAM_MECHANICUS -> jewelDefinition = this.config.steamMechanicusJewels().get(jewelType);
        }
        int tier = jewelDefinition.defaultTier();
        return new Jewel(jewelType, tier, jewelDefinition.statsPerTier().getOrDefault(tier, Map.of()), jewelDefinition.descriptionPerTier().get(tier));
    }

    public Jewel createJewel(JewelType jewelType, CharacterClass characterClass, int tier)
    {
        JewelDefinition jewelDefinition = null;
        switch (characterClass)
        {
            case SPELLWEAVER -> jewelDefinition = this.config.spellweaverJewels().get(jewelType);
            case DRAGONKNIGHT -> jewelDefinition = this.config.dragonknightJewels().get(jewelType);
            case RANGER -> jewelDefinition = this.config.rangerJewels().get(jewelType);
            case STEAM_MECHANICUS -> jewelDefinition = this.config.steamMechanicusJewels().get(jewelType);
        }
        Map<Integer, String> description = jewelDefinition.descriptionPerTier();
        if (description.get(tier) == null)
            throw new IllegalArgumentException("Invalid jewel tier: " + tier + "!");
        return new Jewel(jewelType, tier, jewelDefinition.statsPerTier().getOrDefault(tier, Map.of()), jewelDefinition.descriptionPerTier().get(tier));
    }
}
