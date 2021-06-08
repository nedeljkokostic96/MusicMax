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

import com.musicmax.demo.message.request.FestivalCommentForm;
import com.musicmax.demo.service.FestivalCommentService;

@RestController
@RequestMapping(value = "/festival-commnets")
public class FestivalCommentController {

	@Autowired
	private FestivalCommentService festivalCommentService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> saveFestivalComment(@Valid @RequestBody FestivalCommentForm data,
			HttpServletRequest request) {
		return festivalCommentService.saveFestivalComment(data, request);
	}

}
