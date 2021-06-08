package com.musicmax.demo.message.response;

import model.Song;

public class BestGradedSongWrapper {
	private Song song;
	private double grade;

	public Song getSong() {
		return song;
	}

	public void setSong(Song song) {
		this.song = song;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

}
