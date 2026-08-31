import { Component, EventEmitter, Input, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { CharacterDTO } from '../../models/instanceDTOs/CharacterDTO';
import { BuffDefinitionDTO } from '../../models/gamedataDTOs/BuffDefinitionDTO';
import { BuffInstanceDTO } from '../../models/instanceDTOs/BuffInstanceDTO';

import { formatStatName, formatStatValueAbsolute, formatStatValueRelative } from '../../utils/display-utils';
import { StatType } from '../../enums/StatType';
import { BuffCategory } from '../../enums/BuffCategory';

@Component({
  selector: 'app-buff-selector',
  imports: [FormsModule],
  templateUrl: './buff-selector.html',
  styleUrl: './buff-selector.scss',
})
export class BuffSelector {
  
  @Input() scale = 1;
  
  @Input() buffs!: BuffDefinitionDTO[];
  
  @Input() character!: CharacterDTO;

  @Input() buffCategory!: BuffCategory;

  @Output() cancelled = new EventEmitter<void>();

  @Output() confirmed = new EventEmitter<BuffInstanceDTO | null>();

  selectedBuff: BuffDefinitionDTO | null = null;
  selectedTier: number = 0;

  formatStatName = formatStatName;
  formatStatValue = formatStatValueRelative;
  StatType = StatType;

  ngOnInit() {
    const currentBuff =
      this.buffCategory === BuffCategory.PHYSIC
        ? this.character.physic
        : this.character.tonic;

    if (currentBuff) {
      this.selectedBuff =
        this.buffs.find(
          buff => buff.type === currentBuff.type
        ) ?? null;

      this.selectedTier = currentBuff.tier;
    }
  }

  get buffTypes(): string[] {
    return [...new Set(
      this.buffs.map(buff => buff.type)
    )];
  }

  get availableTiers(): number[] {
    if (!this.selectedBuff) {
      return [];
    }

    return Object.keys(this.selectedBuff.statsPerTier)
      .map(Number)
      .sort((a, b) => a - b);
  }

  onBuffChange(buff: BuffDefinitionDTO | null) {
    this.selectedBuff = buff;

    if (buff) {
      this.selectedTier = buff.defaultTier;
    } else {
      this.selectedTier = 0;
    }
  }

  cancel() {
    this.cancelled.emit();
  }

  confirm() {
    if (!this.selectedBuff) {
      this.confirmed.emit(null);
      return;
    }

    const buff: BuffInstanceDTO = {
      type: this.selectedBuff.type,
      tier: this.selectedTier
    };

    this.confirmed.emit(buff);
  }

  formatBuffValue(value: number): string {
    if (this.buffCategory === BuffCategory.TONIC) {
        return formatStatValueAbsolute(value, 1);
    }

    return formatStatValueRelative(value, 2);
}
}