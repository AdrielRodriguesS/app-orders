package br.com.adrielrodrigues.apporders.config.validation;

import java.time.LocalDate;

public class MessageExceptionHandler {
	
	private LocalDate timestamp;
	private Integer status;
	private String message;
	
	public MessageExceptionHandler(LocalDate timestamp, Integer status, String message) {
		this.timestamp = timestamp;
		this.status = status;
		this.message = message;
	}

	public LocalDate getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDate timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
