import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { OnInit } from '@angular/core';
import { CountryService } from '../../services/country.service';
import { Country } from '../../models/country.model';
import { CountryComponent } from '../country/country.component';

@Component({
  selector: 'app-countries',
  standalone: true,
  imports: [CommonModule, CountryComponent],
  templateUrl: './countries.component.html',
  styleUrl: './countries.component.css',
})
export class CountriesComponent implements OnInit {
  countries: Country[] = [];
  isLoading = true;

  constructor(private countryService: CountryService, private router: Router) {}

  ngOnInit(): void {
    this.loadCountries();
  }

  loadCountries(): void {
    this.countryService.getAllCountries().subscribe({
      next: (data) => {
        this.countries = data;
        this.isLoading = false;
      },
      error: (err) => {
        console.error('Error loading countries', err);
        this.isLoading = false;
      },
    });
  }

  viewLanguages(countryId: number): void {
    this.router.navigate(['/countries', countryId.toString(), 'languages']);
  }
}
