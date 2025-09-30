package com.qualco.nations.entity.keys;

import java.io.Serializable;
import java.util.Objects;

public class CountryLanguageId implements Serializable {

    private Integer countryId;
    private Integer languageId;

    public CountryLanguageId() {
    }

    public CountryLanguageId(Integer countryId, Integer languageId) {
        this.countryId = countryId;
        this.languageId = languageId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CountryLanguageId)) return false;
        CountryLanguageId that = (CountryLanguageId) o;
        return Objects.equals(countryId, that.countryId) && Objects.equals(languageId, that.languageId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryId, languageId);
    }
}
