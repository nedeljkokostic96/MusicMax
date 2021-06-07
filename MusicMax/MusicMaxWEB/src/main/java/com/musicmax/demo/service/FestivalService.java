package com.musicmax.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.musicmax.demo.message.request.FestivalForm;
import com.musicmax.demo.repository.FestivalRepository;
import com.musicmax.demo.util.DateConverter;

import model.Client;
import model.Festival;

@Service
public class FestivalService {

	@Autowired
	private FestivalRepository festivalRepository;

	@Autowired
	private ClientParserService clientParserService;

	public List<Festival> getAllFestivals() {
		return festivalRepository.findAll();
	}

	public ResponseEntity<?> saveFestival(FestivalForm data, HttpServletRequest request) {
		Client client = clientParserService.parseClientFromJWT(request);
		Festival festival = new Festival();
		festival.setClient(client);
		festival.setDateBegin(DateConverter.parseDate(data.getDateBegin()));
		festival.setDateEnd(DateConverter.parseDate(data.getDateEnd()));
		festival.setDescription(data.getDescription());
		Festival saved = festivalRepository.save(festival);
		return saved != null ? ResponseEntity.ok("Added new festival!")
				: ResponseEntity.badRequest().body("Error due adding new festival!");
	}
}
