package com.musicmax.demo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.musicmax.demo.repository.ClientRepository;
import com.musicmax.demo.repository.FestivalCommentRepository;
import com.musicmax.demo.repository.FestivalRepository;

import model.Client;
import model.Festival;
import model.FestivalComment;

@Service
public class FestivalCommentService {
	
	@Autowired
	private FestivalCommentRepository festivalCommentRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private FestivalRepository festivalRepository;
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> saveFestivalComment(String json) {

		Map<String, Object> values;
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("status", false);

		try {
			values = new ObjectMapper().readValue(json, Map.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return response;
		}

		Client client = clientRepository.findById((Integer) values.get("idClient")).get();
		Festival festival =festivalRepository.findById((Integer) values.get("idFestival")).get();
		
		FestivalComment newFestivalComment = new FestivalComment();
		newFestivalComment.setClient(client);
		newFestivalComment.setFestival(festival);
		newFestivalComment.setText((String) values.get("textComment"));
		
		FestivalComment saved = festivalCommentRepository.save(newFestivalComment);

		response.put("status", saved != null);
		return response;
	}
}
