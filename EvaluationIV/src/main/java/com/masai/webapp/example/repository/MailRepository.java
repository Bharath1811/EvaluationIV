package com.masai.webapp.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.webapp.example.entity.Mail;
import com.masai.webapp.example.entity.User;

public interface MailRepository extends JpaRepository<Mail, Integer>{
	public List<Mail> findByUser(User user);
}
