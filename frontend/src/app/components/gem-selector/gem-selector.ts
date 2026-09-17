import { Component, EventEmitter, Input, Output } from '@angular/core';
import { GemDefinitionDTO } from '../../models/gamedataDTOs/GemDefinitionDTO';
import { GemInstanceDTO } from '../../models/instanceDTOs/GemInstanceDTO';
import { GemService } from '../../utils/gem-service';
import { BuildSimButton } from '../build-sim-button/build-sim-button';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-gem-selector',
  imports: [
    BuildSimButton,
    FormsModule
  ],
  templateUrl: './gem-selector.html',
  styleUrl: './gem-selector.scss',
})
export class GemSelector {
  constructor(public gemService: GemService){}

  @Input() gemConfig!: Record<string, GemDefinitionDTO>;

  @Input() canSelectGem!: (gemType: string) => boolean;

  @Output() selected = new EventEmitter<GemInstanceDTO>();

  @Output() cancelled = new EventEmitter<void>();

  searchTerm = '';
  maxTierOnly = true;

  ngOnInit()
  {
    this.gemService.setGemConfig(this.gemConfig);
  }

  getTiers(gem: GemDefinitionDTO): number[] {
    const tiers = Object.keys(gem.stats).map(Number);
    const search = this.searchTerm.toLowerCase().trim();

    if (this.maxTierOnly)
      return [tiers[tiers.length - 1]];

    if (!search) {
        return tiers;
    }
    return tiers.filter(tier =>
        this.matchesSearch(
            this.gemService.getGemDefinitionName(gem, tier),
            search
        )
    );
  }

  selectGem(gem: GemDefinitionDTO, tier: number) {
    if (this.canSelectGem(gem.gemType)) {
      const instance: GemInstanceDTO = {
        gemCategory: "GEM",
        gemType: [gem.gemType],
        tier: tier,
      };
      this.selected.emit(instance);
    }
  }

  cancel() {
    this.cancelled.emit();
  }

  getFilteredGems(): GemDefinitionDTO[] {
    const search = this.searchTerm.toLowerCase().trim();

    return Object.values(this.gemConfig)
        .filter(gem =>
            !search ||
            this.getTiers(gem).some(tier =>
                this.matchesSearch(
                    this.gemService.getGemDefinitionName(gem, tier),
                    search
                )
            )
        );
  }

  private matchesSearch(text: string, search: string): boolean {
    const searchWords = search
        .toLowerCase()
        .trim()
        .split(/\s+/);

    const textLower = text.toLowerCase();

    return searchWords.every(word => textLower.includes(word));
  }
}

