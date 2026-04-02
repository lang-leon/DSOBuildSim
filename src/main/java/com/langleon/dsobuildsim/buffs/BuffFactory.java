package com.langleon.dsobuildsim.buffs;
import com.langleon.dsobuildsim.buffs.dto.BuffInstanceDTO;
import com.langleon.dsobuildsim.buffs.enums.PhysicType;
import com.langleon.dsobuildsim.buffs.enums.TonicType;
import com.langleon.dsobuildsim.gamedata.GameDataConfig;
import org.springframework.stereotype.Component;

@Component
public class BuffFactory {
    private final BuffConfig config;

    public BuffFactory(GameDataConfig config) {
        this.config = config.buffConfig();
    }

    public Tonic createTonic(TonicType tonicType, int tier)
    {
        TonicDefinition tonicDefinition = this.config.tonics().get(tonicType);
        if (!tonicDefinition.statsPerTier().containsKey(tier)) throw new IllegalArgumentException("Invalid pet defaultTier: " + tier + "!");
        return new Tonic(tonicType, tonicDefinition.statType(), tonicDefinition.statsPerTier().get(tier), tier);
    }

    public Tonic createTonic(TonicType tonicType)
    {
        TonicDefinition tonicDefinition = this.config.tonics().get(tonicType);
        return new Tonic(tonicType, tonicDefinition.statType(), tonicDefinition.statsPerTier().get(tonicDefinition.defaultTier()), tonicDefinition.defaultTier());
    }

    public Tonic tonicFromDTO(BuffInstanceDTO dto)
    {
        return this.createTonic(TonicType.valueOf(dto.type()), dto.tier());
    }

    public Physic createPhysic(PhysicType physicType, int tier)
    {
        PhysicDefinition physicDefinition = this.config.physics().get(physicType);
        if (!physicDefinition.statsPerTier().containsKey(tier)) throw new IllegalArgumentException("Invalid pet defaultTier: " + tier + "!");
        return new Physic(physicType, physicDefinition.statType(), physicDefinition.statsPerTier().get(tier), tier);
    }

    public Physic createPhysic(PhysicType physicType)
    {
        PhysicDefinition physicDefinition = this.config.physics().get(physicType);
        return new Physic(physicType, physicDefinition.statType(), physicDefinition.statsPerTier().get(physicDefinition.defaultTier()), physicDefinition.defaultTier());
    }

    public Physic physicFromDTO(BuffInstanceDTO dto)
    {
        return this.createPhysic(PhysicType.valueOf(dto.type()), dto.tier());
    }
}
