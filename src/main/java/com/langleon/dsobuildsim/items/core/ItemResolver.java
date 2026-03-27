package com.langleon.dsobuildsim.items.core;

import com.langleon.dsobuildsim.character.CharacterClass;
import com.langleon.dsobuildsim.enchantments.EnchantmentFactory;
import com.langleon.dsobuildsim.enchantments.dto.EnchantmentDTO;
import com.langleon.dsobuildsim.gems.AbstractGem;
import com.langleon.dsobuildsim.gems.GemFactory;
import com.langleon.dsobuildsim.gems.dto.AbstractGemInstanceDTO;
import com.langleon.dsobuildsim.items.dto.ItemDTO;
import com.langleon.dsobuildsim.enchantments.Enchantment;
import com.langleon.dsobuildsim.gems.Gem;
import com.langleon.dsobuildsim.items.mythicitems.MythicItemType;
import com.langleon.dsobuildsim.items.setitems.SetItemType;
import com.langleon.dsobuildsim.items.uniqueitems.UniqueItemType;

public class ItemResolver {

    private final ItemFactory itemFactory;
    private final GemFactory gemFactory;

    public ItemResolver(ItemFactory itemFactory, GemFactory gemFactory) {
        this.itemFactory = itemFactory;
        this.gemFactory = gemFactory;
    }

    public Item fromDTO(ItemDTO itemDTO, CharacterClass characterClass)
    {
        Item item;
        switch (itemDTO.itemCategory())
        {
            case MYTHIC -> item = itemFactory.createItem((MythicItemType) itemDTO.itemType(), characterClass, itemDTO.baseValues(), itemDTO.level());
            case SET -> item = itemFactory.createItem((SetItemType) itemDTO.itemType(), characterClass, itemDTO.baseValues(), itemDTO.level());
            case UNIQUE -> item = itemFactory.createItem((UniqueItemType) itemDTO.itemType(), characterClass, itemDTO.baseValues(), itemDTO.level(), itemDTO.uniqueBaseValues(), EnchantmentFactory.fromDTOList(itemDTO.uniqueEnchantments()));
            default -> throw new IllegalArgumentException("Invalid item category "+itemDTO.itemCategory());
        }

        AbstractGem[] gems = new Gem[10];
        if (itemDTO.gems() != null)
        {
            for (int i=0; i < itemDTO.gems().length && i < 10; i++)
            {
                AbstractGemInstanceDTO gemDTO = itemDTO.gems()[i];
                if (gemDTO != null) gems[i] = gemFactory.fromDTO(gemDTO);
            }
        }
        item.setGems(gems);

        Enchantment[] enchantments = new Enchantment[10];
        if (itemDTO.gems() != null)
        {
            for (int i=0; i < itemDTO.gems().length && i < 10; i++)
            {
                EnchantmentDTO enchantmentDTO = itemDTO.enchantments()[i];
                if (enchantmentDTO != null) enchantments[i] = EnchantmentFactory.fromDTO(enchantmentDTO);
            }
        }
        item.setEnchantments(enchantments);

        return item;
    }
}
