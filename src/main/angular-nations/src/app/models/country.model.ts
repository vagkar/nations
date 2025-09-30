export interface Country {
  id: number;
  name: string;
  area: number;
  countryCode2: string;
  countryCode3: string;
}

export interface Language {
  id: number;
  name: string;
  official: boolean;
}

export interface MaxGdpPerPopulationDTO {
  countryName: string;
  code3: string;
  year: number;
  population: number;
  gdp: number;
  ratio: number;
}

export interface Region {
  id: number;
  name: string;
  continentName: string;
}

export interface NationDTO {
  continent: string;
  region: string;
  country: string;
  year: number;
  population: number;
  gdp: number;
}
