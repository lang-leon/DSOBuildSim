package kaukasus.Items;

import kaukasus.Enums.AbsoluteStatTypeEnum;
import kaukasus.Gems.AbstractGem;

import java.util.Map;

public class MythicItem extends AbstractItem{
    @Override
    public void addGem(AbstractGem gem) {

    }

    @Override
    public void removeGem(AbstractGem gem) {

    }

    @Override
    public Map<AbsoluteStatTypeEnum, Double> calculateTotalStats() {
        return Map.of();
    }
}

