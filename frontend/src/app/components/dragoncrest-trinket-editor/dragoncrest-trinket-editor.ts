import { Component, EventEmitter, Input, Output } from '@angular/core';
import { DragonStoneDefinitionDTO } from '../../models/gamedataDTOs/DragonStoneDefinitionDTO';
import { CharacterDTO } from '../../models/instanceDTOs/CharacterDTO';
import { DragonCrestTrinketDTO } from '../../models/instanceDTOs/DragonCrestTrinketDTO';
import { DragonStoneInstanceDTO } from '../../models/instanceDTOs/DragonStoneInstanceDTO';
import { BuildSimButton } from '../build-sim-button/build-sim-button';
import { formatName } from '../../utils/display-utils';

@Component({
  selector: 'app-dragoncrest-trinket-editor',
  imports: [BuildSimButton],
  templateUrl: './dragoncrest-trinket-editor.html',
  styleUrl: './dragoncrest-trinket-editor.scss',
})
export class DragoncrestTrinketEditor {
  @Input() scale = 1;

  @Input() dragonStoneDefinitions!: DragonStoneDefinitionDTO[];

  @Input() character!: CharacterDTO;

  @Output() cancelled = new EventEmitter<void>();

  @Output() confirmed = new EventEmitter<DragonCrestTrinketDTO>();

  dragonStones: (DragonStoneInstanceDTO | null)[] = Array(10).fill(null);
  showDragonStoneSelector = false;

  ngOnInit(): void {
    const existingStones = this.character.dragonCrest?.dragonStones ?? [];

    this.dragonStones = Array.from({ length: 10 }, (_, index) => existingStones[index] ?? null);
  }

  onSlotClicked(slotIndex: number): void {
    console.log('Dragon Crest slot clicked:', this.dragonStones[slotIndex]);
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

  getDragonStoneIcon(dragonStone: DragonStoneInstanceDTO | null) {
    if (dragonStone === null) {
      return 'dragon-stone-icons/empty-dragon-stone.png';
    }

    const stoneType = dragonStone.dragonStoneType.toLowerCase();

    let tierName: string;

    switch (dragonStone.tier) {
      case 3:
        tierName = 'dragon-hatchlings';
        break;
      case 4:
        tierName = 'mighty-dragons';
        break;
      case 5:
        tierName = 'dragon-elders';
        break;
      default:
        return 'dragon-stone-icons/empty-dragon-stone.png';
    }

    return `dragon-stone-icons/${tierName}-${stoneType}.png`;
  }

  getDragonStoneName(dragonStone: DragonStoneInstanceDTO | null) {
    if (dragonStone === null) {
      return 'Empty';
    }

    const stoneType = formatName(dragonStone.dragonStoneType);

    let tierName: string;

    switch (dragonStone.tier) {
      case 3:
        tierName = "Dragon Hatchling's";
        break;
      case 4:
        tierName = "Mighty Dragon's";
        break;
      case 5:
        tierName = "Dragon Elder's";
        break;
      default:
        return 'Empty';
    }

    return `${tierName} ${stoneType}`;
  }

  deleteDragonStone(index: number) {
    this.dragonStones[index]=null;
  }

  copyDragonStone(index: number) {
    if(!this.hasEmptyDragonStoneSlot()) return;
    for(let i=0; i<10; i++){
      if(this.dragonStones[i]===null){
        this.dragonStones[i]=this.dragonStones[index];
        return;
      }
    }
  }

  hasEmptyDragonStoneSlot(): boolean {
    return this.dragonStones.some((stone) => stone === null);
  }

  openDragonStoneSelector(index: number) {
    this.showDragonStoneSelector = true;
  }

  closeDragonCrestSelector(){
    this.showDragonStoneSelector = false;
  }
}
