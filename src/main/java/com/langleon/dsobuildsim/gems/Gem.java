package com.langleon.dsobuildsim.gems;

import com.langleon.dsobuildsim.enums.AbsoluteStatType;

public class Gem extends AbstractGem{
    public Gem(AbsoluteStatType type, Double value) {
        super.type = type;
        super.value = value;
    }

    @Override
    public Gem copyGem()
    {
        return new Gem(this.type, this.value);
    }


}
