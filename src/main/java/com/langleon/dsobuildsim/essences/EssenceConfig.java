package com.langleon.dsobuildsim.essences;

import java.util.Map;

public record EssenceConfig(Map<EssenceType, EssenceDefinition> essences) {
}
