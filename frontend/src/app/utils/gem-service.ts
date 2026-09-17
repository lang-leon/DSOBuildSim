import { Injectable } from '@angular/core';
import { GemDefinitionDTO } from '../models/gamedataDTOs/GemDefinitionDTO';
import { GemInstanceDTO } from '../models/instanceDTOs/GemInstanceDTO';
import { formatStatName } from './display-utils';

@Injectable({ providedIn: 'root' })
export class GemService {
  private gemConfig!: Record<string, GemDefinitionDTO>;

  private readonly tierNames: Record<number, string> = {
    1: 'splintered',
    2: 'flawed',
    3: 'simple',
    4: 'normal',
    5: 'polished',
    6: 'radiant',
    7: 'flawless',
    8: 'sacred',
    9: 'royal',
    10: 'trapezoid',
    11: 'refined-trapezoid',
    12: 'brilliant-trapezoid',
    13: 'exquisite-trapezoid',
    14: 'imperial',
    15: 'refined-imperial',
    16: 'brilliant-imperial',
    17: 'exquisite-imperial',
  };

  setGemConfig(config: Record<string, GemDefinitionDTO>) {
    this.gemConfig = config;
  }

  private getGemIcon(gemName: string, tier: number): string {
    const tierName = this.tierNames[tier];
    if (!tierName) {
      return 'gem-icons/default.png';
    }
    return (
      'gem-icons/' +
      gemName.toLowerCase().replaceAll(' ', '-').replaceAll('_', '-') +
      '-' +
      tierName +
      '.png'
    );
  }

  getGemDefinitionIcon(gem: GemDefinitionDTO, tier: number): string {
    return this.getGemIcon(gem.gemType, tier);
  }

  getGemInstanceIcon(gem: GemInstanceDTO | null): string {
    if (gem === null) return 'gem-icons/default.png';

    switch (gem.gemCategory) {
      case 'GEM':
        return this.getGemIcon(this.gemConfig[gem.gemType[0]].gemType, gem.tier);
      case 'OPAL':
        return this.getGemIcon('opal', gem.tier);
      default:
        return 'gem-icons/default.png';
    }
  }

  private getGemName(gemName: string, tier: number) {
    const formattedName = gemName
      .toLowerCase()
      .replaceAll('-', ' ')
      .replaceAll('_', ' ')
      .replace(/\b\w/g, (char) => char.toUpperCase());

    if (tier === 4) return formattedName;

    const formattedTier = this.tierNames[tier]
      .replaceAll('-', ' ')
      .replace(/\b\w/g, (char) => char.toUpperCase());

    return formattedTier + ' ' + formattedName;
  }

  getGemDefinitionName(gem: GemDefinitionDTO, tier: number) {
    return this.getGemName(gem.name, tier);
  }

  getGemInstanceName(gem: GemInstanceDTO | null) {
    if (gem === null) return 'Empty';

    switch (gem.gemCategory) {
      case 'GEM':
        return this.getGemName(gem.gemType[0], gem.tier);
      case 'OPAL':
        return this.getGemName('opal', gem.tier);
      default:
        return 'gem-icons/default.png';
    }
  }

  private getGemDescription(gem: GemDefinitionDTO, tier: number, opal: boolean): string {
    if (opal) return '+ ' + gem.stats[tier] * 0.75 + ' ' + formatStatName(gem.statType);
    return '+ ' + gem.stats[tier] + ' ' + formatStatName(gem.statType);
  }

  getGemDefinitionDescription(gem: GemDefinitionDTO, tier: number): string {
    return this.getGemDescription(gem, tier, false);
  }

  getGemInstanceDescription(gem: GemInstanceDTO | null): string {
    if (gem === null) return '';

    switch (gem.gemCategory) {
      case 'GEM':
        return this.getGemDescription(this.gemConfig[gem.gemType[0]], gem.tier, false);
      case 'OPAL':
        return (
          this.getGemDescription(this.gemConfig[gem.gemType[0]], gem.tier, true) +
          '\n' +
          this.getGemDescription(this.gemConfig[gem.gemType[1]], gem.tier, true) +
          '\n' +
          this.getGemDescription(this.gemConfig[gem.gemType[2]], gem.tier, true)
        );
      default:
        return '';
    }
  }

  getOpalName(opalGems: (GemInstanceDTO | null)[]): string {
    const tier = opalGems[0]?.tier;
    if (tier === undefined) return 'Empty';

    return this.getGemName('opal', tier);
  }

  getOpalDescription(opalGems: (GemInstanceDTO | null)[]): string {
    let descr = "";
    for (const gem of opalGems) {
        const type = gem?.gemType;
        const tier = gem?.tier;
      if (type !== undefined && tier !== undefined){
        descr += this.getGemDescription(this.gemConfig[type[0]], tier, true) +"\n";
      }
    }
    return descr;
  }

  getOpalIcon(opalGems: (GemInstanceDTO | null)[]): string {
    const tier = opalGems[0]?.tier;
    if (tier === undefined) return 'gem-icons/default.png';

    return this.getGemIcon('opal', tier);
  }
}
