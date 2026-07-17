import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class CharacterService {
  private apiUrl = "http://localhost:8080/api";

  constructor(private http: HttpClient) {}

  calculateStats(character: object)
  {
    return this.http.post(`${this.apiUrl}/stats/calculate`, character);
  }
}
