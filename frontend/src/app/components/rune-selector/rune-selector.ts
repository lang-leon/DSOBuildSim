import { Component, EventEmitter, Input, Output } from '@angular/core';
import { BuildSimButton } from '../build-sim-button/build-sim-button';
import { FormsModule } from '@angular/forms';
import { RuneInstanceDTO } from '../../models/instanceDTOs/RuneInstanceDTO';
import { RuneDefinitionDTO } from '../../models/gamedataDTOs/RuneDefinitionDTO';
import { formatStatName, getIcon } from '../../utils/display-utils';

@Component({
  selector: 'app-rune-selector',
  imports: [BuildSimButton, FormsModule],
  templateUrl: './rune-selector.html',
  styleUrl: './rune-selector.scss',
})
export class RuneSelector {
  @Input() runeConfig!: Record<string, RuneDefinitionDTO>;

  @Input() canSelectRune!: (runeType: string) => boolean;

  @Output() selected = new EventEmitter<RuneInstanceDTO>();

  @Output() cancelled = new EventEmitter<void>();

  searchTerm = '';
  maxTierOnly = true;

  getIcon = getIcon;

  ngOnInit()
  {
    for(const rune of Object.values(this.runeConfig))
    {
      console.log(rune.name)
    }
  }

  getTiers(rune: RuneDefinitionDTO): number[] {
    const tiers = Object.keys(rune.statsPerTier)
      .map(Number)
      .sort((a, b) => a - b);

    return this.maxTierOnly ? [tiers[tiers.length - 1]] : tiers;
  }

  selectRune(rune: RuneDefinitionDTO, tier: number) {
    if (this.canSelectRune(rune.runeType)) {
      const instance: RuneInstanceDTO = {
        runeType: rune.runeType,
        tier: tier,
      };
      this.selected.emit(instance);
    }else{

    }
  }

  cancel() {
    this.cancelled.emit();
  }

getFilteredRunes(): RuneDefinitionDTO[] {
  const search = this.searchTerm.toLowerCase().trim();

  return Object.values(this.runeConfig)
    .filter(rune => rune.name.toLowerCase().includes(search));
}

getRuneDescription(rune: RuneDefinitionDTO, tier: number) {
    let desc = rune?.description.replace('{tier}', String(tier));
    
    for (const [statType, value] of Object.entries(rune.statsPerTier[tier])) {
      desc += `\n+${(value*100).toFixed(2)}% ${formatStatName(statType)}`;
    }
    return desc.trim();
  }

  getRuneIcon(rune: RuneDefinitionDTO | null, tier: number)
  {
    if(rune === null) return 'rune-icons/default.png';

    const runeName = this.runeConfig[rune.runeType].name;
    return 'rune-icons/'+this.getIcon(runeName, tier);
  }
}
