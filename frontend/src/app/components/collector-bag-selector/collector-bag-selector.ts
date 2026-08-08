import { Component, EventEmitter, Input, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { CharacterDTO } from '../../models/instanceDTOs/CharacterDTO';
import { CollectorBagCategoryBonusInstanceDTO } from '../../models/instanceDTOs/CollectorBagCategoryBonusInstanceDTO';
import { CollectorBagCategoryBonusDefinitionDTO } from '../../models/gamedataDTOs/CollectorBagCategoryBonusDefinitionDTO';

import {
  formatStatName,
  formatStatValueRelative
} from '../../utils/display-utils';

import { StatType } from '../../enums/StatType';
import { CollectorBagCategory } from '../../enums/CollectorBagCategory';

@Component({
  selector: 'app-collector-bag-selector',
  imports: [
    FormsModule
  ],
  templateUrl: './collector-bag-selector.html',
  styleUrl: './collector-bag-selector.scss',
})
export class CollectorBagSelector {

  @Input() scale = 1;

  @Input() categoryBonuses!: CollectorBagCategoryBonusDefinitionDTO[];

  @Input() character!: CharacterDTO;

  @Output() cancelled = new EventEmitter<void>();

  @Output() confirmed =
    new EventEmitter<CollectorBagCategoryBonusInstanceDTO[]>();

  selectedTiers: Partial<Record<CollectorBagCategory, number>> = {};

  formatStatName = formatStatName;
  formatStatValue = formatStatValueRelative;
  StatType = StatType;

  ngOnInit() {
    // Default all categories to tier 0
    for (const categoryBonus of this.categoryBonuses) {
      this.selectedTiers[categoryBonus.category] = 0;
    }

    // Restore existing selections
    for (const buff of this.character.collectorBagBuffs ?? []) {
      this.selectedTiers[buff.category] = buff.tier;
    }
  }

  getMaxTier(category: CollectorBagCategory): number {
    const categoryBonus = this.categoryBonuses.find(
      bonus => bonus.category === category
    );

    return categoryBonus?.bonuses.length ?? 0;
  }

  cancel() {
    this.cancelled.emit();
  }

confirm() {
  const selectedBuffs: CollectorBagCategoryBonusInstanceDTO[] =
    Object.entries(this.selectedTiers)
      .filter(([_, tier]) => tier > 0)
      .map(([category, tier]) => ({
        category: category as CollectorBagCategory,
        tier
      }));

  this.confirmed.emit(selectedBuffs);
}

hasSelectedBuffs(): boolean {
  return Object.values(this.selectedTiers).some(tier => tier > 0);
}

getSelectedStats(): { type: StatType; value: number }[] {

  const stats = new Map<StatType, number>();

  for (const category of this.categoryBonuses) {

    const tier = this.selectedTiers[category.category] ?? 0;

    if (tier <= 0) {
      continue;
    }

    // tier is cumulative:
    // tier 2 => bonus 1 + bonus 2
    for (let i = 0; i < tier; i++) {

      const bonus = category.bonuses[i];

      for (const [statType, value] of Object.entries(bonus.stats)) {

        const type = statType as StatType;

        stats.set(
          type,
          (stats.get(type) ?? 0) + value
        );
      }
    }
  }

  return Array.from(stats.entries()).map(([type, value]) => ({
    type,
    value
  }));
}

getSliderWidth(category: CollectorBagCategory): number {
  const tierCount = this.getMaxTier(category);
  const tierSpacing = 60;

  return tierCount * tierSpacing;
}

getTierValues(category: CollectorBagCategory): number[] {
  const maxTier = this.getMaxTier(category);

  return Array.from(
    { length: maxTier + 1 },
    (_, index) => index
  );
}

}