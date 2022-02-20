package com.demo.user.End_Point;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.user.Model.LoginModel;
import com.demo.user.Model.User;
import com.demo.user.Repository.UserRepository;


@RestController
@RequestMapping(path="/v1")
public class UserController {
	@Autowired
	UserRepository userRepository ; 
	
	
	@PostMapping("/login")
	public ResponseEntity<?> LoginWithEmailAndPassword(
			@RequestBody
 LoginModel login
	 
			) 
					
	{
		

		  User user=userRepository.findByEmail(login.getEmail());
		  if(user==null)
		  {return ResponseEntity.ok("email not found");}
			  if(!user.getPassword().equals(login.getPassword()))
			  { return ResponseEntity.ok("Incorrrect password");}
	
		
		 
       
		  
			  return   ResponseEntity.ok(user);
}
	  
	
	  @GetMapping("/allUsers")
	  public  List<User> getAllUsers() {
	    return userRepository.findAll();
	  }
	  
	  @PostMapping("/createUser")
	  public ResponseEntity<User> createUser(@RequestBody User user) { 
		return new ResponseEntity<User>(userRepository.save(user),HttpStatus.OK);	  
	  }
	  
	  @PutMapping("/updateUser/{id}")
		public User updateUser(
				@PathVariable
				int id,
				@RequestBody
				User user){
			User user1 =userRepository.findById(id); 
			user1.setFirstName(user.getFirstName());
			user1.setLastName(user.getLastName());
		
			user1.setEmail(user.getEmail());
			
			user1.setNumTel(user.getNumTel());
			

			return userRepository.save(user1);
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
