package com.langleon.dsobuildsim.items.core;

import com.langleon.dsobuildsim.sets.SetType;

public interface SetBonusProvider {
    SetType getSetType();
    String getSetItemIdentifier();
}
