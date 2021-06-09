package com.musicmax.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.musicmax.demo.repository.GenreRepository;
import com.musicmax.demo.service.GenreService;

import model.Genre;

@RestController
@RequestMapping(value = "/genres")
public class GenreController {

	@Autowired
	private GenreRepository genreRepository;

	@Autowired
	private GenreService genreService;
	
	@GetMapping
	public List<Genre> getAllGenres() {
		return genreRepository.findAll();
	}
	
	@GetMapping(value = "/with-songs-number")
	public ResponseEntity<?> getGenresWithNumberOfSongs() {
		return genreService.getGenresWithNumberOfSongs();
	}

}
