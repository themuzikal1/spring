package com.tekcamp.exercise11.Controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tekcamp.exercise11.Dto.UserDto;
import com.tekcamp.exercise11.Model.UserEntity;
import com.tekcamp.exercise11.Model.Response.UserResponse;
import com.tekcamp.exercise11.Model.request.UserRequest;
import com.tekcamp.exercise11.Services.UserService;

@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;

	}

	@GetMapping
	public ResponseEntity<List<UserEntity>> getUsers(@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "id") String sortBy) {

		List<UserEntity> list = (List<UserEntity>) userService.getUsers();
		return new ResponseEntity<List<UserEntity>>(list, HttpStatus.OK);

	}

	@GetMapping(path = "/{firstName}")
	public UserDto getUser(@PathVariable String firstName) {
		UserDto returnValue = userService.getUser(firstName);
		return returnValue;

	}

	@PostMapping(path = "/{users}")
	public UserResponse createUser(@RequestBody UserRequest userRequest) {
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userRequest, userDto);

		UserDto createdUser = userService.createUser(userDto);

		UserResponse returnValue = new UserResponse();
		BeanUtils.copyProperties(userRequest, returnValue);

		return returnValue;

	}

	@PutMapping(path = "/{id}")
	public UserResponse updateUser(@PathVariable String firstName, @RequestBody UserRequest userRequest) {
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userRequest, userDto);

		UserDto updatedUser = userService.updateUser(firstName, userDto);

		UserResponse returnValue = new UserResponse();
		BeanUtils.copyProperties(updatedUser, returnValue);
		return returnValue;

	}

	@DeleteMapping(path = "/{id}")
	public void deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);

	}

}
