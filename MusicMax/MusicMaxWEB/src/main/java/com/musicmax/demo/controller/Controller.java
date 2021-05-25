package com.musicmax.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.musicmax.demo.service.ForumTopicService;

@RestController
public class Controller {

	@Autowired
	private ForumTopicService forumTopicService;

	public ResponseEntity<String> saveForumTopic(String json, HttpServletRequest request) {
		return forumTopicService.saveForumTopic(json, request);
	}

}
