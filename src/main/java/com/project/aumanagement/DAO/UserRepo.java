package com.project.aumanagement.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.aumanagement.model.User;

@Repository
public interface UserRepo extends JpaRepository<User,Long>{
	
	List<User> findByEmail(String email);
}
