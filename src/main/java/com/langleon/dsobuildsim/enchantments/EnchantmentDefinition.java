package com.langleon.dsobuildsim.enchantments;

import com.langleon.dsobuildsim.common.StatType;

public record EnchantmentDefinition(StatType statType, Double value)
{
    public Enchantment toEnchantment()
    {
        if (value != null && statType != null)
        {
            return new Enchantment(statType, value);
        }
        else
        {
            throw new IllegalArgumentException("StatType or Value is null");
        }
    }
}
