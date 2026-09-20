import { Component, EventEmitter, Input, Output } from '@angular/core';
import { PetDefinitionDTO } from '../../models/gamedataDTOs/PetDefinitionDTO';
import { FormsModule } from '@angular/forms';
import { PetInstanceDTO } from '../../models/instanceDTOs/PetInstanceDTO';
import { KeyValuePipe } from '@angular/common';
import { formatStatName, formatStatValueRelative } from '../../utils/display-utils';

@Component({
  selector: 'app-pet-selector',
  imports: [FormsModule, KeyValuePipe],
  templateUrl: './pet-selector.html',
  styleUrl: './pet-selector.scss',
})
export class PetSelector {
  @Input() scale = 1;

  @Input() petConfig!: Record<string, PetDefinitionDTO>;

  @Input() pet!: PetInstanceDTO | null;

  @Output() cancelled = new EventEmitter<void>();

  @Output() confirmed = new EventEmitter<{
    petType: string;
    tier: number;
  } | null>();

  selectedPet: PetDefinitionDTO | null = null;
  selectedTier: number = 0;

  formatStatName = formatStatName;
  formatStatValue = formatStatValueRelative;

  ngOnInit() {
    if (this.pet) {
      this.selectedPet = this.petConfig[this.pet.petType];
      this.selectedTier = this.pet.tier;
    }
  }

  get availableTiers(): number[] {
    if (!this.selectedPet) {
      return [];
    }
    return Object.keys(this.selectedPet.stats)
      .map(Number)
      .sort((a, b) => a - b);
  }

  onPetChange(pet: PetDefinitionDTO) {
    this.selectedPet = pet;
    this.selectedTier = this.selectedPet.tier;
  }

  cancel() {
    this.cancelled.emit();
  }

  confirm() {
    if (!this.selectedPet) {
      this.confirmed.emit(null);
      return;
    }

    const pet: PetInstanceDTO = {
      petType: this.selectedPet.petType,
      tier: this.selectedTier,
    };

    this.confirmed.emit(pet);
  }
}
