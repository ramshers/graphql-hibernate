package me.exp.graphqljava.service.datafetcher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import me.exp.graphqljava.model.Country;
import me.exp.graphqljava.repository.CountryRepository;

@Component
public class AllCountriesDataFetcher implements DataFetcher<List<Country>> {

	@Autowired
	CountryRepository countryRepository;
	
	@Override
	public List<Country> get(DataFetchingEnvironment environment) {
		return countryRepository.findAll() ;
	}

}
