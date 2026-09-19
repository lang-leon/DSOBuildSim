import { ConnectedPosition, OverlayModule } from '@angular/cdk/overlay';
import { NgClass } from '@angular/common';
import { Component, EventEmitter, Input, Output } from '@angular/core';
import { RuneTrinketDTO } from '../../models/instanceDTOs/RuneTrinketDTO';
import { JewelTrinketDTO } from '../../models/instanceDTOs/JewelTrinketDTO';
import { DragonCrestTrinketDTO } from '../../models/instanceDTOs/DragonCrestTrinketDTO';
import { TrinketTooltip } from '../trinket-tooltip/trinket-tooltip';
import { RuneDefinitionDTO } from '../../models/gamedataDTOs/RuneDefinitionDTO';
import { JewelDefinitionDTO } from '../../models/gamedataDTOs/JewelDefinitionDTO';
import { DragonStoneDefinitionDTO } from '../../models/gamedataDTOs/DragonStoneDefinitionDTO';

@Component({
  selector: 'app-build-sim-button',
  imports: [OverlayModule, NgClass, TrinketTooltip],
  templateUrl: './build-sim-button.html',
  styleUrl: './build-sim-button.scss',
})
export class BuildSimButton {
  @Input()
  icon!: string;

  @Input()
  slotName!: string;

  @Input()
  tooltipTitle?: string;

  @Input() tooltipTitleClass: string = '';

  @Input()
  tooltipDescription: string | string[] = [];

  @Input() runeTrinket?: RuneTrinketDTO;

  @Input() runeConfig?: Record<string, RuneDefinitionDTO>;

  @Input() jewelTrinket?: JewelTrinketDTO;

  @Input() jewelConfig?: Record<string, JewelDefinitionDTO>;

  @Input() dragonCrestTrinket?: DragonCrestTrinketDTO;

  @Input() dragonStoneConfig?: Record<string, DragonStoneDefinitionDTO>;

  @Input()
  overlayText?: string;

  @Input() disabled = false;

  @Output()
  clicked = new EventEmitter<void>();

  showTooltip = false;

  tooltipPositions: ConnectedPosition[] = [
    {
      originX: 'center',
      originY: 'top',
      overlayX: 'center',
      overlayY: 'bottom',
      offsetY: -8,
    },
    {
      originX: 'center',
      originY: 'bottom',
      overlayX: 'center',
      overlayY: 'top',
      offsetY: 8,
    },
  ];

  get hasTooltip(): boolean {
    return !!(this.slotName || this.tooltipTitle || this.tooltipDescription);
  }

  get effectiveTooltipTitle(): string {
    return this.tooltipTitle || this.slotName;
  }

  onMouseEnter(): void {
    this.showTooltip = true;
  }

  onMouseLeave(): void {
    this.showTooltip = false;
  }

  onClick(): void {
    if (this.disabled) {
      return;
    }

    this.clicked.emit();
  }
}
