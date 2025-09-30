package com.qualco.nations.service;

import com.qualco.nations.dto.CountryDTO;

import com.qualco.nations.dto.LanguageDTO;
import com.qualco.nations.dto.MaxGdpPerPopulationDTO;

import java.util.List;

public interface CountryService {

    List<CountryDTO> findCountriesOrdered();

    List<LanguageDTO> findCountryLanguages(Integer countryId);

    List<MaxGdpPerPopulationDTO> findMaxRatios();
}
