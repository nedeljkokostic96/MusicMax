package com.musicmax.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.musicmax.demo.repository.SongRepository;

import model.Song;

@RestController
public class SongController {

	@Autowired
	private SongRepository songRepository;

	@GetMapping(value = "/songs")
	public List<Song> getAllSongs() {
		return songRepository.findAll();
	}
	
}
