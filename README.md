# Learning GraphQL with Spring Boot
## Project's API is available at below URI:  
- `/rest/api` 

## Sample GraphQL Scalar Queries
- Accessible under `http://localhost:8080/rest/api`
- Usage for `allCities`
`{
  allCities {
    name
    population
    state {
    	name
    	cities 	{
    		name
    	}
    }
  }
}`
- Usage for `city`
`{
  city(name: "BayArea") {
    name
    population
    state {
    	name
    	population
    	cities 	{
    		name
    	}
    	country {
    		name
    		population
    	}
    }
  }
}`
