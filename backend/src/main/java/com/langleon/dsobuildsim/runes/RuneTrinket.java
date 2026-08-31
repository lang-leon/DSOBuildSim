package com.langleon.dsobuildsim.runes;

import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.exceptions.LimitExceededException;
import com.langleon.dsobuildsim.exceptions.LimitType;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class RuneTrinket {

    private final List<Rune> runes;

    public RuneTrinket(List<Rune> runes) {
        if (runes.size() > 10) throw new LimitExceededException(LimitType.RUNE_TRINKET, "Rune Trinket can only hold up to 10 runes.");
        this.runes = runes;
    }

    public List<Rune> getRunes() {
        return runes;
    }

    public Map<StatType, Double> getTotalRelativeStats()
    {
        return runes.stream()
                .filter(Objects::nonNull)
                .flatMap(rn -> rn.getStats().entrySet().stream())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        Double::sum,
                        () -> new EnumMap<>(StatType.class)
                ));
    }
}
