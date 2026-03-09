package com.langleon.dsobuildsim.resolver;

import com.langleon.dsobuildsim.buffs.BuffFactory;
import com.langleon.dsobuildsim.buffs.Physic;
import com.langleon.dsobuildsim.buffs.Tonic;
import com.langleon.dsobuildsim.buffs.enums.PhysicType;
import com.langleon.dsobuildsim.buffs.enums.TonicType;
import com.langleon.dsobuildsim.dto.BuffDTO;

public class BuffResolver {

    private final BuffFactory buffFactory;

    public BuffResolver(BuffFactory buffFactory) {
        this.buffFactory = buffFactory;
    }

    public Tonic resolveTonic(BuffDTO buffDTO)
    {
        try
        {
            TonicType tonicType = TonicType.valueOf(buffDTO.type());
            return buffFactory.createTonic(tonicType, buffDTO.tier());
        }
        catch (IllegalArgumentException e)
        {
            throw new IllegalArgumentException("Unknown physic type: " + buffDTO.type(), e);
        }
    }

    public Physic resolvePhysic(BuffDTO buffDTO)
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
