package com.musicmax.demo.service;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.musicmax.demo.repository.ClientRepository;
import com.musicmax.demo.repository.FunFactRepository;


import model.Client;
import model.FunFact;

@Service
public class FunFactService {

	@Autowired
	private FunFactRepository funFactRepository;

	@Autowired
	private ClientRepository clientRepository;

	@SuppressWarnings("unchecked")
	public Map<String, Object> saveFunFact(String json) {

		Map<String, Object> values;
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("status", false);

		try {
			values = new ObjectMapper().readValue(json, Map.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return response;
		}

		Client administrator = clientRepository.findById((Integer) values.get("idAdministrator")).get();

		FunFact newFunFact = new FunFact();
		newFunFact.setClient(administrator);
		newFunFact.setText((String) values.get("textFunFact"));

		FunFact saved = funFactRepository.save(newFunFact);

		response.put("status", saved != null);
		return response;
	}
}
