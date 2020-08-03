package com.tekcamp.exercise11.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.tekcamp.exercise11.Model.UserEntity;

@Repository

public interface UserRepository extends PagingAndSortingRepository<UserEntity, Long> {
	List<UserEntity> findAll();

	UserEntity findByFirstName(String firstName);

	void deleteById(Long id);

}
