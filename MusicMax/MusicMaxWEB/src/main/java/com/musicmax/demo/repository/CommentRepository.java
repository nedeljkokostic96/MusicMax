package com.musicmax.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

}