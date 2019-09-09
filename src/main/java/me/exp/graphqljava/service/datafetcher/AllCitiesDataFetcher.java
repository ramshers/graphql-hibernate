package me.exp.graphqljava.service.datafetcher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import me.exp.graphqljava.model.City;
import me.exp.graphqljava.repository.CityRepository;

@Component
public class AllCitiesDataFetcher implements DataFetcher<List<City>>{
	
	@Autowired
	CityRepository cityRepository;

	@Override
	public List<City> get(DataFetchingEnvironment environment) {
		System.err.println("all cities df invoked...");
        return cityRepository.findAll();
	}

}
