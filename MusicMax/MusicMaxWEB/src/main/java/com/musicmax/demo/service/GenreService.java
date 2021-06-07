package com.musicmax.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.musicmax.demo.message.response.GenreWrapper;
import com.musicmax.demo.repository.GenreRepository;
import com.musicmax.demo.repository.SongRepository;

import model.Genre;

@Service
public class GenreService {

	@Autowired
	private SongRepository songRepository;
	
	@Autowired
	private GenreRepository genreRepository;

	public ResponseEntity<?> getGenresWithNumberOfSongs() {
		List<Genre> genres = genreRepository.findAll();
		List<GenreWrapper> result = new ArrayList<GenreWrapper>();
		for (Genre genre : genres) {
			GenreWrapper gw = new GenreWrapper();
			gw.setGenre(genre);
			int numberOfSongs = songRepository.getNumberOfSongsByGenre(genre);
			gw.setNumberOfSongs(numberOfSongs);
			result.add(gw);
		}
		return ResponseEntity.ok(result);
	}

}
