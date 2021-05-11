package com.musicmax.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Performer;

public interface PerformerRepository extends JpaRepository<Performer, Integer> {

}
