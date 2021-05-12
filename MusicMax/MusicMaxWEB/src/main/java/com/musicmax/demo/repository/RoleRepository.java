package com.musicmax.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	Optional<Role> findByTitle(String string);

}
