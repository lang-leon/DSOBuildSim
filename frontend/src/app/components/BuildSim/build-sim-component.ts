import { ChangeDetectorRef, Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { StatCalculationService } from '../../services/stat-calculation-service';
import { StatsDTO } from '../../models/stats-dto';
import { GameDataDTO } from '../../models/game-data-dto';
import { GameDataService } from '../../services/game-data-service';

@Component({
  selector: 'app-character',
  standalone: true,
  imports: [
  ],
  templateUrl: './build-sim-component.html',
  styleUrl: './build-sim-component.scss',
})

export class BuildSimComponent implements OnInit{

  @ViewChild('fileInput')
  fileInput!: ElementRef<HTMLInputElement>;

  gameData?: GameDataDTO;

  constructor(
    private statCalculationService: StatCalculationService,
    private gameDataService: GameDataService,
    private changeDetector: ChangeDetectorRef
  ) {}

  ngOnInit(): void {
    this.gameDataService.getGameData()
    .subscribe(data => {
      this.gameData = data;
      console.log(this.gameData);
    });
  }

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
    this.statCalculationService.calculateStats(character).subscribe((response: any) => {
      console.log(response);
    });
  }
}
