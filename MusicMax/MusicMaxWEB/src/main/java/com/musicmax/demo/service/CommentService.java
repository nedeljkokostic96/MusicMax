package com.musicmax.demo.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.musicmax.demo.repository.CommentRepository;
import com.musicmax.demo.repository.ForumTopicRepository;
import com.musicmax.demo.util.DateConverter;

import model.Client;
import model.Comment;
import model.ForumTopic;

@Service
public class CommentService {
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private ForumTopicRepository forumTopicRepository;

	@Autowired
	private ClientParserService clientParserService;
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> saveComment(String json, HttpServletRequest request) {
		
		Map<String, Object> values;
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("status", false);
		
		try {
			values = new ObjectMapper().readValue(json, Map.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return response;
		}
		
		String dateSTR = (String) values.get("date");

		Date date = DateConverter.parseDate(dateSTR);
		
		
		ForumTopic forumTopic = forumTopicRepository.findById((Integer) values.get("idForumTopic")).get();
		Client client = clientParserService.parseClientFromJWT(request);
		
		Comment newComment = new Comment();
		newComment.setComment((String) values.get("textComment"));
		newComment.setForumTopic(forumTopic);
		newComment.setLikes((Integer) values.get("likes"));
		newComment.setLikes((Integer) values.get("unlikes"));
		newComment.setDate(date);
		newComment.setClient(client);

		Comment saved = commentRepository.save(newComment);

		response.put("status", saved != null);
		return response;
	}

}