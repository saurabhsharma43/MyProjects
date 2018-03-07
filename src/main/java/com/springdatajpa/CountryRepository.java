package com.springdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, Integer> {
    @Query("SELECT t.countryName FROM country t where t.id = :id") 
	Country findCountryByCountryName(String name);
    @Query("select country from Country country where country.population >= ?1 and country.population  <= ?2")
    List<Country> findCountriesPopulationRange(long from, long to); 
}
