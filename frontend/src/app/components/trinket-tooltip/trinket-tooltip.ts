import { Component, Input } from '@angular/core';
import { RuneTrinketDTO } from '../../models/instanceDTOs/RuneTrinketDTO';
import { JewelTrinketDTO } from '../../models/instanceDTOs/JewelTrinketDTO';
import { DragonCrestTrinketDTO } from '../../models/instanceDTOs/DragonCrestTrinketDTO';
import { RuneDefinitionDTO } from '../../models/gamedataDTOs/RuneDefinitionDTO';
import { DragonStoneDefinitionDTO } from '../../models/gamedataDTOs/DragonStoneDefinitionDTO';
import { JewelDefinitionDTO } from '../../models/gamedataDTOs/JewelDefinitionDTO';
import { RuneService } from '../../utils/rune-service';
import { JewelService } from '../../utils/jewel-service';
import { DragonStoneService } from '../../utils/dragon-stone-service';
import { StatType } from '../../enums/StatType';
import { formatStatName, formatStatValueRelative } from '../../utils/display-utils';
import { OverlayModule } from '@angular/cdk/overlay';
import { RuneInstanceDTO } from '../../models/instanceDTOs/RuneInstanceDTO';

@Component({
  selector: 'app-trinket-tooltip',
  imports: [],
  templateUrl: './trinket-tooltip.html',
  styleUrl: './trinket-tooltip.scss',
})
export class TrinketTooltip {
  constructor(
    public runeService: RuneService,
    public jewelService: JewelService,
    public dragonStoneService: DragonStoneService,
  ) {}

  @Input() title!: string;

  @Input() runeTrinket?: RuneTrinketDTO;

  @Input() jewelTrinket?: JewelTrinketDTO;

  @Input() dragonCrestTrinket?: DragonCrestTrinketDTO;

  @Input() runeConfig?: Record<string, RuneDefinitionDTO>;

  @Input() jewelConfig?: Record<string, JewelDefinitionDTO>;

  @Input() dragonStoneConfig?: Record<string, DragonStoneDefinitionDTO>;

  ngOnInit() {
    if (this.runeConfig) {
      this.runeService.setRuneConfig(this.runeConfig);
    }
    if (this.jewelConfig) {
      this.jewelService.setJewelConfig(this.jewelConfig);
    }
    if (this.dragonStoneConfig) {
      this.dragonStoneService.setDragonStoneConfig(this.dragonStoneConfig);
    }
  }

  getRuneTrinketDescription(): string {
    if (!this.runeTrinket || !this.runeConfig) return '';
    let desc = '';
    let stats = new Map<StatType, number>();
    for (const rune of this.runeTrinket.runes) {
      if (!rune) {
        continue;
      }

      const runeDef = this.runeConfig[rune.runeType];

      for (const [stat, value] of Object.entries(runeDef.statsPerTier[rune.tier]) as [
        StatType,
        number,
      ][]) {
        stats.set(stat, (stats.get(stat) ?? 0) + value);
      }

      if (runeDef.description !== '') {
        desc += runeDef.description.replace('{tier}', rune.tier.toString()) + '\n';
      }
    }

    let finalDesc = '';

    for (const [stat, value] of stats) {
      finalDesc += formatStatValueRelative(value, 2) + ' ' + formatStatName(stat) + '\n';
    }

    finalDesc += desc;
    return finalDesc.trim();
  }

  getJewelTrinketDescription(): string {
    if (!this.jewelTrinket || !this.jewelConfig) return '';
    let desc = '';
    for (const jewel of this.jewelTrinket.jewels) {
      if (!jewel) {
        continue;
      }

      const jewelDef = this.jewelConfig[jewel.jewelType];

      if (jewelDef.descriptionPerTier[jewel.tier] !== '') {
        desc +=
          jewelDef.descriptionPerTier[jewel.tier].replace('{tier}', jewel.tier.toString()) + '\n';
      }
    }
    return desc.trim();
  }

  getDragonStoneTrinketDescription(): string {
    if (!this.dragonCrestTrinket || !this.dragonStoneConfig) return '';
    let desc = '';
    let stats = new Map<StatType, number>();
    for (const dragonStone of this.dragonCrestTrinket.dragonStones) {
      if (!dragonStone) {
        continue;
      }

      const dragonStoneDef = this.dragonStoneConfig[dragonStone.dragonStoneType];

      for (const [stat, value] of Object.entries(dragonStoneDef.stats[dragonStone.tier]) as [
        StatType,
        number,
      ][]) {
        stats.set(stat, (stats.get(stat) ?? 0) + value);
      }

      if (dragonStoneDef.description[dragonStone.tier] !== '') {
        desc +=
          dragonStoneDef.description[dragonStone.tier].replace(
            '{tier}',
            dragonStone.tier.toString(),
          ) + '\n';
      }
    }

    let finalDesc = '';

    for (const [stat, value] of stats) {
      finalDesc += formatStatValueRelative(value, 2) + ' ' + formatStatName(stat) + '\n';
    }

    finalDesc += desc;
    return finalDesc.trim();
  }
}
