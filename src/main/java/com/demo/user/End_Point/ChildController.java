package com.demo.user.End_Point;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.user.Model.Child;
import com.demo.user.Model.User;
import com.demo.user.Repository.ChildRepository;
import com.demo.user.Repository.UserRepository;

@RestController
@RequestMapping(path="/v1")
public class ChildController {
	
	@Autowired
	ChildRepository childRepository ; 
	@Autowired
	UserRepository userRepository;
	
	  @GetMapping("/allChildsByParent/{idParent}")
	  public  Set<Child> getAllUsers(
			  @PathVariable
			  int idParent
			  ) {
		  User parent=userRepository.findById(idParent);
		  System.out.println(parent.getChildren().size());
		 
	   // return   parent.getChildren();
		  return childRepository.findAllByParent(parent);
	  }
	  
	  @PostMapping("/createChildWithParent/{idParent}")
	  public ResponseEntity<Child> createUser(
			  @PathVariable int idParent,
			  @RequestBody Child child) { 
		  User parent=userRepository.findById(idParent);
		  child.setParent(parent);
		return new ResponseEntity<Child>(childRepository.save(child),HttpStatus.OK);	  
	  }

}
