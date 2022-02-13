package com.demo.user.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.user.Model.User;

@Repository
public interface  UserRepository extends JpaRepository<User, Integer> {
	
	public List<User> findAll();
	public User findById(int id);
	public void deleteById(int id);
	

}
