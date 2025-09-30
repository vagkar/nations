package com.qualco.nations.rest;

import com.qualco.nations.dto.CountryDTO;

import com.qualco.nations.dto.LanguageDTO;
import com.qualco.nations.dto.MaxGdpPerPopulationDTO;
import com.qualco.nations.service.CountryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryRestController {

    private CountryService countryService;

    public CountryRestController(CountryService cs) {
        countryService = cs;
    }

    @GetMapping
    public List<CountryDTO> findCountriesOrdered() {
        return countryService.findCountriesOrdered();
    }

    @GetMapping("/{id}/languages")
    public List<LanguageDTO> findCountryLanguages(@PathVariable Integer id) {
        return countryService.findCountryLanguages(id);
    }

    @GetMapping("/maxRatios")
    public List<MaxGdpPerPopulationDTO> findMaxRatios() {
        return countryService.findMaxRatios();
    }

}
