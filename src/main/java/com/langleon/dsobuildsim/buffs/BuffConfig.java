package com.langleon.dsobuildsim.buffs;

import com.langleon.dsobuildsim.enums.buffs.PhysicType;
import com.langleon.dsobuildsim.enums.buffs.TonicType;

import java.util.Map;

public record BuffConfig(Map<TonicType, TonicDefinition> tonics, Map<PhysicType, PhysicDefinition> physics) {
}
