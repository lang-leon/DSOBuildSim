package com.langleon.dsobuildsim.jewels;

import com.langleon.dsobuildsim.character.CharacterClass;
import com.langleon.dsobuildsim.jewels.dto.JewelInstanceDTO;
import com.langleon.dsobuildsim.jewels.dto.JewelTrinketDTO;

import java.util.List;
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

    public Jewel fromDTO(JewelInstanceDTO jewelDTO, CharacterClass characterClass)
    {
        try
        {
            return this.createJewel(jewelDTO.jewelType(), characterClass, jewelDTO.tier());
        }
        catch (IllegalArgumentException e)
        {
            throw new IllegalArgumentException("Unknown jewel type: " + jewelDTO.jewelType(), e);
        }
    }

    public List<Jewel> fromDTOList(List<JewelInstanceDTO> jewelDTOs, CharacterClass characterClass)
    {
        if (jewelDTOs==null) return List.of();
        return jewelDTOs.stream().map(dto -> fromDTO(dto, characterClass)).toList();
    }

    public JewelTrinket fromTrinketDTO(JewelTrinketDTO jewelTrinketDTO, CharacterClass characterClass){
        return new JewelTrinket(this.fromDTOList(jewelTrinketDTO.jewels(), characterClass));
    }

    public List<JewelTrinket> fromTrinketDTOs(List<JewelTrinketDTO> jewelTrinketDTOs, CharacterClass characterClass)
    {
        return jewelTrinketDTOs.stream().map(dto -> fromTrinketDTO(dto, characterClass)).toList();
    }
}
