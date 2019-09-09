package me.exp.graphqljava.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Table(name="city")
@Entity
public class City {

		@Id
		@Column(name="name")
		String name;

		@Column(name="population")
		String population;
	   
		@ManyToOne 
		//@Column(name="state") //org.hibernate.AnnotationException: @Column(s) not allowed on a @ManyToOne property
		State state;
		
		
		public City() { }

		public City(String name, String population, State state) {
			super();
			this.name = name;
			this.population = population;
			this.state = state;
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

		public State getState() {
			return state;
		}

		public void setState(State state) {
			this.state = state;
		}

		@Override
		public String toString() {
			return "City [name=" + name + ", population=" + population + ", state=" + state.getName() + "]";
		}
		
}
