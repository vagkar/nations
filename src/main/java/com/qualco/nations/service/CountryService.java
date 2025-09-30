package com.qualco.nations.service;

import com.qualco.nations.dto.*;

import java.util.List;

public interface CountryService {

    List<CountryDTO> findCountriesOrdered();

    List<LanguageDTO> findCountryLanguages(Integer countryId);

    List<MaxGdpPerPopulationDTO> findMaxRatios();

    List<RegionDTO> findAllRegions();

    List<NationDTO> findFilteredNations(Integer regionId, Integer fromYear, Integer toYear);
}
