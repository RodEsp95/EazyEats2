package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Restaurant;
import com.revature.util.HibernateUtil;

@Repository
public class RestaurantDaoImpl implements RestaurantDao{
	
	@Autowired
	SessionFactory sf;

	@Override
	@Transactional
	public List<Restaurant> getRestaurants() {
		Session s = sf.getCurrentSession();
		List<Restaurant> restaurants = s.createQuery("from Restaurant").list();
		//s.close();
		return restaurants;
	}

	@Override
	@Transactional
	public Restaurant getRestaurantById(int id) {
		Session s = sf.getCurrentSession();
		Restaurant foundRestaurant = (Restaurant) s.get(Restaurant.class, id);
		//s.close();
		return foundRestaurant;
	}

	@Override
	@Transactional
	public int createRestaurant(Restaurant r) {
		Session s = sf.getCurrentSession();
		//Transaction tx = s.beginTransaction();
		//int created = (int) s.save(r);
		s.save(r);
		//tx.commit();
		//s.close();
		return 0;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void updateRestaurant(Restaurant r) {
		Session s = sf.getCurrentSession();
		//Transaction tx = s.beginTransaction();
		s.update(r);
		//tx.commit();
		//s.close();
		
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void deleteRestaurantById(int id) {
		Session s = sf.getCurrentSession();
		//Transaction tx = s.beginTransaction();
		Restaurant current = (Restaurant) s.get(Restaurant.class, id);
		if(current != null) {
			s.delete(current);
		}
		//tx.commit();
		//s.close();
		
	}
	
	

}
