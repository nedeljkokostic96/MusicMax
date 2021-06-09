package com.musicmax.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.musicmax.demo.service.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@GetMapping(value = "/the-most-active-client", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getMostActiveUser() {
		return clientService.getMostActiveClient();
	}
	
}
