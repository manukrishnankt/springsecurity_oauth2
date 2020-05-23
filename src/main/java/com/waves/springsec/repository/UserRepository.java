package com.waves.springsec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.waves.springsec.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	@Query(value = "SELECT * from users as user WHERE user.username = ?1", nativeQuery = true)
	User getByUserName(String userName);
}
