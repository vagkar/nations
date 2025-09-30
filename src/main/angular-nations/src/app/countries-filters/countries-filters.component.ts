import { Component, OnInit } from '@angular/core';
import { NationDTO } from '../models/country.model';
import { CountryService } from '../services/country.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-countries-filters',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterLink],
  templateUrl: './countries-filters.component.html',
  styleUrl: './countries-filters.component.css',
})
export class CountriesFiltersComponent implements OnInit {
  nations: NationDTO[] = [];
  displayedNations: NationDTO[] = [];
  regions: any[] = [];
  selectedRegion?: number;
  fromYear?: number;
  toYear?: number;
  loading = true;

  // Pagination
  currentPage = 1;
  itemsPerPage = 20;
  totalPages = 1;

  constructor(private countryService: CountryService) {}

  ngOnInit(): void {
    this.loadRegions();
    this.loadFilteredNations();
  }

  loadRegions(): void {
    this.countryService.getRegions().subscribe({
      next: (data) => {
        this.regions = data;
      },
      error: (err) => {
        console.error('Error loading regions', err);
      },
    });
  }

  loadFilteredNations(): void {
    this.countryService
      .getFilteredNations(
        this.selectedRegion || undefined,
        this.fromYear || undefined,
        this.toYear || undefined
      )
      .subscribe({
        next: (data) => {
          this.nations = data;
          this.updatePagination();
          this.loading = false;
        },
        error: (err) => {
          console.error('Error loading filtered nations', err);
          this.loading = false;
        },
      });
  }

  applyFilters(): void {
    this.currentPage = 1;
    this.loading = true;
    this.loadFilteredNations();
  }

  resetFilters(): void {
    this.selectedRegion = undefined;
    this.fromYear = undefined;
    this.toYear = undefined;
    this.currentPage = 1;
    this.loading = true;
    this.loadFilteredNations();
  }

  updatePagination(): void {
    this.totalPages = Math.ceil(this.nations.length / this.itemsPerPage);
    this.updateDisplayedNations();
  }

  updateDisplayedNations(): void {
    const startIndex = (this.currentPage - 1) * this.itemsPerPage;
    const endIndex = startIndex + this.itemsPerPage;
    this.displayedNations = this.nations.slice(startIndex, endIndex);
  }

  goToPage(page: number): void {
    if (page < 1 || page > this.totalPages) return;
    this.currentPage = page;
    this.updateDisplayedNations();
  }
}
