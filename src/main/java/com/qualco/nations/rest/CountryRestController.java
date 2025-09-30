package com.qualco.nations.rest;

import com.qualco.nations.dto.*;

import com.qualco.nations.service.CountryService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/regions")
    public List<RegionDTO> findAllRegions() {
        return countryService.findAllRegions();
    }

    @GetMapping("/filteredNations")
    public List<NationDTO> findFilteredNations(
            @RequestParam(required = false) Integer regionId,
            @RequestParam(required = false) Integer fromYear,
            @RequestParam(required = false) Integer toYear
    ) {
        return countryService.findFilteredNations(regionId, fromYear, toYear);
    }

}
