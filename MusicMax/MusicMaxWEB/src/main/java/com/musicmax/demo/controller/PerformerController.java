package com.musicmax.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.musicmax.demo.service.PerformerService;

@RestController
@RequestMapping(value = "/performers")
public class PerformerController {
	
	@Autowired
	private PerformerService performerService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAllPerformers() {
		return performerService.getAllPerformers();
	}

}
