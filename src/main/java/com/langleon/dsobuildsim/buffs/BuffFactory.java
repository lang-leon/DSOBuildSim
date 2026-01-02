package com.langleon.dsobuildsim.buffs;
import com.langleon.dsobuildsim.enums.buffs.PhysicType;
import com.langleon.dsobuildsim.enums.buffs.TonicType;

public class BuffFactory {
    private final BuffConfig config;

    public BuffFactory(BuffConfig config) {
        this.config = config;
    }

    public Tonic createTonic(TonicType tonicType, int tier)
    {
        TonicDefinition tonicDefinition = this.config.tonics().get(tonicType);
        if (!tonicDefinition.statsPerTier().containsKey(tier)) throw new IllegalArgumentException("Invalid pet tier: " + tier + "!");
        return new Tonic(tonicType, tonicDefinition.statType(), tonicDefinition.statsPerTier().get(tier), tier);
    }

    public Tonic createTonic(TonicType tonicType)
    {
        TonicDefinition tonicDefinition = this.config.tonics().get(tonicType);
        return new Tonic(tonicType, tonicDefinition.statType(), tonicDefinition.statsPerTier().get(tonicDefinition.defaultTier()), tonicDefinition.defaultTier());
    }

    public Physic createPhysic(PhysicType physicType, int tier)
    {
        PhysicDefinition physicDefinition = this.config.physics().get(physicType);
        if (!physicDefinition.statsPerTier().containsKey(tier)) throw new IllegalArgumentException("Invalid pet tier: " + tier + "!");
        return new Physic(physicType, physicDefinition.statType(), physicDefinition.statsPerTier().get(tier), tier);
    }

    public Physic createPhysic(PhysicType physicType)
    {
        PhysicDefinition physicDefinition = this.config.physics().get(physicType);
        return new Physic(physicType, physicDefinition.statType(), physicDefinition.statsPerTier().get(physicDefinition.defaultTier()), physicDefinition.defaultTier());
    }
}
