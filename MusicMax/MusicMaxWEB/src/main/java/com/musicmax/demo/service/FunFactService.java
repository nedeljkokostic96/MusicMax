package com.musicmax.demo.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.musicmax.demo.message.request.FunFactForm;
import com.musicmax.demo.repository.FunFactRepository;

import model.Client;
import model.FunFact;

@Service
public class FunFactService {

	@Autowired
	private FunFactRepository funFactRepository;

	@Autowired
	private ClientParserService clientParserService;

	public ResponseEntity<?> saveFunFact(FunFactForm data, HttpServletRequest request) {

		Client client = clientParserService.parseClientFromJWT(request);
		if (client.getRole().getTitle().equals("user")) {
			return ResponseEntity.badRequest().body("User has no rights to add new fun fact!!!");
		}
		FunFact newFunFact = new FunFact();
		newFunFact.setClient(client);
		newFunFact.setText(data.getText());
		FunFact saved = funFactRepository.save(newFunFact);
		return saved != null ? ResponseEntity.ok("Added new fun fact!")
				: ResponseEntity.badRequest().body("User has no rights to add new fun fact!!!");
	}

	public ResponseEntity<?> getAllFunFacts() {
		List<FunFact> response = funFactRepository.findAll();
		return ResponseEntity.ok(response);
	}
}
