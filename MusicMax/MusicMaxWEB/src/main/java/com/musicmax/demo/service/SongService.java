package com.musicmax.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.musicmax.demo.repository.SongRepository;

import model.Song;

@Service
public class SongService {

	
	@Autowired
	private SongRepository songRepository;
	
	public List<Song> getSongsByGenre(@RequestParam(value = "idGenreSTR") String idGenreSTR) {
		Integer idGenre;
		try {
			idGenre = Integer.parseInt(idGenreSTR);
		} catch (NumberFormatException e) {
			return null;
		}
		return songRepository.findByGenre(idGenre);
	}
	
}
