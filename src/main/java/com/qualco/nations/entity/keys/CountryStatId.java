package com.qualco.nations.entity.keys;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CountryStatId implements Serializable {

    private Long countryId;
    private Integer year;

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
    // equals & hashCode
}
