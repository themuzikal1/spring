package com.tekcamp.exercise1.Services;

import java.util.List;

import com.tekcamp.exercise1.Model.User;

public interface UserService {
	List<User> getUsers();

	void createUser(User user);

	User getUser(String firstName);

}
