package com.langleon.dsobuildsim.buffs;

import com.langleon.dsobuildsim.buffs.enums.PhysicType;
import com.langleon.dsobuildsim.buffs.enums.TonicType;

import java.util.Map;

public record BuffConfig(Map<TonicType, TonicDefinition> tonics, Map<PhysicType, PhysicDefinition> physics) {
}
