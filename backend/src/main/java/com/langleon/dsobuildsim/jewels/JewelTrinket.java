package com.langleon.dsobuildsim.jewels;

import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.exceptions.LimitExceededException;
import com.langleon.dsobuildsim.exceptions.LimitType;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class JewelTrinket {

    private final List<Jewel> jewels;

    public JewelTrinket(List<Jewel> jewels) {
        if (jewels.size() > 10) throw new LimitExceededException(LimitType.JEWEL_TRINKET, "Jewel Trinket can only hold up to 10 jewels.");
        this.jewels = jewels;
    }

    public List<Jewel> getJewels() {
        return jewels;
    }

    public Map<StatType, Double> getTotalRelativeStats()
    {
        return jewels.stream()
                .filter(Objects::nonNull)
                .flatMap(jw -> jw.getStats().entrySet().stream())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        Double::sum,
                        () -> new EnumMap<>(StatType.class)
                ));
    }
}
