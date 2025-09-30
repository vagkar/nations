package com.qualco.nations.dao;

import com.qualco.nations.entity.CountryStat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CountryStatsRepository extends JpaRepository<CountryStat, Integer> {

    @Query("SELECT cs " +
            "FROM CountryStat cs " +
            "WHERE (cs.country.id, cs.gdp/cs.population) IN (" +
            "   SELECT cs2.country.id, MAX(cs2.gdp/cs2.population) " +
            "   FROM CountryStat cs2 " +
            "   GROUP BY cs2.country.id" +
            ")")
    List<CountryStat> findMaxGdpPerCapitalPerCountry();
}
