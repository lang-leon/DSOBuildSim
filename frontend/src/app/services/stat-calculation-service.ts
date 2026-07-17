import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { StatsDTO } from '../models/stats-dto';

@Injectable({
  providedIn: 'root',
})
export class StatCalculationService {
  private apiUrl = "http://localhost:8080/api";

  constructor(private http: HttpClient) {}

  calculateStats(character: object)
  {
    return this.http.post<StatsDTO>(`${this.apiUrl}/stats/calculate`, character);
  }
}
