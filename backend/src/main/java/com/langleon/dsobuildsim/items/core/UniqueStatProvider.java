package com.langleon.dsobuildsim.items.core;

import com.langleon.dsobuildsim.common.StatType;

import java.util.Map;

public interface UniqueStatProvider {
    Map<StatType, Double> getUniqueRelativeValues();
}
