package com.musicmax.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.musicmax.demo.repository.CreatorRepository;

import model.Creator;

@Service
public class CreatorService {
	
	@Autowired
	private CreatorRepository creatorRepository;

	
	public ResponseEntity<?> getAllCreators() {
		List<Creator> creators = creatorRepository.findAll();
		return ResponseEntity.ok(creators);
	}
}
