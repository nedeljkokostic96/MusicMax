package com.musicmax.demo.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musicmax.demo.repository.ClientRepository;
import com.musicmax.demo.security.jwt.JwtProvider;

import model.Client;

@Service
public class ClientParserService {

	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private JwtProvider provider;

	public Client parseClientFromJWT(HttpServletRequest request) {
		
		String jwt = getJwt(request);

		Client client = null;


		String email = provider.getEmailFromJwtToken(jwt);

		client = clientRepository.findByEmail(email).orElse(null);

		return client;
	}
	
	public String getJwt(HttpServletRequest request) {
		String authHeader = request.getHeader("Authorization");

		if (authHeader != null && authHeader.startsWith("Bearer ")) {
			return authHeader.replace("Bearer ", "");
		}

		return null;
	}

}
