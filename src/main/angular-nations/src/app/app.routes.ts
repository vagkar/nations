import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { CountriesListComponent } from './countries-list/countries-list.component';
import { CountryLanguagesComponent } from './countries-list/country-languages/country-languages.component';

export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'countries', component: CountriesListComponent },
  { path: 'countries/:code/languages', component: CountryLanguagesComponent },
//   { path: 'country-stats', component: 'CountryStatsComponent' },
//   { path: 'country-details', component: 'CountryDetailsComponent' }
];
