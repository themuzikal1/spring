package com.tekcamp.exercise1.dao;

import org.springframework.stereotype.Repository;


import com.tekcamp.exercise1.Model.User;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	User findByFirstName(String firstName);

}
