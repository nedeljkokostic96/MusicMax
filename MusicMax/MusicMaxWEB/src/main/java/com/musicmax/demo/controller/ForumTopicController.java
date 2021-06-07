package com.musicmax.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.musicmax.demo.message.request.ForumTopicForm;
import com.musicmax.demo.service.ForumTopicService;

@RestController
@RequestMapping(value = "/forum-topic")
public class ForumTopicController {

	@Autowired
	private ForumTopicService forumTopicService;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> saveForumTopic(@Valid @RequestBody ForumTopicForm data, HttpServletRequest request) {
		return forumTopicService.saveForumTopic(data, request);
	}

}
