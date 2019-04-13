package com.niit.jobmanagement.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.niit.jobmanagement.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);

	
}
