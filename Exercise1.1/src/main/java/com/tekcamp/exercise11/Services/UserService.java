package com.tekcamp.exercise11.Services;

import com.tekcamp.exercise11.Dto.UserDto;

public interface UserService {
	// List<User> getUsers();

	UserDto getUsers();

	UserDto createUser(UserDto userDto);

	UserDto getUser(String firstName);

	void deleteUser(Long id);

	UserDto updateUser(String firstName, UserDto userDto);

}