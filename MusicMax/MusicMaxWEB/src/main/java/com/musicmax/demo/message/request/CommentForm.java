package com.musicmax.demo.message.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CommentForm {

	@NotBlank
	@Size(min = 10, max = 10)
	private String date;
	@NotBlank
	private int idForumTopic;
	@NotBlank
	@Size(max = 1500)
	private String textComment;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getIdForumTopic() {
		return idForumTopic;
	}

	public void setIdForumTopic(int idForumTopic) {
		this.idForumTopic = idForumTopic;
	}

	public String getTextComment() {
		return textComment;
	}

	public void setTextComment(String textComment) {
		this.textComment = textComment;
	}
}