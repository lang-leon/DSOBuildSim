package com.langleon.dsobuildsim.essences;

import java.util.Map;

public record EssenceDefinition(EssenceType essenceType, int defaultTier, Map<Integer, Double> damagePerTier, Map<Integer, String> descriptionPerTier)
{
}
