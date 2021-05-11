package com.musicmax.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.musicmax.demo.repository.SongRepository;
import com.musicmax.demo.service.SongService;

import model.Song;

@RestController
public class SongController {

	@Autowired
	private SongService songService;

	@Autowired
	private SongRepository songRepository;

	@GetMapping(value = "/songs")
	public List<Song> getAllSongs() {
		return songRepository.findAll();
	}

	@GetMapping(value = "songs/genre")
	public List<Song> getSongsByGenre(String idGenreSTR) {
		return songService.getSongsByGenre(idGenreSTR);
	}

	@GetMapping(value = "songs/year")
	public List<Song> getSongsByYear(String year) {
		return songService.getSongsByYear(year);
	}

	@GetMapping(value = "/byTitle")
	public List<Song> getSongByTitle() {
		System.out.println("Hi");
		return songRepository.findByTitle("Give into me");
	}

	@GetMapping(value = "songs/composer")
	public List<Song> getSongsByComposer(String composerID) {
		return songService.getSongsByComposer(composerID);
	}

}
