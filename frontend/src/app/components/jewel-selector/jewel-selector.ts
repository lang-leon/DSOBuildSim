import { Component, EventEmitter, Input, Output } from '@angular/core';
import { JewelDefinitionDTO } from '../../models/gamedataDTOs/JewelDefinitionDTO';
import { JewelInstanceDTO } from '../../models/instanceDTOs/JewelInstanceDTO';
import { BuildSimButton } from '../build-sim-button/build-sim-button';
import { FormsModule } from '@angular/forms';
import { JewelService } from '../../utils/jewel-service';
import { getTierName } from '../../utils/tooltip-utils';

@Component({
  selector: 'app-jewel-selector',
  imports: [BuildSimButton, FormsModule],
  templateUrl: './jewel-selector.html',
  styleUrl: './jewel-selector.scss',
})
export class JewelSelector {
  constructor(public jewelService: JewelService) {}

  @Input() jewelConfig!: Record<string, JewelDefinitionDTO>;

  @Input() canSelectJewel!: (jewelType: string) => boolean;

  @Output() selected = new EventEmitter<JewelInstanceDTO>();

  @Output() cancelled = new EventEmitter<void>();

  searchTerm = '';
  maxTierOnly = true;

  getTierName = getTierName;

  ngOnInit() {
    this.jewelService.setJewelConfig(this.jewelConfig);
  }

  getTiers(jewel: JewelDefinitionDTO): number[] {
    const tiers = Object.keys(jewel.descriptionPerTier)
      .map(Number)
      .sort((a, b) => a - b);

    return this.maxTierOnly ? [tiers[tiers.length - 1]] : tiers;
  }

  getFilteredJewels(): JewelDefinitionDTO[] {
    const search = this.searchTerm.toLowerCase().trim();

    return Object.values(this.jewelConfig).filter((jewel) =>
      jewel.name.toLowerCase().includes(search),
    );
  }

  selectJewel(jewel: JewelDefinitionDTO, tier: number) {
    const instance: JewelInstanceDTO = {
      jewelType: jewel.jewelType,
      tier: tier,
    };
    this.selected.emit(instance);
  }

  cancel() {
    this.cancelled.emit();
  }
}
