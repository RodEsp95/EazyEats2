package com.revature.dao;

import java.util.List;

import com.revature.models.Restaurant;

public interface RestaurantDao {
	
	public List<Restaurant> getRestaurants();
	public Restaurant getRestaurantById(int id);
	public int createRestaurant(Restaurant r);
	public void updateRestaurant(Restaurant r);
	public void deleteRestaurantById(int id);
	
}
