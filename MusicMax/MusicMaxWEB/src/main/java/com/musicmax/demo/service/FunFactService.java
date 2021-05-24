package com.musicmax.demo.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.musicmax.demo.repository.FunFactRepository;

public class FunFactService {

	@Autowired
	private FunFactRepository fuFactRepository;
}
