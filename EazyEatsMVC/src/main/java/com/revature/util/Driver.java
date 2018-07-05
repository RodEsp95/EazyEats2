package com.revature.util;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.revature.dao.RestaurantDao;
import com.revature.dao.RestaurantDaoImpl;
import com.revature.dao.ReviewDao;
import com.revature.dao.ReviewDaoImpl;
import com.revature.dao.UsersDao;
import com.revature.dao.UsersDaoImpl;
import com.revature.models.Restaurant;
import com.revature.models.Review;
import com.revature.models.Users;

public class Driver {
	
public static void main(String[] args) {
		
		Session s = HibernateUtil.getSession();
		
		
		//ReviewDao rvd1 = new ReviewDaoImpl();
		//List<Review> rList = rvd1.getReviewsByRestaurantId(10);
		//for(Review rev: rList) {
		//	System.out.println(rev);
		//}
		//s.close();
		
		/*
		ReviewDao rvd1 = new ReviewDaoImpl();
		List<Review> rList = rvd1.getReviewsByUserId(2);
		for(Review rev: rList) {
			System.out.println(rev);
		}
		s.close();
		*/
		
		UsersDao ud1 = new UsersDaoImpl();
		
		//Users u1 = ud1.getUserById(1);
		//Users u2 = ud1.getUserById(2);
		//Users u3 = ud1.getUserById(3);
		Users u1 = new Users("User1", "username1", "password1", "user1@gmail.com", "Normal");
		Users u2 = new Users("User2", "username2", "password2", "user2@gmail.com", "Verified");
		Users u3 = new Users("User3", "username3", "password3", "user3@gmail.com", "Admin");
		ud1.createUser(u1);
		ud1.createUser(u2);
		ud1.createUser(u3);
		
		ReviewDao rvd1 = new ReviewDaoImpl();
		
		Review rv1 = new Review("This place is great", 7, false);
		Review rv2 = new Review("This place gave me raw steak!", 1, false);
		Review rv3 = new Review("Screw this joint!", 2, true);
		Review rv4 = new Review("I love the music here", 8, false);
		Review rv5 = new Review("Music sucks now", 1, true);
		
		rvd1.createReview(rv1, 1, 11);
		rvd1.createReview(rv2, 1, 12);
		rvd1.createReview(rv3, 2, 5);
		rvd1.createReview(rv4, 3, 11);
		rvd1.createReview(rv5, 2, 11);
		
		List<Review> reviews = rvd1.getReviews();
		for(Review rev: reviews) {
			System.out.println(rev);
		}
		
		s.close();
		
	}
	
}
