package com.tekcamp.exercise1.Services.Implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.tekcamp.exercise1.Model.User;
import com.tekcamp.exercise1.Services.UserService;
import com.tekcamp.exercise1.dao.UserRepository;


@Service
public class UserServiceImplementation implements UserService {
	
	private final UserRepository userRepository;
	
	public UserServiceImplementation(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	
	
	@Override
	public List<User> getUsers() {
		
		List<User> returnValue = new ArrayList<User>();
		
		
		returnValue = (List<User>) userRepository.findAll();
		
		
		return returnValue;
	}
	
	@Override
	public void createUser(User user) {
		userRepository.save(user);
		
	}
	
	@Override
	public User getUser(String firstName) {
		User returnValue = userRepository.findByFirstName(firstName);
		
		return returnValue;
	}

}
