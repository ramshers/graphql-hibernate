package me.exp.graphqljava.service.datafetcher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import me.exp.graphqljava.model.State;
import me.exp.graphqljava.repository.StateRepository;

@Component
public class AllStatesDataFetcher implements DataFetcher<List<State>> {
	
	@Autowired
	StateRepository stateRepository;

	@Override
	public List<State> get(DataFetchingEnvironment environment) {
		System.err.println("all states df invoked...");
		return stateRepository.findAll();
		
	}
}
