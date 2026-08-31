import { Component, EventEmitter, Input, Output } from '@angular/core';
import { DragonStoneDefinitionDTO } from '../../models/gamedataDTOs/DragonStoneDefinitionDTO';
import { CharacterDTO } from '../../models/instanceDTOs/CharacterDTO';
import { DragonCrestTrinketDTO } from '../../models/instanceDTOs/DragonCrestTrinketDTO';
import { DragonStoneInstanceDTO } from '../../models/instanceDTOs/DragonStoneInstanceDTO';
import { BuildSimButton } from '../build-sim-button/build-sim-button';
import { getDragonStoneIcon } from '../../utils/display-utils';
import { getDragonStoneName } from '../../utils/display-utils';
import { DragonstoneSelectorComponent } from '../dragonstone-selector/dragonstone-selector';

@Component({
  selector: 'app-dragoncrest-trinket-editor',
  imports: [BuildSimButton, DragonstoneSelectorComponent],
  templateUrl: './dragoncrest-trinket-editor.html',
  styleUrl: './dragoncrest-trinket-editor.scss',
})
export class DragoncrestTrinketEditor {
  @Input() scale = 1;

  @Input() character!: CharacterDTO;

  @Input() dragonStoneConfig!: DragonStoneDefinitionDTO[];

  @Output() cancelled = new EventEmitter<void>();

  @Output() confirmed = new EventEmitter<DragonCrestTrinketDTO>();

  dragonStones: (DragonStoneInstanceDTO | null)[] = Array(10).fill(null);
  showDragonStoneSelector = false;
  selectedSlot = -1;

  getDragonStoneIcon = getDragonStoneIcon;
  getDragonStoneName = getDragonStoneName;

  ngOnInit(): void {
    const existingStones = this.character.dragonCrest?.dragonStones ?? [];

    this.dragonStones = Array.from({ length: 10 }, (_, index) => existingStones[index] ?? null);
  }

  cancel() {
    this.cancelled.emit();
  }

  confirm() {
    const dragonCrest: DragonCrestTrinketDTO = {
      dragonStones: this.dragonStones.filter((stone) => stone !== null),
    };
    this.confirmed.emit(dragonCrest);
  }

  deleteDragonStone(index: number) {
    this.dragonStones[index] = null;
  }

  copyDragonStone(index: number) {
    if (!this.hasEmptyDragonStoneSlot()) return;
    for (let i = 0; i < 10; i++) {
      if (this.dragonStones[i] === null) {
        this.dragonStones[i] = this.dragonStones[index];
        return;
      }
    }
  }

  hasEmptyDragonStoneSlot(): boolean {
    return this.dragonStones.some((stone) => stone === null);
  }

  getDragonStoneDescription(index: number) {
    if(this.dragonStones[index]===null) return "";
    const stone = this.dragonStoneConfig.find(
    stone => stone.dragonStoneType === this.dragonStones[index]?.dragonStoneType);
    return stone?.description[this.dragonStones[index].tier];
  }

  openDragonStoneSelector(index: number) {
    this.selectedSlot = index;
    this.showDragonStoneSelector = true;
  }

  closeDragonStoneSelector() {
    this.selectedSlot = -1;
    this.showDragonStoneSelector = false;
  }

  confirmDragonStoneSelection(dragonStone: DragonStoneInstanceDTO) {
    this.dragonStones[this.selectedSlot] = dragonStone;
    this.closeDragonStoneSelector();
  }
}
