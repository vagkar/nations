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
}
