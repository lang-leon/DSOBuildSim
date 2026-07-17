import { Component, ElementRef, ViewChild } from '@angular/core';
import { CharacterService } from '../../services/character-service';
import { JsonPipe } from '@angular/common';

@Component({
  selector: 'app-character',
  standalone: true,
  imports: [JsonPipe],
  templateUrl: './character-component.html',
  styleUrl: './character-component.scss',
})
export class CharacterComponent {

  @ViewChild('fileInput')
  fileInput!: ElementRef<HTMLInputElement>;

  stats: any;

  constructor(private characterService: CharacterService) {}

  openFilePicker()
  {
    this.fileInput.nativeElement.click();
  }

  onFileSelected(event: Event)
  {
    const input = event.target as HTMLInputElement;

    if(!input.files || input.files.length ===0)
    {
      return;
    }

    const file = input.files[0];

    const reader = new FileReader();

    reader.onload = () => {
      const character = JSON.parse(reader.result as string);
      this.calculate(character);
    };

    reader.readAsText(file);
  }

  calculate(character: object)
  {
    this.characterService.calculateStats(character).subscribe((response: any) => {
      this.stats = response;
      console.log(response);
    });
  }
}
