package com.langleon.dsobuildsim.resolver;

import com.langleon.dsobuildsim.enchantments.EnchantmentFactory;
import com.langleon.dsobuildsim.enchantments.dto.EnchantmentDTO;
import com.langleon.dsobuildsim.dto.GemDTO;
import com.langleon.dsobuildsim.dto.ItemDTO;
import com.langleon.dsobuildsim.enchantments.Enchantment;
import com.langleon.dsobuildsim.gems.Gem;
import com.langleon.dsobuildsim.items.core.Item;
import com.langleon.dsobuildsim.items.core.ItemFactory;
import com.langleon.dsobuildsim.items.mythicitems.MythicItemType;
import com.langleon.dsobuildsim.items.setitems.SetItemType;
import com.langleon.dsobuildsim.items.uniqueitems.UniqueItemType;

public class ItemResolver {

    private final ItemFactory itemFactory;
    private final GemResolver gemResolver;

    public ItemResolver(ItemFactory itemFactory, GemResolver gemResolver) {
        this.itemFactory = itemFactory;
        this.gemResolver = gemResolver;
    }

    public Item resolveItem(ItemDTO itemDTO)
    {
        Item item;
        switch (itemDTO.itemCategory())
        {
            case MYTHIC -> item = itemFactory.createItem((MythicItemType) itemDTO.itemType(), itemDTO.characterClass(), itemDTO.baseValues(), itemDTO.level());
            case SET -> item = itemFactory.createItem((SetItemType) itemDTO.itemType(), itemDTO.characterClass(), itemDTO.baseValues(), itemDTO.level());
            case UNIQUE -> item = itemFactory.createItem((UniqueItemType) itemDTO.itemType(), itemDTO.characterClass(), itemDTO.baseValues(), itemDTO.level(), itemDTO.uniqueBaseValues(), EnchantmentFactory.fromDTOList(itemDTO.uniqueEnchantments()));
            default -> throw new IllegalArgumentException("Invalid item category "+itemDTO.itemCategory());
        }

        Gem[] gems = new Gem[10];
        if (itemDTO.gems() != null)
        {
            for (int i=0; i < itemDTO.gems().length && i < 10; i++)
            {
                GemDTO gemDTO = itemDTO.gems()[i];
                if (gemDTO != null) gems[i] = gemResolver.resolveGem(gemDTO);
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
