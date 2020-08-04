package com.tekcamp.exercise11.Services.Implementation;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekcamp.exercise11.Dto.UserDto;
import com.tekcamp.exercise11.Model.UserEntity;
import com.tekcamp.exercise11.Services.UserService;
import com.tekcamp.exercise11.dao.UserRepository;

@Service
public class UserServiceImplementation implements UserService {

	@Autowired
	UserRepository userRepository;

	public UserServiceImplementation(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public UserDto getUsers() {

		Iterable<UserEntity> users = userRepository.findAll();
		UserDto returnValue = new UserDto();
		return returnValue;

	}

	@Override
	public UserDto createUser(UserDto userDto) {
		UserEntity newUser = new UserEntity();
		BeanUtils.copyProperties(userDto, newUser);
		UserEntity storedUser = userRepository.save(newUser);
		UserDto returnValue = new UserDto();
		BeanUtils.copyProperties(storedUser, returnValue);
		return returnValue;

	}

	@Override
	public UserDto getUser(String firstName) {
		UserEntity newUser = new UserEntity();
		UserEntity returnValue = userRepository.findByFirstName(firstName);
		UserDto returnValue2 = new UserDto();
		BeanUtils.copyProperties(newUser, returnValue2);
		return returnValue2;
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);

	}

	@Override
	public UserDto updateUser(String firstName, UserDto userDto) {
		UserEntity updatedUser = userRepository.findByFirstName(firstName);
		BeanUtils.copyProperties(userDto, updatedUser);
		UserEntity userEntity = userRepository.save(updatedUser);

		UserDto returnValue = new UserDto();
		BeanUtils.copyProperties(userEntity, returnValue);
		return returnValue;

	}

}
