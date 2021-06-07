package com.musicmax.demo.controller;

import java.util.List;

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

import com.musicmax.demo.message.request.FestivalForm;
import com.musicmax.demo.service.FestivalService;

import model.Festival;

@RestController
@RequestMapping(value = "/festivals")
public class FestivalController {

	@Autowired
	private FestivalService festivalService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> saveNewFestival(@Valid @RequestBody FestivalForm data, HttpServletRequest request) {
		return festivalService.saveFestival(data, request);
	}

	@GetMapping()
	public List<Festival> getAllFestivals() {
		return festivalService.getAllFestivals();
	}

}
