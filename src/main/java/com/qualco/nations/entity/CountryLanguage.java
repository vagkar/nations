package com.qualco.nations.entity;

import com.qualco.nations.entity.keys.CountryLanguageId;

import javax.persistence.*;

@Entity
@Table(name = "country_languages")
@IdClass(CountryLanguageId.class)
public class CountryLanguage {

    @Id
    @Column(name = "country_id")
    private Integer countryId;

    @Id
    @Column(name = "language_id")
    private Integer languageId;

    @ManyToOne
    @JoinColumn(name = "country_id", insertable = false, updatable = false)
    private Country country;

    @ManyToOne
    @JoinColumn(name = "language_id", insertable = false, updatable = false)
    private Language language;

    @Column(nullable = false)
    private boolean official;

    public Integer getCountryId() {
        return countryId;
    }

    public Integer getLanguageId() {
        return languageId;
    }

    public Country getCountry() {
        return country;
    }

    public Language getLanguage() {
        return language;
    }

    public boolean isOfficial() {
        return official;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public void setLanguageId(Integer languageId) {
        this.languageId = languageId;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public void setOfficial(boolean official) {
        this.official = official;
    }
}
