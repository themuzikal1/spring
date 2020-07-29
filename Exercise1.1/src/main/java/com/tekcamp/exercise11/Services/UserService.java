package com.tekcamp.exercise11.Services;



import java.util.List;

import com.tekcamp.exercise11.Model.User;

public interface UserService {
	List<User> getUsers();

	void createUser(User user);

	User getUser(String firstName);

}