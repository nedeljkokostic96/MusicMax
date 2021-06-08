package com.musicmax.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.musicmax.demo.message.request.FunFactForm;
import com.musicmax.demo.service.FunFactService;

@RestController
@RequestMapping(value = "/fun-facts")
public class FunFactController {

	@Autowired
	private FunFactService funFactService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAllFunFacts() {
		return funFactService.getAllFunFacts();
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> saveFunFact(@Valid @RequestBody FunFactForm data, HttpServletRequest request) {
		return funFactService.saveFunFact(data, request);
	}

}
