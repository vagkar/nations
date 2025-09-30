import { CommonModule } from '@angular/common';
import { Component, Input } from '@angular/core';
import { RouterLink, ActivatedRoute } from '@angular/router';
import { OnInit } from '@angular/core';
import { CountryService } from '../../services/country.service';
import { Country, Language } from '../../models/country.model';

@Component({
  selector: 'app-country-languages',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './country-languages.component.html',
  styleUrl: './country-languages.component.css',
})
export class CountryLanguagesComponent implements OnInit {
  countryName: string = '';
  countryCode: string = '';
  languages: Language[] = [];
  loading = true;

  constructor(private route: ActivatedRoute, private countryService: CountryService) { }
  
  ngOnInit(): void {
    this.countryCode = this.route.snapshot.params['code'];
    this.loadCountryName();
    this.loadLanguages();
  }

  loadCountryName(): void {
    // Assuming you have a method to get country details by code
    this.countryService.getAllCountries().subscribe({
      next: (countries) => {
        const country = countries.find(c => c.id.toString() === this.countryCode);
        this.countryName = country ? country.name : 'Unknown Country';
      },
      error: (err) => {
        console.error('Error loading country name', err);
      },
    });
  }

  loadLanguages(): void {
    this.countryService.getCountryLanguages(this.countryCode).subscribe({
      next: (data) => {
        this.languages = data;
        this.loading = false;
      },
      error: (err) => {
        console.error('Error loading languages', err);
        this.loading = false;
      },
    });
  }
}
