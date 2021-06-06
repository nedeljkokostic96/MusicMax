package com.musicmax.demo.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.musicmax.demo.service.CommentService;

@RestController
@RequestMapping(value = "/comments")
public class CommentControrller {
	
	@Autowired
	private CommentService commentService;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> saveNewComment(@RequestBody String json, HttpServletRequest request) {
		return commentService.saveComment(json, request);
	}

}
