package me.exp.graphqljava.service.datafetcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import me.exp.graphqljava.model.Country;
import me.exp.graphqljava.repository.CountryRepository;

@Component
public class CountryDataFetcher implements DataFetcher<Country> {

	@Autowired 
	CountryRepository countryRepository;
	@Override
	public Country get(DataFetchingEnvironment environment) {

		String countryName = environment.getArgument("name");
		return countryRepository.getOne(countryName);
	}

}
