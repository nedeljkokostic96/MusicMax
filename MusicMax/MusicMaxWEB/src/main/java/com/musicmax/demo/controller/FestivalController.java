package com.musicmax.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.musicmax.demo.service.FestivalService;

@RestController
public class FestivalController {

	@Autowired
	private FestivalService festivalService;
	
	@PostMapping(value = "/festivals", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> saveNewFestival(@RequestBody String json, HttpServletRequest request) {
		return festivalService.saveFestival(json, request);
	}
	
}