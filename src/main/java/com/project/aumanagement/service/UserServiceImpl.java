package com.project.aumanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.aumanagement.DAO.UserRepo;
import com.project.aumanagement.model.User;
import com.project.aumanagement.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
    UserRepo userRepository;

	

	@Override
	public User getUser(String email) {
		List<User> result = userRepository.findByEmail(email);
		if(result == null)
			return null;
		return userRepository.findByEmail(email).get(0);
	}
	
	

	
	
}