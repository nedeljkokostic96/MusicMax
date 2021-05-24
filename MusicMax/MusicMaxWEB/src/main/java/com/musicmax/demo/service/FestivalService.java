package com.musicmax.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.musicmax.demo.repository.FestivalRepository;

import model.Festival;

public class FestivalService {

	@Autowired
	private FestivalRepository festivalRepository;
	
	public List<Festival> getAllFestivals(){
		return festivalRepository.findAll();
	}
}
