package com.langleon.dsobuildsim.essences;

import com.langleon.dsobuildsim.enums.essences.EssenceType;

public record Essence(EssenceType essenceType, int tier, double damageIncrease, String description) {
}
