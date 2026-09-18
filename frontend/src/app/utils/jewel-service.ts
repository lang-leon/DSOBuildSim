import { Injectable } from '@angular/core';
import { JewelDefinitionDTO } from '../models/gamedataDTOs/JewelDefinitionDTO';
import { JewelInstanceDTO } from '../models/instanceDTOs/JewelInstanceDTO';
import { getIcon } from './display-utils';

@Injectable({ providedIn: 'root' })
export class JewelService {
  private jewelConfig!: Record<string, JewelDefinitionDTO>;

  setJewelConfig(config: Record<string, JewelDefinitionDTO>) {
    this.jewelConfig = config;
  }

  private getJewelIcon(jewelType: string, tier: number): string {
    return 'jewel-icons/' + getIcon(jewelType, tier);
  }

  getJewelDefinitionIcon(jewel: JewelDefinitionDTO, tier: number): string {
    return this.getJewelIcon(jewel.name, tier);
  }

  getJewelInstanceIcon(jewel: JewelInstanceDTO | null): string {
    if (jewel === null) return 'jewel-icons/default.png';
    return this.getJewelIcon(this.jewelConfig[jewel.jewelType].name, jewel.tier);
  }

  getJewelInstanceDescription(jewel: JewelInstanceDTO | null): string {
    if (jewel === null) return '';
    return this.jewelConfig[jewel.jewelType].descriptionPerTier[jewel.tier];
  }

  getJewelInstanceName(jewel: JewelInstanceDTO | null): string {
    if (jewel === null) return 'Empty';
    return this.jewelConfig[jewel.jewelType].name;
  }
}
