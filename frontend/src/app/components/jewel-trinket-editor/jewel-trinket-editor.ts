import { Component, EventEmitter, Input, Output } from '@angular/core';
import { JewelTrinketDTO } from '../../models/instanceDTOs/JewelTrinketDTO';
import { JewelInstanceDTO } from '../../models/instanceDTOs/JewelInstanceDTO';
import { JewelDefinitionDTO } from '../../models/gamedataDTOs/JewelDefinitionDTO';
import { JewelSelector } from '../jewel-selector/jewel-selector';
import { BuildSimButton } from '../build-sim-button/build-sim-button';
import { formatName, getIcon } from '../../utils/display-utils';

@Component({
  selector: 'app-jewel-trinket-editor',
  imports: [
    JewelSelector,
    BuildSimButton
  ],
  templateUrl: './jewel-trinket-editor.html',
  styleUrl: './jewel-trinket-editor.scss',
})
export class JewelTrinketEditor {
  @Input() scale = 1;

  @Input() jewelTrinket!: JewelTrinketDTO;

  @Input() jewelConfig!: JewelDefinitionDTO[];

  @Input() canAddJewel!: (jewelType: string, jewels: (JewelInstanceDTO | null)[]) => boolean;

  @Output() cancelled = new EventEmitter<void>();

  @Output() confirmed = new EventEmitter<JewelTrinketDTO>();

  jewels: (JewelInstanceDTO | null)[] = Array(10).fill(null);
  showJewelSelector = false;
  selectedSlot = -1;

  getIcon = getIcon;
  formatName = formatName;

  ngOnInit(): void {
    const existingStones = this.jewelTrinket.jewels ?? [];

    this.jewels = Array.from({ length: 10 }, (_, index) => existingStones[index] ?? null);
  }

  cancel() {
    this.cancelled.emit();
  }

  confirm() {
    const jewelTrinket: JewelTrinketDTO = {
      jewels: this.jewels.filter((jewel) => jewel !== null),
    };
    this.confirmed.emit(jewelTrinket);
  }

  deleteJewel(index: number) {
    this.jewels[index] = null;
  }

  copyJewel(index: number) {
    if (this.jewels[index] === null) return;
    if (!this.hasEmptyJewelSlot()) return;
    if (!this.canAddJewel(this.jewels[index].jewelType, this.jewels)) return;
    for (let i = 0; i < 10; i++) {
      if (this.jewels[i] === null) {
        this.jewels[i] = this.jewels[index];
        return;
      }
    }
  }

  hasEmptyJewelSlot(): boolean {
    return this.jewels.some((stone) => stone === null);
  }

  canSelectJewel(jewelType: string)
  {
    return this.canAddJewel(jewelType, this.jewels);
  }

  getJewelName(index: number){
    if(this.jewels[index]===null) return "";
    const jewel = this.jewelConfig.find(
    jewel => jewel.jewelType === this.jewels[index]?.jewelType);
    return jewel?.name;
  }

  getJewelDescription(index: number) {
    if(this.jewels[index]===null) return "";
    const jewel = this.jewelConfig.find(
    jewel => jewel.jewelType === this.jewels[index]?.jewelType);
    return jewel?.descriptionPerTier[this.jewels[index].tier];
  }

  openJewelSelector(index: number) {
    this.selectedSlot = index;
    this.showJewelSelector = true;
  }

  closeJewelSelector() {
    this.selectedSlot = -1;
    this.showJewelSelector = false;
  }

  confirmJewelSelection(jewel: JewelInstanceDTO) {
    this.jewels[this.selectedSlot] = jewel;
    this.closeJewelSelector();
  }
}
