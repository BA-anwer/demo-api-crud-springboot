package com.demo.user.End_Point;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.user.Model.User;
import com.demo.user.Repository.UserRepository;


@RestController
@RequestMapping(path="/v1")
public class UserController {
	@Autowired
	UserRepository userRepository ; 
	
	  @GetMapping("/allUsers")
	  public  List<User> getAllUsers() {
	    return userRepository.findAll();
	  }
	  
	  @PostMapping("/createUser")
	  public ResponseEntity<User> createUser(@RequestBody User user) { 
		return new ResponseEntity<User>(userRepository.save(user),HttpStatus.OK);	  
	  }
	  
	  
	  @DeleteMapping("deleteUser/{id}")
	  public ResponseEntity<String> deleteUser(@PathVariable int id){
		
			  User user = userRepository.findById(id);
			  if (user!=null) {
				  userRepository.deleteById(id);   
				  return new ResponseEntity<String>("User Deleted",HttpStatus.OK);	 
			  }
			  return new ResponseEntity<String>("User not found",HttpStatus.METHOD_FAILURE);  
			  
		
	
		  
	  }
	  
	  
	  
	

}