package com.revature.util;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.dao.RestaurantDao;
import com.revature.dao.RestaurantDaoImpl;
import com.revature.dao.UsersDao;
import com.revature.dao.UsersDaoImpl;
import com.revature.models.Restaurant;
import com.revature.models.Users;

//Just testing out the database

public class Driver {
	
	public static void main(String[] args) {
		
		//Session s = HibernateUtil.getSession();
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		
		UsersDao ud = (UsersDao) ac.getBean("usersDaoImpl");
		
		//List<Users> users = ud.getUsers();
		//for(Users user: users) {
		//	System.out.println(user);
		//}
		
		//RestaurantDaoImpl rd1 = new RestaurantDaoImpl();
		RestaurantDao rd1 = (RestaurantDao) ac.getBean("restaurantDaoImpl");
		
		Restaurant r = new Restaurant();
		r.setId(2);
		rd1.createRestaurant(r);
		
		List<Restaurant> rList = rd1.getRestaurants();
		rList.add(r);
		
		Users u1 = new Users("User1", "username1", "password1", "user1@gmail.com", "Normal", rList);
		Users u2 = new Users("User2", "username2", "password2", "user2@gmail.com", "Verified", rList);
		Users u3 = new Users("User3", "username3", "password3", "user3@gmail.com", "Admin", rList);
		//System.out.println(u1.getId());
		
		//u1.setFavorites(rList);
		//u2.setFavorites(rList);
		//u3.setFavorites(rList);
		
		ud.createUser(u1);
		ud.createUser(u2);
		ud.createUser(u3);
		
		List<Users> users = ud.getUsers();
			for(Users user: users) {
				System.out.println(user);
		}
		
		System.out.println("Done");
		//(AbsractApplicationContext) ac.clos
		//s.close();
		
	}

}
