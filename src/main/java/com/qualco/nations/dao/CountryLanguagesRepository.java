package com.qualco.nations.dao;

import com.qualco.nations.entity.CountryLanguage;
import com.qualco.nations.entity.keys.CountryLanguageId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryLanguagesRepository extends JpaRepository<CountryLanguage, CountryLanguageId> {
    List<CountryLanguage> findByCountryId(Integer countryId);
}
