package com.musicmax.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.musicmax.demo.repository.GenreRepository;

import model.Genre;

@RestController
public class GenreController {

	@Autowired
	private GenreRepository genreRepository;
	
	@GetMapping(value = "/genres")
	public List<Genre> getAllGenres() {
		return genreRepository.findAll();
	}
	
}
