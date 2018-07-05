package com.revature.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.dao.UsersDaoImpl;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Users;

@Controller
public class UsersController {
	
	@Autowired
	UsersDaoImpl udi;
	
	//call with: URL/users
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/users")
	@ResponseBody
	public List<Users> getUsers(){
		return udi.getUsers();
	}
	
	//call with: URL/users/{id} (id will be the id of in the USERS table column
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/users/{id}")
	@ResponseBody
	public Users getUserById(@PathVariable("id") int id) {
		Users u = udi.getUserById(id);
		if(u == null) {
			throw new UserNotFoundException();
		}
		return u;
	}
	
	//Will probably need to change this, depending on what pages call this
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/users/search", method=RequestMethod.GET)
	public String getSearchPage() {
		return "SearchUser";
	}
	
	
	////Will probably need to change this, depending on what pages call this
	//May need the same method per html page that calls it
	@PostMapping("/users/search")
	public String getUser(HttpServletRequest req) {
		String userId = req.getParameter("id");
		return "redirect:/users/"+ userId;
	}
	
	//call with: URL/users/create
	@RequestMapping(value="/users/create", method=RequestMethod.GET)
	public String getCreatePage() {
		return "NewUser";
	}
	
	//call with: URL/users/create
	//@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/users/create", method=RequestMethod.POST)
	public String addUser(@RequestParam("name") String name, @RequestParam("username") String username,
			@RequestParam("password") String password, @RequestParam("email") String email, @RequestParam("status") String status) {
		udi.createUser(new Users(name, username, password, email, status));
		return "redirect:/NewUser.html";
	}
	
	//PATCH is working progress
	//@RequestMapping(value="users/{id}", method=RequestMethod.PATCH)
	//@PatchMapping("users/{id}")
	//public String updateUserStatus(@PathVariable("id") int id, 
	//		@RequestParam("request") String request) {
	//	Users u = udi.getUserById(id);
	//	u.setStatus(request);
	//	return "redirect:/NewUser.html";
	//}
	
	//@CrossOrigin(origins = "http://localhost:4200")
	//@PostMapping(value="/users/{id}")
	//@RequestMapping(value="/users/{id}", method=RequestMethod.POST)
	//@ResponseBody
	//@PostMapping(value="/users/{id}")
	@RequestMapping(value="/users/{id}", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    public String updateUser(@RequestBody Users user, @PathVariable("id") int id, 
    		@RequestParam("name") String name, @RequestParam("username") String username,
        @RequestParam("password") String password, @RequestParam("email") String email,
        @RequestParam("status") String status) {
		//System.out.println(name);
        //Users user = udi.getUserById(id);
        if(name != null) {
        user.setName(name);
        }
        if(username != null) {
        user.setUsername(username);
        }
        if(password != null) {
        user.setPassword(password);
        }
        if(email != null) {
        user.setEmail(email);
        }
        if(status != null) {
        	user.setStatus(status);
        }
        
        udi.updateUser(user);
        return "redirect:/NewUser.html";
    }
	

}
