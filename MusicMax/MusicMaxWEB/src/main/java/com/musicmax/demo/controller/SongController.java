package com.musicmax.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@GetMapping(value = "songs/author")
	public List<Song> getSongsByAuthor(String authorID) {
		return songService.getSongsByAuthor(authorID);
	}

	@GetMapping(value = "songs/year")
	public List<Song> getSongsByYear(String year) {
		return songService.getSongsByYear(year);
	}

	@GetMapping(value = "songs/performer")
	public List<Song> getSongsByPerformer(String performerID) {
		return songService.getSongsByPerformer(performerID);
	}

	@GetMapping(value = "/byTitle")
	public List<Song> getSongByTitle() {
		return songRepository.findByTitle("Give into me");
	}

	@GetMapping(value = "songs/composer")
	public List<Song> getSongsByComposer(String composerID) {
		return songService.getSongsByComposer(composerID);
	}

	@PostMapping(value = "/songs", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> saveSong(@RequestBody String json) {
		return songService.saveSong(json);
	}

}
