package com.qualco.nations.service;

import com.qualco.nations.dao.CountryLanguagesRepository;
import com.qualco.nations.dao.CountryStatsRepository;
import com.qualco.nations.dao.RegionsRepository;
import com.qualco.nations.dto.*;
import com.qualco.nations.dao.CountriesRepository;
import com.qualco.nations.entity.CountryStat;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryServiceImpl implements CountryService {

    private CountriesRepository countriesRepository;

    private CountryLanguagesRepository countryLanguagesRepository;

    private CountryStatsRepository countryStatsRepository;

    private RegionsRepository regionsRepository;

    public CountryServiceImpl(CountriesRepository cr, CountryLanguagesRepository cl, CountryStatsRepository csr, RegionsRepository rr) {
        countriesRepository = cr;
        countryLanguagesRepository = cl;
        countryStatsRepository = csr;
        regionsRepository = rr;
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

    @Override
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

    @Override
    public List<RegionDTO> findAllRegions() {
        return regionsRepository.findAll().stream()
                .map(r -> new RegionDTO(
                        r.getRegionId(),
                        r.getName(),
                        r.getContinent() != null ? r.getContinent().getName() : null
                ))
                .collect(Collectors.toList());
    }

    @Override
    public List<NationDTO> findFilteredNations(Integer regionId, Integer fromYear, Integer toYear) {
        Specification<CountryStat> spec = getSpecification(regionId, fromYear, toYear);

        return countryStatsRepository.findAll(spec)
                .stream()
                .map(cs -> new NationDTO(
                        cs.getCountry().getRegion().getContinent().getName(),
                        cs.getCountry().getRegion().getName(),
                        cs.getCountry().getName(),
                        cs.getId().getYear(),
                        cs.getPopulation(),
                        cs.getGdp()
                ))
                .collect(Collectors.toList());
    }

    private Specification<CountryStat> getSpecification(Integer regionId, Integer fromYear, Integer toYear) {
        return ((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (regionId != null) predicates.add(criteriaBuilder.equal(root.get("country").get("region").get("regionId"), regionId));

            if (fromYear != null) predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("id").get("year"), fromYear));

            if (toYear != null) predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("id").get("year"), toYear));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
    }
}
