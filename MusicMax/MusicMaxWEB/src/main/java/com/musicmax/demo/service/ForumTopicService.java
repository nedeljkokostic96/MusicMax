package com.musicmax.demo.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.musicmax.demo.repository.ForumTopicRepository;
import com.musicmax.demo.util.DateConverter;

import model.Client;
import model.ForumTopic;

@Service
public class ForumTopicService {

	@Autowired
	private ForumTopicRepository forumTopicRepository;

	@Autowired
	private ClientParserService clientParserService;

	public ResponseEntity<String> saveForumTopic(String json, HttpServletRequest request) {

		Map<String, Object> values = null;
		try {
			values = new ObjectMapper().readValue(json, Map.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		Client client = clientParserService.parseClientFromJWT(request);

		ForumTopic topic = new ForumTopic();
		topic.setClient(client);
		topic.setDate(DateConverter.parseDate(values.get("date").toString()));
		topic.setTopic(values.get("topic").toString());

		ForumTopic saved = forumTopicRepository.save(topic);
		return new ResponseEntity<String>(saved != null ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
	}

}
