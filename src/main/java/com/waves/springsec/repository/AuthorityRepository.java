package com.waves.springsec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.waves.springsec.entity.Authority;


@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Integer>{
	
	@Query(value = "SELECT * from authorities as auth WHERE auth.user_id = ?1", nativeQuery = true)
	List<Authority> findByUserId(Integer userId);
}
