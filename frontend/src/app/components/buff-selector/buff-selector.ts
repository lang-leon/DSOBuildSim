import { Component, EventEmitter, Input, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BuffDefinitionDTO } from '../../models/gamedataDTOs/BuffDefinitionDTO';
import { BuffInstanceDTO } from '../../models/instanceDTOs/BuffInstanceDTO';
import {
  formatStatName,
  formatStatValueAbsolute,
  formatStatValueRelative,
} from '../../utils/display-utils';
import { StatType } from '../../enums/StatType';
import { BuffCategory } from '../../enums/BuffCategory';
import { KeyValuePipe } from '@angular/common';

@Component({
  selector: 'app-buff-selector',
  imports: [FormsModule, KeyValuePipe],
  templateUrl: './buff-selector.html',
  styleUrl: './buff-selector.scss',
})
export class BuffSelector {
  @Input() scale = 1;

  @Input() buffConfig!: Record<string, BuffDefinitionDTO>;

  @Input() buff!: BuffInstanceDTO | null;

  @Input() buffCategory!: BuffCategory;

  @Output() cancelled = new EventEmitter<void>();

  @Output() confirmed = new EventEmitter<BuffInstanceDTO | null>();

  selectedBuff: BuffDefinitionDTO | null = null;
  selectedTier: number = 0;

  formatStatName = formatStatName;
  formatStatValue = formatStatValueRelative;
  StatType = StatType;

  ngOnInit() {
    if (this.buff) {
      this.selectedBuff = this.buffConfig[this.buff.type];

      this.selectedTier = this.buff.tier;
    }
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

  formatBuffValue(value: number): string {
    if (this.buffCategory === BuffCategory.TONIC) {
      return formatStatValueAbsolute(value, 1);
    }

    return formatStatValueRelative(value, 2);
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
      tier: this.selectedTier,
    };

    this.confirmed.emit(buff);
  }
}
