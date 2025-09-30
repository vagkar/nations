package com.qualco.nations.dto;

import java.math.BigDecimal;

public class MaxGdpPerPopulationDTO {

    private String CountryName;
    private String Code3;
    private int year;
    private Integer population;
    private BigDecimal gdp;
    private BigDecimal ratio;

    public MaxGdpPerPopulationDTO(String countryName, String code3, int year, Integer population, BigDecimal gdp, BigDecimal ratio) {
        CountryName = countryName;
        Code3 = code3;
        this.year = year;
        this.population = population;
        this.gdp = gdp;
        this.ratio = ratio;
    }

    public String getCountryName() {
        return CountryName;
    }

    public void setCountryName(String countryName) {
        CountryName = countryName;
    }

    public String getCode3() {
        return Code3;
    }

    public void setCode3(String code3) {
        Code3 = code3;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public BigDecimal getGdp() {
        return gdp;
    }

    public void setGdp(BigDecimal gdp) {
        this.gdp = gdp;
    }

    public BigDecimal getRatio() {
        return ratio;
    }

    public void setRatio(BigDecimal ratio) {
        this.ratio = ratio;
    }
}
