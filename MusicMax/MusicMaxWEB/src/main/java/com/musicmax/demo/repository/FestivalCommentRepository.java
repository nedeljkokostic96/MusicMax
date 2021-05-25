package com.musicmax.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.FestivalComment;

public interface FestivalCommentRepository extends JpaRepository<FestivalComment, Integer> {

}
