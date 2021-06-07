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
	
	public List<Festival> getAllFestivals(){
		return festivalRepository.findAll();
	}
	
	public ResponseEntity<String> saveFestival(String json, HttpServletRequest request) {
		
		Map<String, Object> values = new HashMap<String, Object>();
		try {
			values = new ObjectMapper().readValue(json, Map.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		Client client = clientParserService.parseClientFromJWT(request);
		
		Festival festival = new Festival();
		
		festival.setClient(client);
		festival.setDateBegin(DateConverter.parseDate(values.get("dateBegin").toString()));
		festival.setDateEnd(DateConverter.parseDate(values.get("dateEnd").toString()));
		festival.setDescription(values.get("description").toString());
		
		Festival saved = festivalRepository.save(festival);
		
		return new ResponseEntity<String>(saved != null ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
	}
}
