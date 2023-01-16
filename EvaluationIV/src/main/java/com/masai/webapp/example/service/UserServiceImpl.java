package com.masai.webapp.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.webapp.example.entity.Mail;
import com.masai.webapp.example.entity.User;
import com.masai.webapp.example.repository.MailRepository;
import com.masai.webapp.example.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository ur;
	
	@Autowired
	private MailRepository mr;
	
	
	@Override
	public List<User> addUser(User user) {
		ur.save(user);
		return ur.findAll();
	}

	@Override
	public boolean deleteUser(int userId) {
		ur.deleteById(userId);
		return false;
	}

	@Override
	public User loginUser(String firstname, String password) {
		User user = ur.findByFirstnameAndPassword(firstname, password);
		if(user==null) {
			return user;
		}
		return user;
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Mail> getAllMail(int UserId) {
		User user = ur.findById(UserId).get();
		if(user==null) {
			return null;
		}
		return mr.findByUser(user);
	}

	@Override
	public User getUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
