package com.qualco.nations.service;

import com.qualco.nations.dao.CountryLanguagesRepository;
import com.qualco.nations.dao.CountryStatsRepository;
import com.qualco.nations.dto.CountryDTO;
import com.qualco.nations.dto.LanguageDTO;
import com.qualco.nations.dao.CountriesRepository;
import com.qualco.nations.dto.MaxGdpPerPopulationDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryServiceImpl implements CountryService {

    private CountriesRepository countriesRepository;

    private CountryLanguagesRepository countryLanguagesRepository;

    private CountryStatsRepository countryStatsRepository;

    public CountryServiceImpl(CountriesRepository cr, CountryLanguagesRepository cl, CountryStatsRepository csr) {
        countriesRepository = cr;
        countryLanguagesRepository = cl;
        countryStatsRepository = csr;
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

    public List<MaxGdpPerPopulationDTO> findMaxRatios() {
        return countryStatsRepository.findMaxGdpPerCapitalPerCountry()
                .stream()
                .map(cs -> new MaxGdpPerPopulationDTO(
                        cs.getCountry().getName(),
                        cs.getCountry().getCountryCode3(),
                        cs.getId().getYear(),
                        cs.getPopulation(),
                        cs.getGdp(),
                        cs.getGdp().divide(
                                new BigDecimal(cs.getPopulation()),
                                RoundingMode.HALF_UP
                        )
                )).collect(Collectors.toList());
    }
}
