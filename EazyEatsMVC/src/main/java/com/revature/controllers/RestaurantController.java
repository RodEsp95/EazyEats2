package com.revature.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
	@GetMapping("/restaurants")
	public List<Restaurant> getRestaurants(){
		return rdi.getRestaurants();
	}
	
	@GetMapping("/restaurants/{id}")
	@ResponseBody
	public Restaurant getRestaurantById(@PathVariable("id") int id) {
		Restaurant r = rdi.getRestaurantById(id);
		if(r == null) {
			throw new RestaurantNotFoundException();
		}
		return r;
	}
	
	@RequestMapping(value="/restaurants/search", method= RequestMethod.GET)
	public String getSearchPage() {
		return "SearchRestaurant";
	}
	
	@PostMapping("restaurants/search")
	public String getRestaurant(HttpServletRequest req) {
		String restaurantId = req.getParameter("id");
		return "redirect:/restaurants/"+restaurantId;
	}
	
	@RequestMapping(value="/restaurants/create", method=RequestMethod.GET)
	public String getCreatePage() {
		return "NewRestaurant";
	}
	
	@RequestMapping(value="restaurants/create", method=RequestMethod.POST)
	public String addRestaurant() {
		rdi.createRestaurant(new Restaurant());
		return "redirect:/NewRestaurant.html";
	}
	

}
