import { CommonModule } from '@angular/common';
import { Component, Input, Output } from '@angular/core';
import { Country } from '../../models/country.model';
import { EventEmitter } from '@angular/core';

@Component({
  selector: 'app-country',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './country.component.html',
  styleUrl: './country.component.css',
})
export class CountryComponent {
  @Input() country!: Country;
  @Output() clicked = new EventEmitter<number>();

  viewCountryDetails() {
    this.clicked.emit(this.country.id);
  }
}
