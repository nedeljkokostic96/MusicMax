package com.musicmax.demo.controller;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.musicmax.demo.message.request.ImpressionForm;
import com.musicmax.demo.service.ImpressionService;

@RestController
@RequestMapping(value = "/impressions")
public class ImpressionController {


	@Autowired
	private ImpressionService impressionService;
	
	@GetMapping()
	public ResponseEntity<?> getImpressions() {
		return impressionService.findAllImpressions();
	}

	@PostMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> saveImpression(@Valid @RequestBody ImpressionForm data, HttpServletRequest request) {
		return impressionService.saveNewImpression(data, request);
	}

}
