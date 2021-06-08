package com.musicmax.demo.message.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class SongForm {

	@NotBlank
	@Positive
	private int idAuthor;
	@NotBlank
	@Positive
	private int idComposer;
	@NotBlank
	@Positive
	private int idPerformer;
	@NotBlank
	@Size(min = 10, max = 10)
	private String date;
	@NotBlank
	private String title;
	@NotBlank
	private String text;

	public int getIdAuthor() {
		return idAuthor;
	}

	public void setIdAuthor(int idAuthor) {
		this.idAuthor = idAuthor;
	}

	public int getIdComposer() {
		return idComposer;
	}

	public void setIdComposer(int idComposer) {
		this.idComposer = idComposer;
	}

	public int getIdPerformer() {
		return idPerformer;
	}

	public void setIdPerformer(int idPerformer) {
		this.idPerformer = idPerformer;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
