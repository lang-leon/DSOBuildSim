import { Component, EventEmitter, Input, Output } from '@angular/core';
import { CharacterClass } from '../../enums/CharacterClass';

@Component({
  selector: 'app-class-change-window',
  imports: [],
  templateUrl: './class-change-window.html',
  styleUrl: './class-change-window.scss',
})
export class ClassChangeWindow {

  @Input() scale = 1;

  @Output() cancelled = new EventEmitter<void>();
  @Output() classSelected = new EventEmitter<CharacterClass>();

  CharacterClass = CharacterClass;

  cancel() {
    this.cancelled.emit();
  }

  selectClass(characterClass: CharacterClass) {
    this.classSelected.emit(characterClass);
  }
}