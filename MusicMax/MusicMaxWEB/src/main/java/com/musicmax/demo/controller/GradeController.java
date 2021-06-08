package com.musicmax.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.musicmax.demo.service.GradeService;

@RestController
@RequestMapping(value = "/grade")
public class GradeController {
	
	@Autowired
	private GradeService gradeService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> saveNewGrade(@RequestBody String json, HttpServletRequest request) {
		return gradeService.saveGrade(json, request);
	}

}
