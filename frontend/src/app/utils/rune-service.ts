import { Injectable } from '@angular/core';
import { RuneDefinitionDTO } from '../models/gamedataDTOs/RuneDefinitionDTO';
import { RuneInstanceDTO } from '../models/instanceDTOs/RuneInstanceDTO';
import { formatStatName, getIcon } from './display-utils';

@Injectable({ providedIn: 'root' })
export class RuneService {
  private runeConfig!: Record<string, RuneDefinitionDTO>;

  setRuneConfig(config: Record<string, RuneDefinitionDTO>) {
    this.runeConfig = config;
  }

  private getRuneIcon(runeType: string, tier: number): string {
    return 'rune-icons/' + getIcon(runeType, tier);
  }

  getRuneDefinitionIcon(rune: RuneDefinitionDTO, tier: number): string {
    return this.getRuneIcon(rune.name, tier);
  }

  getRuneInstanceIcon(rune: RuneInstanceDTO | null): string {
    if (rune === null) return 'rune-icons/default.png';
    return this.getRuneIcon(this.runeConfig[rune.runeType].name, rune.tier);
  }

  private getRuneDescription(rune: RuneDefinitionDTO | null, tier: number): string {
    if (rune === null) return '';
    let desc = rune.description.replace('{tier}', String(tier));

    for (const [statType, value] of Object.entries(rune.statsPerTier[tier])) {
      desc += `\n+${(value * 100).toFixed(2)}% ${formatStatName(statType)}`;
    }
    return desc.trim();
  }

  getRuneDefinitionDescription(rune: RuneDefinitionDTO, tier: number): string {
    return this.getRuneDescription(rune, tier);
  }

  getRuneInstanceDescription(rune: RuneInstanceDTO | null): string {
    if (rune === null) return '';
    return this.getRuneDescription(this.runeConfig[rune.runeType], rune.tier);
  }

  getRuneInstanceName(rune: RuneInstanceDTO | null): string {
    if (rune === null) return 'Empty';
    return this.runeConfig[rune.runeType].name;
  }
}
