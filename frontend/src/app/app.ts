import { Component } from '@angular/core';
import { BuildSimComponent } from './components/BuildSim/build-sim-component';

@Component({
  selector: 'app-root',
  imports: [BuildSimComponent],
  templateUrl: './app.html',
  styleUrl: './app.scss'
})
export class App {
  
}
