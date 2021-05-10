package com.musicmax.demo.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.musicmax.demo.repository.ClientRepository;
import com.musicmax.demo.repository.ImpressionRepository;
import com.musicmax.demo.repository.SongRepository;

import model.Client;
import model.Impression;
import model.Song;

@RestController
@RequestMapping(value = "/impressionController")
public class ImpressionController {

	@Autowired
	private ImpressionRepository impRepository;

	@Autowired
	private SongRepository songRepository;

	@Autowired
	private ClientRepository clientRepository;

	@GetMapping(value = "/impressions")
	public List<Impression> getImpressions() {
		return impRepository.findAll();
	}

	@PostMapping(value = "/saveImpression", consumes = "application/json", produces = "application/json")
	public void saveImpression(@RequestBody String json) throws JsonMappingException, JsonProcessingException {
		Map values = new ObjectMapper().readValue(json, Map.class);
		Song song = songRepository.findById((Integer) values.get("idSong")).get();
		Client client = clientRepository.findById((Integer) values.get("idClient")).get();

		Impression newImpression = new Impression();
		newImpression.setText((String) values.get("textImpression"));
		newImpression.setClient(client);
		newImpression.setSong(song);

		impRepository.save(newImpression);
	}

}


