package com.qualco.nations.dto;

import java.math.BigDecimal;

public class NationDTO {

    private String continent;
    private String region;
    private String country;
    private int year;
    private Integer population;
    private BigDecimal gdp;

    public NationDTO(String continent, String region, String country, int year, Integer population, BigDecimal gdp) {
        this.continent = continent;
        this.region = region;
        this.country = country;
        this.year = year;
        this.population = population;
        this.gdp = gdp;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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
}
