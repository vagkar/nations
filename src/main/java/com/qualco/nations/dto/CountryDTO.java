package com.qualco.nations.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class CountryDTO implements Serializable {
    Integer id;
    String name;
    BigDecimal area;
    String countryCode2;
    String countryCode3;
    String regionName;
    String continentName;

    public CountryDTO(Integer id, String name, BigDecimal area, String countryCode2, String countryCode3, String regionName, String continentName) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.countryCode2 = countryCode2;
        this.countryCode3 = countryCode3;
        this.regionName = regionName;
        this.continentName = continentName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public String getCountryCode2() {
        return countryCode2;
    }

    public void setCountryCode2(String countryCode2) {
        this.countryCode2 = countryCode2;
    }

    public String getCountryCode3() {
        return countryCode3;
    }

    public void setCountryCode3(String countryCode3) {
        this.countryCode3 = countryCode3;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getContinentName() {
        return continentName;
    }

    public void setContinentName(String continentName) {
        this.continentName = continentName;
    }
}
