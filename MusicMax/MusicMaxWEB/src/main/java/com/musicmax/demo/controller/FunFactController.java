package com.musicmax.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.musicmax.demo.service.FunFactService;

@RestController
public class FunFactController {
	
	@Autowired
	private FunFactService funFactService;
	
	@PostMapping(value = "/funFacts", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> saveFunFact(@RequestBody String json) {
		return funFactService.saveFunFact(json);
	}

}
