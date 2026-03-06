package com.langleon.dsobuildsim.utils;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapUtils {

    private MapUtils() {} //prevent instantiation

    public static <K,V> void replaceExisting(Map<K,V> target, Map<K,V> updates)
    {
        if (!target.keySet().containsAll(updates.keySet()))
        {
            Set<K> missing = new HashSet<>(updates.keySet());
            missing.removeAll(target.keySet());
            throw new IllegalArgumentException("Cannot update keys "+missing+", because they don't exist.");
        }
        target.putAll(updates);
    }
}
