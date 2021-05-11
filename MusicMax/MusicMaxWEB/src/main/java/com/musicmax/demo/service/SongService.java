package com.musicmax.demo.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.musicmax.demo.repository.ClientRepository;
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
	private ClientRepository clientRepository;

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

	@SuppressWarnings("unchecked")
	public Map<String, Object> saveSong(String json) {
		
		Map<String, Object> values;
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("status", false);
		
		try {
			values = new ObjectMapper().readValue(json, Map.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return response;
		}
		
		String dateSTR = (String) values.get("releasedDate");

		Date releasedDate = DateConverter.parseDate(dateSTR);

		Creator author = creatorRepository.findById((Integer) values.get("idAuthor")).get();
		Creator composer = creatorRepository.findById((Integer) values.get("idComposer")).get();
		Client client = clientRepository.findById((Integer) values.get("idClient")).get();
		Performer perfomer = performerRepository.findById((Integer) values.get("idPerformer")).get();

		Song newSong = new Song();
		newSong.setClient(client);
		newSong.setCreator1(author);
		newSong.setCreator2(composer);
		newSong.setPerformer(perfomer);
		newSong.setReleased(releasedDate);
		newSong.setTitle((String) values.get("titleSong"));
		newSong.setTextSong((String) values.get("textSong"));

		Song saved = songRepository.save(newSong);

		response.put("status", saved != null);
		return response;
	}

}
