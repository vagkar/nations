package com.qualco.nations.dao;

import com.qualco.nations.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CountriesRepository extends JpaRepository<Country, Integer> {

    @Query("select c from Country c order by c.name")
    List<Country> findCountriesOrdered();
}
