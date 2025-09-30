import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import {
  Country,
  Language,
  MaxGdpPerPopulationDTO,
  NationDTO,
  Region,
} from '../models/country.model';

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

  getRegions(): Observable<Region[]> {
    return this.http.get<Region[]>(`${this.apiUrl}/countries/regions`);
  }

  getFilteredNations(
    regionId?: number,
    fromYear?: number,
    toYear?: number
  ): Observable<NationDTO[]> {
    let params: any = {};

    if (regionId) params.regionId = regionId;
    if (fromYear) params.fromYear = fromYear;
    if (toYear) params.toYear = toYear;

    return this.http.get<NationDTO[]>(
      `${this.apiUrl}/countries/filteredNations`,
      { params }
    );
  }
}
