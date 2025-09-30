import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CountriesFiltersComponent } from './countries-filters.component';

describe('CountriesFiltersComponent', () => {
  let component: CountriesFiltersComponent;
  let fixture: ComponentFixture<CountriesFiltersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CountriesFiltersComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CountriesFiltersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
