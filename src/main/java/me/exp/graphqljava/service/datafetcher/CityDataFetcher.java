package me.exp.graphqljava.service.datafetcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import me.exp.graphqljava.model.City;
import me.exp.graphqljava.repository.CityRepository;

@Component
public class CityDataFetcher implements DataFetcher<City>{

	@Autowired
	CityRepository cityRepository;

	@Override
	public City get(DataFetchingEnvironment environment) {

		String cityName = environment.getArgument("name");

		return cityRepository.getOne(cityName);
	}
}

