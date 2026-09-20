import { Injectable } from '@angular/core';
import { DragonStoneDefinitionDTO } from '../models/gamedataDTOs/DragonStoneDefinitionDTO';
import { DragonStoneInstanceDTO } from '../models/instanceDTOs/DragonStoneInstanceDTO';
import { formatName, formatStatName, formatStatValueRelative, getIcon } from './display-utils';
import { StatType } from '../enums/StatType';

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
    return this.tierNames[tier] + ' ' + formatName(dragonStoneName);
  }

  getDragonStoneDefinitionName(dragonStone: DragonStoneDefinitionDTO, tier: number) {
    return this.getDragonStoneName(dragonStone.dragonStoneType, tier);
  }

  getDragonStoneInstanceName(dragonStone: DragonStoneInstanceDTO | null) {
    if (dragonStone === null) return 'Empty';

    return this.getDragonStoneName(dragonStone.dragonStoneType, dragonStone.tier);
  }

  private getDragonStoneDescription(dragonStone: DragonStoneDefinitionDTO, tier: number): string {
    let desc = '';
    desc += dragonStone.description[tier];

    for (const [stat, value] of Object.entries(dragonStone.stats[tier]) as [StatType, number][]) {
      desc += formatStatValueRelative(value, 2) + ' ' + formatStatName(stat) + '\n';
    }
    return desc.trim();
  }

  getDragonStoneDefinitionDescription(dragonStone: DragonStoneDefinitionDTO, tier: number): string {
    return this.getDragonStoneDescription(dragonStone, tier);
  }

  getDragonStoneInstanceDescription(dragonStone: DragonStoneInstanceDTO | null): string {
    if (dragonStone === null) return '';
    return this.getDragonStoneDescription(
      this.dragonStoneConfig[dragonStone.dragonStoneType],
      dragonStone.tier,
    );
  }

  private getDragonStoneIcon(dragonStoneType: string, tier: number): string {
    return 'dragon-stone-icons/' + getIcon(dragonStoneType, tier);
  }

  getDragonStoneDefinitionIcon(dragonStone: DragonStoneDefinitionDTO, tier: number): string {
    return this.getDragonStoneIcon(dragonStone.dragonStoneType, tier);
  }

  getDragonStoneInstanceIcon(dragonStone: DragonStoneInstanceDTO | null): string {
    if (dragonStone === null) return 'dragon-stone-icons/default.png';
    return this.getDragonStoneIcon(dragonStone.dragonStoneType, dragonStone.tier);
  }
}
