package com.musicmax.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Grade;

public interface GradeRepository extends JpaRepository<Grade, Integer> {

}
