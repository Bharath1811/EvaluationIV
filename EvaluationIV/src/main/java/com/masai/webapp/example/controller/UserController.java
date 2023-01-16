package com.masai.webapp.example.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.webapp.example.entity.Login;
import com.masai.webapp.example.entity.Mail;
import com.masai.webapp.example.entity.User;
import com.masai.webapp.example.service.MailServiceImpl;
import com.masai.webapp.example.service.UserServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/masaimail")
public class UserController {
	
	@Autowired
	private UserServiceImpl ui;
	
	@Autowired
	private MailServiceImpl mi;
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@Valid @RequestBody User user){
		List<User> users = ui.addUser(user);
		return new ResponseEntity<List<User>>(users,HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@Valid @RequestBody Login login){
		String fname = login.getFirstname();
		String password = login.getPassword();
		User user = ui.loginUser(fname, password);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	@GetMapping("/{UserId}/fir")
	public ResponseEntity<List<Mail>> getListEmailByUser(@PathVariable("Userid") int UserId){
		List<Mail> mails = ui.getAllMail(UserId);
		return new ResponseEntity<List<Mail>>(mails,HttpStatus.OK);
	}
	
	@PostMapping("/mail")
	public ResponseEntity<?> sendMail(@Valid @RequestBody Mail mail){
		System.out.println(mail.getUser().getUserId());
		List<Mail> mails = mi.sendMailByUser(mail);
		return new ResponseEntity<List<Mail>>(mails,HttpStatus.CREATED);
	}
	

}
