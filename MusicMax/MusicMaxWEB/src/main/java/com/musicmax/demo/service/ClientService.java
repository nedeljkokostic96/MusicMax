package com.musicmax.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.musicmax.demo.message.response.MostActiveClientWrapper;
import com.musicmax.demo.repository.ClientRepository;

import model.Client;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;

	public ResponseEntity<?> getMostActiveClient() {
		List<Client> clients = clientRepository.findAll();
		Client mostActive = null;
		int songsNumber = 0;
		for (Client client : clients) {
			if (client.getSongs().size() > songsNumber) {
				songsNumber = client.getSongs().size();
				mostActive = client;
			}
		}
		MostActiveClientWrapper mostActiveClient = new MostActiveClientWrapper();
		mostActiveClient.setClient(mostActive);
		mostActiveClient.setNumberOfSongs(songsNumber);

		return ResponseEntity.ok(mostActiveClient);
	}

}
