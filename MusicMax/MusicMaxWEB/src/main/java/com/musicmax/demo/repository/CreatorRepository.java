package com.musicmax.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Creator;

public interface CreatorRepository extends JpaRepository<Creator, Integer> {

}
