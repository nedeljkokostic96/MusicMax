package com.musicmax.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.musicmax.demo.service.CreatorService;

@RestController
@RequestMapping(value = "/creators")
public class CreatorController {
	
	@Autowired
	private CreatorService creatorService;

	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAllCreators() {
		return creatorService.getAllCreators();
	}
	
}
