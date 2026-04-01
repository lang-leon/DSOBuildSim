package com.langleon.dsobuildsim.items.core;

import com.langleon.dsobuildsim.character.CharacterClass;
import com.langleon.dsobuildsim.enchantments.EnchantmentFactory;
import com.langleon.dsobuildsim.enchantments.dto.EnchantmentDTO;
import com.langleon.dsobuildsim.gems.AbstractGem;
import com.langleon.dsobuildsim.gems.GemFactory;
import com.langleon.dsobuildsim.gems.dto.AbstractGemInstanceDTO;
import com.langleon.dsobuildsim.items.core.enums.ItemSlot;
import com.langleon.dsobuildsim.items.dto.ItemInstanceDTO;
import com.langleon.dsobuildsim.enchantments.Enchantment;
import com.langleon.dsobuildsim.gems.Gem;
import com.langleon.dsobuildsim.items.mythicitems.MythicItemType;
import com.langleon.dsobuildsim.items.setitems.SetItemType;
import com.langleon.dsobuildsim.items.uniqueitems.UniqueItemType;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class ItemResolver {

    private final ItemFactory itemFactory;
    private final GemFactory gemFactory;

    public ItemResolver(ItemFactory itemFactory, GemFactory gemFactory) {
        this.itemFactory = itemFactory;
        this.gemFactory = gemFactory;
    }

    public Item fromDTO(ItemInstanceDTO itemDTO, CharacterClass characterClass)
    {
        List<AbstractGem> gems = gemFactory.fromDTOList(itemDTO.gems());
        List<Enchantment> enchantments = EnchantmentFactory.fromDTOList(itemDTO.enchantments());

        switch (itemDTO.itemCategory())
        {
            case MYTHIC -> {
            return itemFactory.createItem((MythicItemType) itemDTO.itemType(), characterClass, itemDTO.baseValues(), itemDTO.level(), gems, enchantments);
        }
            case SET -> {
            return itemFactory.createItem((SetItemType) itemDTO.itemType(), characterClass, itemDTO.baseValues(), itemDTO.level(), gems, enchantments);
        }
            case UNIQUE -> {
            return itemFactory.createItem((UniqueItemType) itemDTO.itemType(), characterClass, itemDTO.baseValues(), itemDTO.level(), gems, enchantments, itemDTO.uniqueBaseValues(), EnchantmentFactory.fromDTOList(itemDTO.uniqueEnchantments()));
        }
            default -> throw new IllegalArgumentException("Invalid item category "+itemDTO.itemCategory());
        }
    }

    public Map<ItemSlot, Item> fromDTOMap(Map<ItemSlot, ItemInstanceDTO> itemDTOs, CharacterClass characterClass)
    {
        Map<ItemSlot, Item> items = new EnumMap<>(ItemSlot.class);

        itemDTOs.forEach((slot, dto) -> {
            items.put(slot, this.fromDTO(dto, characterClass));
        });

        return items;
    }
}
