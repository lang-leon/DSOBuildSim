package com.langleon.dsobuildsim.enchantments;

public record EnchantmentDefinition(EnchantmentType enchantmentType, Double value)
{
    public Enchantment toEnchantment()
    {
        if (value != null && enchantmentType != null)
        {
            return new Enchantment(enchantmentType, value);
        }
        else
        {
            throw new IllegalArgumentException("Either EnchantmentType or Value is null");
        }
    }
}
