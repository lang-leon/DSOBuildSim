import { Component, signal } from '@angular/core';
import { CharacterComponent } from './components/character/character-component';

@Component({
  selector: 'app-root',
  imports: [CharacterComponent],
  templateUrl: './app.html',
  styleUrl: './app.scss'
})
export class App {
  
}
