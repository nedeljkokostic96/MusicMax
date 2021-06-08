package com.musicmax.demo.message.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ImpressionForm {

	@NotBlank
	private int idSong;

	@NotBlank
	@Size(max = 500)
	private String text;

	public int getIdSong() {
		return idSong;
	}

	public void setIdSong(int idSong) {
		this.idSong = idSong;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
