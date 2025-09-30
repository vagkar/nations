package com.qualco.nations.service;

import com.qualco.nations.dao.CountryLanguagesRepository;
import com.qualco.nations.dto.CountryDTO;
import com.qualco.nations.dto.LanguageDTO;
import com.qualco.nations.dao.CountriesRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryServiceImpl implements CountryService {

    private CountriesRepository countriesRepository;

    private CountryLanguagesRepository countryLanguagesRepository;

    public CountryServiceImpl(CountriesRepository cr, CountryLanguagesRepository cl) {
        countriesRepository = cr;
        countryLanguagesRepository = cl;
    }

    @Override
    public List<CountryDTO> findCountriesOrdered() {
        return countriesRepository.findCountriesOrdered()
                .stream()
                .map(c -> new CountryDTO(
                        c.getCountryId(),
                        c.getName(),
                        c.getArea(),
                        c.getCountryCode2(),
                        c.getCountryCode3(),
                        c.getRegion().getName(),
                        c.getRegion().getContinent().getName()))
                .collect(Collectors.toList());
    }

    @Override
    public List<LanguageDTO> findCountryLanguages(Integer countryId) {
        return countryLanguagesRepository.findByCountryId(countryId)
                .stream()
                .map(c -> new LanguageDTO(
                                c.getLanguage().getId(),
                                c.getLanguage().getName(),
                                c.isOfficial()
                        ))
                .collect(Collectors.toList());
    }
}
