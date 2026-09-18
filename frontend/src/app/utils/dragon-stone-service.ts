import { Injectable } from '@angular/core';
import { DragonStoneDefinitionDTO } from '../models/gamedataDTOs/DragonStoneDefinitionDTO';
import { DragonStoneInstanceDTO } from '../models/instanceDTOs/DragonStoneInstanceDTO';
import { formatName } from './display-utils';

@Injectable({ providedIn: 'root' })
export class DragonStoneService {
  private dragonStoneConfig!: Record<string, DragonStoneDefinitionDTO>;

  private readonly tierNames: Record<number, string> = {
    3: "Dragon Hatchling's",
    4: "Mighty Dragon's",
    5: "Dragon Elder's",
  };

  setDragonStoneConfig(config: Record<string, DragonStoneDefinitionDTO>) {
    this.dragonStoneConfig = config;
  }

  private getDragonStoneName(dragonStoneName: string, tier: number) {
    return this.tierNames[tier] + ' ' + dragonStoneName;
  }

  getDragonStoneDefinitionName(dragonStone: DragonStoneDefinitionDTO, tier: number) {
    return this.getDragonStoneName(formatName(dragonStone.dragonStoneType), tier);
  }

  getDragonStoneInstanceName(dragonStone: DragonStoneInstanceDTO | null) {
    if (dragonStone === null) return 'Empty';

    switch (dragonStone.dragonStoneType) {
      case 'GEM':
        return this.getDragonStoneName(dragonStone.dragonStoneType, dragonStone.tier);
      case 'OPAL':
        return this.getDragonStoneName('opal', dragonStone.tier);
      default:
        return 'dragonStone-icons/default.png';
    }
  }

  getDragonStoneDefinitionDescription(dragonStone: DragonStoneDefinitionDTO, tier: number): string {
    return dragonStone.description[tier];
  }

  getDragonStoneInstanceDescription(dragonStone: DragonStoneInstanceDTO | null): string {
    if (dragonStone === null) return '';
    return this.dragonStoneConfig[dragonStone.dragonStoneType].description[dragonStone.tier];
  }

    private getDragonStoneIcon(dragonStoneType: string, tier: number): string {
      const tierName = this.tierNames[tier];
      if (!tierName) {
        return 'dragonStone-icons/default.png';
      }
      return (
        'dragonStone-icons/' +
        dragonStoneType.toLowerCase().replaceAll(' ', '-').replaceAll('_', '-') +
        '-' +
        tierName.toLowerCase().replaceAll(' ', '-').replaceAll('\'', '') +
        '.png'
      );
    }
  
    getDragonStoneDefinitionIcon(dragonStone: DragonStoneDefinitionDTO, tier: number): string {
      return this.getDragonStoneIcon(dragonStone.dragonStoneType, tier);
    }
  
    getDragonStoneInstanceIcon(dragonStone: DragonStoneInstanceDTO | null): string {
      if (dragonStone === null) return 'dragonStone-icons/default.png';
        return this.getDragonStoneIcon(dragonStone.dragonStoneType, dragonStone.tier)
      }
}
