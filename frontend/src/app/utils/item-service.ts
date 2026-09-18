import { Injectable } from '@angular/core';
import { ItemDefinitionDTO } from '../models/gamedataDTOs/ItemDefinitionDTO';
import { SetDTO } from '../models/gamedataDTOs/SetDTO';
import { formatStatName } from './display-utils';

@Injectable({ providedIn: 'root' })
export class ItemService {
  private itemConfig!: Record<string, ItemDefinitionDTO>;
  private setConfig!: Record<string, SetDTO>;

  setConfigs(itemConfig: Record<string, ItemDefinitionDTO>, setConfig: Record<string, SetDTO>) {
    this.itemConfig = itemConfig;
    this.setConfig = setConfig;
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

  getItemName(itemType: string): string {
    if (itemType === undefined) return 'Empty';
    return this.itemConfig[itemType].name ?? 'Empty';
  }
}
