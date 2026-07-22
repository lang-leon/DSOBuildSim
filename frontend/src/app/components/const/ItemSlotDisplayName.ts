import { CharacterClass } from "../../enums/CharacterClass";
import { ItemSlot } from "../../enums/ItemSlot";

export const ItemSlotDisplayName: Record<ItemSlot, string> = {
    [ItemSlot.AMULET]: 'Amulet',
    [ItemSlot.CLOAK]: 'Cloak',
    [ItemSlot.BELT]: 'Belt',

    [ItemSlot.RING1]: 'Ring 1',
    [ItemSlot.RING2]: 'Ring 2',

    [ItemSlot.HELMET]: 'Helmet',
    [ItemSlot.SHOULDERS]: 'Shoulders',
    [ItemSlot.TORSO]: 'Torso',
    [ItemSlot.GLOVES]: 'Gloves',
    [ItemSlot.BOOTS]: 'Boots',

    [ItemSlot.WEAPON_ADORNMENT]: 'Weapon Adornment',
    [ItemSlot.ONE_HAND_WEAPON]: 'One-Handed Weapon',
    [ItemSlot.OFF_HAND]: 'Off-Hand',
    [ItemSlot.TWO_HAND_WEAPON]: 'Two-Handed Weapon',

    [ItemSlot.SOUL_COMPANION_AMULET]: 'Soul Companion Amulet',
    [ItemSlot.SOUL_COMPANION_CLOAK]: 'Soul Companion Cloak',
    [ItemSlot.SOUL_COMPANION_BELT]: 'Soul Companion Belt'
}