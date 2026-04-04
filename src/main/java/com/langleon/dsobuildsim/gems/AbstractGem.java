package com.langleon.dsobuildsim.gems;

import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.gems.enums.GemLimitGroup;
import com.langleon.dsobuildsim.gems.enums.GemType;
import com.langleon.dsobuildsim.gems.enums.GemUpgradeType;

import java.util.Map;
import java.util.Objects;

public abstract class AbstractGem {

    protected GemType gemType;
    protected GemLimitGroup gemLimitGroup;
    protected int tier;
    protected Map<StatType, Double> stats;

    public GemType getGemType() {
        return gemType;
    }

    public int getTier() {
        return tier;
    }

    public GemLimitGroup getGemLimitGroup() {
        return gemLimitGroup;
    }

    public Map<StatType, Double> getStats() {
        return stats;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AbstractGem that = (AbstractGem) o;
        return tier == that.tier && Objects.equals(gemType, that.gemType) && Objects.equals(stats, that.stats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gemType, tier, stats);
    }
}
