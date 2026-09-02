import { Component, EventEmitter, Input, Output } from '@angular/core';
import { JewelDefinitionDTO } from '../../models/gamedataDTOs/JewelDefinitionDTO';
import { JewelInstanceDTO } from '../../models/instanceDTOs/JewelInstanceDTO';
import { BuildSimButton } from '../build-sim-button/build-sim-button';
import { getIcon } from '../../utils/display-utils';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-jewel-selector',
  imports: [BuildSimButton, FormsModule],
  templateUrl: './jewel-selector.html',
  styleUrl: './jewel-selector.scss',
})
export class JewelSelector {
   @Input() jewelConfig!: Record<string, JewelDefinitionDTO>;

  @Input() canSelectJewel!: (jewelType: string) => boolean;

  @Output() selected = new EventEmitter<JewelInstanceDTO>();

  @Output() cancelled = new EventEmitter<void>();

  searchTerm = '';
  maxTierOnly = true;

  getIcon = getIcon;

  ngOnInit()
  {
    for(const jewel of Object.values(this.jewelConfig))
    {
      console.log(jewel.name)
    }
  }

  getTiers(jewel: JewelDefinitionDTO): number[] {
    const tiers = Object.keys(jewel.descriptionPerTier)
      .map(Number)
      .sort((a, b) => a - b);

    return this.maxTierOnly ? [tiers[tiers.length - 1]] : tiers;
  }

  selectJewel(jewel: JewelDefinitionDTO, tier: number) {
    if (this.canSelectJewel(jewel.jewelType)) {
      const instance: JewelInstanceDTO = {
        jewelType: jewel.jewelType,
        tier: tier,
      };
      this.selected.emit(instance);
    }else{

    }
  }

  cancel() {
    this.cancelled.emit();
  }

getFilteredJewels(): JewelDefinitionDTO[] {
  const search = this.searchTerm.toLowerCase().trim();

  return Object.values(this.jewelConfig)
    .filter(jewel => jewel.name.toLowerCase().includes(search));
}

  getJewelIcon(jewel: JewelDefinitionDTO | null, tier: number)
  {
    if(jewel === null) return 'jewel-icons/default.png';

    const jewelName = this.jewelConfig[jewel.jewelType].name;
    return 'jewel-icons/'+this.getIcon(jewelName, tier);
  }
}
