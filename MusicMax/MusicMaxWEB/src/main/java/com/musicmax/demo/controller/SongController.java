package com.musicmax.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.musicmax.demo.message.request.SongForm;
import com.musicmax.demo.repository.SongRepository;
import com.musicmax.demo.service.SongService;

import model.Song;

@RestController
@RequestMapping(value = "/songs")
public class SongController {

	@Autowired
	private SongService songService;

	@Autowired
	private SongRepository songRepository;

	@GetMapping()
	public List<Song> getAllSongs() {
		return songRepository.findAll();
	}

	@GetMapping(value = "/genre/{id}")
	public List<Song> getSongsByGenre(@PathVariable(value = "id") String idGenreSTR) {
		return songService.getSongsByGenre(idGenreSTR);
	}

	@GetMapping(value = "/author/{id}")
	public List<Song> getSongsByAuthor(@PathVariable(value = "id") String authorID) {
		return songService.getSongsByAuthor(authorID);
	}

	@GetMapping(value = "/year")
	public List<Song> getSongsByYear(@RequestParam(value = "year") String year) {
		return songService.getSongsByYear(year);
	}

	@GetMapping(value = "/performer/{id}")
	public List<Song> getSongsByPerformer(String performerID) {
		return songService.getSongsByPerformer(performerID);
	}

	@GetMapping(value = "/title")
	public List<Song> getSongByTitle(@RequestParam(value = "title") String title) {
		return songRepository.findByTitle("Give into me");
	}

	@GetMapping(value = "/composer/{id}")
	public List<Song> getSongsByComposer(String composerID) {
		return songService.getSongsByComposer(composerID);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> saveSong(@Valid @RequestBody SongForm data, HttpServletRequest request) {
		return songService.saveSong(data, request);
	}

	@GetMapping(value = "/best-graded-song", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getBestGradedSongLastMonth() {
		return songService.getBestGradedSongLastMonth();
	}

	@GetMapping(value = "/byComposerName")
	public ResponseEntity<?> getSongsByComposerName(@RequestParam(value = "composer") String composer) {
		return songService.getSongsByComposerName(composer);
	}

	@GetMapping(value = "/byAuthorName")
	public ResponseEntity<?> getSongsByAuthorName(@RequestParam(value = "author") String author) {
		return songService.getSongsByAuthorName(author);
	}

	@GetMapping(value = "/byPerformerName")
	public ResponseEntity<?> getSongsByPerformerName(@RequestParam(value = "performer") String performer) {
		return songService.getSongsByPerformerName(performer);
	}

}
