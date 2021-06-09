package com.musicmax.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.musicmax.demo.repository.PerformerRepository;

import model.Performer;

@Service
public class PerformerService {

	@Autowired
	private PerformerRepository performerRepository;

	public ResponseEntity<?> getAllPerformers() {
		List<Performer> performers = performerRepository.findAll();
		return ResponseEntity.ok(performers);
	}

}
