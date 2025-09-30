import { Component, OnInit } from '@angular/core';
import { MaxGdpPerPopulationDTO } from '../models/country.model';
import { CountryService } from '../services/country.service';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-country-stats',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './country-stats.component.html',
  styleUrl: './country-stats.component.css',
})
export class CountryStatsComponent implements OnInit {

  countryStats: MaxGdpPerPopulationDTO[] = [];
  loading = true;

  constructor(private countryService: CountryService) {}

  ngOnInit(): void {
    this.loadStats();
  }

  loadStats(): void {
    this.countryService.getMaxRatios().subscribe({
      next: (data) => {
        this.countryStats = data;
        this.loading = false;
      },
      error: (err) => {
        console.error('Error loading country stats', err);
        this.loading = false;
      },
    });
  }
}
