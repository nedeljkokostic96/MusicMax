package com.musicmax.demo.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.musicmax.demo.repository.GradeRepository;
import com.musicmax.demo.repository.SongRepository;
import com.musicmax.demo.util.DateConverter;

import model.Client;
import model.Grade;
import model.Song;

@Service
public class GradeService {
	
	@Autowired
	private GradeRepository gradeRepository;
	
	@Autowired
	private SongRepository songRepository;
	
	@Autowired
	private ClientParserService clientParserService;
	
	 @SuppressWarnings("unchecked")
	public Map<String, Object> saveGrade(String json, HttpServletRequest request) {
		
		Map<String, Object> values;
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("status", false);
		
		try {
			values = new ObjectMapper().readValue(json, Map.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return response;
		}
		
		String dateSTR = (String) values.get("date");

		Date date = DateConverter.parseDate(dateSTR);
		
		Song song = songRepository.findById((Integer) values.get("idSong")).get();
		Client client = clientParserService.parseClientFromJWT(request);
		
		Grade newGrade = new Grade();
		newGrade.setGrade((Integer) values.get("grade"));
		newGrade.setDate(date);
		newGrade.setClient(client);
		newGrade.setSong(song);
		Grade saved = gradeRepository.save(newGrade);
		response.put("status", saved != null);
		return response;
	}

	

}
