import { Component, EventEmitter, Input, Output } from '@angular/core';
import { CharacterDTO } from '../../models/instanceDTOs/CharacterDTO';
import { EssenceDefinitionDTO } from '../../models/gamedataDTOs/EssenceDefinitionDTO';
import { FormsModule } from '@angular/forms';
import { EssenceInstanceDTO } from '../../models/instanceDTOs/EssenceInstanceDTO';
import { formatStatName, formatStatValueRelative } from '../../utils/display-utils';
import { StatType } from '../../enums/StatType';
import { KeyValuePipe } from '@angular/common';

@Component({
  selector: 'app-essence-selector',
  imports: [FormsModule, KeyValuePipe],
  templateUrl: './essence-selector.html',
  styleUrl: './essence-selector.scss',
})
export class EssenceSelector {
  @Input() scale = 1;

  @Input() essenceConfig!: Record<string, EssenceDefinitionDTO>;

  @Input() essence!: EssenceInstanceDTO | null;

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
    if (this.essence) {
      this.selectedEssence = this.essenceConfig[this.essence.essenceType];

      this.selectedTier = this.essence.tier;
    }
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
      tier: this.selectedTier,
    };

    this.confirmed.emit(essence);
  }
}
