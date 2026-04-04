package com.langleon.dsobuildsim.buffs;

import com.langleon.dsobuildsim.buffs.dto.BuffInstanceDTO;
import com.langleon.dsobuildsim.buffs.enums.PhysicType;
import com.langleon.dsobuildsim.buffs.enums.TonicType;

public class BuffResolver {

    private final BuffFactory buffFactory;

    public BuffResolver(BuffFactory buffFactory) {
        this.buffFactory = buffFactory;
    }

    public Tonic resolveTonic(BuffInstanceDTO buffDTO)
    {
        try
        {
            TonicType tonicType = TonicType.valueOf(buffDTO.type());
            return buffFactory.createTonic(tonicType, buffDTO.tier());
        }
        catch (IllegalArgumentException e)
        {
            throw new IllegalArgumentException("Unknown tonic type: " + buffDTO.type(), e);
        }
    }

    public Physic resolvePhysic(BuffInstanceDTO buffDTO)
    {
        try
        {
            PhysicType physicType = PhysicType.valueOf(buffDTO.type());
            return buffFactory.createPhysic(physicType, buffDTO.tier());
        }
        catch (IllegalArgumentException e)
        {
            throw new IllegalArgumentException("Unknown physic type: " + buffDTO.type(), e);
        }
    }
}
