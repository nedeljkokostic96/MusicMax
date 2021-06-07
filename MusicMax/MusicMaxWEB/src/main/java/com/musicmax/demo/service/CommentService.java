package com.musicmax.demo.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.musicmax.demo.message.request.CommentForm;
import com.musicmax.demo.repository.ClientRepository;
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
	
	public ResponseEntity<?> saveComment(CommentForm commentFormData, HttpServletRequest request) {

		Date date = DateConverter.parseDate(commentFormData.getDate());
		
		ForumTopic forumTopic = forumTopicRepository.findById(commentFormData.getIdForumTopic()).get();
		Client client = clientParserService.parseClientFromJWT(request);
		
		Comment newComment = new Comment();
		newComment.setComment(commentFormData.getTextComment());
		newComment.setForumTopic(forumTopic);
		newComment.setLikes(0);//starting number of likes for comment
		newComment.setLikes(0);//stasting nubmer of unlikes for comment
		newComment.setDate(date);
		newComment.setClient(client);

		Comment saved = commentRepository.save(newComment);

		return saved != null ? ResponseEntity.ok("Added new coment!") : ResponseEntity.badRequest().body("Error due adding new comment!");
	}

}