package me.exp.graphqljava.service;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import me.exp.graphqljava.model.City;
import me.exp.graphqljava.model.Country;
import me.exp.graphqljava.model.State;
import me.exp.graphqljava.repository.CityRepository;
import me.exp.graphqljava.repository.CountryRepository;
import me.exp.graphqljava.repository.StateRepository;
import me.exp.graphqljava.service.datafetcher.AllCitiesDataFetcher;
import me.exp.graphqljava.service.datafetcher.AllCountriesDataFetcher;
import me.exp.graphqljava.service.datafetcher.AllStatesDataFetcher;
import me.exp.graphqljava.service.datafetcher.CityDataFetcher;
import me.exp.graphqljava.service.datafetcher.CountryDataFetcher;
import me.exp.graphqljava.service.datafetcher.StateDataFetcher;

@Service
public class GraphQLService {

	@Autowired
    CityRepository cityRepository;
	
	@Autowired
    StateRepository stateRepository;
	
	@Autowired
	CountryRepository countryRepository;

    @Value("classpath:schema.graphql")
    Resource resource;

    private GraphQL graphQL;
  
    
    @Autowired  
    private CityDataFetcher cityDataFetcher;
    @Autowired
    private AllCitiesDataFetcher allCitiesDataFetcher;
    @Autowired
    private StateDataFetcher stateDataFetcher;
    @Autowired
    private AllStatesDataFetcher allStatesDataFetcher;
    @Autowired
    private CountryDataFetcher countryDataFetcher;
    @Autowired
    private AllCountriesDataFetcher allCountriesDataFetcher;

    
    @PostConstruct
    private void loadSchema() throws IOException {

        loadData();

        File schemaFile = resource.getFile();
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemaFile);
        RuntimeWiring wiring = buildRuntimeWiring();
        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
        graphQL = GraphQL.newGraphQL(schema).build();
    }

    private void loadData() {

    	Country usa = new Country ("USA", "330000000");
    	countryRepository.save(usa); 

    	State ca = new State("CA", "39900000", usa);
    	State fl = new State("FL", "21300000", usa);
    	State mi = new State("MI", "11000000", usa); 
    	    	
    	stateRepository.save(mi); 
    	stateRepository.save(ca);  
    	stateRepository.save(fl);
    
    	
    	Stream.of(
    			new City("BayArea",   "7200000", ca ), 
    			new City("LA",        "3900000", ca ),
    			new City("Miami",      "466000", fl ), 
    			new City("Detriot",    "630000", mi ), 
    			new City("RapidsCity", "188000", mi )    			  
    			 ).forEach(city -> 
    	            cityRepository.save(city));
    	
	}
    
    private void loadDataq1() {
    	Country india = new Country ("India", "1330000000");
    	State ka = new State("KA", "64000000",  india);
    	State dl = new State("DL", "19000000",  india);
    	State mh = new State("MH", "114200000", india);
    	
    	countryRepository.save(india);
    	stateRepository.save(ka);
    	stateRepository.save(dl);
    	stateRepository.save(mh);
    	
    	Stream.of(
    			new City("Bangalore", "8400000", ka ), 
    			new City("Delhi", "19000000", dl ), 
    			new City("Mumbai", "18400000", mh ), 
    			new City("Pune", "3100000", mh ) , 
    			new City("Hubli", "840000", ka ) ).forEach(city -> 
    	            cityRepository.save(city));
    	
	}

    private RuntimeWiring buildRuntimeWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type("Queryyy", typeWiring -> typeWiring
                        //.dataFetcher("allCities", allCitiesDataFetcher)
                       // .dataFetcher("city", cityDataFetcher)
                       // .dataFetcher("state", stateDataFetcher)
                          .dataFetcher("allStates", allStatesDataFetcher)
                       //   .dataFetcher("country", countryDataFetcher)
                          .dataFetcher("allCountries", allCountriesDataFetcher)
                		)
                .build();
    }

    public GraphQL getGraphQL() {
        return graphQL;
    }
}
