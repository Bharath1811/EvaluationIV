package com.masai.webapp.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.masai.webapp.example.entity.User;

@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, Integer> {
	public User findByFirstnameAndPassword(String firstName, String password);
}
