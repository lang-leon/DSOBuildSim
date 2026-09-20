import { Injectable } from '@angular/core';
import { ItemDefinitionDTO } from '../models/gamedataDTOs/ItemDefinitionDTO';
import { SetDTO } from '../models/gamedataDTOs/SetDTO';
import { formatStatName, formatStatValueAbsolute, formatStatValueRelative } from './display-utils';
import { ItemInstanceDTO } from '../models/instanceDTOs/ItemInstanceDTO';
import { StatType } from '../enums/StatType';
import { GemDefinitionDTO } from '../models/gamedataDTOs/GemDefinitionDTO';

@Injectable({ providedIn: 'root' })
export class ItemService {
  private itemConfig!: Record<string, ItemDefinitionDTO>;
  private setConfig!: Record<string, SetDTO>;
  private gemConfig!: Record<string, GemDefinitionDTO>;

  setConfigs(itemConfig: Record<string, ItemDefinitionDTO>, setConfig: Record<string, SetDTO>) {
    this.itemConfig = itemConfig;
    this.setConfig = setConfig;
  }

  setGemConfig(gemConfig: Record<string, GemDefinitionDTO>) {
    this.gemConfig = gemConfig;
  }

  getItemName(itemType: string): string {
    if (itemType === undefined) return 'Empty';
    return this.itemConfig[itemType].name ?? 'Empty';
  }

  getItemInstanceTier(item: ItemInstanceDTO) {
    if (item === undefined) return -1;
    return this.itemConfig[item.itemType].tier;
  }

  getItemInstanceBaseValues(item: ItemInstanceDTO): string {
    if (item === undefined) return '';
    let baseValues = '';
    for (const [type, value] of Object.entries(item.baseValues) as [StatType, number][]) {
      baseValues += formatStatValueAbsolute(value, 3) + ' ' + formatStatName(type) + '\n';
    }
    return baseValues.trim();
  }

  getItemInstanceGems(item: ItemInstanceDTO): string {
    if (!item) return '';

    const stats = new Map<StatType, number[]>();

    for (const gem of item.gems) {
      if (!gem) {
        continue;
      }

      for (const gemType of gem.gemType) {
        const gemDef = this.gemConfig[gemType];
        const value = gemDef.stats[gem.tier];

        const values = stats.get(gemDef.statType) ?? [];
        values.push(value);
        stats.set(gemDef.statType, values);
      }
    }

    let gems = '';

    for (const [stat, values] of stats) {
      const total = values.reduce((sum, value) => sum + value, 0);

      gems += `+ ${total} ${formatStatName(stat)} on this item (${values.join(', ')})\n`;
    }
    return gems.trim();
  }

  getItemInstanceEnchantments(item: ItemInstanceDTO): string {
    if (item === undefined) return '';
    let enchantments = '';
    for (const enchantment of item.enchantments) {
      if (enchantment === null) continue;
      enchantments +=
        formatStatValueRelative(enchantment.value, 3) +
        ' ' +
        formatStatName(enchantment.statType) +
        ' on this item\n';
    }
    return enchantments.trim();
  }

  getItemInstanceUniqueValues(item: ItemInstanceDTO): string {
    if (item === undefined) return '';
    let desc = '';

    for (const [type, value] of Object.entries(item.uniqueBaseValues)) {
      desc +=
        formatStatValueAbsolute(value, 3).replace(/\.?0+$/, '') +
        ' ' +
        formatStatName(type) +
        'on this item\n';
    }
    for (const enchantment of item.uniqueEnchantments) {
      desc +=
        formatStatValueRelative(enchantment.value, 3) +
        ' ' +
        formatStatName(enchantment.statType) +
        ' on this item\n';
    }

    const itemDef = this.itemConfig[item.itemType];
    for (const [type, value] of Object.entries(itemDef.uniqueRelativeValues)) {
      desc += formatStatValueRelative(value, 2) + ' ' + formatStatName(type) + '\n';
    }
    if (itemDef.uniqueAbsoluteValues !== null) {
      for (const [type, value] of Object.entries(itemDef.uniqueAbsoluteValues)) {
        desc +=
          formatStatValueAbsolute(value, 3).replace(/\.?0+$/, '') +
          ' ' +
          formatStatName(type) +
          '\n';
      }
    }
    if (itemDef.uniqueDescription !== null) desc += itemDef.uniqueDescription;
    return desc.trim();
  }

  getItemSetHeader(item: ItemInstanceDTO, equippedSets: Record<string, Set<string>>): string {
    return (
      this.setConfig[this.itemConfig[item.itemType].set].name +
      ' (' +
      this.getEquippedSetItemCount(item, equippedSets) +
      '/' +
      this.setConfig[this.itemConfig[item.itemType].set].setItems.length +
      '):'
    );
  }

  getEquippedSetItemCount(
    item: ItemInstanceDTO,
    equippedSets: Record<string, Set<string>>,
  ): number {
    if (item === undefined) return 0;
    const count = equippedSets[this.itemConfig[item.itemType].set]?.size || 0;
    if (equippedSets[this.itemConfig[item.itemType].set] !== undefined) {
      return equippedSets[this.itemConfig[item.itemType].set].has(item.itemType)
        ? count
        : count + 1;
    }
    return count + 1;
  }

  private getItemSetItems(item: ItemDefinitionDTO): string[] {
    if (item === undefined) return [];
    if (item.itemCategory !== 'SET') return [];
    const setItems = this.setConfig[item.set].setItems;
    return setItems;
  }

  getItemInstanceSetItems(item: ItemInstanceDTO): string[] {
    if (item === undefined) return [];
    return this.getItemSetItems(this.itemConfig[item.itemType]);
  }

  getSetBonusStrings(setType: string): Record<number, string> {
    const set = this.setConfig[setType];

    const tiers = new Set([
      ...Object.keys(set.baseValuesPerTier),
      ...Object.keys(set.relativeValuesPerTier),
      ...Object.keys(set.descriptionPerTier),
    ]);

    const bonuses: Record<number, string> = {};

    for (const tier of tiers) {
      const parts: string[] = [];

      const baseValues = set.baseValuesPerTier[tier];
      if (baseValues) {
        for (const [statType, value] of Object.entries(baseValues)) {
          parts.push(`+ ${value} ${formatStatName(statType)}`);
        }
      }

      const relativeValues = set.relativeValuesPerTier[tier];
      if (relativeValues) {
        for (const [statType, value] of Object.entries(relativeValues)) {
          parts.push(`+ ${value}% ${formatStatName(statType)}`);
        }
      }

      const description = set.descriptionPerTier[tier];
      if (description) {
        parts.push(description);
      }

      bonuses[Number(tier)] = `(${tier}): ${parts.join('\n')}`;
    }

    return bonuses;
  }

  getItemInstanceBoni(item: ItemInstanceDTO) {
    if (item === undefined) return [];
    return this.getSetBonusStrings(this.itemConfig[item.itemType].set);
  }
}
