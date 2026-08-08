import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-confirmation-window',
  imports: [],
  templateUrl: './confirmation-window.html',
  styleUrl: './confirmation-window.scss',
})
export class ConfirmationWindow {

  @Input() scale = 1;

  @Input() title = '';
  @Input() message = '';
  @Input() warning = '';

  @Output() confirmed = new EventEmitter<void>();
  @Output() cancelled = new EventEmitter<void>();

  confirm() {
    this.confirmed.emit();
  }

  cancel() {
    this.cancelled.emit();
  }
}