package me.exp.graphqljava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import me.exp.graphqljava.model.State;
import me.exp.graphqljava.repository.StateRepository;

@SpringBootApplication
public class SpringBootGraphqlStarterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootGraphqlStarterApplication.class, args);
	}
	
	
}
