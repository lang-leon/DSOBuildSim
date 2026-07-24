import { Component, EventEmitter, Input, Output } from '@angular/core';
import { CharacterDTO } from '../../models/instanceDTOs/CharacterDTO';
import { EssenceDefinitionDTO } from '../../models/gamedataDTOs/EssenceDefinitionDTO';
import { FormsModule } from '@angular/forms';
import { EssenceInstanceDTO } from '../../models/instanceDTOs/EssenceInstanceDTO';
import { formatStatName, formatStatValueRelative } from '../../utils/display-utils';
import { StatType } from '../../enums/StatType';

@Component({
  selector: 'app-essence-selector',
  imports: [
    FormsModule
  ],
  templateUrl: './essence-selector.html',
  styleUrl: './essence-selector.scss',
})
export class EssenceSelector {
  @Input() essences!: EssenceDefinitionDTO[];

  @Input() character!: CharacterDTO;

  @Output() cancelled = new EventEmitter<void>();

  @Output() confirmed = new EventEmitter<{
    essenceType: string;
    tier: number;
  } | null>();

  selectedEssence: EssenceDefinitionDTO | null = null;
  selectedTier: number = 0;

  formatStatName = formatStatName;
  formatStatValue = formatStatValueRelative;
  StatType = StatType;

  ngOnInit() {
    if (this.character.essence) {
        this.selectedEssence =
            this.essences.find(
                essence => essence.essenceType === this.character.essence!.essenceType
            ) ?? null;

        this.selectedTier = this.character.essence.tier;
    }
}

  get essenceTypes(): string[] {
    return [...new Set(this.essences.map((essence) => essence.essenceType))];
  }

  get availableTiers(): number[] {
    if (!this.selectedEssence) {
      return [];
    }

    return Object.keys(this.selectedEssence.damage)
      .map(Number)
      .sort((a, b) => a - b);
  }

  onEssenceChange(essence: EssenceDefinitionDTO) {
    this.selectedEssence = essence;
    this.selectedTier = essence.defaultTier;
  }

  cancel() {
    this.cancelled.emit();
  }

confirm() {
    if (!this.selectedEssence) {
        this.confirmed.emit(null);
        return;
    }

    const essence: EssenceInstanceDTO = {
        essenceType: this.selectedEssence.essenceType,
        tier: this.selectedTier
    };

    this.confirmed.emit(essence);
}
}
