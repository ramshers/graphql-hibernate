package me.exp.graphqljava.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Table(name="state")
@Entity
public class State { 

	@Id
	@Column(name="name")
	String name;
	@Column(name="population") 
	String population;	
//
//	@OneToMany(cascade=CascadeType.ALL)
//	@JoinTable(name="STATE_CITY_JT", joinColumns={@JoinColumn(name="STATE_NAME", referencedColumnName="name")}
//	    , inverseJoinColumns={@JoinColumn(name="CITY_NAME", referencedColumnName="name")})
	
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="state_nm")
	List<City> cities;

	//@Column(name="country")
	@ManyToOne //(cascade=CascadeType.ALL, fetch=FetchType.EAGER) // don't use cascade all with ManyToOne, atleast for now
	Country country; 


	public State() { }

	public State(String name, String population,  Country country) {
		super();
		this.name = name;
		this.population = population;
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPopulation() {
		return population;
	}

	public void setPopulation(String population) {
		this.population = population;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	@Override
	public String toString() {
		return "State [name=" + name + ", population=" + population + ", cities=" + cities + ", country=" + country + "]";
	}

	

}
