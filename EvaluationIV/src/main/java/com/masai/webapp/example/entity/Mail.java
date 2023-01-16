package com.masai.webapp.example.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "mail")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Mail {
	
	@Id
	private int MailId;
	
	private String message;
	
	private boolean star=false;
	
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getMailId() {
		return MailId;
	}

	public void setMailId(int mailId) {
		MailId = mailId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
	
}
