package com.masai.webapp.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.webapp.example.entity.Mail;
import com.masai.webapp.example.entity.User;
import com.masai.webapp.example.repository.MailRepository;
import com.masai.webapp.example.repository.UserRepository;

@Service
public class MailServiceImpl implements MailService{
	@Autowired
	private UserRepository ur;
	
	@Autowired
	private MailRepository mr;
	
	@Override
	public List<Mail> sendMailByUser(Mail mail) {
		User user = ur.findById(mail.getUser().getUserId()).get();
		if(user==null) {
			return null;
		}
		mail.setUser(user);
		mr.save(mail);
		return mr.findAll();
	}

}
