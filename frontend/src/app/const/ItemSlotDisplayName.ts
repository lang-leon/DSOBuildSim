import { ItemSlot } from '../enums/ItemSlot';

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
  [ItemSlot.MAIN_HAND]: 'Main Hand',
  [ItemSlot.OFF_HAND]: 'Off-Hand',

  [ItemSlot.SOUL_COMPANION_AMULET]: 'Soul Companion Amulet',
  [ItemSlot.SOUL_COMPANION_CLOAK]: 'Soul Companion Cloak',
  [ItemSlot.SOUL_COMPANION_BELT]: 'Soul Companion Belt',

  [ItemSlot.NONE]: 'NONE',
};
