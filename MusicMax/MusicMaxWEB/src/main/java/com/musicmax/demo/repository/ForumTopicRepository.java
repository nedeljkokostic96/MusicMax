package com.musicmax.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.ForumTopic;

public interface ForumTopicRepository extends JpaRepository<ForumTopic, Integer> {

}
