package com.musicmax.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.musicmax.demo.repository.AuthorRepository;

import model.Author;

@RestController
public class AuthorController {
	
	@Autowired
	private AuthorRepository authorRepository;
	
	@GetMapping(value = "/authors")
	public List<Author> getAllAuthors() {
		return authorRepository.findAll();
	}
	
}
