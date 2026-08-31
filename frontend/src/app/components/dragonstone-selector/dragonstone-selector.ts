import { Component, EventEmitter, Input, Output } from '@angular/core';
import { DragonStoneInstanceDTO } from '../../models/instanceDTOs/DragonStoneInstanceDTO';
import { DragonStoneDefinitionDTO } from '../../models/gamedataDTOs/DragonStoneDefinitionDTO';
import { BuildSimButton } from '../build-sim-button/build-sim-button';
import { getDragonStoneIcon } from '../../utils/display-utils';
import { getDragonStoneName } from '../../utils/display-utils';
import { getDragonStoneDescription } from '../../utils/display-utils';

@Component({
  selector: 'app-dragonstone-selector',
  imports: [BuildSimButton],
  templateUrl: './dragonstone-selector.html',
  styleUrl: './dragonstone-selector.scss',
})
export class DragonstoneSelectorComponent {
  @Input() dragonStoneConfig!: DragonStoneDefinitionDTO[];

  @Output() selected = new EventEmitter<DragonStoneInstanceDTO>();

  @Output() cancelled = new EventEmitter<void>();

  getDragonStoneIcon = getDragonStoneIcon;
  getDragonStoneName = getDragonStoneName;
  getDragonStoneDescription = getDragonStoneDescription;

  getTiers(dragonStone: DragonStoneDefinitionDTO): number[] {
    return Object.keys(dragonStone.stats)
      .map(Number)
      .sort((a, b) => a - b);
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
