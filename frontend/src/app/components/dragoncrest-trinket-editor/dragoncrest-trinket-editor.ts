import { Component, EventEmitter, Input, Output } from '@angular/core';
import { DragonStoneDefinitionDTO } from '../../models/gamedataDTOs/DragonStoneDefinitionDTO';
import { CharacterDTO } from '../../models/instanceDTOs/CharacterDTO';
import { DragonCrestTrinketDTO } from '../../models/instanceDTOs/DragonCrestTrinketDTO';
import { DragonStoneInstanceDTO } from '../../models/instanceDTOs/DragonStoneInstanceDTO';
import { BuildSimButton } from '../build-sim-button/build-sim-button';
import { getIcon } from '../../utils/display-utils';
import { DragonstoneSelectorComponent } from '../dragonstone-selector/dragonstone-selector';
import { DragonStoneService } from '../../utils/dragon-stone-service';

@Component({
  selector: 'app-dragoncrest-trinket-editor',
  imports: [BuildSimButton, DragonstoneSelectorComponent],
  templateUrl: './dragoncrest-trinket-editor.html',
  styleUrl: './dragoncrest-trinket-editor.scss',
})
export class DragoncrestTrinketEditor {
  constructor(public dragonStoneService: DragonStoneService) {}

  @Input() scale = 1;

  @Input() dragonCrest!: DragonCrestTrinketDTO;

  @Input() dragonStoneConfig!: Record<string, DragonStoneDefinitionDTO>;

  @Output() cancelled = new EventEmitter<void>();

  @Output() confirmed = new EventEmitter<DragonCrestTrinketDTO>();

  dragonStones: (DragonStoneInstanceDTO | null)[] = Array(10).fill(null);
  showDragonStoneSelector = false;
  selectedSlot = -1;

  getIcon = getIcon;

  ngOnInit(): void {
    this.dragonStoneService.setDragonStoneConfig(this.dragonStoneConfig);

    const existingStones = this.dragonCrest.dragonStones ?? [];
    this.dragonStones = Array.from({ length: 10 }, (_, index) => existingStones[index] ?? null);
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

  cancel() {
    this.cancelled.emit();
  }

  confirm() {
    const dragonCrest: DragonCrestTrinketDTO = {
      dragonStones: this.dragonStones.filter((stone) => stone !== null),
    };
    this.confirmed.emit(dragonCrest);
  }
}
