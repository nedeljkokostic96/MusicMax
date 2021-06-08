package com.musicmax.demo.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.musicmax.demo.message.request.CommentForm;
import com.musicmax.demo.service.CommentService;

@RestController
@RequestMapping(value = "/comments")
public class CommentControrller {

	@Autowired
	private CommentService commentService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> saveNewComment(@Valid @RequestBody CommentForm commentFormData, HttpServletRequest request) {
		return commentService.saveComment(commentFormData, request);
	}

}
