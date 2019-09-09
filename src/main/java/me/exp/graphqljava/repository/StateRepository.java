package me.exp.graphqljava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import me.exp.graphqljava.model.State;

public interface StateRepository extends JpaRepository<State, String>{

}
