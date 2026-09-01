import { Component, EventEmitter, Input, Output } from '@angular/core';
import { JewelDefinitionDTO } from '../../models/gamedataDTOs/JewelDefinitionDTO';
import { JewelInstanceDTO } from '../../models/instanceDTOs/JewelInstanceDTO';
import { BuildSimButton } from '../build-sim-button/build-sim-button';
import { getIcon } from '../../utils/display-utils';

@Component({
  selector: 'app-jewel-selector',
  imports: [
    BuildSimButton
  ],
  templateUrl: './jewel-selector.html',
  styleUrl: './jewel-selector.scss',
})
export class JewelSelector {
  @Input() jewelConfig!: JewelDefinitionDTO[];

  @Output() selected = new EventEmitter<JewelInstanceDTO>();

  @Output() cancelled = new EventEmitter<void>();

  getIcon = getIcon;

  getTiers(jewel: JewelDefinitionDTO): number[] {
    return Object.keys(jewel.statsPerTier)
      .map(Number)
      .sort((a, b) => a - b);
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
