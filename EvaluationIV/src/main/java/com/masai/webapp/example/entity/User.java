package com.masai.webapp.example.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="user")
public class User {
	
	@Id
	private int UserId;
	
	private String Email;
	
	@Pattern(regexp = "^[a-zA-Z]+$",message = "{fname.invalid}")
	private String firstname;
	
	@Pattern(regexp = "^[a-zA-Z]+$",message = "{lname.invalid}")
	private String lastName;
	
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\\$%\\^&\\*])(?=.{6,12}$).*$",
			message = "{pass.invalid")
	private String password;
	
	@Size(min = 10,max = 10,message = "{mobile.invalid}")
	private String mobileNumber;
	
	@Past(message = "{DOB.invalid}")
	private LocalDate dateOfBirth;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy="user")
	@JsonIgnore
	private List<Mail> mails=new ArrayList<>();
	
	public User() {}
	
	public User(int userId, String email,
			@Pattern(regexp = "^[a-zA-Z]+$", message = "{fname.invalid}") String firstName,
			@Pattern(regexp = "^[a-zA-Z]+$", message = "{lname.invalid}") String lastName,
			@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\\$%\\^&\\*])(?=.{6,12}$).*$", message = "{pass.invalid") String password,
			@Size(min = 10, max = 10, message = "{mobile.invalid}") String mobileNumber,
			@Past(message = "{DOB.invalid}") LocalDate dateOfBirth, List<Mail> mails) {
		super();
		UserId = userId;
		Email = email;
		this.firstname = firstname;
		this.lastName = lastName;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.dateOfBirth = dateOfBirth;
		this.mails = mails;
	}

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getFirstName() {
		return firstname;
	}

	public void setFirstName(String firstName) {
		this.firstname = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public List<Mail> getMails() {
		return mails;
	}

	public void setMails(List<Mail> mails) {
		this.mails = mails;
	}
	
	
}
