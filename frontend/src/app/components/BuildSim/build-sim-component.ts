import { ChangeDetectorRef, Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { StatCalculationService } from '../../services/stat-calculation-service';
import { GameDataDTO } from '../../models/game-data-dto';
import { GameDataService } from '../../services/game-data-service';
import { StatType } from '../../models/stat-type';
import { ClassStatsDTO } from '../../models/class-stats-dto';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-character',
  standalone: true,
  imports: [
    CommonModule
  ],
  templateUrl: './build-sim-component.html',
  styleUrl: './build-sim-component.scss',
})

export class BuildSimComponent implements OnInit{

  @ViewChild('fileInput')
  fileInput!: ElementRef<HTMLInputElement>;

  StatType = StatType;
  gameData?: GameDataDTO;
  stats?: ClassStatsDTO;

  constructor(
    private statCalculationService: StatCalculationService,
    private gameDataService: GameDataService,
    private changeDetector: ChangeDetectorRef
  ) {}

  ngOnInit(): void {
    this.gameDataService.getGameData()
    .subscribe(data => {
      this.gameData = data;
      this.stats = this.gameData.characterClassStats["SPELLWEAVER"];
      console.log(this.stats);
      this.changeDetector.detectChanges();
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
      this.stats!.absoluteStats = response.stats;
      this.changeDetector.detectChanges();

      console.log(this.gameData);

      console.log(response);
      console.log("stats:");
      console.log(this.stats?.absoluteStats);
    });
  }
}
