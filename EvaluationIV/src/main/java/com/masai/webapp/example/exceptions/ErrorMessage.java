package com.masai.webapp.example.exceptions;

import java.time.LocalDateTime;
import java.util.Objects;


public class ErrorMessage {
	
	private LocalDateTime localDateTime;
	private String message;
	private String details;
	
	ErrorMessage(){}

	public ErrorMessage(LocalDateTime localDateTime, String message, String details) {
		super();
		this.localDateTime = localDateTime;
		this.message = message;
		this.details = details;
	}

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "ErrorMessage [localDateTime=" + localDateTime + ", message=" + message + ", details=" + details + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(details, localDateTime, message);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof ErrorMessage))
			return false;
		ErrorMessage other = (ErrorMessage) obj;
		return Objects.equals(details, other.details) && Objects.equals(localDateTime, other.localDateTime)
				&& Objects.equals(message, other.message);
	}
	

}
