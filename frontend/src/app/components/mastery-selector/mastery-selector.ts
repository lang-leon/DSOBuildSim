import { Component, EventEmitter, Input, Output } from '@angular/core';
import { CharacterDTO } from '../../models/instanceDTOs/CharacterDTO';
import { FormsModule } from '@angular/forms';
import { formatStatName, formatStatValueRelative } from '../../utils/display-utils';
import { StatType } from '../../enums/StatType';
import { MasteryType } from '../../enums/MasteryType';

@Component({
  selector: 'app-mastery-selector',
  imports: [
    FormsModule
  ],
  templateUrl: './mastery-selector.html',
  styleUrl: './mastery-selector.scss',
})
export class MasterySelector {

  @Input() scale = 1;

  @Input() character!: CharacterDTO;

  @Output() cancelled = new EventEmitter<void>();

  @Output() confirmed = new EventEmitter<{
    masteryType: MasteryType;
    level: number;
  }>();

  selectedMastery: MasteryType = MasteryType.NONE;
  selectedLevel: number = 0;

  formatStatName = formatStatName;
  formatStatValue = formatStatValueRelative;
  StatType = StatType;
  MasteryType = MasteryType;

  ngOnInit() {
    this.selectedMastery = this.character.masteryType;
    this.selectedLevel = this.character.masteryLevel;
}

  onMasteryChange(mastery: MasteryType) {
  if (this.selectedMastery === mastery) {
    this.selectedMastery = MasteryType.NONE;
    this.selectedLevel = 0;
    return;
  }

  this.selectedMastery = mastery;

  if (this.selectedLevel === 0) {
    this.selectedLevel = 1;
  }
}

  cancel() {
    this.cancelled.emit();
  }

confirm() {
  this.confirmed.emit({
    masteryType: this.selectedMastery,
    level: this.selectedLevel
  });
}

getMasteryIcon(type: MasteryType): string {
  if(type === this.selectedMastery)
  {
    console.log(type.toLowerCase);
    return "inventory-icons/mastery-"+type.toLowerCase()+".png"
  }
  else
  {
    return "inventory-icons/mastery-"+type.toLowerCase()+"-inactive.png"
  }
}

//temporary until backend uses masterydtos
getMasteryResistance(type: MasteryType): string {
  if (this.selectedMastery === type) {
    return "+ " + (50 + (this.selectedLevel - 1) * 5).toFixed(2) + " %";
  }

  return "- " + (25).toFixed(2) + " %";
}
}
