package com.musicmax.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Client;

public interface ClientRepository extends JpaRepository<Client,Integer> {

	Optional<Client> findByEmail(String email);

	boolean existsByEmail(String email);
	
}