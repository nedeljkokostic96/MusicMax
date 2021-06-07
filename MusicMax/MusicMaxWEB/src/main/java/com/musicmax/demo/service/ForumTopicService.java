package com.musicmax.demo.service;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.musicmax.demo.message.request.ForumTopicForm;
import com.musicmax.demo.repository.ForumTopicRepository;

import model.Client;
import model.ForumTopic;

@Service
public class ForumTopicService {

	@Autowired
	private ForumTopicRepository forumTopicRepository;

	@Autowired
	private ClientParserService clientParserService;

	public ResponseEntity<?> saveForumTopic(ForumTopicForm data, HttpServletRequest request) {
		Client client = clientParserService.parseClientFromJWT(request);
		ForumTopic topic = new ForumTopic();
		topic.setClient(client);
		topic.setDate(new Date());
		topic.setTopic(data.getTopic());

		ForumTopic saved = forumTopicRepository.save(topic);
		return saved != null ? ResponseEntity.ok("Added new forum topic!")
				: ResponseEntity.badRequest().body("Adding new forum topic failed!");
	}

}
