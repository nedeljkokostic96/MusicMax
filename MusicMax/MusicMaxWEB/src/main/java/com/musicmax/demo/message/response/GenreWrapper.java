package com.musicmax.demo.message.response;

import model.Genre;

public class GenreWrapper {

	private Genre genre;
	private int numberOfSongs;

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public int getNumberOfSongs() {
		return numberOfSongs;
	}

	public void setNumberOfSongs(int numberOfSongs) {
		this.numberOfSongs = numberOfSongs;
	}

}
