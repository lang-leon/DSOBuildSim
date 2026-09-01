import { ConnectedPosition, OverlayModule } from '@angular/cdk/overlay';
import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-build-sim-button',
  imports: [
    OverlayModule
  ],
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

  @Input()
  tooltipDescription?: string;

  @Input()
  overlayText?: string;

  @Output()
  clicked = new EventEmitter<void>();

    showTooltip = false;

  tooltipPositions: ConnectedPosition[] = [
    {
      originX: 'center',
      originY: 'top',
      overlayX: 'center',
      overlayY: 'bottom',
      offsetY: -8
    },
    {
      originX: 'center',
      originY: 'bottom',
      overlayX: 'center',
      overlayY: 'top',
      offsetY: 8
    }
  ];

  get hasTooltip(): boolean {
    return !!(
      this.slotName ||
      this.tooltipTitle ||
      this.tooltipDescription
    );
  }

  get effectiveTooltipTitle(): string {
    return this.tooltipTitle || this.slotName;
  }

  onMouseEnter(): void {
    if (this.hasTooltip) {
      this.showTooltip = true;
    }
  }

  onMouseLeave(): void {
    this.showTooltip = false;
  }

  onClick() {
    this.clicked.emit();
  }
}
