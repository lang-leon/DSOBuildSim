package com.langleon.dsobuildsim.mapper;

import com.langleon.dsobuildsim.enchantments.EnchantmentMapper;
import com.langleon.dsobuildsim.enchantments.dto.EnchantmentDTO;
import com.langleon.dsobuildsim.dto.ItemDefinitionDTO;
import com.langleon.dsobuildsim.items.core.ItemDefinition;
import com.langleon.dsobuildsim.items.core.enums.ItemCategory;
import com.langleon.dsobuildsim.items.mythicitems.MythicItemDefinition;
import com.langleon.dsobuildsim.items.setitems.SetItemDefinition;
import com.langleon.dsobuildsim.items.uniqueitems.UniqueItemDefinition;

import java.util.Set;
import java.util.stream.Collectors;

public class ItemDefinitionMapper {

    public static ItemDefinitionDTO from(ItemDefinition itemDefinition)
    {
        if (itemDefinition instanceof UniqueItemDefinition unique) {
            return from(unique);
        } else if (itemDefinition instanceof SetItemDefinition set) {
            return from(set);
        } else if (itemDefinition instanceof MythicItemDefinition mythic) {
            return from(mythic);
        } else {
            throw new IllegalArgumentException("Unknown ItemDefinition type: " + itemDefinition.getClass());
        }
    }

    public static ItemDefinitionDTO from(MythicItemDefinition itemDefinition)
    {
        return new ItemDefinitionDTO(ItemCategory.MYTHIC, itemDefinition.itemType(), itemDefinition.name(), itemDefinition.defaultLevel(), itemDefinition.tier(), itemDefinition.itemSlotType(), itemDefinition.rawBaseValues(),
                null, itemDefinition.uniqueRelativeValues(), itemDefinition.uniqueAbsoluteValues(), null, null, itemDefinition.set());
    }

    public static ItemDefinitionDTO from(SetItemDefinition itemDefinition)
    {
        return new ItemDefinitionDTO(ItemCategory.MYTHIC, itemDefinition.itemType(), itemDefinition.name(), itemDefinition.defaultLevel(), itemDefinition.tier(), itemDefinition.itemSlotType(), itemDefinition.rawBaseValues(),
                null, null, null, null, null, itemDefinition.set());
    }

    public static ItemDefinitionDTO from(UniqueItemDefinition itemDefinition)
    {
        Set<EnchantmentDTO> enchantments = itemDefinition.uniqueEnchantments().stream()
                .map(EnchantmentMapper::from)
                .collect(Collectors.toSet());
        return new ItemDefinitionDTO(ItemCategory.MYTHIC, itemDefinition.itemType(), itemDefinition.name(), itemDefinition.defaultLevel(), itemDefinition.tier(), itemDefinition.itemSlotType(), itemDefinition.rawBaseValues(),
                itemDefinition.uniqueBaseValues(), itemDefinition.uniqueRelativeValues(), null, enchantments, itemDefinition.uniqueDescription(), null);
    }
}
