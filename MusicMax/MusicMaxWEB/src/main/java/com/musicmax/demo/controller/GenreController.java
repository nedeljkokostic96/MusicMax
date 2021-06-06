package com.musicmax.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.musicmax.demo.repository.GenreRepository;

import model.Genre;

@RestController
@RequestMapping(value = "/genres")
public class GenreController {

	@Autowired
	private GenreRepository genreRepository;

	@GetMapping()
	public List<Genre> getAllGenres() {
		return genreRepository.findAll();
	}

}
