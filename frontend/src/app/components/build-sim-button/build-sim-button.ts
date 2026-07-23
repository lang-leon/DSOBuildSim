import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-build-sim-button',
  imports: [],
  templateUrl: './build-sim-button.html',
  styleUrl: './build-sim-button.scss',
})
export class BuildSimButton {

  @Input()
  icon!: string;

  @Input()
  slotName!: string;
}
