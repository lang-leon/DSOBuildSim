package com.langleon.dsobuildsim.essences;

import com.langleon.dsobuildsim.enums.essences.EssenceType;

import java.util.Map;

public record EssenceConfig(Map<EssenceType, EssenceDefinition> essences) {
}
