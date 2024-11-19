package kaukasus.Gems;

import kaukasus.Enums.AbsoluteStatTypeEnum;

public class Gem extends AbstractGem{
    public Gem(AbsoluteStatTypeEnum type, Double value) {
        super.type = type;
        super.value = value;
    }

    @Override
    public Gem copyGem()
    {
        return new Gem(this.type, this.value);
    }


}
