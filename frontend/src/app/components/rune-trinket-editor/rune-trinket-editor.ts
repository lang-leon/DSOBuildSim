import { Component, EventEmitter, Input, Output } from '@angular/core';
import { RuneSelector } from '../rune-selector/rune-selector';
import { BuildSimButton } from '../build-sim-button/build-sim-button';
import { RuneTrinketDTO } from '../../models/instanceDTOs/RuneTrinketDTO';
import { RuneDefinitionDTO } from '../../models/gamedataDTOs/RuneDefinitionDTO';
import { RuneInstanceDTO } from '../../models/instanceDTOs/RuneInstanceDTO';
import { formatName, formatStatName, getIcon } from '../../utils/display-utils';

@Component({
  selector: 'app-rune-trinket-editor',
  imports: [RuneSelector, BuildSimButton],
  templateUrl: './rune-trinket-editor.html',
  styleUrl: './rune-trinket-editor.scss',
})
export class RuneTrinketEditor {
  @Input() scale = 1;

  @Input() runeTrinket!: RuneTrinketDTO;

  @Input() runeConfig!: Record<string, RuneDefinitionDTO>;

  @Input() canAddRune!: (runeType: string, runes: (RuneInstanceDTO | null)[]) => boolean;

  @Output() cancelled = new EventEmitter<void>();

  @Output() confirmed = new EventEmitter<RuneTrinketDTO>();

  runes: (RuneInstanceDTO | null)[] = Array(10).fill(null);
  showRuneSelector = false;
  selectedSlot = -1;

  getIcon = getIcon;
  formatName = formatName;

  ngOnInit(): void {
    const existingStones = this.runeTrinket.runes ?? [];

    this.runes = Array.from({ length: 10 }, (_, index) => existingStones[index] ?? null);
  }

  cancel() {
    this.cancelled.emit();
  }

  confirm() {
    const runeTrinket: RuneTrinketDTO = {
      runes: this.runes.filter((rune) => rune !== null),
    };
    this.confirmed.emit(runeTrinket);
  }

  deleteRune(index: number) {
    this.runes[index] = null;
  }

  copyRune(index: number) {
    if (this.runes[index] === null) return;
    if (!this.hasEmptyRuneSlot()) return;
    if (!this.canAddRune(this.runes[index].runeType, this.runes)) return;
    for (let i = 0; i < 10; i++) {
      if (this.runes[i] === null) {
        this.runes[i] = this.runes[index];
        return;
      }
    }
  }

  hasEmptyRuneSlot(): boolean {
    return this.runes.some((stone) => stone === null);
  }

  canSelectRune(runeType: string) {
    return this.canAddRune(runeType, this.runes);
  }

  getRuneName(index: number) {
    if (this.runes[index] === null) return '';
    const rune = this.runeConfig[this.runes[index]?.runeType];
    return rune?.name;
  }

  getRuneDescription(index: number) {
    if (this.runes[index] === null) return '';
    const rune = this.runeConfig[this.runes[index]?.runeType];
    let desc = rune?.description.replace('{tier}', String(this.runes[index].tier));
    
    for (const [statType, value] of Object.entries(rune.statsPerTier[this.runes[index].tier])) {
      desc += `\n+${(value*100).toFixed(2)}% ${formatStatName(statType)}`;
    }
    return desc.trim();
  }

  getRuneIcon(rune: RuneInstanceDTO | null) {
    if (rune === null) return 'rune-icons/default.png';

    const runeName = this.runeConfig[rune.runeType].name;
    return 'rune-icons/' + this.getIcon(runeName, rune.tier);
  }

  openRuneSelector(index: number) {
    this.selectedSlot = index;
    this.showRuneSelector = true;
  }

  closeRuneSelector() {
    this.selectedSlot = -1;
    this.showRuneSelector = false;
  }

  confirmRuneSelection(rune: RuneInstanceDTO) {
    this.runes[this.selectedSlot] = rune;
    this.closeRuneSelector();
  }
}
