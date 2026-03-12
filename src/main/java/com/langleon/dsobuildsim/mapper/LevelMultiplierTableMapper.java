package com.langleon.dsobuildsim.mapper;

import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.dto.LevelMultiplierTableDTO;
import com.langleon.dsobuildsim.items.core.LevelMultiplierTable;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;

public class LevelMultiplierTableMapper {

    public static LevelMultiplierTableDTO from(LevelMultiplierTable table)
    {
        if (table == null) return new LevelMultiplierTableDTO(Map.of());

        Map<Integer, Map<StatType, Double>> mapped =
                table.getMultipliersPerLevel().entrySet().stream()
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                e -> new EnumMap<>(e.getValue()) // convert EnumMap -> Map for JSON
                        ));

        return new LevelMultiplierTableDTO(mapped);
    }
}
