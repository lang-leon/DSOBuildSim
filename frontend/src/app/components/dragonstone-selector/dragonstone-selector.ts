import { Component, EventEmitter, Input, Output } from '@angular/core';
import { DragonStoneInstanceDTO } from '../../models/instanceDTOs/DragonStoneInstanceDTO';
import { DragonStoneDefinitionDTO } from '../../models/gamedataDTOs/DragonStoneDefinitionDTO';
import { BuildSimButton } from '../build-sim-button/build-sim-button';
import { getIcon, matchesSearch } from '../../utils/display-utils';
import { FormsModule } from '@angular/forms';
import { DragonStoneService } from '../../utils/dragon-stone-service';
import { getTierName } from '../../utils/tooltip-utils';

@Component({
  selector: 'app-dragonstone-selector',
  imports: [BuildSimButton, FormsModule],
  templateUrl: './dragonstone-selector.html',
  styleUrl: './dragonstone-selector.scss',
})
export class DragonstoneSelectorComponent {
  constructor(public dragonStoneService: DragonStoneService) {}

  @Input() dragonStoneConfig!: Record<string, DragonStoneDefinitionDTO>;

  @Output() selected = new EventEmitter<DragonStoneInstanceDTO>();

  @Output() cancelled = new EventEmitter<void>();

  searchTerm = '';
  maxTierOnly = true;

  getTierName = getTierName;

  ngOnInit() {
    this.dragonStoneService.setDragonStoneConfig(this.dragonStoneConfig);
  }

  getTiers(dragonStone: DragonStoneDefinitionDTO): number[] {
    const tiers = Object.keys(dragonStone.description).map(Number);
    const search = this.searchTerm.toLowerCase().trim();

    if (this.maxTierOnly) return [tiers[tiers.length - 1]];

    if (!search) {
      return tiers;
    }
    return tiers.filter((tier) =>
      matchesSearch(
        this.dragonStoneService.getDragonStoneDefinitionName(dragonStone, tier),
        search,
      ),
    );
  }

  getFilteredDragonStones(): DragonStoneDefinitionDTO[] {
    const search = this.searchTerm.toLowerCase().trim();

    return Object.values(this.dragonStoneConfig).filter(
      (dragonStone) =>
        !search ||
        this.getTiers(dragonStone).some((tier) =>
          matchesSearch(this.dragonStoneService.getDragonStoneDefinitionName(dragonStone, tier), search),
        ),
    );
  }

  selectDragonStone(dragonStone: DragonStoneDefinitionDTO, tier: number) {
    const instance: DragonStoneInstanceDTO = {
      dragonStoneType: dragonStone.dragonStoneType,
      tier: tier,
    };
    this.selected.emit(instance);
  }

  cancel() {
    this.cancelled.emit();
  }
}
