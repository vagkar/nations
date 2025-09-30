import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import { Country, Language, MaxGdpPerPopulationDTO } from '../models/country.model';

@Injectable({
  providedIn: 'root',
})
export class CountryService {
  private apiUrl = environment.apiUrl;

  constructor(private http: HttpClient) {}

  getAllCountries(): Observable<Country[]> {
    return this.http.get<Country[]>(`${this.apiUrl}/countries`);
  }

  getCountryLanguages(countryId: string): Observable<Language[]> {
    return this.http.get<Language[]>(
      `${this.apiUrl}/countries/${countryId}/languages`
    );
  }

  getMaxRatios(): Observable<MaxGdpPerPopulationDTO[]> {
    return this.http.get<MaxGdpPerPopulationDTO[]>(
      `${this.apiUrl}/countries/maxRatios`
    );
  }
}
