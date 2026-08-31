import { Component, EventEmitter, Input, Output } from '@angular/core';
import { CharacterDTO } from '../../models/instanceDTOs/CharacterDTO';
import { PetDefinitionDTO } from '../../models/gamedataDTOs/PetDefinitionDTO';
import { FormsModule } from '@angular/forms';
import { PetInstanceDTO } from '../../models/instanceDTOs/PetInstanceDTO';
import { KeyValuePipe } from '@angular/common';
import { formatStatName, formatStatValueRelative } from '../../utils/display-utils';

@Component({
  selector: 'app-pet-selector',
  imports: [
    FormsModule,
    KeyValuePipe
  ],
  templateUrl: './pet-selector.html',
  styleUrl: './pet-selector.scss',
})
export class PetSelector {
  
  @Input() scale = 1;
  
  @Input() pets!: PetDefinitionDTO[];

  @Input() character!: CharacterDTO;

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
    if (this.character.pet) {
        this.selectedPet =
            this.pets.find(
                pet => pet.petType === this.character.pet!.petType
            ) ?? null;

        this.selectedTier = this.character.pet.tier;
    }
}

  get petTypes(): string[] {
    return [...new Set(this.pets.map((pet) => pet.petType))];
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
        tier: this.selectedTier
    };

    this.confirmed.emit(pet);
}
}
