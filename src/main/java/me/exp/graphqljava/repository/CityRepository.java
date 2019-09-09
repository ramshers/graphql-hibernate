package me.exp.graphqljava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import me.exp.graphqljava.model.City;

public interface CityRepository extends JpaRepository<City, String> {


	}

