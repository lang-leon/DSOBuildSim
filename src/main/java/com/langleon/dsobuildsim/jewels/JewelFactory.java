package com.langleon.dsobuildsim.jewels;

import com.langleon.dsobuildsim.character.CharacterClass;
import com.langleon.dsobuildsim.gamedata.GameDataConfig;
import com.langleon.dsobuildsim.jewels.dto.JewelInstanceDTO;
import com.langleon.dsobuildsim.jewels.dto.JewelTrinketDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class JewelFactory {
    private final Map<CharacterClass, Map<JewelType, JewelDefinition>> jewels;

    public JewelFactory(GameDataConfig config) {
        this.jewels = config.jewels();
    }

    public Jewel createJewel(JewelType jewelType, CharacterClass characterClass, int tier)
    {
        JewelDefinition jewelDefinition = this.jewels.get(characterClass).get(jewelType);
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
