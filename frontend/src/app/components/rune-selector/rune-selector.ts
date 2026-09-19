import { Component, EventEmitter, Input, Output } from '@angular/core';
import { BuildSimButton } from '../build-sim-button/build-sim-button';
import { FormsModule } from '@angular/forms';
import { RuneInstanceDTO } from '../../models/instanceDTOs/RuneInstanceDTO';
import { RuneDefinitionDTO } from '../../models/gamedataDTOs/RuneDefinitionDTO';
import { RuneService } from '../../utils/rune-service';
import { getTierName } from '../../utils/tooltip-utils';

@Component({
  selector: 'app-rune-selector',
  imports: [BuildSimButton, FormsModule],
  templateUrl: './rune-selector.html',
  styleUrl: './rune-selector.scss',
})
export class RuneSelector {
  constructor(public runeService: RuneService) {}

  @Input() runeConfig!: Record<string, RuneDefinitionDTO>;

  @Input() canSelectRune!: (runeType: string) => boolean;

  @Output() selected = new EventEmitter<RuneInstanceDTO>();

  @Output() cancelled = new EventEmitter<void>();

  searchTerm = '';
  maxTierOnly = true;

  getTierName = getTierName;

  ngOnInit() {
    this.runeService.setRuneConfig(this.runeConfig);
  }

  getTiers(rune: RuneDefinitionDTO): number[] {
    const tiers = Object.keys(rune.statsPerTier)
      .map(Number)
      .sort((a, b) => a - b);

    return this.maxTierOnly ? [tiers[tiers.length - 1]] : tiers;
  }

  getFilteredRunes(): RuneDefinitionDTO[] {
    const search = this.searchTerm.toLowerCase().trim();

    return Object.values(this.runeConfig).filter((rune) =>
      rune.name.toLowerCase().includes(search),
    );
  }

  selectRune(rune: RuneDefinitionDTO, tier: number) {
    if (this.canSelectRune(rune.runeType)) {
      const instance: RuneInstanceDTO = {
        runeType: rune.runeType,
        tier: tier,
      };
      this.selected.emit(instance);
    } else {
    }
  }

  cancel() {
    this.cancelled.emit();
  }
}
