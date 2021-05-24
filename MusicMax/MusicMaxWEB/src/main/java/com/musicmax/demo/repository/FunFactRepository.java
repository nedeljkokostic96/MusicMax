package com.musicmax.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.FunFact;

public interface FunFactRepository extends JpaRepository<FunFact, Integer> {

}
