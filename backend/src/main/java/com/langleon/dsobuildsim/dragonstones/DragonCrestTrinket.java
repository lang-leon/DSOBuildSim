package com.langleon.dsobuildsim.dragonstones;

import com.langleon.dsobuildsim.common.StatType;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class DragonCrestTrinket {

    private final List<DragonStone> dragonStones;

    public DragonCrestTrinket(List<DragonStone> dragonStones) {
        if (dragonStones.size() > 10) throw new IllegalArgumentException("Dragon Crest can only hold 10 Dragon Stones.");
        this.dragonStones = List.copyOf(dragonStones);
    }

    public List<DragonStone> getDragonStones() {
        return dragonStones;
    }

    public Map<StatType, Double> getTotalRelativeStats()
    {
        return dragonStones.stream()
                .filter(Objects::nonNull)
                .flatMap(ds -> ds.stats().entrySet().stream())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        Double::sum,
                        () -> new EnumMap<>(StatType.class)
                ));
    }
}
