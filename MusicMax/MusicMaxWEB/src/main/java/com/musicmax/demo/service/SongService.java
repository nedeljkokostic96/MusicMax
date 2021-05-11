package com.musicmax.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.musicmax.demo.repository.CreatorRepository;
import com.musicmax.demo.repository.PerformerRepository;
import com.musicmax.demo.repository.SongRepository;
import com.musicmax.demo.util.Constants;
import com.musicmax.demo.util.DateConverter;

import model.Creator;
import model.Performer;
import model.Song;

@Service
public class SongService {

	@Autowired
	private SongRepository songRepository;

	@Autowired
	private CreatorRepository creatorRepository;
	
	@Autowired
	private PerformerRepository performerRepository;

	public List<Song> getSongsByGenre(@RequestParam(value = "idGenreSTR") String idGenreSTR) {
		Integer idGenre;
		try {
			idGenre = Integer.parseInt(idGenreSTR);
		} catch (NumberFormatException e) {
			return null;
		}
		return songRepository.findByGenre(idGenre);
	}

	public List<Song> getSongsByYear(@RequestParam(value = "year") String year) {
		Date dateStart = DateConverter
				.parseDate(year + Constants.DATE_SEPARATOR + "01" + Constants.DATE_SEPARATOR + "01");
		Date dateEnd = DateConverter
				.parseDate(year + Constants.DATE_SEPARATOR + "12" + Constants.DATE_SEPARATOR + "31");
		return songRepository.findSongsByYear(dateStart, dateEnd);
	}

	public List<Song> getSongsByComposer(@RequestParam(value = "composerID") String composerID) {
		Creator composer = creatorRepository.findById(Integer.parseInt(composerID)).get();
		return songRepository.findByComposer(composer);
	}

	public List<Song> getSongsByAuthor(@RequestParam(value = "authorID") String authorID) {
		Creator author = creatorRepository.findById(Integer.parseInt(authorID)).get();
		return songRepository.findByAuthor(author);
	}

	public List<Song> getSongsByPerformer(@RequestParam(value = "performerID") String performerID) {
		Performer performer = performerRepository.findById(Integer.parseInt(performerID)).get();
		return songRepository.findByPerformer(performer);
	}

}
