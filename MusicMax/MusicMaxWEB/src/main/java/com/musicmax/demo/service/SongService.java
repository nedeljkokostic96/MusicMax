package com.musicmax.demo.service;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.musicmax.demo.message.request.SongForm;
import com.musicmax.demo.repository.CreatorRepository;
import com.musicmax.demo.repository.PerformerRepository;
import com.musicmax.demo.repository.SongRepository;
import com.musicmax.demo.util.Constants;
import com.musicmax.demo.util.DateConverter;

import model.Client;
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

	@Autowired
	private ClientParserService clientParserService;

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

	public ResponseEntity<?> saveSong(SongForm data, HttpServletRequest request) {

		Client client = clientParserService.parseClientFromJWT(request);

		Date releasedDate = DateConverter.parseDate(data.getDate());

		Creator author = creatorRepository.findById(data.getIdAuthor()).get();
		Creator composer = creatorRepository.findById(data.getIdComposer()).get();
		Performer perfomer = performerRepository.findById(data.getIdPerformer()).get();

		Song newSong = new Song();
		newSong.setClient(client);
		newSong.setCreator1(author);
		newSong.setCreator2(composer);
		newSong.setPerformer(perfomer);
		newSong.setReleased(releasedDate);
		newSong.setTitle(data.getTitle());
		newSong.setTextSong(data.getText());

		Song saved = songRepository.save(newSong);

		return saved != null ? ResponseEntity.ok("Added new song!")
				: ResponseEntity.badRequest().body("Adding new song failed!");
	}

}
