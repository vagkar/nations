package com.qualco.nations.entity;

import com.qualco.nations.entity.keys.CountryStatId;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "country_stats")
public class CountryStat {

    @EmbeddedId
    private CountryStatId id;

    @ManyToOne
    @MapsId("countryId")
    @JoinColumn(name = "country_id")
    private Country country;

    private Integer population;

    private BigDecimal gdp;

    public CountryStatId getId() {
        return id;
    }

    public void setId(CountryStatId id) {
        this.id = id;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
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
