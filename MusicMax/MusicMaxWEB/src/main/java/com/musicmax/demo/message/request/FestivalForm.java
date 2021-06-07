package com.musicmax.demo.message.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class FestivalForm {

	@NotBlank
	@Size(min = 10, max = 10)
	private String dateBegin;
	@NotBlank
	@Size(min = 10, max = 10)
	private String dateEnd;
	@NotBlank
	@Size(max = 1000)
	private String description;

	public String getDateBegin() {
		return dateBegin;
	}

	public void setDateBegin(String dateBegin) {
		this.dateBegin = dateBegin;
	}

	public String getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(String dateEnd) {
		this.dateEnd = dateEnd;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
