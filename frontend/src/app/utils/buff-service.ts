import { Injectable } from '@angular/core';
import { formatStatName, formatStatValueAbsolute, formatStatValueRelative } from './display-utils';
import { BuffDefinitionDTO } from '../models/gamedataDTOs/BuffDefinitionDTO';
import { BuffInstanceDTO } from '../models/instanceDTOs/BuffInstanceDTO';

@Injectable({ providedIn: 'root' })
export class BuffService {
  private tonicConfig!: Record<string, BuffDefinitionDTO>;
  private physicConfig!: Record<string, BuffDefinitionDTO>;

  setTonicConfig(config: Record<string, BuffDefinitionDTO>) {
    this.tonicConfig = config;
  }

  setPhysicConfig(config: Record<string, BuffDefinitionDTO>) {
    this.physicConfig = config;
  }

  private getTonicDescription(tonic: BuffDefinitionDTO | null, tier: number) {
    if (tonic === null) return '';
    let desc = '';
    desc +=
      tonic.statsPerTier[tier] !== undefined
        ? '+ ' + tonic.statsPerTier[tier] + ' ' + formatStatName(tonic.statType)
        : '';
    return desc.trim();
  }

  getTonicInstanceDescription(tonic: BuffInstanceDTO | null): string {
    if (tonic === null) return '';
    return this.getTonicDescription(this.tonicConfig[tonic.type], tonic.tier);
  }

  private getPhysicDescription(physic: BuffDefinitionDTO | null, tier: number) {
    if (physic === null) return '';
    let desc = '';
    desc +=
      physic.statsPerTier[tier] !== undefined
        ? formatStatValueRelative(physic.statsPerTier[tier], 2) +
          ' ' +
          formatStatName(physic.statType)
        : '';
    return desc.trim();
  }

  getPhysicInstanceDescription(physic: BuffInstanceDTO | null): string {
    if (physic === null) return '';
    return this.getPhysicDescription(this.physicConfig[physic.type], physic.tier);
  }

  private getTonicName(tonicType: string | null): string {
    if (tonicType === null) return '';
    return this.tonicConfig[tonicType].name;
  }

  getTonicInstanceName(tonic: BuffInstanceDTO | null): string {
    if (tonic === null) return '';
    return this.getTonicName(tonic.type);
  }

  private getPhysicName(physicType: string | null): string {
    if (physicType === null) return '';
    return this.physicConfig[physicType].name;
  }

  getPhysicInstanceName(physic: BuffInstanceDTO | null): string {
    if (physic === null) return '';
    return this.getPhysicName(physic.type);
  }
}
