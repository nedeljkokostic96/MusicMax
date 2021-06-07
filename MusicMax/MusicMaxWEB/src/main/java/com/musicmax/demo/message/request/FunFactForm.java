package com.musicmax.demo.message.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class FunFactForm {

	@NotBlank
	@Size(max = 1500)
	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
