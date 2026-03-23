package com.langleon.dsobuildsim.wisdomskilltree.wisdomgroup;

import java.util.EnumMap;

public record WisdomGroupConfig(EnumMap<WisdomGroupType, WisdomGroupDefinition> wisdomGroups) {
}
