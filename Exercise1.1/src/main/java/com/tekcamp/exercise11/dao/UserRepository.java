package com.tekcamp.exercise11.dao;



import org.springframework.stereotype.Repository;


import com.tekcamp.exercise11.Model.User;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	User findByFirstName(String firstName);

}