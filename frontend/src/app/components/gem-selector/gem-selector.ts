import { Component, EventEmitter, Input, Output } from '@angular/core';
import { GemDefinitionDTO } from '../../models/gamedataDTOs/GemDefinitionDTO';
import { GemInstanceDTO } from '../../models/instanceDTOs/GemInstanceDTO';
import { GemService } from '../../utils/gem-service';
import { BuildSimButton } from '../build-sim-button/build-sim-button';
import { FormsModule } from '@angular/forms';
import { matchesSearch } from '../../utils/display-utils';

@Component({
  selector: 'app-gem-selector',
  imports: [BuildSimButton, FormsModule],
  templateUrl: './gem-selector.html',
  styleUrl: './gem-selector.scss',
})
export class GemSelector {
  constructor(public gemService: GemService) {}

  @Input() gemConfig!: Record<string, GemDefinitionDTO>;

  @Input() canSelectGem!: (gemType: string) => boolean;

  @Output() selected = new EventEmitter<GemInstanceDTO>();

  @Output() cancelled = new EventEmitter<void>();

  searchTerm = '';
  maxTierOnly = true;
  craftOpal = false;
  opalGems: (GemInstanceDTO | null)[] = [null, null, null];
  selectedOpalSlot = 0;

  get selectedOpalTier(): number | null {
    const gem = this.opalGems.find((gem) => gem !== null);
    return gem?.tier ?? null;
  }

  ngOnInit() {
    this.gemService.setGemConfig(this.gemConfig);
  }

  getTiers(gem: GemDefinitionDTO): number[] {
    const tiers = Object.keys(gem.stats).map(Number);
    const search = this.searchTerm.toLowerCase().trim();

    if (this.maxTierOnly) return [tiers[tiers.length - 1]];

    if (!search) {
      return tiers;
    }
    return tiers.filter((tier) =>
      matchesSearch(this.gemService.getGemDefinitionName(gem, tier), search),
    );
  }

  getFilteredGems(): GemDefinitionDTO[] {
    const search = this.searchTerm.toLowerCase().trim();

    return Object.values(this.gemConfig).filter(
      (gem) =>
        !search ||
        this.getTiers(gem).some((tier) =>
          matchesSearch(this.gemService.getGemDefinitionName(gem, tier), search),
        ),
    );
  }

  selectGem(gem: GemDefinitionDTO, tier: number) {
    if (this.canSelectGem(gem.gemType)) {
      const instance: GemInstanceDTO = {
        gemCategory: 'GEM',
        gemType: [gem.gemType],
        tier: tier,
      };
      this.selected.emit(instance);
    }
  }

  //Opal crafting

  selectOpalSlot(index: number) {
    this.selectedOpalSlot = index;
  }

  selectOpalGem(gem: GemDefinitionDTO, tier: number): void {
    this.opalGems[this.selectedOpalSlot] = {
      gemCategory: 'GEM',
      gemType: [gem.gemType],
      tier,
    };

    const nextEmptySlot = this.opalGems.findIndex((gem) => gem === null);

    if (nextEmptySlot !== -1) {
      this.selectedOpalSlot = nextEmptySlot;
    }
  }

  getAvailableOpalTiers(gem: GemDefinitionDTO): number[] {
    const tiers = Object.keys(gem.stats)
      .map(Number)
      .filter((tier) => tier >= 9 && tier <= 17);
    const search = this.searchTerm.toLowerCase().trim();

    if (this.selectedOpalTier !== null) {
      return tiers.filter((tier) => tier === this.selectedOpalTier);
    }

    if (this.maxTierOnly) return [tiers[tiers.length - 1]];

    if (!search) {
      return tiers;
    }

    return tiers.filter((tier) =>
      matchesSearch(this.gemService.getGemDefinitionName(gem, tier), search),
    );
  }

  getFilteredOpalGems(): GemDefinitionDTO[] {
    const search = this.searchTerm.toLowerCase().trim();

    return Object.values(this.gemConfig).filter((gem) =>
      this.getAvailableOpalTiers(gem).some(
        (tier) => !search || matchesSearch(this.gemService.getGemDefinitionName(gem, tier), search),
      ),
    );
  }

  canSelectOpalGem(gemType: string): boolean {
    for (const gem of this.opalGems) {
      if (gem !== null && gem.gemType[0] == gemType) return false;
    }
    return true;
  }

  deleteOpalGem(index: number) {
    this.opalGems[index] = null;
    this.selectedOpalSlot = index;
  }

  selectOpal() {
    const gems = this.opalGems.filter((gem): gem is GemInstanceDTO => gem !== null);

    if (gems.length !== 3) {
      return;
    }

    const instance: GemInstanceDTO = {
      gemCategory: 'OPAL',
      gemType: gems.map((gem) => gem.gemType[0]),
      tier: gems[0].tier,
    };

    this.selected.emit(instance);
  }

  cancel() {
    this.cancelled.emit();
  }
}
