package me.exp.graphqljava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import me.exp.graphqljava.model.Country;

public interface CountryRepository extends JpaRepository<Country, String> {

}
