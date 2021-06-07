package com.musicmax.demo.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.musicmax.demo.message.request.ImpressionForm;
import com.musicmax.demo.repository.ImpressionRepository;
import com.musicmax.demo.repository.SongRepository;

import model.Client;
import model.Impression;
import model.Song;

@Service
public class ImpressionService {

	@Autowired
	private ImpressionRepository impressionRepository;

	@Autowired
	private SongRepository songRepository;

	@Autowired
	private ClientParserService clientParserService;

	public ResponseEntity<?> saveNewImpression(ImpressionForm data, HttpServletRequest request) {

		Song song = songRepository.findById(data.getIdSong()).get();
		Client client = clientParserService.parseClientFromJWT(request);

		Impression newImpression = new Impression();
		newImpression.setText(data.getText());
		newImpression.setClient(client);
		newImpression.setSong(song);

		Impression saved = impressionRepository.save(newImpression);

		return saved != null ? ResponseEntity.ok("New impression added!")
				: ResponseEntity.badRequest().body("Adding new impression failed!");
	}

	public ResponseEntity<?> findAllImpressions() {
		return ResponseEntity.ok(impressionRepository.findAll());
	}
}
