package com.musicmax.demo.message.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Value;

public class GradeForm {
	@NotBlank
	@Min(value = 1)
	@Max(value = 5)
	private int grade;
	@NotBlank
	@Positive
	private int idSong;

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getIdSong() {
		return idSong;
	}

	public void setIdSong(int idSong) {
		this.idSong = idSong;
	}

}
