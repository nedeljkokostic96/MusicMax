package com.musicmax.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Impression;

public interface ImpressionRepository extends JpaRepository<Impression, Integer> {

}

