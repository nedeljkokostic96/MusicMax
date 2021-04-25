package com.musicmax.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
