import { Component, Input } from '@angular/core';
import { ItemInstanceDTO } from '../../models/instanceDTOs/ItemInstanceDTO';
import { ItemService } from '../../utils/item-service';
import { GemService } from '../../utils/gem-service';
import { SetDTO } from '../../models/gamedataDTOs/SetDTO';
import { ItemDefinitionDTO } from '../../models/gamedataDTOs/ItemDefinitionDTO';
import { GemDefinitionDTO } from '../../models/gamedataDTOs/GemDefinitionDTO';
import { KeyValuePipe, NgClass } from '@angular/common';
import { StatType } from '../../enums/StatType';
import { ItemSlot } from '../../enums/ItemSlot';
import { getTierName } from '../../utils/tooltip-utils';

@Component({
  selector: 'app-item-tooltip',
  imports: [KeyValuePipe, NgClass],
  templateUrl: './item-tooltip.html',
  styleUrl: './item-tooltip.scss',
})
export class ItemTooltip {
  constructor(
    public itemService: ItemService,
    public gemService: GemService,
  ) {}

  @Input() item?: ItemInstanceDTO;

  @Input() equippedItems: Partial<Record<ItemSlot, ItemInstanceDTO>> = {};

  @Input() equippedSets: Record<string, Set<string>> = {};

  @Input() itemConfig?: Record<string, ItemDefinitionDTO>;

  @Input() setConfig?: Record<string, SetDTO>;

  @Input() gemConfig?: Record<string, GemDefinitionDTO>;

  Object = Object;
  getTierName = getTierName;

  ngOnInit() {
    if (this.itemConfig && this.setConfig && this.gemConfig) {
      this.itemService.setConfigs(this.itemConfig, this.setConfig);
      this.itemService.setGemConfig(this.gemConfig);
      this.gemService.setGemConfig(this.gemConfig);
    }
  }

  get baseValueEntries(): { type: StatType; value: number }[] {
    if (!this.item) return [];

    return Object.entries(this.item.baseValues).map(([type, value]) => ({
      type: type as StatType,
      value: value as number,
    }));
  }
}
