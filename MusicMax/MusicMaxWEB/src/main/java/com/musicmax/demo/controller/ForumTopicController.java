package com.musicmax.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.musicmax.demo.service.ForumTopicService;

@RestController
public class ForumTopicController {

	@Autowired
	private ForumTopicService forumTopicService;
	
	@PostMapping(value = "/topics", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> saveForumTopic(String json, HttpServletRequest request) {
		return forumTopicService.saveForumTopic(json, request);
	}

}
