package com.musicmax.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.musicmax.demo.service.FestivalCommentService;

@RestController
public class FestivalCommentController {
	
	@Autowired
	private FestivalCommentService festivalCommentService;
	
	@PostMapping(value = "/festivalComments", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> saveFestivalComment(@RequestBody String json) {
		return festivalCommentService.saveFestivalComment(json);
	}

}
