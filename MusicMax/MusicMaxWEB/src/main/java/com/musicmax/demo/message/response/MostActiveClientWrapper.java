package com.musicmax.demo.message.response;

import model.Client;

public class MostActiveClientWrapper {

	private Client client;
	private int numberOfSongs;

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public int getNumberOfSongs() {
		return numberOfSongs;
	}

	public void setNumberOfSongs(int numberOfSongs) {
		this.numberOfSongs = numberOfSongs;
	}

}
