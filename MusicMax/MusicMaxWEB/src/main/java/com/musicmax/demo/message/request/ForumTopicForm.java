package com.musicmax.demo.message.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ForumTopicForm {

	@NotBlank
	@Size(max = 1000)
	private String topic;

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

}
