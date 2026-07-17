import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { GameDataDTO } from '../models/game-data-dto';

@Injectable({
  providedIn: 'root',
})
export class GameDataService {
  private apiUrl = "http://localhost:8080/api";

  constructor(private http: HttpClient) {}

  getGameData()
    {
      return this.http.get<GameDataDTO>(`${this.apiUrl}/game-data`);
    }
}
