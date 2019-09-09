package me.exp.graphqljava.service.datafetcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import me.exp.graphqljava.model.State;
import me.exp.graphqljava.repository.StateRepository;

@Component
public class StateDataFetcher implements DataFetcher<State> {

	@Autowired
	StateRepository stateRepository;
	
	@Override
	public State get(DataFetchingEnvironment environment) {

		System.err.println("state df invoked...... ");
		String stateName = environment.getArgument("name");
		return stateRepository.getOne(stateName);
	}
}
