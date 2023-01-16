package com.masai.webapp.example.service;

import java.util.List;

import com.masai.webapp.example.entity.Mail;

public interface MailService {
	public List<Mail> sendMailByUser(Mail mail);
}
