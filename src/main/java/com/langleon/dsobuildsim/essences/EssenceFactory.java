package com.langleon.dsobuildsim.essences;

import com.langleon.dsobuildsim.essences.dto.EssenceInstanceDTO;
import com.langleon.dsobuildsim.gamedata.GameDataConfig;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class EssenceFactory {
    private final Map<EssenceType, EssenceDefinition> essences;

    public EssenceFactory(GameDataConfig config) {
        this.essences = config.essences();
    }

    public Essence createEssence(EssenceType essenceType, int tier){
        EssenceDefinition essenceDefinition = essences.get(essenceType);
        if (!essenceDefinition.damagePerTier().containsKey(tier)) throw new IllegalArgumentException("Invalid pet tier: " + tier + "!");
        return new Essence(essenceType, tier, essenceDefinition.damagePerTier().get(tier), essenceDefinition.descriptionPerTier().get(tier));
    }

    public Essence fromDTO(EssenceInstanceDTO essenceDTO)
    {
        try
        {
            EssenceType essenceType = essenceDTO.essenceType();
            return this.createEssence(essenceType, essenceDTO.tier());
        }
        catch (IllegalArgumentException e)
        {
            throw new IllegalArgumentException("Unknown essence type: " + essenceDTO.essenceType(), e);
        }
    }
}
