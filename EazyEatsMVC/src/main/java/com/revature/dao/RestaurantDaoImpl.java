package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.revature.models.Restaurant;
import com.revature.util.HibernateUtil;

@Repository
public class RestaurantDaoImpl implements RestaurantDao{
	
	//@Autowired
	//SessionFactory sf;

	@Override
	public List<Restaurant> getRestaurants() {
		Session s = HibernateUtil.getSession();
		List<Restaurant> restaurants = s.createQuery("from Restaurant").list();
		s.close();
		return restaurants;
	}

	@Override
	public Restaurant getRestaurantById(int id) {
		Session s = HibernateUtil.getSession();
		Restaurant foundRestaurant = (Restaurant) s.get(Restaurant.class, id);
		s.close();
		return foundRestaurant;
	}

	@Override
	public int createRestaurant(Restaurant r) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int created = (int) s.save(r);
		s.save(r);
		tx.commit();
		s.close();
		return 0;
	}

	@Override
	public void updateRestaurant(Restaurant r) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.update(r);
		tx.commit();
		s.close();
		
	}

	@Override
	public void deleteRestaurantById(int id) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		Restaurant current = (Restaurant) s.get(Restaurant.class, id);
		if(current != null) {
			s.delete(current);
		}
		tx.commit();
		s.close();
		
	}
	
	

}
