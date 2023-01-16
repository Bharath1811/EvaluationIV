package com.masai.webapp.example.service;

import java.util.List;
import com.masai.webapp.example.entity.Mail;
import com.masai.webapp.example.entity.User;

public interface UserService {
	
	public List<User> addUser(User user);
	public boolean deleteUser(int userId);
	public User loginUser(String firstname,String password);
	public List<User> getUsers();
	public List<Mail> getAllMail(int UserId);
	public User getUser(int userId);

}
