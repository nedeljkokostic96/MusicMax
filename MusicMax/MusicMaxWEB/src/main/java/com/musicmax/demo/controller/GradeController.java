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

import com.musicmax.demo.message.request.GradeForm;
import com.musicmax.demo.service.GradeService;

@RestController
@RequestMapping(value = "/grades")
public class GradeController {

	@Autowired
	private GradeService gradeService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> saveNewGrade(@Valid @RequestBody GradeForm data, HttpServletRequest request) {
		return gradeService.saveGrade(data, request);
	}

}
