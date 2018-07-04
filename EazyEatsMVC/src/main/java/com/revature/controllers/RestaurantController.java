package com.revature.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.dao.RestaurantDaoImpl;
import com.revature.exceptions.RestaurantNotFoundException;
import com.revature.models.Restaurant;

@Controller
public class RestaurantController {
	
	@Autowired
	RestaurantDaoImpl rdi;
	
	//Call with URL/restaurants
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/restaurants")
	@ResponseBody
	public List<Restaurant> getRestaurants(){
		return rdi.getRestaurants();
	}
	
	//Call with URL/restaurants/{id} (id is the value in the ID column in the 
	//RESTAURANTS table
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/restaurants/{id}")
	@ResponseBody
	public Restaurant getRestaurantById(@PathVariable("id") int id) {
		Restaurant r = rdi.getRestaurantById(id);
		if(r == null) {
			throw new RestaurantNotFoundException();
		}
		return r;
	}
	
	/**
	 * TODO
	 * need to resolve this with the frontend
	 */
	@RequestMapping(value="/restaurants/search", method= RequestMethod.GET)
	public String getSearchPage() {
		return "SearchRestaurant";
	}
	
	/**
	 * TODO
	 * need to resolve this with the frontend
	 */
	@PostMapping("restaurants/search")
	public String getRestaurant(HttpServletRequest req) {
		String restaurantId = req.getParameter("id");
		return "redirect:/restaurants/"+restaurantId;
	}
	
	//call with URL/restaurants/create
	@RequestMapping(value="/restaurants/create", method=RequestMethod.GET)
	public String getCreatePage() {
		return "NewRestaurant";
	}
	
	//call with URL/restaurants/create
	@RequestMapping(value="restaurants/create", method=RequestMethod.POST)
	public String addRestaurant(@RequestParam("id") int id) {
		rdi.createRestaurant(new Restaurant(id));
		return "redirect:/NewRestaurant.html";
		//will need to handle this with the frontend
	}
	

}
